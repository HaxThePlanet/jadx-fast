package f.c.a.e.q;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.ViewAnimationUtils;

/* compiled from: CircularRevealCompat.java */
/* loaded from: classes2.dex */
public final class a {

    static class a extends AnimatorListenerAdapter {

        final /* synthetic */ d a;
        a(d dVar) {
            this.a = dVar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.a.a();
        }
    }
    public static Animator a(d dVar, float f, float f2, float f3) {
        final int i = 1;
        f.c.a.e.q.d.e[] arr = new d.e[i];
        final int i3 = 0;
        arr[i3] = new d.e(f, f2, f3);
        ObjectAnimator object = ObjectAnimator.ofObject(dVar, d.c.a, d.b.b, arr);
        if (Build.VERSION.SDK_INT >= 21 && revealInfo != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] arr2 = new Animator[2];
            animatorSet.playTogether(new Animator[] { object, ViewAnimationUtils.createCircularReveal(dVar, (int)f, (int)f2, revealInfo.c, f3) });
            return animatorSet;
        }
        return object;
    }

    public static Animator.AnimatorListener b(d dVar) {
        return new a.a(dVar);
    }
}
