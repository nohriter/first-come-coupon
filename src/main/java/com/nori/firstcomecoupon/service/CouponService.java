package com.nori.firstcomecoupon.service;

import com.nori.firstcomecoupon.controller.request.CouponCreateRequest;
import com.nori.firstcomecoupon.controller.request.CouponIssueRequest;
import com.nori.firstcomecoupon.domain.Coupon;
import com.nori.firstcomecoupon.domain.Member;
import com.nori.firstcomecoupon.repository.CouponRepository;
import com.nori.firstcomecoupon.repository.MemberRepository;
import com.nori.firstcomecoupon.service.response.CouponIssueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {

	private final CouponRepository couponRepository;
	private final MemberRepository memberRepository;
	private final CouponMaker couponMaker;

	public CouponIssueResponse issueCoupon(CouponIssueRequest request) {
		long availableCouponsCount = couponRepository.countByIsIssuedFalse();
		if(availableCouponsCount <= 0) {
			throw new IllegalStateException("모든 쿠폰이 소진 됐습니다.");
		}

		Coupon coupon = couponRepository.findFirstByIsIssuedFalse()
			.orElseThrow(() -> new RuntimeException("발급 가능한 쿠폰이 없습니다."));

		Member member = memberRepository.findById(request.getMemberId())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

		coupon.issue();
		coupon.assignToMember(member);
		Coupon issuedCoupon = couponRepository.save(coupon);

		return CouponIssueResponse.of(issuedCoupon);
	}

	public Long createCoupon(CouponCreateRequest request) {
		if (request.getCreateCouponCount() <= 0) {
			throw new IllegalArgumentException("쿠폰 생성 수량은 0보다 커야 합니다.");
		}

		couponMaker.createCoupons(request.getCreateCouponCount());
		return couponRepository.countByIsIssuedFalse();
	}
}
