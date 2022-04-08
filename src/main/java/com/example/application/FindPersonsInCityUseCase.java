package com.example.application;

import com.example.domain.Person;
import com.example.domain.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPersonsInCityUseCase {

    private final PersonRepository personRepository;

    public List<Person> invoke(String cityName) {
        return personRepository.findPersonsThatLiveInCity(cityName);
    }
}
