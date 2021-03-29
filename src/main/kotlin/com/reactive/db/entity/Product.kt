package com.reactive.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Table("product")
data class Product(
    @Id val id: Long?,
    @Column("name") val name: String,
    @Column("price") val price: Double,
    @Column("description") val description: String
) {

}