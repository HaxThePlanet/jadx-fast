package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.internal.n;
import f.c.a.e.m.a;

/* loaded from: classes2.dex */
class b {
    static RectF a(com.google.android.material.tabs.TabLayout tabLayout, View view2) {
        boolean obj3;
        if (view2 == null) {
            obj3 = new RectF();
            return obj3;
        }
        if (!tabLayout.y() && view2 instanceof TabLayout.i) {
            if (view2 instanceof TabLayout.i) {
                return b.b((TabLayout.i)view2, 24);
            }
        }
        obj3 = new RectF((float)left, (float)top, (float)right, (float)obj4);
        return obj3;
    }

    static RectF b(com.google.android.material.tabs.TabLayout.i tabLayout$i, int i2) {
        int contentWidth;
        int obj4 = (int)obj4;
        if (i.getContentWidth() < obj4) {
            contentWidth = obj4;
        }
        obj4 /= 2;
        i7 /= 2;
        contentWidth /= 2;
        obj4 = new RectF((float)obj3, (float)i6, (float)i4, (float)i9);
        return obj4;
    }

    void c(com.google.android.material.tabs.TabLayout tabLayout, View view2, View view3, float f4, Drawable drawable5) {
        RectF obj3 = b.a(tabLayout, view2);
        RectF obj2 = b.a(tabLayout, view3);
        drawable5.setBounds(a.c((int)obj4, (int)left, f4), bounds.top, a.c((int)obj3, (int)obj2, f4), obj3.bottom);
    }

    void d(com.google.android.material.tabs.TabLayout tabLayout, View view2, Drawable drawable3) {
        RectF obj3 = b.a(tabLayout, view2);
        drawable3.setBounds((int)obj4, bounds.top, (int)obj3, bounds2.bottom);
    }
}
