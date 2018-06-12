package respuestas;

import voz.TextToSpeech;

public class Decir extends Respuesta {
    
    private String texto;

    public Decir(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    @Override
    public void ejecutar(int repeticionesPC){
        TextToSpeech.hablar(texto);
    }
    
    @Override
    public String toString(int repeticionesPC){
        return texto;
    }
    
}
