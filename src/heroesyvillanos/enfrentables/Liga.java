package heroesyvillanos.enfrentables;
import java.util.LinkedList;
import java.util.List;

public class Liga extends Enfrentable {

	private List<Enfrentable> integrantes;
	
	public Liga(String nombre, String nombreFantasia) {
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.integrantes = new LinkedList<Enfrentable>();
	}
	
	public Liga(String nombre, String nombreFantasia, Liga liga) {
		this.nombre = nombre;
		this.nombreFantasia = nombreFantasia;
		this.integrantes = new LinkedList<Enfrentable>();
		this.integrantes.addAll(liga.getPersonajes());
	}
	
	public Boolean addIntegrante(Enfrentable e) {
		return integrantes.add(e);
	}
	
	@Override
	public float getValorAtributo(String key) {
		float res = (float)integrantes.stream()
				.mapToDouble(e -> e.getValorAtributo(key))
				.average().getAsDouble();
		return res;
	}

	@Override
	protected List<Personaje> getPersonajes() {
		List<Personaje> pjs = new LinkedList<Personaje>();
		for (Enfrentable enfrentable : integrantes) {
			pjs.addAll(enfrentable.getPersonajes());
		}
		return pjs;
	}

}
