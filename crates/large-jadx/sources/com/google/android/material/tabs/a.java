package com.google.android.material.tabs;

import android.graphics.drawable.Drawable;
import android.view.View;
import f.c.a.e.m.a;

/* loaded from: classes2.dex */
class a extends com.google.android.material.tabs.b {
    private static float e(float f) {
        return (float)i3;
    }

    private static float f(float f) {
        return (float)d2;
    }

    @Override // com.google.android.material.tabs.b
    void c(com.google.android.material.tabs.TabLayout tabLayout, View view2, View view3, float f4, Drawable drawable5) {
        int obj5;
        float obj6;
        android.graphics.RectF obj4 = b.a(tabLayout, view2);
        android.graphics.RectF obj3 = b.a(tabLayout, view3);
        obj5 = Float.compare(obj5, left) < 0 ? 1 : 0;
        if (obj5 != null) {
            obj5 = a.e(f4);
            obj6 = a.f(f4);
        } else {
            obj5 = a.f(f4);
            obj6 = a.e(f4);
        }
        drawable5.setBounds(a.c((int)left2, (int)left3, obj5), bounds.top, a.c((int)obj4, (int)obj3, obj6), obj4.bottom);
    }
}
