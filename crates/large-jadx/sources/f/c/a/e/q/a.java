package f.c.a.e.q;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.ViewAnimationUtils;

/* loaded from: classes2.dex */
public final class a {

    static class a extends AnimatorListenerAdapter {

        final f.c.a.e.q.d a;
        a(f.c.a.e.q.d d) {
            this.a = d;
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
    public static Animator a(f.c.a.e.q.d d, float f2, float f3, float f4) {
        final int i = 1;
        f.c.a.e.q.d.e[] arr = new d.e[i];
        d.e eVar = new d.e(f2, f3, f4);
        final int i3 = 0;
        arr[i3] = eVar;
        ObjectAnimator object = ObjectAnimator.ofObject(d, d.c.a, d.b.b, arr);
        if (Build.VERSION.SDK_INT >= 21) {
            f.c.a.e.q.d.e revealInfo = d.getRevealInfo();
            if (revealInfo == null) {
            } else {
                AnimatorSet obj7 = new AnimatorSet();
                Animator[] obj8 = new Animator[2];
                obj8[i3] = object;
                obj8[i] = ViewAnimationUtils.createCircularReveal((View)d, (int)f2, (int)f3, revealInfo.c, f4);
                obj7.playTogether(obj8);
                return obj7;
            }
            IllegalStateException obj6 = new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
            throw obj6;
        }
        return object;
    }

    public static Animator.AnimatorListener b(f.c.a.e.q.d d) {
        a.a aVar = new a.a(d);
        return aVar;
    }
}
