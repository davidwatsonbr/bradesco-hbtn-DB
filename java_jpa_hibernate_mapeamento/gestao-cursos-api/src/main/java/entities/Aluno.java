package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Aluno {
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
    private List<Curso> cursos;

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

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

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
