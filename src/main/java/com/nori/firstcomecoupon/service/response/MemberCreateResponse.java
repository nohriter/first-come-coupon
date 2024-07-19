package com.nori.firstcomecoupon.service.response;

import com.nori.firstcomecoupon.domain.Member;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberCreateResponse {

	private Long memberId;

	@Builder
	private MemberCreateResponse(Long memberId) {
		this.memberId = memberId;
	}

	public static MemberCreateResponse of(Member member) {
		return MemberCreateResponse.builder()
			.memberId(member.getId())
			.build();
	}
}
