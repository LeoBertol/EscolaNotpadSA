package br.escolanotpad.sc.mb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.PerguntaRN;
import br.escolanotpad.sc.model.entity.Pergunta;
import br.escolanotpad.sc.model.entity.Resposta;

@ManagedBean
public class PerguntaMB {
	private Pergunta pergunta;
	private PerguntaRN perguntaRN;
	private Long editarId;
	private List<Pergunta> listaPerguntas;
	
	private String respostaA;
	private String respostaB;
	private String respostaC;
	private String respostaD;
	private String respostaE;

	@PostConstruct
	public void initi(){
		perguntaRN = new PerguntaRN();
		pergunta = new Pergunta();
		pergunta.setRespostasPergunta(new ArrayList<Resposta>());
	}
	
	public List<Pergunta> getListaPerguntas() {
		if (listaPerguntas == null){
			listaPerguntas = perguntaRN.listar();
		}
		return listaPerguntas;
	}
	
	public void setListaPerguntas(List<Pergunta> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}
	
	public void carregarEdicao(){
		if(editarId != null && !FacesContext.getCurrentInstance().getPartialViewContext().isAjaxRequest()){
			pergunta = perguntaRN.buscarPorId(editarId);
		}
	}

	public String salvar() throws Throwable{
		try{
			perguntaRN.salvar(pergunta);
			listaPerguntas = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo", "Salvo Com Sucesso"));
			return "/prof/listaPergunta";
		} catch (IllegalArgumentException exception){
			exception.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro",exception.getMessage()));
		}catch (Exception e){
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
		}
		return "";
	}
	
	public void carregarPergunta(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		pergunta = perguntaRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		perguntaRN.excluir(idExcluir);
		listaPerguntas = null;
		return "";
	}
	
	

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		pergunta = pergunta;
	}

	public PerguntaRN getPerguntaRN() {
		return perguntaRN;
	}

	public void setPerguntaRN(PerguntaRN perguntaRN) {
		perguntaRN = perguntaRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

	public String getRespostaA() {
		return respostaA;
	}

	public void setRespostaA(String respostaA) {
		this.respostaA = respostaA;
	}

	public String getRespostaB() {
		return respostaB;
	}

	public void setRespostaB(String respostaB) {
		this.respostaB = respostaB;
	}

	public String getRespostaC() {
		return respostaC;
	}

	public void setRespostaC(String respostaC) {
		this.respostaC = respostaC;
	}

	public String getRespostaD() {
		return respostaD;
	}

	public void setRespostaD(String respostaD) {
		this.respostaD = respostaD;
	}

	public String getRespostaE() {
		return respostaE;
	}

	public void setRespostaE(String respostaE) {
		this.respostaE = respostaE;
	}
	
			
}
