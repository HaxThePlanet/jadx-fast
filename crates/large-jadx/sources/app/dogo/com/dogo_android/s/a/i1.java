package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class i1 implements n {

    public final app.dogo.com.dogo_android.s.a.r3 a;
    public final String b;
    public final Boolean c;
    public i1(app.dogo.com.dogo_android.s.a.r3 r3, String string2, Boolean boolean3) {
        super();
        this.a = r3;
        this.b = string2;
        this.c = boolean3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r3.C(this.a, this.b, this.c, (Boolean)object);
    }
}
