package com.example.notification;

import com.dim.Conf.TestConfig;
import com.dim.Models.Entitys.Notification;
import com.dim.Services.ImplementServices.ImpNotificationServices;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = TestConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RequiredArgsConstructor

@SpringBootTest
class NotificationApplicationTests{

//	private ImpNotificationServices notificationServices;

	/*
	*
	*
	*     {
        "id": 1,
        "cuit": 123,
        "user_env": "fdiaz",
        "tributo": "TEM",
        "notification": "Deuda",
        "pdf": "BARRIOS-Zonas-III-y-IV-2023-09-28-12-58-28",
        "date_read": "2023-10-05 13:41:57",
        "date_notification": "2023-10-05 13:41:57",
        "date_delivered": "2023-10-05 13:41:57",
        "status_date_reported": true
    }
	*
	*
	* */


//	TEST 1 PARA BUSCAR POR CUIT NOTIFICATION
	@Test
	public void test1() {

//		final NotificationGet resultado = new NotificationGet();

//		String fechaLeida = "2023-10-05T13:41:57"; // Formato ISO-8601
//		LocalDateTime dateRead = LocalDateTime.parse(fechaLeida);
//		LocalDateTime dateNotification = LocalDateTime.parse(fechaLeida);
//		LocalDateTime dateDelivered = LocalDateTime.parse(fechaLeida);
//
//		Notification esperado = new Notification(1L,123,"fdiaz","TEM","deuda","BARRIOS-Zonas-III-y-IV-2023-09-28-12-58-28",dateRead
//		,dateNotification,dateDelivered,true);
//
//		final List<Notification> resultado = notificationServices.getNotificationByCuit(123);
//
//		Assertions.assertEquals(esperado,resultado);

	}

}
