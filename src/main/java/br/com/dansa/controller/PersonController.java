package br.com.dansa.controller;

import br.com.dansa.entity.Person;
import br.com.dansa.model.PersonModel;
import br.com.dansa.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(produces = {"application/json", "application/xml", "application/x-yaml"})
    public List<PersonModel> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public PersonModel findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
    			 consumes =  {"application/json", "application/xml", "application/x-yaml"})
    public PersonModel create(@RequestBody PersonModel person) {

        return personService.create(person);
    }

    @PutMapping(produces = {"application/json", "application/xml", "application/x-yaml"},
			 consumes =  {"application/json", "application/xml", "application/x-yaml"})
    public PersonModel update(@RequestBody PersonModel person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
