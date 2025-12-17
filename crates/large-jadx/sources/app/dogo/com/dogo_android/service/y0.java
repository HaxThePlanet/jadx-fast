package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class y0 implements g {

    public final app.dogo.com.dogo_android.service.m2 a;
    public y0(app.dogo.com.dogo_android.service.m2 m2) {
        super();
        this.a = m2;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        m2.W(this.a, (QuerySnapshot)object);
    }
}
