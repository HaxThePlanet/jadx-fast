package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f0;
import com.google.android.material.internal.e;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import f.c.a.e.b;
import f.c.a.e.k;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class g extends d {

    private final f0 v;
    private final AccessibilityManager w;
    private final Rect x;

    class a implements AdapterView.OnItemClickListener {

        final com.google.android.material.textfield.g a;
        a(com.google.android.material.textfield.g g) {
            this.a = g;
            super();
        }

        public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long l4) {
            android.widget.ListView list;
            View view;
            int i;
            long l;
            Object obj7;
            View obj8;
            int obj9;
            long obj10;
            if (i3 < 0) {
                obj7 = g.a(this.a).v();
            } else {
                obj7 = this.a.getAdapter().getItem(i3);
            }
            g.b(this.a, obj7);
            AdapterView.OnItemClickListener onItemClickListener = this.a.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view2 != null) {
                    if (i3 < 0) {
                        obj8 = g.a(this.a).y();
                        obj9 = g.a(this.a).x();
                        obj10 = g.a(this.a).w();
                    }
                } else {
                }
                onItemClickListener.onItemClick(g.a(this.a).k(), obj8, obj9, obj10);
            }
            g.a(this.a).dismiss();
        }
    }
    public g(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.c);
    }

    public g(Context context, AttributeSet attributeSet2, int i3) {
        int obj10;
        final int i = 0;
        super(a.c(context, attributeSet2, i3, i), attributeSet2, i3);
        Rect obj8 = new Rect();
        this.x = obj8;
        obj8 = getContext();
        final TypedArray obj9 = l.h(obj8, attributeSet2, l.X1, i3, k.g, new int[i]);
        obj10 = l.Y1;
        if (obj9.hasValue(obj10) && obj9.getInt(obj10, i) == 0) {
            if (obj9.getInt(obj10, i) == 0) {
                setKeyListener(0);
            }
        }
        this.w = (AccessibilityManager)obj8.getSystemService("accessibility");
        obj10 = new f0(obj8);
        this.v = obj10;
        obj10.J(true);
        obj10.D(this);
        obj10.I(2);
        obj10.p(getAdapter());
        obj8 = new g.a(this);
        obj10.L(obj8);
        obj9.recycle();
    }

    static f0 a(com.google.android.material.textfield.g g) {
        return g.v;
    }

    static void b(com.google.android.material.textfield.g g, Object object2) {
        g.e(object2);
    }

    private com.google.android.material.textfield.TextInputLayout c() {
        ViewParent parent;
        boolean z;
        parent = getParent();
        while (parent != null) {
            parent = parent.getParent();
        }
        return null;
    }

    private int d() {
        Drawable right;
        int i3;
        int i2;
        int i4;
        int view;
        int measuredWidth;
        ViewGroup.LayoutParams layoutParams;
        int i;
        ListAdapter adapter = getAdapter();
        final com.google.android.material.textfield.TextInputLayout textInputLayout = c();
        i3 = 0;
        if (adapter != null) {
            if (textInputLayout == null) {
            } else {
                int i8 = Math.min(adapter.getCount(), i6 += 15);
                final int i12 = 0;
                i4 = i10;
                view = i12;
                i2 = i3;
                while (i4 < i8) {
                    int itemViewType = adapter.getItemViewType(i4);
                    if (itemViewType != i3) {
                    }
                    view = adapter.getView(i4, view, textInputLayout);
                    if (view.getLayoutParams() == null) {
                    }
                    view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), i3), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), i3));
                    i2 = Math.max(i2, view.getMeasuredWidth());
                    i4++;
                    i = -2;
                    layoutParams = new ViewGroup.LayoutParams(i, i);
                    view.setLayoutParams(layoutParams);
                    view = i12;
                    i3 = itemViewType;
                }
                right = this.v.i();
                if (right != null) {
                    right.getPadding(this.x);
                    Rect rect = this.x;
                    i2 += i3;
                }
            }
            return i2 += measuredWidth2;
        }
        return i3;
    }

    private <T extends ListAdapter & android.widget.Filterable> void e(Object object) {
        int adapter;
        int i;
        java.lang.CharSequence obj3;
        if (Build.VERSION.SDK_INT >= 17) {
            setText(convertSelectionToString(object), false);
        } else {
            setAdapter(0);
            setText(convertSelectionToString(object));
            setAdapter(getAdapter());
        }
    }

    @Override // androidx.appcompat.widget.d
    public java.lang.CharSequence getHint() {
        boolean z;
        com.google.android.material.textfield.TextInputLayout textInputLayout = c();
        if (textInputLayout != null && textInputLayout.P()) {
            if (textInputLayout.P()) {
                return textInputLayout.getHint();
            }
        }
        return super.getHint();
    }

    @Override // androidx.appcompat.widget.d
    protected void onAttachedToWindow() {
        com.google.android.material.textfield.TextInputLayout hint;
        super.onAttachedToWindow();
        hint = c();
        if (hint != null && hint.P() && super.getHint() == null && e.c()) {
            if (hint.P()) {
                if (super.getHint() == null) {
                    if (e.c()) {
                        setHint("");
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.d
    protected void onMeasure(int i, int i2) {
        int i3;
        int obj2;
        int obj3;
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), d()), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public <T extends ListAdapter & android.widget.Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.v.p(getAdapter());
    }

    @Override // androidx.appcompat.widget.d
    public void showDropDown() {
        AccessibilityManager touchExplorationEnabled;
        touchExplorationEnabled = this.w;
        if (touchExplorationEnabled != null && touchExplorationEnabled.isTouchExplorationEnabled()) {
            if (touchExplorationEnabled.isTouchExplorationEnabled()) {
                this.v.a();
            } else {
                super.showDropDown();
            }
        } else {
        }
    }
}
