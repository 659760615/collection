package com.zlys.collection.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private Integer uid;

    private String username;

    private String password;

    private Date createdTIme;

    private Set<Role> roles = new HashSet<>();

}
