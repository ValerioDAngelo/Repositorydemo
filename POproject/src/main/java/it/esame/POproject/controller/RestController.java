package it.esame.POproject.controller;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping; //vedere eventuali eccezioni
import it.esame.POproject.utils.Service;
import it.esame.POproject.data.Tweet;
import it.esame.POproject.statistics.day_stats;
import it.esame.POproject.data.CompleteStats;
import it.esame.POproject.data.Metadata;

@org.springframework.web.bind.annotation.RestController




/** Controller dell'applicazione che permette le chiamate GET, 
 * ognuna delle quali restituisce i parametri richiesti.
 * 
 */



public class RestController {

	
	
/**
 * restituisce sulla rotta "/Data" l'array di tweets.	
 * @return un Arraylist di <code>Tweet</code>
 */
	
@RequestMapping (value = "/Data") 

public ArrayList<Tweet> getData() {
	
	return (ArrayList<Tweet>) Service.getArray();
	
}



/**
 * restituisce sulla rotta "/MetaData" l'array di metadata relativi ai parametri dei tweets.	
 * @return un Arraylist di <code>Metadata</code>
 */

@RequestMapping (value = "/MetaData") 

public ArrayList<Metadata> getMetaData() {

	
	return (ArrayList<Metadata>) Service.getMetadata();
	
}



/**
 * restituisce sulla rotta "/timeStats" le statistiche (min, max, avg, devst)
 * relative alle fasce orarie (AM, PM) dei tweets.	
 * @return un oggetto di tipo <code>CompleteStats</code>
 */


@RequestMapping (value = "/timeStats") 

public CompleteStats gettimeStats() {
	
	
CompleteStats timestats = Service.getTimeStats();	
	
	return (CompleteStats) timestats;
	
}



/**
 * restituisce sulla rotta "/dayStats" le statistiche (min, max, avg, devst)
 * relative ai giorni della settimana su tutto il periodo considerato.	
 * @return un oggetto di tipo <code>day_stats</code>
 */


@RequestMapping (value = "/dayStats") 

public day_stats getdayStats() {
	
day_stats daystats = Service.getDayStats();	
	
	return (day_stats) daystats;
	
}


}








