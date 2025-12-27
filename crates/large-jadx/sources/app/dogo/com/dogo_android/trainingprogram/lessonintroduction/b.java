package app.dogo.com.dogo_android.y.v;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import d.h.l.d;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements View.OnTouchListener {

    public final /* synthetic */ d a;
    public /* synthetic */ b(d dVar) {
        super();
        this.a = dVar;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return LessonIntroductionPagerAdapter.m(this.a, view, motionEvent);
    }
}
