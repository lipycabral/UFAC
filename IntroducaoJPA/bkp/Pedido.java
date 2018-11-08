package br.ufac.academico.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Pedido {
	@Id
	private int id;
	private String status;
	
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Item> itens = new ArrayList<Item>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public void addItem(Item i) {
		i.setPedido(this);
		itens.add(i);
	}
	
	public void delItem(Item i) {
		i.setPedido(null);
		itens.remove(i);
	}

}
