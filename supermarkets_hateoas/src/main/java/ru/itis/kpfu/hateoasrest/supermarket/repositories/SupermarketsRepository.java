package ru.itis.kpfu.hateoasrest.supermarket.repositories;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.itis.kpfu.hateoasrest.supermarket.models.Supermarket;

public interface SupermarketsRepository extends JpaRepository<Supermarket, Long> {
    @RestResource(
            path = "Open",
            rel = "findAllOpen"
    )
    @Query("from Supermarket supermarket where supermarket.state = 'Open'")
    Page<Supermarket> findAllOpen(Pageable var1);

    List<Supermarket> findAllByTitle(String var1);
}
