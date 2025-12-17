package app.dogo.com.dogo_android.u.n;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.n.j a;
    public final app.dogo.com.dogo_android.u.n.j.b b;
    public a(app.dogo.com.dogo_android.u.n.j j, app.dogo.com.dogo_android.u.n.j.b j$b2) {
        super();
        this.a = j;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j.b.c(this.a, this.b, view);
    }
}
