package com.example.application;

import com.example.domain.Person;
import com.example.testdatabuilder.PersonTestData;
import com.example.testdatabuilder.TestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FindPersonsInCityUseCaseTest {

    @Autowired
    private TestDataBuilder testDataBuilder;

    @Autowired
    private FindPersonsInCityUseCase findPersonsInCityUseCase;

    @Test
    void twoPersonsInOneCity_findByCity_twoPersonsFound() {
        PersonTestData frieda = testDataBuilder.personTestDataBuilder()
                .withRandomAhvNumber()
                .withName("Frieda")
                .livesInCity("Zürich")
                .save();
        PersonTestData bob = testDataBuilder.personTestDataBuilder()
                .withRandomAhvNumber()
                .withName("Bob")
                .livesInCity("Zürich")
                .save();

        List<Person> personsThatLiveInZurich = findPersonsInCityUseCase.invoke("Zürich");

        assertThat(personsThatLiveInZurich).extracting(Person::getAhvNumber).containsExactlyInAnyOrder(frieda.getAhvNumber(), bob.getAhvNumber());
    }
}