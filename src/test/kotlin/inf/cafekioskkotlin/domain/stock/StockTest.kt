package inf.cafekioskkotlin.domain.stock

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class StockTest : BehaviorSpec({
    given("수량정보가 주어지면") {
        val stock = Stock(
            productNumber = "001",
            quantity = 1
        )

        `when`("제공된 수량보다 적은지 확인할 때") {
            val result = stock.isQuantityLessThan(2)

            then("확인에 성공한다.") {
                result shouldBe true
            }
        }

        `when`("제공된 수량보다 많은 수의 수량으로 차감 시도하는 경우") {
            then("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    stock.deductQuantity(2)
                }.message shouldBe "차감할 재고 수량이 없습니다."
            }
        }

        `when`("재고를 주어진 개수만큼 차감하는 경우") {
            stock.deductQuantity(1)
            then("차감에 성공한다.") {
                stock.quantity shouldBe 0
            }
        }
    }
})
