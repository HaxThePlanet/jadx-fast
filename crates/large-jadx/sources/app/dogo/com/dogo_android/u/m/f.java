package app.dogo.com.dogo_android.u.m;

import android.view.View;
import android.view.View.OnScrollChangeListener;

/* loaded from: classes.dex */
public final class f implements View.OnScrollChangeListener {

    public final app.dogo.com.dogo_android.u.m.m a;
    public f(app.dogo.com.dogo_android.u.m.m m) {
        super();
        this.a = m;
    }

    @Override // android.view.View$OnScrollChangeListener
    public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
        m.I1(this.a, view, i2, i3, i4, i5);
    }
}
