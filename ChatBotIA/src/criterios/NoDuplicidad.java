package criterios;

import reglas.Regla;
import reglas.ReglaDato;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import logica.Agente;

public class NoDuplicidad extends Criterio {
	
    private Agente agente;

    public NoDuplicidad(Agente agente) {
        this.agente = agente;
    }
        
    @Override
    public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {
        //Se obtiene una lista de reglas que no hayan sido usado con la lista de palabras claves obtenidas de la entrada
        LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
        for(ReglaDato prd : list)
        {
            //Verifica que una par regla - lista de palabras claves no hayan sido utilizado por el cliente
            if(!usada(prd.getRegla(), prd.getPalabrasClaves())){
                ret.add(prd);
            }
        }
        return ret;
    }

    @Override
    public String toString() {	
        return "No Duplication (No Duplicación)";
    }

    private boolean usada(Regla r, List<String> pc){
        for(ReglaDato prd : agente.getReglaDatoUsadas())
        {
            Regla ru = prd.getRegla();
            if(ru != null){
                List<String> pcu = prd.getPalabrasClaves();
                //Verifica su un objeto ReglaDato obtenido de la lista de reglas utilizadas por el agente es igual a uno candidato a ser aplicado
                if((r.getId()==ru.getId()) && coincidenPalabrasClaves(pcu, pc)){
                    return true;
                }
            }
        }
        return false;
    }

    //Verifica si dos listas de palabras contienen exactamente las mismas palabras
    private boolean coincidenPalabrasClaves(List<String> pcu, List<String> pc){
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
