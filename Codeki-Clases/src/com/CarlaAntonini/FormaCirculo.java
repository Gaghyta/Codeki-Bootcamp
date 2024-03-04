package com.CarlaAntonini;

import static java.lang.Math.PI;

public class FormaCirculo {
    private double radio;

    public FormaCirculo(double radio) {

        this.radio = radio;
    }


    public double calcularArea() {
        return PI * Math.pow(radio, 2);
    }

    public double calcularPerimetro() {
        return 2 * PI * radio;
    }
}
