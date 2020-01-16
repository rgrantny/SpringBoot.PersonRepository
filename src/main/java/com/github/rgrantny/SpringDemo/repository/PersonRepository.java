package com.github.rgrantny.SpringDemo.repository;

import com.github.rgrantny.SpringDemo.model.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
}
