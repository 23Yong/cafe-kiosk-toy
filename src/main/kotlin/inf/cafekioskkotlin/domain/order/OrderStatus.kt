package inf.cafekioskkotlin.domain.order

enum class OrderStatus(
    val text: String,
) {
    INIT("주문생성"),
    CANCELED("주문취소"),
    PAYMENT_COMPLETED("결제완료"),
    PAYMENT_FALIED("결제실패"),
    RECEIVED("주문접수"),
    COMPLETE("주문완료"),
    ;
}
