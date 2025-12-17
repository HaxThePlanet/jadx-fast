package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.o.u a;
    public final app.dogo.com.dogo_android.y.o.u.g b;
    public k(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.g u$g2) {
        super();
        this.a = u;
        this.b = g2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        u.g.d(this.a, this.b, view);
    }
}
