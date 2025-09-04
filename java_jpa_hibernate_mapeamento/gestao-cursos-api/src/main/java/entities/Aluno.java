package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Aluno {

    public Aluno() {
        this.enderecos = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String matricula;
    private Date nascimento;
    private String email;
    @OneToMany(mappedBy = "aluno")
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "aluno")
    private List<Telefone> telefones;
    @ManyToOne
    private Curso curso;

    public Long getId() { return id; }
    public String getNomeCompleto() { return nomeCompleto; }

    public String getMatricula() { return matricula; }

    public Date getNascimento() { return nascimento; }

    public String getEmail() { return email; }

    public List<Endereco> getEnderecos() { return enderecos; }

    public List<Telefone> getTelefones() { return telefones; }

    public Curso getCurso() { return curso; }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        if (!curso.getAlunos().contains(this)) {
            curso.adicionarAluno(this);
        }
    }
}
