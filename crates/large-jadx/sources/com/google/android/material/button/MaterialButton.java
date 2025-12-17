package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import androidx.appcompat.widget.f;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.k;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.theme.a.a;
import d.a.k.a.a;
import d.h.l.u;
import d.j.a.a;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.d0.n;
import f.c.a.e.k;
import f.c.a.e.l;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public class MaterialButton extends f implements Checkable, n {

    private static final int[] H;
    private static final int[] I;
    private static final int J;
    private int A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private boolean F;
    private int G;
    private final com.google.android.material.button.a c;
    private final LinkedHashSet<com.google.android.material.button.MaterialButton.a> v;
    private com.google.android.material.button.MaterialButton.b w;
    private PorterDuff.Mode x;
    private ColorStateList y;
    private Drawable z;

    public interface a {
        public abstract void a(com.google.android.material.button.MaterialButton materialButton, boolean z2);
    }

    interface b {
        public abstract void a(com.google.android.material.button.MaterialButton materialButton, boolean z2);
    }

    static class c extends a {

        public static final Parcelable.Creator<com.google.android.material.button.MaterialButton.c> CREATOR;
        boolean c;
        static {
            MaterialButton.c.a aVar = new MaterialButton.c.a();
            MaterialButton.c.CREATOR = aVar;
        }

        public c(Parcel parcel, java.lang.ClassLoader classLoader2) {
            java.lang.ClassLoader obj2;
            super(parcel, classLoader2);
            if (classLoader2 == null) {
                MaterialButton.c.class.getClassLoader();
            }
            b(parcel);
        }

        public c(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel) {
            int i;
            if (parcel.readInt() == 1) {
            } else {
                i = 0;
            }
            this.c = i;
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
        }
    }
    static {
        int i = 1;
        int[] iArr2 = new int[i];
        final int i5 = 0;
        iArr2[i5] = 16842911;
        MaterialButton.H = iArr2;
        int[] iArr = new int[i];
        iArr[i5] = 16842912;
        MaterialButton.I = iArr;
        MaterialButton.J = k.p;
    }

    public MaterialButton(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.z);
    }

    public MaterialButton(Context context, AttributeSet attributeSet2, int i3) {
        int obj9;
        final int i12 = MaterialButton.J;
        super(a.c(context, attributeSet2, i3, i12), attributeSet2, i3);
        obj9 = new LinkedHashSet();
        this.v = obj9;
        obj9 = 0;
        this.E = obj9;
        this.F = obj9;
        final Context context5 = getContext();
        TypedArray typedArray = l.h(context5, attributeSet2, l.Z1, i3, i12, new int[obj9]);
        this.D = typedArray.getDimensionPixelSize(l.m2, obj9);
        this.x = n.f(typedArray.getInt(l.p2, -1), PorterDuff.Mode.SRC_IN);
        this.y = c.a(getContext(), typedArray, l.o2);
        this.z = c.d(getContext(), typedArray, l.k2);
        int i9 = 1;
        this.G = typedArray.getInteger(l.l2, i9);
        this.A = typedArray.getDimensionPixelSize(l.n2, obj9);
        a obj11 = new a(this, k.e(context5, attributeSet2, i3, i12).m());
        this.c = obj11;
        obj11.q(typedArray);
        typedArray.recycle();
        setCompoundDrawablePadding(this.D);
        obj9 = this.z != null ? i9 : obj9;
        k(obj9);
    }

    private boolean d() {
        int i2;
        int i;
        int i3 = this.G;
        if (i3 != 3) {
            if (i3 == 4) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    private boolean e() {
        int i2;
        int i;
        final int i3 = this.G;
        if (i3 != 1) {
            if (i3 == 2) {
            } else {
                i2 = 0;
            }
        }
        return i2;
    }

    private boolean f() {
        int i2;
        int i;
        int i3 = this.G;
        if (i3 != 16) {
            if (i3 == 32) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    private boolean g() {
        int i;
        if (u.B(this) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private String getA11yClassName() {
        Class<android.widget.CompoundButton> obj;
        obj = c() ? CompoundButton.class : Button.class;
        return obj.getName();
    }

    private int getTextHeight() {
        String string;
        TransformationMethod transformationMethod;
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(getText().toString(), this).toString();
        }
        Rect rect = new Rect();
        getPaint().getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        String string;
        TransformationMethod transformationMethod;
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(getText().toString(), this).toString();
        }
        return Math.min((int)measureText, getLayout().getEllipsizedWidth());
    }

    private boolean h() {
        com.google.android.material.button.a aVar;
        int i;
        aVar = this.c;
        if (aVar != null && !aVar.o()) {
            i = !aVar.o() ? 1 : 0;
        } else {
        }
        return i;
    }

    private void j() {
        Drawable drawable;
        final int i = 0;
        if (e()) {
            k.l(this, this.z, i, i, i);
        } else {
            if (d()) {
                k.l(this, i, i, this.z, i);
            } else {
                if (f()) {
                    k.l(this, i, this.z, i, i);
                }
            }
        }
    }

    private void k(boolean z) {
        int intrinsicWidth;
        Drawable drawable3;
        int i;
        Object list;
        int intrinsicHeight;
        int i3;
        boolean drawable2;
        Drawable drawable;
        int i4;
        boolean z2;
        int i2;
        boolean obj7;
        drawable3 = this.z;
        i = 1;
        Drawable mutate = a.r(drawable3).mutate();
        this.z = mutate;
        a.o(mutate, this.y);
        PorterDuff.Mode mode = this.x;
        if (drawable3 != null && mode != null) {
            mutate = a.r(drawable3).mutate();
            this.z = mutate;
            a.o(mutate, this.y);
            mode = this.x;
            if (mode != null) {
                a.p(this.z, mode);
            }
            if (this.A != 0) {
            } else {
                intrinsicWidth = this.z.getIntrinsicWidth();
            }
            if (this.A != 0) {
            } else {
                intrinsicHeight = this.z.getIntrinsicHeight();
            }
            i4 = this.B;
            i2 = this.C;
            this.z.setBounds(i4, i2, intrinsicWidth += i4, intrinsicHeight += i2);
            this.z.setVisible(i, z);
        }
        if (z) {
            j();
        }
        obj7 = k.a(this);
        int i6 = 0;
        if (e()) {
            if (obj7[i6] == this.z) {
                if (d()) {
                    if (obj7[2] == this.z) {
                        if (f() && obj7[i] != this.z) {
                            if (obj7[i] != this.z) {
                            } else {
                                i = i6;
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        } else {
        }
        if (i != 0) {
            j();
        }
    }

    private void l(int i, int i2) {
        boolean paddingTop;
        int i5;
        int i4;
        int i3;
        boolean obj5;
        int obj6;
        if (this.z != null) {
            if (getLayout() == null) {
            } else {
                i5 = 0;
                if (!e()) {
                    if (d()) {
                        this.C = i5;
                        obj6 = this.G;
                        if (obj6 != 1) {
                            if (obj6 == 3) {
                            } else {
                                if (this.A == 0) {
                                    obj6 = this.z.getIntrinsicWidth();
                                }
                                if (this.G == 4) {
                                } else {
                                    paddingTop = i5;
                                }
                                if (g() != paddingTop) {
                                    obj5 = -obj5;
                                }
                                if (this.B != obj5) {
                                    this.B = obj5;
                                    k(i5);
                                }
                            }
                        }
                    } else {
                        this.B = i5;
                        if (f() && this.G == 16) {
                            this.B = i5;
                            if (this.G == 16) {
                                this.C = i5;
                                k(i5);
                            }
                            if (this.A == 0) {
                                obj5 = this.z.getIntrinsicHeight();
                            }
                            obj6 /= 2;
                            if (this.C != obj6) {
                                this.C = obj6;
                                k(i5);
                            }
                        }
                    }
                } else {
                }
                this.B = i5;
                k(i5);
            }
        }
    }

    @Override // androidx.appcompat.widget.f
    public void b(com.google.android.material.button.MaterialButton.a materialButton$a) {
        this.v.add(a);
    }

    @Override // androidx.appcompat.widget.f
    public boolean c() {
        com.google.android.material.button.a aVar;
        int i;
        aVar = this.c;
        if (aVar != null && aVar.p()) {
            i = aVar.p() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    @Override // androidx.appcompat.widget.f
    public int getCornerRadius() {
        int i;
        if (h()) {
            i = this.c.b();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.appcompat.widget.f
    public Drawable getIcon() {
        return this.z;
    }

    @Override // androidx.appcompat.widget.f
    public int getIconGravity() {
        return this.G;
    }

    @Override // androidx.appcompat.widget.f
    public int getIconPadding() {
        return this.D;
    }

    @Override // androidx.appcompat.widget.f
    public int getIconSize() {
        return this.A;
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getIconTint() {
        return this.y;
    }

    @Override // androidx.appcompat.widget.f
    public PorterDuff.Mode getIconTintMode() {
        return this.x;
    }

    @Override // androidx.appcompat.widget.f
    public int getInsetBottom() {
        return this.c.c();
    }

    @Override // androidx.appcompat.widget.f
    public int getInsetTop() {
        return this.c.d();
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getRippleColor() {
        ColorStateList list;
        if (h()) {
            list = this.c.h();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.f
    public k getShapeAppearanceModel() {
        if (!h()) {
        } else {
            return this.c.i();
        }
        IllegalStateException illegalStateException = new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
        throw illegalStateException;
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getStrokeColor() {
        ColorStateList list;
        if (h()) {
            list = this.c.j();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // androidx.appcompat.widget.f
    public int getStrokeWidth() {
        int i;
        if (h()) {
            i = this.c.k();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.appcompat.widget.f
    public ColorStateList getSupportBackgroundTintList() {
        if (h()) {
            return this.c.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.f
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (h()) {
            return this.c.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    @Override // androidx.appcompat.widget.f
    public void i(com.google.android.material.button.MaterialButton.a materialButton$a) {
        this.v.remove(a);
    }

    @Override // androidx.appcompat.widget.f
    public boolean isChecked() {
        return this.E;
    }

    @Override // androidx.appcompat.widget.f
    protected void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        if (h()) {
            h.f(this, this.c.f());
        }
    }

    @Override // androidx.appcompat.widget.f
    protected int[] onCreateDrawableState(int i) {
        boolean z;
        boolean checked;
        int[] obj2 = super.onCreateDrawableState(i += 2);
        if (c()) {
            Button.mergeDrawableStates(obj2, MaterialButton.H);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(obj2, MaterialButton.I);
        }
        return obj2;
    }

    @Override // androidx.appcompat.widget.f
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.f
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(c());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.f
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int obj2;
        int obj5;
        int obj6;
        super.onLayout(z, i2, i3, i4, i5);
        obj2 = this.c;
        if (Build.VERSION.SDK_INT == 21 && obj2 != null) {
            obj2 = this.c;
            if (obj2 != null) {
                obj2.H(i5 -= i3, i4 -= i2);
            }
        }
    }

    @Override // androidx.appcompat.widget.f
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof MaterialButton.c) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((MaterialButton.c)parcelable.a());
        setChecked(parcelable.c);
    }

    @Override // androidx.appcompat.widget.f
    public Parcelable onSaveInstanceState() {
        MaterialButton.c cVar = new MaterialButton.c(super.onSaveInstanceState());
        cVar.c = this.E;
        return cVar;
    }

    @Override // androidx.appcompat.widget.f
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l(i, i2);
    }

    @Override // androidx.appcompat.widget.f
    protected void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        l(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.f
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // androidx.appcompat.widget.f
    public void refreshDrawableState() {
        Drawable state;
        Drawable drawable;
        super.refreshDrawableState();
        if (this.z != null && this.z.setState(getDrawableState())) {
            if (this.z.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f
    public void setBackgroundColor(int i) {
        com.google.android.material.button.a z;
        if (h()) {
            this.c.r(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setBackgroundDrawable(Drawable drawable) {
        Drawable background;
        String str;
        int[] obj3;
        if (h()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.c.s();
                super.setBackgroundDrawable(drawable);
            } else {
                getBackground().setState(drawable.getState());
            }
        } else {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setBackgroundResource(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        setBackgroundDrawable(obj2);
    }

    @Override // androidx.appcompat.widget.f
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // androidx.appcompat.widget.f
    public void setBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        setSupportBackgroundTintMode(mode);
    }

    @Override // androidx.appcompat.widget.f
    public void setCheckable(boolean z) {
        boolean z2;
        if (h()) {
            this.c.t(z);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setChecked(boolean z) {
        boolean enabled;
        boolean z2;
        boolean obj3;
        this.E = z;
        refreshDrawableState();
        if (c() && isEnabled() && this.E != z && this.F) {
            if (isEnabled()) {
                if (this.E != z) {
                    this.E = z;
                    refreshDrawableState();
                    if (this.F) {
                    }
                    this.F = true;
                    obj3 = this.v.iterator();
                    for (MaterialButton.a enabled : obj3) {
                        enabled.a(this, this.E);
                    }
                    this.F = false;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setCornerRadius(int i) {
        boolean z;
        if (h()) {
            this.c.u(i);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setCornerRadiusResource(int i) {
        boolean resources;
        int obj2;
        if (h()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setElevation(float f) {
        boolean z;
        super.setElevation(f);
        if (h()) {
            this.c.f().Y(f);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setIcon(Drawable drawable) {
        Drawable measuredHeight;
        Drawable obj2;
        if (this.z != drawable) {
            this.z = drawable;
            k(true);
            l(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setIconGravity(int i) {
        int measuredHeight;
        int obj2;
        if (this.G != i) {
            this.G = i;
            l(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setIconPadding(int i) {
        if (this.D != i) {
            this.D = i;
            setCompoundDrawablePadding(i);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setIconResource(int i) {
        Context context;
        Drawable obj2;
        if (i != 0) {
            obj2 = a.d(getContext(), i);
        } else {
            obj2 = 0;
        }
        setIcon(obj2);
    }

    @Override // androidx.appcompat.widget.f
    public void setIconSize(int i) {
        int obj2;
        if (i < 0) {
        } else {
            if (this.A != i) {
                this.A = i;
                k(true);
            }
        }
        obj2 = new IllegalArgumentException("iconSize cannot be less than 0");
        throw obj2;
    }

    @Override // androidx.appcompat.widget.f
    public void setIconTint(ColorStateList colorStateList) {
        ColorStateList obj2;
        if (this.y != colorStateList) {
            this.y = colorStateList;
            k(false);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setIconTintMode(PorterDuff.Mode porterDuff$Mode) {
        PorterDuff.Mode obj2;
        if (this.x != mode) {
            this.x = mode;
            k(false);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setIconTintResource(int i) {
        setIconTint(a.c(getContext(), i));
    }

    @Override // androidx.appcompat.widget.f
    public void setInsetBottom(int i) {
        this.c.v(i);
    }

    @Override // androidx.appcompat.widget.f
    public void setInsetTop(int i) {
        this.c.w(i);
    }

    @Override // androidx.appcompat.widget.f
    void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.f
    void setOnPressedChangeListenerInternal(com.google.android.material.button.MaterialButton.b materialButton$b) {
        this.w = b;
    }

    @Override // androidx.appcompat.widget.f
    public void setPressed(boolean z) {
        final com.google.android.material.button.MaterialButton.b bVar = this.w;
        if (bVar != null) {
            bVar.a(this, z);
        }
        super.setPressed(z);
    }

    @Override // androidx.appcompat.widget.f
    public void setRippleColor(ColorStateList colorStateList) {
        boolean z;
        if (h()) {
            this.c.x(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setRippleColorResource(int i) {
        boolean context;
        int obj2;
        if (h()) {
            setRippleColor(a.c(getContext(), i));
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setShapeAppearanceModel(k k) {
        if (!h()) {
        } else {
            this.c.y(k);
        }
        IllegalStateException obj2 = new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        throw obj2;
    }

    @Override // androidx.appcompat.widget.f
    void setShouldDrawSurfaceColorStroke(boolean z) {
        boolean z2;
        if (h()) {
            this.c.z(z);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setStrokeColor(ColorStateList colorStateList) {
        boolean z;
        if (h()) {
            this.c.A(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setStrokeColorResource(int i) {
        boolean context;
        int obj2;
        if (h()) {
            setStrokeColor(a.c(getContext(), i));
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setStrokeWidth(int i) {
        boolean z;
        if (h()) {
            this.c.B(i);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setStrokeWidthResource(int i) {
        boolean resources;
        int obj2;
        if (h()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        com.google.android.material.button.a z;
        if (h()) {
            this.c.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        com.google.android.material.button.a z;
        if (h()) {
            this.c.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // androidx.appcompat.widget.f
    public void toggle() {
        setChecked(z ^= 1);
    }
}
