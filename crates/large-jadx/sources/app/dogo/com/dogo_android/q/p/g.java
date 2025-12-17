package app.dogo.com.dogo_android.q.p;

import androidx.lifecycle.y;
import app.dogo.com.dogo_android.y.j;

/* loaded from: classes.dex */
public final class g implements y {

    public final app.dogo.com.dogo_android.q.p.w a;
    public final j b;
    public g(app.dogo.com.dogo_android.q.p.w w, j j2) {
        super();
        this.a = w;
        this.b = j2;
    }

    @Override // androidx.lifecycle.y
    public final void onChanged(Object object) {
        w.J1(this.a, this.b, (y)object);
    }
}
