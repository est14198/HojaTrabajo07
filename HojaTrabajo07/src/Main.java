/**
 * Universidad del Valle de Guatemala
 * Main.java
 * Algoritmos y Estructura de Datos - Seccion 10
 * Maria Fernanda Estrada y Carlos Arroyave
 * @since 22 Marzo 2017
 */



import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Texto text = new Texto();
		BST<Association<String, String>> b = new BST<>();
		text.Leer(b);
		text.close();
		
		
		System.out.println("BST: ");
		b.display(b.getRoot());
	}

}
