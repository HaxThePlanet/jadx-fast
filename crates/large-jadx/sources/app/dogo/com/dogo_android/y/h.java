package app.dogo.com.dogo_android.y;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* loaded from: classes.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    public final View a;
    public h(View view) {
        super();
        this.a = view;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        l.r(this.a, valueAnimator);
    }
}
