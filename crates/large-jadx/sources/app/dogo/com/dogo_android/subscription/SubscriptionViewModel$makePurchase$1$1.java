@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "userCancelled", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 1 extends kotlin.d0.d.p implements kotlin.d0.c.p<com.revenuecat.purchases.PurchasesError, Boolean, kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke(com.revenuecat.purchases.PurchasesError th, boolean z) {
        n.f(th, "error");
        SubscriptionViewModel.this.trackPurchaseError(th, z);
        final StringBuilder stringBuilder = new StringBuilder();
        final String str2 = ", userCancelled ";
        z = th + str2 + z;
        SubscriptionViewModel.this.getPurchaseUIState().postValue(new LoadResult_Error(new Exception(z)));
        SubscriptionViewModel.this.handleRecoverableRevenueCatError(th);
    }

    1(SubscriptionViewModel subscriptionViewModel) {
        super(2);
    }
}
