package models;

import entities.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class CursoModel {
    private EntityManagerFactory emf;

    public CursoModel() {
        emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    }

    public void create(Curso curso) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Long id) {
        Curso curso = null;
        EntityManager em = emf.createEntityManager();
        TypedQuery<Curso> qry = em.createQuery("select c from Curso c", Curso.class);

        try {
            System.out.println("Obtendo curso id " + id);
            curso = em.find(Curso.class, id);
            System.out.println(String.format("Curso id %d obtido com sucesso !!!", id));
        }
        catch(Exception e) {
            System.out.println(String.format("Erro ao obter o curso id %d !!! %s", id, e.getMessage()));
        }
        finally {
            em.close();
            System.out.println("Finalizando consulta de curso por id");
        }
        return curso;
    }

    public  List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        TypedQuery<Curso> qry = em.createQuery("select c from Curso c", Curso.class);

        try {
            System.out.println("Obtendo todos os cursos");
            cursos = qry.getResultList();
            System.out.println("Cursos obtidos com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao obter todos os cursos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a consulta de todos os cursos");
        }
        return cursos;
    }

    public void update(Curso curso) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de update");
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de update");
        }
    }

    public void delete(Curso curso) {
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação de delete");
            em.getTransaction().begin();
            Curso cursoContextoPersistencia = em.find(Curso.class, curso.getId());

            if (cursoContextoPersistencia != null) {
                em.remove(cursoContextoPersistencia);
                System.out.println(String.format("Curso id %d deletado com sucesso !!!", curso.getId()));
                em.getTransaction().commit();
            } else {
                System.out.println(String.format("Curso id %d não encontrada para deleção.", curso.getId()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao deletar o curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação de delete");
        }
    }
}
