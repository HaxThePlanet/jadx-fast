package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n.a;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.v0;
import androidx.core.content.e.f;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.k;
import d.a.a;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.u;
import f.c.a.e.d;
import f.c.a.e.e;
import f.c.a.e.f;
import f.c.a.e.h;

/* loaded from: classes2.dex */
public class NavigationMenuItemView extends com.google.android.material.internal.d implements n.a {

    private static final int[] I;
    boolean A;
    private final CheckedTextView B;
    private FrameLayout C;
    private i D;
    private ColorStateList E;
    private boolean F;
    private Drawable G;
    private final a H;
    private int y;
    private boolean z;

    class a extends a {

        final com.google.android.material.internal.NavigationMenuItemView d;
        a(com.google.android.material.internal.NavigationMenuItemView navigationMenuItemView) {
            this.d = navigationMenuItemView;
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            super.g(view, c2);
            c2.V(obj1.A);
        }
    }
    static {
        int[] iArr = new int[1];
        NavigationMenuItemView.I = iArr;
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        NavigationMenuItemView.a obj4 = new NavigationMenuItemView.a(this);
        this.H = obj4;
        setOrientation(0);
        final int i2 = 1;
        LayoutInflater.from(context).inflate(h.g, this, i2);
        setIconSize(context.getResources().getDimensionPixelSize(d.k));
        View obj3 = findViewById(f.g);
        this.B = (CheckedTextView)obj3;
        obj3.setDuplicateParentStateEnabled(i2);
        u.l0(obj3, obj4);
    }

    private void c() {
        Object layoutParams;
        int i;
        if (e()) {
            this.B.setVisibility(8);
            layoutParams = this.C;
            if (layoutParams != null) {
                layoutParams = layoutParams.getLayoutParams();
                layoutParams.width = -1;
                this.C.setLayoutParams((e0.a)layoutParams);
            }
        } else {
            this.B.setVisibility(0);
            layoutParams = this.C;
            if (layoutParams != null) {
                layoutParams = layoutParams.getLayoutParams();
                layoutParams.width = -2;
                this.C.setLayoutParams((e0.a)layoutParams);
            }
        }
    }

    private StateListDrawable d() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(a.v, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            ColorDrawable colorDrawable2 = new ColorDrawable(typedValue.data);
            stateListDrawable.addState(NavigationMenuItemView.I, colorDrawable2);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, colorDrawable);
            return stateListDrawable;
        }
        return null;
    }

    private boolean e() {
        int i;
        Object actionView;
        if (this.D.getTitle() == null && this.D.getIcon() == null && this.D.getActionView() != null) {
            if (this.D.getIcon() == null) {
                i = this.D.getActionView() != null ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void setActionView(View view) {
        Object inflate;
        FrameLayout frameLayout;
        if (view != null && this.C == null) {
            if (this.C == null) {
                this.C = (FrameLayout)(ViewStub)findViewById(f.f).inflate();
            }
            this.C.removeAllViews();
            this.C.addView(view);
        }
    }

    @Override // com.google.android.material.internal.d
    public boolean g() {
        return 0;
    }

    @Override // com.google.android.material.internal.d
    public i getItemData() {
        return this.D;
    }

    @Override // com.google.android.material.internal.d
    public void h(i i, int i2) {
        int obj2;
        this.D = i;
        if (i.getItemId() > 0) {
            setId(i.getItemId());
        }
        obj2 = i.isVisible() ? 0 : 8;
        setVisibility(obj2);
        if (getBackground() == null) {
            u.o0(this, d());
        }
        setCheckable(i.isCheckable());
        setChecked(i.isChecked());
        setEnabled(i.isEnabled());
        setTitle(i.getTitle());
        setIcon(i.getIcon());
        setActionView(i.getActionView());
        setContentDescription(i.getContentDescription());
        v0.a(this, i.getTooltipText());
        c();
    }

    @Override // com.google.android.material.internal.d
    protected int[] onCreateDrawableState(int i) {
        i checkable;
        int[] obj2 = super.onCreateDrawableState(i++);
        checkable = this.D;
        if (checkable != null && checkable.isCheckable() && this.D.isChecked()) {
            if (checkable.isCheckable()) {
                if (this.D.isChecked()) {
                    ViewGroup.mergeDrawableStates(obj2, NavigationMenuItemView.I);
                }
            }
        }
        return obj2;
    }

    @Override // com.google.android.material.internal.d
    public void setCheckable(boolean z) {
        boolean z2;
        int i;
        boolean obj3;
        refreshDrawableState();
        if (this.A != z) {
            this.A = z;
            this.H.l(this.B, 2048);
        }
    }

    @Override // com.google.android.material.internal.d
    public void setChecked(boolean z) {
        refreshDrawableState();
        this.B.setChecked(z);
    }

    @Override // com.google.android.material.internal.d
    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    @Override // com.google.android.material.internal.d
    public void setIcon(Drawable drawable) {
        boolean z;
        boolean z2;
        Resources.Theme theme;
        Drawable obj4;
        int i = 0;
        if (drawable != null) {
            if (this.F) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState == null) {
                } else {
                    obj4 = constantState.newDrawable();
                }
                a.o(a.r(obj4).mutate(), this.E);
            }
            z = this.y;
            obj4.setBounds(i, i, z, z);
        } else {
            obj4 = f.f(getResources(), e.h, getContext().getTheme());
            this.G = obj4;
            if (this.z && this.G == null && obj4 != null) {
                if (this.G == null) {
                    obj4 = f.f(getResources(), e.h, getContext().getTheme());
                    this.G = obj4;
                    if (obj4 != null) {
                        z = this.y;
                        obj4.setBounds(i, i, z, z);
                    }
                }
                obj4 = this.G;
            }
        }
        int i2 = 0;
        k.l(this.B, obj4, i2, i2, i2);
    }

    @Override // com.google.android.material.internal.d
    public void setIconPadding(int i) {
        this.B.setCompoundDrawablePadding(i);
    }

    @Override // com.google.android.material.internal.d
    public void setIconSize(int i) {
        this.y = i;
    }

    @Override // com.google.android.material.internal.d
    void setIconTintList(ColorStateList colorStateList) {
        int obj1;
        this.E = colorStateList;
        obj1 = colorStateList != null ? 1 : 0;
        this.F = obj1;
        obj1 = this.D;
        if (obj1 != null) {
            setIcon(obj1.getIcon());
        }
    }

    @Override // com.google.android.material.internal.d
    public void setMaxLines(int i) {
        this.B.setMaxLines(i);
    }

    @Override // com.google.android.material.internal.d
    public void setNeedsEmptyIcon(boolean z) {
        this.z = z;
    }

    @Override // com.google.android.material.internal.d
    public void setTextAppearance(int i) {
        k.q(this.B, i);
    }

    @Override // com.google.android.material.internal.d
    public void setTextColor(ColorStateList colorStateList) {
        this.B.setTextColor(colorStateList);
    }

    @Override // com.google.android.material.internal.d
    public void setTitle(java.lang.CharSequence charSequence) {
        this.B.setText(charSequence);
    }
}
