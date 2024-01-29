/*
Actualizar el ejercicio 4.2 para añadir a la clase Persona el siguiente comportamiento:

Debe retornar un saludo con su nombre... saludar():String
Debe retornar si altura por encima de la media (solo si altura >= 1.75)... alturaEncimaMedia():Boolean
Debe retornar si peso por encima de la media (solo si peso >= 70)... pesoEncimaMedia():Boolean
Sería conveniente añadir también un método obtenerDescImc() para usar en obtenerDesc(), que implemente el retorno de la descripción del rango de tipo de imc al que equivale su cálculo.
Nota: (Mejora: Enum class en https://www.baeldung.com/kotlin/enum) * Si el IMC es menos de 18.5, se encuentra dentro del rango de "peso insuficiente". * Si el IMC está entre 18.5 y 24.9, se encuentra dentro del rango de "peso saludable". * Si el IMC está entre 25.0 y 29.9, se encuentra dentro del rango de "sobrepeso". * Si el IMC es 30.0 o superior, se encuentra dentro del rango de "obesidad".

Debe implementar también un método que muestre una descripción completa de la persona... obtenerDesc():String. Por ejemplo, este método mostrará por pantalla algo así:

"Julia con una altura de 1.72m (Por debajo de la media) y un peso 64.7kg (Por encima de la media) tiene un IMC de 21,87 (peso saludable)".
2. Crear en el main() una estructura de datos con 4 o 5 personas más, recorrer la estructura y por cada persona debe saludar y mostrar su descripción completa.
Finalmente, revisa el IDE e intenta actualizar el modificador de visibilidad de los métodos de tu clase cómo os estará indicando... veréis que los métodos que realmente no van a ser llamados desde fuera de la clase te recomienda que sean privados a la misma. De esta manera estamos encapsulando estos métodos para que se puedan utilizar solo desde dentro de la clase y no sean públicos.

 */

/**
 * Programa principal que demuestra el uso de la clase Persona para representar
 * información sobre el peso, altura y nombre de diferentes personas.
 */
fun main(){
    // Crear una instancia de Persona con peso y altura especificados.
    val persona1 = PersonaEjer3(90.55, 1.93)

    println("*******************************************")
    // Modificar el nombre y mostrar la descripción de la persona.
    persona1.nombre = pideNombreAlUsuario()
    persona1.mostrarDesc()
    println(persona1.obtenerDesc())
    println(persona1.toString())

    // Modificar el peso y mostrar la descripción de la persona.
    persona1.peso = 57.7
    persona1.mostrarDesc()

    // Modificar la altura y mostrar la descripción de la persona.
    persona1.altura = 1.67
    persona1.mostrarDesc()

    // Crear una instancia de Persona con nombre, peso y altura especificados.
    val persona2 = damePersona()
    persona2.mostrarDesc()

    // Crear una instancia de Persona con nombre, altura y peso especificados.
    // Si cambiamos el orden, debemos especificar el nombre de los parámetros
    // que reciben los argumentos.
    val persona3 = PersonaEjer3("David", altura = 1.65, peso = 69.50)
    persona3.mostrarDesc()

    println("*******************************************")
    //Cuando mostramos en un print el nombre del objeto de tipo Persona,
    // por defecto lanza el método toString() de la clase
    //Esto ocurre también en el resto de tipos de datos...
    println("Persona 1: $persona1")
    println("Persona 2: $persona2")
    println("Persona 3: $persona3")

    println("*******************************************")
    println("Persona 1")
    println("nombre: ${persona1.nombre}")
    println("peso: ${persona1.peso}")
    println("altura: ${persona1.altura}")
    println("imc: ${persona1.imc}")

    println("*******************************************")
    println("Persona 3")
    println("peso: ${persona3.peso}")
    println("altura: ${persona3.altura}")
    println("imc: ${persona3.imc}")
    println("Modificado altura a 1.80 en P3")
    persona3.altura = 1.80
    println("Persona 3")
    println("peso: ${persona3.peso}")
    println("altura: ${persona3.altura}")
    println("imc: ${persona3.imc}")

    println("*******************************************")
    println("Persona 2")
    println("Modificado altura a 1.80 en P2")
    persona2.altura = 1.80
    println("Persona 2: $persona2")
    println("Persona 3: $persona3")
    println("Persona 2 y 3 ${if (persona3 == persona2) "iguales." else "distintas."}")

}

/**
 * Solicita el nombre de una persona hasta que introduzca un valor distinto de la cadena vacía.
 */
fun pideNombreAlUsuario(): String {
    var nombre:String
    do {
        print("Introduzca el nombre de la persona: ")
        nombre = readln()
    } while (nombre.isBlank())
    return nombre
}

/**
 * Solicita nombre, peso y altura de una persona hasta crear una instancia de Persona válida.
 */
fun damePersona(): PersonaEjer3 {
    var persona: PersonaEjer3? = null

    do {
        try {
            print("Introduzca el nombre: ")
            val nombre = readln()
            print("Introduzca el peso: ")
            val peso = readln().toDouble()
            print("Introduzca la altura: ")
            val altura = readln().toDouble()
            persona = PersonaEjer3(nombre, peso, altura)
        }
        catch (e: NumberFormatException) {
            println("**Error** peso y altura deben ser valores numéricos con decimales (Double).")
        }
        catch (e: IllegalArgumentException) {
            println("**Error** ${e.message}")
        }
    } while (persona == null)

    return persona
}