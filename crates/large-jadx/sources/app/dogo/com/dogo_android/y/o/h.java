package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class h implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.o.u a;
    public final app.dogo.com.dogo_android.y.o.u.d b;
    public h(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.d u$d2) {
        super();
        this.a = u;
        this.b = d2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        u.d.e(this.a, this.b, view);
    }
}
