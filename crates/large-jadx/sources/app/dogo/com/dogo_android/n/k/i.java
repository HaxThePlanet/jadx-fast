package app.dogo.com.dogo_android.n.k;

import androidx.lifecycle.v;
import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class i implements y {

    public final app.dogo.com.dogo_android.n.k.q a;
    public final v b;
    public i(app.dogo.com.dogo_android.n.k.q q, v v2) {
        super();
        this.a = q;
        this.b = v2;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        q.u(this.a, this.b, (Integer)object);
    }
}
