package com.nori.firstcomecoupon.service.response;

import com.nori.firstcomecoupon.domain.Coupon;
import lombok.Builder;
import lombok.Data;

@Data
public class CouponUseResponse {

	private Long id;
	private String code;
	private boolean isUsed;
	private Long memberId;

	@Builder
	private CouponUseResponse(Long id, String code, boolean isUsed, Long memberId) {
		this.id = id;
		this.code = code;
		this.isUsed = isUsed;
		this.memberId = memberId;
	}

	public static CouponUseResponse of(Coupon coupon) {
		return CouponUseResponse.builder()
			.id(coupon.getId())
			.code(coupon.getCode())
			.isUsed(coupon.isUsed())
			.memberId(coupon.getMember().getId())
			.build();
	}
}
