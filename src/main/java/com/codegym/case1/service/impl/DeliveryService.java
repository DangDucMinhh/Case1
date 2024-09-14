package com.codegym.case1.service.impl;
import com.codegym.case1.model.Delivery;
import com.codegym.case1.repository.DeliveryRepository;
import com.codegym.case1.repository.FoodRepository;
import com.codegym.case1.service.IDeliveryService;
import com.codegym.case1.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeliveryService implements IDeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery findById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Delivery delivery) {
             deliveryRepository.save(delivery);
    }

    @Override
    public void remove(Long id) {
            deliveryRepository.deleteById(id);
    }
}
