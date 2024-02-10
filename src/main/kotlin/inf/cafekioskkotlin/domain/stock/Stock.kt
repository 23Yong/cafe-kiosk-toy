package inf.cafekioskkotlin.domain.stock

import inf.cafekioskkotlin.domain.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Stock(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    val productNumber: String,

    var quantity: Int,
) : BaseEntity() {
    fun isQuantityLessThan(quantity: Int) = this.quantity < quantity

    fun deductQuantity(quantity: Int) {
        if (isQuantityLessThan(quantity)) {
            throw IllegalArgumentException("차감할 재고 수량이 없습니다.")
        }

        this.quantity -= quantity
    }
}
