package it.esame.POproject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection; //errore di mancata connessione?
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import it.esame.POproject.data.Tweet;


/** Classe che effettua il download dei tweets (tramite il metodo DownloadToFile), 
 *  partendo dall'url, e poi va a serializzare il JSONArray in un ArrayList.
 *
 */



public class Downloader {
	
	


public JSONArray DownloadToFile () {

	
/** Metodo che effettua il download dei tweets e li inserisce in un JSONArray
 * 
 * @param una url di tipo <code>String</code>
 * @return un oggetto di tipo <code>JSONArray</code>
 * 	
 */
	
String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/user_timeline.json?count=1000"; 


	try {
		
		URLConnection openConnection = new URL(url).openConnection();
		InputStream in = openConnection.getInputStream();
		
		 String data = "";
		 String line = "";
		 try {
		   InputStreamReader inR = new InputStreamReader( in );
		   BufferedReader buf = new BufferedReader( inR );
		  
		   while ( ( line = buf.readLine() ) != null ) {
			   data+= line;
		   }
		 } finally {
		   in.close();
		 }
		
		 
		 JSONArray jsonarr = (JSONArray) JSONValue.parseWithException(data);
		

		return jsonarr;
	
		
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return null;
	
  }






public void Serializzazione (JSONArray jsonarray, int counter) {

	
/** Metodo che effettua il parsing dei soli tweets con ingaggio in un Arraylist apposito.
* 
* @param un oggetto di tipo <code>JSONArray</code> e un oggetto di tipo <code>String</code>
* @return un Arraylist di oggetti di tipo <code>Tweet</code>
* 	
*/	
	
	ArrayList <Tweet> tweets = new ArrayList <Tweet>(1000); 


	for(Object var : jsonarray) {
	
	
		if ( var instanceof JSONObject) {
		
		
		JSONObject obj4 = (JSONObject) var;
	
		Tweet y = new Tweet();

		SingolaSerializzazione (obj4, y);
	
		if (y.retweet_count != 0 || y.favorite_count != 0) {
	
			tweets.add(y);	
		
			counter++;	
			
				}	
	
		
			} 

	}	
	
	
Service.setArray (tweets);
	
	
}






		

public void SingolaSerializzazione (JSONObject var, Tweet t) {

	
/** Metodo che effettua il parsing del singolo tweet con ingaggio
* 
* @param un oggetto di tipo <code>JSONObject</code> e un oggetto di tipo <code>Tweet</code>
* 	
*/
	
	t.created_at = (String) (var.get("created_at"));
	t.text = (String) (var.get("text"));
	t.retweeted = (Boolean) (var.get("retweeted"));
	t.retweet_count = (Long) (var.get("retweet_count"));
	t.favorite_count = (Long) (var.get("favorite_count"));

}



}