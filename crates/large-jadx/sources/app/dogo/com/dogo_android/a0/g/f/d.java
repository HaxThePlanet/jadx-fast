package app.dogo.com.dogo_android.a0.g.f;

import com.google.android.gms.tasks.g;
import java.util.Set;

/* loaded from: classes.dex */
public final class d implements g {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public final app.dogo.com.dogo_android.a0.g.f.g0.c b;
    public final String c;
    public final Set d;
    public d(app.dogo.com.dogo_android.a0.g.f.g0 g0, app.dogo.com.dogo_android.a0.g.f.g0.c g0$c2, String string3, Set set4) {
        super();
        this.a = g0;
        this.b = c2;
        this.c = string3;
        this.d = set4;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.C1(this.b, this.c, this.d, (QuerySnapshot)object);
    }
}
