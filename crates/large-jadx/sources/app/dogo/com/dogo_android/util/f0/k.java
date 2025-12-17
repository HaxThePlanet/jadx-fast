package app.dogo.com.dogo_android.util.f0;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* loaded from: classes.dex */
public final class k implements View.OnTouchListener {

    public static final app.dogo.com.dogo_android.util.f0.k a;
    static {
        k kVar = new k();
        k.a = kVar;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return n.u(view, motionEvent2);
    }
}
