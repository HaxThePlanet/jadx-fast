package app.dogo.com.dogo_android.y.w;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.w.l a;
    public final app.dogo.com.dogo_android.y.w.l.e b;
    public c(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.e l$e2) {
        super();
        this.a = l;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.e.d(this.a, this.b, view);
    }
}
