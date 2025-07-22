package crud.java.agendadorinvestimentos.repository;

import crud.java.agendadorinvestimentos.entity.AccountStock;
import crud.java.agendadorinvestimentos.entity.AccountStockId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStockId> {

}
