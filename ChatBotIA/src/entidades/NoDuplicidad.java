package entidades;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import logica.Agente;

/**
 * Clase que implementa el criterio de no duplicacion.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class NoDuplicidad extends Criterio {
	
	@Override
	public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {
			
            LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
            for(ReglaDato prd : list)
            {
                if(!usada(prd.getRegla(), prd.getPalabrasClaves())){
                    ret.add(prd);
                }
            }
            return ret;	
		
	}

	@Override
	public String toString() {	
		return "No Duplication (No duplicaci�n)";
	}

	private boolean usada(Regla r, List<String> pc){
            for(ReglaDato prd : Agente.getReglaDatoUsadas())
            {
                Regla ru = prd.getRegla();
                List<String> pcu = prd.getPalabrasClaves();
                if((r.getId()==ru.getId()) && coincidenPalabrasClaves(pcu, pc)){
                    return true;
                }
            }
            return false;
	}
        
        private boolean coincidenPalabrasClaves(List<String> pcu, List<String> pc){
            boolean coincide = true;
            for(String palabra : pcu){
                if(!pc.contains(palabra)){
                    coincide = false;
                    break;
                }
            }
            for(String palabra : pc){
                if(!pcu.contains(palabra)){
                    coincide = false;
                    break;
                }
            }
            return coincide;
        }
}
