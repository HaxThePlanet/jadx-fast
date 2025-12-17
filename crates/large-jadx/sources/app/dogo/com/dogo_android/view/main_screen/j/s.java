package app.dogo.com.dogo_android.view.main_screen.j;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* loaded from: classes.dex */
public final class s implements View.OnKeyListener {

    public final app.dogo.com.dogo_android.view.main_screen.j.k0 a;
    public s(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        super();
        this.a = k0;
    }

    @Override // android.view.View$OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent3) {
        return k0.w2(this.a, view, i2, keyEvent3);
    }
}
