package app.dogo.com.dogo_android.u.n;

import android.view.View;
import android.view.View.OnScrollChangeListener;

/* loaded from: classes.dex */
public final class d implements View.OnScrollChangeListener {

    public final app.dogo.com.dogo_android.u.n.l a;
    public d(app.dogo.com.dogo_android.u.n.l l) {
        super();
        this.a = l;
    }

    @Override // android.view.View$OnScrollChangeListener
    public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
        l.F1(this.a, view, i2, i3, i4, i5);
    }
}
