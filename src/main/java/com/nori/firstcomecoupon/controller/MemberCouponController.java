package com.nori.firstcomecoupon.controller;

import com.nori.firstcomecoupon.service.CouponService;
import com.nori.firstcomecoupon.service.response.CouponIssueResponse;
import com.nori.firstcomecoupon.service.response.CouponUseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberCouponController {

	private final CouponService couponService;

	@PostMapping("/{memberId}/coupons/new")
	public ApiResponse<CouponIssueResponse> issueCoupon(@PathVariable Long memberId) {
		CouponIssueResponse response = couponService.issueCoupon(memberId);
		return ApiResponse.ok(response);
	}

	@PostMapping("/{memberId}/coupons/{couponCode}/use")
	public ApiResponse<CouponUseResponse> useCoupon(@PathVariable Long memberId, @PathVariable String couponCode) {
		CouponUseResponse response = couponService.useCoupon(memberId, couponCode);
		return ApiResponse.ok(response);
	}

}
