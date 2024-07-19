package com.nori.firstcomecoupon.repository;

import com.nori.firstcomecoupon.domain.Coupon;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

	Optional<Coupon> findFirstByIsIssuedFalse();
	Long countByIsIssuedFalse();
}
