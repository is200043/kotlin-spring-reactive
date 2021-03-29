package com.reactive.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("cart")
data class Cart(
    @Id val id: Long?,
    @Column("cart_id") val cartId: String,
    @Column("product_id") val productId: Long,
    @Column("product_qty") var productQty: Int = 0,
    @Column("product_price") var productPrice: Double = 0.0
) {

}
