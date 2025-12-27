package h.a.b.f;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: FlexibleLayoutManager.java */
/* loaded from: classes2.dex */
public class a implements b {

    protected RecyclerView a;
    protected RecyclerView.p b;
    public a(RecyclerView recyclerView) {
        this(recyclerView.getLayoutManager());
        this.a = recyclerView;
    }

    private RecyclerView.p g() {
        RecyclerView.p layoutManager;
        if (this.a != null) {
            layoutManager = this.a.getLayoutManager();
        } else {
        }
        return layoutManager;
    }

    public int a() {
        int i;
        int i2 = 1;
        RecyclerView.p pVar = g();
        if (pVar instanceof StaggeredGridLayoutManager) {
            int[] iArr = null;
            i = pVar.y2(iArr)[0];
            i2 = 1;
            while (i2 < e()) {
                i = pVar.y2(iArr)[i2];
                i2 = i2 + 1;
            }
            return i;
        }
        return pVar.r2();
    }

    public int b() {
        int i;
        int i2 = 1;
        RecyclerView.p pVar = g();
        if (pVar instanceof StaggeredGridLayoutManager) {
            int[] iArr = null;
            i = pVar.D2(iArr)[0];
            i2 = 1;
            while (i2 < e()) {
                i = pVar.D2(iArr)[i2];
                i2 = i2 + 1;
            }
            return i;
        }
        return pVar.v2();
    }

    public int c() {
        RecyclerView.p pVar = g();
        if (pVar instanceof LinearLayoutManager) {
            return pVar.J2();
        }
        if (pVar instanceof StaggeredGridLayoutManager) {
            return pVar.Q2();
        }
        return 1;
    }

    public int d() {
        int i;
        int i2 = 1;
        RecyclerView.p pVar = g();
        if (pVar instanceof StaggeredGridLayoutManager) {
            int[] iArr = null;
            i = pVar.G2(iArr)[0];
            i2 = 1;
            while (i2 < e()) {
                i = pVar.G2(iArr)[i2];
                i2 = i2 + 1;
            }
            return i;
        }
        return pVar.y2();
    }

    public int e() {
        RecyclerView.p pVar = g();
        if (pVar instanceof GridLayoutManager) {
            return pVar.s3();
        }
        if (pVar instanceof StaggeredGridLayoutManager) {
            return pVar.R2();
        }
        return 1;
    }

    public int f() {
        int i;
        int i2 = 1;
        RecyclerView.p pVar = g();
        if (pVar instanceof StaggeredGridLayoutManager) {
            int[] iArr = null;
            i = pVar.E2(iArr)[0];
            i2 = 1;
            while (i2 < e()) {
                i = pVar.E2(iArr)[i2];
                i2 = i2 + 1;
            }
            return i;
        }
        return pVar.w2();
    }

    public a(RecyclerView.p pVar) {
        super();
        this.b = pVar;
    }
}
