package com.codegym.case1.service;

import com.codegym.case1.model.WishList;

public interface IWishListService extends IGenerateService<WishList>{

    WishList findByUserId(Long id);

    void save(WishList wishList);

    boolean checkStatus(Long user,Long food);

}