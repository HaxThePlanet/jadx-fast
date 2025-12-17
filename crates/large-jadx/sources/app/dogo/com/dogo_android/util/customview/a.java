package app.dogo.com.dogo_android.util.customview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    public final app.dogo.com.dogo_android.util.customview.ArcProgressBar a;
    public a(app.dogo.com.dogo_android.util.customview.ArcProgressBar arcProgressBar) {
        super();
        this.a = arcProgressBar;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ArcProgressBar.e(this.a, valueAnimator);
    }
}
