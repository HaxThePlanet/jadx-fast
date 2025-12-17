package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import d.h.l.u;
import java.util.Map;

/* loaded from: classes.dex */
public class d extends d.u.m0 {

    private static class b extends AnimatorListenerAdapter {

        private final View a;
        private boolean b = false;
        b(View view) {
            super();
            final int i = 0;
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i;
            int i2;
            boolean obj3;
            f0.g(this.a, 1065353216);
            if (this.b) {
                this.a.setLayerType(0, 0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            int i2;
            int i;
            boolean obj3;
            if (u.N(this.a) && this.a.getLayerType() == 0) {
                if (this.a.getLayerType() == 0) {
                    this.b = true;
                    this.a.setLayerType(2, 0);
                }
            }
        }
    }

    class a extends d.u.p {

        final View a;
        a(d.u.d d, View view2) {
            this.a = view2;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(d.u.o o) {
            f0.g(this.a, 1065353216);
            f0.a(this.a);
            o.S(this);
        }
    }
    public d(int i) {
        super();
        p0(i);
    }

    private Animator q0(View view, float f2, float f3) {
        if (Float.compare(f2, f3) == 0) {
            return null;
        }
        f0.g(view, f2);
        float[] fArr = new float[1];
        ObjectAnimator obj4 = ObjectAnimator.ofFloat(view, f0.b, f3);
        d.b obj5 = new d.b(view);
        obj4.addListener(obj5);
        obj5 = new d.a(this, view);
        a(obj5);
        return obj4;
    }

    private static float r0(d.u.u u, float f2) {
        String str;
        Object obj1;
        float obj2;
        obj1 = u.a.get("android:fade:transitionAlpha");
        if (u != null && (Float)obj1 != null) {
            obj1 = u.a.get("android:fade:transitionAlpha");
            if ((Float)(Float)obj1 != null) {
                obj2 = (Float)(Float)obj1.floatValue();
            }
        }
        return obj2;
    }

    @Override // d.u.m0
    public void j(d.u.u u) {
        super.j(u);
        u.a.put("android:fade:transitionAlpha", Float.valueOf(f0.c(u.b)));
    }

    @Override // d.u.m0
    public Animator k0(ViewGroup viewGroup, View view2, d.u.u u3, d.u.u u4) {
        int obj2;
        final float obj4 = d.r0(u3, 0);
        final int obj5 = 1065353216;
        if (Float.compare(obj4, obj5) == 0) {
        } else {
            obj2 = obj4;
        }
        return q0(view2, obj2, obj5);
    }

    @Override // d.u.m0
    public Animator n0(ViewGroup viewGroup, View view2, d.u.u u3, d.u.u u4) {
        f0.e(view2);
        return q0(view2, d.r0(u3, 1065353216), 0);
    }
}
