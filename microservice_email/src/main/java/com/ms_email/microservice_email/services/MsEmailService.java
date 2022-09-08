package com.ms_email.microservice_email.services;

import com.ms_email.microservice_email.repositories.MsEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsEmailService {

    @Autowired
    private MsEmailRepository msEmailRepository;

}
