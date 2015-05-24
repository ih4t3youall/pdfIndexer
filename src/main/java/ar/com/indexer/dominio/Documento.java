package ar.com.indexer.dominio;

import java.sql.Date;

public class Documento {

	private int idDocumento;
	private Date fecha_inclusion;
	private String ubicacion;

	public int getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(int idDocumento) {
		this.idDocumento = idDocumento;
	}

	public Date getFecha_inclusion() {
		return fecha_inclusion;
	}

	public void setFecha_inclusion(Date fecha_inclusion) {
		this.fecha_inclusion = fecha_inclusion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

}
