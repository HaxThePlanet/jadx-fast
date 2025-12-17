package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.widget.t0;
import androidx.core.content.a;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.internal.n.d;
import com.google.android.material.internal.n.e;
import d.h.l.d0;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.c;
import f.c.a.e.d;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.y.c;
import f.c.a.e.y.d;
import f.c.a.e.y.e;
import f.c.a.e.y.e.b;
import f.c.a.e.y.e.c;

/* loaded from: classes2.dex */
public class BottomNavigationView extends e {

    class a implements n.d {
        a(com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView) {
            super();
        }

        @Override // com.google.android.material.internal.n$d
        public d0 a(View view, d0 d02, n.e n$e3) {
            int i3;
            int i;
            int i2;
            e3.d = i4 += i7;
            if (u.B(view) == 1) {
            } else {
                i = 0;
            }
            final int i8 = d02.k();
            i2 = i != 0 ? i8 : i3;
            e3.a = i9 += i2;
            if (i != 0) {
            } else {
                i3 = i8;
            }
            e3.c = i11 += i3;
            e3.a(view);
            return d02;
        }
    }

    @Deprecated
    public interface b extends e.b {
    }

    @Deprecated
    public interface c extends e.c {
    }
    public BottomNavigationView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.e);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, k.i);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet2, int i3, int i4) {
        int obj10;
        super(context, attributeSet2, i3, i4);
        final Context obj8 = getContext();
        final int i5 = 0;
        t0 obj9 = l.i(obj8, attributeSet2, l.J, i3, i4, new int[i5]);
        setItemHorizontalTranslationEnabled(obj9.a(l.L, true));
        obj10 = l.K;
        if (obj9.s(obj10)) {
            setMinimumHeight(obj9.f(obj10, i5));
        }
        obj9.w();
        if (i()) {
            f(obj8);
        }
        g();
    }

    private void f(Context context) {
        View view = new View(context);
        view.setBackgroundColor(a.d(context, c.a));
        FrameLayout.LayoutParams obj4 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(d.g));
        view.setLayoutParams(obj4);
        addView(view);
    }

    private void g() {
        BottomNavigationView.a aVar = new BottomNavigationView.a(this);
        n.b(this, aVar);
    }

    private int h(int i) {
        int suggestedMinimumHeight;
        int mode;
        int paddingBottom;
        int obj5;
        suggestedMinimumHeight = getSuggestedMinimumHeight();
        final int i2 = 1073741824;
        if (View.MeasureSpec.getMode(i) != i2 && suggestedMinimumHeight > 0) {
            if (suggestedMinimumHeight > 0) {
                obj5 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), suggestedMinimumHeight += mode), i2);
            }
        }
        return obj5;
    }

    private boolean i() {
        int sDK_INT;
        int i;
        if (Build.VERSION.SDK_INT < 21 && !background instanceof g) {
            i = !background instanceof g ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // f.c.a.e.y.e
    protected c d(Context context) {
        b bVar = new b(context);
        return bVar;
    }

    @Override // f.c.a.e.y.e
    public int getMaxItemCount() {
        return 5;
    }

    @Override // f.c.a.e.y.e
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, h(i2));
    }

    @Override // f.c.a.e.y.e
    public void setItemHorizontalTranslationEnabled(boolean z) {
        androidx.appcompat.view.menu.n menuView;
        boolean obj3;
        menuView = getMenuView();
        if ((b)menuView.m() != z) {
            menuView.setItemHorizontalTranslationEnabled(z);
            getPresenter().d(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(com.google.android.material.bottomnavigation.BottomNavigationView.b bottomNavigationView$b) {
        setOnItemReselectedListener(b);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(com.google.android.material.bottomnavigation.BottomNavigationView.c bottomNavigationView$c) {
        setOnItemSelectedListener(c);
    }
}
