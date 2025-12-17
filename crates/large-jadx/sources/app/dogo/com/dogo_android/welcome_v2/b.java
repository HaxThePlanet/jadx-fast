package app.dogo.com.dogo_android.welcome_v2;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.Button;

/* loaded from: classes.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    public final Button a;
    public b(Button button) {
        super();
        this.a = button;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        c0.r(this.a, valueAnimator);
    }
}
