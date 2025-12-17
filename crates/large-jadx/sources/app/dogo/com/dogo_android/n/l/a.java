package app.dogo.com.dogo_android.n.l;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.n.l.b.b a;
    public final app.dogo.com.dogo_android.n.l.b b;
    public a(app.dogo.com.dogo_android.n.l.b.b b$b, app.dogo.com.dogo_android.n.l.b b2) {
        super();
        this.a = b;
        this.b = b2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        b.b.c(this.a, this.b, view);
    }
}
