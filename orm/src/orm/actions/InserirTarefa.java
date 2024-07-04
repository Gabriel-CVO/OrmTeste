package orm.actions;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Tarefa;

public class InserirTarefa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//1. Instanciar e preencher os dados do JavaBeans
		Tarefa tarefa = new Tarefa();
		System.out.print("Informe a descricao da tarefa: ");
        String descricao = scanner.nextLine();
        tarefa.setDescricao(descricao);
        System.out.print("A tarefa ja foi finalizada? Responda com True ou False: ");
        boolean finalizada = scanner.nextBoolean();
        tarefa.setFinalizada(finalizada);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		//2. Conectar ao operador do ORM/JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//3.Executar a operação
		manager.getTransaction().begin();
		//O "C" do CRUD é dado pelo método "persist" de Hibernate
		manager.persist(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa inserida, ID: "+tarefa.getId());
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
