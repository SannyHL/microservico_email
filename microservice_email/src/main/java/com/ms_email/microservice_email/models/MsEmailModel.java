package com.ms_email.microservice_email.models;

import com.ms_email.microservice_email.enums.StatusEnvioEmail;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tbemail")
public class MsEmailModel {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID emailId;

    private String pessoaEmail;
    private String emissorEmail;
    private String destinatarioEmail;
    private String tituloEmail;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;
    private StatusEnvioEmail statusEnvioEmail;
    private LocalDateTime dataEnvioEmail;




}
