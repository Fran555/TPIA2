/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voz;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TextToSpeech {
    
    private static VoiceManager vm;
    private static Voice v;
    
    public static void hablar(String frase){
        try{
            if(vm == null){
                System.setProperty("mbrola.base", "mbrola");
                vm = VoiceManager.getInstance();
            }
            if(v == null){
                v = vm.getVoice("mbrola_us1");
            }
            v.allocate();
            v.speak(frase);
            v.deallocate();
        }
        catch(Exception ex){
            throw(ex);
        }
    }
    
}
