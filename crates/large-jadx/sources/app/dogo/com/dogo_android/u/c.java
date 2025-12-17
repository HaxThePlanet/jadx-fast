package app.dogo.com.dogo_android.u;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.i a;
    public final app.dogo.com.dogo_android.u.i.e b;
    public c(app.dogo.com.dogo_android.u.i i, app.dogo.com.dogo_android.u.i.e i$e2) {
        super();
        this.a = i;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.e.d(this.a, this.b, view);
    }
}
