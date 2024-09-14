package com.codegym.case1.repository;

import com.codegym.case1.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    Optional<WishList> findWishListByUserId(Long id);

}