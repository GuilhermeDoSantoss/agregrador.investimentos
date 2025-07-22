package crud.java.agendadorinvestimentos.controller;

import crud.java.agendadorinvestimentos.controller.dto.AccountResponseDTO;
import crud.java.agendadorinvestimentos.controller.dto.CreateAccountDTO;
import crud.java.agendadorinvestimentos.controller.dto.CreateUserDTO;
import crud.java.agendadorinvestimentos.controller.dto.UpdateUserDTO;
import crud.java.agendadorinvestimentos.entity.User;
import crud.java.agendadorinvestimentos.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO createUserDTO){
        var userId = userService.createUser(createUserDTO);
        return ResponseEntity.created(URI.create("/users" + userId.toString())).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
        var user = userService.getUserById(userId);

        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers(){
       var users = userService.listaUsers();

       return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId,
                                               @RequestBody UpdateUserDTO updateUserDTO){

        userService.updateUserById(userId, updateUserDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId){

        userService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/accounts")
    public ResponseEntity<Void> deleteById(@PathVariable("userId") String userId,
                                           @RequestBody CreateAccountDTO createAccountDTO){

        userService.createAccount(userId, createAccountDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/accounts")
    public ResponseEntity<List<AccountResponseDTO>> listAccounts(@PathVariable("userId") String userId){

       var accounts =  userService.listAccounts(userId);

        return ResponseEntity.ok(accounts);
    }



}
