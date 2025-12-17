package app.dogo.com.dogo_android.u.m;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.m.v a;
    public final app.dogo.com.dogo_android.u.m.v.b b;
    public k(app.dogo.com.dogo_android.u.m.v v, app.dogo.com.dogo_android.u.m.v.b v$b2) {
        super();
        this.a = v;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        v.b.c(this.a, this.b, view);
    }
}
