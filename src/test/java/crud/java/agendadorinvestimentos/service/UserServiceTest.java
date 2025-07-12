package crud.java.agendadorinvestimentos.service;

import crud.java.agendadorinvestimentos.controller.CreateUserDTO;
import crud.java.agendadorinvestimentos.entity.User;
import crud.java.agendadorinvestimentos.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Nested
    class createUser{

        @Test
        @DisplayName("Should create a user with sucess")
        void shouldCreateAUserWithSucess(){

            // Arrange "Preparar"
            var user = new User(UUID.randomUUID(),
                    "username",
                    "email@email.com",
                    "password",
                    Instant.now(),
                    null
            );

            doReturn(user).when(userRepository).save(any());
            var input = new CreateUserDTO("username",
                    "email@email.com",
                    "12345"
            );

            // Act "Agir"
            var output = userService.createUser(input);


            // Assert "Verificar"
            assertNotNull(output);

        }


    }



}