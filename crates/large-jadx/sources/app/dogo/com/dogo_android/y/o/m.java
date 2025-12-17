package app.dogo.com.dogo_android.y.o;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class m implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.o.u a;
    public final app.dogo.com.dogo_android.y.o.u.i b;
    public m(app.dogo.com.dogo_android.y.o.u u, app.dogo.com.dogo_android.y.o.u.i u$i2) {
        super();
        this.a = u;
        this.b = i2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        u.i.d(this.a, this.b, view);
    }
}
