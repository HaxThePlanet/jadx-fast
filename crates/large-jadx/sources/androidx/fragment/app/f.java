package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.b;
import androidx.core.os.b.a;
import d.h.l.r;
import d.m.a;
import d.m.b;

/* loaded from: classes.dex */
class f {

    class b implements Animation.AnimationListener {

        final ViewGroup a;
        final androidx.fragment.app.Fragment b;
        final androidx.fragment.app.x.g c;
        final b v;
        b(ViewGroup viewGroup, androidx.fragment.app.Fragment fragment2, androidx.fragment.app.x.g x$g3, b b4) {
            this.a = viewGroup;
            this.b = fragment2;
            this.c = g3;
            this.v = b4;
            super();
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.b.a aVar = new f.b.a(this);
            this.a.post(aVar);
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class c extends AnimatorListenerAdapter {

        final ViewGroup a;
        final View b;
        final androidx.fragment.app.Fragment c;
        final androidx.fragment.app.x.g d;
        final b e;
        c(ViewGroup viewGroup, View view2, androidx.fragment.app.Fragment fragment3, androidx.fragment.app.x.g x$g4, b b5) {
            this.a = viewGroup;
            this.b = view2;
            this.c = fragment3;
            this.d = g4;
            this.e = b5;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            Object fragment;
            int i;
            Animator obj3;
            this.a.endViewTransition(this.b);
            this.c.setAnimator(0);
            if (this.c.getAnimator() != null && this.a.indexOfChild(this.b) < 0) {
                if (this.a.indexOfChild(this.b) < 0) {
                    this.d.a(this.c, this.e);
                }
            }
        }
    }

    static class d {

        public final Animation a;
        public final Animator b;
        d(Animator animator) {
            super();
            this.a = 0;
            this.b = animator;
            if (animator == null) {
            } else {
            }
            IllegalStateException obj2 = new IllegalStateException("Animator cannot be null");
            throw obj2;
        }

        d(Animation animation) {
            super();
            this.a = animation;
            this.b = 0;
            if (animation == null) {
            } else {
            }
            IllegalStateException obj2 = new IllegalStateException("Animation cannot be null");
            throw obj2;
        }
    }

    static class e extends AnimationSet implements Runnable {

        private final ViewGroup a;
        private final View b;
        private boolean c;
        private boolean v;
        private boolean w = true;
        e(Animation animation, ViewGroup viewGroup2, View view3) {
            super(0);
            int i2 = 1;
            this.a = viewGroup2;
            this.b = view3;
            addAnimation(animation);
            viewGroup2.post(this);
        }

        @Override // android.view.animation.AnimationSet
        public boolean getTransformation(long l, Transformation transformation2) {
            boolean obj3;
            final int i = 1;
            this.w = i;
            if (this.c) {
                return obj3 ^= i;
            }
            if (!super.getTransformation(l, transformation2)) {
                this.c = i;
                r.a(this.a, this);
            }
            return i;
        }

        @Override // android.view.animation.AnimationSet
        public boolean getTransformation(long l, Transformation transformation2, float f3) {
            boolean obj3;
            final int i = 1;
            this.w = i;
            if (this.c) {
                return obj3 ^= i;
            }
            if (!super.getTransformation(l, transformation2, f3)) {
                this.c = i;
                r.a(this.a, this);
            }
            return i;
        }

        @Override // android.view.animation.AnimationSet
        public void run() {
            boolean z;
            int i;
            View view;
            if (!this.c && this.w) {
                if (this.w) {
                    this.w = false;
                    this.a.post(this);
                } else {
                    this.a.endViewTransition(this.b);
                    this.v = true;
                }
            } else {
            }
        }
    }

    class a implements b.a {

        final androidx.fragment.app.Fragment a;
        a(androidx.fragment.app.Fragment fragment) {
            this.a = fragment;
            super();
        }

        @Override // androidx.core.os.b$a
        public void a() {
            View animatingAway;
            androidx.fragment.app.Fragment fragment;
            final int i = 0;
            if (this.a.getAnimatingAway() != null) {
                this.a.setAnimatingAway(i);
                this.a.getAnimatingAway().clearAnimation();
            }
            this.a.setAnimator(i);
        }
    }
    static void a(androidx.fragment.app.Fragment fragment, androidx.fragment.app.f.d f$d2, androidx.fragment.app.x.g x$g3) {
        Object eVar;
        Object obj;
        androidx.fragment.app.x.g gVar;
        androidx.fragment.app.f.c cVar;
        View obj7;
        Object obj8;
        final View mView = fragment.mView;
        final ViewGroup mContainer = fragment.mContainer;
        mContainer.startViewTransition(mView);
        b bVar = new b();
        f.a aVar = new f.a(fragment);
        bVar.c(aVar);
        g3.b(fragment, bVar);
        if (d2.a != null) {
            eVar = new f.e(d2.a, mContainer, mView);
            fragment.setAnimatingAway(fragment.mView);
            obj8 = new f.b(mContainer, fragment, g3, bVar);
            eVar.setAnimationListener(obj8);
            fragment.mView.startAnimation(eVar);
        } else {
            obj8 = d2.b;
            fragment.setAnimator(obj8);
            super(mContainer, mView, fragment, g3, bVar);
            obj8.addListener(cVar);
            obj8.setTarget(fragment.mView);
            obj8.start();
        }
    }

    private static int b(androidx.fragment.app.Fragment fragment, boolean z2, boolean z3) {
        if (z3 && z2) {
            if (z2) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        }
        if (z2) {
            return fragment.getEnterAnim();
        }
        return fragment.getExitAnim();
    }

    static androidx.fragment.app.f.d c(Context context, androidx.fragment.app.Fragment fragment2, boolean z3, boolean z4) {
        int i;
        Object mContainer;
        Object layoutTransition;
        int i2;
        Context obj5;
        Animator obj6;
        Object obj7;
        int obj8;
        int nextTransition = fragment2.getNextTransition();
        obj8 = f.b(fragment2, z3, z4);
        i = 0;
        fragment2.setAnimations(i, i, i, i);
        mContainer = fragment2.mContainer;
        final int i3 = 0;
        i2 = b.c;
        if (mContainer != null && mContainer.getTag(i2) != null) {
            i2 = b.c;
            if (mContainer.getTag(i2) != null) {
                fragment2.mContainer.setTag(i2, i3);
            }
        }
        layoutTransition = fragment2.mContainer;
        if (layoutTransition != null && layoutTransition.getLayoutTransition() != null) {
            if (layoutTransition.getLayoutTransition() != null) {
                return i3;
            }
        }
        Animation onCreateAnimation = fragment2.onCreateAnimation(nextTransition, z3, obj8);
        if (onCreateAnimation != null) {
            obj5 = new f.d(onCreateAnimation);
            return obj5;
        }
        obj6 = fragment2.onCreateAnimator(nextTransition, z3, obj8);
        if (obj6 != null) {
            obj5 = new f.d(obj6);
            return obj5;
        }
        if (obj8 == null && nextTransition != 0) {
            if (nextTransition != 0) {
                obj8 = f.d(nextTransition, z3);
            }
        }
        obj7 = AnimationUtils.loadAnimation(context, obj8);
        if (obj8 != null && "anim".equals(context.getResources().getResourceTypeName(obj8)) && obj7 != null) {
            if ("anim".equals(context.getResources().getResourceTypeName(obj8))) {
                obj7 = AnimationUtils.loadAnimation(context, obj8);
                if (obj7 != null) {
                    f.d dVar = new f.d(obj7);
                    return dVar;
                }
                i = 1;
            }
            obj7 = AnimatorInflater.loadAnimator(context, obj8);
            if (i == 0 && obj7 != null) {
                obj7 = AnimatorInflater.loadAnimator(context, obj8);
                if (obj7 != null) {
                    f.d dVar2 = new f.d(obj7);
                    return dVar2;
                }
            }
        }
        return i3;
    }

    private static int d(int i, boolean z2) {
        int i2;
        int obj1;
        if (i != 4097) {
            if (i != 4099) {
                obj1 = i != 8194 ? -1 : z2 ? a.a : a.b;
            } else {
                obj1 = z2 ? a.c : a.d;
            }
        } else {
            obj1 = z2 ? a.e : a.f;
        }
        return obj1;
    }
}
