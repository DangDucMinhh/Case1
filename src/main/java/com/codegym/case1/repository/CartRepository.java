package com.codegym.case1.repository;

import com.codegym.case1.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {
     Optional<Cart> findCartByUserId(Long id);

     @Query(value = "select f.shop_id from cart_food cf join cart c on c.id = cf.cart_id join food f on f.id = cf.food_id where c.user_id = ?1 group by f.shop_id",nativeQuery = true)
     List<Long> getShopByUserId(Long id);
}
