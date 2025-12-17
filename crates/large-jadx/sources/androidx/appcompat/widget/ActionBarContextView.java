package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.g;
import d.a.a;
import d.a.f;
import d.a.g;
import d.a.j;
import d.a.o.b;
import d.h.l.u;

/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {

    private java.lang.CharSequence A;
    private java.lang.CharSequence B;
    private View C;
    private View D;
    private LinearLayout E;
    private TextView F;
    private TextView G;
    private int H;
    private int I;
    private boolean J;
    private int K;

    class a implements View.OnClickListener {

        final b a;
        a(androidx.appcompat.widget.ActionBarContextView actionBarContextView, b b2) {
            this.a = b2;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.c();
        }
    }
    public ActionBarContextView(Context context) {
        super(context, 0);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.j);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        final int i = 0;
        final androidx.appcompat.widget.t0 obj3 = t0.v(context, attributeSet2, j.x, i3, i);
        u.o0(this, obj3.g(j.y));
        this.H = obj3.n(j.C, i);
        this.I = obj3.n(j.B, i);
        this.w = obj3.m(j.A, i);
        this.K = obj3.n(j.z, g.d);
        obj3.w();
    }

    private void i() {
        int i2;
        LinearLayout linearLayout;
        Object parent;
        int context;
        int i4;
        int i3;
        int i;
        LayoutInflater.from(getContext()).inflate(g.a, this);
        View childAt = getChildAt(childCount--);
        this.E = (LinearLayout)childAt;
        this.F = (TextView)childAt.findViewById(f.e);
        this.G = (TextView)this.E.findViewById(f.d);
        if (this.E == null && this.H != 0) {
            LayoutInflater.from(getContext()).inflate(g.a, this);
            childAt = getChildAt(childCount--);
            this.E = (LinearLayout)childAt;
            this.F = (TextView)childAt.findViewById(f.e);
            this.G = (TextView)this.E.findViewById(f.d);
            if (this.H != 0) {
                this.F.setTextAppearance(getContext(), this.H);
            }
            if (this.I != 0) {
                this.G.setTextAppearance(getContext(), this.I);
            }
        }
        this.F.setText(this.A);
        this.G.setText(this.B);
        empty2 ^= 1;
        final int i10 = 8;
        i = i9 != 0 ? i3 : i10;
        this.G.setVisibility(i);
        if (empty ^= 1 == 0) {
            if (i9 != 0) {
            } else {
                i3 = i10;
            }
        }
        this.E.setVisibility(i3);
        if (this.E.getParent() == null) {
            addView(this.E);
        }
    }

    @Override // androidx.appcompat.widget.a
    public void g() {
        if (this.C == null) {
            k();
        }
    }

    @Override // androidx.appcompat.widget.a
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        return marginLayoutParams;
    }

    @Override // androidx.appcompat.widget.a
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
        return marginLayoutParams;
    }

    @Override // androidx.appcompat.widget.a
    public int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // androidx.appcompat.widget.a
    public java.lang.CharSequence getSubtitle() {
        return this.B;
    }

    @Override // androidx.appcompat.widget.a
    public java.lang.CharSequence getTitle() {
        return this.A;
    }

    @Override // androidx.appcompat.widget.a
    public void h(b b) {
        Object inflate;
        int i2;
        int i;
        View view = this.C;
        if (view == null) {
            inflate = LayoutInflater.from(getContext()).inflate(this.K, this, false);
            this.C = inflate;
            addView(inflate);
        } else {
            if (view.getParent() == null) {
                addView(this.C);
            }
        }
        ActionBarContextView.a aVar = new ActionBarContextView.a(this, b);
        this.C.findViewById(f.i).setOnClickListener(aVar);
        androidx.appcompat.widget.c cVar = this.v;
        if (cVar != null) {
            cVar.A();
        }
        c cVar2 = new c(getContext());
        this.v = cVar2;
        cVar2.L(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        (g)b.e().c(this.v, this.b);
        androidx.appcompat.view.menu.n obj4 = this.v.q(this);
        this.c = (ActionMenuView)obj4;
        u.o0(obj4, 0);
        addView(this.c, layoutParams);
    }

    @Override // androidx.appcompat.widget.a
    public boolean j() {
        return this.J;
    }

    @Override // androidx.appcompat.widget.a
    public void k() {
        removeAllViews();
        final int i = 0;
        this.D = i;
        this.c = i;
    }

    @Override // androidx.appcompat.widget.a
    public boolean l() {
        androidx.appcompat.widget.c cVar = this.v;
        if (cVar != null) {
            return cVar.M();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.a
    public void onDetachedFromWindow() {
        androidx.appcompat.widget.c cVar;
        super.onDetachedFromWindow();
        cVar = this.v;
        if (cVar != null) {
            cVar.D();
            this.v.E();
        }
    }

    @Override // androidx.appcompat.widget.a
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        java.lang.CharSequence eventType;
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.A);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // androidx.appcompat.widget.a
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft;
        LinearLayout visibility;
        int paddingRight;
        View view;
        int rightMargin;
        int i8;
        int i7;
        int i;
        int i6;
        boolean z2;
        int paddingTop;
        int i9;
        boolean obj10;
        int obj11;
        int obj13;
        View obj14;
        obj10 = z0.b(this);
        if (obj10 != null) {
            i11 -= paddingRight;
        } else {
            paddingLeft = getPaddingLeft();
        }
        paddingTop = getPaddingTop();
        int obj12 = obj14 - obj12;
        obj14 = this.C;
        final int i13 = 8;
        if (obj14 != null && obj14.getVisibility() != i13) {
            if (obj14.getVisibility() != i13) {
                obj14 = this.C.getLayoutParams();
                rightMargin = obj10 != null ? obj14.rightMargin : obj14.leftMargin;
                obj14 = obj10 != null ? obj14.leftMargin : obj14.rightMargin;
                int i14 = a.d(paddingLeft, rightMargin, obj10);
                paddingLeft = a.d(i14 += i10, obj14, obj10);
            }
        }
        obj14 = paddingLeft;
        visibility = this.E;
        if (visibility != null && this.D == null && visibility.getVisibility() != i13) {
            if (this.D == null) {
                if (visibility.getVisibility() != i13) {
                    obj14 += visibility;
                }
            }
        }
        view = this.D;
        if (view != null) {
            this.e(view, obj14, paddingTop, obj12, obj10);
        }
        if (obj10 != null) {
            i = obj11;
        } else {
            i = obj13;
        }
        androidx.appcompat.widget.ActionMenuView view4 = this.c;
        if (view4 != null) {
            this.e(view4, i, paddingTop, obj12, obj10 ^= 1);
        }
    }

    @Override // androidx.appcompat.widget.a
    protected void onMeasure(int i, int i2) {
        int childCount;
        int measureSpec3;
        int i3;
        int measureSpec;
        int i9;
        int i7;
        int measureSpec2;
        View height;
        View rightMargin;
        Object parent;
        int i4;
        int width;
        int i5;
        int i8;
        int i6;
        measureSpec3 = 1073741824;
        if (View.MeasureSpec.getMode(i) != measureSpec3) {
        } else {
            if (View.MeasureSpec.getMode(i2) == 0) {
            } else {
                int obj11 = View.MeasureSpec.getSize(i);
                if (this.w > 0) {
                } else {
                    childCount = View.MeasureSpec.getSize(i2);
                }
                obj12 += paddingBottom;
                i9 = childCount - obj12;
                i7 = Integer.MIN_VALUE;
                measureSpec2 = View.MeasureSpec.makeMeasureSpec(i9, i7);
                rightMargin = this.C;
                i5 = 0;
                if (rightMargin != null) {
                    ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
                    i11 -= i8;
                }
                parent = this.c;
                if (parent != null && parent.getParent() == this) {
                    if (parent.getParent() == this) {
                        measureSpec = c(this.c, measureSpec, measureSpec2, i5);
                    }
                }
                width = this.E;
                if (width != null && this.D == null) {
                    if (this.D == null) {
                        if (this.J) {
                            this.E.measure(View.MeasureSpec.makeMeasureSpec(i5, i5), measureSpec2);
                            int measuredWidth = this.E.getMeasuredWidth();
                            i4 = measuredWidth <= measureSpec ? 1 : i5;
                            if (i4 != 0) {
                                measureSpec -= measuredWidth;
                            }
                            width = i4 != 0 ? i5 : 8;
                            this.E.setVisibility(width);
                        } else {
                            measureSpec = c(width, measureSpec, measureSpec2, i5);
                        }
                    }
                }
                height = this.D;
                if (height != null) {
                    ViewGroup.LayoutParams layoutParams = height.getLayoutParams();
                    width = layoutParams.width;
                    i8 = -2;
                    i6 = width != i8 ? measureSpec3 : i7;
                    if (width >= 0) {
                        measureSpec = Math.min(width, measureSpec);
                    }
                    height = layoutParams.height;
                    if (height != i8) {
                    } else {
                        measureSpec3 = i7;
                    }
                    if (height >= 0) {
                        i9 = Math.min(height, i9);
                    }
                    this.D.measure(View.MeasureSpec.makeMeasureSpec(measureSpec, i6), View.MeasureSpec.makeMeasureSpec(i9, measureSpec3));
                }
                if (this.w <= 0) {
                    i3 = i5;
                    while (i5 < getChildCount()) {
                        measuredHeight += obj12;
                        if (measureSpec > i3) {
                        }
                        i5++;
                        i3 = measureSpec;
                    }
                    setMeasuredDimension(obj11, i3);
                } else {
                    setMeasuredDimension(obj11, childCount);
                }
            }
            StringBuilder obj12 = new StringBuilder();
            obj12.append(getClass().getSimpleName());
            obj12.append(" can only be used with android:layout_height=\"wrap_content\"");
            obj11 = new IllegalStateException(obj12.toString());
            throw obj11;
        }
        obj12 = new StringBuilder();
        obj12.append(getClass().getSimpleName());
        obj12.append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        obj11 = new IllegalStateException(obj12.toString());
        throw obj11;
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i) {
        this.w = i;
    }

    @Override // androidx.appcompat.widget.a
    public void setCustomView(View view) {
        View view2;
        view2 = this.D;
        if (view2 != null) {
            removeView(view2);
        }
        this.D = view;
        view2 = this.E;
        if (view != null && view2 != null) {
            view2 = this.E;
            if (view2 != null) {
                removeView(view2);
                this.E = 0;
            }
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    @Override // androidx.appcompat.widget.a
    public void setSubtitle(java.lang.CharSequence charSequence) {
        this.B = charSequence;
        i();
    }

    @Override // androidx.appcompat.widget.a
    public void setTitle(java.lang.CharSequence charSequence) {
        this.A = charSequence;
        i();
    }

    @Override // androidx.appcompat.widget.a
    public void setTitleOptional(boolean z) {
        if (z != this.J) {
            requestLayout();
        }
        this.J = z;
    }

    @Override // androidx.appcompat.widget.a
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.a
    public boolean shouldDelayChildPressedState() {
        return 0;
    }
}
