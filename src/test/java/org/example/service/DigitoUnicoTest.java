package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class DigitoUnicoTest {

    @Test
    public void testEncontrarDigitoUnico() {
        BigInteger numero1 = new BigInteger("9875");
        int resultado = DigitoUnico.encontrarDigitoUnico(numero1);
        Assertions.assertEquals(2, resultado);

    }

    @Test
    public void testConcatenar() {
        // Teste para concatenar
        String numero = "9875";
        int c = 4;
        BigInteger resultadoEsperado = new BigInteger("9875987598759875");
        Assertions.assertEquals(resultadoEsperado, DigitoUnico.concatenar(numero, c));
    }

    @Test
    public void testDigitoUnico() throws Exception {
        // Teste para número válido e multiplicador válido
        String n1 = "9875";
        int c1 = 4;
        Assertions.assertEquals(8, DigitoUnico.digitoUnico(n1, c1));

        // Teste para número inválido (maior que 100000000)
        String n2 = "1234567890";
        int c2 = 3;
        Assertions.assertThrows(Exception.class, () -> {
            DigitoUnico.digitoUnico(n2, c2);
        });

        // Teste para multiplicador inválido (menor que 1)
        String n3 = "9875";
        int c3 = 0;
        Assertions.assertThrows(Exception.class, () -> {
            DigitoUnico.digitoUnico(n3, c3);
        });
    }
}