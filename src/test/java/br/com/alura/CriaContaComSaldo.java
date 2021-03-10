package br.com.alura;

import br.com.alura.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.lang.Long.valueOf;

public class CriaContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("José");
        conta.setAgencia(valueOf(54321));
        conta.setNumero(valueOf(12345));
        conta.setSaldo(100.0);

        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.getTransaction().commit();
    }
}
