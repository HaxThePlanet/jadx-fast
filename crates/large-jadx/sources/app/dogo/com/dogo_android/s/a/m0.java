package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;

/* loaded from: classes.dex */
public final class m0 implements n {

    public final app.dogo.com.dogo_android.s.a.l3 a;
    public final String b;
    public m0(app.dogo.com.dogo_android.s.a.l3 l3, String string2) {
        super();
        this.a = l3;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return l3.c(this.a, this.b, (WorkoutInfoEntity)object);
    }
}
