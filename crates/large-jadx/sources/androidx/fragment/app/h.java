package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import d.h.l.d0;
import d.h.l.u;
import d.m.c;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h extends FrameLayout {

    private ArrayList<View> a;
    private ArrayList<View> b;
    private View.OnApplyWindowInsetsListener c;
    private boolean v = true;
    h(Context context, AttributeSet attributeSet2, androidx.fragment.app.n n3) {
        String classAttribute;
        int i;
        Object classLoader;
        String obj6;
        Object obj7;
        super(context, attributeSet2);
        TypedArray styledAttributes = context.obtainStyledAttributes(attributeSet2, c.e);
        if (attributeSet2.getClassAttribute() == null) {
            classAttribute = styledAttributes.getString(c.f);
        }
        String string = styledAttributes.getString(c.g);
        styledAttributes.recycle();
        i = getId();
        if (classAttribute != null && n3.j0(i) == null && i <= 0) {
            if (n3.j0(i) == null) {
                if (i <= 0) {
                    if (string != null) {
                        obj6 = new StringBuilder();
                        obj6.append(" with tag ");
                        obj6.append(string);
                        obj6 = obj6.toString();
                    } else {
                        obj6 = "";
                    }
                    StringBuilder obj8 = new StringBuilder();
                    obj8.append("FragmentContainerView must have an android:id to add Fragment ");
                    obj8.append(classAttribute);
                    obj8.append(obj6);
                    obj7 = new IllegalStateException(obj8.toString());
                    throw obj7;
                }
                classAttribute = n3.t0().a(context.getClassLoader(), classAttribute);
                classAttribute.onInflate(context, attributeSet2, 0);
                obj6 = n3.n();
                obj6.s(true);
                obj6.c(this, classAttribute, string);
                obj6.j();
            }
        }
        n3.X0(this);
    }

    private void a(View view) {
        ArrayList arrayList;
        ArrayList contains;
        contains = this.b;
        if (contains != null && contains.contains(view) && this.a == null) {
            if (contains.contains(view)) {
                if (this.a == null) {
                    arrayList = new ArrayList();
                    this.a = arrayList;
                }
                this.a.add(view);
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void addView(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3) {
        if (n.C0(view) == null) {
        } else {
            super.addView(view, i2, layoutParams3);
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        obj4.append(view);
        obj4.append(" is not associated with a Fragment.");
        IllegalStateException obj3 = new IllegalStateException(obj4.toString());
        throw obj3;
    }

    @Override // android.widget.FrameLayout
    protected boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams viewGroup$LayoutParams3, boolean z4) {
        if (n.C0(view) == null) {
        } else {
            return super.addViewInLayout(view, i2, layoutParams3, z4);
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Views added to a FragmentContainerView must be associated with a Fragment. View ");
        obj4.append(view);
        obj4.append(" is not associated with a Fragment.");
        IllegalStateException obj3 = new IllegalStateException(obj4.toString());
        throw obj3;
    }

    @Override // android.widget.FrameLayout
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        d0 d0Var;
        boolean childCount;
        int i;
        View childAt;
        View.OnApplyWindowInsetsListener list = this.c;
        if (list != null) {
            d0Var = d0.v(list.onApplyWindowInsets(this, windowInsets));
        } else {
            d0Var = u.Y(this, d0.v(windowInsets));
        }
        if (!d0Var.o()) {
            i = 0;
            while (i < getChildCount()) {
                u.h(getChildAt(i), d0Var);
                i++;
            }
        }
        return windowInsets;
    }

    @Override // android.widget.FrameLayout
    protected void dispatchDraw(Canvas canvas) {
        int z;
        Object size;
        long drawingTime;
        if (this.v && this.a != null) {
            if (this.a != null) {
                z = 0;
                while (z < this.a.size()) {
                    super.drawChild(canvas, (View)this.a.get(z), getDrawingTime());
                    z++;
                }
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.FrameLayout
    protected boolean drawChild(Canvas canvas, View view2, long l3) {
        boolean contains;
        contains = this.a;
        if (this.v && contains != null && contains.size() > 0 && this.a.contains(view2)) {
            contains = this.a;
            if (contains != null) {
                if (contains.size() > 0) {
                    if (this.a.contains(view2)) {
                        return 0;
                    }
                }
            }
        }
        return super.drawChild(canvas, view2, l3);
    }

    @Override // android.widget.FrameLayout
    public void endViewTransition(View view) {
        ArrayList remove;
        remove = this.b;
        remove.remove(view);
        remove = this.a;
        if (remove != null && remove != null && remove.remove(view)) {
            remove.remove(view);
            remove = this.a;
            if (remove != null) {
                if (remove.remove(view)) {
                    this.v = true;
                }
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.widget.FrameLayout
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.widget.FrameLayout
    public void removeAllViewsInLayout() {
        int i;
        View childAt;
        childCount--;
        while (i >= 0) {
            a(getChildAt(i));
            i--;
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.widget.FrameLayout
    protected void removeDetachedView(View view, boolean z2) {
        if (z2) {
            a(view);
        }
        super.removeDetachedView(view, z2);
    }

    @Override // android.widget.FrameLayout
    public void removeView(View view) {
        a(view);
        super.removeView(view);
    }

    @Override // android.widget.FrameLayout
    public void removeViewAt(int i) {
        a(getChildAt(i));
        super.removeViewAt(i);
    }

    @Override // android.widget.FrameLayout
    public void removeViewInLayout(View view) {
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.widget.FrameLayout
    public void removeViews(int i, int i2) {
        int i3;
        View childAt;
        i3 = i;
        while (i3 < i + i2) {
            a(getChildAt(i3));
            i3++;
        }
        super.removeViews(i, i2);
    }

    @Override // android.widget.FrameLayout
    public void removeViewsInLayout(int i, int i2) {
        int i3;
        View childAt;
        i3 = i;
        while (i3 < i + i2) {
            a(getChildAt(i3));
            i3++;
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.widget.FrameLayout
    void setDrawDisappearingViewsLast(boolean z) {
        this.v = z;
    }

    @Override // android.widget.FrameLayout
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT >= 18) {
        } else {
            super.setLayoutTransition(layoutTransition);
        }
        UnsupportedOperationException obj3 = new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        throw obj3;
    }

    @Override // android.widget.FrameLayout
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener view$OnApplyWindowInsetsListener) {
        this.c = onApplyWindowInsetsListener;
    }

    @Override // android.widget.FrameLayout
    public void startViewTransition(View view) {
        ArrayList arrayList;
        Object parent;
        if (view.getParent() == this && this.b == null) {
            if (this.b == null) {
                arrayList = new ArrayList();
                this.b = arrayList;
            }
            this.b.add(view);
        }
        super.startViewTransition(view);
    }
}
