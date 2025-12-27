@Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 3 extends kotlin.d0.d.p implements kotlin.d0.c.a<kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke() {
        SubscriptionViewModel.this.getTimer().postValue(new CouponTimer(0L, r3));
        SubscriptionViewModel.this.getDiscountVisible().postValue(Boolean.FALSE);
    }

    3(SubscriptionViewModel subscriptionViewModel) {
        super(0);
    }
}
