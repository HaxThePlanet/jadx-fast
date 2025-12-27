package f.c.a.e.m;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;

/* compiled from: AnimatorSetCompat.java */
/* loaded from: classes2.dex */
public class b {
    public static void a(AnimatorSet set, List<Animator> list) {
        int max = 0;
        int i;
        i = 0;
        max = 0;
        while (i < list.size()) {
            Object item = list.get(i);
            l = item.getStartDelay() + item.getDuration();
            max = Math.max(max, l);
            i = i + 1;
        }
        ValueAnimator _int = ValueAnimator.ofInt(new int[] { 0, 0 });
        _int.setDuration(max);
        list.add(i, _int);
        set.playTogether(list);
    }
}
