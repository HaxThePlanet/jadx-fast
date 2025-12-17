package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.g0 a;
    public b(app.dogo.com.dogo_android.i.g0 g0) {
        super();
        this.a = g0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        g0.H1(this.a, view);
    }
}
