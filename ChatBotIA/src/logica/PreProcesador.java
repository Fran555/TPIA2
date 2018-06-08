/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Francisco
 */
public class PreProcesador {
    
   public static List<String> preprocesarEntrada(Map <String,String> palabras, String frase){
       
        List <String> pc = new ArrayList<String>();
        String patternString;
        Pattern pattern;
        Matcher matcher;
        boolean matches;
        for (Map.Entry<String, String> entry : palabras.entrySet()){

            patternString = entry.getValue();

            pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);

            matcher = pattern.matcher(frase);

            matches = matcher.matches();

            if (matches==true){
                pc.add(entry.getKey());   
            }

        }
   
        return pc;
    }
   
}
