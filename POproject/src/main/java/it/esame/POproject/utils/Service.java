package it.esame.POproject.utils;

import java.util.ArrayList;

import it.esame.POproject.data.CompleteStats;
import it.esame.POproject.data.Metadata;
import it.esame.POproject.data.Tweet;
import it.esame.POproject.statistics.time_stats;
import it.esame.POproject.statistics.day_stats;
import java.lang.reflect.*;
import java.util.regex.Pattern;





public class Service {

	/** Classe che prende in argomento l'array di tweet e li prepara al calcolo
	 * delle statistiche tramite gestori appositi, a seconda della richiesta
	 * 
	 * @return un Arraylist di tipo <code><Metadata></code>
	 */	
		
static ArrayList<Tweet> array;
	

/** Gestore della rotta dei metadati
 * 
 * Metodo che ritorna i metadati degli attributi della classe tweet
 * 
 * @return un Arraylist di tipo <code><Metadata></code>
 */
	
	
	public static ArrayList<Metadata> getMetadata ()	{
		
	ArrayList<Metadata> metadata = new ArrayList<Metadata> ();	
	Class<?>  myClass = Tweet.class;
	Field[] fields = myClass.getFields();
	
	for (Field field : fields) {
		
		Metadata metadata1 = new Metadata ();
		metadata1.setField_name(field.getName());
		metadata1.setField_type(field.getType().getSimpleName());
		metadata.add(metadata1);
		}

	return metadata;
	}
	
	
	/** Gestore della rotta delle statistiche per fasce orarie
	 *  Prende l'array di tweet e lo divide in due, a seconda della fascia oraria.
	 *  Poi per entrambi gli array risultanti verranno calcolate le statistiche e inserite
	 *  in un oggetto apposito di tipo CompleteStats
	 * 
	 * @return un Arraylist di tipo <code><CompleteStats></code>
	 */
	
	
public static CompleteStats getTimeStats () { 
		
		
	ArrayList<String> times_AM = new ArrayList<String> ();
	ArrayList<String> times_PM = new ArrayList<String> ();
	String[] time1 = null;
	String[] time2 = null;
	time_stats statistics_AM = new time_stats ();
	time_stats statistics_PM = new time_stats ();
	CompleteStats TotStats = new CompleteStats ();
	
	
	
	for(Tweet t : Service.array) { 

	Pattern pattern1 = Pattern.compile("\\s");
	Pattern pattern2 = Pattern.compile("\\W");
	time1 = pattern1.split(t.created_at);
	time2 = pattern2.split(time1[3]);
	int time3 = Integer.parseInt (time2[0]);
	if (time3 < 13) {
	
	times_AM.add(time1[3]);
	}
	else {
		
	times_PM.add(time1[3]);
	}

	}
	
	
	
	time_stats.times = times_AM;
	statistics_AM.CalcStats();
	
	time_stats.times = times_PM;
	statistics_PM.CalcStats();
	
	TotStats.setMin_AM(statistics_AM.getMin());
	TotStats.setMax_AM(statistics_AM.getMax());
	TotStats.setAvg_AM(statistics_AM.getAvg());
	TotStats.setDevst_AM(statistics_AM.getDevst());
	TotStats.setMin_PM(statistics_PM.getMin());
	TotStats.setMax_PM(statistics_PM.getMax());
	TotStats.setAvg_PM(statistics_PM.getAvg());
	TotStats.setDevst_PM(statistics_PM.getDevst());
	
	
	
	return TotStats;	
		
	}	


/** Gestore della rotta delle statistiche per giorni della settimana
 *  Prende l'array di tweet e lo passa alla classe per il calcolo delle statistiche
 * 
 * @return un Arraylist di tipo <code><day_stats></code>
 */


    public static day_stats getDayStats () {

    	
	day_stats.Statsarray = Service.array;
	day_stats dayStats = new day_stats ();

	
	dayStats.CalcStats ();


	return dayStats;	
		
	}	
	
    
    
    
    
	public static ArrayList<Tweet> getArray() {
		return array;
	}



public static void setArray (ArrayList<Tweet> array) {
		Service.array = array;
	}
}
