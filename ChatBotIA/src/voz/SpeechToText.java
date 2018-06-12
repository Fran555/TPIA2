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

public class SpeechToText {
    
    private static ConfigurationManager cm;
    private static Recognizer recognizer;
    private static Microphone microphone;
    
    public static String obtenerTexto(){
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
                    Result result = recognizer.recognize();

                    if (result != null) {
                        respuesta = result.getBestFinalResultNoFiller();
                    }
                    else {
                        System.out.println("No se ha podido entender lo que has dicho.");
                    }
                }
            }
            recognizer.deallocate();
        }
        catch(Exception ex){
            recognizer.deallocate();
            ex.printStackTrace();
        }
        return respuesta;
    }
    
}
