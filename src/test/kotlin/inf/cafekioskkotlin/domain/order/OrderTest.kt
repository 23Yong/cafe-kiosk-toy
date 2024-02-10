package inf.cafekioskkotlin.domain.order

import inf.cafekioskkotlin.domain.product.Product
import inf.cafekioskkotlin.domain.product.ProductSellingStatus
import inf.cafekioskkotlin.domain.product.ProductType
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class OrderTest {
    @DisplayName("주문 생성 시 상품 리스트에서 주문의 총 금액을 계산한다.")
    @Test
    fun calculateTotalPrice() {
        // given
        val products = listOf(
            createProduct("001", 1000),
            createProduct("002", 2000)
        )

        // when
        val order = Order(products = products, registeredDate = LocalDateTime.now())

        // then
        order.totalPrice shouldBe 3000
    }

    @DisplayName("주문 생성 시 리스트에서 주문상태는 INIT(주문생성)이다.")
    @Test
    fun init() {
        // given
        val products = listOf(
            createProduct("001", 1000),
            createProduct("002", 2000)
        )

        // when
        val order = Order(products = products, registeredDate = LocalDateTime.now())

        // then
        order.orderStatus shouldBe OrderStatus.INIT
    }

    @DisplayName("주문 생성 시 주문 등록일시를 기록한다.")
    @Test
    fun registeredDateTime() {
        // given
        val products = listOf(
            createProduct("001", 1000),
            createProduct("002", 2000)
        )
        val now = LocalDateTime.now()

        // when
        val order = Order(products, now)

        // then
        order.registeredDate shouldBe now
    }

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
