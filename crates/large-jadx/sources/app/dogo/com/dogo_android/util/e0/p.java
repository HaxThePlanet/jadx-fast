package app.dogo.com.dogo_android.util.e0;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.q;
import h.a.b.b;
import java.util.List;

/* loaded from: classes.dex */
public class p<ItemType extends h.a.b.h.f>  extends b<ItemType> {

    private q C0;
    public p(List<ItemType> list, q q2) {
        super(list);
        Bundle obj1 = new Bundle();
        this.C0 = q2;
    }

    @Override // h.a.b.b
    public q d2() {
        return this.C0;
    }
}
