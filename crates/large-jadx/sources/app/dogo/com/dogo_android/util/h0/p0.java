package app.dogo.com.dogo_android.util.h0;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import d.h.l.d;

/* loaded from: classes.dex */
public final class p0 implements View.OnTouchListener {

    public final d a;
    public p0(d d) {
        super();
        this.a = d;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return j1.V(this.a, view, motionEvent2);
    }
}
