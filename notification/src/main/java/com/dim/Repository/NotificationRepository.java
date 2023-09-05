package com.dim.Repository;

import com.dim.Models.Entitys.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findAllByCuit(int cuit_notification);

}
