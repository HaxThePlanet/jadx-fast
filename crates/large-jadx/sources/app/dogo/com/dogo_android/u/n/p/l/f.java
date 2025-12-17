package app.dogo.com.dogo_android.u.n.p.l;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.n.p.l.j a;
    public final app.dogo.com.dogo_android.u.n.p.l.j.b b;
    public f(app.dogo.com.dogo_android.u.n.p.l.j j, app.dogo.com.dogo_android.u.n.p.l.j.b j$b2) {
        super();
        this.a = j;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j.b.d(this.a, this.b, view);
    }
}
