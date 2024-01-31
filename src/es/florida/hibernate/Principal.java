package es.florida.hibernate;

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
import org.hibernate.type.TrueFalseType;

public class Principal {

	public static void main(String[] args) {
		// Carrega la configuracio i crea un session factory
		Configuration configuration = new Configuration().configure(new File("./src/hibernate.cfg.canco.xml"));
		configuration.addFile(new File("./src/es/florida/hibernate/canco.hbm.xml"));
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

		// Obri una nova sessió de la session factory
		Session session = sessionFactory.openSession();

		// selectCanco(session, 1); //El index comienca por uno.
		// selectTotesCancons(session);

		// Canco crearCanco = new Canco("H20", "Leiti", "2:20", 2021);
		// System.out.println("Id creat: " + crearCanco(session, crearCanco));

		// actualizarCanco(session, 2, 2021, "04:30");

		eliminarCanco(session, 5);
		// eliminarTodaLaTabla(session);
		// session.clear();
		session.close();

	}

	private static void selectCanco(Session session, int id) {
		session.beginTransaction();

		Canco cancoSelccionada = (Canco) session.get(Canco.class, id);
		System.out.println(cancoSelccionada.toString());

		session.getTransaction().commit();
	}

	private static void selectTotesCancons(Session session) {
		session.beginTransaction();

		ArrayList<Canco> cancos = (ArrayList<Canco>) session.createQuery("FROM Canco", Canco.class).getResultList(); // FROM
																														// 'Canco'
																														// =>
																														// NOM
																														// DE
																														// CLASE
																														// (NO
																														// DE
																														// LA
																														// TABLA)

		for (Canco canco : cancos) {
			System.out.println(canco.toString());
		}
		// session.getTransaction().commit();

	}

	public static Serializable crearCanco(Session session, Canco canco) {
		// Canco crearCanco = new Canco("H20", "Leiti", "2:20", 2021);
		session.beginTransaction();
		Serializable id = session.save(canco);
		session.getTransaction().commit();
		return id; // Si no ha fallo throw un error, no se guarda null.
	}

	public static void actualizarCanco(Session session, int id, int any, String duracio) {
		// Exemple de actualizar per altre parametre (nombre)
//		Canco canco = (Canco) session.createQuery("FROM Canco WHERE nombre = :nombre")
//		        .setParameter("nombre", nombre)
//		        .uniqueResult();
//
//		    if (canco != null) {
//		        canco.setAny(any);
//		        canco.setDuracio(duracio);
//		        session.update(canco);
//		    }

		session.beginTransaction();
		Canco canco = (Canco) session.load(Canco.class, id);

		canco.setAny(any);
		canco.setDuracio(duracio);

		session.update(canco);
		session.getTransaction().commit();
	}

	public static void eliminarCanco(Session session, int id) {
		session.beginTransaction();
		Canco canco = new Canco();

		canco.setId(id);
		session.delete(canco);
		session.getTransaction().commit();
	}

	public static void eliminarTodaLaTabla(Session session) {
		session.beginTransaction();
		Query queryObject = session.createQuery("DELETE FROM cançons"); // FROM 'cançons' => NOM DE TAULA BBDD (NO
																		// DE LA CLASE)
		queryObject.executeUpdate();
		session.getTransaction().commit();
	}

}
