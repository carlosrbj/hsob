package com.hsob.model.users;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.ArrayList;

/**
 * @author carlos
 */

@Document(collection = "user")
@Getter
@Setter
public class User {
    private String username;
    private String name;
    private String sex;
    private String gender;
    public String genderIdentity;
    public String socialName;
    public String document;
    public String documentType;
    public String email;
    public String salt;
    public String digest;
    public Address address;
    public String phone;
    public ArrayList<Abilitys> abilitys;
    public String photo;

}
