package br.com.alura;

import br.com.alura.modelo.Conta;

public class ValidandoEstados {
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Almiro");
        conta.setAgencia(45676L);
        conta.setNumero(59302L);
    }
}
