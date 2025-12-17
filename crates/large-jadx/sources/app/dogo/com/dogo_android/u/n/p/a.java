package app.dogo.com.dogo_android.u.n.p;

import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.h.ol;

/* loaded from: classes.dex */
public final class a implements Runnable {

    public final RecyclerView a;
    public final ol b;
    public a(RecyclerView recyclerView, ol ol2) {
        super();
        this.a = recyclerView;
        this.b = ol2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a(this.a, this.b);
    }
}
