package app.dogo.com.dogo_android.util.f0;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* loaded from: classes.dex */
public final class g implements View.OnTouchListener {

    public static final app.dogo.com.dogo_android.util.f0.g a;
    static {
        g gVar = new g();
        g.a = gVar;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return n.q(view, motionEvent2);
    }
}
