package ar.com.indexer.utilitis;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ar.com.indexer.dominio.ArchivoBusqueda;
import ar.com.indexer.dominio.Resultado;
import ar.com.indexer.dominio.Termino;
import ar.com.indexer.dto.BusquedaDTO;
import ar.com.indexer.dto.UsuarioDTO;

public class HtmlUtility {

	public static String cajaArchivos(ArrayList<String> listStringFiles) {

		String respuesta = "";
		respuesta += "<select multiple=\"multiple\"  name=\"archivos\"  data-hint-position=\"right\" > ";

		for (String string : listStringFiles) {

			respuesta += "<option>" + string + "</option>";
		}

		respuesta += "</select>";

		return respuesta;
	}

//	public static String sinAcentos(String input) {
//		// Cadena de caracteres original a sustituir.
//		String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
//		// Cadena de caracteres ASCII que reemplazarán los originales.
//		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
//		String output = input;
//		for (int i = 0; i < original.length(); i++) {
//			// Reemplazamos los caracteres especiales.
//			output = output.replace(original.charAt(i), ascii.charAt(i));
//		}// for i
//		return output;
//	}// remove1

	
	public static String sinAcentos(String string) {
		String original = "��������������u��ˀ���������􆄍���':";
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcCu   ";

        if (string != null) {
			//Recorro la cadena y remplazo los caracteres originales por aquellos sin acentos
			for (int i = 0; i < original.length(); i++ ) {
	            string = string.replace(original.charAt(i), ascii.charAt(i));
	        }

		//Establezco todos los caracteres a min�scula.
	        string = string.toLowerCase();

        }
        return string;
	}
	
	
	public static String boxesUsers(List<UsuarioDTO> usuariosDTO) {

		String boxes = "";

		for (UsuarioDTO usuarioDTO : usuariosDTO) {
			String cheked = "";
			if (usuarioDTO.isEnabled()) {

				cheked = "checked";
			}

			boxes += "<br/>";
			boxes += "<div class=\"example\" id=\""
					+ usuarioDTO.getNombreUsuario()
					+ "\">"
					+ "<address>"
					+ "<strong>"
					+ usuarioDTO.getNombreUsuario()
					+ "</strong><br>"
					+ ""
					+ usuarioDTO.getNombre()
					+ "<br>"
					+ ""
					+"temporal: "+ usuarioDTO.isTemporal()
					+ "<br>"
					+ ""
					+ usuarioDTO.getApellido()
					+ "<br>"
					+ ""
					+ usuarioDTO.getRazonSocial()
					+ "<br>"
					+ "<abbr title=\"Phone\">Tel:</abbr> "
					+ usuarioDTO.getTelefono()
					+ "<br>"
					+ ""
					+ usuarioDTO.getRuc()
					+ "<br>"
					+ ""
					+ usuarioDTO.getMail()
					+ "<br>"
					+ "empresa<br>"
					+ "</address>"

					+ "<address>"
					+ "<div data-role=\"input-control\" class=\"input-control switch margin10\">"
					+ "<label>"
					+ "  Habilitado<br/>"
					+ "<input value=\""
					+ usuarioDTO.getNombreUsuario()
					+ "\"  type=\"checkbox\" "
					+ cheked
					+ ">"
					+ "<span class=\"check\"></span>"
					+ " </label>"
					+ "</div>"
					+ "</address>"
					+ "<address><h3>Eliminar<i onclick=\"eliminarUsuario('"
					+ usuarioDTO.getNombreUsuario()
					+ "')\" style=\"background: red; color: white; padding: 10px; border-radius: 50%\" class=\"icon-cancel on-left on-right\"></i>usuario</h3></address>"
					+ "</div>";
		}

		return boxes;

	}

	public String crearTab(List<BusquedaDTO> listaBusuqedaDTO) {

		List<String> listaDeFechas = new ArrayList<String>();

		for (BusquedaDTO busquedaDTO : listaBusuqedaDTO) {
			boolean flag = true;
			for (String date : listaDeFechas) {

				if (busquedaDTO.getFecha().toString().equals(date)) {
					flag = false;
				}

			}
			if (flag) {
				listaDeFechas.add(busquedaDTO.getFecha().toString());
			}

		}

		String unString = "";

		String header = "<div class=\"example\">"
				+ "<div class=\"tab-control\" data-role=\"tab-control\">"
				+ "<ul class=\"tabs\">";

		for (int i = 0; i < listaDeFechas.size(); i++) {
			if (i == 0) {
				header += "<li class=\"active\"><a href=\"#"
						+ listaDeFechas.get(i) + "\">" + listaDeFechas.get(i)
						+ "</a></li>";
			} else {
				header += "<li><a href=\"#" + listaDeFechas.get(i) + "\">"
						+ listaDeFechas.get(i) + "</a></li>";
			}
		}
		header += "</ul>";
		header += crearAcordiones(listaBusuqedaDTO);
		return header;
	}

