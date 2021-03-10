package br.com.alura;

import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Conta;
import br.com.alura.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQLMovimentacaoDeUmaCategoria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager entityManager = emf.createEntityManager();

        Categoria categoria = new Categoria();
        categoria.setId(2L);

        String jpql = "select m from Movimentacao m join m.categorias c where c = :categoria";

        TypedQuery<Movimentacao> query = entityManager.createQuery(jpql, Movimentacao.class);
        query.setParameter("categoria", categoria);
        List<Movimentacao> movimentacaoList = query.getResultList();

        for(Movimentacao movimentacao: movimentacaoList){
            System.out.println("===========================================");
            System.out.println("Descricao: " + movimentacao.getDescricao());
            System.out.println("Valor: " + movimentacao.getValor());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
            System.out.println("Categorias: " + movimentacao.getCategorias());
        }
    }
}
