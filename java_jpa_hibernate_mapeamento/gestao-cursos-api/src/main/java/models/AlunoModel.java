package models;

import entities.Aluno;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class AlunoModel {
    private EntityManagerFactory emf;

    public AlunoModel() {
        emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    }

    public void create(Aluno aluno) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Long id) {
        Aluno aluno = null;
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> qry = em.createQuery("select a from Aluno a", Aluno.class);

        try {
            System.out.println("Obtendo aluno id " + id);
            aluno = em.find(Aluno.class, id);
            System.out.println(String.format("Aluno id %d obtido com sucesso !!!", id));
        }
        catch(Exception e) {
            System.out.println(String.format("Erro ao obter o aluno id %d !!! %s", id, e.getMessage()));
        }
        finally {
            em.close();
            System.out.println("Finalizando consulta de aluno por id");
        }
        return aluno;
    }

    public  List<Aluno> findAll() {
        List<Aluno> alunos = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> qry = em.createQuery("select a from Aluno a", Aluno.class);

        try {
            System.out.println("Obtendo todos os alunos");
            alunos = qry.getResultList();
            System.out.println("Alunos obtidos com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao obter todos os alunos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a consulta de todos os alunos");
        }
        return alunos;
    }

    public void update(Aluno aluno) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de update");
            em.getTransaction().begin();
            em.merge(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de update");
        }
    }

    public void delete(Aluno aluno) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de delete");
            em.getTransaction().begin();
            Aluno alunoContextoPersistencia = em.find(Aluno.class, aluno.getId());

            if (alunoContextoPersistencia != null) {
                em.remove(alunoContextoPersistencia);
                System.out.println(String.format("Aluno id %d deletado com sucesso !!!", aluno.getId()));
                em.getTransaction().commit();
            } else {
                System.out.println(String.format("Aluno id %d não encontrado para deleção.", aluno.getId()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar o aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de delete");
        }
    }
}
