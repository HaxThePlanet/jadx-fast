package com.google.android.material.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.google.android.material.internal.c;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import d.h.l.e0.c;
import d.h.l.e0.c.b;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.k;
import f.c.a.e.l;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ChipGroup extends c {

    private static final int F;
    private com.google.android.material.chip.ChipGroup.d A;
    private final com.google.android.material.chip.ChipGroup.b B;
    private com.google.android.material.chip.ChipGroup.e C;
    private int D;
    private boolean E;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    static class a {
    }

    private class b implements CompoundButton.OnCheckedChangeListener {

        final com.google.android.material.chip.ChipGroup a;
        private b(com.google.android.material.chip.ChipGroup chipGroup) {
            this.a = chipGroup;
            super();
        }

        b(com.google.android.material.chip.ChipGroup chipGroup, com.google.android.material.chip.ChipGroup.a chipGroup$a2) {
            super(chipGroup);
        }

        @Override // android.widget.CompoundButton$OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            boolean empty;
            int i;
            int obj4;
            int obj5;
            if (ChipGroup.j(this.a)) {
            }
            final int i2 = 0;
            if (this.a.getCheckedChipIds().isEmpty() && ChipGroup.k(this.a)) {
                if (ChipGroup.k(this.a)) {
                    ChipGroup.l(this.a, compoundButton.getId(), true);
                    ChipGroup.m(this.a, compoundButton.getId(), i2);
                }
            }
            obj4 = compoundButton.getId();
            i = -1;
            if (z2) {
                if (ChipGroup.n(this.a) != i && ChipGroup.n(this.a) != obj4 && ChipGroup.o(this.a)) {
                    if (ChipGroup.n(this.a) != obj4) {
                        if (ChipGroup.o(this.a)) {
                            obj5 = this.a;
                            ChipGroup.l(obj5, ChipGroup.n(obj5), i2);
                        }
                    }
                }
                ChipGroup.p(this.a, obj4);
            } else {
                if (ChipGroup.n(this.a) == obj4) {
                    ChipGroup.p(this.a, i);
                }
            }
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {
        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }

        public c(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
        }
    }

    public interface d {
        public abstract void a(com.google.android.material.chip.ChipGroup chipGroup, int i2);
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {

        private ViewGroup.OnHierarchyChangeListener a;
        final com.google.android.material.chip.ChipGroup b;
        private e(com.google.android.material.chip.ChipGroup chipGroup) {
            this.b = chipGroup;
            super();
        }

        e(com.google.android.material.chip.ChipGroup chipGroup, com.google.android.material.chip.ChipGroup.a chipGroup$a2) {
            super(chipGroup);
        }

        static ViewGroup.OnHierarchyChangeListener a(com.google.android.material.chip.ChipGroup.e chipGroup$e, ViewGroup.OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener2) {
            e.a = onHierarchyChangeListener2;
            return onHierarchyChangeListener2;
        }

        @Override // android.view.ViewGroup$OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            com.google.android.material.chip.ChipGroup chipGroup;
            int i2;
            com.google.android.material.chip.ChipGroup.b bVar;
            boolean checked;
            int i;
            if (view == this.b && view2 instanceof Chip && view2.getId() == -1) {
                if (view2 instanceof Chip) {
                    if (view2.getId() == -1) {
                        view2.setId(u.k());
                    }
                    chipGroup = view2;
                    if ((Chip)chipGroup.isChecked()) {
                        (ChipGroup)view.q(chipGroup.getId());
                    }
                    chipGroup.setOnCheckedChangeListenerInternal(ChipGroup.i(this.b));
                }
            }
            ViewGroup.OnHierarchyChangeListener list = this.a;
            if (list != null) {
                list.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup$OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            com.google.android.material.chip.ChipGroup chipGroup;
            int i;
            if (view == this.b && view2 instanceof Chip) {
                if (view2 instanceof Chip) {
                    (Chip)view2.setOnCheckedChangeListenerInternal(0);
                }
            }
            ViewGroup.OnHierarchyChangeListener list = this.a;
            if (list != null) {
                list.onChildViewRemoved(view, view2);
            }
        }
    }
    static {
        ChipGroup.F = k.r;
    }

    public ChipGroup(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.i);
    }

    public ChipGroup(Context context, AttributeSet attributeSet2, int i3) {
        final int i6 = ChipGroup.F;
        super(a.c(context, attributeSet2, i3, i6), attributeSet2, i3);
        int i = 0;
        ChipGroup.b obj8 = new ChipGroup.b(this, i);
        this.B = obj8;
        obj8 = new ChipGroup.e(this, i);
        this.C = obj8;
        obj8 = -1;
        this.D = obj8;
        final int i7 = 0;
        this.E = i7;
        final TypedArray obj9 = l.h(getContext(), attributeSet2, l.X0, i3, i6, new int[i7]);
        int obj10 = obj9.getDimensionPixelOffset(l.Z0, i7);
        setChipSpacingHorizontal(obj9.getDimensionPixelOffset(l.a1, obj10));
        setChipSpacingVertical(obj9.getDimensionPixelOffset(l.b1, obj10));
        setSingleLine(obj9.getBoolean(l.d1, i7));
        setSingleSelection(obj9.getBoolean(l.e1, i7));
        setSelectionRequired(obj9.getBoolean(l.c1, i7));
        obj10 = obj9.getResourceId(l.Y0, obj8);
        if (obj10 != obj8) {
            this.D = obj10;
        }
        obj9.recycle();
        super.setOnHierarchyChangeListener(this.C);
        u.v0(this, 1);
    }

    private int getChipCount() {
        int i;
        int i2;
        boolean z;
        i2 = i;
        while (i < getChildCount()) {
            if (childAt instanceof Chip) {
            }
            i++;
            i2++;
        }
        return i2;
    }

    static com.google.android.material.chip.ChipGroup.b i(com.google.android.material.chip.ChipGroup chipGroup) {
        return chipGroup.B;
    }

    static boolean j(com.google.android.material.chip.ChipGroup chipGroup) {
        return chipGroup.E;
    }

    static boolean k(com.google.android.material.chip.ChipGroup chipGroup) {
        return chipGroup.z;
    }

    static void l(com.google.android.material.chip.ChipGroup chipGroup, int i2, boolean z3) {
        chipGroup.v(i2, z3);
    }

    static void m(com.google.android.material.chip.ChipGroup chipGroup, int i2, boolean z3) {
        chipGroup.u(i2, z3);
    }

    static int n(com.google.android.material.chip.ChipGroup chipGroup) {
        return chipGroup.D;
    }

    static boolean o(com.google.android.material.chip.ChipGroup chipGroup) {
        return chipGroup.y;
    }

    static void p(com.google.android.material.chip.ChipGroup chipGroup, int i2) {
        chipGroup.setCheckedId(i2);
    }

    private void setCheckedId(int i) {
        u(i, true);
    }

    private void u(int i, boolean z2) {
        boolean z;
        this.D = i;
        final com.google.android.material.chip.ChipGroup.d dVar = this.A;
        if (dVar != null && this.y && z2) {
            if (this.y) {
                if (z2) {
                    dVar.a(this, i);
                }
            }
        }
    }

    private void v(int i, boolean z2) {
        boolean z;
        View obj2;
        obj2 = findViewById(i);
        if (obj2 instanceof Chip) {
            this.E = true;
            (Chip)obj2.setChecked(z2);
            this.E = false;
        }
    }

    @Override // com.google.android.material.internal.c
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        boolean obj;
        boolean checked;
        int i;
        obj = view;
        checked = this.D;
        if (view instanceof Chip && (Chip)obj.isChecked() && checked != -1 && this.y) {
            obj = view;
            if ((Chip)obj.isChecked()) {
                checked = this.D;
                if (checked != -1) {
                    if (this.y) {
                        v(checked, false);
                    }
                }
                setCheckedId(obj.getId());
            }
        }
        super.addView(view, i2, layoutParams3);
    }

    @Override // com.google.android.material.internal.c
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        ViewGroup.LayoutParams obj2;
        if (super.checkLayoutParams(layoutParams) && layoutParams instanceof ChipGroup.c) {
            obj2 = layoutParams instanceof ChipGroup.c ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.android.material.internal.c
    public boolean g() {
        return super.g();
    }

    @Override // com.google.android.material.internal.c
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        final int i = -2;
        ChipGroup.c cVar = new ChipGroup.c(i, i);
        return cVar;
    }

    @Override // com.google.android.material.internal.c
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ChipGroup.c cVar = new ChipGroup.c(getContext(), attributeSet);
        return cVar;
    }

    @Override // com.google.android.material.internal.c
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        ChipGroup.c cVar = new ChipGroup.c(layoutParams);
        return cVar;
    }

    @Override // com.google.android.material.internal.c
    public int getCheckedChipId() {
        int i;
        i = this.y ? this.D : -1;
        return i;
    }

    public List<Integer> getCheckedChipIds() {
        int i;
        View childAt;
        boolean checked;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            i++;
            arrayList.add(Integer.valueOf(childAt.getId()));
        }
        return arrayList;
    }

    @Override // com.google.android.material.internal.c
    public int getChipSpacingHorizontal() {
        return this.w;
    }

    @Override // com.google.android.material.internal.c
    public int getChipSpacingVertical() {
        return this.x;
    }

    @Override // com.google.android.material.internal.c
    protected void onFinishInflate() {
        int i;
        int i2;
        super.onFinishInflate();
        i = this.D;
        if (i != -1) {
            v(i, true);
            setCheckedId(this.D);
        }
    }

    @Override // com.google.android.material.internal.c
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int chipCount;
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (g()) {
            chipCount = getChipCount();
        } else {
            chipCount = -1;
        }
        i = t() ? 1 : 2;
        c.y0(accessibilityNodeInfo).Z(c.b.a(getRowCount(), chipCount, false, i));
    }

    @Override // com.google.android.material.internal.c
    public void q(int i) {
        int i2;
        boolean z;
        i2 = this.D;
        if (i == i2) {
        }
        final int i3 = -1;
        if (i2 != i3 && this.y) {
            if (this.y) {
                v(i2, false);
            }
        }
        if (i != i3) {
            v(i, true);
        }
        setCheckedId(i);
    }

    @Override // com.google.android.material.internal.c
    public void r() {
        int i;
        View childAt;
        boolean z;
        this.E = true;
        int i3 = 0;
        i = i3;
        while (i < getChildCount()) {
            childAt = getChildAt(i);
            if (childAt instanceof Chip) {
            }
            i++;
            (Chip)childAt.setChecked(i3);
        }
        this.E = i3;
        setCheckedId(-1);
    }

    @Override // com.google.android.material.internal.c
    int s(View view) {
        int i2;
        int i;
        boolean childAt;
        final int i3 = -1;
        if (!view instanceof Chip) {
            return i3;
        }
        i = i2;
        while (i2 < getChildCount()) {
            i2++;
            i++;
        }
        return i3;
    }

    @Override // com.google.android.material.internal.c
    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    @Override // com.google.android.material.internal.c
    public void setChipSpacingHorizontal(int i) {
        if (this.w != i) {
            this.w = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    @Override // com.google.android.material.internal.c
    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    @Override // com.google.android.material.internal.c
    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    @Override // com.google.android.material.internal.c
    public void setChipSpacingVertical(int i) {
        if (this.x != i) {
            this.x = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    @Override // com.google.android.material.internal.c
    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
        throw obj2;
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
        throw obj2;
    }

    @Deprecated
    public void setFlexWrap(int i) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
        throw obj2;
    }

    @Override // com.google.android.material.internal.c
    public void setOnCheckedChangeListener(com.google.android.material.chip.ChipGroup.d chipGroup$d) {
        this.A = d;
    }

    @Override // com.google.android.material.internal.c
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener) {
        ChipGroup.e.a(this.C, onHierarchyChangeListener);
    }

    @Override // com.google.android.material.internal.c
    public void setSelectionRequired(boolean z) {
        this.z = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
        throw obj2;
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
        throw obj2;
    }

    @Override // com.google.android.material.internal.c
    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    @Override // com.google.android.material.internal.c
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    @Override // com.google.android.material.internal.c
    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    @Override // com.google.android.material.internal.c
    public void setSingleSelection(boolean z) {
        if (this.y != z) {
            this.y = z;
            r();
        }
    }

    @Override // com.google.android.material.internal.c
    public boolean t() {
        return this.y;
    }
}
