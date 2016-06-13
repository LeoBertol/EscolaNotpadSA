package br.escolanotpad.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.PerguntaRN;
import br.escolanotpad.sc.model.entity.Pergunta;

@ManagedBean
public class PerguntaMB {
	private Pergunta Pergunta;
	private PerguntaRN PerguntaRN;
	private Long editarId;
	private List<Pergunta> listaPerguntas;
	
	@PostConstruct
	public void initi(){
		PerguntaRN = new PerguntaRN();
		Pergunta = new Pergunta();		
	}
	
	public List<Pergunta> getListaPerguntas() {
		if (listaPerguntas == null){
			listaPerguntas = PerguntaRN.listar();
		}
		return listaPerguntas;
	}
	
	public void setListaPerguntas(List<Pergunta> listaPerguntas) {
		this.listaPerguntas = listaPerguntas;
	}

	public String salvar() throws Throwable{
		PerguntaRN.salvar(Pergunta);
		listaPerguntas = null;
		return "/prof/listaPergunta";
	}
	
	public void carregarPergunta(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		Pergunta = PerguntaRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		PerguntaRN.excluir(idExcluir);
		listaPerguntas = null;
		return "";
	}

	public Pergunta getPergunta() {
		return Pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		Pergunta = pergunta;
	}

	public PerguntaRN getPerguntaRN() {
		return PerguntaRN;
	}

	public void setPerguntaRN(PerguntaRN perguntaRN) {
		PerguntaRN = perguntaRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}
			
}
