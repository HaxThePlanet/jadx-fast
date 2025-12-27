package app.dogo.com.dogo_android.util.e0;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.q;
import h.a.b.b;
import h.a.b.h.f;
import java.util.List;

/* compiled from: BaseNavComponentFlexibleAdapter.java */
/* loaded from: classes.dex */
public class p<ItemType extends f> extends b<ItemType> {

    private q C0;
    public p(List<ItemType> list, q qVar) {
        super(list);
        final Bundle bundle = new Bundle();
        this.C0 = qVar;
    }

    @Override // h.a.b.b
    public q d2() {
        return this.C0;
    }
}
