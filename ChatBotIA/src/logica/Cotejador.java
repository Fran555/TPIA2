package logica;

import criterios.Criterio;
import reglas.Regla;
import reglas.ReglaDato;
import java.util.ArrayList;
import java.util.List;

public class Cotejador {
    
    public static List<Regla> cotejarReglas(Agente agente, List<Regla> listaReglas, List<String> palabrasClavesEntrada, String frase){
        
        List<Regla> reglasActivas = new ArrayList<Regla>();
        boolean todasPalabras = true;
        for(Regla regla : listaReglas){
            if((regla.getPalabrasClaves().size() == 0)){
                //Si la regla no tiene palabras claves entonces ya de por sí cumple el cotejamiento entonces se agrega a la lista de palabras activas
                reglasActivas.add(regla);
            }
            else{
                todasPalabras = true;
                for(String palabra : regla.getPalabrasClaves())
                {
                    if(!palabrasClavesEntrada.contains(palabra.toLowerCase())){
                        //Si una palabra clave de la regla no esta incluida en la lista de palabras claves obtenidas de la frase, entonces la regla ya no cumple con el cotejamiento
                        todasPalabras = false;
                        break;
                    }
                }
                if(todasPalabras){
                    //Si las palabras de la regla estan contenidas en la lista de palabras claves obtenidas de la frase, entonces la regla cumple el cotejamiento y se agrega a la lista de palabras activas
                    reglasActivas.add(regla);
                }
            }
        }
        return reglasActivas;
    }
    
}
