package orm.actions;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import orm.model.Tarefa;

public class BuscaTarefas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		String sql = "select t from Tarefa as t where t.finalizada = :paramFinalizado";
		
		//JPQL: classe Query de "javax.persistence"
		Query query = manager.createQuery(sql);
		query.setParameter("paramFinalizado", true);
		
		//Mostrando o resultado
		List<Tarefa> listaTarefa = query.getResultList();
		
		for (Tarefa tarefa : listaTarefa) {
			System.out.println(tarefa.getDescricao());
		}
	}
}
