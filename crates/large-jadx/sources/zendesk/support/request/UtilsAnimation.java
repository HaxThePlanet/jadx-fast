package zendesk.support.request;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;

/* loaded from: classes3.dex */
class UtilsAnimation {
    static ValueAnimator bottomPaddingAnimator(View view, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        ValueAnimator obj3 = ValueAnimator.ofInt(i2, i3);
        UtilsAnimation.2 obj4 = new UtilsAnimation.2(view, obj3);
        obj3.addUpdateListener(obj4);
        obj3.setDuration((long)i4);
        return obj3;
    }

    static ValueAnimator minHeightAnimator(View view, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        ValueAnimator obj3 = ValueAnimator.ofInt(i2, i3);
        UtilsAnimation.4 obj4 = new UtilsAnimation.4(view);
        obj3.addUpdateListener(obj4);
        obj3.setDuration((long)i4);
        return obj3;
    }

    static ValueAnimator sideMarginsAnimator(View view, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        ValueAnimator obj4 = ValueAnimator.ofInt(i2, i3);
        UtilsAnimation.3 obj5 = new UtilsAnimation.3((FrameLayout.LayoutParams)view.getLayoutParams(), view);
        obj4.addUpdateListener(obj5);
        obj4.setDuration((long)i4);
        return obj4;
    }

    static ValueAnimator topPaddingAnimator(View view, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        ValueAnimator obj3 = ValueAnimator.ofInt(i2, i3);
        UtilsAnimation.1 obj4 = new UtilsAnimation.1(view, obj3);
        obj3.addUpdateListener(obj4);
        obj3.setDuration((long)i4);
        return obj3;
    }
}
