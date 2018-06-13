/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voz;

import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import logica.Agente;
import logica.PreProcesador;
import logica.Utils;
import respuestas.Respuesta;

public class SpeechToText {
    
    private static ConfigurationManager cm;
    private static Recognizer recognizer;
    private static Microphone microphone;
    
    public static void obtenerTexto(Agente agente){
        String respuesta = "";
        try{
            if(cm == null && recognizer == null){
                cm = new ConfigurationManager(SpeechToText.class.getResource("new.xml"));
                recognizer = (Recognizer) cm.lookup("recognizer");
                microphone = (Microphone) cm.lookup("microphone");
            }
            recognizer.allocate();
            if(!microphone.isRecording()){
                if (!microphone.startRecording()) {
                    System.out.println("No se pudo iniciar el microfono.");
                    recognizer.deallocate();
                }
                else{
                    
                    while (true) {

                        Result result = recognizer.recognize();

                        if (result != null) {
                            respuesta = result.getBestFinalResultNoFiller();
                            if(respuesta != ""){
                                SpeechToText.obtenerRespuestas(agente, respuesta);
                            }
                            System.out.println("You said: " + respuesta + '\n');
                        }
                        else {
                            System.out.println("No se ha podido entender lo que has dicho.");
                        }
                    
                    }
                }
            }
            recognizer.deallocate();
        }
        catch(Exception ex){
            recognizer.deallocate();
            ex.printStackTrace();
        }
    }
    
    
    private static void obtenerRespuestas(Agente agente, String textoEntrada){
        try{
            if(!textoEntrada.trim().equals("")){
                int repeticionesPalabrasClaves;
                for(Respuesta respuesta : agente.generarRespuesta(textoEntrada)){
                    repeticionesPalabrasClaves = Utils.obtenerRepeticionesPalabrasClaves(agente.getReglaDatoUsadas(), PreProcesador.obtenerPalabras(textoEntrada));
                    respuesta.ejecutar(repeticionesPalabrasClaves);
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
