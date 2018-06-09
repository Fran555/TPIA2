package entidades;

import entidades.Regla;
import entidades.ReglaDato;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa el criterio de novedad.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Novelty extends Criterio {

	@Override
	public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {

            int novelty, mayor = 0;		
            for(ReglaDato prd : list)
            {
                    novelty = list.indexOf(prd);
                    if(novelty > mayor) mayor = novelty;
            }
            LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
            for(ReglaDato prd : list)
            {
                    if(list.indexOf(prd) == mayor) ret.add(prd);
            }    	
            return ret;
		
	}

	@Override
	public String toString() {
		return "Novelty (Novedad)";
	}

}
