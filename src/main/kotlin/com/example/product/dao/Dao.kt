package com.example.product.dao

import com.example.product.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductDAO: JpaRepository<Product, String>