package app.dogo.com.dogo_android.service;

import i.b.c0;
import i.b.e0;
import java.util.Map;

/* loaded from: classes.dex */
public final class i0 implements e0 {

    public final app.dogo.com.dogo_android.service.i2 a;
    public final Map b;
    public final String c;
    public i0(app.dogo.com.dogo_android.service.i2 i2, Map map2, String string3) {
        super();
        this.a = i2;
        this.b = map2;
        this.c = string3;
    }

    @Override // i.b.e0
    public final void a(c0 c0) {
        i2.h(this.a, this.b, this.c, c0);
    }
}
