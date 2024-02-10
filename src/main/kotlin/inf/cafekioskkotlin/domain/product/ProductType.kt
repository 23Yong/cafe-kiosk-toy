package inf.cafekioskkotlin.domain.product

enum class ProductType(
    val text: String,
) {
    HANDMADE("수제음료"),
    BOTTLE("병음료"),
    BAKERY("베이커리"),
    ;

    companion object {
        fun containsStockType(type: ProductType) = listOf(BOTTLE, BAKERY).contains(type)
    }
}
