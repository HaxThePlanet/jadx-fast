package f.c.a.e.m;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

/* loaded from: classes2.dex */
public class b {
    public static void a(AnimatorSet animatorSet, List<Animator> list2) {
        int i2;
        int i;
        Object obj;
        int i3;
        long duration;
        final int i5 = 0;
        i2 = 0;
        i = i5;
        while (i < list2.size()) {
            obj = list2.get(i);
            i2 = Math.max(i2, obj3);
            i++;
        }
        int[] iArr = new int[2];
        iArr = new int[]{0, 0};
        ValueAnimator int = ValueAnimator.ofInt(iArr);
        int.setDuration(i2);
        list2.add(i5, int);
        animatorSet.playTogether(list2);
    }
}
