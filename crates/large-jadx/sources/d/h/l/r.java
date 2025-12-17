package d.h.l;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.Objects;

/* loaded from: classes.dex */
public final class r implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    private final View a;
    private ViewTreeObserver b;
    private final Runnable c;
    private r(View view, Runnable runnable2) {
        super();
        this.a = view;
        this.b = view.getViewTreeObserver();
        this.c = runnable2;
    }

    public static d.h.l.r a(View view, Runnable runnable2) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable2, "runnable == null");
        r rVar = new r(view, runnable2);
        view.getViewTreeObserver().addOnPreDrawListener(rVar);
        view.addOnAttachStateChangeListener(rVar);
        return rVar;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void b() {
        ViewTreeObserver viewTreeObserver;
        if (this.b.isAlive()) {
            this.b.removeOnPreDrawListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.c.run();
        return 1;
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void onViewAttachedToWindow(View view) {
        this.b = view.getViewTreeObserver();
    }

    @Override // android.view.ViewTreeObserver$OnPreDrawListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
