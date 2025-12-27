package d.h.l;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* compiled from: ViewPropertyAnimatorCompat.java */
/* loaded from: classes.dex */
public final class z {

    private WeakReference<View> a = new WeakReference<>();
    Runnable b = null;
    Runnable c = null;
    int d = -1;

    class a extends AnimatorListenerAdapter {

        final /* synthetic */ a0 a;
        final /* synthetic */ View b;
        a(a0 a0Var, View view) {
            this.a = a0Var;
            this.b = view;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationCancel(Animator animator) {
            this.a.a(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.b(this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.a.c(this.b);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        final /* synthetic */ c0 a;
        final /* synthetic */ View b;
        b(c0 c0Var, View view) {
            this.a = c0Var;
            this.b = view;
            super();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.b);
        }
    }

    static class c implements a0 {

        z a;
        boolean b;
        c() {
            super();
            this.a = zVar;
        }

        public void a(View view) {
            Object tag = null;
            a0 r0 = view.getTag(2113929216) instanceof a0 ? (a0)view.getTag(2113929216) : 0;
            if (tag != null) {
                tag.a(view);
            }
        }

        public void b(View view) {
            android.graphics.Paint paint = null;
            int i4 = -1;
            paint = null;
            if (this.a.d > i4) {
                view.setLayerType(this.a.d, paint);
                this.a.d = i4;
            }
            int i2 = 16;
            if (Build.VERSION.SDK_INT >= 16 || !this.b) {
                if (zVar2.c != null) {
                    this.a.c = paint;
                    zVar2.c.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof a0) {
                }
                if (paint != null) {
                    paint.b(view);
                }
                boolean z2 = true;
                this.b = z2;
            }
        }

        public void c(View view) {
            android.graphics.Paint paint = null;
            this.b = false;
            paint = null;
            if (this.a.d > -1) {
                int i = 2;
                view.setLayerType(i, paint);
            }
            if (zVar2.b != null) {
                this.a.b = paint;
                zVar2.b.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof a0) {
            }
            if (paint != null) {
                paint.c(view);
            }
        }
    }
    z(View view) {
        super();
        WeakReference weakReference = new WeakReference(view);
    }

    private void h(View view, a0 a0Var) {
        if (a0Var != null) {
            view.animate().setListener(new z.a(this, a0Var, view));
        } else {
            android.animation.Animator.AnimatorListener animatorListener = null;
            view.animate().setListener(animatorListener);
        }
    }

    public z a(float f) {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().cancel();
        }
    }

    public long c() {
        Object obj = this.a.get();
        if (obj != null) {
            return obj.animate().getDuration();
        }
        return 0;
    }

    public z d(float f) {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().rotation(f);
        }
        return this;
    }

    public z e(long j) {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().setDuration(j);
        }
        return this;
    }

    public z f(Interpolator interpolator) {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public z g(a0 a0Var) {
        Object obj = this.a.get();
        if (obj != null) {
            int i = 16;
            if (Build.VERSION.SDK_INT >= 16) {
                h(obj, a0Var);
            } else {
                int sDK_INT2 = 2113929216;
                obj.setTag(sDK_INT2, a0Var);
                h(obj, new z.c(this));
            }
        }
        return this;
    }

    public z i(long j) {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().setStartDelay(j);
        }
        return this;
    }

    public z j(c0 c0Var) {
        d.h.l.z.b bVar = null;
        Object obj = this.a.get();
        if (obj != null) {
            int i = 19;
            if (Build.VERSION.SDK_INT >= 19 && c0Var != null) {
                bVar = new z.b(this, c0Var, obj);
                obj.animate().setUpdateListener(bVar);
            }
        }
        return this;
    }

    public void k() {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().start();
        }
    }

    public z l(float f) {
        Object obj = this.a.get();
        if (obj != null) {
            obj.animate().translationY(f);
        }
        return this;
    }
}
