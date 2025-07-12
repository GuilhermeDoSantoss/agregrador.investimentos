package crud.java.agendadorinvestimentos.service;

import crud.java.agendadorinvestimentos.controller.CreateUserDTO;
import crud.java.agendadorinvestimentos.entity.User;
import crud.java.agendadorinvestimentos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser (CreateUserDTO createUserDTO){

        // DTO -> Entity
        var entity = new User(
                UUID.randomUUID(),
                createUserDTO.username(),
                createUserDTO.email(),
                createUserDTO.password(),
                Instant.now(),
                null);

         var userSaved =  userRepository.save(entity);

         return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId){

        return userRepository.findById(UUID.fromString(userId));
    }
}
