package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Phone;
import com.pokemonreview.api.models.Role;
import com.pokemonreview.api.models.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQLDB)
public class UserEntityRepositoryTests {

    private UserRepository userRepository;

    @Autowired
    public UserEntityRepositoryTests(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    public void UserRepository_Save_ReturnsSavedUserEntity() {
        List<Role> roles1 = Stream.of(
                new Role(1, "USER")
        ).collect(Collectors.toList());

        List<Phone> phones = new ArrayList<Phone>() ;
        Phone phone = new Phone(0, "1234567", "111111", "57", null);
        phones.add(phone);

        UserEntity userEntity = UserEntity.builder().id(0).name("Luisx").email("luisx@gmail.com").password("1234567").roles(null)
                .created(new Date()).modified(new Date()).lastLogin(null).phones(phones).build();

        UserEntity savedUserEntity = this.userRepository.save(userEntity);

        Assertions.assertThat(savedUserEntity).isNotNull();
        Assertions.assertThat(savedUserEntity.getId()).isGreaterThan(0);
    }

    @Test
    public void UserRepostory_FindAll_ReturnsMoreThanOneUserEntity() {
        List<Phone> phones = new ArrayList<Phone>() ;
        Phone phone = new Phone(0, "1234567", "111111", "57", null);
        phones.add(phone);

        UserEntity userEntity = UserEntity.builder().id(0).name("Luisx").email("luisx@gmail.com").password("1234567").roles(null)
                .created(new Date()).modified(new Date()).lastLogin(null).phones(phones).build();
        UserEntity userEntity2 = UserEntity.builder().id(0).name("Carlosx").email("carlosx@gmail.com").password("1234567").roles(null)
                .created(new Date()).modified(new Date()).lastLogin(null).phones(phones).build();

        UserEntity savedUserEntity = this.userRepository.save(userEntity);
        UserEntity savedUserEntity2 = this.userRepository.save(userEntity2);
        List<UserEntity> list = this.userRepository.findAll();
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(3);
    }

    @Test
    public void UserEntityRepository_FindById_ReturnsSavedReview() {
        List<Phone> phones = new ArrayList<Phone>() ;
        Phone phone = new Phone(0, "1234567", "111111", "57", null);
        phones.add(phone);

        UserEntity userEntity = UserEntity.builder().id(0).name("Saray").email("saray@gmail.com").password("1234567").roles(null)
                .created(new Date()).modified(new Date()).lastLogin(null).phones(phones).build();

        UserEntity savedUserEntity = this.userRepository.save(userEntity);

        UserEntity returnedUserEntity = this.userRepository.findById(savedUserEntity.getId());

        Assertions.assertThat(returnedUserEntity).isNotNull();
    }
}
