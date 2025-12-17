package app.dogo.com.dogo_android.welcome_v2.w0;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* loaded from: classes.dex */
public final class f implements View.OnKeyListener {

    public final app.dogo.com.dogo_android.welcome_v2.w0.i a;
    public f(app.dogo.com.dogo_android.welcome_v2.w0.i i) {
        super();
        this.a = i;
    }

    @Override // android.view.View$OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent3) {
        return i.P1(this.a, view, i2, keyEvent3);
    }
}
