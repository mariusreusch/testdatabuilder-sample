package com.example.domain;

public class Person {

    private final String ahvNumber;
    private final String name;
    private final String city;

    public Person(String ahvNumber, String name, String city) {
        this.ahvNumber = ahvNumber;
        this.name = name;
        this.city = city;
    }

    public String getAhvNumber() {
        return ahvNumber;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
