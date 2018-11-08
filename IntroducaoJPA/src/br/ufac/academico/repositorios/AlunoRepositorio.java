package br.ufac.academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.ufac.academico.entidades.Aluno;

public class AlunoRepositorio {
	private EntityManagerFactory emf;
	private EntityManager em;
	public AlunoRepositorio() {
		emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		em = emf.createEntityManager();
	}

	
	public void adicionar(Aluno aluno) {
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public void atualizar(Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
	}
	
	public void deletar(Aluno aluno) {
		em.getTransaction().begin();
		em.remove(aluno);
		em.getTransaction().commit();
	}
	
	public Aluno recuperar(int id) {
		return em.find(Aluno.class, id);
	}
	
	public List<Aluno> recuperarTodos(){
		Query query = em.createNamedQuery("Alunos.todos");
		return query.getResultList();
	}
	public List<Aluno> recuperarTodosPorNome(){
		Query query = em.createNamedQuery("Alunos.todosPorNome");
		return query.getResultList();
	}
	public List<Aluno> recuperarMenorIdade(){
		Query query = em.createNamedQuery("Alunos.todosMenoresIdade");
		return query.getResultList();
	}
	public List<Aluno> recuperarMaiorIdade(){
		Query query = em.createNamedQuery("Alunos.todosMaioresIdade");
		return query.getResultList();
	}
	public List<Aluno> recuperarAdolescentes(){
		Query query = em.createNamedQuery("Alunos.adolescentes");
		return query.getResultList();
	}
	public List<Aluno> recuperarPorFaixaEtaria(int min, int max){
		Query query = em.createNamedQuery("Alunos.porFaixaEtaria");
		query.setParameter("min", min);
		query.setParameter("max", max);
		return query.getResultList();
	}
	public List<Aluno> recuperarPorNomeContendo(String termo){
		Query query = em.createNamedQuery("Alunos.nomeContendo");
		query.setParameter("termo", "%"+termo+"%");
		return query.getResultList();
	}
	public void encerrar() {
		em.close();
		emf.close();
	}
}
