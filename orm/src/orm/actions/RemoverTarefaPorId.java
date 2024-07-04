package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Tarefa;

public class RemoverTarefaPorId {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//1. Conectar ao operador do ORM/JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//2.Buscar o objeto s drt excluído
		Tarefa tarefa = new Tarefa();
		System.out.print("Informe o Id a ser removido: ");
        Long Id = scanner.nextLong();
		tarefa.setId(Id);
		tarefa = manager.find(Tarefa.class, tarefa.getId());
		//ou tarefa = manager.find(Terefa.class, 1L);
		
		//3. operar com "remove"
		manager.getTransaction().begin();
		manager.remove(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa excluída!");
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
