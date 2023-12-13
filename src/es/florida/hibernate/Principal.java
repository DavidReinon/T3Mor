package es.florida.hibernate;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Principal {

	public static void main(String[] args) {
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure(new File("./src/hibernate.cfg.xml"));
		configuration.addFile(new File("./src/es/florida/hibernate/canco.hbm.xml"));
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Canco canço1 = (Canco) session.get(Canco.class, 1);

		System.out.println(canço1.toString());

		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		// session.clear()
		session.close();

	}

}
