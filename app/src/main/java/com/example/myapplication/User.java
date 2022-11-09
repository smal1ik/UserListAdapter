package com.example.myapplication;

public class User {
    private String name, numberPhone;
    private Sex sex;

    public User(String name, String numberPhone, Sex sex){
        this.name = name;
        this.numberPhone = numberPhone;
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }
}
