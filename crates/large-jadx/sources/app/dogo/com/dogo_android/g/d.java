package app.dogo.com.dogo_android.g;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import app.dogo.com.dogo_android.h.yi;

/* loaded from: classes.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    public final app.dogo.com.dogo_android.g.p a;
    public final yi b;
    public final boolean c;
    public d(app.dogo.com.dogo_android.g.p p, yi yi2, boolean z3) {
        super();
        this.a = p;
        this.b = yi2;
        this.c = z3;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        p.F1(this.a, this.b, this.c, valueAnimator);
    }
}
