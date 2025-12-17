package d.h.l;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    private d.h.l.b.b a;

    public interface a {
    }

    public interface b {
        public abstract void onActionProviderVisibilityChanged(boolean z);
    }
    public b(Context context) {
        super();
    }

    public boolean a() {
        return 0;
    }

    public boolean b() {
        return 1;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public boolean e() {
        return 0;
    }

    public void f(SubMenu subMenu) {
    }

    public boolean g() {
        return 0;
    }

    public void h() {
        this.a = 0;
    }

    public void i(d.h.l.b.a b$a) {
    }

    public void j(d.h.l.b.b b$b) {
        Object string;
        String str;
        if (this.a != null && b != null) {
            if (b != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
                stringBuilder.append(getClass().getSimpleName());
                stringBuilder.append(" instance while it is still in use somewhere else?");
                Log.w("ActionProvider(support)", stringBuilder.toString());
            }
        }
        this.a = b;
    }
}
