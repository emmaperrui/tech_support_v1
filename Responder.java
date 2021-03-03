import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael Kölling and David J. Barnes
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
    //hashmap secundario
    HashMap<HashSet<String>,String> respuestaAuxiliar;
    //respuesta 1
    HashSet<String> respuesta1;
    //respuesta 2
    HashSet<String> respuesta2;
    //respuesta 3
    HashSet<String> respuesta3;
    //respuesta 4
    HashSet<String> respuesta4;

    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        rnd = new Random();
        respuesta = new ArrayList<String>();
        clave = new HashMap<String,String>();
        respuesta1 = new HashSet<String>();
        respuesta2 = new HashSet<String>();
        respuesta3 = new HashSet<String>();
        respuesta4 = new HashSet<String>();
        respuestaAuxiliar = new HashMap<HashSet<String>, String>();
        respuesta.add("Bienvenido al servicio t�cnico de DodgySoft");
        respuesta.add("Cu�ntenos su problema");
        respuesta.add("Lo siento, no podemos ayudarle");
        respuesta.add("Suena interesante, cu�ntenos m�s");
        respuesta.add("Por favor, repita de nuevo su pregunta");
        respuesta.add("Espere por favor");
        clave.put("espere", "ahora no podemos atenderle");
        clave.put("horario", "nuestro horario lo podr� encontrar el la web");
        clave.put("tel�fono", "666666666");
        clave.put("correo", "dodgysoft@gmail.com");
        respuesta1.add("necesito");
        respuesta1.add("m�s");
        respuesta1.add("informaci�n");
        respuesta2.add("adi�s");
        respuesta3.add("hola");
        respuesta4.add("gracias");
        respuesta4.add("por");
        respuesta4.add("la");
        respuesta4.add("informaci�n");
        respuestaAuxiliar.put(respuesta1, "Para m�s informaci�n busque nuestro cat�logo de ofertas");
        respuestaAuxiliar.put(respuesta2, "Buenas tardes");
        respuestaAuxiliar.put(respuesta3, "Buenos d�as");
        respuestaAuxiliar.put(respuesta4, "�Qu� tenga un buen d�a!");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String respuestas = null;
        if(respuestaAuxiliar.containsKey(userInput)){
            respuestas = respuestaAuxiliar.get(userInput);
        }
        if(respuestas == null){
            respuestas = respuesta.get(rnd.nextInt(respuesta.size()));
        }
        return respuestas;
    }
}
