package app.dogo.com.dogo_android.util.h0;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public final class m0 implements Runnable {

    public final RecyclerView a;
    public final int b;
    public final int c;
    public final NestedScrollView v;
    public final int w;
    public m0(RecyclerView recyclerView, int i2, int i3, NestedScrollView nestedScrollView4, int i5) {
        super();
        this.a = recyclerView;
        this.b = i2;
        this.c = i3;
        this.v = nestedScrollView4;
        this.w = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j1.S(this.a, this.b, this.c, this.v, this.w);
    }
}
