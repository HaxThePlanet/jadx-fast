package app.dogo.com.dogo_android.util.customview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    public final /* synthetic */ ArcProgressBar a;
    public /* synthetic */ a(ArcProgressBar arcProgressBar) {
        super();
        this.a = arcProgressBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ArcProgressBar.animateProgressChange(this.a, valueAnimator);
    }
}
