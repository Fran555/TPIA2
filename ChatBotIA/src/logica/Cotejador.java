/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Regla;
import entidades.ReglaDato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fede_
 */
public class Cotejador {
    
    public static List<ReglaDato> cotejarReglas(List<Regla> listaReglas, List<String> palabrasClavesEntrada, String frase){
        List<ReglaDato> reglasActivas = new ArrayList<ReglaDato>();
        boolean todasPalabras = true;
        for(Regla regla : listaReglas){
            if((regla.getPalabrasClaves().size() == 0)){
                reglasActivas.add(new ReglaDato(regla, palabrasClavesEntrada, frase));
            }
            else{
                todasPalabras = true;
                for(String palabra : regla.getPalabrasClaves())
                {
                    if(!palabrasClavesEntrada.contains(palabra.toLowerCase())){
                        todasPalabras = false;
                        break;
                    }
                }
                if(todasPalabras){
                    reglasActivas.add(new ReglaDato(regla, palabrasClavesEntrada, frase));
                }
            }
        }
        return reglasActivas;
    }
    
}
