package br.com.alura;

import br.com.alura.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static java.lang.Long.valueOf;

public class CriaConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Kamila");
        conta.setAgencia(valueOf(4321));
        conta.setNumero(valueOf(1234));

        entityManager.getTransaction().begin();
        entityManager.persist(conta);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
