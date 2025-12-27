package app.dogo.com.dogo_android.c;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements View.OnTouchListener {

    public final /* synthetic */ g a;
    public /* synthetic */ d(g gVar) {
        super();
        this.a = gVar;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return app.dogo.com.dogo_android.camerax.g.f.e(this.a, view, motionEvent);
    }
}
