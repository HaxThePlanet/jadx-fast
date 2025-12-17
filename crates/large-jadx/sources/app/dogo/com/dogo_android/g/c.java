package app.dogo.com.dogo_android.g;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.h.yi;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.g.d0 a;
    public final yi b;
    public c(app.dogo.com.dogo_android.g.d0 d0, yi yi2) {
        super();
        this.a = d0;
        this.b = yi2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n.e(this.a, this.b, view);
    }
}
