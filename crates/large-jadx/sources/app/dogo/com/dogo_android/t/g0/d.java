package app.dogo.com.dogo_android.t.g0;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.t.g0.j a;
    public final app.dogo.com.dogo_android.t.g0.j.c b;
    public d(app.dogo.com.dogo_android.t.g0.j j, app.dogo.com.dogo_android.t.g0.j.c j$c2) {
        super();
        this.a = j;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j.c.d(this.a, this.b, view);
    }
}
