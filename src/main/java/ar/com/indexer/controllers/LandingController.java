package ar.com.indexer.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LandingController {
	
	
	@RequestMapping("pruebe.htm")
	public @ResponseBody String pruebe(){
		String texto = "";
			try {
				texto=leerArchivo("textoPruebe");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return texto;
		
		
	}
	
	
	 public static String leerArchivo(String archivo) throws FileNotFoundException, IOException {
	        String cadena;
	        FileReader f = new FileReader("resources/textos/"+archivo);
	        BufferedReader buffer = new BufferedReader(f);
	        String texto ="";
	        while((cadena = buffer.readLine())!=null) {
	            texto+=cadena;
	        }
	        buffer.close();
	        return texto;
	    }

}
