package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.g.b;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m.a;
import androidx.appcompat.view.menu.n;

/* loaded from: classes.dex */
public class ActionMenuView extends androidx.appcompat.widget.e0 implements g.b, n {

    private int A;
    private int B;
    private int C;
    androidx.appcompat.widget.ActionMenuView.e D;
    private g a;
    private Context b;
    private int c;
    private boolean v;
    private androidx.appcompat.widget.c w;
    private m.a x;
    g.a y;
    private boolean z;

    public interface a {
        public abstract boolean e();

        public abstract boolean f();
    }

    public interface e {
        public abstract boolean onMenuItemClick(MenuItem menuItem);
    }

    private static class b implements m.a {
        @Override // androidx.appcompat.view.menu.m$a
        public void c(g g, boolean z2) {
        }

        @Override // androidx.appcompat.view.menu.m$a
        public boolean d(g g) {
            return 0;
        }
    }

    public static class c extends androidx.appcompat.widget.e0.a {

        @ViewDebug$ExportedProperty
        public boolean c;
        @ViewDebug$ExportedProperty
        public int d;
        @ViewDebug$ExportedProperty
        public int e;
        @ViewDebug$ExportedProperty
        public boolean f;
        @ViewDebug$ExportedProperty
        public boolean g;
        boolean h;
        public c(int i, int i2) {
            super(i, i2);
            this.c = false;
        }

        public c(Context context, AttributeSet attributeSet2) {
            super(context, attributeSet2);
        }

        public c(ViewGroup.LayoutParams viewGroup$LayoutParams) {
            super(layoutParams);
        }

        public c(androidx.appcompat.widget.ActionMenuView.c actionMenuView$c) {
            super(c);
            this.c = c.c;
        }
    }

    private class d implements g.a {

        final androidx.appcompat.widget.ActionMenuView a;
        d(androidx.appcompat.widget.ActionMenuView actionMenuView) {
            this.a = actionMenuView;
            super();
        }

        @Override // androidx.appcompat.view.menu.g$a
        public boolean a(g g, MenuItem menuItem2) {
            androidx.appcompat.widget.ActionMenuView.e obj1;
            obj1 = obj1.D;
            if (obj1 != null && obj1.onMenuItemClick(menuItem2)) {
                obj1 = obj1.onMenuItemClick(menuItem2) ? 1 : 0;
            } else {
            }
            return obj1;
        }

        @Override // androidx.appcompat.view.menu.g$a
        public void b(g g) {
            g.a aVar = view.y;
            if (aVar != null) {
                aVar.b(g);
            }
        }
    }
    public ActionMenuView(Context context) {
        super(context, 0);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        final int obj4 = 0;
        setBaselineAligned(obj4);
        float density = displayMetrics.density;
        this.B = (int)i4;
        this.C = (int)i;
        this.b = context;
        this.c = obj4;
    }

