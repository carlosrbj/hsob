package com.hsob.model.photos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
@Getter
@Setter
public class Photo {
    public String url;
    public String description;
}
