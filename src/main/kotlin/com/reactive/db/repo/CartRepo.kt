package com.reactive.db.repo

import com.reactive.db.entity.Cart
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CartRepo : ReactiveCrudRepository<Cart, String> {

    @Query("select c.* from Cart c where c.cart_id=:cartId")
    fun findCartByCartId(cartId: String): Flux<Cart>

    @Query("select c.* from Cart c where c.cart_id=:cartId and c.product_id=:productId")
    fun findCartByCartIdAndProductId(cartId: String, productId: Long): Mono<Cart>
}