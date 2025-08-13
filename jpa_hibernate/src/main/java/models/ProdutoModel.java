package models;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Produto;

public class ProdutoModel {
    private EntityManagerFactory emf;

    public ProdutoModel() {
        emf = Persistence.createEntityManagerFactory("admin-jpa");
    }

    public void create(Produto p) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de create");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de create");
        }
    }

    public void update(Produto p) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de update");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de update");
        }
    }

    public void delete(Produto p) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de delete");
            em.getTransaction().begin();
            Produto produtoContextoPersistencia = em.find(Produto.class, p.getId());

            if (produtoContextoPersistencia != null) {
                em.remove(produtoContextoPersistencia);
                System.out.println(String.format("Produto id %d deletado com sucesso !!!", p.getId()));
                em.getTransaction().commit();
            } else {
                System.out.println(String.format("Produto id %d não encontrado para deleção.", p.getId()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de delete");
        }
    }

    public Produto findById(Produto p) {
        Produto produto = null;
        EntityManager em = emf.createEntityManager();
        TypedQuery<Produto> qry = em.createQuery("select p from Produto p", Produto.class);

        try {
            System.out.println("Obtendo produto ID " + p.getId());
            produto = em.find(Produto.class, p.getId());
            System.out.println(String.format("Produto ID %d obtido com sucesso !!!", p.getId()));
        } catch (Exception e) {
            System.err.println(String.format("Erro ao obter o produto ID %d !!! %s", p.getId(), e.getMessage()));
        } finally {
            em.close();
            System.out.println("Finalizando a consulta de produto por ID");
        }
        return produto;
    }

    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Produto> qry = em.createQuery("select p from Produto p", Produto.class);

        try {
            System.out.println("Obtendo todos os produtos");
            produtos = qry.getResultList();
            System.out.println("Produtos obtidos com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao obter todos os produtos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a consulta de todos os produtos");
        }
        return produtos;
    }
}