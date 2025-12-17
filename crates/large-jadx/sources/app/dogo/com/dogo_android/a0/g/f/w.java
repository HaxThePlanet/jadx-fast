package app.dogo.com.dogo_android.a0.g.f;

import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class w implements g {

    public final app.dogo.com.dogo_android.a0.g.f.g0 a;
    public w(app.dogo.com.dogo_android.a0.g.f.g0 g0) {
        super();
        this.a = g0;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.E1((QuerySnapshot)object);
    }
}
