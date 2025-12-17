package app.dogo.com.dogo_android.y.y;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class c implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.y.e a;
    public final app.dogo.com.dogo_android.y.y.e.f b;
    public c(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.f e$f2) {
        super();
        this.a = e;
        this.b = f2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e.f.d(this.a, this.b, view);
    }
}
