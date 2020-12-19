package heroesyvillanos.enfrentables.atributos;

import heroesyvillanos.enfrentables.Enfrentable;

public class AtributoSimple implements Atributo {
	
	private float value;
	
	public AtributoSimple(float value){
		this.value = value;
	}
	
	public float getValor(Enfrentable e) {
		return value;
	}
	
}
