package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class i extends androidx.recyclerview.widget.RecyclerView.o {

    private static final int[] d;
    private Drawable a;
    private int b;
    private final Rect c;
    static {
        int[] iArr = new int[1];
        i.d = iArr;
    }

    public i(Context context, int i2) {
        Object drawable;
        String str;
        super();
        Rect rect = new Rect();
        this.c = rect;
        final TypedArray obj3 = context.obtainStyledAttributes(i.d);
        drawable = obj3.getDrawable(0);
        this.a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obj3.recycle();
        h(i2);
    }

    private void f(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2) {
        int paddingTop;
        int i;
        int height;
        int paddingLeft;
        int i2;
        int paddingRight;
        Drawable drawable;
        canvas.save();
        if (recyclerView2.getClipToPadding()) {
            canvas.clipRect(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), width -= paddingRight, height2 -= paddingBottom);
        } else {
            height = recyclerView2.getHeight();
            paddingTop = i;
        }
        while (i < recyclerView2.getChildCount()) {
            View childAt = recyclerView2.getChildAt(i);
            recyclerView2.getLayoutManager().m0(childAt, this.c);
            right += round;
            this.a.setBounds(paddingRight - intrinsicWidth, paddingTop, paddingRight, height);
            this.a.draw(canvas);
            i++;
        }
        canvas.restore();
    }

    private void g(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2) {
        int paddingLeft;
        int i;
        int width;
        int paddingTop;
        int i2;
        int paddingBottom;
        Drawable drawable;
        canvas.save();
        if (recyclerView2.getClipToPadding()) {
            canvas.clipRect(recyclerView2.getPaddingLeft(), recyclerView2.getPaddingTop(), width2 -= paddingRight, height -= paddingBottom);
        } else {
            width = recyclerView2.getWidth();
            paddingLeft = i;
        }
        while (i < recyclerView2.getChildCount()) {
            View childAt = recyclerView2.getChildAt(i);
            recyclerView2.l0(childAt, this.c);
            bottom += round;
            this.a.setBounds(paddingLeft, paddingBottom - intrinsicHeight, width, paddingBottom);
            this.a.draw(canvas);
            i++;
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect rect, View view2, androidx.recyclerview.widget.RecyclerView recyclerView3, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b04) {
        int obj3;
        obj3 = this.a;
        final int obj4 = 0;
        if (obj3 == null) {
            rect.set(obj4, obj4, obj4, obj4);
        }
        if (this.b == 1) {
            rect.set(obj4, obj4, obj4, obj3.getIntrinsicHeight());
        } else {
            rect.set(obj4, obj4, obj3.getIntrinsicWidth(), obj4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void h(int i) {
        int i2;
        if (i != 0) {
            if (i != 1) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
            throw obj2;
        }
        this.b = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void onDraw(Canvas canvas, androidx.recyclerview.widget.RecyclerView recyclerView2, androidx.recyclerview.widget.RecyclerView.b0 recyclerView$b03) {
        int i;
        androidx.recyclerview.widget.RecyclerView.p obj4;
        if (recyclerView2.getLayoutManager() != null) {
            if (this.a == null) {
            } else {
                if (this.b == 1) {
                    g(canvas, recyclerView2);
                } else {
                    f(canvas, recyclerView2);
                }
            }
        }
    }
}
