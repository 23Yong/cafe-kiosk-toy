package inf.cafekioskkotlin.domain.stock

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StockTest {
    @DisplayName("재고의 수량이 제공된 수량보다 적은지 확인한다.")
    @Test
    fun isQuantityLessThan() {
        // given
        val stock = Stock(
            productNumber = "001",
            quantity = 1
        )

        // when
        val result = stock.isQuantityLessThan(2)

        // then
        result shouldBe true
    }

    @DisplayName("재고보다 많은 수의 수량으로 차감 시도하는 경우 예외가 발생한다.")
    @Test
    fun deductQuantity() {
        // given
        val stock = Stock(
            productNumber = "001",
            quantity = 1
        )

        // when & then
        shouldThrow<IllegalArgumentException> {
            stock.deductQuantity(2)
        }.message shouldBe "차감할 재고 수량이 없습니다."
    }

    @DisplayName("재고를 주어진 개수만큼 차감할 수 있다.")
    @Test
    fun deductQuantity2() {
        // given
        val stock = Stock(
            productNumber = "001",
            quantity = 1
        )

        // when
        stock.deductQuantity(1)

        // then
        stock.quantity shouldBe 0
    }
}
