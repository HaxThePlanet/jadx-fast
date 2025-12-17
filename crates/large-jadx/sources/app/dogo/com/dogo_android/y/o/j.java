package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class j implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.o.u a;
    public final app.dogo.com.dogo_android.y.o.u.f b;
    public j(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.f u$f2) {
        super();
        this.a = u;
        this.b = f2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        u.f.d(this.a, this.b, view);
    }
}
