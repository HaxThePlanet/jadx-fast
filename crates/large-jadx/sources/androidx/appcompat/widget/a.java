package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import d.a.a;
import d.a.j;
import d.h.l.a0;
import d.h.l.u;
import d.h.l.z;

/* loaded from: classes.dex */
abstract class a extends ViewGroup {

    protected final androidx.appcompat.widget.a.a a;
    protected final Context b;
    protected androidx.appcompat.widget.ActionMenuView c;
    protected androidx.appcompat.widget.c v;
    protected int w;
    protected z x;
    private boolean y;
    private boolean z;

    protected class a implements a0 {

        private boolean a = false;
        int b;
        final androidx.appcompat.widget.a c;
        protected a(androidx.appcompat.widget.a a) {
            this.c = a;
            super();
            final int obj1 = 0;
        }

        @Override // d.h.l.a0
        public void a(View view) {
            this.a = true;
        }

        @Override // d.h.l.a0
        public void b(View view) {
            if (this.a) {
            }
            androidx.appcompat.widget.a obj2 = this.c;
            obj2.x = 0;
            a.b(obj2, this.b);
        }

        @Override // d.h.l.a0
        public void c(View view) {
            final int i = 0;
            a.a(this.c, i);
            this.a = i;
        }

        @Override // d.h.l.a0
        public androidx.appcompat.widget.a.a d(z z, int i2) {
            aVar.x = z;
            this.b = i2;
            return this;
        }
    }
    a(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    a(Context context, AttributeSet attributeSet2, int i3) {
        TypedValue obj4;
        boolean obj5;
        super(context, attributeSet2, i3);
        obj4 = new a.a(this);
        this.a = obj4;
        obj4 = new TypedValue();
        if (context.getTheme().resolveAttribute(a.a, obj4, true) && obj4.resourceId != 0) {
            if (obj4.resourceId != 0) {
                obj5 = new ContextThemeWrapper(context, obj4.resourceId);
                this.b = obj5;
            } else {
                this.b = context;
            }
        } else {
        }
    }

    static void a(androidx.appcompat.widget.a a, int i2) {
        super.setVisibility(i2);
    }

    static void b(androidx.appcompat.widget.a a, int i2) {
        super.setVisibility(i2);
    }

    protected static int d(int i, int i2, boolean z3) {
        int obj0;
        obj0 = z3 ? i - i2 : i + i2;
        return obj0;
    }

    @Override // android.view.ViewGroup
    protected int c(View view, int i2, int i3, int i4) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE), i3);
        return Math.max(0, obj3 -= i4);
    }

    @Override // android.view.ViewGroup
    protected int e(View view, int i2, int i3, int i4, boolean z5) {
        int measuredWidth;
        int i;
        int obj6;
        measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        i3 += obj6;
        if (z5) {
            view.layout(i2 - measuredWidth, obj5, i2, measuredHeight += obj5);
        } else {
            view.layout(i2, obj5, i2 + measuredWidth, measuredHeight += obj5);
        }
        if (z5) {
            measuredWidth = -measuredWidth;
        }
        return measuredWidth;
    }

    @Override // android.view.ViewGroup
    public z f(int i, long l2) {
        z zVar = this.x;
        if (zVar != null) {
            zVar.b();
        }
        int i2 = 0;
        if (i == 0 && getVisibility() != 0) {
            if (getVisibility() != 0) {
                setAlpha(i2);
            }
            z zVar2 = u.d(this);
            zVar2.a(1065353216);
            zVar2.e(l2);
            androidx.appcompat.widget.a.a obj4 = this.a;
            obj4.d(zVar2, i);
            zVar2.g(obj4);
            return zVar2;
        }
        z zVar3 = u.d(this);
        zVar3.a(i2);
        zVar3.e(l2);
        obj4 = this.a;
        obj4.d(zVar3, i);
        zVar3.g(obj4);
        return zVar3;
    }

    @Override // android.view.ViewGroup
    public int getAnimatedVisibility() {
        if (this.x != null) {
            return aVar.b;
        }
        return getVisibility();
    }

    @Override // android.view.ViewGroup
    public int getContentHeight() {
        return this.w;
    }

    @Override // android.view.ViewGroup
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        final int i4 = 0;
        TypedArray styledAttributes = getContext().obtainStyledAttributes(0, j.a, a.c, i4);
        setContentHeight(styledAttributes.getLayoutDimension(j.j, i4));
        styledAttributes.recycle();
        androidx.appcompat.widget.c cVar = this.v;
        if (cVar != null) {
            cVar.H(configuration);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onHoverEvent(MotionEvent motionEvent) {
        MotionEvent obj6;
        final int actionMasked = motionEvent.getActionMasked();
        final int i = 0;
        final int i2 = 9;
        if (actionMasked == i2) {
            this.z = i;
        }
        final int i3 = 1;
        if (!this.z && actionMasked == i2 && !super.onHoverEvent(motionEvent)) {
            if (actionMasked == i2) {
                if (!super.onHoverEvent(motionEvent)) {
                    this.z = i3;
                }
            }
        }
        if (actionMasked != 10) {
            if (actionMasked == 3) {
                this.z = i;
            }
        } else {
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent obj5;
        final int actionMasked = motionEvent.getActionMasked();
        final int i = 0;
        if (actionMasked == 0) {
            this.y = i;
        }
        final int i2 = 1;
        if (!this.y && actionMasked == 0 && !super.onTouchEvent(motionEvent)) {
            if (actionMasked == 0) {
                if (!super.onTouchEvent(motionEvent)) {
                    this.y = i2;
                }
            }
        }
        if (actionMasked != i2) {
            if (actionMasked == 3) {
                this.y = i;
            }
        } else {
        }
        return i2;
    }

    @Override // android.view.ViewGroup
    public abstract void setContentHeight(int i);

    @Override // android.view.ViewGroup
    public void setVisibility(int i) {
        int visibility;
        visibility = this.x;
        if (i != getVisibility() && visibility != null) {
            visibility = this.x;
            if (visibility != null) {
                visibility.b();
            }
            super.setVisibility(i);
        }
    }
}
