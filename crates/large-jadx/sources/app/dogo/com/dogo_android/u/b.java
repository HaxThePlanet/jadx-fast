package app.dogo.com.dogo_android.u;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.i a;
    public final app.dogo.com.dogo_android.u.i.a b;
    public b(app.dogo.com.dogo_android.u.i i, app.dogo.com.dogo_android.u.i.a i$a2) {
        super();
        this.a = i;
        this.b = a2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        i.a.d(this.a, this.b, view);
    }
}
