package it.esame.POproject.data;


/** Classe che estende la classe Social_post, nel caso in cui 
 * il post sia un tweet. Gli attributi specifici della classe sono
 * infatti il numero dei retweets e se il tweet è stato retwettato 
 * oppure no
 * 
 */


public class Tweet extends Social_post {

	

public Boolean retweeted;
public Long retweet_count;






public Long getRetweet_count() {
	return retweet_count;
}

public void setRetweet_count(Long retweet_count) {
	this.retweet_count = retweet_count;
}



public Boolean getRetweeted() {
	return retweeted;
}

public void setRetweeted(Boolean retweeted) {
	this.retweeted = retweeted;
}

public Tweet() {

super();

	// TODO Auto-generated constructor stub
}	






}
