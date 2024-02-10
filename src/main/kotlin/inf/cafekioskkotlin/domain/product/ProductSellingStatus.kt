package inf.cafekioskkotlin.domain.product

enum class ProductSellingStatus(
    val text: String,
) {
    SELLING("판매 중"),
    HOLD("판매 보류"),
    STOP_SELLING("판매 중지"),
    ;

    companion object {
        fun forDisplay() = listOf(SELLING, HOLD)
    }
}
