/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package historial;

import criterios.Criterio;
import java.util.ArrayList;
import java.util.List;
import logica.Utils;
import reglas.ReglaDato;

/**
 *
 * @author fede_
 */
public class Historial {
    
    public static List<String> obtenerHistorial(List<ReglaDato> reglasDatos){
        List<String> logs = new ArrayList<String>();
        String texto = "";
        String palabra;
        int repeticionesPalabrasClaves;
        List<String> palabrasClaves;
        ReglaDato reglaDato;
        for(int i = 0; i<reglasDatos.size(); i++){
            texto = "";
            reglaDato = reglasDatos.get(i);
            repeticionesPalabrasClaves = Utils.obtenerRepeticionesPalabrasClaves(obtenerReglasDatos(reglasDatos, i), reglaDato.getPalabrasClaves());
            texto += ((texto.equals("")) ? "" : "\n") + "Frase ingresada:\n\t" + reglaDato.getFrase();
            texto += ((texto.equals("")) ? "" : "\n") + "Palabras claves detectadas:\n\t";
            palabrasClaves = reglaDato.getPalabrasClaves();
            for(int j = 0; j<palabrasClaves.size(); j++){
                palabra = palabrasClaves.get(j);
                texto += palabra;
                if(j < palabrasClaves.size() - 1){
                    texto += " ,";
                }
            }
            texto += ((texto.equals("")) ? "" : "\n") + "Regla aplicada:" + reglaDato.getRegla().toString(repeticionesPalabrasClaves);
            texto += ((texto.equals("")) ? "" : "\n") + "Criterios aplicados:";
            for(Criterio criterio : reglaDato.getCriteriosAplicados()){
                texto += "\n\t" + criterio.toString();
            }
            logs.add(texto);
        }
        return logs;
    }
    
    private static List<ReglaDato> obtenerReglasDatos(List<ReglaDato> reglasDatos, int maxIndice){
        List<ReglaDato> reglasDatosResp = new ArrayList<ReglaDato>();
        for(int i=0; i<=maxIndice; i++){
            reglasDatosResp.add(reglasDatos.get(i));
        }
        return reglasDatosResp;
    }
    
}
