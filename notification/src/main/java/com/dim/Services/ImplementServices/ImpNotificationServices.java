package com.dim.Services.ImplementServices;

import com.dim.Models.Dtos.NotificationGet;
import com.dim.Models.Dtos.NotificationPut;
import com.dim.Models.Entitys.Notification;
import com.dim.Models.message.MyObjectProducer;
import com.dim.Repository.NotificationRepository;
import com.dim.Services.InterfaceServices.IntNotificationServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.NotificationFilter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImpNotificationServices implements IntNotificationServices {

    private final NotificationRepository notificationRepository;

    private final MyObjectProducer myObjectProducer;

    @Override
    public List<Notification> getNotification() {return notificationRepository.findAll();}

    @Override
    public List<Notification> getNotificationByCuit(int cuit_notification) {
        return notificationRepository.findAllByCuit(cuit_notification);
    }

    @Override
    public boolean deletNoficationById(Long id_notification) {

        if (notificationRepository.existsById(id_notification)) {
            notificationRepository.deleteById(id_notification);
            return true;
        } else {
            return false;
        }


    }

    @Override
    public Notification addNotification(Notification notification) throws JsonProcessingException {


        final ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());

        myObjectProducer.sendMessage(objectMapper.writeValueAsString(notification));

        return notificationRepository.save(notification);

    }

    @Override
    public boolean verifyCredentials(Notification notification) {
        return false;
    }
    @Override
    public void Notificated(Long id) {
        notificationRepository.updateAllStatusDateReportedByCuitNotification(id);
    }
}

























