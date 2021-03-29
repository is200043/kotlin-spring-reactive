package com.reactive.web.service

import com.reactive.db.entity.Cart
import com.reactive.db.repo.CartRepo
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono
import java.util.*
import java.util.function.Supplier

@Service
class CartService(val cartRepo: CartRepo) {

    fun getCart(cartId: String): Flux<Cart> {
        return cartRepo.findCartByCartId(cartId)
    }

    fun addProduct(cart: Cart) {
        cartRepo.findCartByCartIdAndProductId(cart.cartId, cart.productId)
            .defaultIfEmpty(cart)
            .subscribe {
                it.productQty = cart.productQty
                cartRepo.save(it).subscribe()
            }
    }

    fun delProduct(cart: Cart) {
        cartRepo.findCartByCartIdAndProductId(cart.cartId, cart.productId)
            .subscribe {
                cartRepo.delete(it).subscribe()
            }
    }
}