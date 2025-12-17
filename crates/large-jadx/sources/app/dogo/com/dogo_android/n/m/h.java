package app.dogo.com.dogo_android.n.m;

import androidx.lifecycle.v;
import androidx.lifecycle.y;

/* loaded from: classes.dex */
public final class h implements y {

    public final app.dogo.com.dogo_android.n.m.r a;
    public final v b;
    public h(app.dogo.com.dogo_android.n.m.r r, v v2) {
        super();
        this.a = r;
        this.b = v2;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        r.w(this.a, this.b, (y)object);
    }
}
