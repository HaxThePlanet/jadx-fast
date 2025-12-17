package app.dogo.com.dogo_android.u;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class d implements View.OnClickListener {

    public final app.dogo.com.dogo_android.u.l a;
    public d(app.dogo.com.dogo_android.u.l l) {
        super();
        this.a = l;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        l.d.d(this.a, view);
    }
}
