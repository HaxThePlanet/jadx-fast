package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.d;
import d.h.l.u;
import f.c.a.e.d0.g;
import f.c.a.e.d0.i;
import f.c.a.e.f;
import f.c.a.e.h;
import f.c.a.e.l;

/* loaded from: classes2.dex */
class d extends ConstraintLayout {

    private final Runnable M;
    private int N;
    private g O;

    class a implements Runnable {

        final com.google.android.material.timepicker.d a;
        a(com.google.android.material.timepicker.d d) {
            this.a = d;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.z();
        }
    }
    public d(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public d(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        LayoutInflater.from(context).inflate(h.l, this);
        u.o0(this, v());
        int i2 = 0;
        final TypedArray obj3 = context.obtainStyledAttributes(attributeSet2, l.U3, i3, i2);
        this.N = obj3.getDimensionPixelSize(l.V3, i2);
        d.a obj4 = new d.a(this);
        this.M = obj4;
        obj3.recycle();
    }

    private void A() {
        Runnable runnable;
        final Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.M);
            handler.post(this.M);
        }
    }

    private Drawable v() {
        g gVar = new g();
        this.O = gVar;
        i iVar = new i(1056964608);
        gVar.X(iVar);
        this.O.Z(ColorStateList.valueOf(-1));
        return this.O;
    }

    private static boolean y(View view) {
        return "skip".equals(view.getTag());
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        int obj2;
        super.addView(view, i2, layoutParams3);
        if (view.getId() == -1) {
            view.setId(u.k());
        }
        A();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        z();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        A();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setBackgroundColor(int i) {
        this.O.Z(ColorStateList.valueOf(i));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public int w() {
        return this.N;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void x(int i) {
        this.N = i;
        z();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void z() {
        int i3;
        int i5;
        int i6;
        boolean z;
        int i4;
        View childAt;
        int i2;
        int i;
        final int childCount = getChildCount();
        i5 = 1;
        i6 = i3;
        while (i6 < childCount) {
            if (d.y(getChildAt(i6))) {
            }
            i6++;
            i5++;
        }
        d dVar = new d();
        dVar.g(this);
        i4 = 0;
        while (i3 < childCount) {
            childAt = getChildAt(i3);
            i = f.b;
            if (childAt.getId() != i) {
            }
            i3++;
            if (d.y(childAt)) {
            } else {
            }
            dVar.j(childAt.getId(), i, this.N, i4);
            i4 += childAt;
        }
        dVar.c(this);
    }
}
