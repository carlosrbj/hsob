package com.hsob.model.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "products")
@Getter
@Setter
public class Product {
    public String name;
    public String productId;
    public String type;
    public String unit;
    public double quantity;
    public double purchasePrice;
    public double salePrice;
    public long creationDate;
    public ArrayList<Category> categories;

}
