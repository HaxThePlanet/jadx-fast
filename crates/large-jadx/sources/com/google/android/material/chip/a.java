package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.a;
import androidx.core.graphics.drawable.b;
import com.google.android.material.internal.i;
import com.google.android.material.internal.i.b;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import d.a.k.a.a;
import d.h.f.a;
import d.h.j.a;
import f.c.a.e.a0.c;
import f.c.a.e.a0.d;
import f.c.a.e.b0.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.l;
import f.c.a.e.m.h;
import f.c.a.e.o.a;
import f.c.a.e.r.a;
import f.c.a.e.t.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class a extends g implements b, Drawable.Callback, i.b {

    private static final int[] b1;
    private static final ShapeDrawable c1;
    private final Paint A0 = null;
    private final Paint.FontMetrics B0;
    private final RectF C0;
    private final PointF D0;
    private final Path E0;
    private final i F0;
    private int G0;
    private int H0;
    private int I0;
    private int J0;
    private int K0;
    private int L0;
    private boolean M0;
    private int N0;
    private int O0 = 255;
    private ColorFilter P0;
    private PorterDuffColorFilter Q0;
    private ColorStateList R;
    private ColorStateList R0;
    private ColorStateList S;
    private PorterDuff.Mode S0 = 255;
    private float T;
    private int[] T0;
    private float U = -1f;
    private boolean U0;
    private ColorStateList V;
    private ColorStateList V0;
    private float W;
    private WeakReference<com.google.android.material.chip.a.a> W0;
    private ColorStateList X;
    private TextUtils.TruncateAt X0;
    private java.lang.CharSequence Y;
    private boolean Y0 = true;
    private boolean Z;
    private int Z0;
    private Drawable a0;
    private boolean a1;
    private ColorStateList b0;
    private float c0;
    private boolean d0;
    private boolean e0;
    private Drawable f0;
    private Drawable g0;
    private ColorStateList h0;
    private float i0;
    private java.lang.CharSequence j0;
    private boolean k0;
    private boolean l0;
    private Drawable m0;
    private ColorStateList n0;
    private h o0;
    private h p0;
    private float q0;
    private float r0;
    private float s0;
    private float t0;
    private float u0;
    private float v0;
    private float w0;
    private float x0;
    private final Context y0;
    private final Paint z0;

    public interface a {
        public abstract void a();
    }
    static {
        int[] iArr = new int[1];
        a.b1 = iArr;
        OvalShape ovalShape = new OvalShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        a.c1 = shapeDrawable;
    }

    private a(Context context, AttributeSet attributeSet2, int i3, int i4) {
        boolean obj2;
        TextPaint obj3;
        super(context, attributeSet2, i3, i4);
        obj3 = -1082130432;
        obj3 = new Paint(1);
        this.z0 = obj3;
        obj3 = new Paint.FontMetrics();
        this.B0 = obj3;
        obj3 = new RectF();
        this.C0 = obj3;
        obj3 = new PointF();
        this.D0 = obj3;
        obj3 = new Path();
        this.E0 = obj3;
        obj3 = 255;
        obj3 = PorterDuff.Mode.SRC_IN;
        obj3 = new WeakReference(0);
        this.W0 = obj3;
        O(context);
        this.y0 = context;
        obj3 = new i(this);
        this.F0 = obj3;
        this.Y = "";
        obj3.density = obj2.density;
        obj2 = a.b1;
        setState(obj2);
        o2(obj2);
        if (b.a) {
            a.c1.setTint(-1);
        }
    }

    private void A0(Canvas canvas, Rect rect2) {
        boolean z;
        float f;
        Paint paint;
        Object obj5;
        if (!this.a1) {
            this.z0.setColor(this.H0);
            this.z0.setStyle(Paint.Style.FILL);
            this.z0.setColorFilter(o1());
            this.C0.set(rect2);
            canvas.drawRoundRect(this.C0, L0(), L0(), this.z0);
        }
    }

    private void B0(Canvas canvas, Rect rect2) {
        boolean z;
        Drawable drawable;
        int i;
        int i3;
        int i2;
        Rect obj7;
        if (Q2()) {
            o0(rect2, this.C0);
            obj7 = this.C0;
            float left = obj7.left;
            obj7 = obj7.top;
            canvas.translate(left, obj7);
            i2 = 0;
            this.a0.setBounds(i2, i2, (int)width, (int)height);
            this.a0.draw(canvas);
            canvas.translate(-left, -obj7);
        }
    }

    private void C0(Canvas canvas, Rect rect2) {
        boolean z;
        int cmp;
        Object sTROKE;
        int i5;
        int i6;
        int i3;
        int i;
        int i2;
        int i4;
        Object obj9;
        this.z0.setColor(this.J0);
        this.z0.setStyle(Paint.Style.STROKE);
        if (Float.compare(f, i5) > 0 && !this.a1 && !this.a1) {
            if (!this.a1) {
                this.z0.setColor(this.J0);
                this.z0.setStyle(Paint.Style.STROKE);
                if (!this.a1) {
                    this.z0.setColorFilter(o1());
                }
                float f4 = this.W;
                i3 = 1073741824;
                this.C0.set(f3 += i9, f5 += i10, f6 -= i4, obj9 -= i6);
                obj9 -= i7;
                canvas.drawRoundRect(this.C0, obj9, obj9, this.z0);
            }
        }
    }

    private void D0(Canvas canvas, Rect rect2) {
        boolean z;
        float f;
        Paint paint;
        Object obj5;
        if (!this.a1) {
            this.z0.setColor(this.G0);
            this.z0.setStyle(Paint.Style.FILL);
            this.C0.set(rect2);
            canvas.drawRoundRect(this.C0, L0(), L0(), this.z0);
        }
    }

    private void E0(Canvas canvas, Rect rect2) {
        boolean z;
        Drawable drawable;
        int bounds;
        int i;
        int i2;
        Rect obj7;
        if (R2()) {
            r0(rect2, this.C0);
            obj7 = this.C0;
            float left = obj7.left;
            obj7 = obj7.top;
            canvas.translate(left, obj7);
            i2 = 0;
            this.f0.setBounds(i2, i2, (int)width, (int)height);
            if (b.a) {
                this.g0.setBounds(this.f0.getBounds());
                this.g0.jumpToCurrentState();
                this.g0.draw(canvas);
            } else {
                this.f0.draw(canvas);
            }
            canvas.translate(-left, -obj7);
        }
    }

    private void F0(Canvas canvas, Rect rect2) {
        float f2;
        float f;
        Paint paint;
        Object obj5;
        this.z0.setColor(this.K0);
        this.z0.setStyle(Paint.Style.FILL);
        this.C0.set(rect2);
        if (!this.a1) {
            canvas.drawRoundRect(this.C0, L0(), L0(), this.z0);
        } else {
            RectF rectF = new RectF(rect2);
            h(rectF, this.E0);
            super.p(canvas, this.z0, this.E0, u());
        }
    }

    private void G0(Canvas canvas, Rect rect2) {
        Paint paint2;
        boolean z2;
        java.lang.CharSequence right;
        boolean z;
        int i;
        Paint i2;
        int i3;
        Object obj;
        float f;
        float exactCenterY;
        float f2;
        float exactCenterY2;
        Paint paint;
        Object obj11;
        paint2 = this.A0;
        if (paint2 != null) {
            i3 = 127;
            paint2.setColor(a.i(-16777216, i3));
            canvas.drawRect(rect2, this.A0);
            if (!Q2()) {
                if (P2()) {
                    o0(rect2, this.C0);
                    canvas.drawRect(this.C0, this.A0);
                }
            } else {
            }
            if (this.Y != null) {
                canvas.drawLine((float)left, rect2.exactCenterY(), (float)right, rect2.exactCenterY(), this.A0);
            }
            if (R2()) {
                r0(rect2, this.C0);
                canvas.drawRect(this.C0, this.A0);
            }
            this.A0.setColor(a.i(-65536, i3));
            q0(rect2, this.C0);
            canvas.drawRect(this.C0, this.A0);
            this.A0.setColor(a.i(-16711936, i3));
            s0(rect2, this.C0);
            canvas.drawRect(this.C0, this.A0);
        }
    }

    private void H0(Canvas canvas, Rect rect2) {
        Object charSequence;
        int round;
        java.lang.CharSequence ellipsize;
        int save;
        Object obj;
        TextUtils.TruncateAt truncateAt;
        java.lang.CharSequence width;
        int i;
        int length;
        float f;
        float f2;
        TextPaint textPaint;
        Rect obj11;
        u0(rect2, this.C0);
        if (this.Y != null && this.F0.d() != null) {
            u0(rect2, this.C0);
            if (this.F0.d() != null) {
                obj11.drawableState = getState();
                this.F0.j(this.y0);
            }
            this.F0.e().setTextAlign(w0(rect2, this.D0));
            obj11 = Math.round(this.F0.f(k1().toString())) > Math.round(this.C0.width()) ? 1 : save;
            if (obj11 != null) {
                save = canvas.save();
                canvas.clipRect(this.C0);
            }
            if (obj11 != null && this.X0 != null) {
                if (this.X0 != null) {
                    ellipsize = TextUtils.ellipsize(this.Y, this.F0.e(), this.C0.width(), this.X0);
                }
            }
            width = ellipsize;
            PointF d02 = this.D0;
            canvas.drawText(width, 0, width.length(), d02.x, d02.y, this.F0.e());
            if (obj11 != null) {
                canvas.restoreToCount(save);
            }
        }
    }

    private boolean P2() {
        int i;
        boolean z;
        if (this.l0 && this.m0 != null && this.M0) {
            if (this.m0 != null) {
                i = this.M0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private boolean Q2() {
        boolean z;
        int i;
        if (this.Z && this.a0 != null) {
            i = this.a0 != null ? 1 : 0;
        } else {
        }
        return i;
    }

    private boolean R2() {
        boolean z;
        int i;
        if (this.e0 && this.f0 != null) {
            i = this.f0 != null ? 1 : 0;
        } else {
        }
        return i;
    }

    private void S2(Drawable drawable) {
        int i;
        if (drawable != null) {
            drawable.setCallback(0);
        }
    }

    private void T2() {
        ColorStateList list;
        if (this.U0) {
            list = b.d(this.X);
        } else {
            list = 0;
        }
        this.V0 = list;
    }

    private void U2() {
        RippleDrawable rippleDrawable = new RippleDrawable(b.d(i1()), this.f0, a.c1);
        this.g0 = rippleDrawable;
    }

    private float c1() {
        Drawable drawable;
        float f;
        int cmp;
        drawable = this.M0 ? this.m0 : this.a0;
        int i2 = 24;
        if (Float.compare(f, i) <= 0 && drawable != null && Float.compare(f4, f) <= 0) {
            if (drawable != null) {
                i2 = 24;
                if (Float.compare(f4, f) <= 0) {
                    return (float)intrinsicHeight;
                }
            }
        }
        return f;
    }

    private float d1() {
        Drawable drawable;
        drawable = this.M0 ? this.m0 : this.a0;
        final float f2 = this.c0;
        if (Float.compare(f2, i) <= 0 && drawable != null) {
            if (drawable != null) {
                return (float)intrinsicWidth;
            }
        }
        return f2;
    }

    private void e2(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (this.R != colorStateList) {
            this.R = colorStateList;
            onStateChange(getState());
        }
    }

    private void n0(Drawable drawable) {
        boolean stateful2;
        boolean stateful;
        int i;
        if (drawable == null) {
        }
        drawable.setCallback(this);
        a.m(drawable, a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f0 && drawable.isStateful()) {
            if (drawable.isStateful()) {
                drawable.setState(Z0());
            }
            a.o(drawable, this.h0);
        }
        Drawable drawable3 = this.a0;
        if (drawable == drawable3 && this.d0) {
            if (this.d0) {
                a.o(drawable3, this.b0);
            }
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void o0(Rect rect, RectF rectF2) {
        boolean z;
        int i2;
        int i;
        Object obj4;
        rectF2.setEmpty();
        if (!Q2()) {
            if (P2()) {
                f += f2;
                float f3 = d1();
                if (a.f(this) == 0) {
                    f4 += i3;
                    rectF2.left = i6;
                    rectF2.right = i6 += f3;
                } else {
                    f5 -= i3;
                    rectF2.right = i7;
                    rectF2.left = i7 -= f3;
                }
                z = c1();
                obj4 -= i2;
                rectF2.top = obj4;
                rectF2.bottom = obj4 += z;
            }
        } else {
        }
    }

    private ColorFilter o1() {
        Object obj;
        if (this.P0 != null) {
        } else {
            obj = this.Q0;
        }
        return obj;
    }

    private void q0(Rect rect, RectF rectF2) {
        boolean z;
        int i;
        Rect obj3;
        rectF2.set(rect);
        if (R2()) {
            i4 += f5;
            if (a.f(this) == 0) {
                rectF2.right = obj3 -= z;
            } else {
                rectF2.left = obj3 += z;
            }
        }
    }

    private static boolean q1(int[] iArr, int i2) {
        int i3;
        int i;
        final int i4 = 0;
        if (iArr == null) {
            return i4;
        }
        i3 = i4;
        while (i3 < iArr.length) {
            i3++;
        }
        return i4;
    }

    private void r0(Rect rect, RectF rectF2) {
        float f;
        boolean z;
        int i2;
        int i;
        Object obj3;
        rectF2.setEmpty();
        if (R2()) {
            f2 += f3;
            if (a.f(this) == 0) {
                f5 -= i3;
                rectF2.right = i7;
                rectF2.left = i7 -= f;
            } else {
                f4 += i3;
                rectF2.left = i5;
                rectF2.right = i5 += f;
            }
            z = this.i0;
            obj3 -= i;
            rectF2.top = obj3;
            rectF2.bottom = obj3 += z;
        }
    }

    private void s0(Rect rect, RectF rectF2) {
        boolean z;
        int i;
        float f;
        Object obj4;
        rectF2.setEmpty();
        if (R2()) {
            i4 += f6;
            if (a.f(this) == 0) {
                float f8 = (float)right;
                rectF2.right = f8;
                rectF2.left = f8 -= i5;
            } else {
                int left = rect.left;
                rectF2.left = (float)left;
                rectF2.right = f7 += i5;
            }
            rectF2.top = (float)top;
            rectF2.bottom = (float)obj4;
        }
    }

    private void u0(Rect rect, RectF rectF2) {
        int i2;
        java.lang.CharSequence charSequence;
        int i;
        int i3;
        Object obj4;
        rectF2.setEmpty();
        if (this.Y != null) {
            i4 += f4;
            i5 += f8;
            if (a.f(this) == 0) {
                rectF2.left = f10 += i2;
                rectF2.right = f2 -= i;
            } else {
                rectF2.left = f9 += i;
                rectF2.right = f6 -= i2;
            }
            rectF2.top = (float)top;
            rectF2.bottom = (float)obj4;
        }
    }

    private static boolean u1(ColorStateList colorStateList) {
        boolean obj0;
        if (colorStateList != null && colorStateList.isStateful()) {
            obj0 = colorStateList.isStateful() ? 1 : 0;
        } else {
        }
        return obj0;
    }

    private float v0() {
        this.F0.e().getFontMetrics(this.B0);
        Paint.FontMetrics b0 = this.B0;
        return i2 /= i;
    }

    private static boolean v1(Drawable drawable) {
        boolean obj0;
        if (drawable != null && drawable.isStateful()) {
            obj0 = drawable.isStateful() ? 1 : 0;
        } else {
        }
        return obj0;
    }

    private static boolean w1(d d) {
        ColorStateList list;
        int obj1;
        if (d && d.i() != null && d.i().isStateful()) {
            if (d.i() != null) {
                obj1 = d.i().isStateful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    private boolean x0() {
        int i;
        boolean z;
        if (this.l0 && this.m0 != null && this.k0) {
            if (this.m0 != null) {
                i = this.k0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void x1(AttributeSet attributeSet, int i2, int i3) {
        int attributeValue2;
        int i;
        boolean attributeValue;
        boolean attributeValue3;
        boolean value;
        String obj8;
        int obj10;
        final int i16 = 0;
        final TypedArray obj9 = l.h(this.y0, attributeSet, l.h0, i2, i3, new int[i16]);
        this.a1 = obj9.hasValue(l.T0);
        e2(c.a(this.y0, obj9, l.G0));
        I1(c.a(this.y0, obj9, l.t0));
        int i5 = 0;
        W1(obj9.getDimension(l.B0, i5));
        obj10 = l.u0;
        if (obj9.hasValue(obj10)) {
            K1(obj9.getDimension(obj10, i5));
        }
        a2(c.a(this.y0, obj9, l.E0));
        c2(obj9.getDimension(l.F0, i5));
        B2(c.a(this.y0, obj9, l.S0));
        G2(obj9.getText(l.n0));
        obj10 = c.f(this.y0, obj9, l.i0);
        obj10.l(obj9.getDimension(l.j0, obj10.j()));
        H2(obj10);
        obj10 = obj9.getInt(l.l0, i16);
        if (obj10 != 1) {
            if (obj10 != 2) {
                if (obj10 != 3) {
                } else {
                    t2(TextUtils.TruncateAt.END);
                }
            } else {
                t2(TextUtils.TruncateAt.MIDDLE);
            }
        } else {
            t2(TextUtils.TruncateAt.START);
        }
        V1(obj9.getBoolean(l.A0, i16));
        obj10 = "http://schemas.android.com/apk/res-auto";
        if (attributeSet != null && attributeSet.getAttributeValue(obj10, "chipIconEnabled") != null && attributeSet.getAttributeValue(obj10, "chipIconVisible") == null) {
            if (attributeSet.getAttributeValue(obj10, "chipIconEnabled") != null) {
                if (attributeSet.getAttributeValue(obj10, "chipIconVisible") == null) {
                    V1(obj9.getBoolean(l.x0, i16));
                }
            }
        }
        O1(c.d(this.y0, obj9, l.w0));
        i = l.z0;
        if (obj9.hasValue(i)) {
            S1(c.a(this.y0, obj9, i));
        }
        Q1(obj9.getDimension(l.y0, -1082130432));
        r2(obj9.getBoolean(l.N0, i16));
        if (attributeSet != null && attributeSet.getAttributeValue(obj10, "closeIconEnabled") != null && attributeSet.getAttributeValue(obj10, "closeIconVisible") == null) {
            if (attributeSet.getAttributeValue(obj10, "closeIconEnabled") != null) {
                if (attributeSet.getAttributeValue(obj10, "closeIconVisible") == null) {
                    r2(obj9.getBoolean(l.I0, i16));
                }
            }
        }
        f2(c.d(this.y0, obj9, l.H0));
        p2(c.a(this.y0, obj9, l.M0));
        k2(obj9.getDimension(l.K0, i5));
        A1(obj9.getBoolean(l.o0, i16));
        H1(obj9.getBoolean(l.s0, i16));
        if (attributeSet != null && attributeSet.getAttributeValue(obj10, "checkedIconEnabled") != null && attributeSet.getAttributeValue(obj10, "checkedIconVisible") == null) {
            if (attributeSet.getAttributeValue(obj10, "checkedIconEnabled") != null) {
                if (attributeSet.getAttributeValue(obj10, "checkedIconVisible") == null) {
                    H1(obj9.getBoolean(l.q0, i16));
                }
            }
        }
        C1(c.d(this.y0, obj9, l.p0));
        obj8 = l.r0;
        if (obj9.hasValue(obj8)) {
            E1(c.a(this.y0, obj9, obj8));
        }
        E2(h.b(this.y0, obj9, l.U0));
        u2(h.b(this.y0, obj9, l.P0));
        Y1(obj9.getDimension(l.D0, i5));
        y2(obj9.getDimension(l.R0, i5));
        w2(obj9.getDimension(l.Q0, i5));
        L2(obj9.getDimension(l.W0, i5));
        J2(obj9.getDimension(l.V0, i5));
        m2(obj9.getDimension(l.L0, i5));
        h2(obj9.getDimension(l.J0, i5));
        M1(obj9.getDimension(l.v0, i5));
        A2(obj9.getDimensionPixelSize(l.m0, Integer.MAX_VALUE));
        obj9.recycle();
    }

    public static com.google.android.material.chip.a y0(Context context, AttributeSet attributeSet2, int i3, int i4) {
        a aVar = new a(context, attributeSet2, i3, i4);
        aVar.x1(attributeSet2, i3, i4);
        return aVar;
    }

    private void z0(Canvas canvas, Rect rect2) {
        boolean z;
        Drawable drawable;
        int i2;
        int i3;
        int i;
        Rect obj7;
        if (P2()) {
            o0(rect2, this.C0);
            obj7 = this.C0;
            float left = obj7.left;
            obj7 = obj7.top;
            canvas.translate(left, obj7);
            i = 0;
            this.m0.setBounds(i, i, (int)width, (int)height);
            this.m0.draw(canvas);
            canvas.translate(-left, -obj7);
        }
    }

    private boolean z1(int[] iArr, int[] i2Arr2) {
        boolean onStateChange;
        boolean state;
        boolean state2;
        boolean iArr2;
        int colorForState;
        int colorForState3;
        int colorForState2;
        int colorForState5;
        int i;
        int i9;
        boolean z2;
        Object dVar;
        ColorStateList z;
        int i6;
        int colorForState4;
        int i2;
        int i7;
        int i4;
        int i5;
        Drawable drawable;
        int colorForState6;
        int i8;
        int i10;
        int i3;
        int[] obj7;
        onStateChange = super.onStateChange(iArr);
        ColorStateList list = this.R;
        final int i14 = 0;
        if (list != null) {
            colorForState = list.getColorForState(iArr, this.G0);
        } else {
            colorForState = i14;
        }
        int i12 = l(colorForState);
        i8 = 1;
        if (this.G0 != i12) {
            this.G0 = i12;
            onStateChange = i8;
        }
        ColorStateList list4 = this.S;
        if (list4 != null) {
            colorForState4 = list4.getColorForState(iArr, this.H0);
        } else {
            colorForState4 = i14;
        }
        int i15 = l(colorForState4);
        if (this.H0 != i15) {
            this.H0 = i15;
            onStateChange = i8;
        }
        int i13 = a.g(i12, i15);
        i2 = this.I0 != i13 ? i8 : i14;
        i3 = x() == null ? i8 : i14;
        if (i2 |= i3 != 0) {
            this.I0 = i13;
            Z(ColorStateList.valueOf(i13));
            onStateChange = i8;
        }
        ColorStateList list2 = this.V;
        if (list2 != null) {
            colorForState3 = list2.getColorForState(iArr, this.J0);
        } else {
            colorForState3 = i14;
        }
        if (this.J0 != colorForState3) {
            this.J0 = colorForState3;
            onStateChange = i8;
        }
        if (this.V0 != null && b.e(iArr)) {
            if (b.e(iArr)) {
                colorForState2 = this.V0.getColorForState(iArr, this.K0);
            } else {
                colorForState2 = i14;
            }
        } else {
        }
        this.K0 = colorForState2;
        if (this.K0 != colorForState2 && this.U0) {
            this.K0 = colorForState2;
            if (this.U0) {
                onStateChange = i8;
            }
        }
        if (this.F0.d() != null && this.F0.d().i() != null) {
            if (this.F0.d().i() != null) {
                colorForState5 = this.F0.d().i().getColorForState(iArr, this.L0);
            } else {
                colorForState5 = i14;
            }
        } else {
        }
        if (this.L0 != colorForState5) {
            this.L0 = colorForState5;
            onStateChange = i8;
        }
        if (a.q1(getState(), 16842912) && this.k0) {
            i = this.k0 ? i8 : i14;
        } else {
        }
        if (this.M0 != i && this.m0 != null) {
            if (this.m0 != null) {
                this.M0 = i;
                if (Float.compare(f, f2) != 0) {
                    i9 = onStateChange;
                } else {
                    i9 = i14;
                    onStateChange = i8;
                }
            } else {
                i9 = i14;
            }
        } else {
        }
        ColorStateList r02 = this.R0;
        if (r02 != null) {
            colorForState6 = r02.getColorForState(iArr, this.N0);
        } else {
            colorForState6 = i14;
        }
        if (this.N0 != colorForState6) {
            this.N0 = colorForState6;
            this.Q0 = a.a(this, this.R0, this.S0);
        } else {
            i8 = onStateChange;
        }
        if (a.v1(this.a0)) {
            i8 |= state;
        }
        if (a.v1(this.m0)) {
            i8 |= state2;
        }
        if (a.v1(this.f0)) {
            iArr2 = new int[length += length2];
            System.arraycopy(iArr, i14, iArr2, i14, iArr.length);
            System.arraycopy(i2Arr2, i14, iArr2, iArr.length, i2Arr2.length);
            i8 |= obj7;
        }
        if (b.a && a.v1(this.g0)) {
            if (a.v1(this.g0)) {
                i8 |= obj7;
            }
        }
        if (i8 != 0) {
            invalidateSelf();
        }
        if (i9 != 0) {
            y1();
        }
        return i8;
    }

    @Override // f.c.a.e.d0.g
    public void A1(boolean z) {
        boolean z2;
        boolean obj2;
        this.k0 = z;
        if (this.k0 != z && !z && this.M0) {
            this.k0 = z;
            if (!z) {
                if (this.M0) {
                    this.M0 = false;
                }
            }
            invalidateSelf();
            if (Float.compare(z2, obj2) != 0) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public void A2(int i) {
        this.Z0 = i;
    }

    @Override // f.c.a.e.d0.g
    public void B1(int i) {
        A1(this.y0.getResources().getBoolean(i));
    }

    @Override // f.c.a.e.d0.g
    public void B2(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (this.X != colorStateList) {
            this.X = colorStateList;
            T2();
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public void C1(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3;
        Drawable obj3;
        this.m0 = drawable;
        S2(this.m0);
        n0(this.m0);
        invalidateSelf();
        if (this.m0 != drawable && Float.compare(drawable2, obj3) != 0) {
            this.m0 = drawable;
            S2(this.m0);
            n0(this.m0);
            invalidateSelf();
            if (Float.compare(drawable2, obj3) != 0) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public void C2(int i) {
        B2(a.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public void D1(int i) {
        C1(a.d(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    void D2(boolean z) {
        this.Y0 = z;
    }

    @Override // f.c.a.e.d0.g
    public void E1(ColorStateList colorStateList) {
        boolean list;
        ColorStateList obj2;
        this.n0 = colorStateList;
        if (this.n0 != colorStateList && x0()) {
            this.n0 = colorStateList;
            if (x0()) {
                a.o(this.m0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public void E2(h h) {
        this.o0 = h;
    }

    @Override // f.c.a.e.d0.g
    public void F1(int i) {
        E1(a.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public void F2(int i) {
        E2(h.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public void G1(int i) {
        H1(this.y0.getResources().getBoolean(i));
    }

    @Override // f.c.a.e.d0.g
    public void G2(java.lang.CharSequence charSequence) {
        boolean equals;
        String obj2;
        if (charSequence == null) {
            obj2 = "";
        }
        if (!TextUtils.equals(this.Y, obj2)) {
            this.Y = obj2;
            this.F0.i(true);
            invalidateSelf();
            y1();
        }
    }

    @Override // f.c.a.e.d0.g
    public void H1(boolean z) {
        boolean z2;
        boolean obj2;
        if (this.l0 != z) {
            this.l0 = z;
            obj2 = P2();
            z2 = P2() != obj2 ? 1 : 0;
            if (z2 != 0) {
                if (obj2 != null) {
                    n0(this.m0);
                } else {
                    S2(this.m0);
                }
                invalidateSelf();
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public void H2(d d) {
        this.F0.h(d, this.y0);
    }

    @Override // f.c.a.e.d0.g
    public Drawable I0() {
        return this.m0;
    }

    @Override // f.c.a.e.d0.g
    public void I1(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (this.S != colorStateList) {
            this.S = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public void I2(int i) {
        d dVar = new d(this.y0, i);
        H2(dVar);
    }

    @Override // f.c.a.e.d0.g
    public ColorStateList J0() {
        return this.n0;
    }

    @Override // f.c.a.e.d0.g
    public void J1(int i) {
        I1(a.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public void J2(float f) {
        if (Float.compare(f2, f) != 0) {
            this.u0 = f;
            invalidateSelf();
            y1();
        }
    }

    @Override // f.c.a.e.d0.g
    public ColorStateList K0() {
        return this.S;
    }

    @Deprecated
    public void K1(float f) {
        int cmp;
        float obj2;
        if (Float.compare(f2, f) != 0) {
            this.U = f;
            setShapeAppearanceModel(E().w(f));
        }
    }

    @Override // f.c.a.e.d0.g
    public void K2(int i) {
        J2(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public float L0() {
        float f;
        if (this.a1) {
            f = H();
        } else {
            f = this.U;
        }
        return f;
    }

    @Deprecated
    public void L1(int i) {
        K1(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public void L2(float f) {
        if (Float.compare(f2, f) != 0) {
            this.t0 = f;
            invalidateSelf();
            y1();
        }
    }

    @Override // f.c.a.e.d0.g
    public float M0() {
        return this.x0;
    }

    @Override // f.c.a.e.d0.g
    public void M1(float f) {
        if (Float.compare(f2, f) != 0) {
            this.x0 = f;
            invalidateSelf();
            y1();
        }
    }

    @Override // f.c.a.e.d0.g
    public void M2(int i) {
        L2(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public Drawable N0() {
        Drawable drawable;
        Drawable drawable2 = this.a0;
        if (drawable2 != null) {
            drawable = a.q(drawable2);
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // f.c.a.e.d0.g
    public void N1(int i) {
        M1(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public void N2(boolean z) {
        boolean obj2;
        if (this.U0 != z) {
            this.U0 = z;
            T2();
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public float O0() {
        return this.c0;
    }

    @Override // f.c.a.e.d0.g
    public void O1(Drawable drawable) {
        boolean drawable2;
        float f;
        int obj3;
        drawable2 = N0();
        if (drawable2 != drawable) {
            if (drawable != null) {
                obj3 = a.r(drawable).mutate();
            } else {
                obj3 = 0;
            }
            this.a0 = obj3;
            S2(drawable2);
            if (Q2()) {
                n0(this.a0);
            }
            invalidateSelf();
            if (Float.compare(f, obj3) != 0) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    boolean O2() {
        return this.Y0;
    }

    @Override // f.c.a.e.d0.g
    public ColorStateList P0() {
        return this.b0;
    }

    @Override // f.c.a.e.d0.g
    public void P1(int i) {
        O1(a.d(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public float Q0() {
        return this.T;
    }

    @Override // f.c.a.e.d0.g
    public void Q1(float f) {
        int cmp;
        float obj2;
        this.c0 = f;
        invalidateSelf();
        if (Float.compare(f2, f) != 0 && Float.compare(cmp, obj2) != 0) {
            this.c0 = f;
            invalidateSelf();
            if (Float.compare(cmp, obj2) != 0) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public float R0() {
        return this.q0;
    }

    @Override // f.c.a.e.d0.g
    public void R1(int i) {
        Q1(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public ColorStateList S0() {
        return this.V;
    }

    @Override // f.c.a.e.d0.g
    public void S1(ColorStateList colorStateList) {
        boolean list;
        ColorStateList obj2;
        this.d0 = true;
        this.b0 = colorStateList;
        if (this.b0 != colorStateList && Q2()) {
            this.b0 = colorStateList;
            if (Q2()) {
                a.o(this.a0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public float T0() {
        return this.W;
    }

    @Override // f.c.a.e.d0.g
    public void T1(int i) {
        S1(a.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public Drawable U0() {
        Drawable drawable;
        Drawable drawable2 = this.f0;
        if (drawable2 != null) {
            drawable = a.q(drawable2);
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // f.c.a.e.d0.g
    public void U1(int i) {
        V1(this.y0.getResources().getBoolean(i));
    }

    @Override // f.c.a.e.d0.g
    public java.lang.CharSequence V0() {
        return this.j0;
    }

    @Override // f.c.a.e.d0.g
    public void V1(boolean z) {
        boolean z2;
        boolean obj2;
        if (this.Z != z) {
            this.Z = z;
            obj2 = Q2();
            z2 = Q2() != obj2 ? 1 : 0;
            if (z2 != 0) {
                if (obj2 != null) {
                    n0(this.a0);
                } else {
                    S2(this.a0);
                }
                invalidateSelf();
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public float W0() {
        return this.w0;
    }

    @Override // f.c.a.e.d0.g
    public void W1(float f) {
        if (Float.compare(f2, f) != 0) {
            this.T = f;
            invalidateSelf();
            y1();
        }
    }

    @Override // f.c.a.e.d0.g
    public float X0() {
        return this.i0;
    }

    @Override // f.c.a.e.d0.g
    public void X1(int i) {
        W1(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public float Y0() {
        return this.v0;
    }

    @Override // f.c.a.e.d0.g
    public void Y1(float f) {
        if (Float.compare(f2, f) != 0) {
            this.q0 = f;
            invalidateSelf();
            y1();
        }
    }

    @Override // f.c.a.e.d0.g
    public int[] Z0() {
        return this.T0;
    }

    @Override // f.c.a.e.d0.g
    public void Z1(int i) {
        Y1(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public void a() {
        y1();
        invalidateSelf();
    }

    @Override // f.c.a.e.d0.g
    public ColorStateList a1() {
        return this.h0;
    }

    @Override // f.c.a.e.d0.g
    public void a2(ColorStateList colorStateList) {
        ColorStateList list;
        ColorStateList obj2;
        this.V = colorStateList;
        if (this.V != colorStateList && this.a1) {
            this.V = colorStateList;
            if (this.a1) {
                i0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public void b1(RectF rectF) {
        s0(getBounds(), rectF);
    }

    @Override // f.c.a.e.d0.g
    public void b2(int i) {
        a2(a.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public void c2(float f) {
        int cmp;
        this.W = f;
        this.z0.setStrokeWidth(f);
        if (Float.compare(f2, f) != 0 && this.a1) {
            this.W = f;
            this.z0.setStrokeWidth(f);
            if (this.a1) {
                super.j0(f);
            }
            invalidateSelf();
        }
    }

    @Override // f.c.a.e.d0.g
    public void d2(int i) {
        c2(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public void draw(Canvas canvas) {
        Rect bounds;
        boolean empty;
        boolean z;
        float f3;
        float f;
        float f2;
        float f4;
        int i2;
        int i;
        bounds = getBounds();
        if (!bounds.isEmpty()) {
            if (getAlpha() == 0) {
            } else {
                empty = 0;
                i2 = this.O0;
                i = 255;
                if (i2 < i) {
                    empty = a.a(canvas, (float)left, (float)top, (float)right, (float)bottom, i2);
                }
                D0(canvas, bounds);
                A0(canvas, bounds);
                if (this.a1) {
                    super.draw(canvas);
                }
                C0(canvas, bounds);
                F0(canvas, bounds);
                B0(canvas, bounds);
                z0(canvas, bounds);
                if (this.Y0) {
                    H0(canvas, bounds);
                }
                E0(canvas, bounds);
                G0(canvas, bounds);
                if (this.O0 < i) {
                    canvas.restoreToCount(empty);
                }
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public TextUtils.TruncateAt e1() {
        return this.X0;
    }

    @Override // f.c.a.e.d0.g
    public h f1() {
        return this.p0;
    }

    @Override // f.c.a.e.d0.g
    public void f2(Drawable drawable) {
        Drawable drawable2;
        float f;
        Drawable obj3;
        drawable2 = U0();
        if (drawable2 != drawable) {
            if (drawable != null) {
                obj3 = a.r(drawable).mutate();
            } else {
                obj3 = 0;
            }
            this.f0 = obj3;
            if (b.a) {
                U2();
            }
            S2(drawable2);
            if (R2()) {
                n0(this.f0);
            }
            invalidateSelf();
            if (Float.compare(f, obj3) != 0) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public float g1() {
        return this.s0;
    }

    @Override // f.c.a.e.d0.g
    public void g2(java.lang.CharSequence charSequence) {
        Object charSequence2;
        java.lang.CharSequence obj2;
        if (this.j0 != charSequence) {
            this.j0 = a.c().h(charSequence);
            invalidateSelf();
        }
    }

    @Override // f.c.a.e.d0.g
    public int getAlpha() {
        return this.O0;
    }

    @Override // f.c.a.e.d0.g
    public ColorFilter getColorFilter() {
        return this.P0;
    }

    @Override // f.c.a.e.d0.g
    public int getIntrinsicHeight() {
        return (int)f;
    }

    @Override // f.c.a.e.d0.g
    public int getIntrinsicWidth() {
        return Math.min(Math.round(i5 += f7), this.Z0);
    }

    @Override // f.c.a.e.d0.g
    public int getOpacity() {
        return -3;
    }

    @Override // f.c.a.e.d0.g
    public void getOutline(Outline outline) {
        float empty;
        Outline outline2;
        int i;
        int i2;
        int intrinsicWidth;
        int intrinsicHeight;
        float f;
        if (this.a1) {
            super.getOutline(outline);
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.U);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.U);
        }
        outline.setAlpha(f2 /= i4);
    }

    @Override // f.c.a.e.d0.g
    public float h1() {
        return this.r0;
    }

    @Override // f.c.a.e.d0.g
    public void h2(float f) {
        float obj2;
        this.w0 = f;
        invalidateSelf();
        if (Float.compare(f2, f) != 0 && R2()) {
            this.w0 = f;
            invalidateSelf();
            if (R2()) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public ColorStateList i1() {
        return this.X;
    }

    @Override // f.c.a.e.d0.g
    public void i2(int i) {
        h2(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public void invalidateDrawable(Drawable drawable) {
        final Drawable.Callback obj1 = getCallback();
        if (obj1 != null) {
            obj1.invalidateDrawable(this);
        }
    }

    @Override // f.c.a.e.d0.g
    public boolean isStateful() {
        int i;
        boolean z;
        if (!a.u1(this.R) && !a.u1(this.S) && !a.u1(this.V)) {
            if (!a.u1(this.S)) {
                if (!a.u1(this.V)) {
                    if (this.U0) {
                        if (!a.u1(this.V0) && !a.w1(this.F0.d()) && !x0() && !a.v1(this.a0) && !a.v1(this.m0)) {
                            if (!a.w1(this.F0.d())) {
                                if (!x0()) {
                                    if (!a.v1(this.a0)) {
                                        if (!a.v1(this.m0)) {
                                            if (a.u1(this.R0)) {
                                                i = 1;
                                            } else {
                                                i = 0;
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // f.c.a.e.d0.g
    public h j1() {
        return this.o0;
    }

    @Override // f.c.a.e.d0.g
    public void j2(int i) {
        f2(a.d(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public java.lang.CharSequence k1() {
        return this.Y;
    }

    @Override // f.c.a.e.d0.g
    public void k2(float f) {
        float obj2;
        this.i0 = f;
        invalidateSelf();
        if (Float.compare(f2, f) != 0 && R2()) {
            this.i0 = f;
            invalidateSelf();
            if (R2()) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public d l1() {
        return this.F0.d();
    }

    @Override // f.c.a.e.d0.g
    public void l2(int i) {
        k2(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public float m1() {
        return this.u0;
    }

    @Override // f.c.a.e.d0.g
    public void m2(float f) {
        float obj2;
        this.v0 = f;
        invalidateSelf();
        if (Float.compare(f2, f) != 0 && R2()) {
            this.v0 = f;
            invalidateSelf();
            if (R2()) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public float n1() {
        return this.t0;
    }

    @Override // f.c.a.e.d0.g
    public void n2(int i) {
        m2(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    public boolean o2(int[] iArr) {
        boolean equals;
        this.T0 = iArr;
        if (!Arrays.equals(this.T0, iArr) && R2()) {
            this.T0 = iArr;
            if (R2()) {
                return z1(getState(), iArr);
            }
        }
        return 0;
    }

    @Override // f.c.a.e.d0.g
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged;
        boolean z2;
        boolean z3;
        boolean z;
        int obj3;
        if (Q2()) {
            onLayoutDirectionChanged |= z2;
        }
        if (P2()) {
            onLayoutDirectionChanged |= z3;
        }
        if (R2()) {
            onLayoutDirectionChanged |= obj3;
        }
        if (onLayoutDirectionChanged) {
            invalidateSelf();
        }
        return 1;
    }

    @Override // f.c.a.e.d0.g
    protected boolean onLevelChange(int i) {
        boolean onLevelChange;
        boolean level;
        boolean level2;
        boolean z;
        int obj3;
        if (Q2()) {
            onLevelChange |= level;
        }
        if (P2()) {
            onLevelChange |= level2;
        }
        if (R2()) {
            onLevelChange |= obj3;
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // f.c.a.e.d0.g
    public boolean onStateChange(int[] iArr) {
        if (this.a1) {
            super.onStateChange(iArr);
        }
        return z1(iArr, Z0());
    }

    @Override // f.c.a.e.d0.g
    float p0() {
        boolean z;
        if (!Q2() && P2()) {
            if (P2()) {
            }
            return 0;
        }
        return i2 += f3;
    }

    @Override // f.c.a.e.d0.g
    public boolean p1() {
        return this.U0;
    }

    @Override // f.c.a.e.d0.g
    public void p2(ColorStateList colorStateList) {
        boolean list;
        ColorStateList obj2;
        this.h0 = colorStateList;
        if (this.h0 != colorStateList && R2()) {
            this.h0 = colorStateList;
            if (R2()) {
                a.o(this.f0, colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public void q2(int i) {
        p2(a.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    public boolean r1() {
        return this.k0;
    }

    @Override // f.c.a.e.d0.g
    public void r2(boolean z) {
        boolean z2;
        boolean obj2;
        if (this.e0 != z) {
            this.e0 = z;
            obj2 = R2();
            z2 = R2() != obj2 ? 1 : 0;
            if (z2 != 0) {
                if (obj2 != null) {
                    n0(this.f0);
                } else {
                    S2(this.f0);
                }
                invalidateSelf();
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public boolean s1() {
        return a.v1(this.f0);
    }

    @Override // f.c.a.e.d0.g
    public void s2(com.google.android.material.chip.a.a a$a) {
        WeakReference weakReference = new WeakReference(a);
        this.W0 = weakReference;
    }

    @Override // f.c.a.e.d0.g
    public void scheduleDrawable(Drawable drawable, Runnable runnable2, long l3) {
        final Drawable.Callback obj1 = getCallback();
        if (obj1 != null) {
            obj1.scheduleDrawable(this, runnable2, l3);
        }
    }

    @Override // f.c.a.e.d0.g
    public void setAlpha(int i) {
        if (this.O0 != i) {
            this.O0 = i;
            invalidateSelf();
        }
    }

    @Override // f.c.a.e.d0.g
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.P0 != colorFilter) {
            this.P0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // f.c.a.e.d0.g
    public void setTintList(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (this.R0 != colorStateList) {
            this.R0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // f.c.a.e.d0.g
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        Object obj;
        Object obj2;
        if (this.S0 != mode) {
            this.S0 = mode;
            this.Q0 = a.a(this, this.R0, mode);
            invalidateSelf();
        }
    }

    @Override // f.c.a.e.d0.g
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible2;
        boolean visible3;
        boolean visible;
        boolean z3;
        boolean obj3;
        if (Q2()) {
            visible2 |= visible3;
        }
        if (P2()) {
            visible2 |= visible;
        }
        if (R2()) {
            visible2 |= obj3;
        }
        if (visible2) {
            invalidateSelf();
        }
        return visible2;
    }

    @Override // f.c.a.e.d0.g
    float t0() {
        if (R2()) {
            return i += f3;
        }
        return 0;
    }

    @Override // f.c.a.e.d0.g
    public boolean t1() {
        return this.e0;
    }

    @Override // f.c.a.e.d0.g
    public void t2(TextUtils.TruncateAt textUtils$TruncateAt) {
        this.X0 = truncateAt;
    }

    @Override // f.c.a.e.d0.g
    public void u2(h h) {
        this.p0 = h;
    }

    @Override // f.c.a.e.d0.g
    public void unscheduleDrawable(Drawable drawable, Runnable runnable2) {
        final Drawable.Callback obj1 = getCallback();
        if (obj1 != null) {
            obj1.unscheduleDrawable(this, runnable2);
        }
    }

    @Override // f.c.a.e.d0.g
    public void v2(int i) {
        u2(h.c(this.y0, i));
    }

    @Override // f.c.a.e.d0.g
    Paint.Align w0(Rect rect, PointF pointF2) {
        Paint.Align rIGHT;
        int i;
        java.lang.CharSequence charSequence;
        Object obj3;
        int i2 = 0;
        pointF2.set(i2, i2);
        rIGHT = Paint.Align.LEFT;
        if (this.Y != null) {
            i3 += f3;
            if (a.f(this) == 0) {
                pointF2.x = f5 += i4;
                rIGHT = Paint.Align.LEFT;
            } else {
                pointF2.x = f4 -= i4;
                rIGHT = Paint.Align.RIGHT;
            }
            pointF2.y = obj3 -= charSequence;
        }
        return rIGHT;
    }

    @Override // f.c.a.e.d0.g
    public void w2(float f) {
        int cmp;
        float obj2;
        this.s0 = f;
        invalidateSelf();
        if (Float.compare(f2, f) != 0 && Float.compare(cmp, obj2) != 0) {
            this.s0 = f;
            invalidateSelf();
            if (Float.compare(cmp, obj2) != 0) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public void x2(int i) {
        w2(this.y0.getResources().getDimension(i));
    }

    @Override // f.c.a.e.d0.g
    protected void y1() {
        Object obj = this.W0.get();
        if ((a.a)obj != null) {
            (a.a)obj.a();
        }
    }

    @Override // f.c.a.e.d0.g
    public void y2(float f) {
        int cmp;
        float obj2;
        this.r0 = f;
        invalidateSelf();
        if (Float.compare(f2, f) != 0 && Float.compare(cmp, obj2) != 0) {
            this.r0 = f;
            invalidateSelf();
            if (Float.compare(cmp, obj2) != 0) {
                y1();
            }
        }
    }

    @Override // f.c.a.e.d0.g
    public void z2(int i) {
        y2(this.y0.getResources().getDimension(i));
    }
}
