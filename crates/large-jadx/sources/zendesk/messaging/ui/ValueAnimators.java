package zendesk.messaging.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

/* loaded from: classes3.dex */
class ValueAnimators {
    static ValueAnimator topMarginAnimator(View view, int i2, int i3, long l4) {
        int[] iArr = new int[2];
        ValueAnimator obj4 = ValueAnimator.ofInt(i2, i3);
        ValueAnimators.4 obj5 = new ValueAnimators.4((ViewGroup.MarginLayoutParams)view.getLayoutParams(), view);
        obj4.addUpdateListener(obj5);
        obj4.setDuration(l4);
        return obj4;
    }

    static ValueAnimator topPaddingAnimator(View view, int i2, int i3, long l4) {
        int[] iArr = new int[2];
        ValueAnimator obj3 = ValueAnimator.ofInt(i2, i3);
        ValueAnimators.1 obj4 = new ValueAnimators.1(view, obj3);
        obj3.addUpdateListener(obj4);
        obj3.setDuration(l4);
        return obj3;
    }
}
