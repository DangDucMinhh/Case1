package com.codegym.case1.service.impl;

import com.codegym.case1.model.Food;
import com.codegym.case1.repository.FoodRepository;
import com.codegym.case1.service.IFoodService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private FoodRepository foodRepository;

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food findById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Food food) {
        foodRepository.save(food);
    }

    @Override
    public void remove(Long id) {
        foodRepository.deleteById(id);
    }

    @Override
    public List<Food> findByShopId(Long shopId) {
        return foodRepository.findByShopId(shopId);
    }

    @Override
    public List<Food> findByNameContaining(String searchName) {
        return foodRepository.findByNameContaining(searchName);
    }

    @Override
    public HashMap<String,List<Food>> findSimilarFoodsByFoodId(Long id) {
        List<Food> shop_foods = foodRepository.getSameFoodsByShopId(id);
        List<Long> bestseller_ids = foodRepository.getBestsellerFoodToday();
        List<Food> bestseller = new LinkedList<>();
        int index = 10;
        if(bestseller_ids.size() < 10) index = bestseller_ids.size();
        for (int i = 0 ; i < index;i++){
            bestseller.add(foodRepository.findById(bestseller_ids.get(i)).get());
        }
        HashMap<String,List<Food>> back = new HashMap<>();
        back.put("shop",shop_foods);
        back.put("bestseller",bestseller);
        return back;
    }

    @Override
    public List<Food> getBestSellerFoods() {
        List<Long> bestseller_ids = foodRepository.getBestsellerFoodToday();
        List<Food> bestseller = new LinkedList<>();
        for (int i = 0 ; i < bestseller_ids.size();i++){
            bestseller.add(foodRepository.findById(bestseller_ids.get(i)).get());
        }
        return bestseller;
    }

    @Override
    public List<Food> FilterFood(String address, String coupon, Double start, Double end) {
        return null;
    }

    @Override
    public List<Food> findByShopIdAndNameContaining(Long shopId, String name) {
        return foodRepository.findByShopIdAndNameContaining(shopId, name);
    }



}
