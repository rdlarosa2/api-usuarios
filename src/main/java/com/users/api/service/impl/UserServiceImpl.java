package com.users.api.service.impl;

import com.users.api.dto.PhoneDto;
import com.users.api.dto.UserEntityDto;
import com.users.api.dto.UserEntityResponseDto;
import com.users.api.exceptions.CreatingUserWithExistentEmailException;
import com.users.api.models.Phone;
import com.users.api.models.Role;
import com.users.api.models.UserEntity;
import com.users.api.repository.PhoneRepository;
import com.users.api.repository.UserRepository;
import com.users.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PhoneRepository phoneRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PhoneRepository phoneRepository, PasswordEncoder thePasswordEncoder) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
        this.passwordEncoder = thePasswordEncoder ;
    }

    @Override
    public List<UserEntityResponseDto> findAll() {
        List<UserEntity> list = this.userRepository.findAll();
        List<UserEntityResponseDto> userEntityDtoList = new ArrayList<UserEntityResponseDto>();
        UserEntityResponseDto userEntityResponseDto = null ;
        PhoneDto phoneDto = null;

        for (UserEntity userEntity: list) {
            userEntityResponseDto = new UserEntityResponseDto(userEntity) ;

            userEntityDtoList.add(userEntityResponseDto);
        }
        return userEntityDtoList;
    }

    public UserEntityResponseDto findById(int id) {
        UserEntity userEntity = this.userRepository.findById(id);
        UserEntityResponseDto userEntityResponseDto = new UserEntityResponseDto(userEntity);
        return userEntityResponseDto ;
    }

    @Override
    public List<UserEntityResponseDto> findByName(String username) {
        List<UserEntity> list = this.userRepository.findByName(username);
        List<UserEntityResponseDto> listDto = new ArrayList<UserEntityResponseDto>();
        UserEntityResponseDto userEntityResponseDto = null;

        for (UserEntity userEntity: list) {
            userEntityResponseDto = new UserEntityResponseDto(userEntity);
            listDto.add(userEntityResponseDto);
        }

        return listDto;
    }

    @Override
    public UserEntityResponseDto save(UserEntityDto theUser) {
        List<Phone> phones = null ;
        if ( userRepository.existsByEmail(theUser.getEmail()) ) {
            throw new CreatingUserWithExistentEmailException("El correo ya registrado");
        }
        Date now = new Date();
        if (passwordEncoder==null) {
            passwordEncoder = new BCryptPasswordEncoder();
        }
        UserEntity userEntity = new UserEntity(0, theUser.getName(), theUser.getEmail(), passwordEncoder.encode(theUser.getPassword()), new ArrayList<Role>(), now, now, null, phones);
        UserEntity userEntity1 = userRepository.save(userEntity);
        PhoneDto[] arrayPhones = new PhoneDto[theUser.getPhones().length];
        for (int i=0 ; i < theUser.getPhones().length ; i++ ) {
            Phone phone = new Phone(0,theUser.getPhones()[i].getNumber(), theUser.getPhones()[i].getCitycode(), theUser.getPhones()[i].getCountrycode(),userEntity1);
            Phone phone1 = this.phoneRepository.save(phone);
            arrayPhones[i] = new PhoneDto(phone1);
        }
        /*
        Date creationDate = user.getCreated();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
        StringBuffer creationDateSB = new StringBuffer("");
        FieldPosition fp = new  FieldPosition(0);
        creationDateSB = sdf.format(creationDate,creationDateSB,fp);
        */
        UserEntityResponseDto userEntityResponseDto = new UserEntityResponseDto(userEntity1);
        userEntityResponseDto.setPhones(arrayPhones);
        return userEntityResponseDto;
    }

}