	private String crearAcordiones(List<BusquedaDTO> busquedaDTOs) {
		String acordion = "";

		List<Aux> listaAux = new ArrayList<Aux>();
		// TODO ta mal
		for (BusquedaDTO busquedaDTO : busquedaDTOs) {

			boolean flag = true;

			for (Aux aux : listaAux) {

				if (aux.getFecha().equals(busquedaDTO.getFecha())) {

					aux.add(busquedaDTO);
					flag = false;
				}

			}

			if (flag) {

				Aux aux = new Aux(busquedaDTO.getFecha());
				aux.add(busquedaDTO);
				listaAux.add(aux);

			}

		}

		acordion += "<div class=\"frames\">";
		for (Aux aux : listaAux) {

			acordion += "<div class=\"frame clearfix\" id=\""
					+ aux.getFecha()
					+ "\">"
					+ "<div class=\"accordion\" data-role=\"accordion\" data-closeany=\"true\">";
			for (BusquedaDTO busquedaDTO : aux.getBusquedaDTO()) {

				int idBusqueda = busquedaDTO.getIdBusqueda();
				for (ArchivoBusqueda archivos : busquedaDTO.getArchivos()) {

					List<Aux2> listaAuxiliar = new ArrayList<HtmlUtility.Aux2>();

					for (Resultado resultado : archivos.getResultados()) {
						int bandera = -1;
						if (listaAuxiliar.size() == 0) {
							Aux2 nose = new Aux2();
							nose.setNombre(resultado.getPalabra());

							String coleccionTexto = "";

							for (String palabra : resultado.getResultado()) {

								coleccionTexto += sinAcentos(palabra);
								coleccionTexto += "</br>";

							}
							String boton = "<input onclick=\"generarPDF(this)\" type=\"button\" value=\"Ver en Pdf\" palabra=\""
									+ resultado.getPalabra()
									+ "\" index=\""
									+ resultado.getPagina()
									+ "\"   termino=\""
									+ idBusqueda
									+ "\"  documento=\""
									+ resultado.getDocumento().toString()
									+ "\" /></br>";
							coleccionTexto += boton;
							nose.setTexto(coleccionTexto);
							listaAuxiliar.add(nose);
							bandera = -2;
						} else {

							for (int i = 0; i < listaAuxiliar.size(); i++) {

								if (listaAuxiliar.get(i).getNombre()
										.equals(resultado.getPalabra())) {
									bandera = i;

								}

							}

						}

						if (bandera == -1) {
							Aux2 nose = new Aux2();
							nose.setNombre(resultado.getPalabra());

							String coleccionTexto = "";

							for (String palabra : resultado.getResultado()) {

								coleccionTexto += sinAcentos(palabra);
								coleccionTexto += "</br>";

							}
							String boton = "<input onclick=\"generarPDF(this)\" type=\"button\" value=\"Ver en pdf \"  palabra=\""
									+ resultado.getPalabra()
									+ "\" index=\""
									+ resultado.getPagina()
									+ "\" termino=\""
									+ idBusqueda
									+ "\" documento=\""
									+ resultado.getDocumento().toString()
									+ "\" /></br>";
							coleccionTexto += boton;
							nose.setTexto(coleccionTexto);
							listaAuxiliar.add(nose);

						} else {

							String coleccionTexto = "";
							for (String palabra : resultado.getResultado()) {

								coleccionTexto += sinAcentos(palabra);
								coleccionTexto += "</br>";

							}
							String boton = "<input onclick=\"generarPDF(this)\" type=\"button\" value=\"Ver en pdf \"  palabra=\""
									+ resultado.getPalabra()
									+ "\"  termino=\""
									+ idBusqueda
									+ "\" index=\""
									+ resultado.getPagina()
									+ "\" documento=\""
									+ resultado.getDocumento().toString()
									+ "\" /></br>";
							coleccionTexto += boton;
							if (bandera != -2) {
								listaAuxiliar.get(bandera).setTexto(
										listaAuxiliar.get(bandera).getTexto()
												+ coleccionTexto);
							}
						}

					}

					String palabras = "";
					for (Aux2 aux2 : listaAuxiliar) {

						palabras += aux2.getNombre();
						palabras += " ";
					}

					acordion += "<div class=\"accordion-frame\">"
							+ "<a class=\"heading\" href=\"#\">"
							+ archivos.getNombre() + " Se encontraron "
							+ archivos.getResultados().size()
							+ " coincidencias de las palabras " + palabras
							+ "</a>" + "<div class=\"content clearfix\">";
					List<Termino> terminos = busquedaDTO.getTerminos();
					for (Aux2 aux2 : listaAuxiliar) {
						acordion += "<div class=\"accordion span5 place-left margin10\""
								+ "data-role=\"accordion\""
								+ "data-closeany=\"false\">"
								+ "<div class=\"accordion-frame\">";

						String terminosBuscados = "";
						terminosBuscados += aux2.getNombre() + " , ";

						acordion += "<a  class=\"heading terminos\" href=\"#\">"
								+ terminosBuscados + "</a>" +

								"<div class=\"content contenido\">";

						acordion += "<p>" + aux2.getTexto() + "</p>";

						if (archivos.getResultados().isEmpty()) {
							acordion += "<p>No se encontraron coincidencias dentro del archivo.</p>";
						}

						acordion += "</div>" + "</div>" + "</div>";
					}
					acordion += "</div>" + "</div>";
				}
			}

			acordion += "</div>" + "</div>";
		}
		acordion += "</div>" + "</div>" + "</div>" + "</div>" + "</div>"
				+ "</div>";

		return acordion;

	}

	public class Aux {

		private Date fecha;
		private List<BusquedaDTO> busquedaDTO;

		public Aux(Date fecha) {
			busquedaDTO = new ArrayList<BusquedaDTO>();
			this.fecha = fecha;
		}

		public void add(BusquedaDTO busquedaDTO) {

			this.busquedaDTO.add(busquedaDTO);

		}

		public Date getFecha() {
			return fecha;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public List<BusquedaDTO> getBusquedaDTO() {
			return busquedaDTO;
		}

		public void setBusquedaDTO(List<BusquedaDTO> busquedaDTO) {
			this.busquedaDTO = busquedaDTO;
		}

	}

	public class Aux2 {

		private String nombre;
		private String texto;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTexto() {
			return texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

	}

}
