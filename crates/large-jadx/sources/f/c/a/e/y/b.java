package f.c.a.e.y;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;

/* compiled from: NavigationBarMenu.java */
/* loaded from: classes2.dex */
public final class b extends g {

    private final Class<?> B;
    private final int C;
    public b(Context context, Class<?> cls, int i) {
        super(context);
        this.B = cls;
        this.C = i;
    }

    @Override // androidx.appcompat.view.menu.g
    protected MenuItem a(int i, int i2, int i3, java.lang.CharSequence charSequence) {
        final int i6 = 1;
        if (size() + i6 > this.C) {
            String simpleName = this.B.getSimpleName();
            final StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Maximum number of items supported by ";
            String str3 = " is ";
            String str4 = ". Limit can be checked with ";
            String str = "#getMaxItemCount()";
            i = str2 + simpleName + str3 + this.C + str4 + simpleName + str;
            throw new IllegalArgumentException(i);
        } else {
            h0();
            MenuItem i4 = super.a(i, i2, i3, charSequence);
            z = i4 instanceof i;
            if (i4 instanceof i) {
                (i)i4.t(true);
            }
            g0();
            return i4;
        }
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu addSubMenu(int i, int i2, int i3, java.lang.CharSequence charSequence) {
        StringBuilder stringBuilder = new StringBuilder();
        String simpleName = this.B.getSimpleName();
        String str = " does not support submenus";
        i2 = simpleName + str;
        throw new UnsupportedOperationException(i2);
    }
}
