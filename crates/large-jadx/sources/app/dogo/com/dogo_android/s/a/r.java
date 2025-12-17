package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class r implements n {

    public final String a;
    public final app.dogo.com.dogo_android.s.a.s2 b;
    public r(String string, app.dogo.com.dogo_android.s.a.s2 s22) {
        super();
        this.a = string;
        this.b = s22;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return s2.f(this.a, this.b, (List)object);
    }
}
