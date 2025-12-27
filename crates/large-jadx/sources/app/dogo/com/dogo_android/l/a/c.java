package app.dogo.com.dogo_android.l.a;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;

/* compiled from: OnRefreshListener.java */
/* loaded from: classes.dex */
public final class c implements SwipeRefreshLayout.j {

    final c.a a;
    final int b;

    public interface a {
        void a(int i);
    }
    public c(c.a aVar, int i) {
        super();
        this.a = aVar;
        this.b = i;
    }

    public void onRefresh() {
        this.a.a(this.b);
    }
}
