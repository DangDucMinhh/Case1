package com.codegym.case1.controller;

import com.codegym.case1.model.Shop;
import com.codegym.case1.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/merchant")
public class ShopController {
    @Autowired
    IShopService shopService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Shop shop) {
           shopService.save(shop);
           return new ResponseEntity<>("SUCCESSED",HttpStatus.OK);
    }
    @GetMapping("/edit/{id}")
    public ResponseEntity<Shop> showEdit(@PathVariable Long id) {
        Shop shop = shopService.findByUserId(id);
        return new ResponseEntity<Shop>(shop,HttpStatus.OK);
    }
    @PostMapping("/edit")
    public ResponseEntity<String> saveMerchant(@RequestBody Shop shop) {
        shop.setId(shopService.findByUserId(shop.getUser().getId()).getId());
        shopService.save(shop);
        return new ResponseEntity<String>("OK",HttpStatus.OK);
    }

    @GetMapping("/shop/{id_merchant}")
    public ResponseEntity<Shop> getShopByMerchantId(@PathVariable Long id_merchant) {
        Shop shop = shopService.findByUserId(id_merchant);
        return new ResponseEntity<Shop>(shop,HttpStatus.OK);
    }

}
