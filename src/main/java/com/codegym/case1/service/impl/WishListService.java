package com.codegym.case1.service.impl;

import com.codegym.case1.model.Food;
import com.codegym.case1.model.User;
import com.codegym.case1.model.WishList;
import com.codegym.case1.repository.WishListRepository;
import com.codegym.case1.service.IWishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class WishListService implements IWishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Override
    public WishList findByUserId(Long id) {
        Optional<WishList> wishList = wishListRepository.findWishListByUserId(id);
        if (wishList.isEmpty()) {
            WishList newWishList = new WishList();
            User user = new User();
            user.setId(id);
            Set<Food> foods = new HashSet<>();
            newWishList.setUser(user);
            newWishList.setFood(foods);
            return newWishList;
        }
        return wishList.get();
    }

    @Override
    public boolean checkStatus(Long user, Long food) {
        Optional<WishList> optional = wishListRepository.findWishListByUserId(user);
        if(optional.isPresent()){
            WishList wishList = optional.get();
            Set<Food> foods = wishList.getFood();
            for(Food food1: foods){
                if(food1.getId().equals(food))
                    return true;
            }
        }
        return false;
    }

    @Override
    public List<WishList> findAll() {
        return null;
    }

    @Override
    public WishList findById(Long id) {
        return wishListRepository.findById(id).get();
    }

    @Override
    public void save(WishList wishList) {
        wishListRepository.save(wishList);
    }

    @Override
    public void remove(Long id) {

    }

}