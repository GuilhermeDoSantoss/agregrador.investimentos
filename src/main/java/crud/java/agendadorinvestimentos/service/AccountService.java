package crud.java.agendadorinvestimentos.service;

import crud.java.agendadorinvestimentos.client.BrapClient;
import crud.java.agendadorinvestimentos.controller.dto.AccountStockResponseDTO;
import crud.java.agendadorinvestimentos.controller.dto.AssociateAccountStockDTO;
import crud.java.agendadorinvestimentos.entity.AccountStock;
import crud.java.agendadorinvestimentos.entity.AccountStockId;
import crud.java.agendadorinvestimentos.repository.AccountRepository;
import crud.java.agendadorinvestimentos.repository.AccountStockRepository;
import crud.java.agendadorinvestimentos.repository.StockRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {

    @Value("#{environment.TOKEN}")
    private String TOKEN;

    private AccountRepository accountRepository;

    private StockRepository stockRepository;

    private AccountStockRepository accountStockRepository;

    private BrapClient brapClient;

    public AccountService(AccountRepository accountRepository,
                          StockRepository stockRepository,
                          AccountStockRepository accountStockRepository,
                          BrapClient brapClient) {
        this.accountRepository = accountRepository;
        this.stockRepository = stockRepository;
        this.accountStockRepository = accountStockRepository;
        this.brapClient = brapClient;
    }

    public void associateStock(String accountId, AssociateAccountStockDTO dto) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        var stock = stockRepository.findById(dto.stockId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        var id = new AccountStockId(account.getAccountId(),stock.getStockId());
        var entity = new AccountStock(
                id,
                account,
                stock,
                dto.quantity()
        );


        accountStockRepository.save(entity);



    }

    public List<AccountStockResponseDTO> listStocks(String accountId) {

        var account = accountRepository.findById(UUID.fromString(accountId))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        return account.getAccountStocks()
                .stream()
                .map(as ->
                        new AccountStockResponseDTO(
                                as.getStock().getStockId(),
                                as.getQuantity(),
                                getTotal(as.getQuantity(), as.getStock().getStockId())
                        ))
                .toList();
    }

    private double getTotal(Integer quantity, String stockId){

        var response = brapClient.getQuote(TOKEN, stockId);

        var price = response.results().getFirst().regularMarketPrice();

        return quantity * price;
    }
}
