package models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import entities.Aluno;

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
        // TODO
        return null;
    }

    public  List<Aluno> findAll() {
        // TODO
        return null;
    }

    public void update(Aluno aluno) {
        // TODO
    }

    public void delete(Aluno aluno) {
        // TODO
    }
}
