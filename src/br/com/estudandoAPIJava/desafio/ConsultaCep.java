package br.com.estudandoAPIJava.desafio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ConsultaCep {
	public Endereco buscaEndereço(String cep) throws JsonSyntaxException {
		URI	endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");
		
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(endereco)
	            .build();
	    
	    try {
	    	  HttpResponse<String> response = HttpClient
					.newHttpClient()
					.send(request, HttpResponse.BodyHandlers.ofString());
			return new Gson().fromJson(response.body(), Endereco.class);
		} catch (Exception e) {
			throw new RuntimeException("Não e possivel encontrar o endereço apartir deste Cep:");
		} 
	    
	}

}
