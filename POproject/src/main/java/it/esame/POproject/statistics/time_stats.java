package it.esame.POproject.statistics;

import java.util.ArrayList;
import java.util.regex.Pattern;
import it.esame.POproject.data.Stats;



public class time_stats implements Stats {

	
String min;
String max;
String avg;
String devst;

public static ArrayList<String> times;


/** Metodo per il calcolo delle statistiche.
 * 
 * Richiama tutti i metodi per il calcolo delle singole statistiche e le
 * inserisce negli attributi della classe
 * 
 */

@Override

public void CalcStats () {


this.min = CalcMin ();
this.max = CalcMax ();
this.avg = CalcAvg ();
this.devst = CalcDevst ();
	
}	


@Override

public String CalcMin () {


String min = time_stats.times.get(0);	

for (int i=1;i<time_stats.times.size();i++) 
	
	if (Conversione(time_stats.times.get(i)) < Conversione(min)) min = time_stats.times.get(i); 


return min;	
}


@Override

public String CalcMax () {
	
	String max = time_stats.times.get(0);	

	for (int i=1;i<time_stats.times.size();i++) 
		
		if (Conversione(time_stats.times.get(i)) > Conversione(max)) max = time_stats.times.get(i); 
	
return max;		
}

public String CalcAvg () {

double avg = 0;
double sum = 0;

for(String element : time_stats.times)	sum = sum + Conversione(element);

avg = (double) (sum/time_stats.times.size()); //eccezione nel caso ci sia una divisione per zero

return AntiConversione(avg);	
}



public String CalcDevst () {
	 
	double avg = 0;
	double sum = 0;

	for(String element : time_stats.times)	sum = sum + Conversione(element);

	avg = (double) (sum/time_stats.times.size());		

double appoggio = 0;

for(String element : time_stats.times)	appoggio = appoggio + Math.pow(((double)Conversione(element))-avg, 2);

double devst = Math.sqrt(appoggio/time_stats.times.size()); //eccezione nel caso ci sia una divisione per zero

return AntiConversione(devst);	
}




public int Conversione (String time) {

String [] time2;
int time3 = 0;
Pattern pattern = Pattern.compile("\\W");	
time2 = pattern.split(time);
time3 = (Integer.parseInt(time2[0])*3600) + (Integer.parseInt(time2[1])*60) + Integer.parseInt(time2[2]);
	
return time3;
}





public String AntiConversione (double time) {
	
int time2 = ((int) time)/3600;
int time3 = (((int) time)%3600);
int time4 = time3 % 60;
	

return "" + time2 + ":" + time3/60 + ":" + time4 + "";
	
}
	




public String getMin() {
	return min;
}


public void setMin(String min) {
	this.min = min;
}


public String getMax() {
	return max;
}


public void setMax(String max) {
	this.max = max;
}


public String getAvg() {
	return avg;
}


public void setAvg(String avg) {
	this.avg = avg;
}


public String getDevst() {
	return devst;
}


public void setDevst(String devst) {
	this.devst = devst;
}


public static ArrayList<String> getTimes() {
	return times;
}


public static void setTimes(ArrayList<String> times) {
	time_stats.times = times;
}
	
	
	
	
	
	public time_stats() {
		// TODO Auto-generated constructor stub
	}



}
