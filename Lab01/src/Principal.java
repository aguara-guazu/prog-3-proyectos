import java.util.*;

public class Principal {

	public static void main(String[] args) {
		// Primero importé paquete java.util.* para utilizar el Collection Framework
		// Creé una colección lista de tipo Persona (entre ellas Alumnos y Profesores) - ver Tabla en hoja de cálculo
		List<Persona> lista = new ArrayList<Persona>();

		// Utilizo los datos construidos de la tabla. Cargo 10 Alumnos, luego 10
		// Profesores. Luego los desordeno con un algoritmo de dispersión/mezcla
		lista.add(new Alumno(789, "Borgert", "Manuel", 21, 'M', 30256945, 15418, 12, 7.59));
		lista.add(new Alumno(456, "Caceres", "Pablo", 25, 'M', 36258963, 15420, 11, 6.88));
		lista.add(new Alumno(123, "Espindola", "Daniel", 28, 'M', 37052963, 15496, 25, 8.96));
		lista.add(new Alumno(741, "Garcia", "Juan", 32, 'M', 37080136, 15434, 15, 6.92));
		lista.add(new Alumno(852, "Brunner", "Dario", 28, 'M', 31635896, 15475, 18, 9.22));
		lista.add(new Alumno(963, "Garcia", "Maria", 27, 'F', 35623541, 15485, 25, 9.56));
		lista.add(new Alumno(357, "Lopez", "Daniela", 22, 'F', 35896603, 15491, 24, 8.34));
		lista.add(new Alumno(159, "Wittmann", "Florencia", 28, 'F', 31456250, 15432, 12, 6.84));
		lista.add(new Alumno(654, "Grinovero", "Ximena", 29, 'F', 35963789, 15420, 13, 9.66));
		lista.add(new Alumno(321, "Taborda", "Marisa", 30, 'F', 31265458, 15431, 10, 7.66));

		lista.add(new Profesor(987, "Gomez", "Pedro", 45, 'M', 20596314, 15856, "Lic. en Tecnologías de la Información"));
		lista.add(new Profesor(153, "Fernandez", "Jorge", 50, 'M', 22565986, 15893, "Ing. en Sistemas"));
		lista.add(new Profesor(759, "Krenz", "Mario", 41, 'M', 14604028, 15832, "Ing. en Sistemas"));
		lista.add(new Profesor(756, "Acevedo", "Luis", 43, 'M', 14753652, 15842, "Analista en Sistemas"));
		lista.add(new Profesor(954, "Barrios", "Andres", 51, 'M', 14602031, 15823, "Lic. En Informática"));
		lista.add(new Profesor(356, "Acosta", "Ofelia", 50, 'F', 16166693, 15846, "Ing. en Sistemas"));
		lista.add(new Profesor(154, "Aguilar", "Norma", 46, 'F', 20639130, 15832, "Lic. en Bioinformática"));
		lista.add(new Profesor(520, "Fernandez", "Silvina", 49, 'F', 12745632, 15874, "Lic. en Bioinformática"));
		lista.add(new Profesor(120, "Altamirano", "Gabriela", 38, 'F', 17456012, 15863,"Lic. en Tecnologías de la Información"));
		lista.add(new Profesor(320, "Veron", "Cristina", 36, 'F', 15236578, 15871, "Analista en Sistemas"));

		System.out.println("\n---------------------------------- LISTA DE PERSONAS - CARGADAS -----------------------------------");
		// Imprimo para ver la lista original cargada de Persona
		for (Persona per : lista) {
			System.out.println(per.getInformación()); // generar otro método para recibir la info
		}

		// Aplico algoritmo de dispersión para mezclar de manera aleatoria los elementos
		// (objetos) contenidos
		Collections.shuffle(lista);
		
		System.out.println("\n---------------------------------- LISTA DE PERSONAS - DESORDENADA --------------------------------");
		// Imprimo la lista luego de aplicar dispersión aleatoria
		for (Persona per : lista) {
			System.out.println(per.getInformación()); // generar otro método para recibir la info
		}

		// De esta lista de Personas mezcladas, separo Alumnos y Profesores en dos listas respectivamente
		List<Alumno> alumnos = new ArrayList<Alumno>();
		List<Profesor> profesores = new ArrayList<Profesor>();

		// Recorro con foreach, pregunto si "tal" objeto es una instancia de Alumno o
		// Profesor
		// y lo agrego a listas separadas, casteando cada tipo
		for (Persona per : lista) {
			if (per instanceof Alumno) {
				alumnos.add((Alumno) per);
			} else
				profesores.add((Profesor) per);
		}

		// Trabajo con la lista de alumnos. Imprimo una línea de separación para guiarme
		System.out.println("\na)---------------------------------- ALUMNOS ORDENADOS POR APELLIDO Y NOMBRE -------------------------------------");

		// a. Ordenar los Alumnos por Apellido y luego por Nombre.
		// Llamo al método sort() de Collection que ordena la lista de alumnos
		Collections.sort(alumnos);

		// c. Identificar los alumnos que tienen un promedio mayor a 7, y esa lista ordenada por mayor promedio.
		
		// Imprimo la lista ordenada de alumnos por apellido, y si los apellidos son iguales pasa a ordenarlo por nombre
		// En este caso el apellido que se repite entre los alumnos es "Garcia".
		for (Alumno a : alumnos) {
			System.out.println(a.getApellido() + ", " + a.getNombre() + " - promedio: " + a.getPromedio());
		}
		
		System.out.println("\nc)---------------------- ALUMNOS CON PROMEDIO MAYOR A 7 ORDENADOS DE MAYOR A MENOR -----------------------");
		// Ordeno la lista de alumnos por promedio. Llamo a sort que implementa compare() de la interfaz Comparator
		Collections.sort(alumnos, new Alumno());

		// Imprimo la lista de promedios mayores a 7
		for(Alumno a : alumnos) {
			if (a.getPromedio()>7.0) {
				System.out.println(a.getApellido() + ", " + a.getNombre() + " - prom: " + a.getPromedio());
			}
		}
		
		System.out.println("\nd) y e)------------------------- MAYOR Y MENOR PROMEDIO DEL TOTAL DE ALUMNOS -----------------------------");
		// d. Identificar el mayor promedio. Sería el primer elemento de la lista de alumnos ordenados por promedios de Mayor a menos
		System.out.println("Mayor promedio: " + alumnos.get(0).getPromedio());
		// e. Identificar el menor promedio. Ingreso al último indice de la lista alumnos ordenad por promedios de Mayor a menor
		System.out.println("Menor promedio: " + alumnos.get(alumnos.size()-1).getPromedio());
		
		// Trabajo con la lista de profesores. Imprimo separación para guiarme
		System.out.println("\nb)------------------------------ PROFESORES ORDENADOS POR APELLIDO Y NOMBRE -------------------------------");

		// b. Ordenar los Profesores por Apellido y por Nombre.
		// Llamo al método sort() de Collection que ordena la lista de profesores
		Collections.sort(profesores);

		// Imprimo la lista ordenada de profesores por apellido, y si los apellidos son iguales pasa a ordenarlo por nombre
		// En este caso el apellido que se repite entre los profesores es "Fernandez".
		for (Profesor p : profesores) {
			System.out.println(p.getApellido() + ", " + p.getNombre() + " - " + p.getEdad() + " años");
		}

		
		// g. Ordenar los profesores de Mayor a Menor, imprimiendo sus datos por pantalla
		System.out.println("\ng)-------------------------- PROFESORES ORDENADOS POR EDAD DE MAYOR A MENOR ------------------------");
		
		// Llamo al método sort() que usa comparator
		Collections.sort(profesores, new Profesor());

		// Creo una lista para filtrar los proferos con título en Ing. en Sistemas
		List<Profesor> ingenieros = new ArrayList<Profesor>();
		
		// Imprimo los profesores ordenados de Mayor a Menor por edad, y en el mismo "for" filtro los profesores en la lista ingenieros
		// para imprimirlo después aparte
		for (Profesor p : profesores) {
			if (p.getTitulo().equals("Ing. en Sistemas")) {
			ingenieros.add(p);}
			System.out.println(p.getApellido() + ", " + p.getNombre() + "  - " + p.getEdad() + " años");
		}
		
		System.out.println("\nf)--------------------- PROFESORES QUE TIENEN TÍTULO DE INGENIERA EN SISTEMAS -----------------------\n");
		for (Profesor i : ingenieros) {
			System.out.println(i.getApellido() + ", " + i.getNombre());
		}
	}
}