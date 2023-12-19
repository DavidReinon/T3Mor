package es.florida.hibernate.MiniProjecte;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Executable {

	public static void main(String[] args) {
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure(new File("./src/hibernate.cfg.llibre.xml"));
		configuration.addFile(new File("./src/es/florida/hibernate/MiniProjecte/llibre.hbm.xml"));
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.clear();
		session.close();

	}

	public static int Menu() {
		return 0;

	}

}
