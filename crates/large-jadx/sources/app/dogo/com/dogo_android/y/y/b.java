package app.dogo.com.dogo_android.y.y;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final app.dogo.com.dogo_android.y.y.e a;
    public final app.dogo.com.dogo_android.y.y.e.e b;
    public b(app.dogo.com.dogo_android.y.y.e e, app.dogo.com.dogo_android.y.y.e.e e$e2) {
        super();
        this.a = e;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        e.e.d(this.a, this.b, view);
    }
}
