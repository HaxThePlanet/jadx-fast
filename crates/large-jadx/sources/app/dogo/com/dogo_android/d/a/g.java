package app.dogo.com.dogo_android.d.a;

import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class g implements g {

    public final app.dogo.com.dogo_android.d.a.m a;
    public g(app.dogo.com.dogo_android.d.a.m m) {
        super();
        this.a = m;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        m.N(this.a, (QuerySnapshot)object);
    }
}
