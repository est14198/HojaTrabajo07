/**
 * Universidad del Valle de Guatemala 
 * BST.java 
 * Algoritmos y Estructura de Datos - Seccion 10 
 * Maria Fernanda Estrada y Carlos Arroyave 
 * Tomado de: http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 * @since 22 Marzo 2017
 */



public class BST<E extends Comparable<E>> {
	
	// Variable del nodo
	private Node<E> root;

	
	// Obtener el nodo
	public Node<E> getRoot() {
		return root;
	}

	
	// Colocar un nodo
	public void setRoot(Node<E> root) {
		this.root = root;
	}


	// Constructor
	public BST() {
		this.root = null;
	}

	
	// Encontrar y devolver un elemento del BST
	public E find(E id) {
		Node<E> current = root;
		while (current != null) {
			if (current.data.equals(id)) {
				return current.data;
			} else if (current.data.compareTo(id) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}

	
	// Eliminar un elemento
	public boolean delete(E id) {
		Node<E> parent = root;
		Node<E> current = root;
		boolean isLeftChild = false;
		while (!current.data.equals(id)) {
			parent = current;
			if (current.data.compareTo(id) > 0) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}	
		// Case 1: Si el nodo no tiene hijos
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			}
			if (isLeftChild == true) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		// Case 2 : Si el nodo solo tiene un hijo
		else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else if (current.left != null && current.right != null) {

			Node<E> successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	
	// Obtener el nodo sucesor
	public Node<E> getSuccessor(Node<E> deleleNode) {
		Node<E> successsor = null;
		Node<E> successsorParent = null;
		Node<E> current = deleleNode.right;
		while (current != null) {
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		if (successsor != deleleNode.right) {
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}

	
	// Insertar un nuevo elemento
	public void insert(E id) {
		Node<E> newNode = new Node<E>(id);
		if (root == null) {
			root = newNode;
			return;
		}
		Node<E> current = root;
		Node<E> parent = null;
		while (true) {
			parent = current;
			if (current.data.compareTo(id) > 0) {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	
	// Mostrar el nodo
	public void display(Node<E> root) {
		if (root != null) {
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
}

// Clase del nodo
class Node<E> {
	E data;
	Node<E> left;
	Node<E> right;

	public Node(E data) {
		this.data = data;
		left = null;
		right = null;
	}
}