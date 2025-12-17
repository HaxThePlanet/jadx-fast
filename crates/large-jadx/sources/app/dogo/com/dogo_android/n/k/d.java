package app.dogo.com.dogo_android.n.k;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.n.k.n a;
    public final app.dogo.com.dogo_android.n.k.n.a b;
    public d(app.dogo.com.dogo_android.n.k.n n, app.dogo.com.dogo_android.n.k.n.a n$a2) {
        super();
        this.a = n;
        this.b = a2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        n.a.d(this.a, this.b, view);
    }
}
