package ar.com.indexer.dto;

public class BusquedasRestantesDTO {

	private int diarias = 0;
	private int semanales = 0;
	private int mensuales = 0;

	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}

	public int getSemanales() {
		return semanales;
	}

	public void setSemanales(int semanales) {
		this.semanales = semanales;
	}

	public int getMensuales() {
		return mensuales;
	}

	public void setMensuales(int mensuales) {
		this.mensuales = mensuales;
	}

	public void actualizar(String tipoBusqueda, int resta) {

		if (tipoBusqueda.equals("Diaria")) {

			this.diarias = this.diarias - resta;

		}
		if (tipoBusqueda.equals("Semanal")) {

			this.semanales = this.semanales - resta;

		}
		if (tipoBusqueda.equals("Mensual")) {

			this.mensuales = this.mensuales - resta;

		}

	}

}
