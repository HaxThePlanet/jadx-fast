package app.dogo.com.dogo_android.subscription;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class h implements n {

    public static final app.dogo.com.dogo_android.subscription.h a;
    static {
        h hVar = new h();
        h.a = hVar;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return BillingRepository.h((Boolean)object);
    }
}
