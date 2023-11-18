import java.util.Random;
import java.util.Scanner;

public class AhorcadoRandom {
    public static void main(String[] args) {
        /*
         * Utilizando los conocimientos obtenidos hasta ahora, vamos a desarrollar el juego el
         * ahorcado. El programa deberá funcionar de la siguiente forma.
         * Primero, pide al usuario la palabra que hay que adivinar.
         * Después comenzará el juego.
         * El programa imprime tantas barras bajas como letras tiene la palabra, para que el
         * segundo usuario sepa cuántas letras tiene la palabra a adivinar.
         * A continuación, el programa tendrá que ir pidiendo letras:
         * 
         * - Si la letra está en la palabra, se muestra en su posición correspondiente.
         * - Si la letra no está, se cuenta un fallo.
         * - Cuando se falle 7 veces, el jugador ha perdido la partida.
         * - Si se han acertado todas las letras de la palabra, el jugador ha ganado la partida.
         */

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("\033[H\033[2J");
        /*
        * System.out.flush();
        * lo he encontrado en:
        * https://es.stackoverflow.com/a/529860
        * sirve para borrar la consola
        */

        //System.out.println("Palabra a adivinar: ");
        //String palabra = scanner.nextLine();
        // pide la palaba que hay que adivinar

        String palabra[] = {"hola", "mordekaiser", "flecha", "kindred", "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo", "adios", "movil", "coche", "mac", 
        "apple", "agua", "botella", "nubes", "pelicula", "serie", "raton", "teclado", "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", 
        "noviembre", "diciembre", "disco duro", "pila", "boton", "persiana", "ventana", "minecraft", "league of legends", "ajedrez", "old school runescape", "netflix", "imgur", "reddit", 
        "competicion", "libro", "programacion", "java", "android", "iphone", "daniels laizans", ""};
        // de ahí cogerá una palabra aleatoria
        System.out.println("\033[H\033[2J"); // borra la consola

        int numeroRandom = random.nextInt(palabra.length);
        // guarda un número aleatorio

        String palabraParaAdivinar = palabra[numeroRandom];
        /*
         * guarda en palabraAdivinar lo que esté en la posición 
         * numeroRandom dentro de palabra[]
         */

        String palabraAdivinar[] = new String[palabraParaAdivinar.length()];
        
        //String palabraAdivinar[] = new String[palabra.length];
        // crea el arraypalabraAdivinar con el tamaño de palabra.lenght

        boolean repetir = true;
        /*
         * sirve para luego cambiarlo cuando ya no se tenga que repetir
         * más el bucle principal
         */
        int fallos = 0;
        // para ir contando los fallos
        
        boolean arrayLleno = false;
        /*
         * sirve para saber si el array palabraAdivinar[] está ya lleno
         * de _ o no
         */
        boolean asignar = true;
        // sirve para hacer o no un if que hay en el segundo dowhile
        
        System.out.println("\033[H\033[2J"); // borra la consola

        String fallosLetras = "";
        /*
         * este string es para guardar la letras que no están 
         * en la palabra que hay que adivinar
         */

         
        boolean letrasDobles = false;
        System.out.println(letrasDobles);
        /*
         * lo imprimo para que no salga que la variable
         * no se está usando
         */
        System.out.println("\033[H\033[2J"); // borra la consola

        do { // bucle principal
            if (arrayLleno == false) {
                for (int i = 0; i < palabraAdivinar.length; i++) {
                    palabraAdivinar[i] = "_";
                    // llena el array de _
                }
                
                for (int i = 0; i < palabraAdivinar.length; i++) {
                    System.out.print(palabraAdivinar[i] + " ");
                    // imprime palabraAdivinar[]
                }
                arrayLleno = true;
                /*
                * cambia a false para que en la siguiente vuelta 
                * no lo vuelva a hacer porque borraría lo que hará
                * ahora más abajo
                */
            }
            
            if (fallos == 0) {
                System.out.println();
            }
            /*
            * este if es porque me molesta que haya una línea
            * en blanco de más cuando enseña la línea de los fallos
            * y las letras
            * _ _ _ _ _ _ _ _ _
            * 
            * Letra:
             * 
             * así está bien pero cuando tienes un fallo hace esto:
             * _ _ _ _ _ _ _ _ _
             * 
             * Fallos = 1
             * Letras: l
             * 
             * 
             * Letra:
             * 
             * mete dos líneas vacías...
             * 
             * _ _ _ _ _ _ _ _ _
             * 
             * Fallos = 1
             * Letras: l
             * 
             * Letra:
             * 
             * ahora si
             */
            
            System.out.println();
            System.out.println("Letra: ");
            String letra = scanner.nextLine().toLowerCase();
            // pide la letra al segundo usuario
            /*
             * antes estaba con .next, ahora está con .nextLine
             * para que pueda meter espacios
             */
            if (letra.length() != 1 ) {
                letrasDobles = true;
                System.out.println("Has introducido más de una letra, vuelve a intentarlo.");
                continue;
            }
            
            int posicion = 0;
            String palabraSinLetrasRepetidas = palabraParaAdivinar;
            
            do {
                if (palabraSinLetrasRepetidas.trim().toLowerCase().contains(letra.trim().toLowerCase())) {
                    posicion = palabraSinLetrasRepetidas.trim().toLowerCase().indexOf(letra);
                    palabraSinLetrasRepetidas = palabraSinLetrasRepetidas.replaceFirst(letra, "-");
                    
                    /*
                    * si palabraSinLetrasRepetidas (sin espacios y en minúscula) 
                    * tiene letra (sin espacios y en minúscula)
                    * si es verdad entra en el if y guarda en posicion
                    * el número en el que estaba letra dentro de palabraSinLetrasRepetidas
                    * 
                    * luego cambia la primera letra por un - y lo guarda otra vez en 
                    * palabraSinLetrasRepetidas
                    */
                    if (asignar == true) { // si asignar vale true entra
                        for (int i = 0; i < palabraAdivinar.length; i++) {
                            if (i == posicion)
                            palabraAdivinar[i] = letra;
                        }
                    /*
                     * este if es para guardar la letra en la posición de palabraAdivinar[]
                     * en la que tenga que estar, lo repite entero y si la i vale lo mismo
                     * que posicion guarda la letra
                     */
                    }

                }else{
                    fallos++;
                    asignar = false;

                    if (fallosLetras.contains(letra))
                        continue;
                    else
                        fallosLetras = fallosLetras + letra + " ";
                    /*
                    * sino suma un fallo
                    * y asignar lo pone en falso
                    *
                    * no sé porque puse lo de asignar, creo que no sirve para nada
                    * 
                    * el if es para que no guarde más de una vez la misma letra
                    * si vuelve a meter la misma que ya había escrito antes y que
                    * estaba mal
                    */
                }

            } while (palabraSinLetrasRepetidas.contains(letra));
            /*
             * repite esto mientras que en palabraSinLetrasRepetidas siga teniendo letra dentro
             * porque durante el bucle las va cambiando por -
             */

            System.out.println("\033[H\033[2J"); // borra la consola


            for (int i = 0; i < palabraAdivinar.length; i++) {
                System.out.print(palabraAdivinar[i] + " ");
                // imprime palabraAdivinar[]
            }

            for (int i = 0; i < palabraAdivinar.length; i++) {
                if (palabraAdivinar[i].contains("_")) {
                    repetir = true;
                    break;
                }
                    else {
                        repetir = false;
                    }
                /*
                 * repite durante el tamaño de palabraAdivinar
                 * si en palabraAdivinar[i] hay un guión repetir lo pone en true
                 * y se sale del for
                 * sino repetir lo pone en false y se acabaría el programa
                 */
            }

            if (fallos != 0) {
                System.out.println();
                System.out.println();
                System.out.println("Fallos = " + fallos);
                System.out.println("Letras: " + fallosLetras);

                /*
                 * esto solo lo muestra cuando fallos valga más de 0
                 * escribe los fallos que lleva y las letras que ha probado
                 * que están mal
                 */
            }

            asignar = true;

        } while (repetir == true && fallos < 7);
        /*
         * repite el bucle principal mientra que repetir valga true
         * y tenga menos de 7 fallos, al séptimo se acaba
         */

        if (fallos == 7) {
            System.err.println();
            System.out.println("No tienes más intentos");
            System.out.println();
            System.out.println("La palabra era: " + palabraParaAdivinar);
            // y al no tener más intentos muestra esto
        }

        scanner.close();
    }
}