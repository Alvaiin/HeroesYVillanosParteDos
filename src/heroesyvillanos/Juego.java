package heroesyvillanos;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import heroesyvillanos.enfrentables.Enfrentable;
import heroesyvillanos.enfrentables.Personaje;

public class Juego {

	private List<Enfrentable> enfrentables;
	
	public Juego() {
		this.enfrentables = new LinkedList<Enfrentable>();
	}
	
	public List<Enfrentable> getQuienesVence(Enfrentable e,Comparator<Enfrentable> c){
		List<Enfrentable> vencen = enfrentables.stream()
											   .filter(f -> c.compare(e, f) < 0)
											   .collect(Collectors.toList());
		
		return vencen;
	}
	
	public Enfrentable enfrentar(Enfrentable e1, Enfrentable e2, Comparator<Enfrentable> c) {
		return e1.enfrentar(e2, c);
	}
	
	public Boolean addEnfrentable(Enfrentable e) {
		return enfrentables.add(e);
	}
	
	public List<Personaje> ordenarPersonajes(Comparator<Enfrentable> c) {
		
		List<Personaje> ordenados = enfrentables.stream()
												  .map(f -> f.ordenar(c))
												  .flatMap(List::stream)
												  .distinct()
												  .sorted(c)
												  .collect(Collectors.toList());
		
		return ordenados;
	}
}
