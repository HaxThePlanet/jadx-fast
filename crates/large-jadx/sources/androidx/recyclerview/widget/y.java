package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

/* loaded from: classes.dex */
public abstract class y extends androidx.recyclerview.widget.RecyclerView.s {

    androidx.recyclerview.widget.RecyclerView a;
    private final androidx.recyclerview.widget.RecyclerView.u b;

    class a extends androidx.recyclerview.widget.RecyclerView.u {

        boolean a = false;
        final androidx.recyclerview.widget.y b;
        a(androidx.recyclerview.widget.y y) {
            this.b = y;
            super();
            final int obj1 = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrollStateChanged(androidx.recyclerview.widget.RecyclerView recyclerView, int i2) {
            androidx.recyclerview.widget.RecyclerView obj1;
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.a) {
                if (this.a) {
                    this.a = false;
                    this.b.k();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrolled(androidx.recyclerview.widget.RecyclerView recyclerView, int i2, int i3) {
            int obj1;
            if (i2 == 0) {
                if (i3 != 0) {
                    this.a = true;
                }
            } else {
            }
        }
    }

    class b extends androidx.recyclerview.widget.p {

        final androidx.recyclerview.widget.y a;
        b(androidx.recyclerview.widget.y y, Context context2) {
            this.a = y;
            super(context2);
        }

        @Override // androidx.recyclerview.widget.p
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return i /= obj2;
        }

        @Override // androidx.recyclerview.widget.p
        protected void onTargetFound(View view, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b02, androidx.recyclerview.widget.RecyclerView.a0.a recyclerView$a0$a3) {
            int mDecelerateInterpolator;
            androidx.recyclerview.widget.y obj4 = this.a;
            androidx.recyclerview.widget.RecyclerView view2 = obj4.a;
            if (view2 == null) {
            }
            int[] obj3 = obj4.c(view2.getLayoutManager(), view);
            obj4 = obj3[0];
            obj3 = obj3[1];
            int timeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(obj4), Math.abs(obj3)));
            if (timeForDeceleration > 0) {
                a3.d(obj4, obj3, timeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }
    public y() {
        super();
        y.a aVar = new y.a(this);
        this.b = aVar;
    }

    private void f() {
        this.a.h1(this.b);
        this.a.setOnFlingListener(0);
    }

    private void i() {
        if (this.a.getOnFlingListener() != null) {
        } else {
            this.a.l(this.b);
            this.a.setOnFlingListener(this);
        }
        IllegalStateException illegalStateException = new IllegalStateException("An instance of OnFlingListener already set.");
        throw illegalStateException;
    }

    private boolean j(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, int i2, int i3) {
        final int i = 0;
        if (!p instanceof RecyclerView.a0.b) {
            return i;
        }
        androidx.recyclerview.widget.RecyclerView.a0 view = d(p);
        if (view == null) {
            return i;
        }
        final int obj4 = h(p, i2, i3);
        if (obj4 == -1) {
            return i;
        }
        view.setTargetPosition(obj4);
        p.f2(view);
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$s
    public boolean a(int i, int i2) {
        int i4;
        int i3;
        boolean obj5;
        androidx.recyclerview.widget.RecyclerView.p layoutManager = this.a.getLayoutManager();
        i4 = 0;
        if (layoutManager == null) {
            return i4;
        }
        if (this.a.getAdapter() == null) {
            return i4;
        }
        int minFlingVelocity = this.a.getMinFlingVelocity();
        if (Math.abs(i2) <= minFlingVelocity) {
            if (Math.abs(i) > minFlingVelocity && j(layoutManager, i, i2)) {
                if (j(layoutManager, i, i2)) {
                    i4 = 1;
                }
            }
        } else {
        }
        return i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$s
    public void b(androidx.recyclerview.widget.RecyclerView recyclerView) {
        Object context;
        DecelerateInterpolator decelerateInterpolator;
        Object obj3;
        context = this.a;
        if (context == recyclerView) {
        }
        if (context != null) {
            f();
        }
        this.a = recyclerView;
        if (recyclerView != null) {
            i();
            decelerateInterpolator = new DecelerateInterpolator();
            obj3 = new Scroller(this.a.getContext(), decelerateInterpolator);
            k();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$s
    public abstract int[] c(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, View view2);

    @Override // androidx.recyclerview.widget.RecyclerView$s
    protected androidx.recyclerview.widget.RecyclerView.a0 d(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        return e(p);
    }

    @Deprecated
    protected androidx.recyclerview.widget.p e(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        if (!p instanceof RecyclerView.a0.b) {
            return null;
        }
        y.b obj2 = new y.b(this, this.a.getContext());
        return obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$s
    public abstract View g(androidx.recyclerview.widget.RecyclerView.p recyclerView$p);

    @Override // androidx.recyclerview.widget.RecyclerView$s
    public abstract int h(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, int i2, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView$s
    void k() {
        int[] iArr;
        int i;
        int i2;
        androidx.recyclerview.widget.RecyclerView view = this.a;
        if (view == null) {
        }
        androidx.recyclerview.widget.RecyclerView.p layoutManager = view.getLayoutManager();
        if (layoutManager == null) {
        }
        View view2 = g(layoutManager);
        if (view2 == null) {
        }
        iArr = c(layoutManager, view2);
        i = 0;
        final int i3 = 1;
        if (iArr[i] == 0) {
            if (iArr[i3] != 0) {
                this.a.u1(iArr[i], iArr[i3]);
            }
        } else {
        }
    }
}
