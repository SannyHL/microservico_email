package com.ms_email.microservice_email.controllers;

import com.ms_email.microservice_email.dtos.MsEmailDto;
import com.ms_email.microservice_email.models.MsEmailModel;
import com.ms_email.microservice_email.services.MsEmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Controller
@RequestMapping("/email")
public class MsEmailController {

    @Autowired
    private MsEmailService msEmailService;

    @PostMapping("/")
    public ResponseEntity<MsEmailModel> envioEmail(@RequestBody @Valid MsEmailDto msEmailDto){
        var msEmailModel = new MsEmailModel();
        BeanUtils.copyProperties(msEmailDto, msEmailModel);
        msEmailModel.setDataEnvioEmail(LocalDateTime.now(ZoneId.of("UTC")));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
