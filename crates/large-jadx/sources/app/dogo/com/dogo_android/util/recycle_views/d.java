package app.dogo.com.dogo_android.util.n0;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.p;
import java.io.Serializable;
import java.util.List;

/* compiled from: BaseFlexibleAdapter.java */
/* loaded from: classes.dex */
public class d<ItemType extends h.a.b.h.f> extends p<ItemType> {

    private q D0;
    private Bundle E0 = new Bundle();
    public d(List<ItemType> list, app.dogo.com.dogo_android.util.k0.f fVar, q qVar) {
        super(list, qVar);
        final Bundle bundle = new Bundle();
        this.D0 = qVar;
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public q d2() {
        return this.D0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public Serializable e2(String str) {
        return this.E0.getSerializable(str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public void f2(String str, Serializable serializable) {
        this.E0.putSerializable(str, serializable);
    }
}
