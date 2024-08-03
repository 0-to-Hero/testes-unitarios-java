package br.com.zeroth.tujava.calculadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTeste {

    Calculadora calculadora;
    @BeforeEach
    void setUp(){
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumerosEValidarResultado(){

        //ACT
        int resultado = calculadora.somar(2, 3);

        //ASSERT
        assertEquals(5, resultado, "a soma de 2 + 3 deve ser igual a 5");
    }

    @Test
    public void deveValidarSeASomaDeDoisNumerosNaoEhIgualAoValorInformado() {

        //ACT
        int resultado = calculadora.somar(2, 3);

        //ASSERTIONS
        assertNotEquals(6, resultado);
    }

    @Test
    void deveValidarSeNumeroEhMaiorQueZero() {

        //ACT
        boolean resultado = calculadora.validaSeEhMaiorQueZero(-2);

        //ASSERT
        assertFalse(resultado);
    }

    @Test
    void deveValidarSeEhNulo() {

        //ACT
        int resultado = calculadora.somar(2, 3);

        //Assert
        assertNotNull(resultado);
    }

    @Test
    void deveLancarExceptionAoRealizarDivisaoPorZero() {
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(120, 0));
    }

    @Test
    void deveNaoLancarExceptionQuandoOsValoresDaDivisaoForemCorretos() {
        assertDoesNotThrow(() -> {
            double resultado = calculadora.dividir(120, 2);
            //assertEquals(3, resultado);
        });
    }


}
