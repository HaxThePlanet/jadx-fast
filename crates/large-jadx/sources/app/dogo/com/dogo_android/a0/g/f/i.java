package app.dogo.com.dogo_android.a0.g.f;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class i implements c {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public final String b;
    public final String c;
    public i(app.dogo.com.dogo_android.a0.g.f.g0 g0, String string2, String string3) {
        super();
        this.a = g0;
        this.b = string2;
        this.c = string3;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.y1(this.b, this.c, j);
    }
}
