package app.dogo.com.dogo_android.s.b;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class o0 implements n {

    public final app.dogo.com.dogo_android.s.b.p1 a;
    public final String b;
    public final String c;
    public o0(app.dogo.com.dogo_android.s.b.p1 p1, String string2, String string3) {
        super();
        this.a = p1;
        this.b = string2;
        this.c = string3;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return p1.R(this.a, this.b, this.c, (DogLocalEntity)object);
    }
}
