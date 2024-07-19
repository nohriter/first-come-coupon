package com.nori.firstcomecoupon.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "coupon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon {

	@Id
	@Column(name = "coupon_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;

	private boolean isIssued = false;

	private boolean isUsed = false;

	@ManyToOne
	private Member member;

	public void issue() {
		this.isIssued = true;
	}

	public void assignToMember(Member member) {
		this.member = member;
	}

	public void use() {
		this.isUsed = true;
	}

	@Builder
	private Coupon(String code) {
		this.code = code;
	}

	public static Coupon of(String code) {
		return Coupon.builder()
			.code(code)
			.build();
	}

}
