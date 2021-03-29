package com.reactive.web.controller

import com.reactive.db.entity.Cart
import com.reactive.web.service.CartService
import com.reactive.web.service.ProductService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/carts")
class CartController(val productService: ProductService, val cartService: CartService) {

    @GetMapping("/{cartId}")
    fun getCart(@PathVariable cartId: String): Flux<Cart> {
        return cartService.getCart(cartId)
    }

    @PostMapping
    fun postCart(@RequestParam cartId: String, @RequestParam productId: Long): Mono<Void> {
        productService.getProductById(productId).log()
            .subscribe { cartService.addProduct(Cart(null, cartId, productId, 99, it.price)) }
        return Mono.empty();
    }
}