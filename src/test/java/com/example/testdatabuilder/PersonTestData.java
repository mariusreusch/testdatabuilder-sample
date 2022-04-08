package com.example.testdatabuilder;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class PersonTestData {

    private String ahvNumber;
    private String name;
    private String city;
}
