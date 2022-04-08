package com.example.domain;

import java.util.List;

public interface PersonRepository {

    List<Person> findPersonsThatLiveInCity(String cityName);
}
