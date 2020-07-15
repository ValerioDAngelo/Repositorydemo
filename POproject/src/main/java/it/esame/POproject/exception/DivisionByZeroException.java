package it.esame.POproject.exception;

public class DivisionByZeroException extends Exception {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

DivisionByZeroException() { super(); }

DivisionByZeroException(String msg) { super(msg); }
	
	
//la posso lanciare, perchè un post potrebbe avere 5 retweet e 0 like, o viceversa	

}
