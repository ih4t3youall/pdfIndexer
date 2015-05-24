package ar.com.indexer.dto;

import java.sql.Date;

public class UsuarioDTO {

	private int idUsuario;
	private String nombre;
	private String nombreUsuario;
	private String apellido;
	private String passwd;
	private boolean enabled;
	private final static int tamanioParrafo = 20;
	private String direccion;
	private String telefono;
	private String empresa;
	private String mail;
	private String tipo_usuario;
	private BusquedasRestantesDTO busquedasRestantesDTO;
	private String codigoVerificador;
	private Date fecha_caducidad;
	
	

	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public String getCodigoVerificador() {
		return codigoVerificador;
	}

	public void setCodigoVerificador(String codigoVerificador) {
		this.codigoVerificador = codigoVerificador;
	}

	public BusquedasRestantesDTO getBusquedasRestantesDTO() {
		return busquedasRestantesDTO;
	}

	public void setBusquedasRestantesDTO(
			BusquedasRestantesDTO busquedasRestantesDTO) {
		this.busquedasRestantesDTO = busquedasRestantesDTO;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public static int getTamanioparrafo() {
		return tamanioParrafo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
