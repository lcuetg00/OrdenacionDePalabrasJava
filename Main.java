import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String[] lista = new String[] {"hola","mundo","mango",};
		
		Arbol arbol = new Arbol();
		arbol.insertarListaPalabras(lista);
		
		ArrayList<String> listaOrdenada = arbol.recogerPalabras();
		
		for(int i=0; i < listaOrdenada.size();i++) {
			System.out.println(listaOrdenada.get(i));
		}
		
	}
}
