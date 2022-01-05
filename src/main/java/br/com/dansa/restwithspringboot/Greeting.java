package br.com.dansa.restwithspringboot;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Greeting {

    private final Long id;
    private final String content;
}
