package com.nori.firstcomecoupon.service.response;

import com.nori.firstcomecoupon.domain.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CouponIssueResponse {

	private Long id;
	private String code;
	private boolean isIssued;
	private Long userId;

	@Builder
	public CouponIssueResponse(Long id, String code, boolean isIssued, Long userId) {
		this.id = id;
		this.code = code;
		this.isIssued = isIssued;
		this.userId = userId;
	}

	public static CouponIssueResponse of(Coupon coupon) {
		return CouponIssueResponse.builder()
			.id(coupon.getId())
			.code(coupon.getCode())
			.isIssued(coupon.isIssued())
			.userId(coupon.getMember().getId())
			.build();
	}
}
