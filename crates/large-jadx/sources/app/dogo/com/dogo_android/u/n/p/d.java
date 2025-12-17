package app.dogo.com.dogo_android.u.n.p;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.n.p.k a;
    public final app.dogo.com.dogo_android.u.n.p.k.b b;
    public d(app.dogo.com.dogo_android.u.n.p.k k, app.dogo.com.dogo_android.u.n.p.k.b k$b2) {
        super();
        this.a = k;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        k.b.c(this.a, this.b, view);
    }
}
