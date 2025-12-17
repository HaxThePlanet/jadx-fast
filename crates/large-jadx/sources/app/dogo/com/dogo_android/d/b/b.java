package app.dogo.com.dogo_android.d.b;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* loaded from: classes.dex */
public final class b implements View.OnKeyListener {

    public final app.dogo.com.dogo_android.d.b.v a;
    public b(app.dogo.com.dogo_android.d.b.v v) {
        super();
        this.a = v;
    }

    @Override // android.view.View$OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent3) {
        return v.k2(this.a, view, i2, keyEvent3);
    }
}
