package br.escolanotpad.sc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.TurmaRN;
import br.escolanotpad.sc.model.entity.Turma;
import br.escolanotpad.sc.model.entity.Usuario;

@ViewScoped
@ManagedBean
public class TurmaMB {
	private List<Turma> listaTurmas;
	private List<Turma> listaTurmasUsuario;
	private TurmaRN turmaRN;
	private Turma turma;
	private Usuario usuarioLogado;	
	private Long editarId;
		
	
	private Usuario alunoSelecionado;
	
	@PostConstruct
	public void init(){
		turmaRN = new TurmaRN();
		turma = new Turma();
		turma.setAlunosTurma(new ArrayList<Usuario>());
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
	
	public Long getIdUsuarioLogado(){
		return usuarioLogado ==  null ? null: usuarioLogado.getId();
	}
		
	public List<Turma> getListaTurmasUsuario(Long usuarioLogado) {		
		if (listaTurmas == null){
			listaTurmasUsuario = turmaRN.listarTurmaPorUsuario(usuarioLogado);
		}		
		return listaTurmasUsuario;
	}

	public void setListaTurmasUsuario(List<Turma> listaTurmasUsuario) {
		this.listaTurmasUsuario = listaTurmasUsuario;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public Usuario getAlunoSelecionado() {
		return alunoSelecionado;
	}

	public void setAlunoSelecionado(Usuario alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	
	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
	
	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			turma = turmaRN.buscarPorId(editarId);
		}
	}
	
	public void adicionarAluno(AjaxBehaviorEvent event){
		if(turma.getAlunosTurma().contains(alunoSelecionado)){
			return;
		}
		turma.getAlunosTurma().add(alunoSelecionado);
		alunoSelecionado = null;
	}
	
	public void excluirAluno(AjaxBehaviorEvent event){
		Usuario aluno = (Usuario) event.getComponent().getAttributes().get("idAluno");
		turma.getAlunosTurma().remove(aluno);
	}
	
	public String salvar() throws Throwable{
		try{
			turmaRN.salvar(turma);
			listaTurmas = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Salvo Com Sucesso"));
			return "/admin/listaTurma";
		} catch (IllegalArgumentException exception){
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",exception.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return "";
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
