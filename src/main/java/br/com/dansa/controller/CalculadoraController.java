package br.com.dansa.controller;

import br.com.dansa.exception.UnsuportedMathOperationException;
import br.com.dansa.validate.NumberConvert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    @GetMapping(value = "/sum/{numberOne}/{numbeTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numbeTwo") String numbeTwo) {

        if(!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numbeTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return NumberConvert.convertToDouble(numberOne) + NumberConvert.convertToDouble(numbeTwo);
    }

    @GetMapping(value = "/subtraction/{numberOne}/{numbeTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numbeTwo") String numbeTwo) {

        if(!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numbeTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return NumberConvert.convertToDouble(numberOne) - NumberConvert.convertToDouble(numbeTwo);
    }

    @GetMapping(value = "/division/{numberOne}/{numbeTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numbeTwo") String numbeTwo) {

        if(!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numbeTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return NumberConvert.convertToDouble(numberOne) / NumberConvert.convertToDouble(numbeTwo);
    }

    @GetMapping(value = "/multiplication/{numberOne}/{numbeTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numbeTwo") String numbeTwo) {

        if(!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numbeTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return NumberConvert.convertToDouble(numberOne) * NumberConvert.convertToDouble(numbeTwo);
    }

    @GetMapping(value = "/average/{numberOne}/{numbeTwo}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numbeTwo") String numbeTwo) {

        if(!NumberConvert.isNumeric(numberOne) || !NumberConvert.isNumeric(numbeTwo)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return (NumberConvert.convertToDouble(numberOne) + NumberConvert.convertToDouble(numbeTwo)) / 2;
    }

    @GetMapping(value = "/square/{numberOne}")
    public Double square(@PathVariable("numberOne") String numberOne) {

        if(!NumberConvert.isNumeric(numberOne)) {
            throw new UnsuportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(NumberConvert.convertToDouble(numberOne));
    }
}
