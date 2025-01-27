package com.nori.firstcomecoupon.service.response;

import com.nori.firstcomecoupon.domain.Coupon;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CouponIssueResponse {

	private Long id;
	private String code;
	private boolean isIssued;
	private Long memberId;

	@Builder
	public CouponIssueResponse(Long id, String code, boolean isIssued, Long memberId) {
		this.id = id;
		this.code = code;
		this.isIssued = isIssued;
		this.memberId = memberId;
	}

	public static CouponIssueResponse of(Coupon coupon) {
		return CouponIssueResponse.builder()
			.id(coupon.getId())
			.code(coupon.getCode())
			.isIssued(coupon.isIssued())
			.memberId(coupon.getMember().getId())
			.build();
	}
}
