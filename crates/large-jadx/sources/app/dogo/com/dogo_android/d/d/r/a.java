package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.d.d.q;
import app.dogo.com.dogo_android.h.e2;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.d.d.r.e.a a;
    public final q b;
    public final e2 c;
    public a(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2, e2 e23) {
        super();
        this.a = a;
        this.b = q2;
        this.c = e23;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e.a.e(this.a, this.b, this.c, view);
    }
}
