package br.com.estudandoAPIJava.desafio;

import java.util.Scanner;

public class TestandoCep {

	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		ConsultaCep consultaCep = new ConsultaCep();
		
		System.out.println("Digite um número de CEP para consulta:");
		var cep = leitura.nextLine();
		
		try {
			Endereco enderecoNovo = consultaCep.buscaEndereço(cep);
			System.out.println(enderecoNovo);
			
			GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
			geradorDeArquivo.salvarJson(enderecoNovo);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Finalizando a aplicação");
		}
		
	
	}

}
