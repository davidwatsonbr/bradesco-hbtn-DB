package entities;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String endereco;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer cep;
    @ManyToOne
    private Aluno aluno;

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        if (!aluno.getEnderecos().contains(this)) {
            aluno.getEnderecos().add(this);
        }
    }
}
