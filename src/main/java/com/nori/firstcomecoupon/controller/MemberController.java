package com.nori.firstcomecoupon.controller;

import com.nori.firstcomecoupon.controller.request.MemberCreateRequest;
import com.nori.firstcomecoupon.domain.Member;
import com.nori.firstcomecoupon.repository.MemberRepository;
import com.nori.firstcomecoupon.service.CouponService;
import com.nori.firstcomecoupon.service.response.CouponIssueResponse;
import com.nori.firstcomecoupon.service.response.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

	private final MemberRepository memberRepository;

	@PostMapping("/new")
	public ApiResponse<MemberCreateResponse> createMember(@RequestBody MemberCreateRequest request) {
		Member member = memberRepository.save(request.toEntity());
		return ApiResponse.ok(MemberCreateResponse.of(member));
	}

}
