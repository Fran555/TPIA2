package logica;

import java.util.List;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import reglas.ReglaDato;

public class Utils{
    
    public static int obtenerRepeticionesPalabrasClaves(List<ReglaDato> reglasDatos, List<String> palabrasClaves){
        int repeticiones = 0;
        for(ReglaDato reglaDato : reglasDatos){
            if(coincidenPalabrasClaves(reglaDato.getPalabrasClaves(), palabrasClaves)){
                repeticiones++;
            }
        }
        return repeticiones;
    }
    
    public static boolean coincidenPalabrasClaves(List<String> pcu, List<String> pc){
        boolean coincide = true;
        //Verifica que la  lista de palabras claves de la entrada (pc) contenga todas las palabras de la lista de palabras del objeto ReglaDato obtenido de la lista de reglas usadas por el agente (pcu)
        for(String palabra : pcu){
            if(!pc.contains(palabra)){
                coincide = false;
                break;
            }
        }
        //Verifica que la lista de palabras del objeto ReglaDato obtenido de la lista de reglas usadas por el agente (pcu) contenga todas las palabras de la lista de palabras claves de la entrada (pc)
        for(String palabra : pc){
            if(!pcu.contains(palabra)){
                coincide = false;
                break;
            }
        }
        return coincide;
    }
    
    public static void escribirDocumento(StyledDocument doc, String texto, SimpleAttributeSet estilo) throws Exception{
        try{
            doc.insertString(doc.getLength(), texto, estilo);
            doc.setParagraphAttributes(doc.getLength() - 1, 1, estilo, false);
        }
        catch(Exception ex){
            throw ex;
        }
    }
  
}
