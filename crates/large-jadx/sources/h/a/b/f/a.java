package h.a.b.f;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* loaded from: classes2.dex */
public class a implements h.a.b.f.b {

    protected RecyclerView a;
    protected RecyclerView.p b;
    public a(RecyclerView.p recyclerView$p) {
        super();
        this.b = p;
    }

    public a(RecyclerView recyclerView) {
        super(recyclerView.getLayoutManager());
        this.a = recyclerView;
    }

    private RecyclerView.p g() {
        RecyclerView.p layoutManager;
        RecyclerView view = this.a;
        if (view != null) {
            layoutManager = view.getLayoutManager();
        } else {
            layoutManager = this.b;
        }
        return layoutManager;
    }

    @Override // h.a.b.f.b
    public int a() {
        int i3;
        int i2;
        int i;
        RecyclerView.p view = g();
        if (view instanceof StaggeredGridLayoutManager != null) {
            int i5 = 0;
            i3 = (StaggeredGridLayoutManager)view.y2(i5)[0];
            i2 = 1;
            while (i2 < e()) {
                i = view.y2(i5)[i2];
                if (i < i3) {
                }
                i2++;
                i3 = i;
            }
            return i3;
        }
        return (LinearLayoutManager)view.r2();
    }

    @Override // h.a.b.f.b
    public int b() {
        int i3;
        int i2;
        int i;
        RecyclerView.p view = g();
        if (view instanceof StaggeredGridLayoutManager != null) {
            int i5 = 0;
            i3 = (StaggeredGridLayoutManager)view.D2(i5)[0];
            i2 = 1;
            while (i2 < e()) {
                i = view.D2(i5)[i2];
                if (i < i3) {
                }
                i2++;
                i3 = i;
            }
            return i3;
        }
        return (LinearLayoutManager)view.v2();
    }

    @Override // h.a.b.f.b
    public int c() {
        RecyclerView.p view = g();
        if (view instanceof LinearLayoutManager != null) {
            return (LinearLayoutManager)view.J2();
        }
        if (view instanceof StaggeredGridLayoutManager != null) {
            return (StaggeredGridLayoutManager)view.Q2();
        }
        return 1;
    }

    @Override // h.a.b.f.b
    public int d() {
        int i3;
        int i2;
        int i;
        RecyclerView.p view = g();
        if (view instanceof StaggeredGridLayoutManager != null) {
            int i5 = 0;
            i3 = (StaggeredGridLayoutManager)view.G2(i5)[0];
            i2 = 1;
            while (i2 < e()) {
                i = view.G2(i5)[i2];
                if (i > i3) {
                }
                i2++;
                i3 = i;
            }
            return i3;
        }
        return (LinearLayoutManager)view.y2();
    }

    @Override // h.a.b.f.b
    public int e() {
        RecyclerView.p view = g();
        if (view instanceof GridLayoutManager != null) {
            return (GridLayoutManager)view.s3();
        }
        if (view instanceof StaggeredGridLayoutManager != null) {
            return (StaggeredGridLayoutManager)view.R2();
        }
        return 1;
    }

    @Override // h.a.b.f.b
    public int f() {
        int i3;
        int i;
        int i2;
        RecyclerView.p view = g();
        if (view instanceof StaggeredGridLayoutManager != null) {
            int i5 = 0;
            i3 = (StaggeredGridLayoutManager)view.E2(i5)[0];
            i = 1;
            while (i < e()) {
                i2 = view.E2(i5)[i];
                if (i2 > i3) {
                }
                i++;
                i3 = i2;
            }
            return i3;
        }
        return (LinearLayoutManager)view.w2();
    }
}
