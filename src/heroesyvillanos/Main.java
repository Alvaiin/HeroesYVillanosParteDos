package heroesyvillanos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import heroesyvillanos.Juego;
import heroesyvillanos.enfrentables.Enfrentable;
import heroesyvillanos.enfrentables.Liga;
import heroesyvillanos.enfrentables.Personaje;
import heroesyvillanos.enfrentables.atributos.AtributoOperacionDivision;
import heroesyvillanos.enfrentables.atributos.AtributoSimple;
import heroesyvillanos.enfrentables.comparadores.ComparatorCompuesto;
import heroesyvillanos.enfrentables.comparadores.ComparatorCriterioSimple;

public class Main {

	public static void main(String[] args) {
		Personaje pj1 = new Personaje("Personaje 1", "PJ1");
		pj1.addAtributo("Fuerza", new AtributoSimple(110));
		pj1.addAtributo("Velocidad", new AtributoSimple(80));
		pj1.addAtributo("Resistencia", new AtributoOperacionDivision("Fuerza", "Velocidad"));
		
		Personaje pj2 = new Personaje("Personaje 2", "PJ2");
		pj2.addAtributo("Fuerza", new AtributoSimple(101));
		pj2.addAtributo("Velocidad", new AtributoSimple(90));
		pj2.addAtributo("Resistencia", new AtributoOperacionDivision("Fuerza", "Velocidad"));
		
		Personaje pj3 = new Personaje("Personaje 3", "PJ3");
		pj3.addAtributo("Fuerza", new AtributoSimple(100));
		pj3.addAtributo("Velocidad", new AtributoSimple(100));
		pj3.addAtributo("Resistencia", new AtributoOperacionDivision("Fuerza", "Velocidad"));
		
		Personaje pj4 = new Personaje("Personaje 4", "PJ4");
		pj4.addAtributo("Fuerza", new AtributoSimple(160));
		pj4.addAtributo("Velocidad", new AtributoSimple(100));
		pj4.addAtributo("Resistencia", new AtributoOperacionDivision("Fuerza", "Velocidad"));
		
		Personaje pj5 = new Personaje("Personaje 5", "PJ5");
		pj5.addAtributo("Fuerza", new AtributoSimple(110));
		pj5.addAtributo("Velocidad", new AtributoSimple(100));
		pj5.addAtributo("Resistencia", new AtributoOperacionDivision("Fuerza", "Velocidad"));
		
		
		Juego juego = new Juego();
		
		juego.addEnfrentable(pj1);
		juego.addEnfrentable(pj2);
		juego.addEnfrentable(pj3);
		juego.addEnfrentable(pj4);
		juego.addEnfrentable(pj5);
		
		Liga liga1 = new Liga("Liga 1", "L1");
		liga1.addIntegrante(pj3);
		liga1.addIntegrante(pj4);
		liga1.addIntegrante(pj5);
		juego.addEnfrentable(liga1);
		
		Comparator<Enfrentable> c = new ComparatorCriterioSimple("Fuerza");
		System.out.println(pj1.enfrentar(pj2, c).getNombre());
		
		List<Comparator<Enfrentable>> listComparators = new ArrayList<Comparator<Enfrentable>>();
		listComparators.add(c);
		listComparators.add(new ComparatorCriterioSimple("Velocidad"));
		
		
		System.out.println(pj1.enfrentar(pj2, new ComparatorCompuesto(listComparators)).getNombre());
		
		System.out.println(liga1.enfrentar(pj1, c).getNombre());
		
		System.out.println(pj2.enfrentar(liga1, c).getNombre());
		
		System.out.println(pj2.enfrentar(liga1,new ComparatorCompuesto(listComparators)).getNombre());
		
		System.out.println(pj1.enfrentar(pj2, new ComparatorCriterioSimple("Resistencia")).getNombre());
		
		System.out.println("Vencen a pj2 en fuerza:");
		List<Enfrentable> vencen = juego.getQuienesVence(pj2, c);
		for (Enfrentable enfrentable : vencen) {
			System.out.println(enfrentable.getNombre());
		}
		
		System.out.println("Personajes ordenados por fuerza");
		List<Personaje> ordenados = juego.ordenarPersonajes(c);
		for (Enfrentable enfrentable : ordenados) {
			System.out.println(enfrentable.getNombre());
		}
		

	}

}
