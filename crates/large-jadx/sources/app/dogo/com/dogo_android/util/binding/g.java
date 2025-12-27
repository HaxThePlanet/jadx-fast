package app.dogo.com.dogo_android.util.f0;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class g implements View.OnTouchListener {

    public static final /* synthetic */ g a = new g();

    private /* synthetic */ g() {
        super();
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return BindingAdapters.S(view, motionEvent);
    }
}
