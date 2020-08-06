package com.myretail;

import com.myretail.common.dao.ProductPriceRepository;
import com.myretail.common.model.ProductPriceEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@SpringBootApplication
@EnableMongoRepositories("com.myretail.common.dao")
 @ComponentScan("com.myretail.common.dao")
public class MyRetailDataLoader {
    private static final Logger log = LoggerFactory.getLogger(MyRetailDataLoader.class);

    public static void main(String[] args) {
        SpringApplication.run(MyRetailDataLoader.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ProductPriceRepository productPriceRepository) {

        return args -> {
            log.info("loading data ...");

            productPriceRepository.save(new ProductPriceEntity("13860428", 100.00, "USD"));
            productPriceRepository.save(new ProductPriceEntity("54456119", 200.00, "USD"));
            productPriceRepository.save(new ProductPriceEntity("13264003", 300.00, "USD"));
            productPriceRepository.save(new ProductPriceEntity("12954218", 400.00, "USD"));

            log.info("data loaded ...");
            Optional<ProductPriceEntity> p = productPriceRepository.findById("54456119");
            log.info("p is ..."+p.get());

        };
    }
}