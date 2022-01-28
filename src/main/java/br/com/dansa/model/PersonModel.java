package br.com.dansa.model;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonModel extends RepresentationModel<PersonModel> implements Serializable {
	private static final long serialVersionUID = 1L;
		
    private Long id;
    private String firstName;    
    private String lastName;   
    private String address;  
    private String gender;
}
