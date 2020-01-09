package main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import biblioteca.Autor;
import biblioteca.Biblioteca;
import biblioteca.Llibres;
import biblioteca.Persona;
import persistencia.HibernateUtil;

public class HibernateManager {

	static Scanner lectorInt;
	static Scanner lectorString;

	// BIBLIOTECA
	public static void insertarBiblioteca() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// creamos un objeto biblioteca
		Biblioteca b = new Biblioteca();
		try {
			System.out.println("\nInserta id_biblioteca:");
			int id_biblioteca = lectorInt.nextInt();
			System.out.println("Inserta nom:");
			String nom = lectorString.nextLine();
			b.setIdBiblioteca(id_biblioteca);
			b.setNom(nom);
			// save y commit sino rollback
			session.save(b);
			transaction.commit();
			System.out.println("\nBiblioteca '" + b.getNom() + "' insertada.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut insertar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void modificarBiblioteca() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Biblioteca b = new Biblioteca();
		try {
			System.out.println("\nInserta id_biblioteca:");
			int id_biblioteca = lectorInt.nextInt();
			System.out.println("Inserta el nou nom:");
			String nom = lectorString.nextLine();
			// load objeto biblioteca pasandole el id y actualizamos el nombre
			b = (Biblioteca) session.load(Biblioteca.class, id_biblioteca);
			b.setNom(nom);
			transaction.commit();
			System.out.println("\nBiblioteca actualitzada.");
			System.out.println(b.getIdBiblioteca() + "\t" + b.getNom());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut modificar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void eliminarBiblioteca() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Biblioteca b = new Biblioteca();
		try {
			System.out.println("\nInserta id_biblioteca:");
			int id_biblioteca = lectorInt.nextInt();
			// load objeto biblioteca pasandole el id y lo eliminamos
			b = (Biblioteca) session.load(Biblioteca.class, id_biblioteca);
			session.delete(b);
			transaction.commit();
			System.out.println("\nBiblioteca eliminada.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut eliminar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void mostrarBiblioteca() {
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// list de todas las bibliotecas usando la query
			List<Biblioteca> result = (List<Biblioteca>) session.createQuery("from Biblioteca").list();
			transaction.commit();
			System.out.println("\n-Llistat Biblioteques-");
			// foreach recorriendo y printando los datos
			for (Biblioteca b : result)
				System.out.println(b.getIdBiblioteca() + "\t" + b.getNom());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("No se ha encontrado resultado.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	// PERSONA
	public static void insertarPersona() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// creamos un objeto persona
		Persona p = new Persona();
		try {
			System.out.println("\nInserta dni:");
			String dni = lectorString.nextLine();
			System.out.println("Inserta nom_persona:");
			String nom_persona = lectorString.nextLine();
			System.out.println("Inserta telefon:");
			int telefon = lectorInt.nextInt();
			p.setDni(dni);
			p.setNomPersona(nom_persona);
			p.setTelefon(telefon);
			// save y commit sino rollback
			session.save(p);
			transaction.commit();
			System.out.println("\nPersona '" + p.getNomPersona() + "' insertada.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut insertar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void modificarPersona() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Persona p = new Persona();
		try {
			System.out.println("\nInserta dni:");
			String dni = lectorString.nextLine();
			System.out.println("Inserta el nou nom_persona:");
			String nom_persona = lectorString.nextLine();
			System.out.println("Inserta el nou telefon:");
			int telefon = lectorInt.nextInt();
			// load objeto persona pasando id y actualizamos el nombre y
			// telefono
			p = (Persona) session.load(Persona.class, dni);
			p.setNomPersona(nom_persona);
			p.setTelefon(telefon);
			transaction.commit();
			System.out.println("\nPersona actualitzada.");
			System.out.println(p.getDni() + "\t" + p.getNomPersona() + "\t" + p.getTelefon());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut modificar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void eliminarPersona() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Persona p = new Persona();
		try {
			System.out.println("\nInserta dni:");
			String dni = lectorString.nextLine();
			// load objeto persona pasandole el id y lo eliminamos
			p = (Persona) session.load(Persona.class, dni);
			session.delete(p);
			transaction.commit();
			System.out.println("\nPersona eliminada.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut eliminar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void mostrarPersona() {
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// list de todas las personas usando la query
			List<Persona> result = (List<Persona>) session.createQuery("from Persona").list();
			transaction.commit();
			System.out.println("\n-Llistat Persones-");
			// foreach recorriendo y printando los datos
			for (Persona p : result)
				System.out.println(p.getDni() + "\t" + p.getNomPersona() + "\t" + p.getTelefon());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("No se ha encontrado resultado.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	// AUTOR
	public static void insertarAutor() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// creamos un objeto autor
		Autor a = new Autor();
		try {
			System.out.println("\nInserta id_autor:");
			int id_autor = lectorInt.nextInt();
			System.out.println("Inserta nom_autor:");
			String nom_autor = lectorString.nextLine();
			a.setIdAutor(id_autor);
			a.setNomAutor(nom_autor);
			// save y commit sino rollback
			session.save(a);
			transaction.commit();
			System.out.println("\nAutor '" + a.getNomAutor() + "' insertat.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut insertar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void modificarAutor() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Autor a = new Autor();
		try {
			System.out.println("\nInserta id_autor:");
			int id_autor = lectorInt.nextInt();
			System.out.println("Inserta el nou nom_autor:");
			String nom_autor = lectorString.nextLine();
			// load objeto autor pasando id y actualizamos el nombre
			a = (Autor) session.load(Autor.class, id_autor);
			a.setNomAutor(nom_autor);
			transaction.commit();
			System.out.println("\nAutor actualitzat.");
			System.out.println(a.getIdAutor() + "\t" + a.getNomAutor());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut modificar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void eliminarAutor() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Autor a = new Autor();
		try {
			System.out.println("\nInserta id_autor:");
			int id_autor = lectorInt.nextInt();
			// load objeto autor pasandole el id y lo eliminamos
			a = (Autor) session.load(Autor.class, id_autor);
			session.delete(a);
			transaction.commit();
			System.out.println("\nAutor eliminat.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut eliminar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void mostrarAutor() {
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// list de todos los autors usando la query
			List<Autor> result = (List<Autor>) session.createQuery("from Autor").list();
			transaction.commit();
			System.out.println("\n-Llistat Autors-");
			// foreach recorriendo y printando los datos
			for (Autor a : result)
				System.out.println(a.getIdAutor() + "\t" + a.getNomAutor());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("No se ha encontrado resultado.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	// LLIBRES
	public static void insertarLlibre() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		// creamos un objeto llibre
		Llibres ll = new Llibres();
		Autor a = new Autor();
		try {
			System.out.println("\nInserta id_llibre:");
			int id_llibre = lectorInt.nextInt();
			System.out.println("Inserta nom_llibre:");
			String nom_llibre = lectorString.nextLine();
			System.out.println("Inserta editoria:");
			String editoria = lectorString.nextLine();
			System.out.println("Inserta id_autor:");
			int id_autor = lectorInt.nextInt();
			ll.setIdLlibre(id_llibre);
			ll.setNomLlibre(nom_llibre);
			ll.setEditoria(editoria);
			a.setIdAutor(id_autor);
			ll.setAutor(a);
			// save y commit sino rollback
			session.save(ll);
			transaction.commit();
			System.out.println("\nLlibre '" + ll.getNomLlibre() + "' insertat.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut insertar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void modificarLlibre() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Llibres ll = new Llibres();
		Autor a = new Autor();
		try {
			System.out.println("\nInserta id_llibre:");
			int id_llibre = lectorInt.nextInt();
			System.out.println("Inserta el nou nom_llibre:");
			String nom_llibre = lectorString.nextLine();
			System.out.println("Inserta la nova editoria:");
			String editoria = lectorString.nextLine();
			System.out.println("Inserta el nou id_autor:");
			int id_autor = lectorInt.nextInt();
			// load objeto llibre pasando id y actualizamos datos
			ll = (Llibres) session.load(Llibres.class, id_llibre);
			ll.setNomLlibre(nom_llibre);
			ll.setEditoria(editoria);
			a.setIdAutor(id_autor);
			ll.setAutor(a);
			transaction.commit();
			System.out.println("\nLlibre actualitzat.");
			System.out.println(ll.getIdLlibre() + "\t" + ll.getNomLlibre() + "\t" + ll.getEditoria() + "\t"
					+ ll.getAutor().getIdAutor());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut modificar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void eliminarLlibre() {
		lectorInt = new Scanner(System.in);
		lectorString = new Scanner(System.in);
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Llibres ll = new Llibres();
		try {
			System.out.println("\nInserta id_llibre:");
			int id_llibre = lectorInt.nextInt();
			// load objeto llibre pasandole el id y lo eliminamos
			ll = (Llibres) session.load(Llibres.class, id_llibre);
			session.delete(ll);
			transaction.commit();
			System.out.println("\nLlibre eliminat.");
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("\nError! No s'ha pogut eliminar.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}

	public static void mostrarLlibre() {
		// session y transaction
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			// list de todos los llibres usando la query
			List<Llibres> result = (List<Llibres>) session.createQuery("from Llibres").list();
			transaction.commit();
			System.out.println("\n-Llistat Llibres-");
			// foreach recorriendo y printando los datos
			for (Llibres ll : result)
				System.out.println(ll.getIdLlibre() + "\t" + ll.getNomLlibre() + "\t" + ll.getEditoria() + "\t"
						+ ll.getAutor().getIdAutor());
		} catch (RuntimeException e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("No se ha encontrado resultado.");
		} finally {
			// cerramos sesion
			session.close();
		}
	}
}
