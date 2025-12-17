package app.dogo.com.dogo_android.y.w;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.w.l a;
    public final app.dogo.com.dogo_android.y.w.l.d b;
    public b(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.d l$d2) {
        super();
        this.a = l;
        this.b = d2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.d.d(this.a, this.b, view);
    }
}
