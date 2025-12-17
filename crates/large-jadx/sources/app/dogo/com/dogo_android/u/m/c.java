package app.dogo.com.dogo_android.u.m;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.m.m a;
    public c(app.dogo.com.dogo_android.u.m.m m) {
        super();
        this.a = m;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        m.F1(this.a, view);
    }
}
