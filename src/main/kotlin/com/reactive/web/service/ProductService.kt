package com.reactive.web.service

import com.reactive.db.entity.Product
import com.reactive.db.repo.ProductRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProductService(val productRepo: ProductRepo) {

    fun getProducts(): Flux<Product> {
        return productRepo.findAll()
    }

    fun getProductById(id: Long): Mono<Product> {
        return productRepo.findById(id)
//            .doOnNext(customer -> {
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//        }).block(Duration.ofSeconds(10));
    }

    fun getProductByName(name: String): Mono<Product> {
        return productRepo.findProductByName(name)
    }

}