package com.nori.firstcomecoupon.service;

import com.nori.firstcomecoupon.domain.Coupon;
import com.nori.firstcomecoupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponMaker {

	private final CouponRepository couponRepository;

	// 쿠폰 코드 생성 메서드
	public String generateCouponCode() {
		// 고유한 쿠폰 코드를 생성하는 로직 (예: UUID 사용)
		return "COUPON-" + java.util.UUID.randomUUID().toString();
	}

	// 쿠폰 생성 및 저장 메서드
	public void createCoupon() {
		String code = generateCouponCode();
		Coupon coupon = Coupon.of(code); // 정적 팩토리 메서드 사용
		couponRepository.save(coupon);
	}

	// 여러 개의 쿠폰 생성 및 저장 메서드
	public void createCoupons(Integer numberOfCoupons) {
		for (int i = 0; i < numberOfCoupons; i++) {
			createCoupon();
		}
	}

}
