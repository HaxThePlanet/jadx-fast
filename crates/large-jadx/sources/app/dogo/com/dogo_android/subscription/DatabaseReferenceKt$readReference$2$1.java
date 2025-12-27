@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n", d2 = {"<anonymous>", "", "T", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 1 extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, kotlin.w> {

    final /* synthetic */ app.dogo.com.dogo_android.subscription.DatabaseReferenceKt.readReference.AnonymousClass2.listener.AnonymousClass1 $listener;
    final /* synthetic */ com.google.firebase.database.DatabaseReference $reference;
    @Override // kotlin.d0.d.p
    public final void invoke(Throwable th) {
        this.$reference.removeEventListener(this.$listener);
    }

    1(com.google.firebase.database.DatabaseReference databaseReference, DatabaseReferenceKt.readReference.AnonymousClass2.listener.AnonymousClass1 1Var) {
        this.$reference = databaseReference;
        this.$listener = 1Var;
        super(1);
    }
}
