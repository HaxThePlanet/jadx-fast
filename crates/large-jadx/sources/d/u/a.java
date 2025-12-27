package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import java.util.ArrayList;

/* compiled from: AnimatorUtils.java */
/* loaded from: classes.dex */
class a {

    interface a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }
    static void a(Animator animator, AnimatorListenerAdapter list) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(list);
        }
    }

    static void b(Animator animator) {
        int i = 0;
        Object item;
        boolean z;
        i = 19;
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
        } else {
            ArrayList listeners = animator.getListeners();
            if (listeners != null) {
                i = 0;
                while (i < listeners.size()) {
                    item = listeners.get(i);
                    z = item instanceof a.a;
                    i = i + 1;
                }
            }
        }
    }

    static void c(Animator animator) {
        int i = 0;
        Object item;
        boolean z;
        i = 19;
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
        } else {
            ArrayList listeners = animator.getListeners();
            if (listeners != null) {
                i = 0;
                while (i < listeners.size()) {
                    item = listeners.get(i);
                    z = item instanceof a.a;
                    i = i + 1;
                }
            }
        }
    }
}
