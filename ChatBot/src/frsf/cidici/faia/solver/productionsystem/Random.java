package frsf.cidici.faia.solver.productionsystem;

import java.util.LinkedList;

/**
 * Clase que implementa el criterio aleatorio.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Random extends Criteria {

	@Override
	public LinkedList<PeerRuleData> apply(LinkedList<PeerRuleData> list) {

		java.util.Random r = new java.util.Random(System.currentTimeMillis());
		int valor = r.nextInt(list.size());
		LinkedList<PeerRuleData> ret = new LinkedList<PeerRuleData>();
		ret.add(list.get(valor));
		return ret;
		
	}

	@Override
	public String toString() {
		return "Random (Aleatorio)";
	}

}
