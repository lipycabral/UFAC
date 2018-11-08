package br.ufac.academico.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufac.academico.entidades.Item;
import br.ufac.academico.entidades.Pedido;

public class PedidoTeste {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademicoJPA");
		EntityManager em = emf.createEntityManager();
		
		Pedido p1, p2;
		Item i1,i2;
		
		
		/*p1 = new Pedido();
		p1.setId(1);
		p1.setStatus("Em processamento");
		
		p2 = new Pedido();
		p2.setId(2);
		p2.setStatus("Em trânsito");
		
		i1 = new Item();
		i1.setId(1);
		i1.setQuantidade(5);
		
		i2 = new Item();
		i2.setId(2);
		i2.setQuantidade(15);
		
		p1.addItem(i1);
		p2.addItem(i1);
		p2.addItem(i2);*/
		
		p2 = em.find(Pedido.class, 2);
		i2 = em.find(Item.class, 2);
		
		p2.delItem(i2);
		
		/*em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();*/
		
		em.getTransaction().begin();
		em.merge(p2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
