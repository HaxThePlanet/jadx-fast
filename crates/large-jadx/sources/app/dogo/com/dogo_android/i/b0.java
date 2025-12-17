package app.dogo.com.dogo_android.i;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class b0 implements View.OnClickListener {

    public final app.dogo.com.dogo_android.i.n0 a;
    public final app.dogo.com.dogo_android.i.n0.h b;
    public b0(app.dogo.com.dogo_android.i.n0 n0, app.dogo.com.dogo_android.i.n0.h n0$h2) {
        super();
        this.a = n0;
        this.b = h2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n0.h.d(this.a, this.b, view);
    }
}
