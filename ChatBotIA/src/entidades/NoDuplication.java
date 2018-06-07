package entidades;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import logica.Agente;

/**
 * Clase que implementa el criterio de no duplicacion.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class NoDuplication extends Criterio {
	
	@Override
	public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {
			
            LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
            for(ReglaDato prd : list)
            {
                if(!usada(prd.getRegla(), prd.getDato())){
                    ret.add(prd);
                }
            }
            return ret;	
		
	}

	@Override
	public String toString() {	
		return "No Duplication (No duplicaci�n)";
	}

	private boolean usada(Regla r, String d){
            for(ReglaDato prd : Agente.getReglaDatoUsadas())
            {
                Regla ru = prd.getRegla();
                String du = prd.getDato();
                if((r.getId()==ru.getId()) && (d.equals(du))){
                    return true;
                }
            }
            return false;
	}
}
