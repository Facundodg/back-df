package com.dim.Services.InterfaceServices;

import com.dim.Models.Entitys.Notification;

import java.util.List;

public interface IntNotificationServices{

    List<Notification> getNotification();

    List<Notification> getNotificationByCuit(int cuit_notification);

    boolean deletNoficationById(Long id_notification);

    Notification addNotification(Notification notification);

    boolean verifyCredentials(Notification notification);

}
