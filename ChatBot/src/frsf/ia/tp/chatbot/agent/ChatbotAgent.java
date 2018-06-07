package frsf.ia.tp.chatbot.agent;

import frsf.cidici.faia.solver.productionsystem.Criteria;
import frsf.cidici.faia.solver.productionsystem.NoDuplication;
import frsf.cidici.faia.solver.productionsystem.Novelty;
import frsf.cidici.faia.solver.productionsystem.Priority;
import frsf.cidici.faia.solver.productionsystem.Random;
import frsf.cidici.faia.solver.productionsystem.Specificity;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;
import frsf.ia.tp.chatbot.graph.Regla;
import frsf.ia.tp.chatbot.search.actions.Ir;
import frsf.ia.tp.chatbot.solver.productionsystem.ChatbotProductionSystem;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/**
 * Clase que implementa el agente ChatBot.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotAgent extends SearchBasedAgent {

	/**
	 * Constructor.
	 */
    public ChatbotAgent() {

        // The Agent Goal
        ChatbotGoal agGoal = new ChatbotGoal();

        // The Agent State
        ChatbotState agState = new ChatbotState();
        this.setAgentState(agState);

        // Create the operators
        String nodos[] = {"hola","donde","que","chau","gracias","estar","final","informar","grupo","conformar","organizar","regularizar","ir","como","nota","cuantas","entregar","objetivo","promocionar","calcular","materia","actividad","cuando","realizar","evaluar","sitio","apunte","tp","mail","fecha","aprobar","charla","coloquio","ser","framework","llamar","agente","tema","cual","recuperatorio","modalidad","quien","parcial","libro","asistencia","porcentaje","bibliografia","clase","profesor","profesora","ayudante","horario","practica","teoria","consulta"};
        Vector<SearchAction> operators = new Vector<SearchAction>();
        for(int i=0;i<55;i++)
        {
        	Ir op = new Ir(nodos[i]);
        	operators.addElement(op);	
        }        
                
        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
        
    }

    /**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {
    	
    	ChatbotState estado = (ChatbotState) this.getAgentState();
    	if(estado.tienePercepcionValida())
    	{
	
    		//TODO Aca se decide la estrategia de busqueda.
	        // Create the search strategy
	        DepthFirstSearch strategy = new DepthFirstSearch();          
	
	        // Create a Search object with the strategy
	        Search searchSolver = new Search(strategy);
	
	        /* Generate an XML file with the search tree. It can also be generated
	         * in other formats like PDF with PDF_TREE */
	        searchSolver.setVisibleTree(Search.EFAIA_TREE); //TODO Aca esta la generacion del arbol.
	
	        // Set the Search searchSolver.
	        this.setSolver(searchSolver);
	
	        // Ask the solver for the best action
	        Action selectedAction = null;
	        try 
	        {
	            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
	        }
	        catch (Exception ex) 
	        {
	            Logger.getLogger(ChatbotAgent.class.getName()).log(Level.SEVERE, null, ex);
	        }
	
	        // Return the selected action
	        return selectedAction;
    	}
    	else
    	{
    		if(estado.tieneQueDespedirse())
    			estado.agregarReglasDespedida();
    		else estado.agregarReglasNoEntendio();    		
    	}
    	return null;
    	
    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
    
    /**
     * Metodo que actualiza la percepcion sacando la ultima
     * palabra de la oración.
     */
    public void actualizar(){
    	ChatbotState estado = (ChatbotState) this.getAgentState();
    	estado.actualizarPercepcion();
    	this.setAgentState(estado);
    }
    
    /**
     * Metodo que elimina las reglas repetidas del estado del
     * agente.
     */
    public void eliminarReglasRepetidas(){
    	ChatbotState estado = (ChatbotState) this.getAgentState();
    	LinkedList<Regla> listaR = estado.getreglas();
    	LinkedList<Regla> ret = new LinkedList<Regla>();
    	for(Iterator<Regla> i = listaR.iterator(); i.hasNext();)
    	{
    		Regla r1 = i.next();
    		boolean existe = false;
        	for(Iterator<Regla> j = ret.iterator(); j.hasNext();)
        	{
        		Regla r2 = j.next();
        		if(r1.equals(r2)) existe = true;
        	}
        	if(!existe) ret.addLast(r1);
    	}
    	estado.setreglas(ret);
    	this.setAgentState(estado);
    }
    
	/**
	 * Metodo que setea un valor inicial al estado del agente.
	 * @param El inicio en formato string.
	 */
    public void setInicio(String inicio) {

        ChatbotState agState = new ChatbotState(inicio);
        this.setAgentState(agState);
        
    }
    
    /**
     * Metodo que decide que regla ejecutar.
     */
    public boolean estaConectado(){
    	
        ChatbotState agState = (ChatbotState) this.getAgentState();
    	return !agState.seDespidio();
    	
    }
    
    /**
     * Metodo que determina si el agente debe decidir.
     * @return True si el agente tiene opciones, false en otro caso.
     */
    public boolean debeDecidir(){
    	
    	ChatbotState estado = (ChatbotState) this.getAgentState();
    	if(estado.gettipopercepcion()=='f' && estado.getpercepcion()==null) 
    		return false;   	
    	return true;
    	
    }
    
    /**
     * Metodo que hace que el agente aprenda.
     * @return La regla que hay que ejecutar o null si no hay ninguna.
     */
    public Action learn(){
    	
		//TODO Aca se deciden los criterios del sistema de produccion
    	LinkedList<Criteria> lista = new LinkedList<Criteria>();
    	
    	//Creacion del criterio Especificidad
    	lista.add(new Specificity());          
        //Creacion del criterio No duplicacion
    	lista.add(new NoDuplication());     	
        //Creacion del criterio Prioridad
    	lista.add(new Priority());         
        //Creacion del criterio Novedad
    	lista.add(new Novelty());         
        //Creacion del criterio Aleatorio
    	lista.add(new Random()); 
                
        //Creacion de un objeto sistema de produccion con los criterios.
    	ChatbotState ch = (ChatbotState) this.getAgentState();
        ChatbotProductionSystem productionSystemSolver = new ChatbotProductionSystem(lista,ch.getreglas(),ch.getpercepcion());

        //Setea el solver productionSystemSolver.
        this.setSolver(productionSystemSolver);

        //Se le pide al solver la acción a ejecutar si es que existe.
        Action selectedAction = null;
        try 
        {
            selectedAction = this.getSolver().solve(new Object[]{this.getProblem()});
        }
        catch (Exception ex) 
        {
            Logger.getLogger(ChatbotAgent.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;    	

    }

}
