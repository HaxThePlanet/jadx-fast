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

/* loaded from: classes.dex */
public final class z {

    private WeakReference<View> a;
    Runnable b = null;
    Runnable c = null;
    int d = -1;

    class a extends AnimatorListenerAdapter {

        final d.h.l.a0 a;
        final View b;
        a(d.h.l.z z, d.h.l.a0 a02, View view3) {
            this.a = a02;
            this.b = view3;
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

        final d.h.l.c0 a;
        final View b;
        b(d.h.l.z z, d.h.l.c0 c02, View view3) {
            this.a = c02;
            this.b = view3;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.a(this.b);
        }
    }

    static class c implements d.h.l.a0 {

        d.h.l.z a;
        boolean b;
        c(d.h.l.z z) {
            super();
            this.a = z;
        }

        @Override // d.h.l.a0
        public void a(View view) {
            Object tag;
            if (tag instanceof a0) {
            } else {
                tag = 0;
            }
            if (tag != null) {
                tag.a(view);
            }
        }

        @Override // d.h.l.a0
        public void b(View view) {
            int i;
            boolean sDK_INT;
            int i3;
            int i2;
            View obj4;
            i = zVar.d;
            int i5 = -1;
            i2 = 0;
            if (i > i5) {
                view.setLayerType(i, i2);
                i.d = i5;
            }
            if (Build.VERSION.SDK_INT < 16) {
                d.h.l.z zVar2 = this.a;
                Runnable runnable = zVar2.c;
                if (!this.b && runnable != null) {
                    zVar2 = this.a;
                    runnable = zVar2.c;
                    if (runnable != null) {
                        zVar2.c = i2;
                        runnable.run();
                    }
                    sDK_INT = view.getTag(2113929216);
                    if (sDK_INT instanceof a0) {
                        i2 = sDK_INT;
                    }
                    if (i2 != 0) {
                        i2.b(view);
                    }
                    this.b = true;
                }
            } else {
            }
        }

        @Override // d.h.l.a0
        public void c(View view) {
            int i;
            int i2;
            this.b = false;
            i2 = 0;
            if (zVar.d > -1) {
                view.setLayerType(2, i2);
            }
            d.h.l.z zVar2 = this.a;
            Runnable runnable = zVar2.b;
            if (runnable != null) {
                zVar2.b = i2;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            if (tag instanceof a0) {
                i2 = tag;
            }
            if (i2 != 0) {
                i2.c(view);
            }
        }
    }
    z(View view) {
        super();
        int i = 0;
        int i2 = -1;
        WeakReference weakReference = new WeakReference(view);
        this.a = weakReference;
    }

    private void h(View view, d.h.l.a0 a02) {
        ViewPropertyAnimator animate;
        d.h.l.z.a aVar;
        Object obj3;
        d.h.l.a0 obj4;
        if (a02 != null) {
            aVar = new z.a(this, a02, view);
            view.animate().setListener(aVar);
        } else {
            view.animate().setListener(0);
        }
    }

    public d.h.l.z a(float f) {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().alpha(f);
        }
        return this;
    }

    public void b() {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().cancel();
        }
    }

    public long c() {
        Object obj = this.a.get();
        if ((View)obj != null) {
            return (View)obj.animate().getDuration();
        }
        return 0;
    }

    public d.h.l.z d(float f) {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().rotation(f);
        }
        return this;
    }

    public d.h.l.z e(long l) {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().setDuration(l);
        }
        return this;
    }

    public d.h.l.z f(Interpolator interpolator) {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().setInterpolator(interpolator);
        }
        return this;
    }

    public d.h.l.z g(d.h.l.a0 a0) {
        int sDK_INT;
        int i;
        d.h.l.a0 obj4;
        Object obj = this.a.get();
        if ((View)obj != null) {
            if (Build.VERSION.SDK_INT >= 16) {
                h((View)obj, a0);
            } else {
                obj.setTag(2113929216, a0);
                obj4 = new z.c(this);
                h(obj, obj4);
            }
        }
        return this;
    }

    public d.h.l.z i(long l) {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().setStartDelay(l);
        }
        return this;
    }

    public d.h.l.z j(d.h.l.c0 c0) {
        int sDK_INT;
        int i;
        Object obj4;
        Object obj = this.a.get();
        sDK_INT = 0;
        if ((View)obj != null && Build.VERSION.SDK_INT >= 19 && c0 != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                sDK_INT = 0;
                if (c0 != null) {
                    sDK_INT = new z.b(this, c0, (View)obj);
                }
                obj.animate().setUpdateListener(sDK_INT);
            }
        }
        return this;
    }

    public void k() {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().start();
        }
    }

    public d.h.l.z l(float f) {
        Object animate;
        animate = this.a.get();
        if ((View)animate != null) {
            (View)animate.animate().translationY(f);
        }
        return this;
    }
}
