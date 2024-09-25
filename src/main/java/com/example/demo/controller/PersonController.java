package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/person-controller")
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    public ResponseEntity<Person> create(Person person) {
        final Person responseBody = service.create(person);
        final ResponseEntity<Person> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.CREATED);
        return  responseEntity;
    }

    @RequestMapping(path = "/read/id", method = RequestMethod.GET)
    public ResponseEntity<Person> readById(@PathVariable Long id) {
        final Person responseBody = service.readById(id);
        final ResponseEntity<Person> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping(path = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> readAll() {
        final List<Person> responseBody = service.readAll();
        final ResponseEntity<List<Person>> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        final Person responseBody = service.update(id, person);
        final ResponseEntity<Person> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        final Person responseBody = service.deleteById(id);
        final ResponseEntity<Person> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }
}
