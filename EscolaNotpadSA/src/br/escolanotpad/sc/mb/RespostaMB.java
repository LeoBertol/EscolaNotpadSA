package br.escolanotpad.sc.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.escolanotpad.sc.model.RespostaRN;
import br.escolanotpad.sc.model.entity.Resposta;

@ManagedBean
public class RespostaMB {
	private Resposta Resposta;
	private RespostaRN RespostaRN;
	private Long editarId;
	private List<Resposta> listaRespostas;
	
	@PostConstruct
	public void initi(){
		RespostaRN = new RespostaRN();
		Resposta = new Resposta();		
	}
	
	public List<Resposta> getListaRespostas() {
		if (listaRespostas == null){
			listaRespostas = RespostaRN.listar();
		}
		return listaRespostas;
	}
	
	public void setListaRespostas(List<Resposta> listaRespostas) {
		this.listaRespostas = listaRespostas;
	}

	public String salvar() throws Throwable{
		RespostaRN.salvar(Resposta);
		listaRespostas = null;
		return "/prof/listaResposta";
	}
	
	public void carregarResposta(ComponentSystemEvent event){
		if(editarId == null){
			return ;
		}
		
		Resposta = RespostaRN.buscarPorId(editarId);
	}
	
	public String excluir(String id){
		Long idExcluir = Long.parseLong(id);
		RespostaRN.excluir(idExcluir);
		listaRespostas = null;
		return "";
	}

	public Resposta getResposta() {
		return Resposta;
	}

	public void setResposta(Resposta resposta) {
		Resposta = resposta;
	}

	public RespostaRN getRespostaRN() {
		return RespostaRN;
	}

	public void setRespostaRN(RespostaRN respostaRN) {
		RespostaRN = respostaRN;
	}

	public Long getEditarId() {
		return editarId;
	}

	public void setEditarId(Long editarId) {
		this.editarId = editarId;
	}

}
