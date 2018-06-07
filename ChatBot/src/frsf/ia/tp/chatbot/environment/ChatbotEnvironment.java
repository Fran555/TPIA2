package frsf.ia.tp.chatbot.environment;

import java.util.LinkedList;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;
import frsf.ia.tp.chatbot.agent.ChatbotAgentPerception;

/**
 * Clase que implementa el ambiente del ChatBot.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotEnvironment extends Environment {

	/**
	 * Constructor.
	 */
    public ChatbotEnvironment() {
    	
        /*
         * Se crea el estado del ambiente.
         */
        this.environmentState = new ChatbotEnvironmentState();
        
    }

    public ChatbotEnvironmentState getEnvironmentState() {
        return (ChatbotEnvironmentState) super.getEnvironmentState();
    }

    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  ChatbotAgentPerception getPercept() {
        
        ChatbotAgentPerception perception = new ChatbotAgentPerception();
        ChatbotEnvironmentState estado = (ChatbotEnvironmentState) environmentState;
        String o = estado.getinput();
        perception.setoracion(o);
		return perception;
		
    }
    
    public String toString() {
        return environmentState.toString();
    }
    
    public boolean agentFailed(Action actionReturned) {
        return false;
    }
    
    /**
     * Metodo que agrega una nueva linea al log de chat.
     * @param Linea a agregar.
     */
    public void agregarLineaAlLog(String linea){
    	ChatbotEnvironmentState estado = this.getEnvironmentState();
    	estado.agregarLineaAlLog(linea);
    	this.setEnvironmentState(estado);
    }
    
    /**
     * Metodo que setea la linea ingresada por el usuario (ya 
     * preprocesada) en el estado del ambiente.
     * @param La línea preprocesada.
     */
    public void setInput(String o){
    	ChatbotEnvironmentState estado = this.getEnvironmentState();
    	estado.setinput(o);
    	this.setEnvironmentState(estado);    	
    }
    
    /**
     * Metodo que actualiza el estado del ambiente.
     */
    public void actualizar(String resp,boolean est){
    	ChatbotEnvironmentState estado = this.getEnvironmentState();
    	estado.actualizar(resp,est);
    	this.setEnvironmentState(estado);  
    }
    
    /**
     * Metodo que devuelve la respuesta.
     * @return
     */
    public String getRespuesta(){
    	ChatbotEnvironmentState estado = this.getEnvironmentState();
    	return estado.getrta();
    }
    
    /**
     * Metodo que devuelve el log del chat.
     * @return
     */
    public LinkedList<String> getlog(){
    	ChatbotEnvironmentState estado = this.getEnvironmentState();
    	return estado.getlog();
    }
    
    /**
     * Metodo que inicializa el estado del ambiente.
     * @param e
     */
    public void init(String e){
    	this.agregarLineaAlLog(e);
   		this.setInput(e);   		
   		this.borrarRta();   		
    }
    
    /**
     * Metodo que borra la respuesta.
     */
    private void borrarRta(){
    	ChatbotEnvironmentState estado = this.getEnvironmentState();
    	estado.borrarRta();
    	this.setEnvironmentState(estado);  
    }
    
    /**
     * Metodo que determina si el chatbot sigue o no conectado.
     * @return True si el chatbot no se despidió, False en otro caso.
     */
    public boolean chatbotVive(){
    	ChatbotEnvironmentState estado = this.getEnvironmentState();
    	return estado.getconectado();
    }
    
}
