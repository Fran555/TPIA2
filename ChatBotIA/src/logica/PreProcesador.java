package logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PreProcesador {
    
   public static List<String> preprocesarEntrada(Agente agente, Map <String,String> palabras, String fraseOriginal){
        List <String> pc = new ArrayList<String>();
        //Se convierten las keys del mapa de sinonimos - palabras claves obtenido por parametro a minúsculas
        Map<String, String> palabrasClaves = convertirPalabrasClavesAMinusculas(palabras);
        //Se obtiene una lista de palabras a partir de la frase ingresada por parámetro
        List<String> palabrasFrase = obtenerPalabras(fraseOriginal);
        //Se obtienen la lista de palabras claves ingresadas usando el mapa sinonimos - palabras claves y la lista de palabras obtenidas de la frase de entrada
        for (String palabra : palabrasFrase){
            if(palabrasClaves.containsKey(palabra.toLowerCase())){
                pc.add(palabrasClaves.get(palabra.toLowerCase()).toLowerCase());
            }
        }
        return pc;
    }
   /**
    * Devuelve en lowercase un mapa las palabras clave del mapa que es pasado como parámetro
    * @param palabrasClaves Map<String, String>
    * @return resultado  Map<String, String>
    */
   public static Map<String, String> convertirPalabrasClavesAMinusculas(Map<String, String> palabrasClaves){
       Map<String, String> resultado = new HashMap<String, String>();
       for(String clave : palabrasClaves.keySet()){
           resultado.put(clave.toLowerCase(), palabrasClaves.get(clave));
       }
       return resultado;
   }
   
   /**
    * Devuelve la lista de palabras componentes de la frase inicial pasada como parámetro
    * @param frase List<String>
    * @return palabras String
    */
   public static List<String> obtenerPalabras(String frase){
       List<String> palabras = new ArrayList<String>();
       String palabraAux;
       //Se recorre cada palabra separando la frase por espacios
       for(String palabra : frase.split(" ")){
           //Se quita todo lo que no sea un caracter alfanumérico
           palabraAux = palabra.replaceAll("[^a-zA-Z0-9]+", "");
           palabras.add(palabraAux);
       }
       return palabras;
   }
   
}
