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

    @GetMapping()
    public List<PersonModel> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonModel findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping()
    public PersonModel create(@RequestBody PersonModel person) {

        return personService.create(person);
    }

    @PutMapping()
    public PersonModel update(@RequestBody PersonModel person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok().build();
    }
}
