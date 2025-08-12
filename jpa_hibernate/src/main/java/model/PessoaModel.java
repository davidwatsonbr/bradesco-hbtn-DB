package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Pessoa;
import entities.Produto;

public class PessoaModel {
    private EntityManagerFactory emf;

    public PessoaModel() {
        emf = Persistence.createEntityManagerFactory("admin-jpa");
    }

    public void create(Pessoa p) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de create");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de pessoa");
        }
    }

    public void update(Pessoa p) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de update");
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            System.out.println("Pessoa atualizada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de update");
        }
    }

    public void delete(Pessoa p) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de delete");
            em.getTransaction().begin();
            Pessoa pessoaContextoPersistencia = em.find(Pessoa.class, p.getId());

            if (pessoaContextoPersistencia != null) {
                em.remove(pessoaContextoPersistencia);
                System.out.println(String.format("Pessoa id %d deletada com sucesso !!!", p.getId()));
                em.getTransaction().commit();
            } else {
                System.out.println(String.format("Pessoa id %d não encontrada para deleção.", p.getId()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de delete");
        }
    }

    public Pessoa findById(Pessoa p) {
        Pessoa pessoa = null;
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pessoa> qry = em.createQuery("select p from Pessoa p", Pessoa.class);

        try {
            System.out.println("Obtendo pessoa id " + p.getId());
            pessoa = em.find(Pessoa.class, p.getId());
            System.out.println(String.format("Pessoa id %d obtido com sucesso !!!", p.getId()));
        } catch (Exception e) {
            System.err.println(String.format("Erro ao obter a pessoa id %d !!! %s", p.getId(), e.getMessage()));
        } finally {
            em.close();
            System.out.println("Finalizando a consulta de pessoa por id");
        }
        return pessoa;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Pessoa> qry = em.createQuery("select p from Pessoa p", Pessoa.class);

        try {
            System.out.println("Obtendo todas as pessoas");
            pessoas = qry.getResultList();
            System.out.println("Pessoas obtidos com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao obter todas as pessoas !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a consulta de todas as pessoas");
        }
        return pessoas;
    }
}
