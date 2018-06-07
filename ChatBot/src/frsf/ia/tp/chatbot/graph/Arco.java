package frsf.ia.tp.chatbot.graph;

/**
 * Clase que implementa los arcs del grafo.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class Arco { 

	String nodoInicio;
	String nodoFin;

	/**
	 * Constructor.
	 * @param s
	 * @param e
	 */
	public Arco(String s, String e){
		nodoInicio=s;
		nodoFin=e;
	}
	
	/**
	 * Devuelve la etiqueta del nodo inicial del arco.
	 * @return El nombre del nodo inicial.
	 */
	public String getInicio(){
		return nodoInicio;
	}
	
	/**
	 * Devuelve la etiqueta del nodo destino del arco.
	 * @return El nombre del nodo destino.
	 */
	public String getFin(){
		return nodoFin;
	}
	
}
