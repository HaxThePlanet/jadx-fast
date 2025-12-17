package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.ReplaceWith;
import androidx.core.internal.view.SupportMenu;

/* loaded from: classes5.dex */
public final class MenuCompat {

    static class Api28Impl {
        static void setGroupDividerEnabled(Menu menu, boolean groupDividerEnabled) {
            menu.setGroupDividerEnabled(groupDividerEnabled);
        }
    }
    public static void setGroupDividerEnabled(Menu menu, boolean enabled) {
        Object obj;
        if (menu instanceof SupportMenu) {
            (SupportMenu)menu.setGroupDividerEnabled(enabled);
        } else {
            MenuCompat.Api28Impl.setGroupDividerEnabled(menu, enabled);
        }
    }

    @ReplaceWith(expression = "item.setShowAsAction(actionEnum)")
    @Deprecated
    public static void setShowAsAction(MenuItem item, int actionEnum) {
        item.setShowAsAction(actionEnum);
    }
}
