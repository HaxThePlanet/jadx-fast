package app.dogo.com.dogo_android.util.f0;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class k implements View.OnTouchListener {

    public static final /* synthetic */ k a = new k();

    private /* synthetic */ k() {
        super();
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return BindingAdapters.m(view, motionEvent);
    }
}
