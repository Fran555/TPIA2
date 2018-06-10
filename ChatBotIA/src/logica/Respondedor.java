package logica;

import criterios.Criterio;
import reglas.Regla;
import reglas.ReglaDato;
import java.util.ArrayList;
import java.util.List;
import respuestas.AdvertirNoResponder;
import respuestas.Decir;
import respuestas.LlamarPadres;
import respuestas.Respuesta;

public class Respondedor {
    
    private static final int ADVERTIR_NO_RESPONDER_VECES_REPETICIONES_PALABRAS_CLAVES = 3;
    
    public static List<Respuesta> obtenerRespuesta(Agente agente, List<Criterio> listaCriterios, List<ReglaDato> listaReglasActivas){
        List<Respuesta> respuestas = new ArrayList<Respuesta>();
        List<Criterio> criteriosAplicados = new ArrayList<Criterio>();
        //Se define la respuesta por defecto
        respuestas.add(new Decir("No se ha podido encontrar una respuesta."));
        if(listaReglasActivas.isEmpty()){
            //Si no existe ninguna regla activa para la entrada
            respuestas.clear();
            respuestas.add(new Decir("No se han encontrado reglas activas para la frase."));
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
                respuestas.clear();
                //Se obtiene las respuestas a partir de la regla elegida
                respuestas = obtenerRespuestas(agente, r, reglaDatoAplicada.getPalabrasClaves());
                reglaDatoAplicada.getRegla().setRespuestas(respuestas);
                agente.agregarReglaDatoUsada(reglaDatoAplicada);
            }
        }
        return respuestas;
    }
    
    public static List<Respuesta> obtenerRespuestas(Agente agente, Regla regla, List<String> palabrasClaves){
        List<Respuesta> respuestas = regla.getRespuestas();
        //Se eliminan las respuestas repetidas para que no se ejecute dos veces algo que hace lo mismo (no llame dos veces a los padres por ejemplo)
        int repeticionesPalabrasClaves = Utils.obtenerRepeticionesPalabrasClaves(agente.getReglaDatoUsadas(), palabrasClaves);
        respuestas = eliminarRespuestasRepetidas(repeticionesPalabrasClaves, respuestas);
        return respuestas;
    }
    
    public static List<Respuesta> eliminarRespuestasRepetidas(int repeticionesPC, List<Respuesta> respuestas){
        List<Respuesta> respuestasVerif = new ArrayList<Respuesta>();
        boolean repetida = false;
        for(Respuesta res : respuestas){
            if(respuestasVerif.size() == 0){
                respuestasVerif.add(res);
            }
            else{
                for(Respuesta resp : respuestasVerif){
                    if(res.toString(repeticionesPC).equals(resp.toString(repeticionesPC))){
                        repetida = true;
                    }
                }
                if(!repetida){
                    respuestasVerif.add(res);
                }
            }
        }
        return respuestasVerif;
    }
    
}
