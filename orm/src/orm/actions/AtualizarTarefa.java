package orm.actions;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Tarefa;

public class AtualizarTarefa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//1.
		Tarefa tarefa = new Tarefa();
		System.out.print("Informe o Id a ser atualizado: ");
        Long Id = scanner.nextLong();
        scanner.nextLine();
		tarefa.setId(Id);
		System.out.print("Informe a nova descricao da tarefa: ");
        String descricao = scanner.nextLine();
		tarefa.setDescricao(descricao);
		System.out.print("A tarefa ja foi finalizada? Responda com True ou False: ");
	    boolean finalizada = scanner.nextBoolean();
	    tarefa.setFinalizada(finalizada);
		tarefa.setDataFinalizacao(Calendar.getInstance());
		
		//2.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//3. operar com "merge"
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa atualizada, ID: "+tarefa.getId());
		
		manager.close();
		factory.close();
		scanner.close();
	}
}
