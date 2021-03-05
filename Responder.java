import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
    //respuesta 5
    HashSet<String> respuesta5;
    //respuesta 6
    HashSet<String> respuesta6;
    //para evitar repeticiones de palabras
    private String userInputRepetido;

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
        respuesta5 = new HashSet<String>();
        respuesta6 = new HashSet<String>();
        respuestaAuxiliar = new HashMap<HashSet<String>, String>();
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
        respuesta1.add("necesito");
        respuesta1.add("más");
        respuesta1.add("información");
        respuesta2.add("adiós");
        respuesta3.add("hola");
        respuesta4.add("gracias");
        respuesta4.add("por");
        respuesta4.add("la");
        respuesta4.add("información");
        respuesta5.add("linux");
        respuesta5.add("crash");
        respuesta5.add("problem");
        respuesta6.add("windows");
        respuesta6.add("corrupt");
        respuesta6.add("problem");
        respuestaAuxiliar.put(respuesta1, "Para más información busque nuestro catálogo de ofertas");
        respuestaAuxiliar.put(respuesta2, "Buenas tardes");
        respuestaAuxiliar.put(respuesta3, "Buenos días");
        respuestaAuxiliar.put(respuesta4, "¡Qué tenga un buen día!");
        respuestaAuxiliar.put(respuesta5, "Sí");
        respuestaAuxiliar.put(respuesta6, "No");
        userInputRepetido = "";
    }

    /**
     * genera una respuesta en función de la pregunta introducida
     */
    public String generateResponse(HashSet<String> userInput){
        String resultado = "";
        int coincidenciasGeneral = 0; 
        for(HashSet<String> palabrasRespuestas : respuestaAuxiliar.keySet()){
            int coincidenciasVuelta = 0;
            for(String palabraRespuesta : palabrasRespuestas){
                if(userInput.contains(palabraRespuesta)){
                    coincidenciasVuelta++;
                    if(coincidenciasVuelta > coincidenciasGeneral){
                        resultado = respuestaAuxiliar.get(palabrasRespuestas);
                        coincidenciasGeneral = coincidenciasVuelta;
                    }
                }
            }
        }
        if(userInputRepetido.equals(resultado)){
            resultado = respuesta.get(rnd.nextInt(respuesta.size()));
        }
        if(resultado == null){
            resultado = respuesta.get(rnd.nextInt(respuesta.size()));
        }
        userInputRepetido = resultado;
        return resultado;
    }
}
