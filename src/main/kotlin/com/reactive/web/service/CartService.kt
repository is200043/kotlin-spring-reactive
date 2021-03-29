package com.reactive.web.service

import com.reactive.db.entity.Cart
import com.reactive.db.repo.CartRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Service
class CartService(val cartRepo: CartRepo) {

    fun getCart(cartId: String): Flux<Cart> {
        return cartRepo.findCartByCartId(cartId)
    }

    fun addProduct(cart: Cart) {
        cartRepo.save(cart);


//        cartRepo.addCart(cart);

//        cartRepo.findCartByCartIdAndProductId(cart.cartId, cart.productId)
//            .flatMap {
//                it.productQty = it.productQty + 1
//                cartRepo.save(it)
//            }
//            .subscribe {
//                it.productQty = it.productQty + 1
//                println(it)
//                cartRepo.save(it)
//            }
//            .doOnSuccess() {
//                it.productQty = it.productQty++
//                cartRepo.save(it)
//            }
    }
}