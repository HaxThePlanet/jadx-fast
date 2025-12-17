package app.dogo.com.dogo_android.y.w;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.w.l a;
    public final app.dogo.com.dogo_android.y.w.l.a b;
    public a(app.dogo.com.dogo_android.y.w.l l, app.dogo.com.dogo_android.y.w.l.a l$a2) {
        super();
        this.a = l;
        this.b = a2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.a.d(this.a, this.b, view);
    }
}
