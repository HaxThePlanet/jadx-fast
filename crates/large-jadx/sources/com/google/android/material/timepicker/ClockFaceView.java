package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.firestore.ktx.R.id;
import d.a.k.a.a;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.e0.c.b;
import d.h.l.e0.c.c;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.c;
import f.c.a.e.d;
import f.c.a.e.f;
import f.c.a.e.h;
import f.c.a.e.k;
import f.c.a.e.l;
import java.util.Arrays;

/* loaded from: classes2.dex */
class ClockFaceView extends com.google.android.material.timepicker.d implements com.google.android.material.timepicker.ClockHandView.d {

    private final com.google.android.material.timepicker.ClockHandView P;
    private final Rect Q;
    private final RectF R;
    private final SparseArray<TextView> S;
    private final a T;
    private final int[] U;
    private final float[] V;
    private final int W;
    private final int a0;
    private final int b0;
    private final int c0;
    private String[] d0;
    private float e0;
    private final ColorStateList f0;

    class a implements ViewTreeObserver.OnPreDrawListener {

        final com.google.android.material.timepicker.ClockFaceView a;
        a(com.google.android.material.timepicker.ClockFaceView clockFaceView) {
            this.a = clockFaceView;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnPreDrawListener
        public boolean onPreDraw() {
            final int i4 = 1;
            if (!this.a.isShown()) {
                return i4;
            }
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.a.x(i2 -= i6);
            return i4;
        }
    }

    class b extends a {

