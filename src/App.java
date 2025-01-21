public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}

// 15)

// Nos piden realizar una agenda telefónica de contactos.

// Un contacto está definido por un nombre y un teléfono (No es necesario de
// validar). Un contacto es igual a otro cuando sus nombres son iguales.

// Una agenda de contactos está formada por un conjunto

// de contactos (Piensa en que tipo puede ser)

// Se podrá crear de dos formas, indicándoles nosotros el tamaño o con un tamaño
// por defecto (10)

// Los métodos de la agenda serán los siguientes:

// aniadirContacto(Contacto c): Añade un contacto a la agenda, sino se pueden
// meter más a la agenda se indicara por pantalla. No se pueden meter contactos
// que existan, es decir, no podemos duplicar nombres, aunque tengan distinto
// teléfono.

// existeContacto(Conctacto c): indica si el contacto pasado existe o no.
// listarContactos(): Lista toda la agenda

// buscaContacto(String nombre): busca un contacto por su nombre y muestra su
// teléfono.

// eliminarContacto(Contacto c): elimina el contacto de la agenda, indica si se
// ha eliminado o no por pantalla
// agendaLlena(): indica si la agenda está llena.
// huecosLibres(): indica cuantos contactos más podemos meter.
// Crea un menú con opciones por consola para probar todas estas
// funcionalidades.

// Spoiler
// 16) Vamos a hacer unas mejoras a la clase Baraja del ejercicio 5 de POO de
// los videos.

// Lo primero que haremos es que nuestra clase Baraja será la clase padre y será
// abstracta.

// Le añadiremos el número de cartas en total y el número de cartas por palo.

// El

// método crearBaraja() será abstracto.

// La clase Carta tendrá un atributo genérico que será el palo de nuestra
// versión anterior.

// Creamos dos Enum:

// PalosBarEspañola:
// OROS
// COPAS
// ESPADAS
// BASTOS
// PalosBarFrancesa:
// DIAMANTES
// PICAS
// CORAZONES
// TREBOLES
// Creamos dos clases hijas:

// BarajaEspañola: tendrá un atributo boolean para indicar si queremos jugar con
// las cartas 8 y 9 (total 48 cartas)

// o no (total 40 cartas).
// BarajaFrancesa: no tendrá atributos, el total de cartas es 52 y el número de
// cartas por palo es de 13. Tendrá dos métodos llamados:

// cartaRoja(Carta<PalosBarFrancesa> c): si el palo es de corazones y diamantes.

// cartaNegra(Carta<PalosBarFrancesa> c): si el palo es de tréboles y picas.
// De la carta modificaremos el

// método toString()

// Si el palo es de tipo PalosBarFrancesa:

// La carta número 11 será Jota
// La carta numero 12 será Reina
// La carta numero 13 será Rey
// La carta numero 1 será As
// Si el palo es de tipo PalosBarFrancesa:

// La carta numero 10 será Sota
// La carta numero 12 será Caballo
// La carta numero 13 será Rey
// La carta numero 1 será As
// Spoiler
// 17)

// Una academia nos pide hacer un programa para hacer un pequeño test a sus
// alumnos.

// Estas preguntas, para facilitar la inclusión, estarán escritas en

// un txt (incluido en la descarga del proyecto).

// Una opción se compone de:

// El texto de la

// opción (digamos la respuesta)
// Es correcto o no
// Una pregunta consta de:

// Pregunta (tendrá delante dos puntos y coma ;P;)
// Opciones de

// la pregunta (entre 2 y 4)

// Opción correcta (tendrá delante dos puntos y coma ;R;)
// Puntos
// La pregunta no será válida en los siguientes casos:

// Las opciones no están entre 2 y 4.
// La opción correcta esta entre el número de opciones y es un número.
// Los puntos es un número entero.
// Sus métodos son:

// mostrarPregunta(): muestra la pregunta con sus opciones.

// comprobarRespuesta(int respuestaUsuario): comprueba la respuesta del usuario
// si es correcta o no.
// Getter de los atributos.
// Un test está formado por un conjunto preguntas y los puntos acumulados.
// Piensa que debemos saber por cual pregunta vamos.

// Sus métodos son:

// cargarPreguntas(String fichero): carga todas las preguntas del fichero
// siguientePregunta(): devuelve la siguiente pregunta
// reiniciarTest(): nos permite reiniciar el test.
// realizarTest(): empieza el test y empieza a formular las preguntas
// El fichero de preguntas tiene el siguiente formato:

// ;P;Pregunta 1

// Opción 1 pregunta 1

// Opción 2 pregunta 1

// Opción 3 pregunta 1

// Opción 4 pregunta 1

// ;R;Numero opción correcta

// Puntos pregunta 1

// ;P;Pregunta 2

// Opción 1 pregunta 2

// Opción 2 pregunta 2

// …
