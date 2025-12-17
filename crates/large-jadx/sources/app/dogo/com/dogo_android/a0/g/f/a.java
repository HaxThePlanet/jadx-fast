package app.dogo.com.dogo_android.a0.g.f;

import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class a implements g {

    public final app.dogo.com.dogo_android.a0.g.f.d0 a;
    public a(app.dogo.com.dogo_android.a0.g.f.d0 d0) {
        super();
        this.a = d0;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        d0.Z(this.a, (QuerySnapshot)object);
    }
}
