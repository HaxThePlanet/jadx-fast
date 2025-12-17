package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.google.android.material.internal.c;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.theme.a.a;
import d.h.l.e0.c;
import d.h.l.e0.c.a;
import d.h.l.e0.c.c;
import d.h.l.u;
import d.j.b.a;
import f.c.a.e.a0.c;
import f.c.a.e.a0.d;
import f.c.a.e.a0.f;
import f.c.a.e.b;
import f.c.a.e.b0.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.d0.k;
import f.c.a.e.d0.n;
import f.c.a.e.j;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.m.h;
import java.util.List;

/* loaded from: classes2.dex */
public class Chip extends AppCompatCheckBox implements com.google.android.material.chip.a.a, n {

    private static final int M;
    private static final Rect N;
    private static final int[] O;
    private static final int[] P;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private final com.google.android.material.chip.Chip.c H;
    private boolean I;
    private final Rect J;
    private final RectF K;
    private final f L;
    private com.google.android.material.chip.a v;
    private InsetDrawable w;
    private RippleDrawable x;
    private View.OnClickListener y;
    private CompoundButton.OnCheckedChangeListener z;

    class b extends ViewOutlineProvider {

        final com.google.android.material.chip.Chip a;
        b(com.google.android.material.chip.Chip chip) {
            this.a = chip;
            super();
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline2) {
            com.google.android.material.chip.a obj1;
            if (Chip.b(this.a) != null) {
                Chip.b(this.a).getOutline(outline2);
            } else {
                outline2.setAlpha(0);
            }
        }
    }

    class a extends f {

        final com.google.android.material.chip.Chip a;
        a(com.google.android.material.chip.Chip chip) {
            this.a = chip;
            super();
        }

        @Override // f.c.a.e.a0.f
        public void a(int i) {
        }

        @Override // f.c.a.e.a0.f
        public void b(Typeface typeface, boolean z2) {
            java.lang.CharSequence obj2;
            com.google.android.material.chip.Chip obj1 = this.a;
            if (Chip.b(obj1).O2()) {
                obj2 = Chip.b(this.a).k1();
            } else {
                obj2 = this.a.getText();
            }
            obj1.setText(obj2);
            this.a.requestLayout();
            this.a.invalidate();
        }
    }

    private class c extends a {

        final com.google.android.material.chip.Chip q;
        c(com.google.android.material.chip.Chip chip, com.google.android.material.chip.Chip chip2) {
            this.q = chip;
            super(chip2);
        }

        @Override // d.j.b.a
        protected int B(float f, float f2) {
            boolean z;
            float obj2;
            if (Chip.c(this.q) && Chip.d(this.q).contains(f, f2)) {
                obj2 = Chip.d(this.q).contains(f, f2) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        protected void C(List<Integer> list) {
            boolean valueOf;
            list.add(0);
            if (Chip.c(this.q) && this.q.r() && Chip.e(this.q) != null) {
                if (this.q.r()) {
                    if (Chip.e(this.q) != null) {
                        list.add(1);
                    }
                }
            }
        }

        @Override // d.j.b.a
        protected boolean J(int i, int i2, Bundle bundle3) {
            int obj2;
            if (i2 == 16 && i == 0) {
                if (i == 0) {
                    return this.q.performClick();
                }
                if (i == 1) {
                    return this.q.s();
                }
            }
            return 0;
        }

        @Override // d.j.b.a
        protected void M(c c) {
            c.V(this.q.q());
            c.Y(this.q.isClickable());
            c.X(this.q.getAccessibilityClassName());
            java.lang.CharSequence text = this.q.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                c.u0(text);
            } else {
                c.b0(text);
            }
        }

        @Override // d.j.b.a
        protected void N(int i, c c2) {
            Object str;
            Object[] arr;
            Context context;
            int i2;
            int i3;
            boolean empty;
            Object obj7;
            arr = 1;
            if (i == arr) {
                obj7 = this.q.getCloseIconContentDescription();
                if (obj7 != null) {
                    c2.b0(obj7);
                } else {
                    obj7 = this.q.getText();
                    arr = new Object[arr];
                    if (!TextUtils.isEmpty(obj7)) {
                        str = obj7;
                    }
                    arr[0] = str;
                    c2.b0(this.q.getContext().getString(j.r, arr).trim());
                }
                c2.T(Chip.g(this.q));
                c2.b(c.a.e);
                c2.d0(this.q.isEnabled());
            } else {
                c2.b0("");
                c2.T(Chip.h());
            }
        }

        @Override // d.j.b.a
        protected void O(int i, boolean z2) {
            int obj2;
            if (i == 1) {
                Chip.f(this.q, z2);
                this.q.refreshDrawableState();
            }
        }
    }
    static {
        Chip.M = k.s;
        Rect rect = new Rect();
        Chip.N = rect;
        int i2 = 1;
        int[] iArr2 = new int[i2];
        final int i5 = 0;
        iArr2[i5] = 16842913;
        Chip.O = iArr2;
        int[] iArr = new int[i2];
        iArr[i5] = 16842911;
        Chip.P = iArr;
    }

