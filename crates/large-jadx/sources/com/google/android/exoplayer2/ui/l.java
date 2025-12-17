package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class l extends View implements com.google.android.exoplayer2.ui.z {

    private final Paint A;
    private final Paint B;
    private final Drawable C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private final int I;
    private final int J;
    private final int K;
    private final int L;
    private final StringBuilder M;
    private final Formatter N;
    private final Runnable O;
    private final CopyOnWriteArraySet<com.google.android.exoplayer2.ui.z.a> P;
    private final Point Q;
    private final float R;
    private int S;
    private long T;
    private int U;
    private Rect V;
    private ValueAnimator W;
    private final Rect a;
    private float a0;
    private final Rect b;
    private boolean b0;
    private final Rect c;
    private boolean c0;
    private long d0;
    private long e0;
    private long f0;
    private long g0;
    private int h0;
    private long[] i0;
    private boolean[] j0;
    private final Rect v;
    private final Paint w;
    private final Paint x;
    private final Paint y;
    private final Paint z;
    public l(Context context, AttributeSet attributeSet2, int i3, AttributeSet attributeSet4) {
        super(context, attributeSet2, i3, attributeSet4, 0);
    }

    public l(Context context, AttributeSet attributeSet2, int i3, AttributeSet attributeSet4, int i5) {
        int i4;
        int i6;
        Drawable minimumHeight;
        int paint5;
        int i2;
        Locale default;
        Paint paint2;
        int styledAttributes;
        Paint paint4;
        int int3;
        float density;
        int int2;
        int int;
        int i;
        int i7;
        Paint paint;
        Paint paint3;
        final Object obj = this;
        AttributeSet set = attributeSet4;
        super(context, attributeSet2, i3);
        Rect rect = new Rect();
        obj.a = rect;
        Rect rect2 = new Rect();
        obj.b = rect2;
        Rect rect3 = new Rect();
        obj.c = rect3;
        Rect rect4 = new Rect();
        obj.v = rect4;
        paint5 = new Paint();
        obj.w = paint5;
        Paint paint7 = new Paint();
        obj.x = paint7;
        paint2 = new Paint();
        obj.y = paint2;
        Paint paint8 = new Paint();
        obj.z = paint8;
        paint4 = new Paint();
        obj.A = paint4;
        Paint paint9 = new Paint();
        obj.B = paint9;
        paint9.setAntiAlias(true);
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        obj.P = copyOnWriteArraySet;
        Point point = new Point();
        obj.Q = point;
        density = displayMetrics.density;
        obj.R = density;
        obj.L = l.c(density, -50);
        int i41 = 4;
        int = l.c(density, i41);
        i = l.c(density, 26);
        int2 = l.c(density, i41);
        int i48 = l.c(density, 12);
        final int i49 = l.c(density, 0);
        int3 = l.c(density, 16);
        if (set != null) {
            styledAttributes = context.getTheme().obtainStyledAttributes(set, v.c, i3, i5);
            minimumHeight = styledAttributes.getDrawable(v.n);
            obj.C = minimumHeight;
            if (minimumHeight != null) {
                obj.o(minimumHeight);
                i = Math.max(minimumHeight.getMinimumHeight(), i);
            }
            obj.D = styledAttributes.getDimensionPixelSize(v.g, int);
            obj.E = styledAttributes.getDimensionPixelSize(v.p, i);
            obj.F = styledAttributes.getInt(v.f, 0);
            obj.G = styledAttributes.getDimensionPixelSize(v.e, int2);
            obj.H = styledAttributes.getDimensionPixelSize(v.o, i48);
            obj.I = styledAttributes.getDimensionPixelSize(v.l, i49);
            obj.J = styledAttributes.getDimensionPixelSize(v.m, int3);
            int i32 = -1;
            paint5.setColor(styledAttributes.getInt(v.j, i32));
            paint9.setColor(styledAttributes.getInt(v.k, i32));
            paint7.setColor(styledAttributes.getInt(v.h, -855638017));
            paint2.setColor(styledAttributes.getInt(v.q, 872415231));
            paint8.setColor(styledAttributes.getInt(v.d, -1291845888));
            paint4.setColor(styledAttributes.getInt(v.i, 872414976));
            styledAttributes.recycle();
        } else {
            obj.D = int;
            obj.E = i;
            obj.F = 0;
            obj.G = int2;
            obj.H = i48;
            obj.I = i49;
            obj.J = int3;
            styledAttributes = -1;
            paint5.setColor(styledAttributes);
            paint9.setColor(styledAttributes);
            paint7.setColor(-855638017);
            paint2.setColor(872415231);
            paint8.setColor(-1291845888);
            paint4.setColor(872414976);
            obj.C = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        obj.M = stringBuilder;
        Formatter formatter = new Formatter(stringBuilder, Locale.getDefault());
        obj.N = formatter;
        b bVar = new b(obj);
        obj.O = bVar;
        Drawable drawable = obj.C;
        if (drawable != null) {
            obj.K = i8 /= 2;
        } else {
            obj.K = i14 /= 2;
        }
        obj.a0 = 1065353216;
        ValueAnimator valueAnimator = new ValueAnimator();
        obj.W = valueAnimator;
        c cVar = new c(obj);
        valueAnimator.addUpdateListener(cVar);
        long l = -9223372036854775807L;
        obj.e0 = l;
        obj.T = l;
        obj.S = 20;
        int i11 = 1;
        obj.setFocusable(i11);
        if (getImportantForAccessibility() == 0) {
            obj.setImportantForAccessibility(i11);
        }
    }

    private static int c(float f, int i2) {
        return (int)obj1;
    }

    private void d(Canvas canvas) {
        Drawable drawable2;
        int i2;
        int i3;
        boolean focused;
        int i;
        int i5;
        Drawable drawable;
        int i6;
        int i4;
        if (Long.compare(l, i9) <= 0) {
        }
        Rect rect = this.v;
        int i7 = p0.p(rect.right, rect.left, rect3.right);
        int centerY = this.v.centerY();
        Drawable drawable3 = this.C;
        if (drawable3 == null) {
            if (!this.c0) {
                if (isFocused()) {
                    i3 = this.J;
                } else {
                    i3 = isEnabled() ? this.H : this.I;
                }
            } else {
            }
            canvas.drawCircle((float)i7, (float)centerY, (float)i14, this.B);
        } else {
            i11 /= 2;
            i16 /= 2;
            this.C.setBounds(i7 - i, centerY - i5, i7 += i, centerY += i5);
            this.C.draw(canvas);
        }
    }

    private void e(Canvas canvas) {
        int width;
        int left;
        int right;
        int right2;
        float f7;
        int i;
        float f8;
        Paint paint2;
        float f5;
        float f4;
        float f3;
        Paint paint3;
        float f2;
        float f6;
        float f;
        Paint paint;
        final Object obj = this;
        int height = obj.b.height();
        centerY -= i4;
        height += i3;
        if (Long.compare(l, i6) <= 0) {
            Rect rect3 = obj.b;
            canvas.drawRect((float)left2, (float)i3, (float)right3, (float)i2, obj.y);
        }
        Rect rect4 = obj.c;
        int right4 = rect4.right;
        int i8 = Math.max(Math.max(rect7.left, right4), rect9.right);
        right2 = rect10.right;
        if (i8 < right2) {
            canvas.drawRect((float)i8, (float)i3, (float)right2, (float)i2, obj.y);
        }
        left = Math.max(rect4.left, rect8.right);
        if (right4 > left) {
            canvas.drawRect((float)left, (float)i3, (float)right4, (float)i2, obj.x);
        }
        if (obj.v.width() > 0) {
            Rect rect6 = obj.v;
            canvas.drawRect((float)left, (float)i3, (float)width, (float)i2, obj.w);
        }
        if (obj.h0 == 0) {
        }
        long[] lArr = obj.i0;
        g.e(lArr);
        boolean[] zArr = obj.j0;
        g.e(zArr);
        int i11 = 0;
        i = i11;
        while (i < obj.h0) {
            Rect rect11 = obj.b;
            left5 += i16;
            if ((boolean[])zArr[i]) {
            } else {
            }
            paint2 = obj.z;
            canvas.drawRect((float)i19, (float)i3, (float)f4, (float)i2, paint2);
            i++;
            paint2 = obj.A;
        }
    }

    private boolean f(float f, float f2) {
        return this.a.contains((int)f, (int)f2);
    }

    private void g() {
        s(false);
    }

    private long getPositionIncrement() {
        long l;
        long cmp;
        cmp = -9223372036854775807L;
        if (Long.compare(l, cmp) == 0) {
            long l2 = this.e0;
            if (Long.compare(l2, cmp) == 0) {
                l = 0;
            } else {
                l2 /= cmp;
            }
        }
        return l;
    }

    private String getProgressText() {
        return p0.X(this.M, this.N, this.f0);
    }

    private long getScrubberPosition() {
        int width;
        long l;
        if (this.b.width() > 0 && Long.compare(l2, l) == 0) {
            if (Long.compare(l2, l) == 0) {
            }
            return i /= l5;
        }
        return 0;
    }

    private void i(ValueAnimator valueAnimator) {
        this.a0 = (Float)valueAnimator.getAnimatedValue().floatValue();
        invalidate(this.a);
    }

    private void k(float f) {
        Rect rect2 = this.b;
        rect.right = p0.p((int)f, rect2.left, rect2.right);
    }

    private static int l(float f, int i2) {
        return (int)obj1;
    }

    private Point m(MotionEvent motionEvent) {
        this.Q.set((int)f, (int)obj3);
        return this.Q;
    }

    private boolean n(long l) {
        long l2;
        final long l3 = this.e0;
        final int i4 = 0;
        if (Long.compare(l3, i) <= 0) {
            return i4;
        }
        l2 = this.c0 ? this.d0 : this.f0;
        final long l4 = l2;
        long obj10 = p0.q(l4 + l, obj1, 0);
        if (Long.compare(obj10, l4) == 0) {
            return i4;
        }
        if (!this.c0) {
            r(obj10);
        } else {
            v(obj10);
        }
        t();
        return 1;
    }

    private boolean o(Drawable drawable) {
        int layoutDirection;
        Drawable obj3;
        if (p0.a >= 23 && l.p(drawable, getLayoutDirection())) {
            obj3 = l.p(drawable, getLayoutDirection()) ? 1 : 0;
        } else {
        }
        return obj3;
    }

    private static boolean p(Drawable drawable, int i2) {
        boolean obj2;
        if (p0.a >= 23 && drawable.setLayoutDirection(i2)) {
            obj2 = drawable.setLayoutDirection(i2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private void q(int i, int i2) {
        Rect height;
        height = this.V;
        if (height != null && height.width() == i && this.V.height() == i2) {
            if (height.width() == i) {
                if (this.V.height() == i2) {
                }
            }
        }
        final int i3 = 0;
        Rect rect2 = new Rect(i3, i3, i, i2);
        this.V = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private void r(long l) {
        ViewParent parent;
        this.d0 = l;
        int i = 1;
        this.c0 = i;
        setPressed(i);
        parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(i);
        }
        Iterator iterator = this.P.iterator();
        for (z.a parent : iterator) {
            parent.E(this, l);
        }
    }

    private void s(boolean z) {
        ViewParent parent;
        long l;
        removeCallbacks(this.O);
        int i = 0;
        this.c0 = i;
        setPressed(i);
        parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(i);
        }
        invalidate();
        Iterator iterator = this.P.iterator();
        for (z.a parent : iterator) {
            parent.D(this, this.d0, obj3);
        }
    }

    private void t() {
        long l;
        Rect rect;
        int left;
        int cmp;
        int i2;
        int i;
        int i3;
        this.c.set(this.b);
        this.v.set(this.b);
        l = this.c0 ? this.d0 : this.f0;
        if (Long.compare(l3, i) > 0) {
            i = this.b;
            rect11.right = Math.min(left3 += i7, i.right);
            cmp = this.b;
            left.right = Math.min(left2 += i4, cmp.right);
        } else {
            left = rect8.left;
            rect4.right = left;
            rect.right = left;
        }
        invalidate(this.a);
    }

    private void u() {
        Drawable stateful;
        int[] drawableState;
        stateful = this.C;
        if (stateful != null && stateful.isStateful() && this.C.setState(getDrawableState())) {
            if (stateful.isStateful()) {
                if (this.C.setState(getDrawableState())) {
                    invalidate();
                }
            }
        }
    }

    private void v(long l) {
        Object next;
        if (Long.compare(l2, l) == 0) {
        }
        this.d0 = l;
        Iterator iterator = this.P.iterator();
        for (z.a next : iterator) {
            next.t(this, l);
        }
    }

    @Override // android.view.View
    public void a(long[] lArr, boolean[] z2Arr2, int i3) {
        int i;
        if (i3 != 0) {
            if (lArr != null && z2Arr2 != null) {
                if (z2Arr2 != null) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        g.a(i);
        this.h0 = i3;
        this.i0 = lArr;
        this.j0 = z2Arr2;
        t();
    }

    @Override // android.view.View
    public void b(com.google.android.exoplayer2.ui.z.a z$a) {
        g.e(a);
        this.P.add(a);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        u();
    }

    @Override // android.view.View
    public long getPreferredUpdateDelay() {
        int width;
        int i;
        int cmp;
        int i2 = l.l(this.R, this.b.width());
        width = this.e0;
        if (i2 != 0 && Long.compare(width, i3) != 0) {
            width = this.e0;
            if (Long.compare(width, i3) != 0) {
                if (Long.compare(width, l) == 0) {
                    i = Long.MAX_VALUE;
                } else {
                    width /= cmp;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.view.View
    public void h() {
        g();
    }

    @Override // android.view.View
    public void j(ValueAnimator valueAnimator) {
        i(valueAnimator);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        final Drawable drawable = this.C;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        e(canvas);
        d(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i2, Rect rect3) {
        boolean obj1;
        super.onFocusChanged(z, i2, rect3);
        if (this.c0 && !z) {
            if (!z) {
                s(false);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int eventType;
        int progressText;
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo.AccessibilityAction aCTION_SCROLL_BACKWARD;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (Long.compare(l, i4) <= 0) {
        }
        if (p0.a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    @Override // android.view.View
    public boolean onKeyDown(int i, KeyEvent keyEvent2) {
        boolean positionIncrement;
        int i3;
        int i2;
        if (isEnabled()) {
            i2 = 1;
            if (i != 66) {
                switch (i) {
                    case 21:
                        removeCallbacks(this.O);
                        postDelayed(this.O, 1000);
                        return i2;
                    case 22:
                        s(false);
                        return i2;
                    default:
                }
            } else {
            }
        }
        return super.onKeyDown(i, keyEvent2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i8;
        int i6;
        int i;
        int i7;
        int obj7;
        i4 -= i2;
        i5 -= i3;
        int i9 = 0;
        obj7 = this.b0 ? i9 : this.K;
        if (this.F == 1) {
            i15 -= i17;
            int i22 = this.D;
            i19 -= i8;
        } else {
            i6 = i12 / 2;
            i = i8 / 2;
        }
        this.a.set(getPaddingLeft(), i6, obj8 - obj6, i20 += i6);
        Rect obj6 = this.a;
        this.b.set(left += obj7, i, obj6 -= obj7, obj7 += i);
        if (p0.a >= 29) {
            q(obj8, obj9);
        }
        t();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode;
        int i3;
        int obj4;
        mode = View.MeasureSpec.getMode(i2);
        if (mode == 0) {
            obj4 = this.E;
        } else {
            if (mode == 1073741824) {
            } else {
                obj4 = Math.min(this.E, View.MeasureSpec.getSize(i2));
            }
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), obj4);
        u();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        int obj2;
        final Drawable drawable = this.C;
        if (drawable != null && l.p(drawable, i)) {
            if (l.p(drawable, i)) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean enabled;
        int i3;
        int l;
        int action;
        int i;
        int i4;
        int i2;
        float obj8;
        i3 = 0;
        if (isEnabled()) {
            if (Long.compare(l, i) <= 0) {
            } else {
                Point point = m(motionEvent);
                l = point.x;
                enabled = point.y;
                action = motionEvent.getAction();
                i = 1;
                if (action != 0) {
                    i4 = 3;
                    if (action != i) {
                        if (action != 2) {
                            if (action != i4) {
                            } else {
                                if (this.c0 && motionEvent.getAction() == i4) {
                                    if (motionEvent.getAction() == i4) {
                                        i3 = i;
                                    }
                                    s(i3);
                                    return i;
                                }
                            }
                        } else {
                            if (this.c0) {
                                if (enabled < this.L) {
                                    obj8 = this.U;
                                    k((float)obj8);
                                } else {
                                    this.U = l;
                                    k((float)l);
                                }
                                v(getScrubberPosition());
                                t();
                                invalidate();
                                return i;
                            }
                        }
                    } else {
                    }
                } else {
                    obj8 = (float)l;
                    if (f(obj8, (float)enabled)) {
                        k(obj8);
                        r(getScrubberPosition());
                        t();
                        invalidate();
                        return i;
                    }
                }
            }
        }
        return i3;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle2) {
        boolean obj6;
        int obj7;
        final int i2 = 1;
        if (super.performAccessibilityAction(i, bundle2)) {
            return i2;
        }
        int i3 = 0;
        if (Long.compare(l, i4) <= 0) {
            return i3;
        }
        obj7 = 8192;
        if (i == obj7) {
            if (n(-obj6)) {
                s(i3);
            }
            sendAccessibilityEvent(4);
            return i2;
        } else {
            obj7 = 4096;
            if (i == obj7 && n(getPositionIncrement())) {
                if (n(getPositionIncrement())) {
                    s(i3);
                }
            }
        }
        return i3;
    }

    @Override // android.view.View
    public void setAdMarkerColor(int i) {
        this.z.setColor(i);
        invalidate(this.a);
    }

    @Override // android.view.View
    public void setBufferedColor(int i) {
        this.x.setColor(i);
        invalidate(this.a);
    }

    @Override // android.view.View
    public void setBufferedPosition(long l) {
        if (Long.compare(l2, l) == 0) {
        }
        this.g0 = l;
        t();
    }

    @Override // android.view.View
    public void setDuration(long l) {
        boolean z;
        long obj3;
        if (Long.compare(l2, l) == 0) {
        }
        this.e0 = l;
        if (this.c0 && Long.compare(l, z) == 0) {
            if (Long.compare(l, z) == 0) {
                s(true);
            }
        }
        t();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        boolean obj2;
        super.setEnabled(z);
        if (this.c0 && !z) {
            if (!z) {
                s(true);
            }
        }
    }

    @Override // android.view.View
    public void setKeyCountIncrement(int i) {
        int i2;
        i2 = i > 0 ? 1 : 0;
        g.a(i2);
        this.S = i;
        this.T = -9223372036854775807L;
    }

    @Override // android.view.View
    public void setKeyTimeIncrement(long l) {
        int i;
        i = Long.compare(l, i2) > 0 ? 1 : 0;
        g.a(i);
        this.S = -1;
        this.T = l;
    }

    @Override // android.view.View
    public void setPlayedAdMarkerColor(int i) {
        this.A.setColor(i);
        invalidate(this.a);
    }

    @Override // android.view.View
    public void setPlayedColor(int i) {
        this.w.setColor(i);
        invalidate(this.a);
    }

    @Override // android.view.View
    public void setPosition(long l) {
        if (Long.compare(l2, l) == 0) {
        }
        this.f0 = l;
        setContentDescription(getProgressText());
        t();
    }

    @Override // android.view.View
    public void setScrubberColor(int i) {
        this.B.setColor(i);
        invalidate(this.a);
    }

    @Override // android.view.View
    public void setUnplayedColor(int i) {
        this.y.setColor(i);
        invalidate(this.a);
    }
}
