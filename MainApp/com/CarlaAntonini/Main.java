package com.CarlaAntonini;

public class Main {
    public static void main(String[] args) {

        // Creo una instancia de la clase Saludo para poder usarla
        Saludo saludo = new Saludo();

        // Imprimir el saludo con el nombre almacenado en la variable
        System.out.println("Hola mi nombre es " + nombre);

        // Creo una instancia de la clase Operacion para poder usarla
        Operacion operacion = new Operacion();

        // Invoco al método crearOperacion() para poder obtener números del usuario
        operacion.crearOperacion();

        // Accedo a los números que ingresamos
        double numero1 = operacion.getNumero1();
        double numero2 = operacion.getNumero2();

        // Realizar operaciones con los números según tus necesidades
        double suma = operacion.sumar();
        double resta = operacion.restar();
        double multiplicacion = operacion.multiplicar();
        double division = operacion.dividir();

        // Imprimir resultados
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);



    }
}

