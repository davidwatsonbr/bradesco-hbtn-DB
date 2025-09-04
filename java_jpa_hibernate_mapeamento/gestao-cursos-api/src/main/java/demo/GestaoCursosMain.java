package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;

public class GestaoCursosMain {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.setNomeCompleto("Teacher");
        professor.setMatricula("PROF01");
        professor.setEmail("teacher@gmail.com");

        Curso curso = new Curso();
        curso.setNome("Enfermagem");
        curso.setSigla("ENF");

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

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setCurso(curso);
        materialCurso.setUrl("www.enfermagemjack.com.br");

        // criando relacionamentos
        professor.adicionarCurso(curso);
        curso.adicionarProfessor(professor);
        curso.adicionarAluno(aluno);
        curso.adicionarMaterial(materialCurso);

        CursoModel cursoModel = new CursoModel();
        AlunoModel alunoModel = new AlunoModel();
        cursoModel.create(curso);
        alunoModel.create(aluno);
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
