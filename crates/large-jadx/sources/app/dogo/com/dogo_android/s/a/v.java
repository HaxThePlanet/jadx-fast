package app.dogo.com.dogo_android.s.a;

import i.b.l0.n;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
public final class v implements n {

    public final app.dogo.com.dogo_android.s.a.t2 a;
    public final String b;
    public final m0 c;
    public final boolean v;
    public v(app.dogo.com.dogo_android.s.a.t2 t2, String string2, m0 m03, boolean z4) {
        super();
        this.a = t2;
        this.b = string2;
        this.c = m03;
        this.v = z4;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return t2.j(this.a, this.b, this.c, this.v, (Boolean)object);
    }
}
