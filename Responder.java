import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{   
    //atributo de tipo random
    private Random rnd = new Random();
    //atributo de tripo String
    private ArrayList<String> respuesta;
    //creo un hashmap
    HashMap<String,String> clave;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        rnd = new Random();
        respuesta = new ArrayList<String>();
        clave = new HashMap<String,String>();
        respuesta.add("Bienvenido al servicio técnico de DodgySoft");
        respuesta.add("Cuéntenos su problema");
        respuesta.add("Lo siento, no podemos ayudarle");
        respuesta.add("Suena interesante, cuéntenos más");
        respuesta.add("Por favor, repita de nuevo su pregunta");
        respuesta.add("Espere por favor");
        clave.put("espere", "ahora no podemos atenderle");
        clave.put("horario", "nuestro horario lo podrá encontrar el la web");
        clave.put("teléfono", "666666666");
        clave.put("correo", "dodgysoft@gmail.com");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String respuestas = null;
        for(String input : userInput){
            if(clave.containsKey(input)){
                respuestas = clave.get(input);
            }
            if(respuestas == null){
                respuestas = respuesta.get(rnd.nextInt(respuesta.size()));
            }
        }
        return respuestas;
    }
}
