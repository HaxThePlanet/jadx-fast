@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 2 extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, kotlin.w> {
    @Override // kotlin.d0.d.p
    public final void invoke(Throwable th) {
        n.f(th, "it");
        RedeemCodeViewModel.this._result.postValue(new LoadResult_Error(th));
    }

    2(RedeemCodeViewModel redeemCodeViewModel) {
        super(1);
    }
}
