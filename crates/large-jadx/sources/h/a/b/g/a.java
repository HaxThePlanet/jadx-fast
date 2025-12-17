package h.a.b.g;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.l.f;
import androidx.recyclerview.widget.m;
import h.a.b.i.a;

/* loaded from: classes2.dex */
public class a extends l.f {

    protected h.a.b.g.a.a d;
    protected boolean e = false;
    protected boolean f = false;
    protected boolean g = false;
    protected long h = 300;
    protected long i = 400;
    protected float j = 0.5f;
    protected float k = 0.5f;
    protected int l = -1;

    public interface a {
        public abstract void c(int i, int i2);

        public abstract boolean d(int i, int i2);

        public abstract void e(RecyclerView.e0 recyclerView$e0, int i2);

        public abstract boolean k(int i, int i2);
    }

    public interface b {
        public abstract View getFrontView();

        public abstract View getRearLeftView();

        public abstract View getRearRightView();

        public abstract boolean isDraggable();

        public abstract boolean isSwipeable();

        public abstract void onActionStateChanged(int i, int i2);

        public abstract void onItemReleased(int i);
    }
    public a(h.a.b.g.a.a a$a) {
        super();
        int i = 0;
        int i2 = 300;
        int i3 = 400;
        int i4 = 1056964608;
        int i5 = -1;
        this.d = a;
    }

    private static void E(h.a.b.g.a.b a$b, int i2) {
        View rearRightView;
        int i3;
        int i;
        View obj4;
        final int i4 = 8;
        if (b.getRearRightView() != null) {
            i = i2 == 4 ? i3 : i4;
            b.getRearRightView().setVisibility(i);
        }
        if (b.getRearLeftView() != null) {
            if (i2 == i4) {
            } else {
                i3 = i4;
            }
            b.getRearLeftView().setVisibility(i3);
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public void B(RecyclerView.e0 recyclerView$e0, int i2) {
        boolean aVar;
        RecyclerView.e0 obj2;
        int obj3;
        this.d.e(e0, i2);
        if (i2 != 0) {
            aVar = e0;
            (a.b)aVar.onActionStateChanged(e0.getAdapterPosition(), i2);
            if (e0 instanceof a.b && i2 == 1) {
                aVar = e0;
                (a.b)aVar.onActionStateChanged(e0.getAdapterPosition(), i2);
                if (i2 == 1) {
                    l.f.i().b(aVar.getFrontView());
                }
            }
        } else {
            super.B(e0, i2);
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public void C(RecyclerView.e0 recyclerView$e0, int i2) {
        boolean cmp;
        int i;
        Object obj3;
        if (e0 instanceof a.b && Float.compare(translationX, i) != 0) {
            if (Float.compare(translationX, i) != 0) {
                this.d.c(e0.getAdapterPosition(), i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public boolean D() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.l$f
    public void F(boolean z) {
        this.g = z;
    }

    @Override // androidx.recyclerview.widget.l$f
    public void G(int i) {
        this.l = i;
    }

    @Override // androidx.recyclerview.widget.l$f
    public void H(float f) {
        this.j = f;
    }

    @Override // androidx.recyclerview.widget.l$f
    public boolean a(RecyclerView recyclerView, RecyclerView.e0 recyclerView$e02, RecyclerView.e0 recyclerView$e03) {
        return 1;
    }

    @Override // androidx.recyclerview.widget.l$f
    public void c(RecyclerView recyclerView, RecyclerView.e0 recyclerView$e02) {
        int i;
        View frontView;
        boolean obj3;
        Object obj4;
        e02.itemView.setAlpha(1065353216);
        if (e02 instanceof a.b) {
            obj3 = e02;
            l.f.i().a((a.b)obj3.getFrontView());
            a.E(obj3, 0);
            obj3.onItemReleased(e02.getAdapterPosition());
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public long g(RecyclerView recyclerView, int i2, float f3, float f4) {
        long obj1;
        obj1 = i2 == 8 ? this.i : this.h;
        return obj1;
    }

    @Override // androidx.recyclerview.widget.l$f
    public float k(RecyclerView.e0 recyclerView$e0) {
        return this.k;
    }

    @Override // androidx.recyclerview.widget.l$f
    public int l(RecyclerView recyclerView, RecyclerView.e0 recyclerView$e02) {
        androidx.recyclerview.widget.RecyclerView.p layoutManager;
        int i2;
        int i4;
        int i;
        int i3;
        RecyclerView obj7;
        layoutManager = recyclerView.getLayoutManager();
        i2 = 12;
        i = 0;
        if (layoutManager instanceof GridLayoutManager == null) {
            if (layoutManager instanceof StaggeredGridLayoutManager != null) {
                i2 = 15;
                i4 = i;
            } else {
                if (a.c(recyclerView) == 0) {
                    obj7 = this.l;
                    if (obj7 > 0) {
                        i4 = obj7;
                    }
                } else {
                    obj7 = this.l;
                    if (obj7 > 0) {
                        i2 = obj7;
                    }
                    i4 = i2;
                    i2 = i3;
                }
            }
        } else {
        }
        if (e02 instanceof a.b) {
            if (!(a.b)e02.isDraggable()) {
                i2 = i;
            }
            if (!e02.isSwipeable()) {
            } else {
                i = i4;
            }
        } else {
        }
        return l.f.u(i2, i);
    }

    @Override // androidx.recyclerview.widget.l$f
    public float n(RecyclerView.e0 recyclerView$e0) {
        return this.j;
    }

    @Override // androidx.recyclerview.widget.l$f
    public boolean r() {
        return this.g;
    }

    @Override // androidx.recyclerview.widget.l$f
    public boolean s() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.l$f
    public void v(Canvas canvas, RecyclerView recyclerView2, RecyclerView.e0 recyclerView$e03, float f4, float f5, int i6, boolean z7) {
        int i3;
        int cmp;
        Canvas canvas2;
        int i;
        RecyclerView view;
        int i2;
        View frontView;
        float f;
        int i4;
        int i5;
        boolean z;
        if (i6 == 1 && e03 instanceof a.b) {
            if (e03 instanceof a.b) {
                cmp = 0;
                i = Float.compare(f5, cmp) != 0 ? f5 : f4;
                i2 = 0;
                if (Float.compare(i, cmp) > 0) {
                    i2 = 8;
                } else {
                    if (Float.compare(i, cmp) < 0) {
                        i2 = 4;
                    }
                }
                a.E(e03, i2);
                l.f.i().d(canvas, recyclerView2, (a.b)e03.getFrontView(), f4, f5, i6, z7);
            } else {
                super.v(canvas, recyclerView2, e03, f4, f5, i6, z7);
            }
        } else {
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public boolean z(RecyclerView recyclerView, RecyclerView.e0 recyclerView$e02, RecyclerView.e0 recyclerView$e03) {
        if (!this.d.d(e02.getAdapterPosition(), e03.getAdapterPosition())) {
            return 0;
        }
        this.d.k(e02.getAdapterPosition(), e03.getAdapterPosition());
        return 1;
    }
}
