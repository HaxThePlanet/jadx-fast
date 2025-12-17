package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.p.v;

/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final v a;
    public f(v v) {
        super();
        this.a = v;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.j(this.a, view);
    }
}
