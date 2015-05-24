package ar.com.indexer.dominio;

import java.sql.Date;
import java.util.Set;

public class Busqueda {

	private int idBusqueda;
	private Date fecha;
	private String tipoBusqueda;

	public String getTipoBusqueda() {
		return tipoBusqueda;
	}

	public void setTipoBusqueda(String tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	public int getIdBusqueda() {
		return idBusqueda;
	}

	public void setIdBusqueda(int idBusqueda) {
		this.idBusqueda = idBusqueda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
