package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.exceptions.StandardError;
import br.inatel.labs.labrest.client.model.Curso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientPutCurso {
    public static void main(String[] args) {
        Curso cursoExistente = new Curso();
        cursoExistente.setId(4L);
        cursoExistente.setDescricao("REST com spring ");
        cursoExistente.setCargaHoraria(120);

        try {
            ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080")
                    .put()
                    .uri("/curso")
                    .bodyValue(cursoExistente)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            System.out.println("status code: ");
            assert responseEntity != null;
            System.out.println(responseEntity.getStatusCode());
        }catch (WebClientResponseException e){
            StandardError error = new StandardError(e.getResponseBodyAsString());

            System.out.println("--------------------------------------------------------");
            System.out.println("timestamp: " + error.getTimestamp().toString());
            System.out.println("status: " + error.getStatus());
            System.out.println("error: " + error.getError());
            System.out.println("message: " + error.getMessage());
            System.out.println("path: " + error.getPath());
            System.out.println("--------------------------------------------------------");
        }

    }

}
