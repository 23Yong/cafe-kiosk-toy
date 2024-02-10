package inf.cafekioskkotlin.domain.product

import inf.cafekioskkotlin.domain.BaseEntity
import jakarta.persistence.*

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val productNumber: String,

    @Enumerated(EnumType.STRING)
    val type: ProductType,

    @Enumerated(EnumType.STRING)
    val sellingStatus: ProductSellingStatus,

    val name: String,

    val price: Int,
) : BaseEntity()
