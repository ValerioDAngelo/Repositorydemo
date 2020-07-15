package it.esame.POproject.data;


/** La classe CompleteStats serve come appoggio per contenere
 *  le statistiche relative alle fasce orarie dei tweet, che poi saranno 
 *  ritornate sulla rotta /timeStats
 * 
 */


public class CompleteStats {
	
String min_AM;
String max_AM;
String avg_AM;
String devst_AM;
String min_PM;
String max_PM;
String avg_PM;
String devst_PM;
	
	
	
	public String getMin_AM() {
	return min_AM;
}



public void setMin_AM(String min_AM) {
	this.min_AM = min_AM;
}



public String getMax_AM() {
	return max_AM;
}



public void setMax_AM(String max_AM) {
	this.max_AM = max_AM;
}



public String getAvg_AM() {
	return avg_AM;
}



public void setAvg_AM(String avg_AM) {
	this.avg_AM = avg_AM;
}



public String getDevst_AM() {
	return devst_AM;
}



public void setDevst_AM(String devst_AM) {
	this.devst_AM = devst_AM;
}



public String getMin_PM() {
	return min_PM;
}



public void setMin_PM(String min_PM) {
	this.min_PM = min_PM;
}



public String getMax_PM() {
	return max_PM;
}



public void setMax_PM(String max_PM) {
	this.max_PM = max_PM;
}



public String getAvg_PM() {
	return avg_PM;
}



public void setAvg_PM(String avg_PM) {
	this.avg_PM = avg_PM;
}



public String getDevst_PM() {
	return devst_PM;
}



public void setDevst_PM(String devst_PM) {
	this.devst_PM = devst_PM;
}



	public CompleteStats() {
		// TODO Auto-generated constructor stub
	}

}
