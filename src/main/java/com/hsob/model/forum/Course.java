package com.hsob.model.forum;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "course")
@Getter
@Setter
public class Course {
    public String name;
    public String category;

    public Course(String name, String category) {
        this.name = name;
        this.category = category;
    }

}
