package com.CarlaAntonini;

import java.util.Scanner;

import com.CarlaAntonini.FormaRectangulo;
import com.CarlaAntonini.FormaCirculo;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {

        // Creo una instancia de la clase Saludo para poder usarla
        Saludo saludo = new Saludo();

        // Almacenar el nombre en una variable
        String nombre = "Carla Antonini";

        // Imprimir el saludo con el nombre almacenado en la variable
        System.out.println("Hola mi nombre es " + nombre);


        // Creo una instancia de la clase Operacion para poder usarla
        Operacion operacion = new Operacion();

        scanner = new Scanner(System.in);

        realizarOperacionesMatematicas(scanner);

        // Programa de la clase Cuenta
        ejecutarProgramaCuenta();

        // Ejecutar programa de formas geométricas
        ejecutarProgramaFormasGeometricas();



        scanner.close();
    }

    private static void realizarOperacionesMatematicas(Scanner scanner) {
        Operacion operacion = new Operacion();

        // Bucle para realizar varias operaciones
        while (true) {
            mostrarMenuOperaciones();

            // Obtener la operación deseada
            int opcion = scanner.nextInt();

            if (opcion == 0) {
                // Salir del bucle si la opción es 0
                break;
            }

            // Realizar la operación correspondiente
            operacion.crearOperacion();
            double resultado = realizarOperacion(opcion, operacion);

            // Mostrar el resultado
            System.out.println("Resultado: " + resultado);
        }
    }

    private static void mostrarMenuOperaciones() {
        System.out.println("Seleccione una operación:");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("0. Salir");
        System.out.print("Ingrese el número de la operación deseada: ");
    }

    private static double realizarOperacion(int opcion, Operacion operacion) {
        switch (opcion) {
            case 1:
                return operacion.sumar();
            case 2:
                return operacion.restar();
            case 3:
                return operacion.multiplicar();
            case 4:
                return operacion.dividir();
            default:
                System.out.println("Opción no válida. Por favor, elija una operación válida.");
                return 0;
        }
    }

    private static void ejecutarProgramaCuenta() {

        // Solicitar datos al usuario para crear la cuenta
        System.out.print("Ingrese el número de cuenta: ");
        int numeroCuenta = scanner.nextInt();

        System.out.print("Ingrese el DNI del cliente: ");
        int dniCliente = scanner.nextInt();

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Ingrese la tasa de interés: ");
        double tasaInteres = scanner.nextDouble();

        // Crear una instancia de la clase Cuenta con los datos ingresados por el usuario
        Cuenta cuenta = new Cuenta(numeroCuenta, dniCliente, saldoInicial, tasaInteres);

        // Realizar algunas operaciones con la cuenta
        cuenta.extraccionRapida();
        cuenta.depositar(500.0);

        // Mostrar información de la cuenta
        cuenta.mostrarInformacion();
        System.out.printf("Saldo actual: " + cuenta.consultarSaldo());
    }


    private static void ejecutarProgramaFormasGeometricas() {
        // Crear instancias de formas geométricas
        FormaCirculo circulo = new FormaCirculo(5);
        FormaRectangulo rectangulo = new FormaRectangulo(3, 4);

        // Calcular y mostrar áreas y perímetros
        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Perímetro del círculo: " + circulo.calcularPerimetro());

        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        System.out.println("Perímetro del rectángulo: " + rectangulo.calcularPerimetro());
    }



}
