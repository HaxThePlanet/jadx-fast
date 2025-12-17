package app.dogo.com.dogo_android.d.a;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class f implements e {

    public final app.dogo.com.dogo_android.d.a.m a;
    public f(app.dogo.com.dogo_android.d.a.m m) {
        super();
        this.a = m;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        m.M(this.a, j);
    }
}
