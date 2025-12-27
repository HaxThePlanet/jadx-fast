package h.a.b.g;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.l.f;
import androidx.recyclerview.widget.m;
import h.a.b.i.a;

/* compiled from: ItemTouchHelperCallback.java */
/* loaded from: classes2.dex */
public class a extends l.f {

    protected a.a d;
    protected boolean e = false;
    protected boolean f = false;
    protected boolean g = false;
    protected long h = 300;
    protected long i = 400;
    protected float j = 0.5f;
    protected float k = 0.5f;
    protected int l = -1;

    public interface a {
        void c(int i, int i2);

        boolean d(int i, int i2);

        void e(RecyclerView.e0 e0Var, int i);

        boolean k(int i, int i2);
    }

    public interface b {
        View getFrontView();

        View getRearLeftView();

        View getRearRightView();

        boolean isDraggable();

        boolean isSwipeable();

        void onActionStateChanged(int i, int i2);

        void onItemReleased(int i);
    }
    public a(a.a aVar) {
        super();
        this.d = aVar;
    }

    private static void E(a.b bVar, int i) {
        i = 0;
        i = 8;
        if (bVar.getRearRightView() != null) {
            int r3 = i == 4 ? 0 : i;
            bVar.getRearRightView().setVisibility((i == 4 ? 0 : i));
        }
        if (bVar.getRearLeftView() != null && i == i) {
            bVar.getRearLeftView().setVisibility(i);
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public void B(RecyclerView.e0 e0Var, int i) {
        this.d.e(e0Var, i);
        if (i == 0) {
            super.B(e0Var, i);
        } else {
            z = e0Var instanceof a.b;
            if (e0Var instanceof a.b) {
                RecyclerView.e0 e0Var2 = e0Var;
                e0Var2.onActionStateChanged(e0Var.getAdapterPosition(), i);
                i = 1;
                if (i == 1) {
                    l.f.i().b(e0Var2.getFrontView());
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public void C(RecyclerView.e0 e0Var, int i) {
        z = e0Var instanceof a.b;
        if (e0Var instanceof a.b) {
            float translationX = (a.b)e0Var.getFrontView().getTranslationX();
            float f = 0.0f;
            if (translationX != 0.0f) {
                this.d.c(e0Var.getAdapterPosition(), i);
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
    public void c(RecyclerView recyclerView, RecyclerView.e0 e0Var) {
        float f = 1f;
        e0Var.itemView.setAlpha(f);
        z = e0Var instanceof a.b;
        if (e0Var instanceof a.b) {
            h.a.b.g.a.b bVar = e0Var;
            l.f.i().a(bVar.getFrontView());
            a.E(bVar, 0);
            bVar.onItemReleased(e0Var.getAdapterPosition());
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public long g(RecyclerView recyclerView, int i, float f, float f2) {
        long l;
        recyclerView = i == 8 ? this.i : this.h;
        return (i == 8 ? this.i : this.h);
    }

    @Override // androidx.recyclerview.widget.l$f
    public float k(RecyclerView.e0 e0Var) {
        return this.k;
    }

    @Override // androidx.recyclerview.widget.l$f
    public int l(RecyclerView recyclerView, RecyclerView.e0 e0Var) {
        androidx.recyclerview.widget.RecyclerView.p layoutManager;
        int recyclerView2 = 12;
        boolean swipeable;
        layoutManager = recyclerView.getLayoutManager();
        recyclerView2 = 12;
        recyclerView2 = 3;
        recyclerView2 = 0;
        if (!(layoutManager instanceof GridLayoutManager)) {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                recyclerView2 = 15;
            } else {
                if (a.c(recyclerView) != 0) {
                    if (this.l > 0) {
                    }
                } else {
                    if (this.l > 0) {
                    }
                }
            }
        }
        swipeable = e0Var instanceof a.b;
        if (e0Var instanceof a.b) {
            if (!e0Var.isDraggable()) {
            }
            if (e0Var.isSwipeable()) {
            }
        }
        return l.f.u(recyclerView2, recyclerView2);
    }

    @Override // androidx.recyclerview.widget.l$f
    public float n(RecyclerView.e0 e0Var) {
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
    public void v(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 e0Var, float f, float f2, int i, boolean z) {
        float f52;
        int i2 = 0;
        i = 1;
        if (i == 1) {
            if (e0Var instanceof a.b) {
                f = 0.0f;
                float r1 = f2 != 0.0f ? f2 : f;
                i2 = 0;
                if (r1 > 0.0f) {
                    i2 = 8;
                } else {
                    if (r1 < 0.0f) {
                        i2 = 4;
                    }
                }
                a.E(e0Var, i2);
                l.f.i().d(canvas, recyclerView, e0Var.getFrontView(), f, f2, i, z);
            } else {
                super.v(canvas, recyclerView, e0Var, f, f2, i, z);
            }
        }
    }

    @Override // androidx.recyclerview.widget.l$f
    public boolean z(RecyclerView recyclerView, RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        if (!this.d.d(e0Var.getAdapterPosition(), e0Var2.getAdapterPosition())) {
            return false;
        }
        this.d.k(e0Var.getAdapterPosition(), e0Var2.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.l$f
    public boolean a(RecyclerView recyclerView, RecyclerView.e0 e0Var, RecyclerView.e0 e0Var2) {
        return true;
    }
}
