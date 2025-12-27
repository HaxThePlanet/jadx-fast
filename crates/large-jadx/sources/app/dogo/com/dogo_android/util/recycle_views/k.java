package app.dogo.com.dogo_android.util.n0;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;

/* compiled from: EndlessRecyclerOnScrollListener.java */
/* loaded from: classes.dex */
public abstract class k extends RecyclerView.u {

    private int a;
    private int b = 0;
    private boolean c = true;
    public k(int i) {
        super();
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void b() {
        this.b = 0;
        this.c = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        int i4 = recyclerView.getLayoutManager().v0();
        if (this.c && i4 > this.b) {
            boolean z = false;
            this.c = z;
            this.b = i4;
        }
        if (!this.c) {
            i4 = i4 - recyclerView.getChildCount();
            i = (LinearLayoutManager)recyclerView.getLayoutManager().v2() + this.a;
            if (i4 - childCount <= i + this.a) {
                a();
                this.c = true;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public abstract void a();
}
