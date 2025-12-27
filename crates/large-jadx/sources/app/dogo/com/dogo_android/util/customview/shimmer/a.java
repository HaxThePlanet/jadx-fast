package app.dogo.com.dogo_android.util.customview.shimmer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    public final /* synthetic */ c a;
    public /* synthetic */ a(c cVar) {
        super();
        this.a = cVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ShimmerDrawable.d(this.a, valueAnimator);
    }
}
