package br.com.dansa.services;

import br.com.dansa.entity.Person;
import br.com.dansa.exception.PersonNotFoundException;
import br.com.dansa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records for this ID"));
    }

    public Person create(Person person) {

        return repository.save(person);
    }

    public Person update(Person person) {

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new PersonNotFoundException("No records for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(entity);
    }

    public void delete(Long id) {

        Person entity = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records for this ID " + id));

        repository.delete(entity);
    }
}
