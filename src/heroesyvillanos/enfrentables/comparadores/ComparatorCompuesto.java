package heroesyvillanos.enfrentables.comparadores;

import java.io.InvalidObjectException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import heroesyvillanos.enfrentables.Enfrentable;

public class ComparatorCompuesto implements Comparator<Enfrentable> {

	List<Comparator<Enfrentable>> comparators;

	public ComparatorCompuesto() {
		this.comparators = new LinkedList<Comparator<Enfrentable>>();
	}

	public ComparatorCompuesto(List<Comparator<Enfrentable>> comparators) {
		this.comparators = comparators;
	}

	public boolean addComparator(Comparator<Enfrentable> c) {
		if (c == this)
			return false;
		return comparators.add(c);
	}

	public boolean addComparator(Comparator<Enfrentable> c, int index) {
		if (c == this)
			return false;
		comparators.add(index, c);
		return true;
	}

	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {
		int resultado;
		for (Comparator<Enfrentable> comparator : comparators) {
			resultado = comparator.compare(e1, e2);
			if (resultado != 0)
				return resultado;
		}
		return 0;
	}

}
