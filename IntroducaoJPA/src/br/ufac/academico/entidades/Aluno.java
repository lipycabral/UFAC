package br.ufac.academico.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="alunos")
@NamedQueries({
	@NamedQuery(name="Alunos.todos", query="SELECT a FROM Aluno a"),
	@NamedQuery(name="Alunos.todosPorNome", query="SELECT a FROM Aluno a ORDER BY a.nome"),
	@NamedQuery(name="Alunos.todosMenoresIdade", query="SELECT a FROM Aluno a where a.idade < 18 ORDER BY a.nome"),
	@NamedQuery(name="Alunos.todosMaioresIdade", query="SELECT a FROM Aluno a where a.idade >= 18 ORDER BY a.nome"),
	@NamedQuery(name="Alunos.adolescentes", query="SELECT a FROM Aluno a where a.idade BETWEEN 13 AND 19 ORDER BY a.nome"),
	@NamedQuery(name="Alunos.porFaixaEtaria", query="SELECT a FROM Aluno a where a.idade BETWEEN :min AND :max ORDER BY a.nome"),
	@NamedQuery(name="Alunos.nomeContendo", query="SELECT a FROM Aluno a where a.nome LIKE :termo ORDER BY a.nome")
})

public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int idade;
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Aluno() {}
	public Aluno(long id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return String.format("Aluno[id=%d, nome=/%s/, idade=%d", id,nome, idade);
	}

}
