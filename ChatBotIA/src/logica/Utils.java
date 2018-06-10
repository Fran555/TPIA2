package logica;

import java.util.List;
import reglas.ReglaDato;

public class Utils{
    
    public static int obtenerRepeticionesPalabrasClaves(List<ReglaDato> reglasDatos, List<String> palabrasClaves){
        int repeticiones = 0;
        for(ReglaDato reglaDato : reglasDatos){
            if(coincidenPalabrasClaves(reglaDato.getPalabrasClaves(), palabrasClaves)){
                repeticiones++;
            }
        }
        return repeticiones;
    }
    
    public static boolean coincidenPalabrasClaves(List<String> pcu, List<String> pc){
        boolean coincide = true;
        //Verifica que la  lista de palabras claves de la entrada (pc) contenga todas las palabras de la lista de palabras del objeto ReglaDato obtenido de la lista de reglas usadas por el agente (pcu)
        for(String palabra : pcu){
            if(!pc.contains(palabra)){
                coincide = false;
                break;
            }
        }
        //Verifica que la lista de palabras del objeto ReglaDato obtenido de la lista de reglas usadas por el agente (pcu) contenga todas las palabras de la lista de palabras claves de la entrada (pc)
        for(String palabra : pc){
            if(!pcu.contains(palabra)){
                coincide = false;
                break;
            }
        }
        return coincide;
    }
    
}
