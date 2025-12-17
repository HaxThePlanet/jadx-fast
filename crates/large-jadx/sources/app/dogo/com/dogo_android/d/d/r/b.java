package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.e2;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.d.d.r.e.a a;
    public final e2 b;
    public b(app.dogo.com.dogo_android.d.d.r.e.a e$a, e2 e22) {
        super();
        this.a = a;
        this.b = e22;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e.a.f(this.a, this.b, view);
    }
}
