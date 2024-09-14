package com.codegym.case1.service;

import com.codegym.case1.model.Shop;

public interface IShopService extends IGenerateService<Shop>{
    Shop findByUserId(Long id);

}
