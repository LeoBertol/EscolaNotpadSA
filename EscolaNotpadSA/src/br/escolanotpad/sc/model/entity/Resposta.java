package br.escolanotpad.sc.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Resposta {
	@Id
	@GeneratedValue
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private Boolean correta;
	@ManyToOne
	private Pergunta pergunta;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Boolean getCorreta() {
		return correta;
	}
	public void setCorreta(Boolean correta) {
		this.correta = correta;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	
}
