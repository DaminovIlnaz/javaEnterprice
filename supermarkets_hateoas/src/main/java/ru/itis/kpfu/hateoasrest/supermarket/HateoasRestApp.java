package ru.itis.kpfu.hateoasrest.supermarket;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.kpfu.hateoasrest.supermarket.models.Basket;
import ru.itis.kpfu.hateoasrest.supermarket.models.Buyer;
import ru.itis.kpfu.hateoasrest.supermarket.models.Product;
import ru.itis.kpfu.hateoasrest.supermarket.models.Seller;
import ru.itis.kpfu.hateoasrest.supermarket.models.Supermarket;
import ru.itis.kpfu.hateoasrest.supermarket.repositories.BasketsRepository;
import ru.itis.kpfu.hateoasrest.supermarket.repositories.BuyersRepository;
import ru.itis.kpfu.hateoasrest.supermarket.repositories.ProductsRepository;
import ru.itis.kpfu.hateoasrest.supermarket.repositories.SellersRepository;
import ru.itis.kpfu.hateoasrest.supermarket.repositories.SupermarketsRepository;

@SpringBootApplication
public class HateoasRestApp {
    public HateoasRestApp() {
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HateoasRestApp.class, args);
        BasketsRepository basketsRepository = (BasketsRepository)context.getBean(BasketsRepository.class);
        BuyersRepository buyersRepository = (BuyersRepository)context.getBean(BuyersRepository.class);
        ProductsRepository productsRepository = (ProductsRepository)context.getBean(ProductsRepository.class);
        SellersRepository sellersRepository = (SellersRepository)context.getBean(SellersRepository.class);
        SupermarketsRepository supermarketsRepository = (SupermarketsRepository)context.getBean(SupermarketsRepository.class);
        Seller mrArslanoff = Seller.builder().firstName("мистер").lastName("Лев").build();
        Seller akaShirokoffa = Seller.builder().firstName("миссис").lastName("тичер").build();
        sellersRepository.saveAll(Arrays.asList(mrArslanoff, akaShirokoffa));
        Supermarket fiveOchka = Supermarket.builder().description("Продуктовый магазин для нищебродов. Сам там затариваюсь.").title("5ochka").state("Draft").seller(mrArslanoff).build();
        Supermarket fkuzWill = Supermarket.builder().description("Продуктовый магазин для изысканных гураманов. На самом деле тот же 5ochka.").title("FkuzWill").state("Open").seller(akaShirokoffa).build();
        supermarketsRepository.saveAll(Arrays.asList(fiveOchka, fkuzWill));
        Product chocolate = Product.builder().name("Шоколадка").price(100).supermarket(fiveOchka).build();
        Product soda = Product.builder().name("Газировка").price(200).supermarket(fiveOchka).build();
        Product crisps = Product.builder().name("Чипсы").price(150).supermarket(fiveOchka).build();
        Product banana = Product.builder().name("Связка бананов").price(100).supermarket(fkuzWill).build();
        Product cottageСheese = Product.builder().name("Какое-то коттеджное молоко, хз. На самом деле обычный творожок.").price(200).supermarket(fiveOchka).build();
        Product milk = Product.builder().name("Овсяное молочко. Гурманы обычное не пьют.").price(100).supermarket(fiveOchka).build();
        productsRepository.saveAll(Arrays.asList(chocolate, soda, crisps, banana, cottageСheese, milk));
        Buyer mrFerenezz = Buyer.builder().firstName("Мистер").lastName("Ferenezz").build();
        Buyer mrSalimov = Buyer.builder().firstName("Мистер").lastName("Zorro").build();
        buyersRepository.saveAll(Arrays.asList(mrFerenezz, mrSalimov));
        Basket.builder().buyer(mrFerenezz).supermarket(fkuzWill).build();
        Basket.builder().buyer(mrSalimov).supermarket(fiveOchka).build();
    }
}