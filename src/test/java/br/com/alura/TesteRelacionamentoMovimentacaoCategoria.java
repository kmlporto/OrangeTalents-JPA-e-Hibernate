package br.com.alura;

import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Conta;
import br.com.alura.modelo.Movimentacao;
import br.com.alura.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TesteRelacionamentoMovimentacaoCategoria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        Categoria categoria = new Categoria("Viagem");
        Categoria categoria2 = new Categoria("Negócios");

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDescricao("Viagem à SP");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setValor(new BigDecimal(300));
        movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
        movimentacao.setConta(conta);

        Movimentacao movimentacao2 = new Movimentacao();
        movimentacao2.setDescricao("Viagem à RJ");
        movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao2.setData(LocalDateTime.now().plusDays(7));
        movimentacao2.setValor(new BigDecimal(300));
        movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
        movimentacao2.setConta(conta);

        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.persist(categoria2);
        entityManager.persist(movimentacao);
        entityManager.persist(movimentacao2);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
