package ru.itis.kpfu.hateoasrest.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.hateoasrest.supermarket.models.Basket;

public interface BasketsRepository extends JpaRepository<Basket, Long> {
}
