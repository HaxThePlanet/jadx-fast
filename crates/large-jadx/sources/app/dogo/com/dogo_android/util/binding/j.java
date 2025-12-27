package app.dogo.com.dogo_android.util.f0;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class j implements View.OnApplyWindowInsetsListener {

    public final /* synthetic */ SwipeRefreshLayout a;
    public /* synthetic */ j(SwipeRefreshLayout swipeRefreshLayout) {
        super();
        this.a = swipeRefreshLayout;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        BindingAdapters.b0(this.a, view, windowInsets);
        return windowInsets;
    }
}
