package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class i implements n {

    public final app.dogo.com.dogo_android.s.a.i2 a;
    public final String b;
    public i(app.dogo.com.dogo_android.s.a.i2 i2, String string2) {
        super();
        this.a = i2;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return i2.d(this.a, this.b, (CertificateUrlModel)object);
    }
}
