package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.util.k0.e;

/* loaded from: classes.dex */
public final class n implements View.OnClickListener {

    public final e a;
    public n(e e) {
        super();
        this.a = e;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.r(this.a, view);
    }
}
