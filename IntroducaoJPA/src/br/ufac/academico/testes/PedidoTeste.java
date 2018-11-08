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
		Item i1,i2,i3,i4,i5;
		
		p1 = new Pedido();
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
		
		i3 = new Item();
		i3.setId(3);
		i3.setQuantidade(15);
		
		i4 = new Item();
		i4.setId(4);
		i4.setQuantidade(15);
		
		i5 = new Item();
		i5.setId(5);
		i5.setQuantidade(15);
		
		p1.addItem(i1);
		p1.addItem(i2);
		p1.addItem(i3);
		p2.addItem(i4);
		p2.addItem(i5);
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		
		
//		p1 = em.find(Pedido.class, 1);
//		i2 = em.find(Item.class, 2);
//		
//		p1.delItem(i2);
//		
//		
//		
//		em.getTransaction().begin();
//		em.merge(p1);
//		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
