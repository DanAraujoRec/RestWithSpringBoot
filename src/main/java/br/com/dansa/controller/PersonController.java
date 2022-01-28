package br.com.dansa.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

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

import br.com.dansa.entity.Person;
import br.com.dansa.model.PersonModel;
import br.com.dansa.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping()
	public List<PersonModel> findAll() {
		
		List<PersonModel> personModels = personService.findAll();
		personModels.stream()
		.forEach(person -> person.add(
				linkTo(methodOn(PersonController.class).findById(person.getId())).withSelfRel()));	
		return personModels;
	}

	@GetMapping("/{id}")
	public PersonModel findById(@PathVariable Long id) {
		PersonModel personModel = personService.findById(id);
		personModel.add(linkTo(methodOn(PersonController.class).findById(personModel.getId())).withSelfRel());

		/*
		 * (linkTo(PersonController.class) //.slash(personModel.getId()) adiciona uma
		 * barra .withSelfRel() );
		 */
		return personModel;
	}

	@PostMapping()
	public PersonModel create(@RequestBody PersonModel person) {

		PersonModel personModel = personService.create(person);

		personModel.add(linkTo(methodOn(PersonController.class).findById(personModel.getId())).withSelfRel());

		return personModel;
	}

	@PutMapping()
	public PersonModel update(@RequestBody PersonModel person) {

		PersonModel personModel = personService.update(person);

		personModel.add(linkTo(methodOn(PersonController.class).findById(personModel.getId())).withSelfRel());

		return personModel;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Person> delete(@PathVariable Long id) {

		personService.delete(id);
		return ResponseEntity.ok().build();
	}
}
