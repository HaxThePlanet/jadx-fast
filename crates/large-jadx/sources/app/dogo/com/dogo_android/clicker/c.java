package app.dogo.com.dogo_android.e;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar.f;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements Toolbar.f {

    public final /* synthetic */ i a;
    public /* synthetic */ c(i iVar) {
        super();
        this.a = iVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ClickerFragment.I1(this.a, menuItem);
    }
}
