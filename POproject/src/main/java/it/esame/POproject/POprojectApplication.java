package it.esame.POproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.json.simple.JSONArray;
import it.esame.POproject.utils.Downloader;

/**
 * 
 * @author D'Angelo Valerio
 *
 * Classe main dell'applicazione, che dopo l'avvio richiama i metodi
 * DownloadToFile e Serializzazione della classe Downloader, i quali
 * effettuano il download e parsing dei tweets in un apposito array.
 */


@SpringBootApplication
public class POprojectApplication {

	public static void main(String[] args) {
		
		
		SpringApplication.run(POprojectApplication.class, args);
		
		
		int counter = 0;
		Downloader d = new Downloader ();
		JSONArray jsonarr = new JSONArray();
		
		
		jsonarr = d.DownloadToFile();
		d.Serializzazione(jsonarr, counter);
		
	}

}
