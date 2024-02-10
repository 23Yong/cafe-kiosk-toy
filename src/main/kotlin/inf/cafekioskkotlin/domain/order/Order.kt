package inf.cafekioskkotlin.domain.order

import inf.cafekioskkotlin.domain.BaseEntity
import inf.cafekioskkotlin.domain.orderproduct.OrderProduct
import inf.cafekioskkotlin.domain.product.Product
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
class Order(
    products: List<Product>,
    val registeredDate: LocalDateTime,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Enumerated(EnumType.STRING)
    val orderStatus: OrderStatus = OrderStatus.INIT

    val totalPrice: Int

    @OneToMany(mappedBy = "order")
    val orderProducts: List<OrderProduct>

    init {
        totalPrice = calculateTotalPrice(products)
        orderProducts = products.map {
            OrderProduct(
                product = it,
                order = this
            )
        }
    }

    private fun calculateTotalPrice(products: List<Product>) = products.sumOf { it.price }
}
