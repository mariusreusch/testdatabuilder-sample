package com.example.infrastructure;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PersonDbEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ahvNumber;
    private String name;
    private String city;

    public PersonDbEntity(String ahvNumber, String name, String city) {
        this.ahvNumber = ahvNumber;
        this.name = name;
        this.city = city;
    }
}
