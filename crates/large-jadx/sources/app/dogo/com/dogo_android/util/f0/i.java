package app.dogo.com.dogo_android.util.f0;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class i implements View.OnApplyWindowInsetsListener {

    public final View a;
    public i(View view) {
        super();
        this.a = view;
    }

    @Override // android.view.View$OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets2) {
        n.s(this.a, view, windowInsets2);
        return windowInsets2;
    }
}
