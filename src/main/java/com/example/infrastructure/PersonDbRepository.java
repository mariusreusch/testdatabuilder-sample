package com.example.infrastructure;

import com.example.domain.Person;
import com.example.domain.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonDbRepository implements PersonRepository {

    private final PersonJpaRepository personJpaRepository;

    @Override
    public List<Person> findPersonsThatLiveInCity(String cityName) {
        return personJpaRepository.findByCity(cityName).stream()
                .map(dbEntity -> new Person(dbEntity.getAhvNumber(), dbEntity.getName(), dbEntity.getCity()))
                .toList();
    }
}
