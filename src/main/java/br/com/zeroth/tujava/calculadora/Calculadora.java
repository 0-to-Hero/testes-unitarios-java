package br.com.zeroth.tujava.calculadora;

public class Calculadora {
    public int somar(int a, int b) {
        return a+b;
    }

    public double dividir(double a, double b){
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero.");
        }
        return  a / b;
    }

    public boolean validaSeEhMaiorQueZero(int i) {
        return i > 0;
    }
}
