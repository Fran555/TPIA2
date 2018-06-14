package respuestas;

import java.util.Random;
import voz.TextToSpeech;

public class AdvertirNoResponder extends Respuesta {
    
    //Repeticion de las mismas palabras claves a partir de la cual cambia la respuesta (a la n repeticion ya cambia)
    private static final int CANTIDAD_REPETICIONES_LIMITE = 3;
    
    private String texto;

    public AdvertirNoResponder() {

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
            if(generateRandomResponse()){
                TextToSpeech.hablar( "Hey! Don't answer that! This is our secret!");
            }
            else{
                TextToSpeech.hablar("You really should not answer that, kid!");
            }
        }
        else{
            (new LlamarPadres()).ejecutar(repeticionesPC);
        }
    }
    
    @Override
    public String toString(int repeticionesPC){
        if(repeticionesPC < CANTIDAD_REPETICIONES_LIMITE){
            if(generateRandomResponse()){
                return "Hey! Don't answer that! This is our secret!";
            }
            else{
                return "You really should not tell that, kid!";
            }
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
