package orm.utilsDB;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//classe responsável pelo DDL -> Data Definition Lenguage
public class GeraTabelaTarefa {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		factory.close();
	}
}