        final com.google.android.material.timepicker.ClockFaceView d;
        b(com.google.android.material.timepicker.ClockFaceView clockFaceView) {
            this.d = clockFaceView;
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            Object tag;
            int i;
            super.g(view, c2);
            final int intValue = (Integer)view.getTag(f.y).intValue();
            if (intValue > 0) {
                c2.v0((View)ClockFaceView.D(this.d).get(intValue + -1));
            }
            c2.a0(c.c.a(0, 1, intValue, 1, false, view.isSelected()));
        }
    }
    public ClockFaceView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.E);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet2, int i3) {
        int defaultColor;
        super(context, attributeSet2, i3);
        Rect rect = new Rect();
        this.Q = rect;
        RectF rectF = new RectF();
        this.R = rectF;
        SparseArray sparseArray = new SparseArray();
        this.S = sparseArray;
        int i = 3;
        float[] fArr = new float[i];
        fArr = new int[]{0, 1063675494, 1065353216};
        this.V = fArr;
        TypedArray obj9 = context.obtainStyledAttributes(attributeSet2, l.j1, i3, k.B);
        final Resources obj10 = getResources();
        ColorStateList list2 = c.a(context, obj9, l.l1);
        this.f0 = list2;
        final int i11 = 1;
        LayoutInflater.from(context).inflate(h.k, this, i11);
        View viewById = findViewById(f.k);
        this.P = (ClockHandView)viewById;
        this.W = obj10.getDimensionPixelSize(d.r);
        int[] iArr3 = new int[i11];
        final int i13 = 0;
        iArr3[i13] = 16842913;
        int colorForState = list2.getColorForState(iArr3, list2.getDefaultColor());
        int[] iArr = new int[i];
        iArr[i13] = colorForState;
        iArr[i11] = colorForState;
        iArr[2] = list2.getDefaultColor();
        this.U = iArr;
        viewById.b(this);
        defaultColor = a.c(context, c.g).getDefaultColor();
        ColorStateList obj8 = c.a(context, obj9, l.k1);
        if (obj8 == null) {
        } else {
            defaultColor = obj8.getDefaultColor();
        }
        setBackgroundColor(defaultColor);
        ClockFaceView.a aVar = new ClockFaceView.a(this);
        getViewTreeObserver().addOnPreDrawListener(aVar);
        setFocusable(i11);
        obj9.recycle();
        obj8 = new ClockFaceView.b(this);
        this.T = obj8;
        obj8 = new String[12];
        Arrays.fill(obj8, "");
        H(obj8, i13);
        this.a0 = obj10.getDimensionPixelSize(d.E);
        this.b0 = obj10.getDimensionPixelSize(d.F);
        this.c0 = obj10.getDimensionPixelSize(d.t);
    }

    static com.google.android.material.timepicker.ClockHandView B(com.google.android.material.timepicker.ClockFaceView clockFaceView) {
        return clockFaceView.P;
    }

    static int C(com.google.android.material.timepicker.ClockFaceView clockFaceView) {
        return clockFaceView.W;
    }

    static SparseArray D(com.google.android.material.timepicker.ClockFaceView clockFaceView) {
        return clockFaceView.S;
    }

    private void E() {
        int i;
        Object obj;
        RadialGradient radialGradient;
        TextPaint paint;
        int paddingTop;
        i = 0;
        while (i < this.S.size()) {
            obj = this.S.get(i);
            if ((TextView)obj == null) {
            } else {
            }
            (TextView)obj.getDrawingRect(this.Q);
            this.Q.offset(obj.getPaddingLeft(), obj.getPaddingTop());
            offsetDescendantRectToMyCoords(obj, this.Q);
            this.R.set(this.Q);
            obj.getPaint().setShader(F(this.P.d(), this.R));
            obj.invalidate();
            i++;
        }
    }

    private RadialGradient F(RectF rectF, RectF rectF2) {
        if (!RectF.intersects(rectF, rectF2)) {
            return null;
        }
        super(centerX - left, centerY - top, obj8 * i, this.U, this.V, Shader.TileMode.CLAMP);
        return obj9;
    }

    private static float G(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    private void I(int i) {
        int i2;
        SparseArray inflate;
        int length;
        Integer valueOf;
        String str;
        final int i3 = 0;
        i2 = i3;
        while (i2 < Math.max(strArr.length, this.S.size())) {
            inflate = this.S.get(i2);
            if (i2 >= strArr2.length) {
            } else {
            }
            if ((TextView)inflate == null) {
            }
            inflate.setVisibility(i3);
            inflate.setText(this.d0[i2]);
            inflate.setTag(f.y, Integer.valueOf(i2));
            u.l0(inflate, this.T);
            inflate.setTextColor(this.f0);
            if (i != 0) {
            }
            i2++;
            valueOf = new Object[1];
            valueOf[i3] = this.d0[i2];
            inflate.setContentDescription(getResources().getString(i, valueOf));
            inflate = LayoutInflater.from(getContext()).inflate(h.j, this, i3);
            this.S.put(i2, (TextView)inflate);
            addView(inflate);
            removeView((TextView)inflate);
            this.S.remove(i2);
        }
    }

    @Override // com.google.android.material.timepicker.d
    public void H(String[] stringArr, int i2) {
        this.d0 = stringArr;
        I(i2);
    }

    @Override // com.google.android.material.timepicker.d
    public void b(float f, boolean z2) {
        if (Float.compare(obj3, i) > 0) {
            this.e0 = f;
            E();
        }
    }

    @Override // com.google.android.material.timepicker.d
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        final int i = 1;
        c.y0(accessibilityNodeInfo).Z(c.b.a(i, strArr.length, false, i));
    }

    @Override // com.google.android.material.timepicker.d
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        E();
    }

    @Override // com.google.android.material.timepicker.d
    protected void onMeasure(int i, int i2) {
        android.util.DisplayMetrics obj3 = getResources().getDisplayMetrics();
        obj3 = (int)i4;
        int obj4 = View.MeasureSpec.makeMeasureSpec(obj3, 1073741824);
        setMeasuredDimension(obj3, obj3);
        super.onMeasure(obj4, obj4);
    }

    @Override // com.google.android.material.timepicker.d
    public void x(int i) {
        int i2;
        int obj2;
        if (i != w()) {
            super.x(i);
            this.P.k(w());
        }
    }
}
