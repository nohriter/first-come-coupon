package com.nori.firstcomecoupon.controller;

import com.nori.firstcomecoupon.controller.request.CouponCreateRequest;
import com.nori.firstcomecoupon.controller.request.CouponIssueRequest;
import com.nori.firstcomecoupon.service.response.CouponIssueResponse;
import com.nori.firstcomecoupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CouponController {

	private final CouponService couponService;

	@PostMapping("/api/coupons/new")
	public ApiResponse<Long> createCoupon(@RequestBody CouponCreateRequest createCouponCount) {
		Long createdCouponCount = couponService.createCoupon(createCouponCount);
		return ApiResponse.ok(createdCouponCount);
	}

	@PostMapping("/api/coupons/issue")
	public ApiResponse<CouponIssueResponse> issueCoupon(@RequestBody CouponIssueRequest request) {
		log.info("request: {}", request);
		CouponIssueResponse response = couponService.issueCoupon(request);
		return ApiResponse.ok(response);
	}


}
