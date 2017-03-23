/**
 * Universidad del Valle de Guatemala
 * Association.java
 * Algoritmos y Estructura de Datos - Seccion 10
 * Maria Fernanda Estrada y Carlos Arroyave
 * Tomado de: (c) 1998,2001 Duane A. Bailey
 * @since 22 Marzo 2017
 */



public class Association<K extends Comparable<K>,V> implements Comparable<Association<K,V>> {
    
	// La llave
    protected K theKey;
    // El valor para esa llave
    protected V theValue;

    
    /**
     * Constructor si se tiene una llave y un valor
     * @pre La llave no es null
     * @post Se realiza un par entre llave y valor
     * @param key Objeto no null
     * @param value Objeto (puede ser nulo)
     */
    public Association(K key, V value) {
        theKey = key;
        theValue = value;
    }

    
    /**
     * Constructs si solo se tiene una llave
     * @pre La llave no es null
     * @post Se realiza un par entre llave y valor pero el valor es null
     * @param key valor no null
     */
    public Association(K key) {
        this(key,null);
    }

    
    /**
     * Comparacion de keys unicamente
     * @pre other es una Asociacion no null
     * @post regresa True si las keys son iguales
     * @param other Otra asociacion
     * @return True si las keys son iguales
     */
    public boolean equals(Object other) {
        @SuppressWarnings("unchecked")
		Association<K, V> otherAssoc = (Association<K, V>)other;
        return getKey().equals(otherAssoc.getKey());
    }
    
    
    /**
     * Obtener el hashcode
     * @post Regresa el hashcode de la asociacion con esta asociacion
     * @return HashCode para asociacion
     */
    public int hashCode() {
        return getKey().hashCode();
    }
    
    
    /**
     * Dar el valor de la asociacion
     * @post Regresa el valor que tiene en la asociacion
     * @return Valor del par
     */
    public V getValue() {
        return theValue;
    }

    
    /**
     * Dar el key de la asociacion
     * @post Regresa el key de la asociacion
     * @return Key del par
     */
    public K getKey() {
        return theKey;
    }

    
    /**
     * Colocar el valor del par
     * @post Coloca el valor nuevo
     * @param value El nuevo valor
     */
    public V setValue(V value) {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    
    /**
     * Mostrar la asociacion
     * @post Regresa un string
     * @return String que muestra la asociacion
     */
    public String toString() {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+ getKey() +"="+ getValue() +">\n");
        return s.toString();
    }

    
    /**
     * Comparar los keys
     * @post Regresa 1, 0 o -1
     * @return int para indicar si uno es mayor, uno es menor o si son iguales
     */
	@Override
	public int compareTo(Association<K, V> arg0) {
		return theKey.compareTo(arg0.getKey());
	}
    
}