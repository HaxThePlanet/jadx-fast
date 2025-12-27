@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@f(c = "app.dogo.com.dogo_android.subscription.DatabaseReferenceKt", f = "DatabaseReference.kt", l = 208, m = "saveValue")
static final class 1<T> extends kotlin.b0.k.a.d {

    int label;
    /* synthetic */ Object result;
    1(kotlin.b0.d<? super DatabaseReferenceKt.saveValue.AnonymousClass1> dVar) {
        super(dVar);
    }

    @Override // kotlin.b0.k.a.d
    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= -2147483648;
        com.google.firebase.database.DatabaseReference databaseReference = null;
        return DatabaseReferenceKt.saveValue(databaseReference, databaseReference, this);
    }
}
