package br.com.alura;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPSQL {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(2L);

        String jpql = "select m from Movimentacao m where m.conta = :conta";

        TypedQuery<Movimentacao> query = entityManager.createQuery(jpql, Movimentacao.class);
        query.setParameter("conta", conta);
        List<Movimentacao> movimentacaoList = query.getResultList();

        for(Movimentacao movimentacao: movimentacaoList){
            System.out.println("===========================================");
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}
