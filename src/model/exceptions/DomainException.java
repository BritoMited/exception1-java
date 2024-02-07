package model.exceptions;

public class DomainException extends RuntimeException { // por ser runtime ele nao 
	// necessita de ser tratado entao nao é necessario colocar throws
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}

}
