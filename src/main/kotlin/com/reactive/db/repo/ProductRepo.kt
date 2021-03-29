package com.reactive.db.repo

import com.reactive.db.entity.Product
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface ProductRepo : ReactiveCrudRepository<Product, Long> {

    @Query("select p.* from Product p where p.name = :name")
    fun findProductByName(name: String): Mono<Product>
}