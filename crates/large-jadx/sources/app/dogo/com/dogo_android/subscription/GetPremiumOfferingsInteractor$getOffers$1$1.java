@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 1 extends kotlin.d0.d.p implements kotlin.d0.c.l<com.revenuecat.purchases.PurchasesError, kotlin.w> {

    final /* synthetic */ i.b.c0<app.dogo.com.dogo_android.repository.domain.SubscriptionOffer> $emitter;
    @Override // kotlin.d0.d.p
    public final void invoke(com.revenuecat.purchases.PurchasesError th) {
        n.f(th, "error");
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Purchase error code: ";
        com.revenuecat.purchases.PurchasesErrorCode code = th.getCode();
        String str3 = " - message : ";
        String message = th.getMessage();
        String str4 = " - extras: ";
        String underlyingErrorMessage = th.getUnderlyingErrorMessage();
        r1 = str2 + code + str3 + message + str4 + underlyingErrorMessage;
        a.d(new Exception(r1));
        this.$emitter.a(new PurchaseException(th.getCode()));
    }

    1(i.b.c0<app.dogo.com.dogo_android.repository.domain.SubscriptionOffer> c0Var) {
        this.$emitter = c0Var;
        super(1);
    }
}
