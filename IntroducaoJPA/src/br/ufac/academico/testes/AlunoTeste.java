package br.ufac.academico.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufac.academico.entidades.*;
import br.ufac.academico.repositorios.AlunoRepositorio;

public class AlunoTeste {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("AcademicoJPA");
	
		EntityManager em = emf.createEntityManager();
		
		AlunoRepositorio ar = new AlunoRepositorio();
		
//		Aluno a1 = new Aluno();
//		a1.setNome("Paulo");
//		a1.setIdade(12);
//		
//		Aluno a2 = new Aluno();
//		a2.setNome("Carlos");
//		a2.setIdade(30);
//		
//		Aluno a3 = new Aluno();
//		a3.setNome("João");
//		a3.setIdade(18);
//		
//
//		Aluno a4 = new Aluno();
//		a4.setNome("Silvana");
//		a4.setIdade(50);
//		
//		Aluno a5 = new Aluno();
//		a5.setNome("Enzo");
//		a5.setIdade(13);
//		
//		ar.adicionar(a1);
//		ar.adicionar(a2);
//		ar.adicionar(a3);
//		ar.adicionar(a4);
//		ar.adicionar(a5);
		
		
		List<Aluno> alunos;
		
		System.out.println("Todos");
		alunos = ar.recuperarTodos();
		for (Aluno aluno : alunos) {
			System.out.printf("id = %d, nome=%s, idade=%d\n", aluno.getId(), aluno.getNome(), aluno.getIdade());
		}
		
		System.out.println("Ordenados");
		alunos = ar.recuperarTodosPorNome();
		for (Aluno aluno : alunos) {
			System.out.printf("id = %d, nome=%s, idade=%d\n", aluno.getId(), aluno.getNome(), aluno.getIdade());
		}
		
		System.out.println("Menores de idade");
		alunos = ar.recuperarMenorIdade();
		for (Aluno aluno : alunos) {
			System.out.printf("id = %d, nome=%s, idade=%d\n", aluno.getId(), aluno.getNome(), aluno.getIdade());
		}
		
		System.out.println("Maiores de idade");
		alunos = ar.recuperarMaiorIdade();
		for (Aluno aluno : alunos) {
			System.out.printf("id = %d, nome=%s, idade=%d\n", aluno.getId(), aluno.getNome(), aluno.getIdade());
		}
		
		System.out.println("Adolescentes");
		alunos = ar.recuperarAdolescentes();
		for (Aluno aluno : alunos) {
			System.out.printf("id = %d, nome=%s, idade=%d\n", aluno.getId(), aluno.getNome(), aluno.getIdade());
		}
		System.out.println("Por faixa etaria");
		alunos = ar.recuperarPorFaixaEtaria(15, 30);
		for (Aluno aluno : alunos) {
			System.out.printf("id = %d, nome=%s, idade=%d\n", aluno.getId(), aluno.getNome(), aluno.getIdade());
		}
		System.out.println("Nome contendo");
		alunos = ar.recuperarPorNomeContendo("e");
		for (Aluno aluno : alunos) {
			System.out.printf("id = %d, nome=%s, idade=%d\n", aluno.getId(), aluno.getNome(), aluno.getIdade());
		}
//		Aluno a1, a2;
//		
//		a1 = em.find(Aluno.class, 3l);
//		
//		System.out.println("Aluno");
//		System.out.println(a1.getId());
//		System.out.println(a1.getNome());
//		
//		a1.setNome("Antonio José");
//		
//		a1 = em.find(Aluno.class, 3l);
//		System.out.println("Aluno");
//		System.out.println(a1.getId());
//		System.out.println(a1.getNome());
//		
//		a2 = em.find(Aluno.class, 5l);
//		System.out.println("Aluno");
//		System.out.println(a2.getId());
//		System.out.println(a2.getNome());
//		
//		em.getTransaction().begin();
//		em.merge(a1);
//		em.remove(a2);
//		em.getTransaction().commit();
		
//		em.close();
//		emf.close();
		ar.encerrar();
	}

}
