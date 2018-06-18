package respuestas;

import java.util.Random;
import voz.TextToSpeech;

public class AdvertirNoResponder extends Respuesta {
    
    //Repeticion de las mismas palabras claves a partir de la cual cambia la respuesta (a la n repeticion ya cambia)
    private static final int CANTIDAD_REPETICIONES_LIMITE = 3;
    
    private String texto;
    private boolean fraseElegida;



    public AdvertirNoResponder() {
    
        this.fraseElegida = this.generateRandomResponse();
        
        if(fraseElegida){
            this.texto = "Hey! Don't answer that! This is our secret!";
        }
        else{
            this.texto = "You really should not answer that, kid!";
        }
        
    }
    
    public boolean isFraseElegida() {
        return fraseElegida;
    }

    public void setFraseElegida(boolean fraseElegida) {
        this.fraseElegida = fraseElegida;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    @Override
    public void ejecutar(int repeticionesPC){
        if(repeticionesPC < CANTIDAD_REPETICIONES_LIMITE){
            TextToSpeech.hablar(this.texto);
        }
        else{
            (new LlamarPadres()).ejecutar(repeticionesPC);
        }
    }
    
    @Override
    public String toString(int repeticionesPC){
        if(repeticionesPC < CANTIDAD_REPETICIONES_LIMITE){
            return this.texto;
        }
        else{
            return (new LlamarPadres()).toString(repeticionesPC);
        }
    }
    
    private boolean generateRandomResponse(){
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        Random r = new Random();
        double createdRanNum = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return(createdRanNum > 0.5);
    }
}
