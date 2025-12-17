package app.dogo.com.dogo_android.util.customview.shimmer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    public final app.dogo.com.dogo_android.util.customview.shimmer.c a;
    public a(app.dogo.com.dogo_android.util.customview.shimmer.c c) {
        super();
        this.a = c;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        c.c(this.a, valueAnimator);
    }
}
