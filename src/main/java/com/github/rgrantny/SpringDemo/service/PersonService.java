package com.github.rgrantny.SpringDemo.service;

import com.github.rgrantny.SpringDemo.model.Person;
import com.github.rgrantny.SpringDemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll()
    {
        return personRepository.findAll();
    }

    public Person create (Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    public Person delete(Long id) {
    Person personToBeDeleted = this.findById(id);
    personRepository.delete(personToBeDeleted);
    return personToBeDeleted;
    }

    public Person update(Long id, Person newPerson) {
        Person updatePerson = personRepository.findById(id).get();
        updatePerson.toString();
        updatePerson.setFirstName(newPerson.getFirstName());
        updatePerson.setLastName(newPerson.getLastName());
        personRepository.save(updatePerson);

        return updatePerson;
    }
}
