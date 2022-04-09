package com.hsob.model.sales;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author carlos
 */

@Document(collection = "sales")
@Getter
@Setter
public class Sales {

    public Date saleDate;
    public ArrayList<Item> items;
    public String storeLocation;
    public Customer customer;
    public boolean couponUsed;
    public String purchaseMethod;

    @Getter
    @Setter
    public class Item{
        public String name;
        public ArrayList<String> tags;
        public double price;
        public int quantity;
    }

    @Getter
    @Setter
    public class Customer{
        public String gender;
        public int age;
        public String email;
        public int satisfaction;
    }
}
