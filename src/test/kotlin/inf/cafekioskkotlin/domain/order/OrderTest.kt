package inf.cafekioskkotlin.domain.order

import inf.cafekioskkotlin.domain.product.Product
import inf.cafekioskkotlin.domain.product.ProductSellingStatus
import inf.cafekioskkotlin.domain.product.ProductType
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import java.time.LocalDateTime

class OrderTest : BehaviorSpec({
    given("상품이 주어지면") {
        val products = listOf(
            createProduct("001", 1000),
            createProduct("002", 2000)
        )
        val now = LocalDateTime.now()

        `when`("주문을 생성할 때") {
            val order = Order(products = products, registeredDate = now)

            then("주문의 총 금액을 계산한다.") {
                order.totalPrice shouldBe 3000
            }

            then("주문 상태는 INIT(주문생성)이다.") {
                order.orderStatus shouldBe OrderStatus.INIT
            }

            then("등록일시를 기록한다.") {
                order.registeredDate shouldBe now
            }
        }
    }
}) {
    companion object {
        fun createProduct(productNumber: String, price: Int) = Product(
            productNumber = productNumber,
            type = ProductType.BOTTLE,
            sellingStatus = ProductSellingStatus.SELLING,
            name = "상품이름",
            price = price
        )
    }
}
