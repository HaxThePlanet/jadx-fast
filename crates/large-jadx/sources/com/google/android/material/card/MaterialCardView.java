package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import d.a.k.a.a;
import f.c.a.e.b;
import f.c.a.e.d0.h;
import f.c.a.e.d0.k;
import f.c.a.e.d0.n;
import f.c.a.e.k;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class MaterialCardView extends CardView implements Checkable, n {

    private static final int A;
    private static final int[] x;
    private static final int[] y;
    private static final int[] z;
    private final com.google.android.material.card.a a;
    private boolean b;
    private boolean c;
    private boolean v;
    private com.google.android.material.card.MaterialCardView.a w;

    public interface a {
        public abstract void a(com.google.android.material.card.MaterialCardView materialCardView, boolean z2);
    }
    static {
        int i = 1;
        int[] iArr2 = new int[i];
        final int i6 = 0;
        iArr2[i6] = 16842911;
        MaterialCardView.x = iArr2;
        int[] iArr3 = new int[i];
        iArr3[i6] = 16842912;
        MaterialCardView.y = iArr3;
        int[] iArr = new int[i];
        iArr[i6] = b.R;
        MaterialCardView.z = iArr;
        MaterialCardView.A = k.q;
    }

    public MaterialCardView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.D);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet2, int i3) {
        final int i5 = MaterialCardView.A;
        super(a.c(context, attributeSet2, i3, i5), attributeSet2, i3);
        int obj8 = 0;
        this.c = obj8;
        this.v = obj8;
        this.b = true;
        obj8 = l.h(getContext(), attributeSet2, l.R2, i3, i5, new int[obj8]);
        a aVar = new a(this, attributeSet2, i3, i5);
        this.a = aVar;
        aVar.G(super.getCardBackgroundColor());
        aVar.U(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.D(obj8);
        obj8.recycle();
    }

    static float c(com.google.android.material.card.MaterialCardView materialCardView) {
        return super.getRadius();
    }

    private void d() {
        int sDK_INT;
        if (Build.VERSION.SDK_INT > 26) {
            this.a.i();
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.a.j().getBounds());
        return rectF;
    }

    @Override // androidx.cardview.widget.CardView
    public boolean e() {
        com.google.android.material.card.a aVar;
        int i;
        aVar = this.a;
        if (aVar != null && aVar.C()) {
            i = aVar.C() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.cardview.widget.CardView
    public boolean f() {
        return this.v;
    }

    @Override // androidx.cardview.widget.CardView
    void g(int i, int i2, int i3, int i4) {
        super.setContentPadding(i, i2, i3, i4);
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.a.k();
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardForegroundColor() {
        return this.a.l();
    }

    @Override // androidx.cardview.widget.CardView
    float getCardViewRadius() {
        return MaterialCardView.c(this);
    }

    @Override // androidx.cardview.widget.CardView
    public Drawable getCheckedIcon() {
        return this.a.m();
    }

    @Override // androidx.cardview.widget.CardView
    public int getCheckedIconMargin() {
        return this.a.n();
    }

    @Override // androidx.cardview.widget.CardView
    public int getCheckedIconSize() {
        return this.a.o();
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCheckedIconTint() {
        return this.a.p();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return rect.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return rect.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return rect.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return rect.top;
    }

    @Override // androidx.cardview.widget.CardView
    public float getProgress() {
        return this.a.t();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.a.r();
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getRippleColor() {
        return this.a.u();
    }

    @Override // androidx.cardview.widget.CardView
    public k getShapeAppearanceModel() {
        return this.a.v();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.a.w();
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getStrokeColorStateList() {
        return this.a.x();
    }

    @Override // androidx.cardview.widget.CardView
    public int getStrokeWidth() {
        return this.a.y();
    }

    @Override // androidx.cardview.widget.CardView
    public boolean isChecked() {
        return this.c;
    }

    @Override // androidx.cardview.widget.CardView
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.a.j());
    }

    @Override // androidx.cardview.widget.CardView
    protected int[] onCreateDrawableState(int i) {
        boolean z2;
        boolean checked;
        boolean z;
        int[] obj2 = super.onCreateDrawableState(i += 3);
        if (e()) {
            FrameLayout.mergeDrawableStates(obj2, MaterialCardView.x);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(obj2, MaterialCardView.y);
        }
        if (f()) {
            FrameLayout.mergeDrawableStates(obj2, MaterialCardView.z);
        }
        return obj2;
    }

    @Override // androidx.cardview.widget.CardView
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.a.E(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // androidx.cardview.widget.CardView
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setBackgroundDrawable(Drawable drawable) {
        boolean z;
        int i;
        if (this.b && !this.a.B()) {
            if (!this.a.B()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.a.F(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.cardview.widget.CardView
    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i) {
        this.a.G(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.a.G(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f) {
        super.setCardElevation(f);
        this.a.Z();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.a.H(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckable(boolean z) {
        this.a.I(z);
    }

    @Override // androidx.cardview.widget.CardView
    public void setChecked(boolean z) {
        if (this.c != z) {
            toggle();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckedIcon(Drawable drawable) {
        this.a.K(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckedIconMargin(int i) {
        this.a.L(i);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckedIconMarginResource(int i) {
        int i2;
        Resources resources;
        int obj3;
        if (i != -1) {
            this.a.L(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckedIconResource(int i) {
        this.a.K(a.d(getContext(), i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckedIconSize(int i) {
        this.a.M(i);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckedIconSizeResource(int i) {
        com.google.android.material.card.a aVar;
        Resources resources;
        int obj3;
        if (i != 0) {
            this.a.M(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.a.N(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setClickable(boolean z) {
        super.setClickable(z);
        final com.google.android.material.card.a obj1 = this.a;
        if (obj1 != null) {
            obj1.X();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.a.U(i, i2, i3, i4);
    }

    @Override // androidx.cardview.widget.CardView
    public void setDragged(boolean z) {
        if (this.v != z) {
            this.v = z;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f) {
        super.setMaxCardElevation(f);
        this.a.b0();
    }

    @Override // androidx.cardview.widget.CardView
    public void setOnCheckedChangeListener(com.google.android.material.card.MaterialCardView.a materialCardView$a) {
        this.w = a;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.a.b0();
        this.a.Y();
    }

    @Override // androidx.cardview.widget.CardView
    public void setProgress(float f) {
        this.a.P(f);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        this.a.O(f);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRippleColor(ColorStateList colorStateList) {
        this.a.Q(colorStateList);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRippleColorResource(int i) {
        this.a.Q(a.c(getContext(), i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setShapeAppearanceModel(k k) {
        int sDK_INT;
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(k.u(getBoundsAsRectF()));
        }
        this.a.R(k);
    }

    @Override // androidx.cardview.widget.CardView
    public void setStrokeColor(int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setStrokeColor(ColorStateList colorStateList) {
        this.a.S(colorStateList);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setStrokeWidth(int i) {
        this.a.T(i);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.a.b0();
        this.a.Y();
    }

    @Override // androidx.cardview.widget.CardView
    public void toggle() {
        boolean enabled;
        boolean z;
        this.c = z2 ^= 1;
        refreshDrawableState();
        d();
        this.a.J(this.c);
        enabled = this.w;
        if (e() && isEnabled() && enabled != null) {
            if (isEnabled()) {
                this.c = z2 ^= 1;
                refreshDrawableState();
                d();
                this.a.J(this.c);
                enabled = this.w;
                if (enabled != null) {
                    enabled.a(this, this.c);
                }
            }
        }
    }
}
