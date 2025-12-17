package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes.dex */
public abstract class t {

    protected final androidx.recyclerview.widget.RecyclerView.p a;
    private int b;
    final Rect c;

    class a extends androidx.recyclerview.widget.t {
        a(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
            super(p, 0);
        }

        @Override // androidx.recyclerview.widget.t
        public int d(View view) {
            return obj3 += rightMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int e(View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return obj3 += rightMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int f(View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return obj3 += bottomMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int g(View view) {
            return obj3 -= leftMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int h() {
            return this.a.H0();
        }

        @Override // androidx.recyclerview.widget.t
        public int i() {
            return i -= i3;
        }

        @Override // androidx.recyclerview.widget.t
        public int j() {
            return this.a.p();
        }

        @Override // androidx.recyclerview.widget.t
        public int k() {
            return this.a.I0();
        }

        @Override // androidx.recyclerview.widget.t
        public int l() {
            return this.a.u0();
        }

        @Override // androidx.recyclerview.widget.t
        public int m() {
            return this.a.v();
        }

        @Override // androidx.recyclerview.widget.t
        public int n() {
            return i2 -= i5;
        }

        @Override // androidx.recyclerview.widget.t
        public int p(View view) {
            this.a.G0(view, true, this.c);
            return obj4.right;
        }

        @Override // androidx.recyclerview.widget.t
        public int q(View view) {
            this.a.G0(view, true, this.c);
            return obj4.left;
        }

        @Override // androidx.recyclerview.widget.t
        public void r(int i) {
            this.a.W0(i);
        }
    }

    class b extends androidx.recyclerview.widget.t {
        b(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
            super(p, 0);
        }

        @Override // androidx.recyclerview.widget.t
        public int d(View view) {
            return obj3 += bottomMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int e(View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return obj3 += bottomMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int f(View view) {
            android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            return obj3 += rightMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int g(View view) {
            return obj3 -= topMargin;
        }

        @Override // androidx.recyclerview.widget.t
        public int h() {
            return this.a.t0();
        }

        @Override // androidx.recyclerview.widget.t
        public int i() {
            return i -= i3;
        }

        @Override // androidx.recyclerview.widget.t
        public int j() {
            return this.a.a();
        }

        @Override // androidx.recyclerview.widget.t
        public int k() {
            return this.a.u0();
        }

        @Override // androidx.recyclerview.widget.t
        public int l() {
            return this.a.I0();
        }

        @Override // androidx.recyclerview.widget.t
        public int m() {
            return this.a.u();
        }

        @Override // androidx.recyclerview.widget.t
        public int n() {
            return i2 -= i5;
        }

        @Override // androidx.recyclerview.widget.t
        public int p(View view) {
            this.a.G0(view, true, this.c);
            return obj4.bottom;
        }

        @Override // androidx.recyclerview.widget.t
        public int q(View view) {
            this.a.G0(view, true, this.c);
            return obj4.top;
        }

        @Override // androidx.recyclerview.widget.t
        public void r(int i) {
            this.a.X0(i);
        }
    }
    private t(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        super();
        this.b = Integer.MIN_VALUE;
        Rect rect = new Rect();
        this.c = rect;
        this.a = p;
    }

    t(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, androidx.recyclerview.widget.t.a t$a2) {
        super(p);
    }

    public static androidx.recyclerview.widget.t a(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        t.a aVar = new t.a(p);
        return aVar;
    }

    public static androidx.recyclerview.widget.t b(androidx.recyclerview.widget.RecyclerView.p recyclerView$p, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
            } else {
                return t.c(p);
            }
            IllegalArgumentException obj1 = new IllegalArgumentException("invalid orientation");
            throw obj1;
        }
        return t.a(p);
    }

    public static androidx.recyclerview.widget.t c(androidx.recyclerview.widget.RecyclerView.p recyclerView$p) {
        t.b bVar = new t.b(p);
        return bVar;
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        int i2;
        int i;
        if (Integer.MIN_VALUE == this.b) {
            i2 = 0;
        } else {
            i4 -= i;
        }
        return i2;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i);

    public void s() {
        this.b = n();
    }
}
