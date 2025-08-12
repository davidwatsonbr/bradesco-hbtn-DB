package entities;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidade;
    private Double preco;
    @Column(nullable = false)
    private Boolean status;

    public Long getId() { return id; }

    public void setNome(String nome) { this.nome = nome; }

    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public void setPreco(Double preco) { this.preco = preco; }

    public void setStatus(Boolean status) { this.status = status; }

    @Override
    public String toString() {
        return "Produto{ " +
                "id=" + id +
                ", nome=" + nome +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                ", status=" + status +
                " }";
    }
}
