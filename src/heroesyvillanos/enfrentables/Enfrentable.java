package heroesyvillanos.enfrentables;
import java.util.Comparator;
import java.util.List;

public abstract class Enfrentable {
	
	protected String nombre;
	protected String nombreFantasia;
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getNombreFantasia() {
		return this.nombreFantasia;
	}
	
	public abstract float getValorAtributo(String key);
	
	public Enfrentable enfrentar(Enfrentable e, Comparator<Enfrentable> c) {
		int resultado = c.compare(this, e);
		if(resultado==0)
			return null;
		return resultado>0?this:e;
	}
	
	public List<Personaje> ordenar(Comparator<Enfrentable> c) {
		List<Personaje> ordenados = getPersonajes();
		ordenados.sort(c);
		return ordenados;
	}
	
	protected abstract List<Personaje> getPersonajes();
}
