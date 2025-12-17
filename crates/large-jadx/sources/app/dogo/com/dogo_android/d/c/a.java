package app.dogo.com.dogo_android.d.c;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.e0.b0;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.d.c.g a;
    public final b0 b;
    public a(app.dogo.com.dogo_android.d.c.g g, b0 b02) {
        super();
        this.a = g;
        this.b = b02;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        g.g2(this.a, this.b, view);
    }
}
