package com.reactive.web.controller

import com.reactive.db.entity.Product
import com.reactive.web.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono


@RestController
@RequestMapping("/products")
class ProductController(val productService: ProductService) {

    @GetMapping
    fun getAllProduct(): Flux<Product> {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id : Long): Mono<Product> {
        return productService.getProductById(id);
    }

//    @GetMapping("/{name}")
//    fun getProductByName(@PathVariable name : String): Mono<Product> {
//        return productService.getProductByName(name);
//    }
//
//    @PostMapping
//    fun postProduct(@RequestBody product : Mono<Product> ): Mono<Product> {
//        return product.flatMap { productRepo.save(it) };
//    }
//
//    @PutMapping("/{id}")
//    fun putProduct(@RequestBody product : Mono<Product> ): Mono<Product> {
//        return product.flatMap { p -> productRepo.save(p).flatMap { r -> p.id = r.toMono(). .id } };
//    }

//    @PostMapping
//    fun postProductInCart(@RequestParam cartId: String, @RequestParam productId: String, @RequestParam qty:Int): Mono<Cart> {
//        return product.flatMap { productRepo.save(it) };
//    }



//
//    @PutMapping("/{id}")
//    public Mono<ResponseEntity<Customer>> updateCustomer(@PathVariable String id, @RequestBody Mono<Customer> customer) {
//        return service.updateCustomerById(id, customer).map(ResponseEntity::ok)
//            .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public Mono<Void> deleteCustomer(@PathVariable String id) {
//        return service.deleteCustomer(id);
//    }
}