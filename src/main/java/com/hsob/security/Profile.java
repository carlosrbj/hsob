package com.hsob.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document(collection = "profile")
@Getter
@Setter
@EntityScan
public class Profile implements GrantedAuthority {
    @Id
    public String id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
