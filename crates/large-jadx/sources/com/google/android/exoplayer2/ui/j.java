package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class j extends View implements com.google.android.exoplayer2.ui.SubtitleView.a {

    private final List<com.google.android.exoplayer2.ui.x> a;
    private List<c> b;
    private int c;
    private float v;
    private com.google.android.exoplayer2.ui.k w;
    private float x;
    public j(Context context) {
        super(context, 0);
    }

    public j(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        ArrayList obj1 = new ArrayList();
        this.a = obj1;
        this.b = Collections.emptyList();
        this.c = 0;
        this.v = 1029329178;
        this.w = k.g;
        this.x = 1034147594;
    }

    private static c b(c c) {
        int i2;
        int i;
        final c.b bVar = c.a();
        bVar.k(-8388609);
        bVar.l(Integer.MIN_VALUE);
        bVar.p(0);
        final int i9 = 0;
        int i10 = 1065353216;
        if (c.f == 0) {
            bVar.h(i10 -= i2, i9);
        } else {
            bVar.h(i8 -= i10, 1);
        }
        int obj4 = c.g;
        int i7 = 2;
        if (obj4 != null) {
            if (obj4 != i7) {
            } else {
                bVar.i(i9);
            }
        } else {
            bVar.i(i7);
        }
        return bVar.a();
    }

    public void a(List<c> list, com.google.android.exoplayer2.ui.k k2, float f3, int i4, float f5) {
        com.google.android.exoplayer2.ui.k obj2;
        float obj3;
        int obj4;
        this.b = list;
        this.w = k2;
        this.v = f3;
        this.c = i4;
        this.x = f5;
        while (this.a.size() < list.size()) {
            obj3 = new x(getContext());
            this.a.add(obj3);
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        int paddingBottom;
        Object obj;
        float paddingRight;
        com.google.android.exoplayer2.ui.k kVar;
        float f3;
        float f;
        float f4;
        int i8;
        int size;
        int i7;
        int i;
        int i2;
        float f2;
        int i3;
        int i9;
        int i5;
        int i4;
        int i6;
        final Object obj2 = this;
        final List list = obj2.b;
        if (list.isEmpty()) {
        }
        int height = getHeight();
        final int paddingLeft = getPaddingLeft();
        final int paddingTop = getPaddingTop();
        i = height - paddingBottom;
        if (i > paddingTop) {
            if (width - paddingRight <= paddingLeft) {
            } else {
                f2 = y.f(obj2.c, obj2.v, height, i - paddingTop);
                if (Float.compare(f2, i11) <= 0) {
                }
                size = list.size();
                i8 = paddingBottom;
                while (i8 < size) {
                    obj = list.get(i8);
                    if (obj.p != Integer.MIN_VALUE) {
                    }
                    paddingRight = obj;
                    i4 = i;
                    (x)obj2.a.get(i8).b(paddingRight, obj2.w, f2, y.f(paddingRight.n, paddingRight.o, height, i7), obj2.x, canvas, paddingLeft, paddingTop, i2, i4);
                    i8 = i3 + 1;
                    size = i9;
                    i7 = i5;
                    i = i4;
                    i2 = i6;
                    obj = j.b((c)obj);
                }
            }
        }
    }
}
