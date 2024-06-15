package org.example.service;

import java.math.BigInteger;

public class DigitoUnico {

    static int encontrarDigitoUnico(BigInteger numero) {

        long somaDigitos = 0L;

        for (BigInteger temp = numero; temp.compareTo(BigInteger.ZERO) > 0; temp = temp.divide(BigInteger.TEN)) {
            somaDigitos += temp.mod(BigInteger.TEN).longValue();

        }

        if (somaDigitos >= 10)
        {
            return encontrarDigitoUnico(BigInteger.valueOf(somaDigitos));

        }

        return (int) somaDigitos;

    }

    static BigInteger concatenar(String numero, int c)
    {
        StringBuilder concatenalo = new StringBuilder();

        for (int i = 1; i <= c ; i++)
        {
            concatenalo.append(numero);

        }

        return new BigInteger(concatenalo.toString().toString());

    }

    public static int digitoUnico (String n, int c ) throws Exception {
        long numberLong = 0;
        try {
            numberLong =Long.parseLong(n);


        } catch (Throwable e)
        {
            throw new Exception("Apenas Numeros inteiros ");
        }

        if (numberLong >= 100000000 || numberLong <= 1 )
        {
            throw new Exception("Numero maior que 100000000 ou menor que 1 ");

        }

        if (c >= 100000 || c <= 1 )
        {
            throw new Exception("Multiplicador maior que 100000 ou menor que 1 ");

        }

        BigInteger digitoConcatenado = concatenar(n, c);
        long resultado = encontrarDigitoUnico( digitoConcatenado);

        return Math.toIntExact(resultado);

    }


}
