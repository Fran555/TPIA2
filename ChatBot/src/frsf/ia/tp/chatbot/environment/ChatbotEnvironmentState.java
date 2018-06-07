package frsf.ia.tp.chatbot.environment;

import java.util.LinkedList;

import frsf.cidici.faia.solver.productionsystem.PeerRuleData;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp.chatbot.agent.ChatbotState;
import frsf.ia.tp.chatbot.graph.Regla;

/**
 * Esta clase representa el estado del ambiente del ChatBot.
 * @author Grupo 12: Blas,María Julia / Diaz Ferreyra,Nicolas/ Sarli, Juan Leonardo.
 */
public class ChatbotEnvironmentState extends EnvironmentState {
	
	private LinkedList<String> log;
    private String input;
    private String rta;
    private boolean conectado;

    /**
     * Constructor.
     */
    public ChatbotEnvironmentState() {
        log = new LinkedList<String>();
    	rta = "";
    	conectado = true;
    }

    /**
     * This method is used to setup the initial real world.
     */
    @Override
    public void initState() {
    }

    /**
     * String representation of the real world state.
     */
    @Override
    public String toString() {
        String str = "Input: " + input.toString() + " - Respuesta: " + rta + " - Conectado: " + conectado + "\n";
        return str;
    }

    // The following methods are agent-specific.
     public LinkedList<String> getlog(){
        return log;
     }
     
     public void setlog(LinkedList<String> arg){
        log = arg;
     }	
     
     public String getinput(){
         return input;
     }
     
     public void setinput(String arg){
         input = arg;
     }

     public String getrta(){
         return rta;
     }
     
     public void setrta(String arg){
         rta = arg;
     }

     public void agregarLineaAlLog(String linea){
    	 log.addLast(linea);
     }
     
     /**
      * Metodo que actualiza la respuesta y el log de chat.
      * @param resp
      */
     public void actualizar(String resp,boolean est){
    	 rta = resp;
    	 conectado = est;
    	 if (resp!=null) this.agregarLineaAlLog(resp);
     }
     
     /**
      * Metodo que borra la respuesta.
      */
     public void borrarRta(){
    	 rta = "";
     }
     
     /**
      * Metodo que devuelve el valor de conectado.
      * @return True o False.
      */
     public boolean getconectado(){
    	 return conectado;
     }
     
     /**
      * Metodo que actualiza el estado del ambiente.
      */
     public void update(AgentState ag,PeerRuleData r){
     	Regla reg = (Regla) ((PeerRuleData) r).getRule();
     	ChatbotState ch = (ChatbotState) ag;
    	actualizar(reg.getRespuesta(),!ch.seDespidio());
     }
     
}

