package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		menuPrincipal();
	}

	public static void menuPrincipal() {
		Scanner lector = new Scanner(System.in);
		int i = 0;
		while (i != 5) {
			System.out.println("\nMENU PRINCIPAL");
			System.out.println("   1. Biblioteques");
			System.out.println("   2. Persones");
			System.out.println("   3. Autors");
			System.out.println("   4. Llibres");
			System.out.println("   5. Sortir");
			System.out.print("Escriu una opcio: ");
			i = lector.nextInt();
			if (i > 0 && i < 6) {
				switch (i) {
				case 1:
					menuBiblioteques();
					break;
				case 2:
					menuPersones();
					break;
				case 3:
					menuAutors();
					break;
				case 4:
					menuLlibres();
					break;
				default:
					System.out.println("\nAdeu!");
					break;
				}
			} else
				System.out.println("\nError! Valor incorrecte.");
		}
		lector.close();
	}

	public static void menuBiblioteques() {
		Scanner lector = new Scanner(System.in);
		int i = 0;
		while (i != 5) {
			System.out.println("\nBIBLIOTEQUES");
			System.out.println("   1. Insertar");
			System.out.println("   2. Modificar");
			System.out.println("   3. Eliminar");
			System.out.println("   4. Mostrar");
			System.out.println("   5. Menu Principal");
			System.out.print("Escriu una opcio: ");
			i = lector.nextInt();
			if (i > 0 && i < 6) {
				switch (i) {
				case 1:
					HibernateManager.insertarBiblioteca();
					break;
				case 2:
					HibernateManager.modificarBiblioteca();
					break;
				case 3:
					HibernateManager.eliminarBiblioteca();
					break;
				case 4:
					HibernateManager.mostrarBiblioteca();
					break;
				default:
					break;
				}
			} else
				System.out.println("\nError! Valor incorrecte.");
		}
	}

	public static void menuPersones() {
		Scanner lector = new Scanner(System.in);
		int i = 0;
		while (i != 5) {
			System.out.println("\nPERSONES");
			System.out.println("   1. Insertar");
			System.out.println("   2. Modificar");
			System.out.println("   3. Eliminar");
			System.out.println("   4. Mostrar");
			System.out.println("   5. Menu Principal");
			System.out.print("Escriu una opcio: ");
			i = lector.nextInt();
			if (i > 0 && i < 6) {
				switch (i) {
				case 1:
					HibernateManager.insertarPersona();
					break;
				case 2:
					HibernateManager.modificarPersona();
					break;
				case 3:
					HibernateManager.eliminarPersona();
					break;
				case 4:
					HibernateManager.mostrarPersona();
					break;
				default:
					break;
				}
			} else
				System.out.println("\nError! Valor incorrecte.");
		}
	}

	public static void menuAutors() {
		Scanner lector = new Scanner(System.in);
		int i = 0;
		while (i != 5) {
			System.out.println("\nAUTORS");
			System.out.println("   1. Insertar");
			System.out.println("   2. Modificar");
			System.out.println("   3. Eliminar");
			System.out.println("   4. Mostrar");
			System.out.println("   5. Menu Principal");
			System.out.print("Escriu una opcio: ");
			i = lector.nextInt();
			if (i > 0 && i < 6) {
				switch (i) {
				case 1:
					HibernateManager.insertarAutor();
					break;
				case 2:
					HibernateManager.modificarAutor();
					break;
				case 3:
					HibernateManager.eliminarAutor();
					break;
				case 4:
					HibernateManager.mostrarAutor();
					break;
				default:
					break;
				}
			} else
				System.out.println("\nError! Valor incorrecte.");
		}
	}

	public static void menuLlibres() {
		Scanner lector = new Scanner(System.in);
		int i = 0;
		while (i != 5) {
			System.out.println("\nLLIBRES");
			System.out.println("   1. Insertar");
			System.out.println("   2. Modificar");
			System.out.println("   3. Eliminar");
			System.out.println("   4. Mostrar");
			System.out.println("   5. Menu Principal");
			System.out.print("Escriu una opcio: ");
			i = lector.nextInt();
			if (i > 0 && i < 6) {
				switch (i) {
				case 1:
					HibernateManager.insertarLlibre();
					break;
				case 2:
					HibernateManager.modificarLlibre();
					break;
				case 3:
					HibernateManager.eliminarLlibre();
					break;
				case 4:
					HibernateManager.mostrarLlibre();
					break;
				default:
					break;
				}
			} else
				System.out.println("\nError! Valor incorrecte.");
		}
	}
}
