public class Main {
    public static void main(String[] args) {
        // Almacenar el nombre en una variable
        String nombre = "Carla Antonini";

        // Imprimir el saludo con el nombre almacenado en la variable
        System.out.println("Hola mi nombre es " + nombre);


        // Creo una instancia de la clase Operacion para poder usarla
        Operacion operacion = new Operacion();

        // Invoco al método crearOperacion() para poder obtener números del usuario
        operacion.crearOperacion();

        // Accedo a los números que ingresamos
        double numero1 = operacion.getNumero1();
        double numero2 = operacion.getNumero2();


    }
}