package br.com.dansa.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PersonModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
    private Long id;
    private String firstName;    
    private String lastName;   
    private String address;  
    private String gender;
}
