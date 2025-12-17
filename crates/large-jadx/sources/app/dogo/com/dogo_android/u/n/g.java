package app.dogo.com.dogo_android.u.n;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.n.o a;
    public g(app.dogo.com.dogo_android.u.n.o o) {
        super();
        this.a = o;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.c.c(this.a, view);
    }
}
