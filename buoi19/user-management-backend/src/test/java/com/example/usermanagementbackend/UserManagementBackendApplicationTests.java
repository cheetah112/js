package com.example.usermanagementbackend;

import com.example.usermanagementbackend.entity.User;
import com.example.usermanagementbackend.repository.UserRepository;
import com.example.usermanagementbackend.service.FileService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserManagementBackendApplicationTests {


//    @Autowired
//    private FileService fileService;
    @Autowired
    private UserRepository userRepository;

//    @Test
//    void getFileExtension_test() {
//        System.out.println(fileService.getFileExtension("abc.png"));
//        System.out.println(fileService.getFileExtension("image.123.jpg"));
//    }

    @Test
    @Rollback(value = false)
    void save_user() {
        Faker faker = new Faker();
        for (int i = 0; i < 20 ; i++) {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password("111")
                    .address(faker.address().fullAddress())
                    .avatar("1")
                    .build();

            userRepository.save(user);
        }
    }


}
