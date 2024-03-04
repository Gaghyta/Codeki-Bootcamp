package com.CarlaAntonini;

public class Cuenta {

        private int numeroCuenta;
        private int dniCliente;
        private double saldoActual;

        private double interes;

        // Constructor
        public Cuenta(int numeroCuenta, int dniCliente, double saldoInicial) {
            this.numeroCuenta = numeroCuenta;
            this.dniCliente = dniCliente;
            this.saldoActual = saldoInicial;
        }

        // Constructor con DNI, saldo, número de cuenta e interés
        public Cuenta(int numeroCuenta, int dniCliente, double saldoInicial, double interes) {
            this.numeroCuenta = numeroCuenta;
            this.dniCliente = dniCliente;
            this.saldoActual = saldoInicial;
            this.interes = interes;
        }


        // Métodos getter y setter para los atributos

        public int getNumeroCuenta() {
            return numeroCuenta;
        }

        public void setNumeroCuenta(int numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
        }

        public long getDniCliente() {
            return dniCliente;
        }

        public void setDniCliente(int dniCliente) {
            this.dniCliente = dniCliente;
        }

        public double getSaldoActual() {
            return saldoActual;
        }

        public void setSaldoActual(double saldoActual) {
            this.saldoActual = saldoActual;
        }


        public double getInteres() {
            return interes;
        }

        public void setInteres(double interes) {
            this.interes = interes;
        }

        // Operación para depositar dinero en la cuenta
        public void depositar(double monto) {
            if (monto > 0) {
                this.saldoActual += monto;
                System.out.println("Depósito exitoso. Saldo actual: " + this.saldoActual);
            } else {
                System.out.println("Error: El monto a depositar debe ser mayor que cero.");
            }
        }

        // Operación para retirar dinero de la cuenta
        public void retirar(double monto) {
            if (monto > 0 && monto <= this.saldoActual) {
                this.saldoActual -= monto;
                System.out.println("Retiro exitoso. Saldo actual: " + this.saldoActual);
            } else {
                System.out.println("Error: Monto no válido o insuficiente saldo.");
            }
        }

        public void extraccionRapida() {
            double porcentajeAExtraer = 0.2; // 20%
            double montoAExtraer = this.saldoActual * porcentajeAExtraer;

            if (montoAExtraer > 0) {
                if (montoAExtraer <= this.saldoActual) {
                    this.saldoActual -= montoAExtraer;
                    System.out.println("Extracción rápida exitosa. Se retiró: " + montoAExtraer);
                    System.out.println("Saldo actual: " + this.saldoActual);
                } else {
                    System.out.println("Error: Saldo insuficiente para la extracción rápida.");
                }
            } else {
                System.out.println("Error: No se puede extraer un porcentaje negativo o nulo.");
            }
        }

        // Método para consultar el saldo actual
        public double consultarSaldo() {
            return this.saldoActual;
        }

        // Método para mostrar todos los datos de la cuenta

        public void mostrarInformacion() {
            System.out.println("Número de cuenta: " + this.numeroCuenta);
            System.out.println("DNI del cliente: " + this.dniCliente);
            System.out.println("Saldo actual: " + this.saldoActual);
        }


}
