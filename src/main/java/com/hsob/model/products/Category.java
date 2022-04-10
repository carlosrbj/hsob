package com.hsob.model.products;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "categories")
@Getter
@Setter
public class Category {
    public String categoryId;
    public String name;
}
