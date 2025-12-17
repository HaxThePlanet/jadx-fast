package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.o.q a;
    public final app.dogo.com.dogo_android.y.o.q.c b;
    public a(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.c q$c2) {
        super();
        this.a = q;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        q.c.f(this.a, this.b, view);
    }
}
