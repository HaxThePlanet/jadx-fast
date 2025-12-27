package app.dogo.com.dogo_android.service;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class f2 implements ValueAnimator.AnimatorUpdateListener {

    public final /* synthetic */ View a;
    public final /* synthetic */ ValueAnimator.AnimatorUpdateListener b;
    public /* synthetic */ f2(View view, ValueAnimator.AnimatorUpdateListener list) {
        super();
        this.a = view;
        this.b = list;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Utilities.x(this.a, this.b, valueAnimator);
    }
}
