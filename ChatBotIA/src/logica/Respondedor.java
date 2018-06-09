/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Criterio;
import entidades.Regla;
import entidades.ReglaDato;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fede_
 */
public class Respondedor {
    
    public static List<String> obtenerRespuesta(List<Criterio> listaCriterios, List<ReglaDato> listaReglasActivas){
        List<String> respuesta = new ArrayList<String>();
        respuesta.add("No se ha podido encontrar una respuesta.");
        if(listaReglasActivas.isEmpty()){
            respuesta.clear();
            respuesta.add("No se han encontrado reglas activas para la frase.");
        }
        else{
            List<ReglaDato> finalRules;
            Criterio criterio;
            int j = 0;
            do{
                finalRules = listaReglasActivas;
                for(int i=j; i<listaCriterios.size(); i++){
                    criterio = listaCriterios.get(i);
                    finalRules = criterio.aplicarCriterio(finalRules);
                    if(finalRules.size()==1){
                        break;
                    }
                }
                j++;
            }
            while(finalRules.size() != 1 && j < listaCriterios.size());
            if(finalRules != null && finalRules.size() > 0){
                Regla r = (finalRules.get(0)).getRegla();
                Agente.agregarReglaDatoUsada(finalRules.get(0));
                respuesta.clear();
                respuesta = obtenerRespuesta(r);
            }
        }
        return respuesta;
    }
    
    public static List<String> obtenerRespuesta(Regla regla){
        //Aca es donde se puede hacer algo especial segun la regla
        List<String> respuesta = regla.getRespuestas();
        return respuesta;
    }
    
}
