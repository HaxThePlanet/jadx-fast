package app.dogo.com.dogo_android.n.m.u;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import d.h.l.d;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements View.OnTouchListener {

    public final /* synthetic */ d a;
    public /* synthetic */ h(d dVar) {
        super();
        this.a = dVar;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return VideoTrickDetailsAdapter.x(this.a, view, motionEvent);
    }
}
