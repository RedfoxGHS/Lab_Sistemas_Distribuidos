package br.inatel.labs.labrest.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientDeleteCursoPeloId {
    public static void main(String[] args) {

        int id = 2;

        ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080")
                .delete()
                .uri("/curso/" + id)
                .retrieve()
                .toBodilessEntity()
                .block();


        assert responseEntity != null;
        HttpStatus statusCode = responseEntity.getStatusCode();
        System.out.println("status da resposta: "+statusCode);

        if(responseEntity.getStatusCode() == HttpStatus.NO_CONTENT){
            System.out.println("Curso com Id [" + id + "] já não existe na base.");
            return;
        }

        System.out.println("Curso com id [" + id + "] deletado com sucesso!");

    }
}
