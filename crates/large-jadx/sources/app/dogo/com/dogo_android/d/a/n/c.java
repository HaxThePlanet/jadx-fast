package app.dogo.com.dogo_android.d.a.n;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.d.a.n.g a;
    public final int b;
    public c(app.dogo.com.dogo_android.d.a.n.g g, int i2) {
        super();
        this.a = g;
        this.b = i2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        g.y(this.a, this.b, view);
    }
}
