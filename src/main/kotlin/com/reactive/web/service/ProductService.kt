package com.reactive.web.service

import com.reactive.db.entity.Product
import com.reactive.db.repo.ProductRepo
import org.springframework.data.redis.core.ReactiveRedisOperations
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@Service
class ProductService(
    val productRepo: ProductRepo,
    val productReactiveRedisOperations: ReactiveRedisOperations<String, Product>
) {

    fun getProducts(): Flux<Product> {
            productRepo.findAll()
                .flatMap { productReactiveRedisOperations.opsForValue().set("${it.id}", it) }
                .subscribe { println(it) }
        return productReactiveRedisOperations.keys("*")
            .flatMap(productReactiveRedisOperations.opsForValue()::get);
    }

    fun getProductById(id: Long): Mono<Product> {
        return productReactiveRedisOperations.keys("$id")
            .flatMap(productReactiveRedisOperations.opsForValue()::get).toMono();
//        return productRepo.findById(id)
    }

    fun getProductByName(name: String): Mono<Product> {
        return productRepo.findProductByName(name)
    }

}