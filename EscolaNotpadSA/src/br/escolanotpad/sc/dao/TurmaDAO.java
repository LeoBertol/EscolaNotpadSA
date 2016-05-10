package br.escolanotpad.sc.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.Query;

import br.escolanotpad.sc.model.entity.Turma;

public class TurmaDAO extends DAO{
	
	public void salvar(Turma turma) throws SQLException{
		getEM().merge(turma);
	}
	
	public List<Turma> listar(){
		Query query = getEM().createQuery("From Turma", Turma.class);
		return query.getResultList();
	}
	
}
