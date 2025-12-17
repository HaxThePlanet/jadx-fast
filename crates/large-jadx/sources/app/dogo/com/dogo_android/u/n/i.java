package app.dogo.com.dogo_android.u.n;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.n.o a;
    public final app.dogo.com.dogo_android.u.n.o.e b;
    public i(app.dogo.com.dogo_android.u.n.o o, app.dogo.com.dogo_android.u.n.o.e o$e2) {
        super();
        this.a = o;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.e.f(this.a, this.b, view);
    }
}
