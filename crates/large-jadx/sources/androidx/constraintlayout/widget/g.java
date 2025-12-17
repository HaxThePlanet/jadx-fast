package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import d.f.a.m.e;
import d.f.a.m.e.b;

/* loaded from: classes.dex */
public class g extends View {

    private int a;
    private View b;
    private int c;
    @Override // android.view.View
    public void a(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        Object bVar;
        e.b bVar2;
        int i;
        Object obj5;
        if (this.b == null) {
        }
        obj5 = getLayoutParams();
        android.view.ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        layoutParams.s0.a1(0);
        e.b fIXED = e.b.FIXED;
        if (obj5.s0.y() != fIXED) {
            obj5.s0.b1(layoutParams.s0.R());
        }
        if (obj5.s0.O() != fIXED) {
            obj5.s0.C0(layoutParams.s0.v());
        }
        layoutParams.s0.a1(8);
    }

    @Override // android.view.View
    public void b(androidx.constraintlayout.widget.ConstraintLayout constraintLayout) {
        int inEditMode;
        int i;
        View obj3;
        if (this.a == -1 && !isInEditMode()) {
            if (!isInEditMode()) {
                setVisibility(this.c);
            }
        }
        obj3 = constraintLayout.findViewById(this.a);
        this.b = obj3;
        if (obj3 != null) {
            obj3.g0 = true;
            i = 0;
            this.b.setVisibility(i);
            setVisibility(i);
        }
    }

    @Override // android.view.View
    public View getContent() {
        return this.b;
    }

    @Override // android.view.View
    public int getEmptyVisibility() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        boolean inEditMode;
        float f;
        int i;
        int i3;
        int i2;
        String str;
        int i4;
        if (isInEditMode()) {
            int i5 = 223;
            canvas.drawRGB(i5, i5, i5);
            inEditMode = new Paint();
            int i7 = 210;
            inEditMode.setARGB(255, i7, i7, i7);
            inEditMode.setTextAlign(Paint.Align.CENTER);
            int i8 = 0;
            inEditMode.setTypeface(Typeface.create(Typeface.DEFAULT, i8));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            inEditMode.setTextSize((float)height);
            inEditMode.setTextAlign(Paint.Align.LEFT);
            str = "?";
            inEditMode.getTextBounds(str, i8, 1, rect);
            i2 = 1073741824;
            canvas.drawText(str, i10 -= f6, i12 -= f, inEditMode);
        }
    }

    @Override // android.view.View
    public void setContentId(int i) {
        View view;
        int parent;
        int i2;
        int obj3;
        if (this.a == i) {
        }
        view = this.b;
        if (view != null) {
            i2 = 0;
            view.setVisibility(i2);
            layoutParams.g0 = i2;
            this.b = 0;
        }
        this.a = i;
        obj3 = (View)getParent().findViewById(i);
        if (i != -1 && obj3 != null) {
            obj3 = (View)getParent().findViewById(i);
            if (obj3 != null) {
                obj3.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setEmptyVisibility(int i) {
        this.c = i;
    }
}
