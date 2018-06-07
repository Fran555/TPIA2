package frsf.ia.tp.chatbot.graph;

import java.util.LinkedList;

/**
 * Clase que ejemplifica los nodos del grafo.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class NodoG {

	LinkedList<Regla> reglas;
	String etiqueta;
	
	/**
	 * Constructor.
	 */
	public NodoG(){
		reglas = new LinkedList<Regla>();
	}
	
	/**
	 * Constructor.
	 */	
	public NodoG(String aString){
		etiqueta=aString;
		reglas = Grafo.obtenerReglas(aString);
	}
	
	/**
	 * Metodo que setea la etiqueta.
	 * @param aString
	 */
	public void  setEtiqueta(String aString){
		etiqueta=aString;
	}
	
	/**
	 * Metodo que devuelve la etiqueta.
	 * @return La etiqueta del nodo.
	 */
	public String getEtiqueta(){
		return etiqueta;
	}
	
	/**
	 * Metodo que convierte a string el nodo.
	 */
	public String toString(){
		return etiqueta;
	}
	
	/**
	 * Metodo que determina si dos nodos son iguales.
	 * @return True si son iguales, False en otro caso.
	 */
	public boolean equals(Object obj){
		NodoG otroNodo = (NodoG) obj;
		return (otroNodo.getEtiqueta().compareTo(etiqueta)==0);
	}

	/**
	 * Metodo que devuelve las reglas.
	 * @return Las reglas del nodo.
	 */
	public LinkedList<Regla> getReglas(){
		return reglas;
	}
	
	/**
	 * Metodo que agrega una regla a nodo.
	 * @param aRegla
	 */
	public void addRegla(Regla aRegla){
		reglas.add(aRegla);
	}
	
}
