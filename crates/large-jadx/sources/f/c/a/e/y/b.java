package f.c.a.e.y;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;

/* loaded from: classes2.dex */
public final class b extends g {

    private final Class<?> B;
    private final int C;
    public b(Context context, Class<?> class2, int i3) {
        super(context);
        this.B = class2;
        this.C = i3;
    }

    @Override // androidx.appcompat.view.menu.g
    protected MenuItem a(int i, int i2, int i3, java.lang.CharSequence charSequence4) {
        boolean obj5;
        final int i5 = 1;
        if (size += i5 > this.C) {
        } else {
            h0();
            MenuItem obj4 = super.a(i, i2, i3, charSequence4);
            if (obj4 instanceof i) {
                (i)obj4.t(i5);
            }
            g0();
            return obj4;
        }
        obj4 = this.B.getSimpleName();
        StringBuilder obj6 = new StringBuilder();
        obj6.append("Maximum number of items supported by ");
        obj6.append(obj4);
        obj6.append(" is ");
        obj6.append(this.C);
        obj6.append(". Limit can be checked with ");
        obj6.append(obj4);
        obj6.append("#getMaxItemCount()");
        obj5 = new IllegalArgumentException(obj6.toString());
        throw obj5;
    }

    @Override // androidx.appcompat.view.menu.g
    public SubMenu addSubMenu(int i, int i2, int i3, java.lang.CharSequence charSequence4) {
        StringBuilder obj2 = new StringBuilder();
        obj2.append(this.B.getSimpleName());
        obj2.append(" does not support submenus");
        UnsupportedOperationException obj1 = new UnsupportedOperationException(obj2.toString());
        throw obj1;
    }
}
