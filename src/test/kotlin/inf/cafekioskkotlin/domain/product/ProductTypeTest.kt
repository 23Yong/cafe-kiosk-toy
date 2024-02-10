package inf.cafekioskkotlin.domain.product

import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductTypeTest {

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    fun containsStockType() {
        // given
        val productType = ProductType.HANDMADE

        // when
        val result = ProductType.containsStockType(productType)

        // then
        result shouldBe false
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    fun containsStockType2() {
        // given
        val productTypes = listOf(ProductType.BOTTLE, ProductType.BAKERY)

        // when & then
        productTypes.forAll {
            ProductType.containsStockType(it) shouldBe true
        }
    }
}
