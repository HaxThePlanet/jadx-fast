package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class f implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.g0 a;
    public f(app.dogo.com.dogo_android.i.g0 g0) {
        super();
        this.a = g0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        g0.L1(this.a, view);
    }
}
