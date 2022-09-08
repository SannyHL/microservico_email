package com.ms_email.microservice_email.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MsEmailDto {

    @NotBlank
    private String pessoaEmail;
    @NotBlank
    private String emissorEmail;
    @NotBlank
    private String destinatarioEmail;
    @NotBlank
    private String tituloEmail;
    @NotBlank
    private String texto;
}
