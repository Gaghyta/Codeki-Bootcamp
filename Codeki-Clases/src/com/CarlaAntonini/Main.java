package com.CarlaAntonini;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Creo una instancia de la clase Saludo para poder usarla
        Saludo saludo = new Saludo();

        // Almacenar el nombre en una variable
        String nombre = "Carla Antonini";

        // Imprimir el saludo con el nombre almacenado en la variable
        System.out.println("Hola mi nombre es " + nombre);


        // Creo una instancia de la clase Operacion para poder usarla
        Operacion operacion = new Operacion();

        Scanner scanner = new Scanner(System.in);

        // Menú interactivo
        int opcion;
        do {
            System.out.println("\nSeleccione una operación:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("0. Salir");

            System.out.print("Ingrese el número de la operación deseada: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    operacion.crearOperacion();
                    double suma = operacion.sumar();
                    System.out.println("Suma: " + suma);
                    break;
                case 2:
                    operacion.crearOperacion();
                    double resta = operacion.restar();
                    System.out.println("Resta: " + resta);
                    break;
                case 3:
                    operacion.crearOperacion();
                    double multiplicacion = operacion.multiplicar();
                    System.out.println("Multiplicación: " + multiplicacion);
                    break;
                case 4:
                    operacion.crearOperacion();
                    double division = operacion.dividir();
                    System.out.println("División: " + division);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);

        // Cerrar el Scanner después de usarlo
        scanner.close();
    }


        /*//SUMAR

        // Invoco al método crearOperacion() para poder obtener números del usuario
        operacion.crearOperacion();

        // Accedo a los números que ingresamos
        double numero1 = operacion.getNumero1();
        double numero2 = operacion.getNumero2();
        double suma = operacion.sumar();
        System.out.println("Suma: " + suma);

        //RESTAR

        operacion.crearOperacion();

        // Ingresamos
        double numero3 = operacion.getNumero1();
        double numero4 = operacion.getNumero2();
        double resta = operacion.restar();
        System.out.println("Resta: " + resta);

        //MULTIPLICACION

        operacion.crearOperacion();

        // Ingresamos
        double numero5 = operacion.getNumero1();
        double numero6 = operacion.getNumero2();
        double multiplicacion = operacion.multiplicar();
        System.out.println("Multiplicación: " + multiplicacion);


        //DIVISION

        operacion.crearOperacion();
        // Ingresamos

        double numero7 = operacion.getNumero1();
        double numero8 = operacion.getNumero2();
        double division = operacion.dividir();
        System.out.println("División: " + division);}*/




}
