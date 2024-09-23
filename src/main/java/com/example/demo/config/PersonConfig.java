package com.example.demo.config;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PersonConfig {

    @Autowired
    private PersonRepository repository;

    @PostConstruct
    public void setup (){
        final Person person1 = new Person();
        final Person person2 = new Person();

        person1.setId(1L);
        person1.setFirstName("Jorden");
        person1.setLastName("Ross");

        person2.setId(2L);
        person2.setFirstName("Nija");
        person2.setLastName("Ross");

        repository.save(person1);
        repository.save(person2);
    }
}
