package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.o.q a;
    public final app.dogo.com.dogo_android.y.o.q.e b;
    public d(app.dogo.com.dogo_android.y.o.q q, app.dogo.com.dogo_android.y.o.q.e q$e2) {
        super();
        this.a = q;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        q.e.d(this.a, this.b, view);
    }
}
