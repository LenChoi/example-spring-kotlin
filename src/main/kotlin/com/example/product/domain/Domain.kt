package com.example.product.domain

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.Min
import javax.validation.constraints.Size

@Entity
data class Product(

    @Id
    @field:Size(min = 3, max = 20) // 코틀린에서는 생성자에 validation을 붙이기 때문에 필드를 앞에 붙여준다
    val name:String,

    @field:Min(0)
    var price:Double? = 55.5,

    @field:Min(0)
    var stock:Int = 0){
}