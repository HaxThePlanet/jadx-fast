@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 2 extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke(Throwable th) {
        n.f(th, "it");
        SubscriptionViewModel.this._result.postValue(new LoadResult_Error(th));
        SubscriptionViewModel.this.getUserError().postValue(th);
        SubscriptionViewModel.this.getSkuList().postValue(p.g());
        Boolean fALSE2 = Boolean.FALSE;
        SubscriptionViewModel.this.isFreeTrailAvailable().postValue(fALSE2);
        SubscriptionViewModel.this.getDiscountVisible().postValue(fALSE2);
        SubscriptionViewModel.this.getShouldGoBack().postValue(Boolean.TRUE);
    }

    2(SubscriptionViewModel subscriptionViewModel) {
        super(1);
    }
}
