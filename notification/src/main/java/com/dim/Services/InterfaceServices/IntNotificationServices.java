package com.dim.Services.InterfaceServices;

import com.dim.Models.Dtos.NotificationGet;
import com.dim.Models.Dtos.NotificationPut;
import com.dim.Models.Entitys.Notification;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IntNotificationServices{

    List<Notification> getNotification();

    List<Notification> getNotificationByCuit(int cuit_notification);

    boolean deletNoficationById(Long id_notification);

    Notification addNotification(Notification notification) throws JsonProcessingException;

    boolean verifyCredentials(Notification notification);

    void Notificated(Long id);
}
