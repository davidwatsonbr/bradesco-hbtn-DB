package entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    @ManyToOne
    private Professor professor;
    @OneToOne(mappedBy = "curso")
    private MaterialCurso material;
    @OneToMany(mappedBy = "curso")
    private List<Aluno> alunos;

    public Professor getProfessor() {
        return professor;
    }

    public MaterialCurso getMaterial() {
        return material;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void adicionarProfessor(Professor professor) {
        this.professor = professor;
        if (!professor.getCursos().contains(this)) {
            professor.adicionarCurso(this);
        }
    }

    public void adicionarMaterial(MaterialCurso material) {
        this.material = material;
        if (material.getCurso() != this) {
            material.setCurso(this);
        }
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        if (aluno.getCursos() != this) {
            aluno.setCursos(this);
        }
    }
}
