package app.dogo.com.dogo_android.u.m;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.m.u a;
    public i(app.dogo.com.dogo_android.u.m.u u) {
        super();
        this.a = u;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        u.G1(this.a, view);
    }
}
