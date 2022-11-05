package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.exceptions.StandardError;
import br.inatel.labs.labrest.client.model.Curso;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class WebClientPostCurso {
    public static void main(String[] args) {
        Curso novoCurso= new Curso();
        novoCurso.setDescricao("Dominando spring webflux");
        novoCurso.setCargaHoraria(80);
        try {


            Curso cursoCriado = WebClient.create("http://localhost:8080")
                    .post()
                    .uri("/curso")
                    .bodyValue(novoCurso)
                    .retrieve()
                    .bodyToMono(Curso.class) //indica que nd é esperado no corpo do response
                    .block();

            System.out.println("curso criado: ");
            System.out.println(cursoCriado); //Id
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