    public Chip(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.j);
    }

    public Chip(Context context, AttributeSet attributeSet2, int i3) {
        Object obj8;
        int obj10;
        final int i5 = Chip.M;
        super(a.c(context, attributeSet2, i3, i5), attributeSet2, i3);
        obj8 = new Rect();
        this.J = obj8;
        obj8 = new RectF();
        this.K = obj8;
        obj8 = new Chip.a(this);
        this.L = obj8;
        obj8 = getContext();
        B(attributeSet2);
        final com.google.android.material.chip.a aVar = a.y0(obj8, attributeSet2, i3, i5);
        n(obj8, attributeSet2, i3);
        setChipDrawable(aVar);
        aVar.Y(u.w(this));
        TypedArray obj9 = l.h(obj8, attributeSet2, l.h0, i3, i5, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(c.a(obj8, obj9, l.k0));
        }
        obj9.recycle();
        obj9 = new Chip.c(this, this);
        this.H = obj9;
        w();
        if (!obj9.hasValue(l.T0)) {
            o();
        }
        setChecked(this.A);
        setText(aVar.k1());
        setEllipsize(aVar.e1());
        A();
        if (!this.v.O2()) {
            obj8 = 1;
            setLines(obj8);
            setHorizontallyScrolling(obj8);
        }
        setGravity(8388627);
        z();
        if (u()) {
            setMinHeight(this.G);
        }
        this.F = u.B(this);
    }

