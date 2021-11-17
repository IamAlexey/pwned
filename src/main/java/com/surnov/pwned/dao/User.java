package com.surnov.pwned.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "my_user")
public class User {
    @Id
    private long id;

    private String name;

    private int age;
}
