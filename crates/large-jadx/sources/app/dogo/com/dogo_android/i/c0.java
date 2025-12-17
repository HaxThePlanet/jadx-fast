package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c0 implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.n0 a;
    public final app.dogo.com.dogo_android.i.n0.i b;
    public c0(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.i n0$i2) {
        super();
        this.a = n0;
        this.b = i2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n0.i.d(this.a, this.b, view);
    }
}
