

package com.example.parcial.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LucasController {


    @GetMapping("/lucasseq")
    public Map<String, Object> getMethodName(@RequestParam String value) {
        int n;
        try {
            n = Integer.parseInt(value); 
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El valor proporcionado debe ser un número entero.");
        }

        List<Integer> lucasSequence = LucasAlgoritmo.SecuenciaL(n); 

        Map<String, Object> response = new HashMap<>();
        response.put("operation", "Secuencia de Lucas para el numero" + n);
        response.put("input", n);
        response.put("output", lucasSequence.stream().map(String::valueOf).collect(Collectors.joining(", "))); 
        return response;
    }

}
