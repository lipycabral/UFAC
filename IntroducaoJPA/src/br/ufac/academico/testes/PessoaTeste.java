package br.ufac.academico.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufac.academico.entidades.PessoaFisica;
import br.ufac.academico.entidades.PessoaJuridica;

public class PessoaTeste {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		EntityManager em = emf.createEntityManager();
		
		PessoaFisica pf = new PessoaFisica();
		PessoaJuridica pj = new PessoaJuridica();
		
		pf.setNome("Felipy Cabral");
		pf.setCpf("12345678912");
		
		pj.setNome("UFAC");
		pj.setCnpj("12345678901234");
		
		
		em.getTransaction().begin();
		em.persist(pf);
		em.persist(pj);
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}

}
