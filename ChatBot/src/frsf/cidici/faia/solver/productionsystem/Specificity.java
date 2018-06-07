package frsf.cidici.faia.solver.productionsystem;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase que implementa el criterio de especificidad.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Specificity extends Criteria {

	@Override
	public LinkedList<PeerRuleData> apply(LinkedList<PeerRuleData> list) {
		
		int specifity, mayor = 0;		
    	for(Iterator<PeerRuleData> i = list.iterator(); i.hasNext();)
    	{
    		Rule r = i.next().getRule();
    		specifity = r.getSpecificity();
    		if(specifity > mayor) mayor = specifity;
    	}
    	LinkedList<PeerRuleData> ret = new LinkedList<PeerRuleData>();
    	for(Iterator<PeerRuleData> i = list.iterator(); i.hasNext();)
    	{
    		PeerRuleData prd = i.next();
    		Rule r = prd.getRule();
    		if(r.getSpecificity() == mayor) ret.add(prd);
    	}    	
		return ret;
		
	}

	@Override
	public String toString() {
		return "Specificity (Especificidad)";
	}

}
