package com.hsob.service;

import com.hsob.Utils;
import com.hsob.model.products.Product;
import org.junit.jupiter.api.Test;

public class SalesServiceTest {
    ProductsService productsService = new ProductsService();
    Product product= new Product();

    @Test
    void checkExistingProductId(){
        product.setProductId(Utils.generateAlphaNumericString(6));


    }
}
