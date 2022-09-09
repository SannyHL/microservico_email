package com.ms_email.microservice_email.models;

import com.ms_email.microservice_email.enums.StatusEnvioEmail;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tbemail")
public class MsEmailModel {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;
    @Column
    private String pessoaEmail;
    @Column
    private String emissorEmail;
    @Column
    private String destinatarioEmail;
    @Column
    private String tituloEmail;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String texto;
    @Column
    private StatusEnvioEmail statusEnvioEmail;
    @Column
    private LocalDateTime dataEnvioEmail;




}
