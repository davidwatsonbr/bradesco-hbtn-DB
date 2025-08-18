package entities;

import javax.persistence.*;

@Entity
public class MaterialCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @OneToOne
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
