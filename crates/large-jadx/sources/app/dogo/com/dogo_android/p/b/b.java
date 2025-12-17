package app.dogo.com.dogo_android.p.b;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.p.b.c a;
    public b(app.dogo.com.dogo_android.p.b.c c) {
        super();
        this.a = c;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        c.Z1(this.a, view);
    }
}
