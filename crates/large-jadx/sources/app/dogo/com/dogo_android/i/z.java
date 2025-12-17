package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class z implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.n0 a;
    public final app.dogo.com.dogo_android.i.n0.d b;
    public z(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.d n0$d2) {
        super();
        this.a = n0;
        this.b = d2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n0.d.d(this.a, this.b, view);
    }
}
