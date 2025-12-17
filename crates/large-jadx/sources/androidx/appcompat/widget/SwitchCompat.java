package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.k;
import d.a.a;
import d.a.j;
import d.a.k.a.a;
import d.a.n.a;
import d.h.l.u;
import java.util.List;

/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    private static final Property<androidx.appcompat.widget.SwitchCompat, Float> i0;
    private static final int[] j0;
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private boolean F;
    private java.lang.CharSequence G;
    private java.lang.CharSequence H;
    private boolean I;
    private int J;
    private int K;
    private float L;
    private float M;
    private VelocityTracker N;
    private int O;
    float P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private Drawable a;
    private final TextPaint a0;
    private ColorStateList b;
    private ColorStateList b0;
    private PorterDuff.Mode c;
    private Layout c0;
    private Layout d0;
    private TransformationMethod e0;
    ObjectAnimator f0;
    private final androidx.appcompat.widget.v g0;
    private final Rect h0;
    private boolean v;
    private boolean w;
    private Drawable x;
    private ColorStateList y;
    private PorterDuff.Mode z;

    class a extends Property<androidx.appcompat.widget.SwitchCompat, Float> {
        a(Class class, String string2) {
            super(class, string2);
        }

        @Override // android.util.Property
        public Float a(androidx.appcompat.widget.SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.P);
        }

        @Override // android.util.Property
        public void b(androidx.appcompat.widget.SwitchCompat switchCompat, Float float2) {
            switchCompat.setThumbPosition(float2.floatValue());
        }

        @Override // android.util.Property
        public Object get(Object object) {
            return a((SwitchCompat)object);
        }

        @Override // android.util.Property
        public void set(Object object, Object object2) {
            b((SwitchCompat)object, (Float)object2);
        }
    }
    static {
        SwitchCompat.a aVar = new SwitchCompat.a(Float.class, "thumbPos");
        SwitchCompat.i0 = aVar;
        int[] iArr = new int[1];
        SwitchCompat.j0 = iArr;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.M);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet2, int i3) {
        boolean z2;
        boolean z;
        super(context, attributeSet2, i3);
        int i = 0;
        this.b = i;
        this.c = i;
        final int i4 = 0;
        this.v = i4;
        this.w = i4;
        this.y = i;
        this.z = i;
        this.A = i4;
        this.B = i4;
        this.N = VelocityTracker.obtain();
        Rect rect = new Rect();
        this.h0 = rect;
        o0.a(this, getContext());
        final int i5 = 1;
        TextPaint textPaint = new TextPaint(i5);
        this.a0 = textPaint;
        textPaint.density = displayMetrics.density;
        final int[] iArr = j.u2;
        androidx.appcompat.widget.t0 t0Var = t0.v(context, attributeSet2, iArr, i3, i4);
        u.j0(this, context, iArr, attributeSet2, t0Var.r(), i3, 0);
        Drawable drawable = t0Var.g(j.x2);
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = t0Var.g(j.G2);
        this.x = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.G = t0Var.p(j.v2);
        this.H = t0Var.p(j.w2);
        this.I = t0Var.a(j.y2, i5);
        this.C = t0Var.f(j.D2, i4);
        this.D = t0Var.f(j.A2, i4);
        this.E = t0Var.f(j.B2, i4);
        this.F = t0Var.a(j.z2, i4);
        ColorStateList list = t0Var.c(j.E2);
        if (list != null) {
            this.b = list;
            this.v = i5;
        }
        int i16 = -1;
        PorterDuff.Mode mode2 = a0.e(t0Var.k(j.F2, i16), i);
        if (this.c != mode2) {
            this.c = mode2;
            this.w = i5;
        }
        if (!this.v) {
            if (this.w) {
                b();
            }
        } else {
        }
        ColorStateList list2 = t0Var.c(j.H2);
        if (list2 != null) {
            this.y = list2;
            this.A = i5;
        }
        PorterDuff.Mode mode = a0.e(t0Var.k(j.I2, i16), i);
        if (this.z != mode) {
            this.z = mode;
            this.B = i5;
        }
        if (!this.A) {
            if (this.B) {
                c();
            }
        } else {
        }
        int i2 = t0Var.n(j.C2, i4);
        if (i2 != 0) {
            i(context, i2);
        }
        v vVar = new v(this);
        this.g0 = vVar;
        vVar.m(attributeSet2, i3);
        t0Var.w();
        ViewConfiguration obj13 = ViewConfiguration.get(context);
        this.K = obj13.getScaledTouchSlop();
        this.O = obj13.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void a(boolean z) {
        int obj5;
        obj5 = z ? 1065353216 : 0;
        final int i2 = 1;
        float[] fArr = new float[i2];
        final int i4 = 0;
        fArr[i4] = obj5;
        obj5 = ObjectAnimator.ofFloat(this, SwitchCompat.i0, fArr);
        this.f0 = obj5;
        obj5.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f0.setAutoCancel(i2);
        }
        this.f0.start();
    }

    private void b() {
        Drawable stateful;
        boolean z;
        boolean drawableState;
        stateful = this.a;
        if (stateful != null) {
            if (!this.v) {
                Drawable mutate = a.r(stateful).mutate();
                this.a = mutate;
                if (this.w && this.v) {
                    mutate = a.r(stateful).mutate();
                    this.a = mutate;
                    if (this.v) {
                        a.o(mutate, this.b);
                    }
                    if (this.w) {
                        a.p(this.a, this.c);
                    }
                    if (this.a.isStateful()) {
                        this.a.setState(getDrawableState());
                    }
                }
            } else {
            }
        }
    }

    private void c() {
        Drawable stateful;
        boolean z;
        boolean drawableState;
        stateful = this.x;
        if (stateful != null) {
            if (!this.A) {
                Drawable mutate = a.r(stateful).mutate();
                this.x = mutate;
                if (this.B && this.A) {
                    mutate = a.r(stateful).mutate();
                    this.x = mutate;
                    if (this.A) {
                        a.o(mutate, this.y);
                    }
                    if (this.B) {
                        a.p(this.x, this.z);
                    }
                    if (this.x.isStateful()) {
                        this.x.setState(getDrawableState());
                    }
                }
            } else {
            }
        }
    }

    private void d() {
        final ObjectAnimator objectAnimator = this.f0;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        final MotionEvent obj2 = MotionEvent.obtain(motionEvent);
        obj2.setAction(3);
        super.onTouchEvent(obj2);
        obj2.recycle();
    }

    private static float f(float f, float f2, float f3) {
        float obj1;
        float obj2;
        if (Float.compare(f, f2) < 0) {
            obj1 = f2;
        } else {
            if (Float.compare(f, f3) > 0) {
                obj1 = f3;
            }
        }
        return obj1;
    }

    private boolean g(float f, float f2) {
        int i2;
        int i;
        float obj8;
        if (this.a == null) {
            return 0;
        }
        this.a.getPadding(this.h0);
        int i9 = this.K;
        i11 -= i9;
        Rect rect2 = this.h0;
        if (Float.compare(f, f3) > 0 && Float.compare(f, i2) < 0 && Float.compare(f2, obj8) > 0 && Float.compare(f2, obj8) < 0) {
            if (Float.compare(f, i2) < 0) {
                if (Float.compare(f2, obj8) > 0) {
                    if (Float.compare(f2, obj8) < 0) {
                        i = 1;
                    }
                }
            }
        }
        return i;
    }

    private boolean getTargetCheckedState() {
        int i;
        i = Float.compare(f, i2) > 0 ? 1 : 0;
        return i;
    }

    private int getThumbOffset() {
        int i;
        float f;
        if (z0.b(this)) {
            i5 -= f;
        } else {
            i = this.P;
        }
        return (int)i3;
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.x;
        if (drawable != null) {
            Rect rect2 = this.h0;
            drawable.getPadding(rect2);
            Drawable drawable2 = this.a;
            if (drawable2 != null) {
                rect = a0.d(drawable2);
            } else {
                rect = a0.c;
            }
            return i6 -= right;
        }
        return 0;
    }

    private Layout h(java.lang.CharSequence charSequence) {
        int i;
        double ceil;
        java.lang.CharSequence obj9;
        TransformationMethod method = this.e0;
        if (method != null) {
            obj9 = method.getTransformation(charSequence, this);
        }
        final java.lang.CharSequence charSequence2 = obj9;
        final TextPaint textPaint = this.a0;
        if (charSequence2 != null) {
            i = (int)ceil;
        } else {
            i = 0;
        }
        super(charSequence2, textPaint, i, Layout.Alignment.ALIGN_NORMAL, 1065353216, 0, 1);
        return obj9;
    }

    private void k(int i, int i2) {
        int i3;
        Typeface obj2;
        if (i != 1) {
            if (i != 2) {
                obj2 = i != 3 ? 0 : Typeface.MONOSPACE;
            } else {
                obj2 = Typeface.SERIF;
            }
        } else {
            obj2 = Typeface.SANS_SERIF;
        }
        j(obj2, i2);
    }

    private void l(MotionEvent motionEvent) {
        int enabled;
        int xVelocity;
        boolean targetCheckedState;
        boolean cmp;
        int i;
        final int i2 = 0;
        this.J = i2;
        targetCheckedState = 1;
        if (motionEvent.getAction() == targetCheckedState && isEnabled()) {
            xVelocity = isEnabled() ? targetCheckedState : i2;
        } else {
        }
        final boolean checked = isChecked();
        if (xVelocity != 0) {
            this.N.computeCurrentVelocity(1000);
            xVelocity = this.N.getXVelocity();
            if (Float.compare(f, i) > 0) {
                i = 0;
                if (z0.b(this)) {
                    if (Float.compare(xVelocity, i) < 0) {
                    } else {
                        targetCheckedState = i2;
                    }
                } else {
                    if (Float.compare(xVelocity, i) > 0) {
                    } else {
                    }
                }
            } else {
                targetCheckedState = getTargetCheckedState();
            }
        } else {
            targetCheckedState = checked;
        }
        if (targetCheckedState != checked) {
            playSoundEffect(i2);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    @Override // android.widget.CompoundButton
    public void draw(Canvas canvas) {
        Object background;
        int i2;
        Drawable drawable2;
        int i;
        int i3;
        Rect bottom;
        Drawable drawable;
        Drawable bottom2;
        int left;
        int right2;
        int right;
        background = this.h0;
        i2 = this.T;
        final int i4 = this.U;
        final int i5 = this.W;
        Drawable drawable4 = this.a;
        if (drawable4 != null) {
            bottom = a0.d(drawable4);
        } else {
            bottom = a0.c;
        }
        drawable = this.x;
        if (drawable != null) {
            drawable.getPadding(background);
            int left3 = background.left;
            i3 += left3;
            if (bottom != null) {
                left = bottom.left;
                if (left > left3) {
                    i2 += left;
                }
                int top = bottom.top;
                int top2 = background.top;
                drawable = top > top2 ? i8 + i4 : i4;
                right2 = bottom.right;
                right = background.right;
                if (right2 > right) {
                    i -= right2;
                }
                bottom = bottom.bottom;
                bottom2 = background.bottom;
                bottom = bottom > bottom2 ? i5 - i7 : i5;
            } else {
                drawable = i4;
            }
            this.x.setBounds(i2, drawable, i, bottom);
        }
        drawable2 = this.a;
        drawable2.getPadding(background);
        drawable2 = i3 - left2;
        i6 += right3;
        this.a.setBounds(drawable2, i4, i3, i5);
        background = getBackground();
        if (drawable2 != null && background != null) {
            drawable2.getPadding(background);
            drawable2 = i3 - left2;
            i6 += right3;
            this.a.setBounds(drawable2, i4, i3, i5);
            background = getBackground();
            if (background != null) {
                a.l(background, drawable2, i4, i3, i5);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        Drawable drawable = this.a;
        if (drawable != null) {
            a.k(drawable, f, f2);
        }
        Drawable drawable2 = this.x;
        if (drawable2 != null) {
            a.k(drawable2, f, f2);
        }
    }

    @Override // android.widget.CompoundButton
    protected void drawableStateChanged() {
        int[] drawableState;
        Drawable state;
        int i;
        boolean stateful;
        super.drawableStateChanged();
        drawableState = getDrawableState();
        state = this.a;
        if (state != null && state.isStateful()) {
            if (state.isStateful()) {
                i |= state;
            }
        }
        Drawable drawable = this.x;
        if (drawable != null && drawable.isStateful()) {
            if (drawable.isStateful()) {
                i |= drawableState;
            }
        }
        if (i != 0) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton
    public int getCompoundPaddingLeft() {
        int i;
        boolean empty;
        if (!z0.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        if (!TextUtils.isEmpty(getText())) {
            i += empty;
        }
        return i;
    }

    @Override // android.widget.CompoundButton
    public int getCompoundPaddingRight() {
        int i;
        boolean empty;
        if (z0.b(this)) {
            return super.getCompoundPaddingRight();
        }
        if (!TextUtils.isEmpty(getText())) {
            i += empty;
        }
        return i;
    }

    @Override // android.widget.CompoundButton
    public boolean getShowText() {
        return this.I;
    }

    @Override // android.widget.CompoundButton
    public boolean getSplitTrack() {
        return this.F;
    }

    @Override // android.widget.CompoundButton
    public int getSwitchMinWidth() {
        return this.D;
    }

    @Override // android.widget.CompoundButton
    public int getSwitchPadding() {
        return this.E;
    }

    @Override // android.widget.CompoundButton
    public java.lang.CharSequence getTextOff() {
        return this.H;
    }

    @Override // android.widget.CompoundButton
    public java.lang.CharSequence getTextOn() {
        return this.G;
    }

    @Override // android.widget.CompoundButton
    public Drawable getThumbDrawable() {
        return this.a;
    }

    @Override // android.widget.CompoundButton
    public int getThumbTextPadding() {
        return this.C;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getThumbTintList() {
        return this.b;
    }

    @Override // android.widget.CompoundButton
    public PorterDuff.Mode getThumbTintMode() {
        return this.c;
    }

    @Override // android.widget.CompoundButton
    public Drawable getTrackDrawable() {
        return this.x;
    }

    @Override // android.widget.CompoundButton
    public ColorStateList getTrackTintList() {
        return this.y;
    }

    @Override // android.widget.CompoundButton
    public PorterDuff.Mode getTrackTintMode() {
        return this.z;
    }

    @Override // android.widget.CompoundButton
    public void i(Context context, int i2) {
        Context context2;
        int cmp;
        ColorStateList obj5;
        final androidx.appcompat.widget.t0 obj4 = t0.t(context, i2, j.J2);
        obj5 = obj4.c(j.N2);
        if (obj5 != null) {
            this.b0 = obj5;
        } else {
            this.b0 = getTextColors();
        }
        context2 = 0;
        obj5 = obj4.f(j.K2, context2);
        obj5 = (float)obj5;
        if (obj5 != null && Float.compare(obj5, textSize) != 0) {
            obj5 = (float)obj5;
            if (Float.compare(obj5, textSize) != 0) {
                this.a0.setTextSize(obj5);
                requestLayout();
            }
        }
        int i = -1;
        k(obj4.k(j.L2, i), obj4.k(j.M2, i));
        if (obj4.a(j.U2, context2)) {
            obj5 = new a(getContext());
            this.e0 = obj5;
        } else {
            this.e0 = 0;
        }
        obj4.w();
    }

    @Override // android.widget.CompoundButton
    public void j(Typeface typeface, int i2) {
        int i3;
        int i4;
        int i;
        int obj4;
        TextPaint obj5;
        i4 = 0;
        if (i2 > 0) {
            if (typeface == null) {
                obj4 = Typeface.defaultFromStyle(i2);
            } else {
                obj4 = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(obj4);
            if (obj4 != null) {
                obj4 = obj4.getStyle();
            } else {
                obj4 = i4;
            }
            obj4 &= i2;
            if (obj4 & 1 != 0) {
                i4 = 1;
            }
            this.a0.setFakeBoldText(i4);
            if (obj4 &= 2 != 0) {
                i3 = -1098907648;
            }
            this.a0.setTextSkewX(i3);
        } else {
            this.a0.setFakeBoldText(i4);
            this.a0.setTextSkewX(0);
            setSwitchTypeface(typeface);
        }
    }

    @Override // android.widget.CompoundButton
    public void jumpDrawablesToCurrentState() {
        ObjectAnimator started;
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.x;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        started = this.f0;
        if (started != null && started.isStarted()) {
            if (started.isStarted()) {
                this.f0.end();
                this.f0 = 0;
            }
        }
    }

    @Override // android.widget.CompoundButton
    protected int[] onCreateDrawableState(int i) {
        boolean checked;
        int[] obj2 = super.onCreateDrawableState(i++);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(obj2, SwitchCompat.j0);
        }
        return obj2;
    }

    @Override // android.widget.CompoundButton
    protected void onDraw(Canvas canvas) {
        Layout layout;
        int i;
        int i2;
        int right;
        boolean save;
        int width;
        Region.Op dIFFERENCE;
        ColorStateList colorForState;
        int left;
        int i3;
        super.onDraw(canvas);
        Rect rect = this.h0;
        Drawable drawable = this.x;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        right = this.a;
        if (drawable != null) {
            if (this.F && right != null) {
                if (right != null) {
                    Rect rect2 = a0.d(right);
                    right.copyBounds(rect);
                    rect.left = left3 += left;
                    rect.right = right3 -= right2;
                    canvas.clipRect(rect, Region.Op.DIFFERENCE);
                    drawable.draw(canvas);
                    canvas.restoreToCount(canvas.save());
                } else {
                    drawable.draw(canvas);
                }
            } else {
            }
        }
        if (right != null) {
            right.draw(canvas);
        }
        layout = getTargetCheckedState() ? this.c0 : this.d0;
        int[] drawableState = getDrawableState();
        colorForState = this.b0;
        if (layout != null && colorForState != null) {
            drawableState = getDrawableState();
            colorForState = this.b0;
            if (colorForState != null) {
                this.a0.setColor(colorForState.getColorForState(drawableState, 0));
            }
            dIFFERENCE.drawableState = drawableState;
            if (right != null) {
                Rect bounds = right.getBounds();
                left2 += right;
            } else {
                width = getWidth();
            }
            canvas.translate((float)save, (float)i7);
            layout.draw(canvas);
        }
        canvas.restoreToCount(canvas.save());
    }

    @Override // android.widget.CompoundButton
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.widget.CompoundButton
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        java.lang.CharSequence charSequence;
        boolean empty;
        StringBuilder stringBuilder;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        charSequence = isChecked() ? this.G : this.H;
        if (!TextUtils.isEmpty(charSequence)) {
            empty = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(empty)) {
                accessibilityNodeInfo.setText(charSequence);
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(empty);
                stringBuilder.append(' ');
                stringBuilder.append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    @Override // android.widget.CompoundButton
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int obj1;
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        super.onLayout(z, i2, i3, i4, i5);
        obj2 = 0;
        if (this.a != null) {
            obj1 = this.h0;
            obj3 = this.x;
            if (obj3 != null) {
                obj3.getPadding(obj1);
            } else {
                obj1.setEmpty();
            }
            obj3 = a0.d(this.a);
            obj4 = Math.max(obj2, obj4 -= obj5);
            obj2 = Math.max(obj2, obj3 -= obj1);
        } else {
            obj4 = obj2;
        }
        if (z0.b(this)) {
            obj3 -= obj2;
        } else {
            obj1 += obj2;
        }
        obj2 &= 112;
        if (obj2 != 16) {
            if (obj2 != 80) {
                obj2 = getPaddingTop();
                obj4 = this.R;
                obj4 += obj2;
            } else {
                obj2 = obj4 - obj2;
            }
        } else {
            obj2 -= obj5;
        }
        this.T = obj1;
        this.U = obj2;
        this.W = obj4;
        this.V = obj3;
    }

    @Override // android.widget.CompoundButton
    public void onMeasure(int i, int i2) {
        Layout layout;
        boolean z;
        int right;
        int i3;
        Drawable drawable;
        int left2;
        int intrinsicHeight2;
        int intrinsicHeight;
        int i4;
        Drawable right2;
        int left;
        int obj7;
        if (this.I && this.c0 == null) {
            if (this.c0 == null) {
                this.c0 = h(this.G);
            }
            if (this.d0 == null) {
                this.d0 = h(this.H);
            }
        }
        Rect rect = this.h0;
        Drawable drawable2 = this.a;
        intrinsicHeight2 = 0;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 -= right3;
            intrinsicHeight = this.a.getIntrinsicHeight();
        } else {
            intrinsicHeight = i3;
        }
        if (this.I) {
            i10 += left;
        } else {
            i4 = intrinsicHeight2;
        }
        this.S = Math.max(i4, i3);
        drawable = this.x;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicHeight2 = this.x.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        right2 = this.a;
        if (right2 != null) {
            Rect rect2 = a0.d(right2);
            left2 = Math.max(rect.left, rect2.left);
            right = Math.max(rect.right, rect2.right);
        }
        int i8 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.Q = Math.max(this.D, i13 += right);
        this.R = i8;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < i8) {
            setMeasuredDimension(getMeasuredWidthAndState(), i8);
        }
    }

    @Override // android.widget.CompoundButton
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        java.lang.CharSequence charSequence;
        Object obj2;
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        charSequence = isChecked() ? this.G : this.H;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    @Override // android.widget.CompoundButton
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float cmp2;
        VelocityTracker actionMasked;
        int i;
        int i2;
        int enabled;
        int cmp;
        float f;
        this.N.addMovement(motionEvent);
        actionMasked = motionEvent.getActionMasked();
        final int i6 = 1;
        if (actionMasked != 0) {
            i2 = 2;
            if (actionMasked != i6) {
                if (actionMasked != i2) {
                    if (actionMasked != 3) {
                    } else {
                    }
                } else {
                    actionMasked = this.J;
                    if (actionMasked != i6) {
                        if (actionMasked != i2) {
                        } else {
                            float obj7 = motionEvent.getX();
                            int thumbScrollRange = getThumbScrollRange();
                            int i7 = obj7 - f4;
                            int i8 = 1065353216;
                            int i9 = 0;
                            i = thumbScrollRange != 0 ? i7 / cmp2 : cmp2 > 0 ? i8 : cmp2;
                            if (z0.b(this)) {
                                i = -i;
                            }
                            float f3 = SwitchCompat.f(f2 += i, i9, i8);
                            if (Float.compare(f3, f5) != 0) {
                                this.L = obj7;
                                setThumbPosition(f3);
                            }
                        }
                        return i6;
                    }
                    actionMasked = motionEvent.getX();
                    enabled = motionEvent.getY();
                    if (Float.compare(f7, f) <= 0 && Float.compare(f9, f) > 0) {
                        if (Float.compare(f9, f) > 0) {
                        }
                    }
                }
                this.J = i2;
                getParent().requestDisallowInterceptTouchEvent(i6);
                this.L = actionMasked;
                this.M = enabled;
                return i6;
            }
            if (this.J == i2) {
                l(motionEvent);
                super.onTouchEvent(motionEvent);
                return i6;
            }
            this.J = 0;
            this.N.clear();
        } else {
            actionMasked = motionEvent.getX();
            i2 = motionEvent.getY();
            if (isEnabled() && g(actionMasked, i2)) {
                if (g(actionMasked, i2)) {
                    this.J = i6;
                    this.L = actionMasked;
                    this.M = i2;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.CompoundButton
    public void setChecked(boolean z) {
        android.os.IBinder windowToken;
        int obj2;
        super.setChecked(z);
        obj2 = isChecked();
        if (getWindowToken() != null && u.R(this)) {
            if (u.R(this)) {
                a(obj2);
            } else {
                d();
                obj2 = obj2 != null ? 1065353216 : 0;
                setThumbPosition(obj2);
            }
        } else {
        }
    }

    @Override // android.widget.CompoundButton
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    @Override // android.widget.CompoundButton
    public void setShowText(boolean z) {
        if (this.I != z) {
            this.I = z;
            requestLayout();
        }
    }

    @Override // android.widget.CompoundButton
    public void setSplitTrack(boolean z) {
        this.F = z;
        invalidate();
    }

    @Override // android.widget.CompoundButton
    public void setSwitchMinWidth(int i) {
        this.D = i;
        requestLayout();
    }

    @Override // android.widget.CompoundButton
    public void setSwitchPadding(int i) {
        this.E = i;
        requestLayout();
    }

    @Override // android.widget.CompoundButton
    public void setSwitchTypeface(Typeface typeface) {
        Object typeface2;
        if (this.a0.getTypeface() != null) {
            if (this.a0.getTypeface().equals(typeface)) {
                if (this.a0.getTypeface() == null && typeface != null) {
                    if (typeface != null) {
                        this.a0.setTypeface(typeface);
                        requestLayout();
                        invalidate();
                    }
                }
            } else {
            }
        } else {
        }
    }

    @Override // android.widget.CompoundButton
    public void setTextOff(java.lang.CharSequence charSequence) {
        this.H = charSequence;
        requestLayout();
    }

    @Override // android.widget.CompoundButton
    public void setTextOn(java.lang.CharSequence charSequence) {
        this.G = charSequence;
        requestLayout();
    }

    @Override // android.widget.CompoundButton
    public void setThumbDrawable(Drawable drawable) {
        int i;
        final Drawable drawable2 = this.a;
        if (drawable2 != null) {
            drawable2.setCallback(0);
        }
        this.a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    @Override // android.widget.CompoundButton
    void setThumbPosition(float f) {
        this.P = f;
        invalidate();
    }

    @Override // android.widget.CompoundButton
    public void setThumbResource(int i) {
        setThumbDrawable(a.d(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setThumbTextPadding(int i) {
        this.C = i;
        requestLayout();
    }

    @Override // android.widget.CompoundButton
    public void setThumbTintList(ColorStateList colorStateList) {
        this.b = colorStateList;
        this.v = true;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setThumbTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.c = mode;
        this.w = true;
        b();
    }

    @Override // android.widget.CompoundButton
    public void setTrackDrawable(Drawable drawable) {
        int i;
        final Drawable drawable2 = this.x;
        if (drawable2 != null) {
            drawable2.setCallback(0);
        }
        this.x = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    @Override // android.widget.CompoundButton
    public void setTrackResource(int i) {
        setTrackDrawable(a.d(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setTrackTintList(ColorStateList colorStateList) {
        this.y = colorStateList;
        this.A = true;
        c();
    }

    @Override // android.widget.CompoundButton
    public void setTrackTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.z = mode;
        this.B = true;
        c();
    }

    @Override // android.widget.CompoundButton
    public void toggle() {
        setChecked(checked ^= 1);
    }

    @Override // android.widget.CompoundButton
    protected boolean verifyDrawable(Drawable drawable) {
        boolean verifyDrawable;
        int obj2;
        if (!super.verifyDrawable(drawable) && drawable != this.a) {
            if (drawable != this.a) {
                if (drawable == this.x) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }
}
