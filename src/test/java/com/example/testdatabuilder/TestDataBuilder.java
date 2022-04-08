package com.example.testdatabuilder;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataBuilder {

    private final ObjectFactory<PersonTestDataBuilder> swisscomLoginSubjectTestDataBuilderObjectFactory;

    public PersonTestDataBuilder personTestDataBuilder() {
        return swisscomLoginSubjectTestDataBuilderObjectFactory.getObject();
    }

}
