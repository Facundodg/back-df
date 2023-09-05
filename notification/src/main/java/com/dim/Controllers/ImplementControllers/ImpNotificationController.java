package com.dim.Controllers.ImplementControllers;

import com.dim.Controllers.InterfaceControllers.IntNotificationController;
import com.dim.Models.Dtos.NotificationGet;
import com.dim.Models.Dtos.NotificationPost;
import com.dim.Models.Entitys.Notification;
import com.dim.Services.InterfaceServices.IntNotificationServices;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ImpNotificationController implements IntNotificationController {

    private final IntNotificationServices intNotificationServices;
    private final ModelMapper modelMapper;

    @Operation(summary = "Elimina la notificacion por Id", description = "Retorna un booleano")
    @DeleteMapping(value = "/delete-by/{id}")
    public ResponseEntity DeleteById(@PathVariable("id") @Positive long id){
        log.info(("[NotificationController - delete-by-id: id={}"), id);
        return ResponseEntity.ok(intNotificationServices.deletNoficationById(id));
    }

//    @PostMapping(value = "/add-notification")
//    public ResponseEntity AddNotification(@RequestBody Notification notification){
//        log.info(("[NotificationController - add-notification: notification={}"), notification);
//        return ResponseEntity.ok(intNotificationServices.addNotification(notification));
//    }

    @Operation(summary = "Agrega una notificacion", description = "Retorna una notificacion")
    @PostMapping(value = "/add-notification")
    public ResponseEntity AddNotification(@Valid @RequestBody NotificationPost notificationPost){
        log.info(("[NotificationController - add-notification: notificationPost={}"), notificationPost);

        Notification notification = new Notification();

        notification.setCuit(notificationPost.getCuit());
        notification.setUserEnv(notificationPost.getUserEnv());
        notification.setTributo(notificationPost.getTributo());
        notification.setNotification(notificationPost.getNotification());
        notification.setPdf(notificationPost.getPdf());
        notification.setDateRead(notificationPost.getDateRead());
        notification.setDateNotification(notificationPost.getDateNotification());
        notification.setDateDelivered(notificationPost.getDateDelivered());
        notification.setStatusDateReported(false);

        return ResponseEntity.ok(intNotificationServices.addNotification(notification));
    }


    @Override
    @GetMapping(value = "/to-list")
    public ResponseEntity<List<NotificationGet>> GetAllNotification() {
        log.info(("[NotificationController - to-list]"));
        return ResponseEntity.ok(intNotificationServices.getNotification().stream().map(x -> modelMapper.map( x, NotificationGet.class)).toList());
    }

    @Operation(summary = "Busca la notificacion por Cuit", description = "Retorna una notificacion por cuit")
    @GetMapping(value = "/to-list-by/{cuit}")
    public ResponseEntity<List<NotificationGet>> getAllnotificationbyCuit(@PathVariable("cuit") @Positive @Size(min = 10, max = 10) int cuit) {
        log.info(("[NotificationController - to-list-by-cuit: cuit={}]"), cuit);
        return ResponseEntity.ok(intNotificationServices.getNotificationByCuit(cuit).stream().map(x -> modelMapper.map( x, NotificationGet.class)).toList());
    }
}


/*

    @Override
    public ResponseEntity<Collection<ChatPropiedades>> buscarTodos() {
        log.info("[ChatControlador - BuscarTodos]");

        final List<ChatPropiedades> chatPropiedadesLista = chatServicio.buscarTodos()
                .stream()
                .map(u -> modelMapper.map(u, ChatPropiedades.class))
                .toList();
        return new ResponseEntity<>(chatPropiedadesLista, HttpStatus.OK);
    }

 */