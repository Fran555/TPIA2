/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.HashMap;
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
        Map<String, String> palabrasClaves = convertirPalabrasClavesAMinusculas(palabras);
        List<String> palabrasFrase = obtenerPalabras(frase);
        for (String palabra : palabrasFrase){
            if(palabrasClaves.containsKey(palabra.toLowerCase())){
                pc.add(palabrasClaves.get(palabra.toLowerCase()).toLowerCase());
            }
        }
        return pc;
    }
   
   public static Map<String, String> convertirPalabrasClavesAMinusculas(Map<String, String> palabrasClaves){
       Map<String, String> resultado = new HashMap<String, String>();
       for(String clave : palabrasClaves.keySet()){
           resultado.put(clave.toLowerCase(), palabrasClaves.get(clave));
       }
       return resultado;
   }
   
   public static List<String> obtenerPalabras(String frase){
       List<String> palabras = new ArrayList<String>();
       String palabraAux;
       for(String palabra : frase.split(" ")){
           palabraAux = palabra.replaceAll("[^a-zA-Z0-9]+", "");
           palabras.add(palabraAux);
       }
       return palabras;
   }
   
}
