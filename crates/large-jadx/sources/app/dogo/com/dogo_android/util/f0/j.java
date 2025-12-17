package app.dogo.com.dogo_android.util.f0;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes.dex */
public final class j implements View.OnApplyWindowInsetsListener {

    public final SwipeRefreshLayout a;
    public j(SwipeRefreshLayout swipeRefreshLayout) {
        super();
        this.a = swipeRefreshLayout;
    }

    @Override // android.view.View$OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets2) {
        n.t(this.a, view, windowInsets2);
        return windowInsets2;
    }
}
