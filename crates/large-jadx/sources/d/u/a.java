package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import java.util.ArrayList;

/* loaded from: classes.dex */
class a {

    interface a {
        public abstract void onAnimationPause(Animator animator);

        public abstract void onAnimationResume(Animator animator);
    }
    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter2) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter2);
        }
    }

    static void b(Animator animator) {
        ArrayList sDK_INT;
        int i;
        int size;
        Object obj;
        boolean z;
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
        } else {
            sDK_INT = animator.getListeners();
            if (sDK_INT != null) {
                i = 0;
                while (i < sDK_INT.size()) {
                    obj = sDK_INT.get(i);
                    if (obj instanceof a.a) {
                    }
                    i++;
                    (a.a)(Animator.AnimatorListener)obj.onAnimationPause(animator);
                }
            }
        }
    }

    static void c(Animator animator) {
        ArrayList sDK_INT;
        int i;
        int size;
        Object obj;
        boolean z;
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
        } else {
            sDK_INT = animator.getListeners();
            if (sDK_INT != null) {
                i = 0;
                while (i < sDK_INT.size()) {
                    obj = sDK_INT.get(i);
                    if (obj instanceof a.a) {
                    }
                    i++;
                    (a.a)(Animator.AnimatorListener)obj.onAnimationResume(animator);
                }
            }
        }
    }
}
