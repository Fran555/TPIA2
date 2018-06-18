package respuestas;

import java.util.Random;
import voz.TextToSpeech;

public class AdvertirNoResponder extends Respuesta {
    
    //Repeticion de las mismas palabras claves a partir de la cual cambia la respuesta (a la n repeticion ya cambia)
    private static final int CANTIDAD_REPETICIONES_LIMITE = 3;
    private String texto;
    
    public AdvertirNoResponder() {
        setTexto();
    }
    
    public void setTexto() {
        
        double valor = this.generateRandomNumber();
        String textoRespuesta = "";
        
        if(valor <= 0.10){
            textoRespuesta = "Hey! Don't answer that! This is our secret!";
        }
        if(valor > 0.10 && valor <= 0.20){
            textoRespuesta = "Ask mom and dad before saying something about that!";
        }
        if(valor > 0.20 && valor <= 0.30){
            textoRespuesta = "You really should not answer that, kid!";
        }
        if(valor > 0.30 && valor <= 0.40){
            textoRespuesta = "Don't say a word about that! Don't answer! Pleeease!";
        }
        if(valor > 0.40 && valor <= 0.50){
            textoRespuesta = "Don't answer that! I'm asking you as a friend!";
        }
        if(valor > 0.50 && valor <= 0.60){
            textoRespuesta = "Mom and dad would not want you to answer that!";
        }
        if(valor > 0.60 && valor <= 0.70){
            textoRespuesta = "A good friend of mine would never answer that...";
        }
        if(valor > 0.70 && valor <= 0.80){
            textoRespuesta = "Remember that good friends don't say those things to strangers!";
        }
        if(valor > 0.80 && valor <= 0.90){
            textoRespuesta = "Say you can't answer to that! That's what a best friend would do!";
        }
        if(valor > 0.90 && valor <= 1){
            textoRespuesta = "Shh! That's one of our secrets as best friends! Don't say anything!";
        }
        
       this.texto = textoRespuesta;
    }
    
    public String getTexto()
    {
        return this.texto;
    }
    
    @Override
    public void ejecutar(int repeticionesPC){
        if(repeticionesPC < CANTIDAD_REPETICIONES_LIMITE){
            TextToSpeech.hablar(this.getTexto());
        }
        else{
            (new LlamarPadres()).ejecutar(repeticionesPC);
        }
    }
    
    @Override
    public String toString(int repeticionesPC){
        if(repeticionesPC < CANTIDAD_REPETICIONES_LIMITE){
            return this.getTexto();
        }
        else{
            return (new LlamarPadres()).toString(repeticionesPC);
        }
    }
    
    private double generateRandomNumber(){
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        Random r = new Random();
        return rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }
}
