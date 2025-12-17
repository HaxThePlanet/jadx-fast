package app.dogo.com.dogo_android.n.m.u;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import d.h.l.d;

/* loaded from: classes.dex */
public final class h implements View.OnTouchListener {

    public final d a;
    public h(d d) {
        super();
        this.a = d;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return o.n(this.a, view, motionEvent2);
    }
}
