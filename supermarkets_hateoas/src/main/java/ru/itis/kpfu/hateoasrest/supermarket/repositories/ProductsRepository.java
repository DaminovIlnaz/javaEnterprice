package ru.itis.kpfu.hateoasrest.supermarket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kpfu.hateoasrest.supermarket.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
