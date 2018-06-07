package frsf.ia.tp.chatbot.agent;

import java.util.Iterator;
import java.util.LinkedList;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.ia.tp.chatbot.preprocessing.*;
import frsf.ia.tp.chatbot.graph.*;

/**
 * Clase que representa el estado del agente ChatBot.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotState extends SearchBasedAgentState {
	
	private int despedirse;
	private char tipoPercepcion;
    private Oracion percepcion;
    private Oracion cadenaActual;
    private NodoG nodoActual;
    private LinkedList<Regla> reglas; 

    /**
     * Constructor.
     */
    public ChatbotState() {
    	
    	tipoPercepcion = ' ';
    	despedirse = 0;
    	percepcion = new Frase();
		cadenaActual = new Frase();
		nodoActual = new NodoG("");
		reglas = new LinkedList<Regla>();
		
    }

    /**
     * Constructor.
     */
    public ChatbotState(String nodoInicial) {

    	tipoPercepcion = ' ';
    	despedirse = 0;
    	percepcion = new Frase();
    	cadenaActual = new Frase(nodoInicial);
		nodoActual = new NodoG(nodoInicial);
		reglas = new LinkedList<Regla>();
		this.agregarReglas(nodoActual.getReglas());
		
    }

    /**
     * Metodo que agrega una lista de reglas a las reglas actuales.
     * @param lista
     */
    public void agregarReglas(LinkedList<Regla> lista){
    	for(Iterator<Regla> i = lista.iterator();i.hasNext();)
    	{
    		Regla e = i.next();
    		if(e.isActive(percepcion)) reglas.addLast(e);
    	}   	
    }
    
    /**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
    	
    	ChatbotState ret = new ChatbotState();  
    	ret.setpercepcion(this.getpercepcion());
    	Oracion original = this.getcadenaActual();     	
    	LinkedList<Palabra> l = original.getPalabras();
    	Oracion copia = new Frase();
    	for(Iterator<Palabra> i = l.iterator();i.hasNext();)
    	{
    		Palabra p1 = i.next();
    		Palabra p2 = new Palabra();
    		p2.setPalabra(p1.getPalabra());
    		p2.setEncontrada(p1.estaEncontrada());
    		copia.agregarPalabra(p2);
    	}
    	ret.setcadenaActual(copia);
    	ret.setnodoActual(this.getnodoActual());    
    	LinkedList<Regla> r = this.getreglas();
    	LinkedList<Regla> rAux = new LinkedList<Regla>();
    	for(Iterator<Regla> i = r.iterator();i.hasNext();)
    	{
    		Regla r1 = i.next();
    		Regla r2 = new Regla(r1.getId().intValue(),r1.getSpecificity(),r1.getPriority(),r1.getNovelty(),(String) r1.getCondition(),(String) r1.getThen());
    		rAux.addLast(r2);
    	}    	
    	ret.setreglas(rAux);
        return ret;
        
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
    	
    	reglas = new LinkedList<Regla>();
		cadenaActual = new Frase();
		nodoActual = new NodoG("");
    	ChatbotAgentPerception c = (ChatbotAgentPerception) p;
    	Preprocesamiento preprocess = new Preprocesamiento();
    	percepcion = preprocess.start(c.getoracion());
    	tipoPercepcion = preprocess.tipo(c.getoracion());
    	if(percepcion!=null)
    	{
    		String p1 = percepcion.primeraPalabra().getPalabra();
    		cadenaActual = new Frase(p1);
    		nodoActual = new NodoG(p1);
    		this.agregarReglas(nodoActual.getReglas());
    	}
    	else if(tipoPercepcion=='p') despedirse++;
    	
    }

    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
    }

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
    	
        String str = "";
        str = str.concat("Percepcion: " + percepcion + "- ");
        str = str.concat("Tipo percepcion: " + tipoPercepcion + " - ");
        str = str.concat("Cadena Actual: " + cadenaActual.toString() + "- ");
        str = str.concat("Nodo Actual: " + nodoActual.toString() + " - ");
        String r = "";
        for(Iterator<Regla> i = reglas.iterator();i.hasNext();)
    	{        
        	Regla aux = i.next();
        	r = r.concat("(" + aux.getId().toString() + ") " );
        }
    	str = str.concat("Reglas: " + r  + "- ");
    	str = str.concat("Despedirse: " + despedirse+ "\n");
        return str;
        
    }
    
    public String getStringRtas() {
    	
        String r = "";
        for(Iterator<Regla> i = reglas.iterator();i.hasNext();)
    	{        
        	Regla aux = i.next();
        	r = r.concat("(" + aux.getId().toString() + ") " );
        }
        return r;
        
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
    public boolean equals(Object obj) {
    	
    	ChatbotState s = (ChatbotState) obj;
    	if(s.getnodoActual().equals(nodoActual)) return true;
    	else return false;
    	
    }

    // The following methods are agent-specific:    	
     public Oracion getpercepcion(){
        return percepcion;
     }
     public void setpercepcion(Oracion arg){
        percepcion = arg;
     }
     public NodoG getnodoActual(){
        return nodoActual;
     }
     public void setnodoActual(NodoG arg){
        nodoActual = arg;
     }
     public Oracion getcadenaActual(){
        return cadenaActual;
     }
     public void setcadenaActual(Oracion arg){
        cadenaActual = arg;
     }
     public LinkedList<Regla> getreglas(){
        return reglas;
     }
     public void setreglas(LinkedList<Regla> arg){
    	 reglas = arg;
     }
     
     /**
      * Metodo que quita la ultima palabra de la percepcion.
      */
     public void actualizarPercepcion(){
    	 percepcion.borrarUltima();
     }

     /**
      * Metodo que determina si la percepción del agente es válida.
      * @return True si tiene una percepcion, False en otro caso.
      */
     public boolean tienePercepcionValida(){    	 
    	 return !(percepcion==null);
     }
     
     /**
      * Metodo que determina si el Chatbot debe despedirse.
      * Se despedirá después de 3 frases ignoradas a lo
      * largo del chat.
      * @return True si debe despedirse, False en otro caso.
      */
     public boolean tieneQueDespedirse(){
    	 return (despedirse==3);
     }
     
     /**
      * Metodo que determina cuales son las reglas que el 
      * Chatbot usa para despedirse y las agrega a la lista
      * de reglas.
      */
     public void agregarReglasDespedida(){
    	 reglas.add(new Regla(93,1,3,0,"","Me tengo que ir yendo...nos vemos en clases!"));
    	 reglas.add(new Regla(94,1,0,0,"","Che, me tengo que ir de la pc...byes!"));
     }
     
     /**
      * Metodo que determina cuales son las reglas que el 
      * Chatbot usa para decir que no entendió la pregunta
      * y las agrega a la lista de reglas.
      */
     public void agregarReglasNoEntendio(){
    	 reglas.add(new Regla(95,1,0,0,"","...?¡"));
    	 reglas.add(new Regla(96,1,3,0,"","¿?"));
     }
     
     /**
      * Metodo que determina si hay reglas que el 
      * Chatbot pueda usar para decir.
      * @return True si la lista de reglas no esta vacia, sino False.
      */
     public boolean tieneReglas(){
    	 return !reglas.isEmpty();
     }
     
     /**
      * Metodo que determina si el Chatbot se despidio.
      * @return True si la lista de reglas no esta vacia, sino False.
      */
     public boolean seDespidio(){
    	 return (despedirse==3);
     }
     
     /**
      * Metodo que retorna el atributo tipoPercepcion.
      * @return tipoPercepcion
      */
     public char gettipopercepcion(){
    	 return tipoPercepcion;
     }
     
}

