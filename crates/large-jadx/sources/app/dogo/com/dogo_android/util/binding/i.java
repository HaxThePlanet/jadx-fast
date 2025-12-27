package app.dogo.com.dogo_android.util.f0;

import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class i implements View.OnApplyWindowInsetsListener {

    public final /* synthetic */ View a;
    public /* synthetic */ i(View view) {
        super();
        this.a = view;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        BindingAdapters.l0(this.a, view, windowInsets);
        return windowInsets;
    }
}
