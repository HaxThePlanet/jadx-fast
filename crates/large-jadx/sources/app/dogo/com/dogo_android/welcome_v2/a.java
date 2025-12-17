package app.dogo.com.dogo_android.welcome_v2;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    public final app.dogo.com.dogo_android.welcome_v2.AnimatedTextView a;
    public a(app.dogo.com.dogo_android.welcome_v2.AnimatedTextView animatedTextView) {
        super();
        this.a = animatedTextView;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AnimatedTextView.j(this.a, valueAnimator);
    }
}
