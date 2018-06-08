/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import entidades.Criterio;
import entidades.Regla;
import entidades.ReglaDato;
import java.util.List;

/**
 *
 * @author fede_
 */
public class Respondedor {
    
    public static String obtenerRespuesta(List<Criterio> listaCriterios, List<ReglaDato> listaReglasActivas){
        String respuesta = "No se ha podido encontrar una respuesta.";
        if(listaReglasActivas.isEmpty()){
            respuesta = "No se han encontrado reglas activas para la frase.";
        }
        else{
            List<ReglaDato> finalRules = null;
            for(Criterio criterio : listaCriterios)
            {
                finalRules = criterio.aplicarCriterio(listaReglasActivas);
                if(finalRules.size()==1){
                    break;
                }
            }
            if(finalRules != null && finalRules.size() > 0){
                Regla r = (finalRules.get(0)).getRegla();
                Agente.agregarReglaDatoUsada(finalRules.get(0));
                respuesta = obtenerRespuesta(r);
            }
        }
        return respuesta;
    }
    
    public static String obtenerRespuesta(Regla regla){
        //Aca es donde se puede hacer algo especial segun la regla
        String respuesta = regla.getRespuesta();
        return respuesta;
    }
    
}
