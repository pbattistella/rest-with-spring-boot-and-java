package br.pbattistella.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/sum/{numberOne}/{numberTow}")
    public Double sum(@PathVariable(value= "numberOne") String numberOne,
                      @PathVariable(value= "numberTow") String numberTow) {
        return Double.parseDouble(numberOne) + Double.parseDouble(numberTow);
    }

}
