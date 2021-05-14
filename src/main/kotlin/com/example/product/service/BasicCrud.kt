package com.example.product.service

import com.example.product.domain.Product

interface BasicCrud<T, ID>{
    fun findAll(): List<T>
    fun findById(id:ID): T?
    fun save(t: T): Product
    fun update(t:T): Product
    fun deleteById(id:ID): Product
}