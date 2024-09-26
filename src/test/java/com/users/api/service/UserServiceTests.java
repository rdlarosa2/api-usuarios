package com.users.api.service;

import com.users.api.repository.UserRepository;
import com.users.api.service.impl.UserServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    /*
    @Test
    public void UserService_Save_ReturnsUserEntityResponseDto() {
        Date now = new Date();
        List<Phone> phones = new ArrayList<Phone>() ;
        Phone phone = new Phone(0, "1234567", "111111", "57", null);
        phones.add(phone);

        PhoneDto phoneDto = PhoneDto.builder().number("2315535").citycode("111111").countrycode("57").build();
                //new PhoneDto(String number, String citycode, String countrycode);

        PhoneDto[] arrPhones = new PhoneDto[1];
        arrPhones[0] = phoneDto ;

        UserEntity userEntity = UserEntity.builder().id(0).name("Ana").email("ana@gmail.com").password("1234567").roles(null)
                .created(now).modified(now).lastLogin(now).phones(phones).build();

        UserEntityDto userEntityDto
                = UserEntityDto.builder().id(0).name("Ana").email("ana@gmail.com").password("1234567").created(now).modified(now).lastLogin(now).phones(arrPhones).build();

        when(userRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);

        UserEntityResponseDto savedUserEntityResponseDto = userService.save(userEntityDto);

        Assertions.assertThat(savedUserEntityResponseDto).isNotNull();
    }
    */

}
