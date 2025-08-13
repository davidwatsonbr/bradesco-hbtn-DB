package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Integer getIdade() { return idade; }

    public void setIdade(Integer idade) { this.idade = idade; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    @Override
    public String toString() {
        return "Pessoa{ " +
                "id=" + id +
                ", nome=" + nome +
                ", email=" + email +
                ", idade=" + idade +
                ", cpf=" + cpf +
                ", data nascimento=" + dataNascimento +
                " }";
    }
}
