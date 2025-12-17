package app.dogo.com.dogo_android.u.n.q;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.n.q.m a;
    public final app.dogo.com.dogo_android.u.n.q.m.b b;
    public h(app.dogo.com.dogo_android.u.n.q.m m, app.dogo.com.dogo_android.u.n.q.m.b m$b2) {
        super();
        this.a = m;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.b.c(this.a, this.b, view);
    }
}
