package ru.itis.kpfu.hateoasrest.supermarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.kpfu.hateoasrest.supermarket.models.Supermarket;
import ru.itis.kpfu.hateoasrest.supermarket.repositories.SupermarketsRepository;

@Service
public class SupermarketsServiceImpl implements SupermarketsService {
    @Autowired
    public SupermarketsRepository supermarketsRepository;

    public SupermarketsServiceImpl() {
    }

    public Supermarket publish(Long supermarketId) {
        Supermarket supermarket = (Supermarket)this.supermarketsRepository.findById(supermarketId).orElseThrow(IllegalArgumentException::new);
        supermarket.publish();
        this.supermarketsRepository.save(supermarket);
        return supermarket;
    }
}
