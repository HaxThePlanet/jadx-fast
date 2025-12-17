package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import d.h.l.u;
import d.r.c;

/* loaded from: classes.dex */
class n implements androidx.recyclerview.widget.m {

    static final androidx.recyclerview.widget.m a;
    static {
        n nVar = new n();
        n.a = nVar;
    }

    private static float e(androidx.recyclerview.widget.RecyclerView recyclerView, View view2) {
        int i;
        int i2;
        View childAt;
        int cmp;
        i = 0;
        i2 = 0;
        while (i2 < recyclerView.getChildCount()) {
            childAt = recyclerView.getChildAt(i2);
            if (childAt == view2) {
            } else {
            }
            childAt = u.w(childAt);
            if (Float.compare(childAt, i) > 0) {
            }
            i2++;
            i = childAt;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.m
    public void a(View view) {
        int sDK_INT;
        Object floatValue;
        int i;
        boolean z;
        sDK_INT = c.a;
        floatValue = view.getTag(sDK_INT);
        if (Build.VERSION.SDK_INT >= 21 && floatValue instanceof Float) {
            sDK_INT = c.a;
            floatValue = view.getTag(sDK_INT);
            if (floatValue instanceof Float) {
                u.s0(view, (Float)floatValue.floatValue());
            }
            view.setTag(sDK_INT, 0);
        }
        int i2 = 0;
        view.setTranslationX(i2);
        view.setTranslationY(i2);
    }

    @Override // androidx.recyclerview.widget.m
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.m
    public void c(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, View view3, float f4, float f5, int i6, boolean z7) {
    }

    @Override // androidx.recyclerview.widget.m
    public void d(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, View view3, float f4, float f5, int i6, boolean z7) {
        int obj1;
        androidx.recyclerview.widget.RecyclerView obj2;
        int obj6;
        int obj7;
        obj1 = c.a;
        if (Build.VERSION.SDK_INT >= 21 && z7 != 0 && view3.getTag(obj1) == null) {
            if (z7 != 0) {
                obj1 = c.a;
                if (view3.getTag(obj1) == null) {
                    u.s0(view3, obj2 += obj7);
                    view3.setTag(obj1, Float.valueOf(u.w(view3)));
                }
            }
        }
        view3.setTranslationX(f4);
        view3.setTranslationY(f5);
    }
}
