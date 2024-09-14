package com.codegym.case1.service;

import com.codegym.case1.model.Cart;
import com.codegym.case1.model.Food;

import java.util.HashMap;
import java.util.List;

public interface ICartService extends IGenerateService<Cart>{

      Cart findByUserId(Long id);

      void removeAllById(Long id);

      List<Food> getFoodsByCartAndShop(Long cart_id,Long shop_id);

      HashMap<String,List> getCartByUserId(Long id);


      List<Long> getShopList(Long id);
}
