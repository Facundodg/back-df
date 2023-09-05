package com.dim.Services.ImplementServices;

import com.dim.Models.Dtos.NotificationPost;
import com.dim.Models.Entitys.Notification;
import com.dim.Repository.NotificationRepository;
import com.dim.Services.InterfaceServices.IntNotificationServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImpNotificationServices implements IntNotificationServices {

    private final NotificationRepository notificationRepository;

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
    public Notification addNotification(Notification notification) {

        return notificationRepository.save(notification);

    }

    @Override
    public boolean verifyCredentials(Notification notification) {
        return false;
    }
}
