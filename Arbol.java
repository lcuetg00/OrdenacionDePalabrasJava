import java.util.ArrayList;


public class Arbol {
	public final int primerCaracter='A';
	public final int numeroCaracteres='Z'-'A'+1;
	
	Nodo raiz;
	
	public Arbol() {
		raiz = new Nodo(null);
	}
	
	/**
	 * Inserta una palabra en el arbol.
	 * Precondicion: s solo debe de contener caracteres mayuscula y no debe tener
	 * espacios.
	 * @param s
	 */
	public void insertar(String s) {
		Nodo siguienteNodo = raiz;
		for(int i=0;i < s.length();i++) {
			int posicion = s.charAt(i) - primerCaracter;
			if(siguienteNodo.arrayNodos[posicion] == null) {
				siguienteNodo.arrayNodos[posicion] = new Nodo(siguienteNodo);
			}
			siguienteNodo = siguienteNodo.arrayNodos[posicion];
		}
		siguienteNodo.terminaPalabra = true;
	}
	
	public void insertarListaPalabras(String[] lista) {
		for(int i=0;i < lista.length;i++) {
			insertar(lista[i].toUpperCase());
		}
	}
	
	/**
	 * Devuelve una lista de palabras ordenadas a partir de palabras previamente insertadas.
	 * @return
	 */
	public ArrayList<String> recogerPalabras() {
		ArrayList <String> cadenas=new ArrayList<>();
		ArrayList <Character> letras=new ArrayList<>();
		Nodo siguienteNodo = raiz;
		boolean terminado = true; //Variable para saber si se ha terminado de recorrer el arbol
		int i = 0;
		
		do {
			for(;i<numeroCaracteres;i++) {
				if(siguienteNodo.arrayNodos[i]!=null) {
					char letra = (char)(primerCaracter+i);
					letras.add(letra);
					siguienteNodo = siguienteNodo.arrayNodos[i];
					i = -1; //reinicio el puntero para empezar en A del siguiente caracter
					if(siguienteNodo.terminaPalabra==true) {
						char[] c = new char[letras.size()];
						for (int j=0; j < letras.size(); j++) {
							c[j] = letras.get(j).charValue();
						}
						cadenas.add(new String(c));
					}
				}
			}
			if (siguienteNodo != raiz) {
				siguienteNodo = siguienteNodo.nodoPadre;
				i = letras.get(letras.size()-1)-primerCaracter+1;
				letras.remove(letras.size()-1);
			} else {
				terminado = false;
			}
			
		} while(terminado);
		
		return cadenas;
	}
	
	public class Nodo {
		Nodo[] arrayNodos;
		Nodo nodoPadre;
		boolean terminaPalabra = false;
		
		protected Nodo(Nodo nodoPadre) {
			arrayNodos = new Nodo[numeroCaracteres];
			this.nodoPadre = nodoPadre;
		}
	}
}
