package app.dogo.com.dogo_android.g;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class l implements View.OnClickListener {

    public final app.dogo.com.dogo_android.g.f0 a;
    public l(app.dogo.com.dogo_android.g.f0 f0) {
        super();
        this.a = f0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        f0.c.d(this.a, view);
    }
}
