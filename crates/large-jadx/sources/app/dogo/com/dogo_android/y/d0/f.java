package app.dogo.com.dogo_android.y.d0;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.d0.n a;
    public final app.dogo.com.dogo_android.y.d0.n.c b;
    public f(app.dogo.com.dogo_android.y.d0.n n, app.dogo.com.dogo_android.y.d0.n.c n$c2) {
        super();
        this.a = n;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n.c.d(this.a, this.b, view);
    }
}
