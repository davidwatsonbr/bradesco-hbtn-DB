package demo;

import java.time.LocalDate;
import java.util.List;
import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

public class AdministrativoApp {

    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        // 2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());

        System.out.println(produtoModel.findById(p1));
        produtoModel.delete(p1);
        p1.setPreco(600.0);
        produtoModel.update(p1);
        System.out.println(produtoModel.findById(p1));

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Diniz");
        pessoa.setIdade(34);
        pessoa.setEmail("enf@gmail.com");
        pessoa.setCpf("123456789");
        pessoa.setDataNascimento(LocalDate.of(1990, 11, 20));

        pessoaModel.create(pessoa);
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());

        System.out.println(pessoaModel.findById(pessoa));
        pessoaModel.delete(pessoa);
        pessoa.setNome("Jack");
        pessoaModel.update(pessoa);
        System.out.println(pessoaModel.findById(pessoa));
        // TODO - Testar os demais metódos das classes: ProdutoModel e PessoaModel
    }
}
