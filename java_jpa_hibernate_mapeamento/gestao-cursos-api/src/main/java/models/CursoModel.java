package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import entities.Curso;

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
        // TODO
        return null;
    }

    public  List<Curso> findAll() {
        // TODO
        return null;
    }

    public void update(Curso curso) {
        // TODO
    }

    public void delete(Curso curso) {
        // TODO
    }
}
