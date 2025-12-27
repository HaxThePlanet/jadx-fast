@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 1 extends kotlin.d0.d.p implements kotlin.d0.c.l<com.revenuecat.purchases.PurchaserInfo, kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke(com.revenuecat.purchases.PurchaserInfo purchaserInfo) {
        str = "it";
        n.f(purchaserInfo, str);
        if (app.dogo.com.dogo_android.util.extensionfunction.j1.P(purchaserInfo)) {
            SubscriptionViewModel.this.tracker.logEvent(E_Subscription.d);
            SubscriptionViewModel.this.purchases.invalidatePurchaserInfoCache();
        }
    }

    1(SubscriptionViewModel subscriptionViewModel) {
        super(1);
    }
}
