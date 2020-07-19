package ru.itis.kpfu.hateoasrest.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.hateoasrest.supermarket.models.Buyer;

public interface BuyersRepository extends JpaRepository<Buyer, Long> {
}
