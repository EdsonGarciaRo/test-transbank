package com.testtransbank.repositorio;

import com.testtransbank.modelo.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}
