package com.testtransbank.servicio;

import com.testtransbank.dto.RegisterDto;
import com.testtransbank.modelo.Phone;
import com.testtransbank.modelo.Users;
import com.testtransbank.repositorio.PhoneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Transactional
    public Collection<Phone> saveAll(Users users, RegisterDto registerDto) {
        log.info("saveAll | users={}, registerDto={}", users, registerDto);
        return saveAll(Phone.from(users, registerDto));
    }

    @Transactional
    public Collection<Phone> saveAll(Collection<Phone> phones) {
        log.info("saveAll | phones={}",phones);
        return phoneRepository.saveAll(phones);
    }
}