    private void A() {
        com.google.android.material.chip.a state;
        Context context;
        f fVar;
        final android.text.TextPaint paint = getPaint();
        state = this.v;
        if (state != null) {
            paint.drawableState = state.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.L);
        }
    }

    private void B(AttributeSet attributeSet) {
        String attributeValue;
        boolean attributeBooleanValue;
        int obj5;
        if (attributeSet == null) {
        }
        String str = "http://schemas.android.com/apk/res/android";
        final String str15 = "Chip";
        if (attributeSet.getAttributeValue(str, "background") != null) {
            Log.w(str15, "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue(str, "drawableLeft") != null) {
        } else {
            if (attributeSet.getAttributeValue(str, "drawableStart") != null) {
            } else {
                String str16 = "Please set end drawable using R.attr#closeIcon.";
                if (attributeSet.getAttributeValue(str, "drawableEnd") != null) {
                } else {
                    if (attributeSet.getAttributeValue(str, "drawableRight") != null) {
                    } else {
                        int i = 1;
                        if (!attributeSet.getAttributeBooleanValue(str, "singleLine", i)) {
                        } else {
                            if (attributeSet.getAttributeIntValue(str, "lines", i) != i) {
                            } else {
                                if (attributeSet.getAttributeIntValue(str, "minLines", i) != i) {
                                } else {
                                    if (attributeSet.getAttributeIntValue(str, "maxLines", i) != i) {
                                    } else {
                                        int i2 = 8388627;
                                        if (attributeSet.getAttributeIntValue(str, "gravity", i2) != i2) {
                                            Log.w(str15, "Chip text must be vertically center and start aligned");
                                        }
                                    }
                                }
                            }
                        }
                        obj5 = new UnsupportedOperationException("Chip does not support multi-line text");
                        throw obj5;
                    }
                    obj5 = new UnsupportedOperationException(str16);
                    throw obj5;
                }
                obj5 = new UnsupportedOperationException(str16);
                throw obj5;
            }
            obj5 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            throw obj5;
        }
        obj5 = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        throw obj5;
    }

    static com.google.android.material.chip.a b(com.google.android.material.chip.Chip chip) {
        return chip.v;
    }

    static boolean c(com.google.android.material.chip.Chip chip) {
        return chip.m();
    }

    static RectF d(com.google.android.material.chip.Chip chip) {
        return chip.getCloseIconTouchBounds();
    }

    static View.OnClickListener e(com.google.android.material.chip.Chip chip) {
        return chip.y;
    }

    static boolean f(com.google.android.material.chip.Chip chip, boolean z2) {
        chip.D = z2;
        return z2;
    }

    static Rect g(com.google.android.material.chip.Chip chip) {
        return chip.getCloseIconTouchBoundsInt();
    }

    private RectF getCloseIconTouchBounds() {
        boolean z;
        RectF rectF;
        this.K.setEmpty();
        if (m() && this.y != null) {
            if (this.y != null) {
                this.v.b1(this.K);
            }
        }
        return this.K;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.J.set((int)left, (int)top, (int)right, (int)bottom);
        return this.J;
    }

    private d getTextAppearance() {
        d dVar;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            dVar = aVar.l1();
        } else {
            dVar = 0;
        }
        return dVar;
    }

    static Rect h() {
        return Chip.N;
    }

    private void i(com.google.android.material.chip.a a) {
        a.s2(this);
    }

    private int[] j() {
        int i2;
        int i;
        boolean z;
        boolean z3;
        boolean z2;
        boolean checked;
        boolean enabled;
        i = 0;
        int i3 = 1;
        i2 = isEnabled() ? i3 : i;
        if (this.D) {
            i2++;
        }
        if (this.C) {
            i2++;
        }
        if (this.B) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[i] = 16842910;
            i = i3;
        }
        if (this.D) {
            iArr[i] = 16842908;
            i++;
        }
        if (this.C) {
            iArr[i] = 16843623;
            i++;
        }
        if (this.B) {
            iArr[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            iArr[i] = 16842913;
        }
        return iArr;
    }

    private void l() {
        Object backgroundDrawable;
        InsetDrawable insetDrawable;
        if (getBackgroundDrawable() == this.w && this.v.getCallback() == null) {
            if (this.v.getCallback() == null) {
                this.v.setCallback(this.w);
            }
        }
    }

    private boolean m() {
        Drawable aVar;
        int i;
        aVar = this.v;
        if (aVar != null && aVar.U0() != null) {
            i = aVar.U0() != null ? 1 : 0;
        } else {
        }
        return i;
    }

    private void n(Context context, AttributeSet attributeSet2, int i3) {
        final int i4 = 0;
        final TypedArray obj8 = l.h(context, attributeSet2, l.h0, i3, Chip.M, new int[i4]);
        this.E = obj8.getBoolean(l.O0, i4);
        int obj10 = 48;
        obj10 = l.C0;
        this.G = (int)obj9;
        obj8.recycle();
    }

    private void o() {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            sDK_INT = new Chip.b(this);
            setOutlineProvider(sDK_INT);
        }
    }

    private void p(int i, int i2, int i3, int i4) {
        super(this.v, i, i2, i3, i4);
        this.w = insetDrawable2;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.C != z) {
            this.C = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.B != z) {
            this.B = z;
            refreshDrawableState();
        }
    }

    private void t() {
        InsetDrawable insetDrawable;
        if (this.w != null) {
            this.w = 0;
            setMinWidth(0);
            setMinHeight((int)chipMinHeight);
            x();
        }
    }

    private void v(com.google.android.material.chip.a a) {
        int i;
        if (a != null) {
            a.s2(0);
        }
    }

    private void w() {
        int i;
        boolean z;
        if (m() && r() && this.y != null) {
            if (r()) {
                if (this.y != null) {
                    u.l0(this, this.H);
                    this.I = true;
                } else {
                    u.l0(this, 0);
                    this.I = false;
                }
            } else {
            }
        } else {
        }
    }

    private void x() {
        boolean backgroundDrawable;
        int i;
        if (b.a) {
            y();
        } else {
            this.v.N2(true);
            u.o0(this, getBackgroundDrawable());
            z();
            l();
        }
    }

    private void y() {
        RippleDrawable rippleDrawable = new RippleDrawable(b.d(this.v.i1()), getBackgroundDrawable(), 0);
        this.x = rippleDrawable;
        this.v.N2(false);
        u.o0(this, this.x);
        z();
    }

    private void z() {
        int empty;
        int i;
        InsetDrawable right;
        int paddingTop;
        int paddingBottom;
        if (!TextUtils.isEmpty(getText())) {
            empty = this.v;
            if (empty == null) {
            } else {
                if (this.w != null) {
                    Rect rect = new Rect();
                    this.w.getPadding(rect);
                    i += paddingBottom;
                    empty += right;
                }
                u.y0(this, i, getPaddingTop(), empty, getPaddingBottom());
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void a() {
        k(this.G);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int obj2;
        if (!this.I) {
            return super.dispatchHoverEvent(motionEvent);
        }
        if (!this.H.v(motionEvent)) {
            if (super.dispatchHoverEvent(motionEvent)) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int i;
        if (!this.I) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.H.w(keyEvent) && this.H.A() != Integer.MIN_VALUE) {
            if (this.H.A() != Integer.MIN_VALUE) {
                return 1;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    protected void drawableStateChanged() {
        com.google.android.material.chip.a aVar;
        int i;
        int[] iArr;
        super.drawableStateChanged();
        aVar = this.v;
        if (aVar != null && aVar.s1()) {
            if (aVar.s1()) {
                i = this.v.o2(j());
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0) {
            invalidate();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public java.lang.CharSequence getAccessibilityClassName() {
        android.view.ViewParent parent;
        parent = getParent();
        if (q() && parent instanceof ChipGroup && (ChipGroup)parent.t()) {
            parent = getParent();
            if (parent instanceof ChipGroup) {
                if ((ChipGroup)parent.t()) {
                    return "android.widget.RadioButton";
                }
            }
            return "android.widget.CompoundButton";
        }
        if (isClickable()) {
            return "android.widget.Button";
        }
        return "android.view.View";
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public Drawable getBackgroundDrawable() {
        Object insetDrawable;
        if (this.w == null) {
            insetDrawable = this.v;
        }
        return insetDrawable;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public Drawable getCheckedIcon() {
        Drawable drawable;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            drawable = aVar.I0();
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public ColorStateList getCheckedIconTint() {
        ColorStateList list;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            list = aVar.J0();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public ColorStateList getChipBackgroundColor() {
        ColorStateList list;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            list = aVar.K0();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar;
        int i;
        aVar = this.v;
        if (aVar != null) {
            i = Math.max(0, aVar.L0());
        }
        return i;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public Drawable getChipDrawable() {
        return this.v;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getChipEndPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.M0();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public Drawable getChipIcon() {
        Drawable drawable;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            drawable = aVar.N0();
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getChipIconSize() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.O0();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public ColorStateList getChipIconTint() {
        ColorStateList list;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            list = aVar.P0();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getChipMinHeight() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.Q0();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getChipStartPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.R0();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public ColorStateList getChipStrokeColor() {
        ColorStateList list;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            list = aVar.S0();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getChipStrokeWidth() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.T0();
        } else {
            f = 0;
        }
        return f;
    }

    @Deprecated
    public java.lang.CharSequence getChipText() {
        return getText();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public Drawable getCloseIcon() {
        Drawable drawable;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            drawable = aVar.U0();
        } else {
            drawable = 0;
        }
        return drawable;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public java.lang.CharSequence getCloseIconContentDescription() {
        java.lang.CharSequence charSequence;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            charSequence = aVar.V0();
        } else {
            charSequence = 0;
        }
        return charSequence;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getCloseIconEndPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.W0();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getCloseIconSize() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.X0();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getCloseIconStartPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.Y0();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public ColorStateList getCloseIconTint() {
        ColorStateList list;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            list = aVar.a1();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public TextUtils.TruncateAt getEllipsize() {
        TextUtils.TruncateAt truncateAt;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            truncateAt = aVar.e1();
        } else {
            truncateAt = 0;
        }
        return truncateAt;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void getFocusedRect(Rect rect) {
        int closeIconTouchBoundsInt;
        int i;
        if (this.I) {
            i = 1;
            if (this.H.A() != i) {
                if (this.H.x() == i) {
                    rect.set(getCloseIconTouchBoundsInt());
                } else {
                    super.getFocusedRect(rect);
                }
            } else {
            }
        } else {
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public h getHideMotionSpec() {
        h hVar;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            hVar = aVar.f1();
        } else {
            hVar = 0;
        }
        return hVar;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getIconEndPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.g1();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getIconStartPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.h1();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public ColorStateList getRippleColor() {
        ColorStateList list;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            list = aVar.i1();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public k getShapeAppearanceModel() {
        return this.v.E();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public h getShowMotionSpec() {
        h hVar;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            hVar = aVar.j1();
        } else {
            hVar = 0;
        }
        return hVar;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getTextEndPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.m1();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public float getTextStartPadding() {
        float f;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            f = aVar.n1();
        } else {
            f = 0;
        }
        return f;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean k(int i) {
        InsetDrawable right;
        int minWidth;
        int i2;
        int i3;
        int bottom;
        this.G = i;
        i2 = 0;
        if (!u()) {
            if (this.w != null) {
                t();
            } else {
                x();
            }
            return i2;
        }
        int i5 = Math.max(i2, i - intrinsicHeight);
        int i7 = Math.max(i2, i - intrinsicWidth);
        if (i7 <= 0 && i5 <= 0) {
            if (i5 <= 0) {
                if (this.w != null) {
                    t();
                } else {
                    x();
                }
                return i2;
            }
        }
        i3 = i7 > 0 ? i7 / 2 : i2;
        if (i5 > 0) {
            i2 = i5 / 2;
        }
        final int i8 = 1;
        right = new Rect();
        this.w.getPadding(right);
        if (this.w != null && right.top == i2 && right.bottom == i2 && right.left == i3 && right.right == i3) {
            right = new Rect();
            this.w.getPadding(right);
            if (right.top == i2) {
                if (right.bottom == i2) {
                    if (right.left == i3) {
                        if (right.right == i3) {
                            x();
                            return i8;
                        }
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (getMinHeight() != i) {
                setMinHeight(i);
            }
            if (getMinWidth() != i) {
                setMinWidth(i);
            }
        } else {
            setMinHeight(i);
            setMinWidth(i);
        }
        p(i3, i2, i3, i2);
        x();
        return i8;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.v);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    protected int[] onCreateDrawableState(int i) {
        boolean checked;
        boolean z;
        int[] obj2 = super.onCreateDrawableState(i += 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(obj2, Chip.O);
        }
        if (q()) {
            CheckBox.mergeDrawableStates(obj2, Chip.P);
        }
        return obj2;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    protected void onFocusChanged(boolean z, int i2, Rect rect3) {
        boolean z2;
        super.onFocusChanged(z, i2, rect3);
        if (this.I) {
            this.H.I(z, i2, rect3);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked;
        int i;
        float f;
        actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked != 10) {
            } else {
                setCloseIconHovered(false);
            }
        } else {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean cVar;
        int i2;
        int i6;
        int i3;
        int i4;
        int i;
        int i5;
        boolean checked;
        Object obj9;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(q());
        accessibilityNodeInfo.setClickable(isClickable());
        if (parent instanceof ChipGroup) {
            android.view.ViewParent parent2 = getParent();
            if ((ChipGroup)parent2.g()) {
                i2 = parent2.s(this);
            } else {
                i2 = -1;
            }
            c.y0(accessibilityNodeInfo).a0(c.c.a(parent2.f(this), 1, i2, 1, false, isChecked()));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        boolean obj2;
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            if (isEnabled()) {
                return PointerIcon.getSystemIcon(getContext(), 1002);
            }
        }
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.F != i) {
            this.F = i;
            z();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        int i2;
        int contains;
        int i;
        int i3;
        MotionEvent obj6;
        actionMasked = motionEvent.getActionMasked();
        contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        i = 0;
        int i4 = 1;
        if (actionMasked != 0) {
            if (actionMasked != i4) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        i2 = i;
                    } else {
                        i2 = i;
                        setCloseIconPressed(i);
                    }
                } else {
                    if (this.B) {
                        if (!contains) {
                            setCloseIconPressed(i);
                        }
                        i2 = i4;
                    } else {
                    }
                }
            } else {
                if (this.B) {
                    s();
                    i2 = i4;
                } else {
                }
            }
        } else {
            if (contains) {
                setCloseIconPressed(i4);
            } else {
            }
        }
        if (i2 == 0) {
            if (super.onTouchEvent(motionEvent)) {
                i = i4;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean q() {
        com.google.android.material.chip.a aVar;
        int i;
        aVar = this.v;
        if (aVar != null && aVar.r1()) {
            i = aVar.r1() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean r() {
        com.google.android.material.chip.a aVar;
        int i;
        aVar = this.v;
        if (aVar != null && aVar.t1()) {
            i = aVar.t1() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean s() {
        int i;
        boolean z;
        playSoundEffect(0);
        View.OnClickListener list = this.y;
        final int i2 = 1;
        if (list != null) {
            list.onClick(this);
            i = i2;
        }
        if (this.I) {
            this.H.U(i2, i2);
        }
        return i;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackground(Drawable drawable) {
        Object backgroundDrawable;
        Object obj2;
        if (drawable != getBackgroundDrawable() && drawable != this.x) {
            if (drawable != this.x) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            } else {
                super.setBackground(drawable);
            }
        } else {
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundDrawable(Drawable drawable) {
        Object backgroundDrawable;
        Object obj2;
        if (drawable != getBackgroundDrawable() && drawable != this.x) {
            if (drawable != this.x) {
                Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
            } else {
                super.setBackgroundDrawable(drawable);
            }
        } else {
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckable(boolean z) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.A1(z);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckableResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.B1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChecked(boolean z) {
        com.google.android.material.chip.a checked;
        checked = this.v;
        if (checked == null) {
            this.A = z;
        } else {
            super.setChecked(z);
            checked = this.z;
            if (checked.r1() && isChecked() != z && checked != null) {
                super.setChecked(z);
                if (isChecked() != z) {
                    checked = this.z;
                    if (checked != null) {
                        checked.onCheckedChanged(this, z);
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckedIcon(Drawable drawable) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.C1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckedIconResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.D1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckedIconTint(ColorStateList colorStateList) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.E1(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckedIconTintResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.F1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckedIconVisible(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.G1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCheckedIconVisible(boolean z) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.H1(z);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipBackgroundColor(ColorStateList colorStateList) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.I1(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipBackgroundColorResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.J1(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.K1(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.L1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipDrawable(com.google.android.material.chip.a a) {
        com.google.android.material.chip.a aVar;
        com.google.android.material.chip.a obj2;
        aVar = this.v;
        if (aVar != a) {
            v(aVar);
            this.v = a;
            a.D2(false);
            i(this.v);
            k(this.G);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipEndPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.M1(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipEndPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.N1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIcon(Drawable drawable) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.O1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIconResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.P1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIconSize(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.Q1(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIconSizeResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.R1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIconTint(ColorStateList colorStateList) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.S1(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIconTintResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.T1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIconVisible(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.U1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipIconVisible(boolean z) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.V1(z);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipMinHeight(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.W1(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipMinHeightResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.X1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipStartPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.Y1(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipStartPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.Z1(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipStrokeColor(ColorStateList colorStateList) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.a2(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipStrokeColorResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.b2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipStrokeWidth(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.c2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setChipStrokeWidthResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.d2(i);
        }
    }

    @Deprecated
    public void setChipText(java.lang.CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIcon(Drawable drawable) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.f2(drawable);
        }
        w();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconContentDescription(java.lang.CharSequence charSequence) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.g2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconEndPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.h2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconEndPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.i2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.j2(i);
        }
        w();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconSize(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.k2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconSizeResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.l2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconStartPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.m2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconStartPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.n2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconTint(ColorStateList colorStateList) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.p2(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconTintResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.q2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCloseIconVisible(boolean z) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.r2(z);
        }
        w();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
        } else {
            if (drawable3 != null) {
            } else {
                super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            }
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw obj1;
        }
        obj1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw obj1;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
        } else {
            if (drawable3 != null) {
            } else {
                super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            }
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw obj1;
        }
        obj1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw obj1;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
        } else {
            if (i3 != 0) {
            } else {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
            }
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw obj1;
        }
        obj1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw obj1;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
        } else {
            if (drawable3 != null) {
            } else {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            }
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw obj1;
        }
        obj1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw obj1;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
        } else {
            if (i3 != 0) {
            } else {
                super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
            }
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            throw obj1;
        }
        obj1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        throw obj1;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
        } else {
            if (drawable3 != null) {
            } else {
                super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            }
            UnsupportedOperationException obj1 = new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
            throw obj1;
        }
        obj1 = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        throw obj1;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setElevation(float f) {
        super.setElevation(f);
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.Y(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setEllipsize(TextUtils.TruncateAt textUtils$TruncateAt) {
        if (this.v == null) {
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
        } else {
            super.setEllipsize(truncateAt);
            com.google.android.material.chip.a aVar2 = this.v;
            if (aVar2 != null) {
                aVar2.t2(truncateAt);
            }
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        throw obj2;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setEnsureMinTouchTargetSize(boolean z) {
        this.E = z;
        k(this.G);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setGravity(int i) {
        String str;
        String obj2;
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setHideMotionSpec(h h) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.u2(h);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setHideMotionSpecResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.v2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setIconEndPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.w2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setIconEndPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.x2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setIconStartPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.y2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setIconStartPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.z2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setLayoutDirection(int i) {
        if (this.v == null) {
        }
        if (Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setLines(int i) {
        if (i > 1) {
        } else {
            super.setLines(i);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Chip does not support multi-line text");
        throw obj2;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setMaxLines(int i) {
        if (i > 1) {
        } else {
            super.setMaxLines(i);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Chip does not support multi-line text");
        throw obj2;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.A2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setMinLines(int i) {
        if (i > 1) {
        } else {
            super.setMinLines(i);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Chip does not support multi-line text");
        throw obj2;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener compoundButton$OnCheckedChangeListener) {
        this.z = onCheckedChangeListener;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setOnCloseIconClickListener(View.OnClickListener view$OnClickListener) {
        this.y = onClickListener;
        w();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setRippleColor(ColorStateList colorStateList) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.B2(colorStateList);
        }
        if (!this.v.p1()) {
            y();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setRippleColorResource(int i) {
        int obj2;
        final com.google.android.material.chip.a aVar = this.v;
        aVar.C2(i);
        if (aVar != null && !this.v.p1()) {
            aVar.C2(i);
            if (!this.v.p1()) {
                y();
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setShapeAppearanceModel(k k) {
        this.v.setShapeAppearanceModel(k);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setShowMotionSpec(h h) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.E2(h);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setShowMotionSpecResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.F2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setSingleLine(boolean z) {
        if (!z) {
        } else {
            super.setSingleLine(z);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Chip does not support multi-line text");
        throw obj2;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setText(java.lang.CharSequence charSequence, TextView.BufferType textView$BufferType2) {
        String str;
        String obj2;
        com.google.android.material.chip.a aVar = this.v;
        if (aVar == null) {
        }
        if (charSequence == null) {
            obj2 = "";
        }
        str = aVar.O2() ? 0 : obj2;
        super.setText(str, bufferType2);
        final com.google.android.material.chip.a obj3 = this.v;
        if (obj3 != null) {
            obj3.G2(obj2);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.I2(i);
        }
        A();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        final com.google.android.material.chip.a obj1 = this.v;
        if (obj1 != null) {
            obj1.I2(i2);
        }
        A();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextAppearance(d d) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.H2(d);
        }
        A();
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextEndPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.J2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextEndPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.K2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextStartPadding(float f) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.L2(f);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setTextStartPaddingResource(int i) {
        final com.google.android.material.chip.a aVar = this.v;
        if (aVar != null) {
            aVar.M2(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public boolean u() {
        return this.E;
    }
}
