package app.dogo.com.dogo_android.e;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.e.k a;
    public final app.dogo.com.dogo_android.e.k.c b;
    public d(app.dogo.com.dogo_android.e.k k, app.dogo.com.dogo_android.e.k.c k$c2) {
        super();
        this.a = k;
        this.b = c2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        k.c.c(this.a, this.b, view);
    }
}
