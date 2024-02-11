package inf.cafekioskkotlin.domain.product

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class ProductTypeTest : BehaviorSpec({
    given("재고 관련 타입이 아닌 상품 타입이 주어지면") {
        val productType = ProductType.HANDMADE

        `when`("재고 관련 타입인지 체크할 때") {
            val result = ProductType.containsStockType(productType)
            then("타입 체크에 성공한다.") {
                result shouldBe false
            }
        }
    }

    given("재고 관련 타입인 상품 타입이 주어지면") {
        val productTypes = listOf(ProductType.BOTTLE, ProductType.BAKERY)
        `when`("재고 관련 타입인지 체크할 때") {
            then("타입 체크에 성공한다.") {
                productTypes.forAll {
                    ProductType.containsStockType(it) shouldBe true
                }
            }
        }
    }
})
