package app.dogo.com.dogo_android.s.b;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class p0 implements n {

    public final app.dogo.com.dogo_android.s.b.p1 a;
    public final String b;
    public p0(app.dogo.com.dogo_android.s.b.p1 p1, String string2) {
        super();
        this.a = p1;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return p1.S(this.a, this.b, (DogLocalEntity)object);
    }
}
