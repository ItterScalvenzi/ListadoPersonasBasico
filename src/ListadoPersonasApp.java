import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonasApp {

	public static void main(String[] args) {
		Scanner consola = new Scanner(System.in);
		
		List<Persona> personas = new ArrayList<>(); 
		
		var salir = false;
		while(!salir) {
			mostrarMenu();
			try {
				salir = ejecutarOperacion(consola, personas);
			} catch(Exception e) {
				System.out.println("Ocurrió un error: " +e.getMessage());
			}
			System.out.println();
		}
	}

	private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch(opcion) {
			case 1 ->{
				System.out.println("Ingrese el nombre: ");
				var nombre = consola.nextLine();
				System.out.println("Ingrese el telefono: ");
				var tel = consola.nextLine();
				System.out.println("ingrese el email: ");
				var email = consola.nextLine();
				personas.add(new Persona(nombre, tel, email));
				System.out.println("Total de personas en la lista " +personas.size());
				break;
			}
			case 2 ->{
				System.out.println("**** Listado de Personas ****");
				personas.forEach(System.out::println);
			}
			case 3 ->{
				System.out.println("Hasta pronto...");
				salir = true;
			}
			default -> System.out.println("Opcion incorrecta: " +opcion);
		}
		return salir;
	}

	private static void mostrarMenu() {
		System.out.println("""
				**** Listado de Personas App ***
				1. Agregar
				2. Listar
				3. Salir
				""");
		System.out.print("Elige una opcion : ");
		
	}
}
