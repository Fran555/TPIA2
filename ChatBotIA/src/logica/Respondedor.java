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
    
    public static List<Object> obtenerRespuesta(List<Criterio> listaCriterios, List<ReglaDato> listaReglasActivas){
        List<Object> respuesta = new ArrayList<Object>();
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
    
    public static List<Object> obtenerRespuesta(Regla regla){
        List<Object> respuesta = new ArrayList<Object>();
        for(Object res : regla.getRespuestas()){
            //Aca es donde se puede hacer algo especial segun la regla, por ahora solo se devuelve la lista de respuestas
            respuesta.add(res);
        }
        return respuesta;
    }
    
}
