package com.dim.Models.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NotificationGet {

    @NotNull
    //@Min(value = 10,message = "El CUIT tiene que tener como minimo 10 caracteres")
    private int cuit;
    @NotNull
    private String userEnv;
    @NotNull
    private String tributo;
    @NotNull
    private String notification;
    @NotNull
    private String pdf;
    @NotNull
    @PastOrPresent(message = "[dateRead] debe ser actual o pasada")
    private LocalDateTime dateRead;
    @NotNull
    @PastOrPresent(message = "[dateNotification] debe ser actual o pasada")
    private LocalDateTime dateNotification;
    @NotNull
    @PastOrPresent(message = "[dateDelivered] debe ser actual o pasada")
    private LocalDateTime dateDelivered;

    private boolean statusDateReported;

}
