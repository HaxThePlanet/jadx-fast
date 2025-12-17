package app.dogo.com.dogo_android.y;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* loaded from: classes.dex */
public final class f implements View.OnTouchListener {

    public static final app.dogo.com.dogo_android.y.f a;
    static {
        f fVar = new f();
        f.a = fVar;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent2) {
        return l.q(view, motionEvent2);
    }
}
