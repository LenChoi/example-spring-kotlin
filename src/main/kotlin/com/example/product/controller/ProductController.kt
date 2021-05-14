package com.example.product.controller

import com.example.product.domain.Product
import com.example.product.service.ProductService
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/product")
class ProductController {

    @Autowired
    private lateinit var productService: ProductService // lateinit으로 나중에 초기화 가능

    @ApiOperation("Get all entities")
    @GetMapping
    fun findAll() = productService.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<Product> {
        val entity = productService.findById(id)
        return ResponseEntity.status(if (entity != null) HttpStatus.OK else HttpStatus.NO_CONTENT).body(entity)
    }

    @PostMapping
    fun save(@Valid @RequestBody product: Product): ResponseEntity<Product> {
        val entity = productService.save(product)
        return ResponseEntity.status(HttpStatus.CREATED).body(entity)
    }

    @PutMapping
    fun update(@RequestBody product: Product): ResponseEntity<Product> {
        val entity = productService.update(product)
        return ResponseEntity.status(HttpStatus.OK).body(entity)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: String): ResponseEntity<Product> {
        val entity = productService.deleteById(id)
        return ResponseEntity.status(HttpStatus.OK).body(entity)
    }
}