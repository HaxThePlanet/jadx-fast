package app.dogo.com.dogo_android.view.main_screen.j;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;

/* loaded from: classes.dex */
public final class a0 implements SwipeRefreshLayout.j {

    public final app.dogo.com.dogo_android.view.main_screen.j.k0 a;
    public a0(app.dogo.com.dogo_android.view.main_screen.j.k0 k0) {
        super();
        this.a = k0;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout$j
    public final void onRefresh() {
        k0.E2(this.a);
    }
}
