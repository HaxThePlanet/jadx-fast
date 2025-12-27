package d.h.l;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionProvider.java */
/* loaded from: classes.dex */
public abstract class b {

    private b.b a;

    public interface a {
    }

    public interface b {
        void onActionProviderVisibilityChanged(boolean z);
    }
    public b(Context context) {
        super();
    }

    public View d(MenuItem menuItem) {
        return c();
    }

    public void h() {
        this.a = null;
    }

    public void j(b.b bVar) {
        if (this.a != null && bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ";
            String simpleName = getClass().getSimpleName();
            String str4 = " instance while it is still in use somewhere else?";
            str2 = str3 + simpleName + str4;
            str = "ActionProvider(support)";
            Log.w(str, str2);
        }
        this.a = bVar;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public abstract View c();

    public boolean e() {
        return false;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return false;
    }

    public void i(b.a aVar) {
    }
}
