package br.com.dansa.services;

import br.com.dansa.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Dan");
        person.setLastName("Araújo");
        person.setAddress("Recife - Pernambuco - Brasil");
        person.setGender("Male");
        return person;
    }

    public Person create(Person person) {
        return person;
    }

    public Person update(Person person) {
        return person;
    }

    public void delete(String id) {

    }

    public Person mockPerson(int i) {
        return Person.builder()
                .id(counter.incrementAndGet())
                .firstName("Dan" + i)
                .lastName("Araújo" + i)
                .address("Recife - Pernambuco - Brasil" + i)
                .gender("Male" + i)
                .build();
    }
}
