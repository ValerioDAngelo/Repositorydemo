package it.esame.POproject.data;


/** Classe relativa ad un post generico sui social. Se il post è
 * un tweet, o un post su instagram, o un post su facebook, possono
 * ereditare da questa classe le classi apposite
 * 
 */

public class Social_post {
	
	
	public String created_at = "";
	public String text = "";
	public Long favorite_count;




	public Long getFavorite_count() {
		return favorite_count;
	}

	public void setFavorite_count(Long favorite_count) {
		this.favorite_count = favorite_count;
	}




	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}




	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}



	
	
	public Social_post() {
		// TODO Auto-generated constructor stub
	}

}
