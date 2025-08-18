package demo;

import entities.Aluno;
import entities.Endereco;
import entities.Telefone;

import entities.Curso;
import entities.Professor;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;

public class GestaoCursosMain {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setNomeCompleto("Teacher");
        professor.setMatricula("PROF01");
        professor.setEmail("teacher@gmail.com");
        professor.setCursos(null)

        Curso curso = new Curso();
        curso.setNome("Enfermagem");
        curso.setSigla("ENF");
        curso.setProfessor(null);
        curso.setAlunos(null);
        curso.setMaterial(null);

        Aluno aluno = new Aluno();
        aluno.setNomeCompleto("Jack Enf");
        aluno.setMatricula("ENF01");
        aluno.setNascimento(Date.from(LocalDate.of(1990, 11, 20).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        aluno.setEmail("enf@gmail.com");

        Telefone telefone = new Telefone();
        telefone.setDDD("11");
        telefone.setNumero("2345678");
        telefone.setAluno(aluno);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("R");
        endereco.setEndereco("Alfredo Pujol");
        endereco.setNumero("1343");
        endereco.setBairro("Santana");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setCep(02017012);
        endereco.setAluno(aluno);
        /*
        c) Para fazer um teste completo, sua aplicação GestaoCursosMain.java
        deverá popular todas as tabelas do banco de dados, ou seja,
        1 aluno (com um telefone e um endereço),
        1 professor,
        1 curso (com um professor e um aluno) e
        um material do curso.
        */
    }
}
