package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class d implements n {

    public static final app.dogo.com.dogo_android.subscription.d a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return BillingRepository.d((DataSnapshot)object);
    }
}
