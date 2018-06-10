package criterios;

import reglas.Regla;
import reglas.Regla;
import reglas.ReglaDato;
import reglas.ReglaDato;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase que implementa el criterio de especificidad.
 * @author Grupo 12: Blas,Mar�a Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Especificidad extends Criterio {

	@Override
	public LinkedList<ReglaDato> aplicarCriterio(List<ReglaDato> list) {
		
            int specifity, mayor = 0;
            //Se obtiene la especificidad más alta de la lista de reglas
            for(ReglaDato prd : list)
            {
                    Regla r = prd.getRegla();
                    //La especificidad es la cantidad de palabras claves que contiene la regla
                    specifity = r.getPalabrasClaves().size();
                    if(specifity > mayor) mayor = specifity;
            }
            
            //Se obtiene una lista de reglas que tiene la máxima especificidad
            LinkedList<ReglaDato> ret = new LinkedList<ReglaDato>();
            for(ReglaDato prd : list)
            {
                    Regla r = prd.getRegla();
                    if(r.getPalabrasClaves().size() == mayor){
                        ret.add(prd);
                    }
            }    	
            return ret;
		
	}

	@Override
	public String toString() {
		return "Specificity (Especificidad)";
	}

}
