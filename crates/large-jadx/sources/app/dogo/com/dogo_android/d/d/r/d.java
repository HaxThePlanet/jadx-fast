package app.dogo.com.dogo_android.d.d.r;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.d.d.q;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.d.d.r.e.a a;
    public final q b;
    public d(app.dogo.com.dogo_android.d.d.r.e.a e$a, q q2) {
        super();
        this.a = a;
        this.b = q2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e.a.h(this.a, this.b, view);
    }
}
