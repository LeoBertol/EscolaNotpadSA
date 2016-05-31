package br.escolanotpad.sc.model.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String titulo;
	private Date dataDeInicio;
	private Date dataDeTermino;
	@ManyToOne
	private Usuario professor;
	@ManyToOne
	private Curso curso;
	@ManyToMany
	private List<Usuario> alunosTurma;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataDeInicio() {
		return dataDeInicio;
	}
	public void setDataDeInicio(Date dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}
	public Date getDataDeTermino() {
		return dataDeTermino;
	}
	public void setDataDeTermino(Date dataDeTermino) {
		this.dataDeTermino = dataDeTermino;
	}
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Usuario> getAlunosTurma() {
		return alunosTurma;
	}
	public void setAlunosTurma(List<Usuario> alunosTurma) {
		this.alunosTurma = alunosTurma;
	}
	
}
