package heroesyvillanos.enfrentables.comparadores;

import java.util.Comparator;

import heroesyvillanos.enfrentables.Enfrentable;

public class ComparatorNombre implements Comparator<Enfrentable> {

	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		return e1.getNombre().compareTo(e2.getNombre());
	}

}
