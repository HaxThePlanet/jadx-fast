@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001H\n", d2 = {"<anonymous>", "", "it", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 3 extends kotlin.d0.d.p implements kotlin.d0.c.l<kotlin.w, kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke(kotlin.w wVar) {
        final Boolean tRUE2 = Boolean.TRUE;
        RedeemCodeViewModel.this._result.postValue(new LoadResult_Success(tRUE2));
        RedeemCodeViewModel.this.getOpenSubscription().postValue(tRUE2);
    }

    3(RedeemCodeViewModel redeemCodeViewModel) {
        super(1);
    }
}
