package com.dim.Commons;

import com.dim.Models.Dtos.Response;
import jakarta.ws.rs.core.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ControllerAdvice
public class FileUploadAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<String> handleMaxSizeExcepttion(MaxUploadSizeExceededException ex){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Verifica el tamaño del pdf.");
    }

//    @ExceptionHandler(FileNotFoundException.class)
//    public ResponseEntity<Response> handleFileNotFoundException(FileNotFoundException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("El archivo no se encuentra en el servidor."));
//    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<String> handleFileNotFoundException(FileNotFoundException ex) throws IOException {
        // Leer el contenido de error.html
        String htmlContent = new String(Files.readAllBytes(Paths.get("src/main/resources/templates/error-404.html")));

        // Reemplazar el marcador de posición en el HTML con el mensaje de error personalizado
        htmlContent = htmlContent.replace("{error_message}", "No se encontro el archivo.");

        // Devolver una respuesta con el contenido HTML
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.valueOf(MediaType.TEXT_HTML));
        return new ResponseEntity<>(htmlContent, headers, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("Se produjo un error."));
    }

}
