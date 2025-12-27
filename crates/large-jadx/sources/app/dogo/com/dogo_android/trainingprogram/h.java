package app.dogo.com.dogo_android.y;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    public final /* synthetic */ View a;
    public /* synthetic */ h(View view) {
        super();
        this.a = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ProgramBindingAdapters.f(this.a, valueAnimator);
    }
}
