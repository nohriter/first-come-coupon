package com.nori.firstcomecoupon.controller;

import com.nori.firstcomecoupon.controller.request.MemberCreateRequest;
import com.nori.firstcomecoupon.domain.Member;
import com.nori.firstcomecoupon.repository.MemberRepository;
import com.nori.firstcomecoupon.service.response.MemberCreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

	private MemberRepository memberRepository;

	@PostMapping("/api/members/new")
	public ApiResponse<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest request) {
		Member member = memberRepository.save(request.toEntity());
		return ApiResponse.ok(MemberCreateResponse.of(member));
	}

}
