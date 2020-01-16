package com.github.rgrantny.SpringDemo.controller;

import com.github.rgrantny.SpringDemo.model.Person;
import com.github.rgrantny.SpringDemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping(value = "/person/")
    public ResponseEntity<?> findAll() {
        Iterable<Person> allPeople = service.findAll();
        ResponseEntity<?> response = new ResponseEntity<>(allPeople, HttpStatus.OK);
        return response;
    }

    @GetMapping(value = "/person/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Person person = service.findById(id);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.OK);
        return response;
    }

    @PostMapping(value = "/person")
    public  ResponseEntity<?> create(@RequestBody Person person) {
        person = service.create(person);
        ResponseEntity<?> response = new ResponseEntity<>(person,HttpStatus.CREATED);
        return response;
    }

    @DeleteMapping(value = "/person/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Person person = service.delete(id);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.OK);
        return response;
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody Person updatePerson) {
        Person person = service.update(id, updatePerson);
        ResponseEntity<?> response = new ResponseEntity<>(person, HttpStatus.OK);
        return response;
    }


}
