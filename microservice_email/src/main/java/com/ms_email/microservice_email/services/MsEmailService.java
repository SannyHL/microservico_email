package com.ms_email.microservice_email.services;

import com.ms_email.microservice_email.enums.StatusEnvioEmail;
import com.ms_email.microservice_email.models.MsEmailModel;
import com.ms_email.microservice_email.repositories.MsEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MsEmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MsEmailRepository msEmailRepository;


    public MsEmailModel create(MsEmailModel msEmailModel) {
        try {
            var mensagem = new SimpleMailMessage();
            mensagem.setFrom(msEmailModel.getEmissorEmail());
            mensagem.setTo(msEmailModel.getDestinatarioEmail());
            mensagem.setSubject(msEmailModel.getTituloEmail());
            mensagem.setText(msEmailModel.getTexto());
            javaMailSender.send(mensagem);
            msEmailModel.setStatusEnvioEmail(StatusEnvioEmail.ENVIADO);
        } catch (MailException exception){
            msEmailModel.setStatusEnvioEmail(StatusEnvioEmail.ERRO);
        } finally {
            return msEmailRepository.save(msEmailModel);
        }
    }
}
