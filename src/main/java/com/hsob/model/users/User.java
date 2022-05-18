package com.hsob.model.users;


import com.hsob.security.Profile;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author carlos
 */

@Document(collection = "user")
@Getter
@Setter
public class User implements UserDetails{
    private @MongoId ObjectId id;
    private String username;
    private String name;
    private String sex;
    private String gender;
    private String genderIdentity;
    private String socialName;
    private String document;
    private String documentType;
    private String email;
    private String salt;
    private String digest;
    private Address address;
    private String phone;
    private ArrayList<Abilitys> abilitys;
    private String photo;
    @DBRef(db= "profile")
    private List<Profile> profile = new ArrayList<>();

    @Override /*coleção de perfis de acesso*/
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.profile;
    }

    @Override
    public String getPassword() {
        return this.digest;
    }

    @Override
    public String getUsername(){
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
