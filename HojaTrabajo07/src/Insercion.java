import static org.junit.Assert.*;

import org.junit.Test;

public class Insercion {

	@Test
	public void test() {
		BST<Association<String, String>> b = new BST<>();
		Association<String, String> a = new Association<String, String>("perro", "dog");
		b.insert(a);
		Association<String, String> buscar = b.find(a);
		a.equals(buscar);
		
	}

}
