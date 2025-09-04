package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professor {

    public Professor() {
        this.cursos = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String matricula;
    private String email;
    @OneToMany(mappedBy = "professor")
    private List<Curso> cursos;

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void adicionarCurso(Curso curso) {
        this.cursos.add(curso);
        if (curso.getProfessor() != this) {
            curso.adicionarProfessor(this);
        }
    }
}
