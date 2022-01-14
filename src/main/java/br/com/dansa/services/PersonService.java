package br.com.dansa.services;

import br.com.dansa.converter.DozerConverter;
import br.com.dansa.entity.Person;
import br.com.dansa.exception.PersonNotFoundException;
import br.com.dansa.model.PersonModel;
import br.com.dansa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public List<PersonModel> findAll() {
        return DozerConverter.parseListObjects(repository.findAll(), PersonModel.class);
    }

    public PersonModel findById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records for this ID"));
        return DozerConverter.parseObject(entity, PersonModel.class);
    }

    public PersonModel create(PersonModel personModel) {
    	
    	var entity = DozerConverter.parseObject(personModel, Person.class);
    	var vo = DozerConverter.parseObject(repository.save(entity), PersonModel.class);

        return vo;
    }

    public PersonModel update(PersonModel personModel) {

        var entity = repository.findById(personModel.getId())
                .orElseThrow(() -> new PersonNotFoundException("No records for this ID"));
        entity.setFirstName(personModel.getFirstName());
        entity.setLastName(personModel.getLastName());
        entity.setAddress(personModel.getAddress());
        entity.setGender(personModel.getGender());
        
        return DozerConverter.parseObject(repository.save(entity), PersonModel.class);
    }

    public void delete(Long id) {

        Person entity = repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("No records for this ID " + id));

        repository.delete(entity);
    }
}
