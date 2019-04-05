package io.zipcoder.crudapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @PostMapping(path = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }

    @PutMapping(path = "/people/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, Person person){
        return new ResponseEntity<>(repository.save(person), HttpStatus.CREATED);
    }

    @GetMapping(path = "/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){
        return new ResponseEntity<>(repository.findById(id).get(), HttpStatus.CREATED);
    }

    @GetMapping(path = "/people")
    public List<Person> getAll(){
        return (List<Person>) repository.findAll();

    }

    @DeleteMapping(path = "/people/{id}")
    public void delete(@PathVariable Long id){
        repository.delete(repository.findById(id).get());

    }
}
