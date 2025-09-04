package entities;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DDD;
    private String numero;
    @ManyToOne
    private Aluno aluno;

    public void setDDD(String DDD) {
        this.DDD = DDD;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        if (!aluno.getTelefones().contains(this)) {
            aluno.getTelefones().add(this);
        }
    }
}
