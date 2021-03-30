package com.reactive.db.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


@Table("product")
data class Product(
    @Id @JsonProperty("id") val id: Long?,
    @Column("name") @JsonProperty("name") val name: String,
    @Column("price") @JsonProperty("price") val price: Double,
    @Column("description") @JsonProperty("description") val description: String
) {

}