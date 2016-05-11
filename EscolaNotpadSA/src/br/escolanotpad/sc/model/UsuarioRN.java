package br.escolanotpad.sc.model;

import java.util.List;

import br.escolanotpad.sc.dao.UsuarioDAO;
import br.escolanotpad.sc.model.entity.Usuario;

public class UsuarioRN {

	private UsuarioDAO dao;

	public UsuarioRN() {
		dao = new UsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		dao.salvar(usuario);
	}

	public Usuario buscarPorId(Long id) {
		return dao.buscarPorId(id);
	}

	public List<Usuario> listarUsuarios() {
		return dao.listarUsuarios();
	}
	
	public List<Usuario> listarProfessores() {
		return dao.listarProfessores();
	}

	public void excluir(Long id) {
		dao.excluir(id);
	}

}
