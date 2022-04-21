package com.testtransbank.servicio;

import com.testtransbank.dto.RegisterDto;
import com.testtransbank.exception.TestTransbankException;
import com.testtransbank.modelo.Users;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class AuthorizationService {

    private final UsersService usersService;
    private final PhoneService phoneService;

    @Transactional
    public Users register(RegisterDto registerDto) throws TestTransbankException {
        log.info("register | registerDto={}", registerDto);
        usersService.validNotExistByEmail(registerDto.getEmail());
        Users users = usersService.save(registerDto);
        phoneService.saveAll(users, registerDto);
        return users;
    }
}
