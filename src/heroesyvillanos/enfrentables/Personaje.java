package heroesyvillanos.enfrentables;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import heroesyvillanos.enfrentables.atributos.Atributo;

public class Personaje extends Enfrentable {
	
	private Map<String, Atributo> atributos;
	
	public Personaje(String nombre, String nombreFantasia) {
		this.atributos = new HashMap<String, Atributo>();
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
	}
	
	
	@Override
	public float getValorAtributo(String key) {
		Atributo a = atributos.get(key);
		if(a == null)
			return 0;
		return a.getValor(this)	;
	}

	@Override
	protected List<Personaje> getPersonajes() {
		List<Personaje> personaje = new LinkedList<Personaje>();
		personaje.add(this);
		return personaje;
	}
	
	public Boolean addAtributo(String key, Atributo a) {
		try {
			atributos.put(key, a);
		}catch (Exception e) {
			return false;
		}
		return true;
		
	}

}
