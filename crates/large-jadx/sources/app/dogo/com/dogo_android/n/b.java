package app.dogo.com.dogo_android.n;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.n.h a;
    public b(app.dogo.com.dogo_android.n.h h) {
        super();
        this.a = h;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        h.F1(this.a, view);
    }
}
