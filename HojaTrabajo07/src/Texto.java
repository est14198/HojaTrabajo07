/**
 * Universidad del Valle de Guatemala
 * Texto.java
 * Algoritmos y Estructura de Datos - Seccion 10
 * Maria Fernanda Estrada y Carlos Arroyave
 * @since 22 Marzo 2017
 */



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Texto {
	
	FileReader fr;
	BufferedReader bf;
	
	public Texto() throws FileNotFoundException {
		fr = new FileReader("diccionario.txt");
		bf = new BufferedReader(fr);
	}
	
	
	public void close() throws IOException {
		bf.close();
	}
	
	
	public void Leer(BST<Association<String, String>> b) throws IOException {
		
		String cadena1;
		String cadena2;
		
		// Leer las asociaciones
		while((cadena1=bf.readLine())!=null)
		{
			cadena1 = cadena1.replaceAll("[()]", ""); 			
			String[] datos = cadena1.split("\\s*,\\s*");
			b.insert(new Association<String,String>(datos[0], datos[1]));
		} 
		
		// Leer el texto a traducir y lo traduce
		fr = new FileReader("texto.txt");
		bf = new BufferedReader(fr);
		String tradu = "";
		while((cadena2=bf.readLine())!=null)
		{
			System.out.println(cadena2);
			cadena2 = cadena2.replace(".", "");
			cadena2 = cadena2.toLowerCase();
			String[] datos2 = cadena2.split("\\s+");
			for (int i=0; i < datos2.length; i++) {
				Association<String, String> buscar = b.find(new Association<String, String>(datos2[i], ""));
				if(buscar != null) {
					tradu += buscar.getValue() + " ";
				} else {
					tradu += "*" + datos2[i] + "* ";
				}
				
		}
	} System.out.println(tradu);
}
}