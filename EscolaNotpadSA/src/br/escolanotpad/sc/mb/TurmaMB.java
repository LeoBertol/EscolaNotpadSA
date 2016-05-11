package br.escolanotpad.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.TurmaRN;
import br.escolanotpad.sc.model.entity.Turma;

@ManagedBean
public class TurmaMB {
	private Turma turma;
	private TurmaRN turmaRN;	
	private Long editarId;
	private List<Turma> listaTurmas;	
	
	@PostConstruct
	public void init(){
		turmaRN = new TurmaRN();
		turma = new Turma();
	}

	public List<Turma> getListaTurmas() {
		if (listaTurmas == null){
			listaTurmas = turmaRN.listar();
		}
		return listaTurmas;
	}

	public void setListaTurmas(List<Turma> listaTurmas) {
		this.listaTurmas = listaTurmas;
	}
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String salvar() throws Throwable{
		turmaRN.salvar(turma);
		listaTurmas = null;
		return "listaTurma";
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public void carregarTurma(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		turma = turmaRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		turmaRN.excluir(idExcluir);
		listaTurmas = null;
		return "";
	}
	
	public TurmaRN getTurmaRN() {
		return turmaRN;
	}

	public void setTurmaRN(TurmaRN turmaRN) {
		this.turmaRN = turmaRN;
	}
	
	

}
