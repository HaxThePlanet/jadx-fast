package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import java.util.List;

/* loaded from: classes2.dex */
public class e extends RecyclerView.o {

    private static final int[] c;
    private Drawable a;
    private int b;
    static {
        int[] iArr = new int[1];
        e.c = iArr;
    }

    public e(Context context) {
        super();
        TypedArray obj2 = context.obtainStyledAttributes(e.c);
        this.a = obj2.getDrawable(0);
        obj2.recycle();
        n(3);
    }

    private void f(Canvas canvas, RecyclerView recyclerView2) {
        int i4;
        Drawable drawable;
        int right;
        int i6;
        Drawable drawable2;
        int rightMargin;
        int i7;
        int i3;
        int i;
        int i5;
        int intrinsicWidth;
        int i2;
        if (!i()) {
        }
        androidx.recyclerview.widget.RecyclerView.p layoutManager = recyclerView2.getLayoutManager();
        i4 = 0;
        while (i4 < recyclerView2.getChildCount()) {
            View childAt = recyclerView2.getChildAt(i4);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((FlexboxLayoutManager)layoutManager.f() == 3) {
            } else {
            }
            i7 = i3 - intrinsicHeight;
            if (layoutManager.w()) {
            } else {
            }
            left3 -= intrinsicWidth;
            right = childAt.getRight();
            rightMargin = layoutParams.rightMargin;
            i = i11;
            i6 = i2;
            this.a.setBounds(i6, i7, i, i3);
            this.a.draw(canvas);
            i4++;
            if (layoutManager.S2()) {
            } else {
            }
            i5 = Math.max(i15 -= intrinsicWidth, left -= paddingLeft);
            right = childAt.getRight();
            rightMargin = layoutParams.rightMargin;
            i = Math.min(i13 += intrinsicWidth, right2 += paddingRight);
            left2 -= rightMargin;
            intrinsicHeight2 += i7;
        }
    }

    private void g(Canvas canvas, RecyclerView recyclerView2) {
        int i;
        Drawable drawable;
        int bottom;
        int i6;
        Drawable drawable2;
        int bottomMargin;
        int i4;
        int i2;
        int i3;
        int intrinsicHeight;
        int i5;
        if (!j()) {
        }
        androidx.recyclerview.widget.RecyclerView.p layoutManager = recyclerView2.getLayoutManager();
        i = 0;
        while (i < recyclerView2.getChildCount()) {
            View childAt = recyclerView2.getChildAt(i);
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutManager.S2()) {
            } else {
            }
            i4 = i2 - intrinsicWidth;
            if (layoutManager.w()) {
            } else {
            }
            if ((FlexboxLayoutManager)layoutManager.f() == 3) {
            } else {
            }
            i3 = Math.max(i15 -= intrinsicHeight, top -= paddingTop);
            bottom = childAt.getBottom();
            bottomMargin = layoutParams.bottomMargin;
            bottom += bottomMargin;
            this.a.setBounds(i4, i3, i2, i6);
            this.a.draw(canvas);
            i++;
            i3 = i10;
            i6 = i5;
            top4 -= intrinsicHeight;
            bottom = childAt.getBottom();
            bottomMargin = layoutParams.bottomMargin;
            intrinsicWidth2 += i4;
        }
    }

    private boolean h(int i, List<com.google.android.flexbox.c> list2, com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager3) {
        int i2;
        int size;
        int obj6;
        int i3 = flexboxLayoutManager3.P2(i);
        i2 = 1;
        if (i3 != -1 && i3 < flexboxLayoutManager3.r().size() && obj6.k == i) {
            if (i3 < flexboxLayoutManager3.r().size()) {
                if (obj6.k == i) {
                    return i2;
                }
            }
        }
        if (i == 0) {
            return i2;
        }
        int i4 = 0;
        if (list2.size() == 0) {
            return i4;
        }
        if (obj5.l == i -= i2) {
        } else {
            i2 = i4;
        }
        return i2;
    }

    private boolean i() {
        int i;
        if (i2 &= i > 0) {
        } else {
            i = 0;
        }
        return i;
    }

    private boolean j() {
        int i;
        i = i2 &= 2 > 0 ? 1 : 0;
        return i;
    }

    private void l(Rect rect, int i2, com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager3, List<com.google.android.flexbox.c> list4) {
        int obj2;
        if (list4.size() == 0) {
        }
        if (flexboxLayoutManager3.P2(i2) == 0) {
        }
        int obj4 = 0;
        if (flexboxLayoutManager3.w()) {
            if (!i()) {
                rect.top = obj4;
                rect.bottom = obj4;
            }
            rect.top = this.a.getIntrinsicHeight();
            rect.bottom = obj4;
        } else {
            if (!j()) {
            }
            if (flexboxLayoutManager3.S2()) {
                rect.right = this.a.getIntrinsicWidth();
                rect.left = obj4;
            } else {
                rect.left = this.a.getIntrinsicWidth();
                rect.right = obj4;
            }
        }
    }

    private void m(Rect rect, int i2, com.google.android.flexbox.FlexboxLayoutManager flexboxLayoutManager3, List<com.google.android.flexbox.c> list4, int i5) {
        int obj2;
        if (h(i2, list4, flexboxLayoutManager3)) {
        }
        final int obj4 = 0;
        if (flexboxLayoutManager3.w()) {
            if (!j()) {
                rect.left = obj4;
                rect.right = obj4;
            }
            if (flexboxLayoutManager3.S2()) {
                rect.right = this.a.getIntrinsicWidth();
                rect.left = obj4;
            } else {
                rect.left = this.a.getIntrinsicWidth();
                rect.right = obj4;
            }
        } else {
            if (!i()) {
                rect.top = obj4;
                rect.bottom = obj4;
            }
            if (i5 == 3) {
                rect.bottom = this.a.getIntrinsicHeight();
                rect.top = obj4;
            } else {
                rect.top = this.a.getIntrinsicHeight();
                rect.bottom = obj4;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView3, RecyclerView.b0 recyclerView$b04) {
        boolean obj10;
        int obj8 = recyclerView3.g0(view2);
        if (obj8 == null) {
        }
        if (!i() && !j()) {
            if (!j()) {
                obj8 = 0;
                rect.set(obj8, obj8, obj8, obj8);
            }
        }
        final androidx.recyclerview.widget.RecyclerView.p obj9 = recyclerView3.getLayoutManager();
        obj10 = (FlexboxLayoutManager)obj9.O2();
        this.m(rect, obj8, obj9, obj10, obj9.f());
        l(rect, obj8, obj9, obj10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void k(Drawable drawable) {
        if (drawable == null) {
        } else {
            this.a = drawable;
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Drawable cannot be null.");
        throw obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void n(int i) {
        this.b = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDraw(Canvas canvas, RecyclerView recyclerView2, RecyclerView.b0 recyclerView$b03) {
        f(canvas, recyclerView2);
        g(canvas, recyclerView2);
    }
}
