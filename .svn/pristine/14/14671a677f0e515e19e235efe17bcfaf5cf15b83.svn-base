package ar.com.indexer.objetos;

public class ListaFrase {

	private String[] palabras;
	private int cantidadPalabras;
	private final static int TOTAL = 30;

	public ListaFrase() {

		palabras = new String[TOTAL];
		cantidadPalabras = 0;
	}

	public static int getTotal() {
		return TOTAL;
	}

	public void add(String palabra) {

		if (cantidadPalabras == TOTAL) {

			for (int i = 0; i < palabras.length - 1; i++) {

				palabras[i] = palabras[i + 1];

			}
			palabras[palabras.length-1] = palabra;
		} else {
			palabras[cantidadPalabras] = palabra;
			cantidadPalabras++;

		}

	}
	
	public String leerCola(){
		String devolver = "";
		for (int i = 0; i < palabras.length; i++) {
			devolver += palabras[i];
//			devolver +=" ";
		}
		return devolver;
	}
	
	public boolean isTamanioMinimo(){
		
		return (cantidadPalabras == TOTAL);
		
	}

}
