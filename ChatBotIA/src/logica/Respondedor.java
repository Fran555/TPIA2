
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import criterios.Criterio;
import reglas.Regla;
import reglas.ReglaDato;
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
            //Si no existe ninguna regla activa para la entrada
            respuesta.clear();
            respuesta.add(new Decir("No se han encontrado reglas activas para la frase."));
        }
        else{
            List<ReglaDato> finalRules;
            Criterio criterio;
            int j = 0;
            //Mientras no haya una sola regla elegida y no nos quedemos sin criterios
            do{
                finalRules = listaReglasActivas;
                criteriosAplicados = new ArrayList<Criterio>();
                //Se seleccionan las reglas segun cada criterio hasta que uno devuelva una sola regla (los criterios se van anidando)
                for(int i=j; i<listaCriterios.size(); i++){
                    criterio = listaCriterios.get(i);
                    //Se va agregando los criterios usados a una lista
                    criteriosAplicados.add(criterio);
                    //Al aplicar el criterio sobre la finalRules se produce el anidamiento de criterios
                    finalRules = criterio.aplicarCriterio(finalRules);
                    //Si hay una sola regla entonces se sale del for y se deja de buscar criterios
                    if(finalRules.size()==1){
                        break;
                    }
                }
                j++;
            }
            while(finalRules.size() != 1 && j < listaCriterios.size());
            if(finalRules != null && finalRules.size() > 0){
                //Se obtiene la primera ReglaDato de finalRules
                ReglaDato reglaDatoAplicada = finalRules.get(0);
                //Se le agrega a la ReglaDato seleccionada la lista de criterios aplicados (para el log)
                reglaDatoAplicada.setCriteriosAplicados(criteriosAplicados);
                //Se obtiene la regla seleccionada
                Regla r = reglaDatoAplicada.getRegla();
                //Se agrega el objeto ReglaDato a la lista que conserva el agente (para el log y la no duplicidad)
                Agente.agregarReglaDatoUsada(reglaDatoAplicada);
                respuesta.clear();
                //Se obtiene las respuestas a partir de la regla elegida
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
