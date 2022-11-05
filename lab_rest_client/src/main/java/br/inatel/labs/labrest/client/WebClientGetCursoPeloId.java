package br.inatel.labs.labrest.client;

import br.inatel.labs.labrest.client.exceptions.StandardError;
import br.inatel.labs.labrest.client.model.Curso;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class WebClientGetCursoPeloId {
    public static void main(String[] args) {
        try {
            Mono<Curso> monoCurso = WebClient.create("http://localhost:8080")
                    .get()
                    .uri("/curso/4")
                    .retrieve()
                    .bodyToMono(Curso.class);

            monoCurso.subscribe();
            Curso curso = monoCurso.block();

            System.out.println("--------------------------------------------------------");
            System.out.println("Curso encontrado: ");
            System.out.println(curso);
            System.out.println("--------------------------------------------------------");
        } catch (WebClientResponseException e) {
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
