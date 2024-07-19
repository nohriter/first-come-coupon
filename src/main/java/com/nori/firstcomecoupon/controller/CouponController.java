package com.nori.firstcomecoupon.controller;

import com.nori.firstcomecoupon.controller.request.CouponCreateRequest;
import com.nori.firstcomecoupon.service.CouponService;
import com.nori.firstcomecoupon.service.response.CouponIssueResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coupons")
public class CouponController {

	private final CouponService couponService;

	@PostMapping("/new")
	public ApiResponse<Long> createCoupon(@RequestBody CouponCreateRequest createCouponCount) {
		Long createdCouponCount = couponService.createCoupon(createCouponCount);
		return ApiResponse.ok(createdCouponCount);
	}

}
