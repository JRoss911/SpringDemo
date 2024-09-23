package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }
    public Person create (Person personToPersist){
        return repository.save(personToPersist);
    }

   public Person readById(Long id){
        return repository.findById(id).get();
   }

   public List<Person> readAll(){
        final Iterable<Person> allRecords = repository.findAll();
        final List<Person> personList = new ArrayList<>();
        allRecords.forEach(personList::add);
        return personList;
   }

   public Person update(Long id, Person newPersonData){
        final Person newPersonInDatabase = this.readById(id);
        newPersonInDatabase.setId(newPersonData.getId());
        newPersonInDatabase.setFirstName(newPersonData.getFirstName());
        newPersonInDatabase.setLastName(newPersonData.getLastName());
        return repository.save(newPersonInDatabase);
   }
   public Person deleteById(Long id){
        final Person personToBeDeleted = this.readById(id);
        repository.delete(personToBeDeleted);
        return personToBeDeleted;
   }
}
