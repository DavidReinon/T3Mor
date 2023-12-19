package es.florida.hibernate.MiniProjecte;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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

		boolean seguir = true;
		Scanner teclat = new Scanner(System.in);
		while (seguir) {
			switch (Menu(teclat)) {
			case 1:
				func1(sessionFactory);
				break;
			case 2:
				// func2(sessionFactory);
				break;
			case 3:
				// func3(sessionFactory);
				break;
			case 4:
				// func4(sessionFactory);
				break;
			case 5:
				// func5(sessionFactory);
				break;
			case 6:
				seguir = false;
				System.out.println("Final del Programa.");
				break;
			}
		}
		teclat.close();
	}

	public static int Menu(Scanner teclat) {
		System.out.println("**********************************************************");
		System.out.println("**********************************************************");
		System.out.println("Funcionalitats:");
		System.out.println("1. Mostrar tots el titols de la biblioteca:");
		System.out.println("2. Informació detallada d'un llibre a partir del seu id:");
		System.out.println("3. Afegir un nou llibre a la biblioteca.:");
		System.out.println("4. Modificar atributs d’un llibre a partir del seu id.:");
		System.out.println("5. Esborrar un llibre a partir del seu id:");
		System.out.println("6. Eixir:");
		System.out.println("**********************************************************");

		int resultado = 0;
		boolean entradaValida = false;

		while (!entradaValida) {

			System.out.print("Tria un numero (1 - 6): ");

			try {
				resultado = teclat.nextInt();

				if (resultado >= 1 && resultado <= 6) {
					entradaValida = true;
				} else {
					System.err.println("ERROR: El numero debe estar entre 1 y 6!");
				}
			} catch (InputMismatchException e) {
				System.err.println("ERROR: Debes escribir un NUMERO!");
			}
		}

		return resultado;
	}

	public static void func1(SessionFactory sessionFactory) {

		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Llibre> titlesList = new ArrayList<Llibre>();
		titlesList = session.createQuery("FROM Llibre", Llibre.class).getResultList();

		for (Llibre llibre : titlesList) {
			System.out.println(llibre.getId() + " - " + llibre.getTitle());
		}

		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.clear();
		session.close();

	}

}
