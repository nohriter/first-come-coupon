package com.nori.firstcomecoupon.controller.request;

import com.nori.firstcomecoupon.domain.Member;
import lombok.Data;

@Data
public class MemberCreateRequest {

	private String name;

	public Member toEntity() {
		return Member.builder()
			.name(name)
			.build();
	}
}
