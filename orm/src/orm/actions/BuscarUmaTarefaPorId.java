package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Tarefa;

public class BuscarUmaTarefaPorId {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//1. Conectar ao operador do ORM/JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//2.Executar a operação
		
		//O "R" do CRUD é dado pelo método "find" de Hibernate
		System.out.print("Informe o Id a ser pesquisado: ");
        Long Id = scanner.nextLong();
		Tarefa t1 = manager.find(Tarefa.class, Id);
		System.out.println(t1.getDescricao());
		
		manager.close();
		scanner.close();
	}
}
