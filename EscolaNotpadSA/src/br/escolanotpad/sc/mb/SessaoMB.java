package br.escolanotpad.sc.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.escolanotpad.sc.model.entity.Perfil;
import br.escolanotpad.sc.model.entity.Usuario;
import br.escolanotpad.sc.model.UsuarioRN;

@SessionScoped
@ManagedBean
public class SessaoMB {
	
	private String emailForm;
	private String senhaForm;
	private Usuario usuarioLogado;
	
	public String getEmailForm() {
		return emailForm;
	}
	public void setEmailForm(String emailForm) {
		this.emailForm = emailForm;
	}
	public String getSenhaForm() {
		return senhaForm;
	}
	public void setSenhaForm(String senhaForm) {
		this.senhaForm = senhaForm;
	}
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public boolean estaLogado(){
		return usuarioLogado != null;
	}
	
	public boolean ehAdmin(){
		return usuarioLogado != null && usuarioLogado.getPerfil().equals(Perfil.Administrador);
	}
	
	public String getNomeUsuarioLogado(){
		return usuarioLogado == null ? "" : usuarioLogado.getNome();
	}
	
	public String sair(){
		usuarioLogado = null;
		return "login?faces-redirect=true";
	}
	
	public String entrar(){
		UsuarioRN usuarioRN = new UsuarioRN();
		Usuario usuario = usuarioRN.buscarPorEmail(emailForm);
		
		if(usuario == null ||
				!usuario.getEmail().equalsIgnoreCase(emailForm) ||
				!usuario.getSenha().equals(senhaForm)){
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("E-mail ou senha não confere."));
			return "";
		}
				
		usuarioLogado = usuario;
		
		return "index?faces-redirect=true";
			
			
	}

	
}
