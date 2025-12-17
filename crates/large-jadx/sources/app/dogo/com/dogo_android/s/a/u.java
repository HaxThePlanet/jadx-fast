package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
public final class u implements n {

    public final app.dogo.com.dogo_android.s.a.t2 a;
    public final m0 b;
    public final Boolean c;
    public final boolean v;
    public u(app.dogo.com.dogo_android.s.a.t2 t2, m0 m02, Boolean boolean3, boolean z4) {
        super();
        this.a = t2;
        this.b = m02;
        this.c = boolean3;
        this.v = z4;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return t2.i(this.a, this.b, this.c, this.v, (DogProfile)object);
    }
}
