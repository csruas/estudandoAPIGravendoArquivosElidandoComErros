package br.com.estudandoAPIJava.execao;

public class ErrorDeConversaoDeAnoException extends Exception {
	
	private String mensagem;

	public ErrorDeConversaoDeAnoException( String mensagem) {
		this.mensagem = mensagem;
	}
	
	@Override
	public String getMessage() {
		
		return this.mensagem;
	}

	
	
	

}
