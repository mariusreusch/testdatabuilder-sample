package com.example.testdatabuilder;

import com.example.infrastructure.PersonDbEntity;
import com.example.infrastructure.PersonJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class PersonTestDataBuilder {

    private final PersonJpaRepository personRepository;
    private final PersonTestData personTestData = new PersonTestData();

    public PersonTestDataBuilder withRandomAhvNumber() {
        this.personTestData.setAhvNumber(UUID.randomUUID().toString());
        return this;
    }
    public PersonTestDataBuilder withName(String name) {
        this.personTestData.setName(name);
        return this;
    }

    public PersonTestDataBuilder livesInCity(String city) {
        this.personTestData.setCity(city);
        return this;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PersonTestData save() {
        personRepository.save(new PersonDbEntity(personTestData.getAhvNumber(), personTestData.getName(), personTestData.getCity()));
        return personTestData;
    }
}
