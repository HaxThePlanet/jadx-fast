package app.dogo.com.dogo_android.y.d0;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class g implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.d0.n a;
    public final app.dogo.com.dogo_android.y.d0.n.d b;
    public g(app.dogo.com.dogo_android.y.d0.n n, app.dogo.com.dogo_android.y.d0.n.d n$d2) {
        super();
        this.a = n;
        this.b = d2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n.d.d(this.a, this.b, view);
    }
}
