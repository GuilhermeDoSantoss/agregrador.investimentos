package crud.java.agendadorinvestimentos.service;

import crud.java.agendadorinvestimentos.controller.dto.CreateStockDTO;
import crud.java.agendadorinvestimentos.entity.Stock;
import crud.java.agendadorinvestimentos.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    private StockRepository stockRepository;

    public void createStock(CreateStockDTO createStockDTO) {

        var stock = new Stock(
                createStockDTO.stockId(),
                createStockDTO.description()
        );

        stockRepository.save(stock);
    }
}
