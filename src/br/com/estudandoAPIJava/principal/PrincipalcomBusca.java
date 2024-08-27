package br.com.estudandoAPIJava.principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.estudandoAPIJava.modelo.Titulo;
import br.com.estudandoAPIJava.modelo.TituloOmdb;

public class PrincipalcomBusca {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para busca: ");
        var busca = leitura.nextLine();
        
        
        String chave = "abc2ac68";
        String endereco = "https://www.omdbapi.com/?t=" +busca + "&apikey=" +chave;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        

        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        
        
        // podemos fazer desta forma 
        // Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        // System.out.println(meuTitulo.getNome());
        
        
        // porém com o java 17 tem uma nova classe chamada record que ela faz os construtor get e set  ajudando o desenvolvimento
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);
        
        Titulo meuTitulo = new Titulo(meuTituloOmdb);
        
        System.out.println("Meu titulo ja convertido");
        System.out.println(meuTitulo);
    }
}
