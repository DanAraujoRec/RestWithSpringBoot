package br.com.dansa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonPropertyOrder({"id", "address", "gender", "firstName", "lastName"})
public class PersonModel implements Serializable {
	private static final long serialVersionUID = 1;
	
	@EqualsAndHashCode.Include
	@JsonIgnore //não mostra na consulta
    private Long id;

    private String firstName;
    @JsonProperty("last_name") //Muda o atributo apresentado
    private String lastName;   
    private String address;  
    private String gender;
}
