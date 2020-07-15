package it.esame.POproject.statistics;

import java.util.ArrayList;

import it.esame.POproject.data.Stats;
import it.esame.POproject.data.Tweet;
import java.util.regex.Pattern;


public class day_stats implements Stats {

public String min;
public String max;
public double avg;
public double devst;
public static ArrayList<Tweet> Statsarray;


/** Metodo per il calcolo delle statistiche.
 * 
 * Richiama tutti i metodi per il calcolo delle singole statistiche e le
 * inserisce negli attributi della classe
 * 
 */

@Override

	public void CalcStats () {	
	
		this.min = CalcMin();
		this.max = CalcMax();
		this.avg = CalcAvg();
		this.devst = CalcDevst();
		
	}

/** Metodo che calcola il giorno della settimana con meno tweet
 * 
 * @return un oggetto di tipo <code><String></code>
 */

@Override
		
	public String CalcMin () {
		

	int [] counter_week = new int[7];
	
	for (int i = 1; i<7; i++) counter_week[i] = 0;

	String [] day = null;

	for(Tweet t : Statsarray) {

	Pattern pattern = Pattern.compile("\\s");
	day = pattern.split(t.created_at);

	if (day[0].equals("Mon")) counter_week[0]++ ;
	if (day[0].equals("Tue")) counter_week[1]++ ;
	if (day[0].equals("Wed")) counter_week[2]++ ;
	if (day[0].equals("Thu")) counter_week[3]++ ;
	if (day[0].equals("Fri")) counter_week[4]++ ;
	if (day[0].equals("Sat")) counter_week[5]++ ;
	if (day[0].equals("Sun")) counter_week[6]++ ;		
	}

	int min = counter_week[0];

	for (int i = 1; i<7; i++) if (counter_week[i]<min)  min = counter_week[i];
		

	if (min == counter_week[0]) return "Mon";
	else if (min == counter_week[1]) return "Tue";
	else if (min == counter_week[2]) return "Wed";
	else if (min == counter_week[3]) return "Thu";
	else if (min == counter_week[4]) return "Fri";
	else if (min == counter_week[5]) return "Sat";
	else if (min == counter_week[6]) return "Sun";


	return null;	

	}


/** Metodo che calcola il giorno della settimana con più tweet
 * 
 * @return un oggetto di tipo <code><String></code>
 */

@Override


	public String CalcMax ()	{
		
		int [] counter_week = new int[7];
		
		for (int i = 1; i<7; i++) counter_week[i] = 0;

		String [] day = null;

		for(Tweet t : Statsarray) {

		Pattern pattern = Pattern.compile("\\s");
		day = pattern.split(t.created_at);

		if (day[0].equals("Mon")) counter_week[0]++ ;
		if (day[0].equals("Tue")) counter_week[1]++ ;
		if (day[0].equals("Wed")) counter_week[2]++ ;
		if (day[0].equals("Thu")) counter_week[3]++ ;
		if (day[0].equals("Fri")) counter_week[4]++ ;
		if (day[0].equals("Sat")) counter_week[5]++ ;
		if (day[0].equals("Sun")) counter_week[6]++ ;		
		}

		int max = counter_week[0];

		for (int i = 1; i<7; i++) if (counter_week[i]>max)  max = counter_week[i];
			

		if (max == counter_week[0]) return "Mon";
		else if (max == counter_week[1]) return "Tue";
		else if (max == counter_week[2]) return "Wed";
		else if (max == counter_week[3]) return "Thu";
		else if (max == counter_week[4]) return "Fri";
		else if (max == counter_week[5]) return "Sat";
		else if (max == counter_week[6]) return "Sun";
	
		
	return null;	
	}


/** Metodo che calcola la media dei tweets fatti in un giorno, prendendo
 * come popolazione i tweets dell'array selezionato
 * 
 * @return un oggetto di tipo <code><double></code>
 */

	public double CalcAvg () { 
		
	double avg = 0;
	double sum_tweets = 0;
	double sum_days = 0;
	String[] day1 = null;
	int number_month;
	int appoggio = 0;
	
	for(Tweet element : Statsarray)	{
		
		sum_tweets++;
		Pattern pattern = Pattern.compile("\\s");
		day1 = pattern.split(element.created_at);
		number_month = Integer.parseInt(day1[2]);
		if (number_month != appoggio) {
			
			sum_days++;
			appoggio = number_month;
		}
	}
	
	avg = sum_tweets/sum_days;
	
	return avg;
	}

	
	/** Metodo che calcola la deviazione standard relativa alla media dei tweets fatti
	 * in un giorno, prendendo come popolazione i tweets dell'array selezionato
	 * 
	 * 
	 * @return un oggetto di tipo <code><double></code>
	 */
	
	public double CalcDevst () { //devst di tweets al giorno
		
	double avg = CalcAvg();
	double devst = 0;
	String[] day1 = null;
	String[] day2 = null;
	double appoggio2 = 0;
	double contatore_tweets = 0;
	
	Pattern pattern = Pattern.compile("\\s");
	day1 = pattern.split(Statsarray.get(0).created_at);
	int number_month = Integer.parseInt(day1[2]);
	
	
	for(Tweet element : Statsarray)	{
		
		Pattern pattern2 = Pattern.compile("\\s");
		day2 = pattern2.split(element.created_at);
		int confronto = Integer.parseInt(day2[2]);
		
		if (number_month!=confronto) {
			
			appoggio2 = appoggio2 + Math.pow(contatore_tweets-avg, 2);
			contatore_tweets = 1;
			number_month = confronto;
		} else contatore_tweets++;
		
	}

	devst = Math.sqrt(appoggio2/Statsarray.size());
	
	return devst;
	}


	
}
