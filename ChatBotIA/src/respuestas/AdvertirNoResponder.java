package respuestas;

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
            TextToSpeech.hablar("You might not answer this...");
        }
        else{
            (new LlamarPadres()).ejecutar(repeticionesPC);
        }
    }
    
    @Override
    public String toString(int repeticionesPC){
        if(repeticionesPC < CANTIDAD_REPETICIONES_LIMITE){
            return "You might not answer this...";
        }
        else{
            return (new LlamarPadres()).toString(repeticionesPC);
        }
    }
    
}
