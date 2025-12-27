package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import d.h.l.u;
import java.util.Map;

/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class d extends m0 {

    private static class b extends AnimatorListenerAdapter {

        private final View a;
        private boolean b = false;
        b(View view) {
            super();
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            float f = 1f;
            f0.g(this.a, f);
            if (this.b) {
                android.graphics.Paint paint = null;
                this.a.setLayerType(0, paint);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            if (u.N(this.a)) {
                if (this.a.getLayerType() == 0) {
                    this.b = true;
                    int i = 2;
                    android.graphics.Paint paint = null;
                    this.a.setLayerType(i, paint);
                }
            }
        }
    }

    class a extends p {

        final /* synthetic */ View a;
        a(View view) {
            this.a = view;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(o oVar) {
            f0.g(this.a, 1f);
            f0.a(this.a);
            oVar.S(this);
        }
    }
    public d(int i) {
        super();
        p0(i);
    }

    private Animator q0(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        f0.g(view, f);
        float[] fArr = new float[1];
        ObjectAnimator _float = ObjectAnimator.ofFloat(view, f0.b, new float[] { f2 });
        _float.addListener(new d.b(view));
        a(new d.a(this, view));
        return _float;
    }

    private static float r0(u uVar, float f) {
        float value2;
        if (uVar != null) {
            str = "android:fade:transitionAlpha";
            Object value = uVar.a.get(str);
            if (value != null) {
                value2 = value.floatValue();
            }
        }
        return value2;
    }

    @Override // d.u.m0
    public void j(u uVar) {
        super.j(uVar);
        uVar.a.put("android:fade:transitionAlpha", Float.valueOf(f0.c(uVar.b)));
    }

    @Override // d.u.m0
    public Animator k0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        float uVar32 = 0;
        uVar32 = 0.0f;
        uVar32 = d.r0(uVar, uVar32);
        final float f = 1f;
        if (uVar32 != f) {
        }
        return q0(view, uVar32, f);
    }

    @Override // d.u.m0
    public Animator n0(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        f0.e(view);
        return q0(view, d.r0(uVar, 1f), 0.0f);
    }
}
