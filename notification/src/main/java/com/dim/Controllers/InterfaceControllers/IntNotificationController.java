package com.dim.Controllers.InterfaceControllers;

import com.dim.Models.Dtos.NotificationGet;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("/notification")
public interface IntNotificationController {

    @Operation(summary = "Busca todas las notificaciones", description = "Retorna todas las notificaciones")
    @GetMapping("/todo")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<NotificationGet>> GetAllNotification();

}
