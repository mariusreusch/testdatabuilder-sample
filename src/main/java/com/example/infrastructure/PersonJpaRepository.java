package com.example.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonJpaRepository extends JpaRepository<PersonDbEntity, Long> {

    List<PersonDbEntity> findByCity(String city);
}
