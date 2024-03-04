import java.util.Scanner;

public class Operacion {

    // 1- Hacer los atributos pedidos en consigna como privados
    private double numero1;
    private double numero2;


    //2- Hacer  el método constructor con todos los atributos pasados por parámetro

    public Operacion(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }


    //3- Hacer le método constructor sin los atributos pasados por parámetro.
    public Operacion() {
    }

    //4- Hacer los getters y setters de los atributos

    public double getNumero1() {
        return numero1;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }


    // Realizo el método que pida dos números al usuario para hacer la operación deseada
    public void crearOperacion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el primer número: ");
        this.numero1 = scanner.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        this.numero2 = scanner.nextDouble();

        scanner.close();
    }
}
