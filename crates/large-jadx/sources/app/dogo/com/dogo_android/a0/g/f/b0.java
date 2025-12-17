package app.dogo.com.dogo_android.a0.g.f;

import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class b0 implements g {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public final String b;
    public b0(app.dogo.com.dogo_android.a0.g.f.g0 g0, String string2) {
        super();
        this.a = g0;
        this.b = string2;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.A1(this.b, (QuerySnapshot)object);
    }
}
