package app.dogo.com.dogo_android.n.m.u;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import d.h.l.d;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnTouchListener {

    public final /* synthetic */ d a;
    public /* synthetic */ a(d dVar) {
        super();
        this.a = dVar;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return TrickDetailsAdapter.l(this.a, view, motionEvent);
    }
}
