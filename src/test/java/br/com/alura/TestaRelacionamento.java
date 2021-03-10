package br.com.alura;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.Movimentacao;
import br.com.alura.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.lang.Long.valueOf;

public class TestaRelacionamento {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Fulano");
        conta.setAgencia(valueOf(879643));
        conta.setNumero(valueOf(405627));
        conta.setSaldo(300.0);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setValor(new BigDecimal(50));
        movimentacao.setDescricao("Almoço");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setConta(conta);

        entityManager.getTransaction().begin();

        entityManager.persist(conta);
        entityManager.persist(movimentacao);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
