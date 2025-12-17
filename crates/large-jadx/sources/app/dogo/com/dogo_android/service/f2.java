package app.dogo.com.dogo_android.service;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* loaded from: classes.dex */
public final class f2 implements ValueAnimator.AnimatorUpdateListener {

    public final View a;
    public final ValueAnimator.AnimatorUpdateListener b;
    public f2(View view, ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener2) {
        super();
        this.a = view;
        this.b = animatorUpdateListener2;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        v2.p(this.a, this.b, valueAnimator);
    }
}
