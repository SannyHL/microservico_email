package com.ms_email.microservice_email.repositories;

import com.ms_email.microservice_email.models.MsEmailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MsEmailRepository extends JpaRepository<MsEmailModel, Long> {
}
