package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class d1 implements n {

    public final app.dogo.com.dogo_android.s.a.r3 a;
    public final String b;
    public d1(app.dogo.com.dogo_android.s.a.r3 r3, String string2) {
        super();
        this.a = r3;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r3.x(this.a, this.b, (List)object);
    }
}
