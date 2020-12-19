package heroesyvillanos.enfrentables.atributos;

import heroesyvillanos.enfrentables.Enfrentable;

public class AtributoCondicional implements Atributo {

	private String key1;
	private String key2;
	private Atributo keyThen;
	private Atributo keyElse;
	
	public AtributoCondicional(String key1, String key2, Atributo keyThen, Atributo keyElse) {
		super();
		this.key1 = key1;
		this.key2 = key2;
		this.keyThen = keyThen;
		this.keyElse = keyElse;
	}


	@Override
	public float getValor(Enfrentable e) {
		return e.getValorAtributo(key1)>e.getValorAtributo(key2)?keyThen.getValor(e):keyElse.getValor(e);
	}

}
