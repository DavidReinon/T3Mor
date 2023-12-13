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

		// LLegir (select)
		Canco canco1 = (Canco) session.get(Canco.class, 1);
		System.out.println(canco1.toString());

		// LLegir tota la taula (select *)
		List<Canco> listaCanciones = new ArrayList<Canco>();
		listaCanciones = session.createQuery("FROM Canco", Canco.class).getResultList();

		for (Canco canco : listaCanciones) {
			System.out.println(canco.toString());
		}
		// Cancion => NOM DE CLASE (NO DE LA TABLA)

		// Crear
//		Canco crearCanco = new Canco("H20", "Leiti", "2:20", 2021);
//		Serializable id = session.save(crearCanco);

		// Actualizar
//		Canco cancion2 = (Canco) session.load(Canco.class, 2);
//		cancion2.setAny(2010);
//		cancion2.setDuracio("02:30");
//		session.update(cancion2);

		// Eliminar
//		Canco cancion3 = new Canco();
//		cancion3.setId(3);
//		session.delete(cancion3);

		// Eliminar tota la tabla
//		Query queryObject = session.createQuery("DELETE FROM canciones");
		// canciones => NOM DE TAULA BBDD (NO DE LA CLASE)
//		queryObject.executeUpdate();

		// Commit de la transacció i tanca de sessió
		session.getTransaction().commit();
		session.clear();
		session.close();

	}

}
