package app.dogo.com.dogo_android.g;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final app.dogo.com.dogo_android.g.u a;
    public k(app.dogo.com.dogo_android.g.u u) {
        super();
        this.a = u;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        u.a.c(this.a, view);
    }
}
