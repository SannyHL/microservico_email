package com.ms_email.microservice_email.controllers;

import com.ms_email.microservice_email.dtos.MsEmailDto;
import com.ms_email.microservice_email.models.MsEmailModel;
import com.ms_email.microservice_email.services.MsEmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/email")
public class MsEmailController {

    @Autowired
    private MsEmailService msEmailService;

    @PostMapping("/")
    public ResponseEntity<MsEmailModel> envioEmail(@RequestBody @Valid MsEmailDto msEmailDto){
        var msEmailModel = new MsEmailModel();
        BeanUtils.copyProperties(msEmailDto, msEmailModel);
        msEmailModel.setDataEnvioEmail(LocalDateTime.now(ZoneId.of("UTC-3")));
        return new ResponseEntity<>(msEmailService.create(msEmailModel) ,HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<MsEmailModel>> verTodosEmails(){
        return new ResponseEntity<>(msEmailService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{emailId}")
    public ResponseEntity<MsEmailModel> verEmails(@PathVariable (value = "emailId")Long emailId){
        Optional<MsEmailModel> emailModelOptional = msEmailService.getId(emailId);
        if(emailModelOptional.isPresent()){
            return new ResponseEntity<>(emailModelOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/enviar")
    public String entrarPagina(){
        return "envia_email";
    }

    @PostMapping("/enviar")
    public ResponseEntity<MsEmailModel> envioEmailNavegador(MsEmailDto msEmailDto){
        var msEmailModel = new MsEmailModel();
        BeanUtils.copyProperties(msEmailDto, msEmailModel);
        msEmailModel.setDataEnvioEmail(LocalDateTime.now(ZoneId.of("UTC-3")));
        return new ResponseEntity<>(msEmailService.create(msEmailModel) ,HttpStatus.CREATED);
    }



}
