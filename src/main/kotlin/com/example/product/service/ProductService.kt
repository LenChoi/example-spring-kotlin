package com.example.product.service

import com.example.product.dao.ProductDAO
import com.example.product.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DuplicateKeyException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class ProductService: BasicCrud<Product, String> {

    @Autowired
    private lateinit var productDAO: ProductDAO

    override fun findById(id: String): Product? = productDAO.findByIdOrNull(id)

    override fun save(t: Product): Product {
        return if(!productDAO.existsById(t.name)) productDAO.save(t) else throw DuplicateKeyException("${t.name} does exists")
    }

    override fun update(t: Product): Product {
        return if(!productDAO.existsById(t.name)) productDAO.save(t) else throw EntityNotFoundException("${t.name} does exists")
    }

    override fun deleteById(id: String): Product {
        return this.findById(id)?.apply {
            productDAO.deleteById(this.name)
        }?: throw EntityNotFoundException("Id does not exists")
    }

    override fun findAll():List<Product> = productDAO.findAll()
}