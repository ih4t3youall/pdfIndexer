package ar.com.indexer.dominio;

import java.sql.Date;

public class Bcp {

	private int idbcp;
	private String codigoBcp;
	private float monto;
	private Date fecha;
	private int user_id;
	private String periodoCubierto;

	
	
	
	public String getCodigoBcp() {
		return codigoBcp;
	}

	public void setCodigoBcp(String codigoBcp) {
		this.codigoBcp = codigoBcp;
	}

	public int getIdbcp() {
		return idbcp;
	}

	public void setIdbcp(int idbcp) {
		this.idbcp = idbcp;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPeriodoCubierto() {
		return periodoCubierto;
	}

	public void setPeriodoCubierto(String periodoCubierto) {
		this.periodoCubierto = periodoCubierto;
	}

}
