package inf.cafekioskkotlin.domain.orderproduct

import inf.cafekioskkotlin.domain.BaseEntity
import inf.cafekioskkotlin.domain.order.Order
import inf.cafekioskkotlin.domain.product.Product
import jakarta.persistence.*

@Entity
class OrderProduct(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product,
) : BaseEntity()
