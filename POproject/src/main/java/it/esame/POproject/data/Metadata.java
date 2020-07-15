package it.esame.POproject.data;


/** Classe che esprime il generico metadato. L'attributo "field_name"
 * ne descrive il nome, mentre l'attributo "field_type" ne descrive
 * il tipo
 *
 */


public class Metadata {

public String field_name = "";
public String field_type = "";



public String getField_name() {
	return field_name;
}
public void setField_name(String field_name) {
	this.field_name = field_name;
}
public String getField_type() {
	return field_type;
}
public void setField_type(String field_type) {
	this.field_type = field_type;
}

	
}
