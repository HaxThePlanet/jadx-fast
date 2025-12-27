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
import h.a.b.i.c;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: AnimatorAdapter.java */
/* loaded from: classes2.dex */
public abstract class a extends e {

    private static long u = 300L;
    private Interpolator i = new LinearInterpolator();
    private a.b j = new a$b();
    private boolean k = true;
    private final SparseArray<Animator> l = new SparseArray<>();
    private int m = -1;
    private int n = -1;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private long r = 0;
    private long s = 100;
    private long t;

    static class a {
    }

    private enum c {

        ALPHA,
        SCALE,
        SLIDE_IN_BOTTOM,
        SLIDE_IN_LEFT,
        SLIDE_IN_RIGHT,
        SLIDE_IN_TOP;
    }

    private class d implements Animator.AnimatorListener {

        int a;
        final /* synthetic */ a b;
        d(int i) {
            this.b = aVar;
            super();
            this.a = i;
        }

        public void onAnimationEnd(Animator animator) {
            this.b.l.remove(this.a);
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    private class b extends RecyclerView.j {

        private boolean a;
        private Handler b;
        private b() {
            super();
            this.b = new Handler(Looper.getMainLooper(), new a.b.a(this));
        }

        static /* synthetic */ boolean a(a.b bVar, boolean z) {
            bVar.a = z;
            return z;
        }

        private void d() {
            this.a = true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void b() {
            if (this.a) {
                this.b.removeCallbacksAndMessages(null);
                long l = 200L;
                this.b.sendMessageDelayed(Message.obtain(this.b), l);
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

        /* synthetic */ b(a.a aVar) {
            this(aVar);
        }
    }
    a(boolean z) {
        super();
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        SparseArray sparseArray = new SparseArray();
        EnumSet.noneOf(a.c.class);
        this.t = a.u;
        setHasStableIds(z);
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "Initialized with StableIds=";
        str2 = str + z;
        this.a.c(str2, new Object[0]);
        registerAdapterDataObserver(new a.b(this, null));
    }

    static /* synthetic */ SparseArray w(a aVar) {
        return aVar.l;
    }

    private long y(RecyclerView.e0 e0Var, int i) {
        long l;
        long l3 = 0;
        int childCount;
        if (l().a() < 0 && i >= 0) {
            childCount = i - 1;
        }
        i = i - 1;
        if (i > l().f()) {
        }
        i -= childCount;
        final int i6 = 1;
        if (this.n == 0 || !(i4 < i && childCount <= i6)) {
            if (i4 <= i6) {
                l = this.s + this.r;
            } else {
                l3 = 0L;
                this.r = l3;
            }
            int i7 = l().e();
            if (i7 > i6) {
                i3 = i % i7;
                l4 = (long)i3;
                l2 = this.s * l4;
                l = this.r + l2;
            } else {
            }
        } else {
            if (!(childCount <= this.n || i > this.n)) {
                i = -1;
                if (childCount == -1) {
                    if (this.f.getChildCount() != 0) {
                        l4 = (long)i * this.s;
                        l = this.r + l4;
                    }
                }
            }
        }
        return l;
    }

    private void z(int i) {
        final Object obj = this.l.get(i);
        if (obj != null) {
            obj.end();
        }
    }

    @Override // h.a.b.e
    protected final void x(RecyclerView.e0 e0Var, int i) {
        boolean z2 = false;
        boolean hasNext;
        long duration;
        int cmp;
        long l;
        if (this.f == null) {
            return;
        }
        if (this.n < this.f.getChildCount()) {
            this.n = this.f.getChildCount();
        }
        z2 = false;
        if (this.q && this.m >= this.n) {
            this.p = false;
        }
        i = l().d();
        if (this.p || this.o) {
            if (!this.h) {
                z3 = e0Var instanceof b;
                if (e0Var instanceof b) {
                    if (!this.j.c() || this.A(i)) {
                        if (A(i) || this.p) {
                            int i8 = e0Var.itemView.hashCode();
                            z(i8);
                            ArrayList arrayList = new ArrayList();
                            if (i >= i) {
                                int i6 = 1;
                            }
                            (b)e0Var.scrollAnimators(arrayList, i, z2);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(arrayList);
                            animatorSet.setInterpolator(this.i);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                arrayList = it.next();
                                long duration2 = arrayList.getDuration();
                                l = a.u;
                            }
                            animatorSet.setDuration(duration);
                            animatorSet.addListener(new a.d(this, i8));
                            if (this.k) {
                                animatorSet.setStartDelay(y(e0Var, i));
                            }
                            animatorSet.start();
                            this.l.put(i8, animatorSet);
                        }
                    }
                }
            }
        }
        this.j.b();
        this.m = i;
    }


    @Override // h.a.b.e
    public abstract boolean A(int i);

    @Override // h.a.b.e
    void B(boolean z) {
    }
}
