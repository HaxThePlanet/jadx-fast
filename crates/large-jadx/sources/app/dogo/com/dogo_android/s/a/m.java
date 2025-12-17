package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import i.b.c0;
import i.b.e0;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
public final class m implements e0 {

    public final m0 a;
    public final app.dogo.com.dogo_android.s.a.q2 b;
    public final TrickItem.TrickCategory c;
    public final String d;
    public m(m0 m0, app.dogo.com.dogo_android.s.a.q2 q22, TrickItem.TrickCategory trickItem$TrickCategory3, String string4) {
        super();
        this.a = m0;
        this.b = q22;
        this.c = trickCategory3;
        this.d = string4;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        q2.o(this.a, this.b, this.c, this.d, c0);
    }
}
