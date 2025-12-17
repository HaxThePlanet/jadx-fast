package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class h1 implements n {

    public final Boolean a;
    public final Boolean b;
    public final app.dogo.com.dogo_android.s.a.r3 c;
    public final String v;
    public h1(Boolean boolean, Boolean boolean2, app.dogo.com.dogo_android.s.a.r3 r33, String string4) {
        super();
        this.a = boolean;
        this.b = boolean2;
        this.c = r33;
        this.v = string4;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return r3.B(this.a, this.b, this.c, this.v, (List)object);
    }
}
