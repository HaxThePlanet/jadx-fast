@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 2 extends kotlin.d0.d.p implements kotlin.d0.c.l<Boolean, kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke(Boolean boolean) {
        SubscriptionViewModel.this.isPurchaseRestored().postValue(new LoadResult_Success(boolean));
        SubscriptionViewModel.this.getShouldGoBack().postValue(Boolean.TRUE);
    }

    2(SubscriptionViewModel subscriptionViewModel) {
        super(1);
    }
}
