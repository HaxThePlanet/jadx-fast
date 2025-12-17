package app.dogo.com.dogo_android.n.m;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.n.m.o.c a;
    public final app.dogo.com.dogo_android.n.m.o b;
    public a(app.dogo.com.dogo_android.n.m.o.c o$c, app.dogo.com.dogo_android.n.m.o o2) {
        super();
        this.a = c;
        this.b = o2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.c.d(this.a, this.b, view);
    }
}
