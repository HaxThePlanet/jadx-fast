package app.dogo.com.dogo_android.util.n0;

import android.os.Bundle;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.util.e0.p;
import app.dogo.com.dogo_android.util.k0.f;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class d<ItemType extends h.a.b.h.f>  extends p<ItemType> {

    private q D0;
    private Bundle E0;
    public d(List<ItemType> list, f f2, q q3) {
        super(list, q3);
        Bundle obj1 = new Bundle();
        this.E0 = obj1;
        this.D0 = q3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public q d2() {
        return this.D0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public Serializable e2(String string) {
        return this.E0.getSerializable(string);
    }

    @Override // app.dogo.com.dogo_android.util.e0.p
    public void f2(String string, Serializable serializable2) {
        this.E0.putSerializable(string, serializable2);
    }
}
