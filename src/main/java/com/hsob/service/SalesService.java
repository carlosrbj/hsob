package com.hsob.service;

import com.hsob.model.sales.Sales;
import com.hsob.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author carlos
 */

@Service
public class SalesService {
    @Autowired
    SalesRepository salesRepository;
    public String getSalesById(String id) {
        Optional<Sales> saleObject = salesRepository.findById(id);
        Sales k = saleObject.get();

        ArrayList<Sales.Item> items = k.getItems();
        int quantity = 0;
        for (int i = 0; i < items.size(); i++) {
            Sales.Item l = items.get(i);
            quantity =  l.getQuantity();


        }

        return String.valueOf(quantity);
    }
}
