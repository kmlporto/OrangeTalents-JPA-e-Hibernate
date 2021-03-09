package br.com.alura;

import br.com.alura.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AlteraSaldoContaKamila {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager entityManager = emf.createEntityManager();

        Conta contaKamila = entityManager.find(Conta.class, 1L);

        entityManager.getTransaction().begin();
        contaKamila.setSaldo(200.0);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
