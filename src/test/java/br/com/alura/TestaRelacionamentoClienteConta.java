package br.com.alura;

import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestaRelacionamentoClienteConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(1L);

        Cliente cliente = new Cliente();
        cliente.setNome("Kamila");
        cliente.setEndereco("Rua X, bairro aqui");
        cliente.setProfissao("Professor");
        cliente.setConta(conta);

        entityManager.getTransaction().begin();
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
