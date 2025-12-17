package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import d.h.l.u;
import d.v.a.a.b;
import f.c.a.e.b;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.r.a;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class b<S extends com.google.android.material.progressindicator.c>  extends ProgressBar {

    static final int F;
    private int A = 4;
    private final Runnable B;
    private final Runnable C;
    private final b D;
    private final b E;
    S a;
    private int b;
    private boolean c;
    private boolean v = true;
    private final int w;
    private long x;
    com.google.android.material.progressindicator.a y;
    private boolean z = false;

    class a implements Runnable {

        final com.google.android.material.progressindicator.b a;
        a(com.google.android.material.progressindicator.b b) {
            this.a = b;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b.a(this.a);
        }
    }

    class b implements Runnable {

        final com.google.android.material.progressindicator.b a;
        b(com.google.android.material.progressindicator.b b) {
            this.a = b;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b.b(this.a);
            b.c(this.a, -1);
        }
    }

    class c extends b {

        final com.google.android.material.progressindicator.b a;
        c(com.google.android.material.progressindicator.b b) {
            this.a = b;
            super();
        }

        @Override // d.v.a.a.b
        public void onAnimationEnd(Drawable drawable) {
            this.a.setIndeterminate(false);
            com.google.android.material.progressindicator.b obj3 = this.a;
            obj3.o(b.d(obj3), b.e(this.a));
        }
    }

    class d extends b {

        final com.google.android.material.progressindicator.b a;
        d(com.google.android.material.progressindicator.b b) {
            this.a = b;
            super();
        }

        @Override // d.v.a.a.b
        public void onAnimationEnd(Drawable drawable) {
            int i;
            boolean obj2;
            super.onAnimationEnd(drawable);
            if (!b.f(this.a)) {
                obj2 = this.a;
                obj2.setVisibility(b.g(obj2));
            }
        }
    }
    static {
        b.F = k.z;
    }

    protected b(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(a.c(context, attributeSet2, i3, b.F), attributeSet2, i3);
        int i2 = 4;
        b.a aVar = new b.a(this);
        this.B = aVar;
        b.b bVar = new b.b(this);
        this.C = bVar;
        b.c cVar = new b.c(this);
        this.D = cVar;
        b.d dVar = new b.d(this);
        this.E = dVar;
        final Context context2 = getContext();
        this.a = i(context2, attributeSet2);
        TypedArray obj8 = l.h(context2, attributeSet2, l.A, i3, i4, new int[0]);
        int obj10 = -1;
        obj8.getInt(l.F, obj10);
        this.w = Math.min(obj8.getInt(l.D, obj10), 1000);
        obj8.recycle();
        obj8 = new a();
        this.y = obj8;
        obj8 = 1;
    }

    static void a(com.google.android.material.progressindicator.b b) {
        b.k();
    }

    static void b(com.google.android.material.progressindicator.b b) {
        b.j();
    }

    static long c(com.google.android.material.progressindicator.b b, long l2) {
        b.x = l2;
        return l2;
    }

    static int d(com.google.android.material.progressindicator.b b) {
        return b.b;
    }

    static boolean e(com.google.android.material.progressindicator.b b) {
        return b.c;
    }

    static boolean f(com.google.android.material.progressindicator.b b) {
        return b.z;
    }

    static int g(com.google.android.material.progressindicator.b b) {
        return b.A;
    }

    private com.google.android.material.progressindicator.i<S> getCurrentDrawingDelegate() {
        com.google.android.material.progressindicator.g progressDrawable;
        com.google.android.material.progressindicator.k indeterminateDrawable;
        com.google.android.material.progressindicator.i i;
        i = 0;
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
            } else {
                i = getIndeterminateDrawable().u();
            }
            return i;
        }
        if (getProgressDrawable() == null) {
        } else {
            i = getProgressDrawable().v();
        }
        return i;
    }

    private void j() {
        boolean z;
        final int i = 0;
        (h)getCurrentDrawable().p(i, i, true);
        if (m()) {
            setVisibility(4);
        }
    }

    private void k() {
        if (this.w > 0) {
            SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean m() {
        int i;
        com.google.android.material.progressindicator.g indeterminateDrawable;
        if (getProgressDrawable() != null) {
            if (!getProgressDrawable().isVisible()) {
                if (getIndeterminateDrawable() != null) {
                    if (!getIndeterminateDrawable().isVisible()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private void n() {
        Object indeterminateDrawable2;
        com.google.android.material.progressindicator.g progressDrawable;
        com.google.android.material.progressindicator.k indeterminateDrawable;
        b bVar;
        if (getProgressDrawable() != null && getIndeterminateDrawable() != null) {
            if (getIndeterminateDrawable() != null) {
                getIndeterminateDrawable().t().d(this.D);
            }
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().l(this.E);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().l(this.E);
        }
    }

    private void p() {
        Object indeterminateDrawable;
        com.google.android.material.progressindicator.g progressDrawable;
        b bVar;
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().r(this.E);
            getIndeterminateDrawable().t().h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().r(this.E);
        }
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        com.google.android.material.progressindicator.h indeterminateDrawable;
        if (isIndeterminate()) {
            indeterminateDrawable = getIndeterminateDrawable();
        } else {
            indeterminateDrawable = getProgressDrawable();
        }
        return indeterminateDrawable;
    }

    @Override // android.widget.ProgressBar
    public int getHideAnimationBehavior() {
        return cVar.f;
    }

    @Override // android.widget.ProgressBar
    public Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    public com.google.android.material.progressindicator.k<S> getIndeterminateDrawable() {
        return (k)super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public int[] getIndicatorColor() {
        return cVar.c;
    }

    @Override // android.widget.ProgressBar
    public Drawable getProgressDrawable() {
        return getProgressDrawable();
    }

    public com.google.android.material.progressindicator.g<S> getProgressDrawable() {
        return (g)super.getProgressDrawable();
    }

    @Override // android.widget.ProgressBar
    public int getShowAnimationBehavior() {
        return cVar.e;
    }

    @Override // android.widget.ProgressBar
    public int getTrackColor() {
        return cVar.d;
    }

    @Override // android.widget.ProgressBar
    public int getTrackCornerRadius() {
        return cVar.b;
    }

    @Override // android.widget.ProgressBar
    public int getTrackThickness() {
        return cVar.a;
    }

    @Override // android.widget.ProgressBar
    protected void h(boolean z) {
        if (!this.v) {
        }
        (h)getCurrentDrawable().p(q(), false, z);
    }

    abstract S i(Context context, AttributeSet attributeSet2);

    @Override // android.widget.ProgressBar
    public void invalidate() {
        Drawable currentDrawable;
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar
    boolean l() {
        android.view.ViewParent parent;
        int i2;
        boolean z;
        int i;
        parent = this;
        while (parent.getVisibility() != 0) {
            parent = parent.getParent();
            i2 = 1;
        }
        return 0;
    }

    @Override // android.widget.ProgressBar
    public void o(int i, boolean z2) {
        boolean progressDrawable;
        com.google.android.material.progressindicator.g obj2;
        boolean obj3;
        if (isIndeterminate()) {
            if (getProgressDrawable() != null) {
                this.b = i;
                this.c = z2;
                this.z = true;
                if (getIndeterminateDrawable().isVisible()) {
                    if (Float.compare(obj2, obj3) == 0) {
                        this.D.onAnimationEnd(getIndeterminateDrawable());
                    } else {
                        getIndeterminateDrawable().t().f();
                    }
                } else {
                }
            }
        } else {
            super.setProgress(i);
            if (getProgressDrawable() != null && !z2) {
                if (!z2) {
                    getProgressDrawable().jumpToCurrentState();
                }
            }
        }
    }

    @Override // android.widget.ProgressBar
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (q()) {
            k();
        }
    }

    @Override // android.widget.ProgressBar
    protected void onDetachedFromWindow() {
        removeCallbacks(this.C);
        removeCallbacks(this.B);
        (h)getCurrentDrawable().h();
        p();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar
    protected void onDraw(Canvas canvas) {
        int paddingLeft;
        int paddingBottom;
        float f;
        int i;
        int paddingBottom2;
        synchronized (this) {
            try {
                if (getPaddingTop() != 0) {
                }
                canvas.translate((float)paddingLeft2, (float)paddingTop);
                if (getPaddingRight() == 0) {
                } else {
                }
                if (getPaddingBottom() != 0) {
                }
                i = 0;
                canvas.clipRect(i, i, width -= i2, height -= i3);
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(canvas.save());
                throw canvas;
            }
        }
    }

    @Override // android.widget.ProgressBar
    protected void onMeasure(int i, int i2) {
        int paddingBottom;
        int obj2;
        int obj3;
        super.onMeasure(i, i2);
        obj2 = getCurrentDrawingDelegate();
        synchronized (this) {
            try {
                obj3 = obj2.e();
                obj2 = obj2.d();
                if (obj3 < 0) {
                } else {
                }
                obj3 = getMeasuredWidth();
                obj3 += paddingBottom;
                if (obj2 < 0) {
                } else {
                }
                obj2 = getMeasuredHeight();
                obj2 += paddingBottom;
            }
            setMeasuredDimension(obj3, obj2);
        }
    }

    @Override // android.widget.ProgressBar
    protected void onVisibilityChanged(View view, int i2) {
        int obj1;
        super.onVisibilityChanged(view, i2);
        obj1 = i2 == 0 ? 1 : 0;
        h(obj1);
    }

    @Override // android.widget.ProgressBar
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        h(false);
    }

    @Override // android.widget.ProgressBar
    boolean q() {
        int i;
        boolean windowVisibility;
        if (u.Q(this) && getWindowVisibility() == 0 && l()) {
            if (getWindowVisibility() == 0) {
                i = l() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.widget.ProgressBar
    public void setAnimatorDurationScaleProvider(com.google.android.material.progressindicator.a a) {
        com.google.android.material.progressindicator.g progressDrawable;
        com.google.android.material.progressindicator.k indeterminateDrawable;
        this.y = a;
        if (getProgressDrawable() != null) {
            progressDrawable.c = a;
        }
        if (getIndeterminateDrawable() != null) {
            indeterminateDrawable.c = a;
        }
    }

    @Override // android.widget.ProgressBar
    public void setHideAnimationBehavior(int i) {
        cVar.f = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminate(boolean z) {
        boolean z2;
        boolean z3;
        Object obj3;
        synchronized (this) {
            try {
                Drawable currentDrawable = getCurrentDrawable();
                if ((h)currentDrawable != null) {
                }
                (h)currentDrawable.h();
                super.setIndeterminate(z);
                obj3 = getCurrentDrawable();
                int i = 0;
            }
            (h)obj3.p(q(), i, i);
            if (obj3 instanceof k && q()) {
                if (q()) {
                    (k)obj3.t().g();
                }
            }
            try {
                this.z = i;
                throw z;
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(0);
        }
        if (!drawable instanceof k) {
        } else {
            (h)drawable.h();
            super.setIndeterminateDrawable(drawable);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        throw obj2;
    }

    @Override // android.widget.ProgressBar
    public void setIndicatorColor(int... iArr) {
        int length;
        boolean equals;
        int i3;
        int i2;
        int i;
        int[] obj5;
        if (iArr.length == 0) {
            new int[1][0] = a.b(getContext(), b.o, -1);
        }
        if (!Arrays.equals(getIndicatorColor(), obj5)) {
            equals.c = obj5;
            getIndeterminateDrawable().t().c();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        synchronized (this) {
            try {
                o(i, false);
                throw i;
            }
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(0);
        }
        if (!drawable instanceof g) {
        } else {
            (g)drawable.h();
            super.setProgressDrawable(drawable);
            drawable.z(f /= f2);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        throw obj3;
    }

    @Override // android.widget.ProgressBar
    public void setShowAnimationBehavior(int i) {
        cVar.e = i;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setTrackColor(int i) {
        final com.google.android.material.progressindicator.c cVar = this.a;
        if (cVar.d != i) {
            cVar.d = i;
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public void setTrackCornerRadius(int i) {
        int i2;
        int obj3;
        final com.google.android.material.progressindicator.c cVar = this.a;
        if (cVar.b != i) {
            cVar.b = Math.min(i, i3 /= 2);
        }
    }

    @Override // android.widget.ProgressBar
    public void setTrackThickness(int i) {
        final com.google.android.material.progressindicator.c cVar = this.a;
        if (cVar.a != i) {
            cVar.a = i;
            requestLayout();
        }
    }

    @Override // android.widget.ProgressBar
    public void setVisibilityAfterHide(int i) {
        int i2;
        if (i != 0 && i != 4) {
            if (i != 4) {
                if (i != 8) {
                } else {
                }
                IllegalArgumentException obj2 = new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
                throw obj2;
            }
        }
        this.A = i;
    }
}
