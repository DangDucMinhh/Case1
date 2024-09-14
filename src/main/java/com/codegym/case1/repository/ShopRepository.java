package com.codegym.case1.repository;

import com.codegym.case1.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Long> {
    Shop findShopByUserId(Long id);

}
