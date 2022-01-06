package br.com.dansa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
}
