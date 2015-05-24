package ar.com.indexer.paginador;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import ar.com.indexer.bo.BusquedaBO;
import ar.com.indexer.configuracion.Configuracion;
import ar.com.indexer.dominio.ArchivoBusqueda;
import ar.com.indexer.dominio.Termino;
import ar.com.indexer.dto.BusquedaDTO;
import ar.com.indexer.servicios.BusquedaActual;
import ar.com.indexer.threads.BuscarThreads;

public class Buscador {

	private File file;
	private List<Termino> words;
	private LinkedList<LinkedList<String>> paginas;
	private ThreadPoolTaskExecutor taskExecutor;

	private Configuracion conf;
	
	private BusquedaActual busquedaActual;

	public void buscarThreads(BusquedaDTO busquedaDTO, BusquedaBO busquedaBO) {
		taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		taskExecutor.initialize();

		String[] carpetas = busquedaDTO.getCarpetas();
		
		List<File> listFiles = new ArrayList<File>();
		
		for (int i = 0; i < carpetas.length; i++) {
			File basefile = new File(conf.getPATH_BASE()+""+carpetas[i]);
			
			 File[] listFiles2 = basefile.listFiles();
			 
			 for (int j = 0; j < listFiles2.length; j++) {
				
				 listFiles.add(listFiles2[j]);
				 
			}
			
			
		}
		
		
		
		


		int contador = 0;
		if (listFiles.size() > 0) {

			for (; contador < listFiles.size(); contador++) {
				if (listFiles.size() == contador) {
				} else {
					taskExecutor.execute(new BuscarThreads(listFiles.get(contador),
							busquedaDTO, busquedaBO));
				}
			}

		}

		// check active thread, if zero then shut down the thread pool
		for (;;) {
			int count = taskExecutor.getActiveCount();
			System.out.println("Active Threads : " + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (count == 0) {
				taskExecutor.shutdown();
				break;
			}
		}

	}

	private void imprimirPaginasPorSeparado() {
		int contador = 0;
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(
					"/Users/martinLequerica/Desktop/archivosdeprueba/prueba.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Nuevo PrintWriter
		PrintWriter pw = new PrintWriter(fichero);
		// Escribimos en el Archivo lo deseado
		for (LinkedList<String> lista : paginas) {
			System.out.println("pagina: " + contador);

			// Nuevo FileWriter

			pw.println("pagina: " + contador);
			for (String string : lista) {
				pw.println(string);

			}

			contador++;

		}

		try {
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BusquedaActual getBusquedaActual() {
		return busquedaActual;
	}

	public void setBusquedaActual(BusquedaActual busquedaActual) {
		this.busquedaActual = busquedaActual;
	}

	public ThreadPoolTaskExecutor getTaskExecutor() {
		return taskExecutor;
	}

	public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public Configuracion getConf() {
		return conf;
	}

	public void setConf(Configuracion conf) {
		this.conf = conf;
	}
	
	

}
