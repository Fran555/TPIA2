
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
import respuestas.Decir;
import respuestas.Respuesta;

/**
 *
 * @author fede_
 */
public class Respondedor {
    
    public static List<Respuesta> obtenerRespuesta(List<Criterio> listaCriterios, List<ReglaDato> listaReglasActivas){
        List<Respuesta> respuesta = new ArrayList<Respuesta>();
        List<Criterio> criteriosAplicados = new ArrayList<Criterio>();
        //Se define la respuesta por defecto
        respuesta.add(new Decir("No se ha podido encontrar una respuesta."));
        if(listaReglasActivas.isEmpty()){
            respuesta.clear();
            respuesta.add(new Decir("No se han encontrado reglas activas para la frase."));
        }
        else{
            List<ReglaDato> finalRules;
            Criterio criterio;
            int j = 0;
            do{
                finalRules = listaReglasActivas;
                criteriosAplicados = new ArrayList<Criterio>();
                for(int i=j; i<listaCriterios.size(); i++){
                    criterio = listaCriterios.get(i);
                    criteriosAplicados.add(criterio);
                    finalRules = criterio.aplicarCriterio(finalRules);
                    if(finalRules.size()==1){
                        break;
                    }
                }
                j++;
            }
            while(finalRules.size() != 1 && j < listaCriterios.size());
            if(finalRules != null && finalRules.size() > 0){
                ReglaDato reglaDatoAplicada = finalRules.get(0);
                reglaDatoAplicada.setCriteriosAplicados(criteriosAplicados);
                Regla r = reglaDatoAplicada.getRegla();
                Agente.agregarReglaDatoUsada(reglaDatoAplicada);
                respuesta.clear();
                respuesta = obtenerRespuestas(r);
            }
        }
        return respuesta;
    }
    
    public static List<Respuesta> obtenerRespuestas(Regla regla){
        List<Respuesta> respuesta = new ArrayList<Respuesta>();
        for(Respuesta res : regla.getRespuestas()){
            //Aca es donde se puede hacer algo especial segun la regla, por ahora solo se devuelve la lista de respuestas
            respuesta.add(res);
        }
        return respuesta;
    }
    
}
