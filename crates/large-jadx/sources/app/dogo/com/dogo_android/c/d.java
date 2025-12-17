package app.dogo.com.dogo_android.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* loaded from: classes.dex */
public final class d implements View.OnTouchListener {

    public final app.dogo.com.dogo_android.c.g a;
    public d(app.dogo.com.dogo_android.c.g g) {
        super();
        this.a = g;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return g.f.f(this.a, view, motionEvent2);
    }
}
