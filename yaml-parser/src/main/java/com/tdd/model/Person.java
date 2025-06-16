package com.tdd.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private ArrayList<Foe> foes;
}
