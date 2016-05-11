package br.escolanotpad.sc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.escolanotpad.sc.commons.JpaUtil;
import br.escolanotpad.sc.model.entity.Perfil;
import br.escolanotpad.sc.model.entity.Usuario;

public class UsuarioDAO extends DAO {
	
	public void salvar(Usuario usuario){
		getEM().merge(usuario);
	}
	
	public Usuario buscarPorId(Long id){
		return getEM().find(Usuario.class, id);
	}
	
	public List<Usuario> listarUsuarios(){
		Query query = getEM().createQuery("From Usuario order by id desc", Usuario.class);
		return query.getResultList();
	}
	
	public List<Usuario> listarProfessores(){
		Query query = getEM().createQuery("From Usuario where perfil = :perfil order by perfil", Usuario.class);
		query.setParameter("perfil", Perfil.Professor);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Usuario usuario = getEM().getReference(Usuario.class, id);
		getEM().remove(usuario);
	}
	
}