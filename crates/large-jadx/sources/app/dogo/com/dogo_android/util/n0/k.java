package app.dogo.com.dogo_android.util.n0;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.p;
import androidx.recyclerview.widget.RecyclerView.u;

/* loaded from: classes.dex */
public abstract class k extends RecyclerView.u {

    private int a;
    private int b = 0;
    private boolean c = true;
    public k(int i) {
        super();
        int i2 = 0;
        int i3 = 1;
        this.a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public abstract void a();

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void b() {
        this.b = 0;
        this.c = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$u
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        boolean z;
        int obj2;
        int obj3;
        int obj4;
        super.onScrolled(recyclerView, i2, i3);
        obj4 = recyclerView.getLayoutManager().v0();
        if (this.c && obj4 > this.b) {
            if (obj4 > this.b) {
                this.c = false;
                this.b = obj4;
            }
        }
        if (!this.c && obj4 -= obj3 <= obj2 += obj3) {
            if (obj4 -= obj3 <= obj2 += obj3) {
                a();
                this.c = true;
            }
        }
    }
}
