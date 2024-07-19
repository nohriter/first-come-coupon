package com.nori.firstcomecoupon.controller.request;

import com.nori.firstcomecoupon.domain.Member;
import lombok.Data;

@Data
public class MemberCreateRequest {

	private Long memberId;

	public Member toEntity() {
		return Member.builder()
			.id(this.memberId)
			.build();
	}
}
