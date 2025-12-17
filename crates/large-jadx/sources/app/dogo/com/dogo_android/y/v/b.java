package app.dogo.com.dogo_android.y.v;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import d.h.l.d;

/* loaded from: classes.dex */
public final class b implements View.OnTouchListener {

    public final d a;
    public b(d d) {
        super();
        this.a = d;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return d.h(this.a, view, motionEvent2);
    }
}
