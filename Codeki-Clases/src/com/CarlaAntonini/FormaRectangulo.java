package com.CarlaAntonini;

public class FormaRectangulo {

    private double base;
    private double altura;

    public FormaRectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return (base + altura) * 2;
    }

}
