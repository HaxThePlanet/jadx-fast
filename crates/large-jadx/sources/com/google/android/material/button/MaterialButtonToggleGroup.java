package com.google.android.material.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.theme.a.a;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.e0.c.b;
import d.h.l.e0.c.c;
import d.h.l.h;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.d0.a;
import f.c.a.e.d0.c;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.k;
import f.c.a.e.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    private static final String C;
    private static final int D;
    private boolean A;
    private int B;
    private final List<com.google.android.material.button.MaterialButtonToggleGroup.d> a;
    private final com.google.android.material.button.MaterialButtonToggleGroup.c b;
    private final com.google.android.material.button.MaterialButtonToggleGroup.f c;
    private final LinkedHashSet<com.google.android.material.button.MaterialButtonToggleGroup.e> v;
    private final Comparator<com.google.android.material.button.MaterialButton> w;
    private Integer[] x;
    private boolean y;
    private boolean z;

    class a implements Comparator<com.google.android.material.button.MaterialButton> {

        final com.google.android.material.button.MaterialButtonToggleGroup a;
        a(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup) {
            this.a = materialButtonToggleGroup;
            super();
        }

        @Override // java.util.Comparator
        public int a(com.google.android.material.button.MaterialButton materialButton, com.google.android.material.button.MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            if (compareTo2 != 0) {
                return compareTo2;
            }
            return Integer.valueOf(this.a.indexOfChild(materialButton)).compareTo(Integer.valueOf(this.a.indexOfChild(materialButton2)));
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((MaterialButton)object, (MaterialButton)object2);
        }
    }

    private static class d {

        private static final c e;
        c a;
        c b;
        c c;
        c d;
        static {
            a aVar = new a(0);
            MaterialButtonToggleGroup.d.e = aVar;
        }

        d(c c, c c2, c c3, c c4) {
            super();
            this.a = c;
            this.b = c3;
            this.c = c4;
            this.d = c2;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.d a(com.google.android.material.button.MaterialButtonToggleGroup.d materialButtonToggleGroup$d) {
            final c cVar = MaterialButtonToggleGroup.d.e;
            MaterialButtonToggleGroup.d dVar = new MaterialButtonToggleGroup.d(cVar, d.d, cVar, d.c);
            return dVar;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.d b(com.google.android.material.button.MaterialButtonToggleGroup.d materialButtonToggleGroup$d, View view2) {
            com.google.android.material.button.MaterialButtonToggleGroup.d obj0;
            if (n.e(view2)) {
                obj0 = MaterialButtonToggleGroup.d.c(d);
            } else {
                obj0 = MaterialButtonToggleGroup.d.d(d);
            }
            return obj0;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.d c(com.google.android.material.button.MaterialButtonToggleGroup.d materialButtonToggleGroup$d) {
            final c cVar2 = MaterialButtonToggleGroup.d.e;
            MaterialButtonToggleGroup.d dVar = new MaterialButtonToggleGroup.d(d.a, d.d, cVar2, cVar2);
            return dVar;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.d d(com.google.android.material.button.MaterialButtonToggleGroup.d materialButtonToggleGroup$d) {
            final c cVar = MaterialButtonToggleGroup.d.e;
            MaterialButtonToggleGroup.d dVar = new MaterialButtonToggleGroup.d(cVar, cVar, d.b, d.c);
            return dVar;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.d e(com.google.android.material.button.MaterialButtonToggleGroup.d materialButtonToggleGroup$d, View view2) {
            com.google.android.material.button.MaterialButtonToggleGroup.d obj0;
            if (n.e(view2)) {
                obj0 = MaterialButtonToggleGroup.d.d(d);
            } else {
                obj0 = MaterialButtonToggleGroup.d.c(d);
            }
            return obj0;
        }

        public static com.google.android.material.button.MaterialButtonToggleGroup.d f(com.google.android.material.button.MaterialButtonToggleGroup.d materialButtonToggleGroup$d) {
            final c cVar2 = MaterialButtonToggleGroup.d.e;
            MaterialButtonToggleGroup.d dVar = new MaterialButtonToggleGroup.d(d.a, cVar2, d.b, cVar2);
            return dVar;
        }
    }

    public interface e {
        public abstract void a(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z3);
    }

    class b extends a {

        final com.google.android.material.button.MaterialButtonToggleGroup d;
        b(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup) {
            this.d = materialButtonToggleGroup;
            super();
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            super.g(view, c2);
            c2.a0(c.c.a(0, 1, MaterialButtonToggleGroup.a(this.d, view), 1, false, (MaterialButton)view.isChecked()));
        }
    }

    private class c implements com.google.android.material.button.MaterialButton.a {

        final com.google.android.material.button.MaterialButtonToggleGroup a;
        private c(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup) {
            this.a = materialButtonToggleGroup;
            super();
        }

        c(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, com.google.android.material.button.MaterialButtonToggleGroup.a materialButtonToggleGroup$a2) {
            super(materialButtonToggleGroup);
        }

        @Override // com.google.android.material.button.MaterialButton$a
        public void a(com.google.android.material.button.MaterialButton materialButton, boolean z2) {
            boolean z;
            com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup;
            int i;
            boolean obj3;
            boolean obj4;
            if (MaterialButtonToggleGroup.b(this.a)) {
            }
            if (MaterialButtonToggleGroup.c(this.a)) {
                if (z2) {
                    i = materialButton.getId();
                } else {
                    i = -1;
                }
                MaterialButtonToggleGroup.d(this.a, i);
            }
            if (MaterialButtonToggleGroup.e(this.a, materialButton.getId(), z2)) {
                MaterialButtonToggleGroup.f(this.a, materialButton.getId(), materialButton.isChecked());
            }
            this.a.invalidate();
        }
    }

    private class f implements com.google.android.material.button.MaterialButton.b {

        final com.google.android.material.button.MaterialButtonToggleGroup a;
        private f(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup) {
            this.a = materialButtonToggleGroup;
            super();
        }

        f(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, com.google.android.material.button.MaterialButtonToggleGroup.a materialButtonToggleGroup$a2) {
            super(materialButtonToggleGroup);
        }

        @Override // com.google.android.material.button.MaterialButton$b
        public void a(com.google.android.material.button.MaterialButton materialButton, boolean z2) {
            this.a.invalidate();
        }
    }
    static {
        MaterialButtonToggleGroup.C = MaterialButtonToggleGroup.class.getSimpleName();
        MaterialButtonToggleGroup.D = k.x;
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.A);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet2, int i3) {
        final int i5 = MaterialButtonToggleGroup.D;
        super(a.c(context, attributeSet2, i3, i5), attributeSet2, i3);
        ArrayList obj7 = new ArrayList();
        this.a = obj7;
        int i = 0;
        obj7 = new MaterialButtonToggleGroup.c(this, i);
        this.b = obj7;
        obj7 = new MaterialButtonToggleGroup.f(this, i);
        this.c = obj7;
        obj7 = new LinkedHashSet();
        this.v = obj7;
        obj7 = new MaterialButtonToggleGroup.a(this);
        this.w = obj7;
        obj7 = 0;
        this.y = obj7;
        final TypedArray obj8 = l.h(getContext(), attributeSet2, l.t2, i3, i5, new int[obj7]);
        setSingleSelection(obj8.getBoolean(l.w2, obj7));
        this.B = obj8.getResourceId(l.u2, -1);
        this.A = obj8.getBoolean(l.v2, obj7);
        obj7 = 1;
        setChildrenDrawingOrderEnabled(obj7);
        obj8.recycle();
        u.v0(this, obj7);
    }

    static int a(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, View view2) {
        return materialButtonToggleGroup.o(view2);
    }

    static boolean b(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup) {
        return materialButtonToggleGroup.y;
    }

    static boolean c(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup) {
        return materialButtonToggleGroup.z;
    }

    static int d(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, int i2) {
        materialButtonToggleGroup.B = i2;
        return i2;
    }

    static boolean e(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z3) {
        return materialButtonToggleGroup.v(i2, z3);
    }

    static void f(com.google.android.material.button.MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z3) {
        materialButtonToggleGroup.m(i2, z3);
    }

    private int getFirstVisibleChildIndex() {
        int i;
        boolean z;
        i = 0;
        while (i < getChildCount()) {
            i++;
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        int i;
        boolean z;
        childCount--;
        while (i >= 0) {
            i--;
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2;
        int i;
        boolean z;
        i = i2;
        while (i2 < getChildCount()) {
            if (childAt instanceof MaterialButton && q(i2)) {
            }
            i2++;
            if (q(i2)) {
            }
            i++;
        }
        return i;
    }

    private void h() {
        int i3;
        com.google.android.material.button.MaterialButton materialButton;
        int i;
        LinearLayout.LayoutParams layoutParams;
        int orientation;
        int i2;
        final int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
        }
        i3 = firstVisibleChildIndex + 1;
        while (i3 < getChildCount()) {
            materialButton = n(i3);
            int i6 = Math.min(materialButton.getStrokeWidth(), n(i3 + -1).getStrokeWidth());
            layoutParams = i(materialButton);
            i2 = 0;
            if (getOrientation() == 0) {
            } else {
            }
            layoutParams.bottomMargin = i2;
            layoutParams.topMargin = -i6;
            h.d(layoutParams, i2);
            materialButton.setLayoutParams(layoutParams);
            i3++;
            h.c(layoutParams, i2);
            h.d(layoutParams, -i6);
            layoutParams.topMargin = i2;
        }
        s(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams i(View view) {
        ViewGroup.LayoutParams obj3 = view.getLayoutParams();
        if (obj3 instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams)obj3;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(obj3.width, obj3.height);
        return layoutParams;
    }

    private void k(int i, boolean z2) {
        final View obj1 = findViewById(i);
        if ((MaterialButton)obj1 != null) {
            (MaterialButton)obj1.setChecked(z2);
        }
    }

    private void m(int i, boolean z2) {
        Object next;
        Iterator iterator = this.v.iterator();
        for (MaterialButtonToggleGroup.e next : iterator) {
            next.a(this, i, z2);
        }
    }

    private com.google.android.material.button.MaterialButton n(int i) {
        return (MaterialButton)getChildAt(i);
    }

    private int o(View view) {
        int i;
        int i2;
        boolean z;
        final int i3 = -1;
        if (!view instanceof MaterialButton) {
            return i3;
        }
        i2 = i;
        while (i < getChildCount()) {
            if (childAt2 instanceof MaterialButton && q(i)) {
            }
            i++;
            if (q(i)) {
            }
            i2++;
        }
        return i3;
    }

    private com.google.android.material.button.MaterialButtonToggleGroup.d p(int i, int i2, int i3) {
        int i4;
        com.google.android.material.button.MaterialButtonToggleGroup.d obj3;
        Object obj = this.a.get(i);
        if (i2 == i3) {
            return (MaterialButtonToggleGroup.d)obj;
        }
        i4 = getOrientation() == 0 ? 1 : 0;
        if (i == i2) {
            if (i4 != 0) {
                obj3 = MaterialButtonToggleGroup.d.e(obj, this);
            } else {
                obj3 = MaterialButtonToggleGroup.d.f(obj);
            }
            return obj3;
        }
        if (i == i3) {
            if (i4 != 0) {
                obj3 = MaterialButtonToggleGroup.d.b(obj, this);
            } else {
                obj3 = MaterialButtonToggleGroup.d.a(obj);
            }
            return obj3;
        }
        return null;
    }

    private boolean q(int i) {
        int obj2;
        obj2 = getChildAt(i).getVisibility() != 8 ? 1 : 0;
        return obj2;
    }

    private void s(int i) {
        int childCount;
        int i2;
        int i3;
        int obj4;
        if (getChildCount() != 0) {
            if (i == -1) {
            } else {
                obj4 = n(i).getLayoutParams();
                i3 = 0;
                if (getOrientation() == 1) {
                    obj4.topMargin = i3;
                    obj4.bottomMargin = i3;
                }
                h.c((LinearLayout.LayoutParams)obj4, i3);
                h.d(obj4, i3);
                obj4.leftMargin = i3;
                obj4.rightMargin = i3;
            }
        }
    }

    private void setCheckedId(int i) {
        this.B = i;
        m(i, true);
    }

    private void setGeneratedIdIfNeeded(com.google.android.material.button.MaterialButton materialButton) {
        int i;
        if (materialButton.getId() == -1) {
            materialButton.setId(u.k());
        }
    }

    private void setupButtonChild(com.google.android.material.button.MaterialButton materialButton) {
        final int i = 1;
        materialButton.setMaxLines(i);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(i);
        materialButton.b(this.b);
        materialButton.setOnPressedChangeListenerInternal(this.c);
        materialButton.setShouldDrawSurfaceColorStroke(i);
    }

    private void t(int i, boolean z2) {
        boolean z;
        View obj2;
        obj2 = findViewById(i);
        if (obj2 instanceof MaterialButton) {
            this.y = true;
            (MaterialButton)obj2.setChecked(z2);
            this.y = false;
        }
    }

    private static void u(k.b k$b, com.google.android.material.button.MaterialButtonToggleGroup.d materialButtonToggleGroup$d2) {
        if (d2 == null) {
            b.o(0);
        }
        b.D(d2.a);
        b.v(d2.d);
        b.H(d2.b);
        b.z(d2.c);
    }

    private boolean v(int i, boolean z2) {
        boolean empty;
        int obj5;
        boolean obj6;
        final List checkedButtonIds = getCheckedButtonIds();
        final int i2 = 1;
        final int i3 = 0;
        if (this.A && checkedButtonIds.isEmpty()) {
            if (checkedButtonIds.isEmpty()) {
                t(i, i2);
                this.B = i;
                return i3;
            }
        }
        if (z2 && this.z) {
            if (this.z) {
                checkedButtonIds.remove(Integer.valueOf(i));
                obj5 = checkedButtonIds.iterator();
                for (Integer obj6 : obj5) {
                    obj6 = obj6.intValue();
                    t(obj6, i3);
                    m(obj6, i3);
                }
            }
        }
        return i2;
    }

    private void w() {
        int i;
        com.google.android.material.button.MaterialButton materialButton;
        Integer valueOf;
        TreeMap treeMap = new TreeMap(this.w);
        final int i2 = 0;
        i = i2;
        while (i < getChildCount()) {
            treeMap.put(n(i), Integer.valueOf(i));
            i++;
        }
        this.x = (Integer[])treeMap.values().toArray(new Integer[i2]);
    }

    @Override // android.widget.LinearLayout
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        boolean obj6;
        ViewGroup.LayoutParams obj7;
        if (!view instanceof MaterialButton) {
            Log.e(MaterialButtonToggleGroup.C, "Child views must be of type MaterialButton.");
        }
        super.addView(view, i2, layoutParams3);
        setGeneratedIdIfNeeded((MaterialButton)view);
        setupButtonChild(view);
        if (view.isChecked()) {
            v(view.getId(), true);
            setCheckedId(view.getId());
        }
        obj6 = view.getShapeAppearanceModel();
        MaterialButtonToggleGroup.d dVar = new MaterialButtonToggleGroup.d(obj6.r(), obj6.j(), obj6.t(), obj6.l());
        this.a.add(dVar);
        obj6 = new MaterialButtonToggleGroup.b(this);
        u.l0(view, obj6);
    }

    @Override // android.widget.LinearLayout
    protected void dispatchDraw(Canvas canvas) {
        w();
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout
    public void g(com.google.android.material.button.MaterialButtonToggleGroup.e materialButtonToggleGroup$e) {
        this.v.add(e);
    }

    @Override // android.widget.LinearLayout
    public java.lang.CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @Override // android.widget.LinearLayout
    public int getCheckedButtonId() {
        int i;
        i = this.z ? this.B : -1;
        return i;
    }

    public List<Integer> getCheckedButtonIds() {
        int i;
        com.google.android.material.button.MaterialButton valueOf;
        boolean checked;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < getChildCount()) {
            valueOf = n(i);
            if (valueOf.isChecked()) {
            }
            i++;
            arrayList.add(Integer.valueOf(valueOf.getId()));
        }
        return arrayList;
    }

    @Override // android.widget.LinearLayout
    protected int getChildDrawingOrder(int i, int i2) {
        int length;
        Integer[] obj2 = this.x;
        if (obj2 != null && i2 >= obj2.length) {
            if (i2 >= obj2.length) {
            }
            return obj2[i2].intValue();
        }
        Log.w(MaterialButtonToggleGroup.C, "Child order wasn't updated");
        return i2;
    }

    @Override // android.widget.LinearLayout
    public void j(int i) {
        if (i == this.B) {
        }
        k(i, true);
    }

    @Override // android.widget.LinearLayout
    public void l() {
        int i2;
        int i;
        this.y = true;
        int i4 = 0;
        i2 = i4;
        while (i2 < getChildCount()) {
            com.google.android.material.button.MaterialButton materialButton = n(i2);
            materialButton.setChecked(i4);
            m(materialButton.getId(), i4);
            i2++;
        }
        this.y = i4;
        setCheckedId(-1);
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        int i;
        super.onFinishInflate();
        final int i2 = this.B;
        if (i2 != -1) {
            k(i2, true);
        }
    }

    @Override // android.widget.LinearLayout
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        final int i2 = 1;
        i = r() ? i2 : 2;
        c.y0(accessibilityNodeInfo).Z(c.b.a(i2, getVisibleButtonCount(), false, i));
    }

    @Override // android.widget.LinearLayout
    protected void onMeasure(int i, int i2) {
        x();
        h();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.LinearLayout
    public void onViewRemoved(View view) {
        boolean view2;
        int i;
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            view2 = view;
            (MaterialButton)view2.i(this.b);
            view2.setOnPressedChangeListenerInternal(0);
        }
        final int obj3 = indexOfChild(view);
        if (obj3 >= 0) {
            this.a.remove(obj3);
        }
        x();
        h();
    }

    @Override // android.widget.LinearLayout
    public boolean r() {
        return this.z;
    }

    @Override // android.widget.LinearLayout
    public void setSelectionRequired(boolean z) {
        this.A = z;
    }

    @Override // android.widget.LinearLayout
    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    @Override // android.widget.LinearLayout
    public void setSingleSelection(boolean z) {
        if (this.z != z) {
            this.z = z;
            l();
        }
    }

    @Override // android.widget.LinearLayout
    void x() {
        int i;
        com.google.android.material.button.MaterialButton materialButton;
        int visibility;
        int i2;
        i = 0;
        while (i < getChildCount()) {
            materialButton = n(i);
            if (materialButton.getVisibility() == 8) {
            } else {
            }
            k.b bVar = materialButton.getShapeAppearanceModel().v();
            MaterialButtonToggleGroup.u(bVar, p(i, getFirstVisibleChildIndex(), getLastVisibleChildIndex()));
            materialButton.setShapeAppearanceModel(bVar.m());
            i++;
        }
    }
}
