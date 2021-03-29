package com.reactive.web.config

import com.reactive.db.entity.Cart
import com.reactive.db.entity.Product
import com.reactive.db.repo.CartRepo
import com.reactive.db.repo.ProductRepo
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.stream.Stream

@Component
class ApplicationConfig {

    @Bean
    fun runner(productRepo: ProductRepo, cartRepo: CartRepo, db: DatabaseClient) = ApplicationRunner {
        val initDb = db.sql("""
            CREATE TABLE IF NOT EXISTS product (
                id SERIAL PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                price DECIMAL(10,2) NOT NULL,
                description VARCHAR(255) NULL
            );
                
            CREATE TABLE IF NOT EXISTS cart (
                id SERIAL PRIMARY KEY,
                cart_id VARCHAR(10) NOT NULL,
                product_id INTEGER NOT NULL,
                product_qty INTEGER NOT NULL,
                product_price DECIMAL(10,2) NOT NULL
            );
        """.trimIndent())

        val streamProduct = Stream.of(
            Product(null, "mouse", 300.00, "ไร้สาย"),
            Product(null, "keyboard", 4000.00, "ไร้สาย"),
            Product(null, "iphone", 30000.00, "ไม่แถมหัวชาร์จ"),
            Product(null, "macbook", 100000.00, "")
        )
        val saveAllProduct = productRepo.saveAll(Flux.fromStream(streamProduct))


        val streamCart = Stream.of(
            Cart(null, "C1", 1, 1, 300.00),
            Cart(null, "C1", 3, 1, 30000.00)
        )
        val saveAllCart = cartRepo.saveAll(Flux.fromStream(streamCart))

        initDb
            .then()
            .thenMany(saveAllProduct)
            .thenMany(saveAllCart)
            .subscribe()
    }
}