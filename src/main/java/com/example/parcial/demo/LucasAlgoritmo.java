package com.example.parcial.demo;

import java.util.ArrayList;
import java.util.List;

/*
 * @author Andres Rodriguez
 */

//L(0)=2
//L(1)=1
//L(n) = L(n-1) + L(n-2), para todo n >= 2


public class LucasAlgoritmo {
    
    public static List<Integer> SecuenciaL(int value) {
        
        int x = 2; 
        int y = 1; 

        List<Integer> ListLucasSecuencia = new ArrayList<>();
        if (value < 0) {
            throw new IllegalArgumentException("El valor debe ser n > 0 :: n == 0");
        }

        ListLucasSecuencia.add(x);
        if (value == 0) {
            return ListLucasSecuencia;
        }
        
        ListLucasSecuencia.add(y);
        for (int i = 2; i <= value; i++) {
            int next = x + y;
            ListLucasSecuencia.add(next);
            x = y;
            y = next;
        }
        return ListLucasSecuencia;
    }
    
}


