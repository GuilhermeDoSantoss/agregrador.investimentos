package crud.java.agendadorinvestimentos.service;

import crud.java.agendadorinvestimentos.controller.dto.AccountResponseDTO;
import crud.java.agendadorinvestimentos.controller.dto.CreateAccountDTO;
import crud.java.agendadorinvestimentos.controller.dto.CreateUserDTO;
import crud.java.agendadorinvestimentos.controller.dto.UpdateUserDTO;
import crud.java.agendadorinvestimentos.entity.Account;
import crud.java.agendadorinvestimentos.entity.BillingAddress;
import crud.java.agendadorinvestimentos.entity.User;
import crud.java.agendadorinvestimentos.repository.AccountRepository;
import crud.java.agendadorinvestimentos.repository.BillingAddressRepository;
import crud.java.agendadorinvestimentos.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {


    private UserRepository userRepository;

    private AccountRepository accountRepository;

    private BillingAddressRepository billingAddressRepository;

    public UserService(UserRepository userRepository,
                       AccountRepository accountRepository,
                       BillingAddressRepository billingAddressRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.billingAddressRepository = billingAddressRepository;
    }

    public UUID createUser(CreateUserDTO createUserDTO) {

        // DTO -> Entity
        var entity = new User(
                UUID.randomUUID(),
                createUserDTO.username(),
                createUserDTO.email(),
                createUserDTO.password(),
                Instant.now(),
                null);

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }

    public Optional<User> getUserById(String userId) {

        return userRepository.findById(UUID.fromString(userId));
    }

    public List<User> listaUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String userId, UpdateUserDTO updateUserDTO) {

        var id = UUID.fromString(userId);

        var userExiste = userRepository.findById(id);

        if (userExiste.isPresent()) {
            var user = userExiste.get();

            if (updateUserDTO.username() != null) {
                user.setUsername(updateUserDTO.username());
            }

            if (updateUserDTO.password() != null) {
                user.setPassword(updateUserDTO.password());
            }

            userRepository.save(user);
        }
    }

    public void deleteById(String userId) {
        var id = UUID.fromString(userId);

        var userExiste = userRepository.existsById(id);

        if (userExiste) {
            userRepository.deleteById(id);
        }
    }

    public void createAccount(String userId, CreateAccountDTO createAccountDTO) {

        var user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // DTO -> ENTITY
        var account = new Account(
                UUID.randomUUID(),
                user,
                null,
                createAccountDTO.description(),
                new ArrayList<>()
        );

        var accountCreated = accountRepository.save(account);

        var billingAddres = new BillingAddress(
                accountCreated.getAccountId(),
                account,
                createAccountDTO.street(),
                createAccountDTO.number()
        );

        billingAddressRepository.save(billingAddres);
    }

    public List<AccountResponseDTO> listAccounts(String userId) {
        var user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return user.getAccounts()
                .stream()
                .map(ac ->
                        new AccountResponseDTO(ac.getAccountId().toString(), ac.getDescription()))
                .toList();
    }
}
