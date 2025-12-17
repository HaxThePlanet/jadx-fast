package h.a.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import h.a.b.f.b;
import h.a.b.i.c;
import h.a.c.b;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a extends h.a.b.e {

    private static long u = 300L;
    private Interpolator i;
    private h.a.b.a.b j;
    private boolean k = true;
    private final SparseArray<Animator> l;
    private int m = -1;
    private int n = -1;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private long r = 0;
    private long s = 100;
    private long t = 100;

    static class a {
    }

    private static enum c {

        ALPHA,
        SLIDE_IN_LEFT,
        SLIDE_IN_RIGHT,
        SLIDE_IN_BOTTOM,
        SLIDE_IN_TOP,
        SCALE;
    }

    private class d implements Animator.AnimatorListener {

        int a;
        final h.a.b.a b;
        d(h.a.b.a a, int i2) {
            this.b = a;
            super();
            this.a = i2;
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.w(this.b).remove(this.a);
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator$AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    private class b extends RecyclerView.j {

        private boolean a;
        private Handler b;
        private b(h.a.b.a a) {
            super();
            a.b.a aVar = new a.b.a(this);
            Handler obj3 = new Handler(Looper.getMainLooper(), aVar);
            this.b = obj3;
        }

        b(h.a.b.a a, h.a.b.a.a a$a2) {
            super(a);
        }

        static boolean a(h.a.b.a.b a$b, boolean z2) {
            b.a = z2;
            return z2;
        }

        private void d() {
            this.a = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void b() {
            boolean z;
            Message obtain;
            int i;
            if (this.a) {
                this.b.removeCallbacksAndMessages(0);
                z = this.b;
                z.sendMessageDelayed(Message.obtain(z), 200);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public boolean c() {
            return this.a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onChanged() {
            d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeChanged(int i, int i2) {
            d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeInserted(int i, int i2) {
            d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeMoved(int i, int i2, int i3) {
            d();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeRemoved(int i, int i2) {
            d();
        }
    }
    static {
    }

    a(boolean z) {
        super();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.i = linearInterpolator;
        int i = 1;
        SparseArray sparseArray = new SparseArray();
        this.l = sparseArray;
        int i2 = -1;
        EnumSet.noneOf(a.c.class);
        int i5 = 0;
        int i6 = 100;
        long l = a.u;
        setHasStableIds(z);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Initialized with StableIds=");
        stringBuilder.append(z);
        this.a.c(stringBuilder.toString(), new Object[0]);
        a.b obj5 = new a.b(this, 0);
        this.j = obj5;
        registerAdapterDataObserver(obj5);
    }

    static SparseArray w(h.a.b.a a) {
        return a.l;
    }

    private long y(RecyclerView.e0 recyclerView$e0, int i2) {
        int i4;
        int i5;
        int i3;
        int i;
        long l;
        int obj7;
        int obj8;
        if (l().a() < 0 && i2 >= 0) {
            if (i2 >= 0) {
                obj7 = i2 + -1;
            }
        }
        i3 = i2 + -1;
        if (i3 > l().f()) {
            i4 = i3;
        }
        i4 -= obj7;
        i = this.n;
        final int i7 = 1;
        if (i != 0 && i6 >= i3) {
            if (i6 >= i3) {
                if (obj7 > i7) {
                    if (obj7 > i) {
                        if (i2 > i && obj7 == -1 && this.f.getChildCount() == 0) {
                            if (obj7 == -1) {
                                if (this.f.getChildCount() == 0) {
                                    if (i6 <= i7) {
                                        i3 += l;
                                    } else {
                                        this.r = 0;
                                    }
                                    obj7 = l().e();
                                    if (obj7 > i7) {
                                        l2 += i;
                                    } else {
                                        i5 = i3;
                                    }
                                } else {
                                    l3 += obj7;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i5;
    }

    private void z(int i) {
        final Object obj2 = this.l.get(i);
        if ((Animator)obj2 != null) {
            (Animator)obj2.end();
        }
    }

    @Override // h.a.b.e
    public abstract boolean A(int i);

    @Override // h.a.b.e
    void B(boolean z) {
    }

    @Override // h.a.b.e
    protected final void x(RecyclerView.e0 recyclerView$e0, int i2) {
        int childCount;
        boolean z;
        int animatorSet;
        int i3;
        int i;
        boolean z2;
        ArrayList arrayList;
        boolean next;
        long l2;
        int cmp;
        long l;
        Object obj11;
        androidx.recyclerview.widget.RecyclerView view = this.f;
        if (view == null) {
        }
        if (this.n < view.getChildCount()) {
            this.n = this.f.getChildCount();
        }
        if (this.q && this.m >= this.n) {
            if (this.m >= this.n) {
                this.p = false;
            }
        }
        animatorSet = l().d();
        if (!this.p) {
            if (this.o && !this.h && e0 instanceof b) {
                if (!this.h) {
                    if (e0 instanceof b) {
                        if (this.j.c()) {
                            if (A(i2)) {
                                if (!A(i2)) {
                                    if (this.p) {
                                        if (i2 <= animatorSet) {
                                            if (this.o) {
                                                if (i2 >= animatorSet) {
                                                    z2 = e0.itemView.hashCode();
                                                    z(z2);
                                                    arrayList = new ArrayList();
                                                    if (i2 == 0 && this.n == 0 && i2 >= animatorSet) {
                                                        if (this.n == 0) {
                                                            z2 = e0.itemView.hashCode();
                                                            z(z2);
                                                            arrayList = new ArrayList();
                                                            if (i2 >= animatorSet) {
                                                                i3 = 1;
                                                            }
                                                            (b)e0.scrollAnimators(arrayList, i2, i3);
                                                            animatorSet = new AnimatorSet();
                                                            animatorSet.playTogether(arrayList);
                                                            animatorSet.setInterpolator(this.i);
                                                            l2 = this.t;
                                                            Iterator iterator = arrayList.iterator();
                                                            while (iterator.hasNext()) {
                                                                arrayList = iterator.next();
                                                                if (Long.compare(duration, l) != 0) {
                                                                }
                                                                l2 = arrayList;
                                                            }
                                                            animatorSet.setDuration(l2);
                                                            a.d dVar = new a.d(this, z2);
                                                            animatorSet.addListener(dVar);
                                                            if (this.k) {
                                                                animatorSet.setStartDelay(y(e0, i2));
                                                            }
                                                            animatorSet.start();
                                                            this.l.put(z2, animatorSet);
                                                        }
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                }
            }
        } else {
        }
        this.j.b();
        this.m = i2;
    }
}
