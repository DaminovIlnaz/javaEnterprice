package ru.itis.kpfu.hateoasrest.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.hateoasrest.supermarket.models.Seller;

public interface SellersRepository extends JpaRepository<Seller, Long> {
}
