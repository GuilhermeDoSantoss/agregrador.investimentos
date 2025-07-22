package crud.java.agendadorinvestimentos.controller;

import crud.java.agendadorinvestimentos.controller.dto.AccountStockResponseDTO;
import crud.java.agendadorinvestimentos.controller.dto.AssociateAccountStockDTO;
import crud.java.agendadorinvestimentos.controller.dto.CreateAccountDTO;
import crud.java.agendadorinvestimentos.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/stocks")
    public ResponseEntity<Void> associateStock(@PathVariable("accountId") String accountId,
                                           @RequestBody AssociateAccountStockDTO dto){

        accountService.associateStock(accountId, dto);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{accountId}/stocks")
    public ResponseEntity<List<AccountStockResponseDTO>> associateStock(@PathVariable("accountId") String accountId){

        var stocks = accountService.listStocks(accountId);

        return ResponseEntity.ok().build();
    }
}
