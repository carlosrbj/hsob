package com.hsob.model.clients;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "client")
public class Client {
    private String name;
    private String socialName;
    private String sex;
    private String gender;
    private String genderIdentity;

    private String document;
    private String documentType;
    private String phone;
    private String email;
    private String birthday;

}
