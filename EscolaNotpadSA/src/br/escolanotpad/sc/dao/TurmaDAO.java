package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Turma;

public class TurmaDAO extends DAO{
	
	public void salvar(Turma turma) throws SQLException{
		getEM().merge(turma);
	}
	
	public Turma buscarPorId(Long id){
		return getEM().find(Turma.class, id);
	}
	
	public List<Turma> listar(){
		Query query = getEM().createQuery("From Turma", Turma.class);
		return query.getResultList();
	}
	
	public void excluir(Long id){
		Turma turma = getEM().getReference(Turma.class, id);
		getEM().remove(turma);
	}
	
}