    static int o(View view, int i2, int i3, int i4, int i5) {
        int i;
        int i6;
        int i7;
        int obj7;
        Object obj9;
        final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int obj8 = View.MeasureSpec.makeMeasureSpec(size -= i5, View.MeasureSpec.getMode(i4));
        if (view instanceof ActionMenuItemView != null) {
            obj9 = view;
        } else {
            obj9 = 0;
        }
        final int i9 = 0;
        if (obj9 != null && obj9.i()) {
            obj9 = obj9.i() ? i : i9;
        } else {
        }
        i6 = 2;
        if (i3 > 0) {
            if (obj9 != null) {
                if (i3 >= i6) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(i3 *= i2, Integer.MIN_VALUE), obj8);
                    obj7 = view.getMeasuredWidth();
                    if (obj7 %= i2 != 0) {
                        i7++;
                    }
                    if (obj9 != null && i7 < i6) {
                        if (i7 < i6) {
                        } else {
                            i6 = i7;
                        }
                    } else {
                    }
                } else {
                    i6 = i9;
                }
            } else {
            }
        } else {
        }
        if (!layoutParams.c && obj9 != null) {
            if (obj9 != null) {
            } else {
                i = i9;
            }
        } else {
        }
        layoutParams.f = i;
        layoutParams.d = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 *= i6, 1073741824), obj8);
        return i6;
    }

    private void p(int i, int i2) {
        int mode;
        int z2;
        int i19;
        float f;
        int i9;
        int i26;
        int childAt;
        int cmp;
        int cmp3;
        int size;
        int layoutParams3;
        int i11;
        int i8;
        int i4;
        boolean z;
        int i7;
        int i25;
        int i12;
        int layoutParams;
        int i28;
        int i18;
        int childAt3;
        int view;
        int i20;
        int visibility;
        int layoutParams2;
        int childAt2;
        int i27;
        int i17;
        int i21;
        int i29;
        int i5;
        int i23;
        int i13;
        int i15;
        int i16;
        int i14;
        int i24;
        int cmp2;
        int i6;
        int i3;
        int i10;
        int i30;
        int i22;
        final Object obj = this;
        mode = View.MeasureSpec.getMode(i2);
        size = View.MeasureSpec.getSize(i2);
        paddingTop += paddingBottom;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i43, -2);
        size2 -= i40;
        int i41 = obj.B;
        i28 = i9 / i41;
        i18 = 0;
        if (i28 == 0) {
            obj.setMeasuredDimension(i9, i18);
        }
        i41 += i50;
        int childCount = getChildCount();
        i15 = i13;
        i16 = 0;
        while (i17 < childCount) {
            childAt2 = obj.getChildAt(i17);
            if (childAt2.getVisibility() == 8) {
            } else {
            }
            z = childAt2 instanceof ActionMenuItemView;
            i29++;
            if (z) {
            } else {
            }
            i24 = i57;
            i23 = 0;
            ViewGroup.LayoutParams layoutParams6 = childAt2.getLayoutParams();
            layoutParams6.h = i23;
            layoutParams6.e = i23;
            layoutParams6.d = i23;
            layoutParams6.f = i23;
            layoutParams6.leftMargin = i23;
            layoutParams6.rightMargin = i23;
            if (z && (ActionMenuItemView)childAt2.i()) {
            } else {
            }
            i7 = 0;
            layoutParams6.g = i7;
            if (layoutParams6.c) {
            } else {
            }
            i25 = i28;
            i12 = ActionMenuView.o(childAt2, i42, i25, childMeasureSpec, i43);
            i13 = Math.max(i13, i12);
            if (layoutParams6.f) {
            }
            if (layoutParams6.c) {
            }
            i28 -= i12;
            layoutParams2 = Math.max(layoutParams2, childAt2.getMeasuredHeight());
            visibility = 1;
            if (i12 == visibility) {
            } else {
            }
            childAt2 = layoutParams2;
            i29 = i24;
            i17++;
            size = i14;
            i18 = 0;
            i16 = visibility;
            layoutParams2 = childAt2;
            i21 = 1;
            i15++;
            i25 = 1;
            if ((ActionMenuItemView)childAt2.i()) {
            } else {
            }
            i7 = 1;
            visibility = obj.C;
            i24 = i57;
            i23 = 0;
            childAt2.setPadding(visibility, i23, visibility, i23);
        }
        if (i21 != 0 && i29 == 2) {
            layoutParams = i29 == 2 ? 1 : 0;
        } else {
        }
        childAt3 = 0;
        while (i15 > 0) {
            if (i28 <= 0) {
                break;
            } else {
            }
            i17 = i59;
            layoutParams3 = 0;
            childAt2 = 0;
            i24 = 0;
            while (childAt2 < childCount) {
                view = layoutParams7;
                if (!view.f) {
                } else {
                }
                view = view.d;
                if (view < i17) {
                } else {
                }
                if (view == i17) {
                }
                childAt2++;
                layoutParams2 = i6;
                childAt3 = i3;
                layoutParams3++;
                i24 = view;
                i24 = cmp2 << childAt2;
                i17 = view;
                layoutParams3 = 1;
            }
            i3 = childAt3;
            i16 |= i24;
            if (layoutParams3 > i28) {
                break;
            } else {
            }
            i11 = 0;
            while (i11 < childCount) {
                childAt3 = obj.getChildAt(i11);
                layoutParams2 = childAt3.getLayoutParams();
                z2 = (long)i26;
                if (Long.compare(i60, i61) == 0) {
                } else {
                }
                if (layoutParams != 0 && layoutParams2.g && i28 == 1) {
                } else {
                }
                i22 = layoutParams;
                i26 = 1;
                layoutParams2.d = i31 += i26;
                layoutParams2.h = i26;
                i28--;
                i11++;
                mode = childAt2;
                i9 = i10;
                layoutParams = i22;
                if (layoutParams2.g) {
                } else {
                }
                if (i28 == 1) {
                } else {
                }
                i26 = obj.C;
                i22 = layoutParams;
                layoutParams = 0;
                childAt3.setPadding(i26 + i42, layoutParams, i26, layoutParams);
                if (layoutParams2.d == i17++) {
                }
                i22 = layoutParams;
                i16 |= z2;
            }
            layoutParams2 = i6;
            layoutParams3 = 2;
            childAt3 = 1;
            childAt3 = obj.getChildAt(i11);
            layoutParams2 = childAt3.getLayoutParams();
            z2 = (long)i26;
            if (Long.compare(i60, i61) == 0) {
            } else {
            }
            if (layoutParams != 0 && layoutParams2.g && i28 == 1) {
            } else {
            }
            i22 = layoutParams;
            i26 = 1;
            layoutParams2.d = i31 += i26;
            layoutParams2.h = i26;
            i28--;
            i11++;
            mode = childAt2;
            i9 = i10;
            layoutParams = i22;
            if (layoutParams2.g) {
            } else {
            }
            if (i28 == 1) {
            } else {
            }
            i26 = obj.C;
            i22 = layoutParams;
            layoutParams = 0;
            childAt3.setPadding(i26 + i42, layoutParams, i26, layoutParams);
            if (layoutParams2.d == i17++) {
            }
            i22 = layoutParams;
            i16 |= z2;
            view = layoutParams7;
            if (!view.f) {
            } else {
            }
            view = view.d;
            if (view < i17) {
            } else {
            }
            if (view == i17) {
            }
            childAt2++;
            layoutParams2 = i6;
            childAt3 = i3;
            layoutParams3++;
            i24 = view;
            i24 = cmp2 << childAt2;
            i17 = view;
            layoutParams3 = 1;
        }
        i27 = mode;
        i30 = i9;
        i3 = childAt3;
        i6 = layoutParams2;
        i19 = 1;
        if (i21 == 0 && i29 == i19) {
            childAt = i29 == i19 ? i19 : 0;
        } else {
        }
        if (i28 > 0 && Long.compare(i16, childAt3) != 0) {
            if (Long.compare(i16, childAt3) != 0) {
                if (i28 >= i29 -= i19 && childAt == 0) {
                    if (childAt == 0) {
                        if (i13 > i19) {
                            if (childAt == 0) {
                                layoutParams3 = 1056964608;
                                if (Long.compare(i36, i54) != 0 && !layoutParams4.g) {
                                    if (!layoutParams4.g) {
                                        f -= layoutParams3;
                                    }
                                }
                                childAt = childCount + -1;
                                if (Long.compare(childAt3, i17) != 0 && !layoutParams5.g) {
                                    if (!layoutParams5.g) {
                                        f -= layoutParams3;
                                    }
                                }
                            } else {
                                i5 = 0;
                            }
                            if (Float.compare(f, i34) > 0) {
                                i19 = (int)cmp;
                            } else {
                                i19 = i5;
                            }
                            childAt = i5;
                            i20 = i3;
                            while (childAt < childCount) {
                                if (Long.compare(i17, i13) == 0) {
                                } else {
                                }
                                View childAt6 = obj.getChildAt(childAt);
                                layoutParams = childAt6.getLayoutParams();
                                if (childAt6 instanceof ActionMenuItemView != null) {
                                } else {
                                }
                                if (layoutParams.c) {
                                } else {
                                }
                                layoutParams3 = 1;
                                if (childAt != 0) {
                                }
                                if (childAt != childCount + -1) {
                                }
                                childAt++;
                                layoutParams.rightMargin = i19 / 2;
                                layoutParams.leftMargin = i19 / 2;
                                layoutParams.e = i19;
                                layoutParams3 = 1;
                                layoutParams.h = layoutParams3;
                                layoutParams.rightMargin = i52 /= i28;
                                i20 = layoutParams3;
                                layoutParams.e = i19;
                                layoutParams.h = true;
                                if (childAt == 0 && !layoutParams.g) {
                                } else {
                                }
                                i28 = 2;
                                layoutParams3 = 1;
                                i20 = 1;
                                if (!layoutParams.g) {
                                } else {
                                }
                                layoutParams.leftMargin = i39 /= i28;
                                layoutParams3 = 1;
                                i28 = 2;
                            }
                        } else {
                            i5 = 0;
                            i20 = i3;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        int i32 = 1073741824;
        if (i20 != 0) {
            i20 = i5;
            while (i20 < childCount) {
                childAt = obj.getChildAt(i20);
                layoutParams3 = childAt.getLayoutParams();
                if (!layoutParams3.h) {
                } else {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i45 += i37, i32), childMeasureSpec);
                i20++;
            }
        }
        i8 = i27 != i32 ? i6 : i58;
        obj.setMeasuredDimension(i30, i8);
    }

    @Override // androidx.appcompat.widget.e0
    public boolean a(i i) {
        return this.a.N(i, 0);
    }

    @Override // androidx.appcompat.widget.e0
    public void b(g g) {
        this.a = g;
    }

    @Override // androidx.appcompat.widget.e0
    public void c() {
        final androidx.appcompat.widget.c cVar = this.w;
        if (cVar != null) {
            cVar.A();
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return layoutParams instanceof ActionMenuView.c;
    }

    @Override // androidx.appcompat.widget.e0
    protected androidx.appcompat.widget.ActionMenuView.c d() {
        int i = -2;
        ActionMenuView.c cVar = new ActionMenuView.c(i, i);
        cVar.b = 16;
        return cVar;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return 0;
    }

    @Override // androidx.appcompat.widget.e0
    public androidx.appcompat.widget.ActionMenuView.c e(AttributeSet attributeSet) {
        ActionMenuView.c cVar = new ActionMenuView.c(getContext(), attributeSet);
        return cVar;
    }

    @Override // androidx.appcompat.widget.e0
    protected androidx.appcompat.widget.ActionMenuView.c f(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        androidx.appcompat.widget.ActionMenuView.c cVar;
        int obj2;
        if (layoutParams != null) {
            if (layoutParams instanceof ActionMenuView.c) {
                cVar = new ActionMenuView.c((ActionMenuView.c)layoutParams);
            } else {
                cVar = new ActionMenuView.c(layoutParams);
            }
            if (cVar.b <= 0) {
                cVar.b = 16;
            }
            return cVar;
        }
        return d();
    }

    @Override // androidx.appcompat.widget.e0
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return d();
    }

    @Override // androidx.appcompat.widget.e0
    protected androidx.appcompat.widget.e0.a generateDefaultLayoutParams() {
        return d();
    }

    @Override // androidx.appcompat.widget.e0
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return e(attributeSet);
    }

    @Override // androidx.appcompat.widget.e0
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return f(layoutParams);
    }

    @Override // androidx.appcompat.widget.e0
    public androidx.appcompat.widget.e0.a generateLayoutParams(AttributeSet attributeSet) {
        return e(attributeSet);
    }

    @Override // androidx.appcompat.widget.e0
    protected androidx.appcompat.widget.e0.a generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams) {
        return f(layoutParams);
    }

    @Override // androidx.appcompat.widget.e0
    public Menu getMenu() {
        Object gVar;
        m.a bVar;
        androidx.appcompat.widget.c cVar;
        Context context;
        if (this.a == null) {
            Context context2 = getContext();
            g gVar4 = new g(context2);
            this.a = gVar4;
            ActionMenuView.d dVar = new ActionMenuView.d(this);
            gVar4.V(dVar);
            c cVar3 = new c(context2);
            this.w = cVar3;
            cVar3.L(true);
            if (this.x != null) {
            } else {
                bVar = new ActionMenuView.b();
            }
            this.w.h(bVar);
            this.a.c(this.w, this.b);
            this.w.J(this);
        }
        return this.a;
    }

    @Override // androidx.appcompat.widget.e0
    public Drawable getOverflowIcon() {
        getMenu();
        return this.w.C();
    }

    @Override // androidx.appcompat.widget.e0
    public int getPopupTheme() {
        return this.c;
    }

    @Override // androidx.appcompat.widget.e0
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.e0
    public androidx.appcompat.widget.ActionMenuView.c i() {
        final androidx.appcompat.widget.ActionMenuView.c view = d();
        view.c = true;
        return view;
    }

    @Override // androidx.appcompat.widget.e0
    protected boolean j(int i) {
        int i2;
        View childAt;
        int childCount;
        int obj5;
        i2 = 0;
        if (i == 0) {
            return i2;
        }
        childAt = getChildAt(i + -1);
        final View childAt2 = getChildAt(i);
        if (i < getChildCount() && childAt instanceof ActionMenuView.a) {
            if (childAt instanceof ActionMenuView.a) {
                i2 |= childAt;
            }
        }
        if (i > 0 && childAt2 instanceof ActionMenuView.a) {
            if (childAt2 instanceof ActionMenuView.a) {
                i2 |= obj5;
            }
        }
        return i2;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean k() {
        androidx.appcompat.widget.c cVar;
        int i;
        cVar = this.w;
        if (cVar != null && cVar.D()) {
            i = cVar.D() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean l() {
        androidx.appcompat.widget.c cVar;
        int i;
        cVar = this.w;
        if (cVar != null && cVar.F()) {
            i = cVar.F() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean m() {
        androidx.appcompat.widget.c cVar;
        int i;
        cVar = this.w;
        if (cVar != null && cVar.G()) {
            i = cVar.G() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean n() {
        return this.v;
    }

    @Override // androidx.appcompat.widget.e0
    public void onConfigurationChanged(Configuration configuration) {
        int i;
        androidx.appcompat.widget.c obj2;
        super.onConfigurationChanged(configuration);
        obj2 = this.w;
        obj2.d(false);
        if (obj2 != null && this.w.G()) {
            obj2.d(false);
            if (this.w.G()) {
                this.w.D();
                this.w.M();
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // androidx.appcompat.widget.e0
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i12;
        int rightMargin2;
        int i8;
        int paddingLeft;
        int paddingRight2;
        int i11;
        int i7;
        int visibility2;
        int i9;
        int measuredWidth;
        int i6;
        int i10;
        int rightMargin;
        int leftMargin;
        View childAt;
        int visibility;
        int i;
        int paddingRight;
        final Object obj = this;
        if (!obj.z) {
            super.onLayout(z, i2, i3, i4, i5);
        }
        int childCount = getChildCount();
        i13 /= 2;
        int i20 = i4 - i2;
        i23 -= paddingLeft2;
        paddingRight2 = z0.b(this);
        visibility2 = 0;
        i9 = 0;
        i6 = 0;
        rightMargin = 8;
        leftMargin = 1;
        while (visibility2 < childCount) {
            childAt = obj.getChildAt(visibility2);
            if (childAt.getVisibility() == rightMargin) {
            } else {
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if (layoutParams.c) {
            } else {
            }
            i8 -= i11;
            obj.j(visibility2);
            i6++;
            visibility2++;
            rightMargin = 8;
            leftMargin = 1;
            if (obj.j(visibility2)) {
            }
            int measuredHeight4 = childAt.getMeasuredHeight();
            if (paddingRight2) {
            } else {
            }
            i = rightMargin - measuredWidth;
            i11 = i14 - paddingRight;
            childAt.layout(i, i11, rightMargin, measuredHeight4 += i11);
            i8 -= measuredWidth;
            i9 = leftMargin;
            rightMargin = i + measuredWidth;
            measuredWidth += dividerWidth;
        }
        if (childCount == leftMargin && i9 == 0) {
            if (i9 == 0) {
                View childAt2 = obj.getChildAt(0);
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight = childAt2.getMeasuredHeight();
                i21 -= i27;
                i14 -= i28;
                childAt2.layout(i22, i15, measuredWidth2 += i22, measuredHeight += i15);
            }
        }
        i6 -= i16;
        i12 = i10 > 0 ? i8 / i10 : 0;
        rightMargin2 = 0;
        int i17 = Math.max(rightMargin2, i12);
        if (paddingRight2) {
            width -= paddingRight2;
            i7 = rightMargin2;
            while (i7 < childCount) {
                rightMargin2 = obj.getChildAt(i7);
                paddingRight2 = rightMargin2.getLayoutParams();
                if (rightMargin2.getVisibility() != rightMargin) {
                }
                i7++;
                if (paddingRight2.c) {
                } else {
                }
                paddingLeft -= rightMargin3;
                int measuredWidth4 = rightMargin2.getMeasuredWidth();
                int measuredHeight2 = rightMargin2.getMeasuredHeight();
                i10 = i14 - i32;
                rightMargin2.layout(i24 - measuredWidth4, i10, i24, measuredHeight2 += i10);
                i24 -= visibility2;
            }
        } else {
            paddingLeft = getPaddingLeft();
            i7 = rightMargin2;
            while (i7 < childCount) {
                rightMargin2 = obj.getChildAt(i7);
                paddingRight2 = rightMargin2.getLayoutParams();
                if (rightMargin2.getVisibility() != rightMargin) {
                }
                i7++;
                if (paddingRight2.c) {
                } else {
                }
                paddingLeft += leftMargin2;
                int measuredWidth5 = rightMargin2.getMeasuredWidth();
                int measuredHeight3 = rightMargin2.getMeasuredHeight();
                i10 = i14 - i33;
                rightMargin2.layout(i25, i10, i25 + measuredWidth5, measuredHeight3 += i10);
                i25 += visibility2;
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z2;
        int z;
        int layoutParams;
        int i4;
        layoutParams = 1;
        final int i5 = 0;
        i3 = View.MeasureSpec.getMode(i) == 1073741824 ? layoutParams : i5;
        this.z = i3;
        if (this.z != i3) {
            this.A = i5;
        }
        int size = View.MeasureSpec.getSize(i);
        z2 = this.a;
        if (this.z && z2 != null && size != this.A) {
            z2 = this.a;
            if (z2 != null) {
                if (size != this.A) {
                    this.A = size;
                    z2.M(layoutParams);
                }
            }
        }
        int childCount = getChildCount();
        if (this.z && childCount > 0) {
            if (childCount > 0) {
                p(i, i2);
            } else {
                z = i5;
                while (z < childCount) {
                    layoutParams = getChildAt(z).getLayoutParams();
                    layoutParams.rightMargin = i5;
                    layoutParams.leftMargin = i5;
                    z++;
                }
                super.onMeasure(i, i2);
            }
        } else {
        }
    }

    @Override // androidx.appcompat.widget.e0
    public g q() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.e0
    public void r(m.a m$a, g.a g$a2) {
        this.x = a;
        this.y = a2;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean s() {
        androidx.appcompat.widget.c cVar;
        int i;
        cVar = this.w;
        if (cVar != null && cVar.M()) {
            i = cVar.M() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.widget.e0
    public void setExpandedActionViewsExclusive(boolean z) {
        this.w.I(z);
    }

    @Override // androidx.appcompat.widget.e0
    public void setOnMenuItemClickListener(androidx.appcompat.widget.ActionMenuView.e actionMenuView$e) {
        this.D = e;
    }

    @Override // androidx.appcompat.widget.e0
    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.w.K(drawable);
    }

    @Override // androidx.appcompat.widget.e0
    public void setOverflowReserved(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.widget.e0
    public void setPopupTheme(int i) {
        int contextThemeWrapper;
        Context context;
        int obj3;
        if (this.c != i) {
            this.c = i;
            if (i == 0) {
                this.b = getContext();
            } else {
                contextThemeWrapper = new ContextThemeWrapper(getContext(), i);
                this.b = contextThemeWrapper;
            }
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void setPresenter(androidx.appcompat.widget.c c) {
        this.w = c;
        c.J(this);
    }
}
