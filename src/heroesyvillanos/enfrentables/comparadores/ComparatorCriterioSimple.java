package heroesyvillanos.enfrentables.comparadores;

import java.util.Comparator;

import heroesyvillanos.enfrentables.Enfrentable;

public class ComparatorCriterioSimple implements Comparator<Enfrentable> {

	private String atributo;
	
	public ComparatorCriterioSimple(String atributo) {
		this.atributo = atributo;
	}
	
	@Override
	public int compare(Enfrentable e1, Enfrentable e2) {		 
		Float valor1 = e1.getValorAtributo(atributo);
		Float valor2 = e2.getValorAtributo(atributo);
		return valor1.compareTo(valor2);
	}

}
