import java.util.Random;
import java.util.ArrayList;

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

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        respuesta = new ArrayList<String>();
        respuesta.add("Bienvenido al servicio técnico de DodgySoft");
        respuesta.add("Cuéntenos su problema");
        respuesta.add("Lo siento, no podemos ayudarle");
        respuesta.add("Suena interesante, cuéntenos más");
        respuesta.add("Por favor, repita de nuevo su pregunta");
        respuesta.add("Espere por favor");
        rnd = new Random();
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse()
    {
        return respuesta.get(rnd.nextInt(respuesta.size()));
    }
}
