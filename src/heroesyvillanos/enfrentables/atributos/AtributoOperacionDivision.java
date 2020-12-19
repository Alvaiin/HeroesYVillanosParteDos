package heroesyvillanos.enfrentables.atributos;

import heroesyvillanos.enfrentables.Enfrentable;

public class AtributoOperacionDivision extends AtributoOperacion {

	public AtributoOperacionDivision(String key1, String key2) {
		super(key1, key2);
	}

	@Override
	public float getValor(Enfrentable e) {
		return e.getValorAtributo(key1)/e.getValorAtributo(key2);
	}

}
