package app.dogo.com.dogo_android.l.a;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;

/* loaded from: classes.dex */
public final class c implements SwipeRefreshLayout.j {

    final app.dogo.com.dogo_android.l.a.c.a a;
    final int b;

    public interface a {
        public abstract void a(int i);
    }
    public c(app.dogo.com.dogo_android.l.a.c.a c$a, int i2) {
        super();
        this.a = a;
        this.b = i2;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout$j
    public void onRefresh() {
        this.a.a(this.b);
    }
}
