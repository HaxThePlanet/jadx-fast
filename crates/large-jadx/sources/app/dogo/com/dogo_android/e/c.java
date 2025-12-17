package app.dogo.com.dogo_android.e;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar.f;

/* loaded from: classes.dex */
public final class c implements Toolbar.f {

    public final app.dogo.com.dogo_android.e.i a;
    public c(app.dogo.com.dogo_android.e.i i) {
        super();
        this.a = i;
    }

    @Override // androidx.appcompat.widget.Toolbar$f
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return i.F1(this.a, menuItem);
    }
}
