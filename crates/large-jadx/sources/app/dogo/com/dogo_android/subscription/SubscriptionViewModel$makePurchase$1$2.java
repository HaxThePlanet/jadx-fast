@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n", d2 = {"<anonymous>", "", "product", "Lcom/android/billingclient/api/Purchase;", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 2 extends kotlin.d0.d.p implements kotlin.d0.c.p<com.android.billingclient.api.Purchase, com.revenuecat.purchases.PurchaserInfo, kotlin.w> {

    final /* synthetic */ app.dogo.com.dogo_android.subscription.DogoSkuDetails $it;
    @Override // kotlin.d0.d.p
    public final void invoke(com.android.billingclient.api.Purchase purchase, com.revenuecat.purchases.PurchaserInfo purchaserInfo) {
        n.f(purchase, "product");
        n.f(purchaserInfo, "purchaserInfo");
        if (app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo)) {
            SubscriptionViewModel.this.repository.handlePurchase(SubscriptionViewModel.this.viewSource, this.$it, purchase, purchaserInfo);
            SubscriptionViewModel.this.doubleCheckRevenueCatCache();
            tRUE2 = Boolean.TRUE;
            SubscriptionViewModel.this.getShouldGoBack().postValue(tRUE2);
            SubscriptionViewModel.this.setPurchaseWasMade(true);
            SubscriptionViewModel.this.couponNotificationInteractor.b();
            SubscriptionViewModel.this.getPurchaseUIState().postValue(new LoadResult_Success(tRUE2));
        }
    }

    2(SubscriptionViewModel subscriptionViewModel, DogoSkuDetails dogoSkuDetails) {
        this.$it = dogoSkuDetails;
        super(2);
    }
}
