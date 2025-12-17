package f.c.a.e.y;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n.a;
import androidx.appcompat.widget.v0;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.k;
import d.h.l.e0.c;
import d.h.l.e0.c.a;
import d.h.l.e0.c.c;
import d.h.l.s;
import d.h.l.u;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.e;
import f.c.a.e.f;
import f.c.a.e.g;
import f.c.a.e.j;
import f.c.a.e.m.a;
import f.c.a.e.n.a;
import f.c.a.e.n.b;
import f.c.a.e.x.a;

/* loaded from: classes2.dex */
public abstract class a extends FrameLayout implements n.a {

    private static final int[] U;
    private static final f.c.a.e.y.a.d V;
    private static final f.c.a.e.y.a.d W;
    private final FrameLayout A;
    private final View B;
    private final ImageView C;
    private final ViewGroup D;
    private final TextView E;
    private final TextView F;
    private int G = -1;
    private i H;
    private ColorStateList I;
    private Drawable J;
    private Drawable K;
    private ValueAnimator L;
    private f.c.a.e.y.a.d M = -1;
    private float N = 0f;
    private boolean O = false;
    private int P = 0;
    private int Q = 0;
    private boolean R = false;
    private int S = 0;
    private a T;
    private boolean a = false;
    private int b;
    private int c;
    private float v;
    private float w;
    private float x;
    private int y;
    private boolean z;

    class a implements View.OnLayoutChangeListener {

        final f.c.a.e.y.a a;
        a(f.c.a.e.y.a a) {
            this.a = a;
            super();
        }

        @Override // android.view.View$OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            int obj1;
            ImageView obj2;
            if (a.a(this.a).getVisibility() == 0) {
                obj1 = this.a;
                a.b(obj1, a.a(obj1));
            }
        }
    }

    class b implements Runnable {

        final int a;
        final f.c.a.e.y.a b;
        b(f.c.a.e.y.a a, int i2) {
            this.b = a;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            a.c(this.b, this.a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        final float a;
        final f.c.a.e.y.a b;
        c(f.c.a.e.y.a a, float f2) {
            this.b = a;
            this.a = f2;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.d(this.b, (Float)valueAnimator.getAnimatedValue().floatValue(), this.a);
        }
    }

    private static class d {
        d(f.c.a.e.y.a.a a$a) {
            super();
        }

        protected float a(float f, float f2) {
            int i;
            int obj5;
            final int i2 = 0;
            obj5 = Float.compare(f2, i2);
            i = obj5 == null ? 1061997773 : i2;
            final int i3 = 1065353216;
            obj5 = obj5 == null ? i3 : 1045220557;
            return a.b(i2, i3, i, obj5, f);
        }

        protected float b(float f, float f2) {
            return a.a(1053609165, 1065353216, f);
        }

        protected float c(float f, float f2) {
            return 1065353216;
        }

        public void d(float f, float f2, View view3) {
            view3.setScaleX(b(f, f2));
            view3.setScaleY(c(f, f2));
            view3.setAlpha(a(f, f2));
        }
    }

    private static class e extends f.c.a.e.y.a.d {
        private e() {
            super(0);
        }

        e(f.c.a.e.y.a.a a$a) {
            super();
        }

        @Override // f.c.a.e.y.a$d
        protected float c(float f, float f2) {
            return b(f, f2);
        }
    }
    static {
        int[] iArr = new int[1];
        a.U = iArr;
        int i3 = 0;
        a.d dVar = new a.d(i3);
        a.V = dVar;
        a.e eVar = new a.e(i3);
        a.W = eVar;
    }

    public a(Context context) {
        float textSize;
        super(context);
        int i = 0;
        int i4 = -1;
        f.c.a.e.y.a.d dVar = a.V;
        int i5 = 0;
        int i6 = 1;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, i6);
        this.A = (FrameLayout)findViewById(f.T);
        this.B = findViewById(f.S);
        View obj7 = findViewById(f.U);
        this.C = (ImageView)obj7;
        View viewById = findViewById(f.V);
        this.D = (ViewGroup)viewById;
        View viewById2 = findViewById(f.X);
        this.E = (TextView)viewById2;
        View viewById3 = findViewById(f.W);
        this.F = (TextView)viewById3;
        setBackgroundResource(getItemBackgroundResId());
        this.b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.c = viewById.getPaddingBottom();
        int i3 = 2;
        u.v0(viewById2, i3);
        u.v0(viewById3, i3);
        setFocusable(i6);
        e(viewById2.getTextSize(), viewById3.getTextSize());
        if (obj7 != null) {
            textSize = new a.a(this);
            obj7.addOnLayoutChangeListener(textSize);
        }
    }

    static ImageView a(f.c.a.e.y.a a) {
        return a.C;
    }

    static void b(f.c.a.e.y.a a, View view2) {
        a.t(view2);
    }

    static void c(f.c.a.e.y.a a, int i2) {
        a.u(i2);
    }

    static void d(f.c.a.e.y.a a, float f2, float f3) {
        a.o(f2, f3);
    }

    private void e(float f, float f2) {
        this.v = f - f2;
        int i2 = 1065353216;
        this.w = i3 /= f;
        this.x = obj3 /= f2;
    }

    private View getIconOrContainer() {
        Object frameLayout;
        if (this.A != null) {
        } else {
            frameLayout = this.C;
        }
        return frameLayout;
    }

    private int getItemVisiblePosition() {
        int i;
        int i2;
        View childAt;
        boolean z;
        final android.view.ViewParent parent = getParent();
        i2 = i;
        while (i < (ViewGroup)parent.indexOfChild(this)) {
            childAt = parent.getChildAt(i);
            if (childAt instanceof a && childAt.getVisibility() == 0) {
            }
            i++;
            if (childAt.getVisibility() == 0) {
            }
            i2++;
        }
        return i2;
    }

    private int getSuggestedIconHeight() {
        int i;
        a aVar = this.T;
        if (aVar != null) {
            minimumHeight /= 2;
        } else {
            i = 0;
        }
        return i3 += i;
    }

    private int getSuggestedIconWidth() {
        int i;
        int i2;
        a aVar = this.T;
        if (aVar == null) {
            i = 0;
        } else {
            minimumWidth -= i2;
        }
        android.view.ViewGroup.LayoutParams layoutParams = getIconOrContainer().getLayoutParams();
        return i5 += i3;
    }

    private FrameLayout i(View view) {
        int i;
        ImageView obj3;
        final ImageView view2 = this.C;
        i = 0;
        if (view == view2 && b.a) {
            if (b.a) {
                i = obj3;
            }
        }
        return i;
    }

    private boolean j() {
        int i;
        i = this.T != null ? 1 : 0;
        return i;
    }

    private boolean k() {
        boolean z;
        int i;
        int i2;
        if (this.R && this.y == 2) {
            i = this.y == 2 ? 1 : 0;
        } else {
        }
        return i;
    }

    private void l(float f) {
        boolean z;
        ValueAnimator valueAnimator;
        if (this.O && this.a) {
            if (this.a) {
                if (!u.Q(this)) {
                } else {
                    valueAnimator = this.L;
                    if (valueAnimator != null) {
                        valueAnimator.cancel();
                        this.L = 0;
                    }
                }
                float[] fArr = new float[2];
                ValueAnimator float = ValueAnimator.ofFloat(this.N, f);
                this.L = float;
                a.c cVar = new a.c(this, f);
                float.addUpdateListener(cVar);
                this.L.setInterpolator(a.e(getContext(), b.J, a.b));
                int i6 = b.I;
                this.L.setDuration((long)i2);
                this.L.start();
            }
        }
        o(f, f);
    }

    private void m() {
        i checked;
        checked = this.H;
        if (checked != null) {
            setChecked(checked.isChecked());
        }
    }

    private void o(float f, float f2) {
        f.c.a.e.y.a.d dVar;
        final View view = this.B;
        if (view != null) {
            this.M.d(f, f2, view);
        }
        this.N = f;
    }

    private static void p(View view, float f2, float f3, int i4) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i4);
    }

    private static void q(View view, int i2, int i3) {
        final android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams((FrameLayout.LayoutParams)layoutParams);
    }

    private void r(View view) {
        boolean z;
        FrameLayout frameLayout;
        if (!j()) {
        }
        if (view != null) {
            int i = 0;
            setClipChildren(i);
            setClipToPadding(i);
            b.a(this.T, view, i(view));
        }
    }

    private void s(View view) {
        boolean z;
        if (!j()) {
        }
        if (view != null) {
            int i = 1;
            setClipChildren(i);
            setClipToPadding(i);
            b.d(this.T, view);
        }
        this.T = 0;
    }

    private void t(View view) {
        if (!j()) {
        }
        b.e(this.T, view, i(view));
    }

    private void u(int i) {
        int i2;
        if (this.B == null) {
        }
        int obj3 = Math.min(this.P, i -= i5);
        android.view.ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
        i2 = k() ? obj3 : this.Q;
        layoutParams.height = i2;
        layoutParams.width = obj3;
        this.B.setLayoutParams((FrameLayout.LayoutParams)layoutParams);
    }

    private void v() {
        f.c.a.e.y.a.d dVar;
        if (k()) {
            this.M = a.W;
        } else {
            this.M = a.V;
        }
    }

    private static void w(View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    @Override // android.widget.FrameLayout
    void f() {
        n();
        this.H = 0;
        this.N = 0;
        this.a = false;
    }

    @Override // android.widget.FrameLayout
    public boolean g() {
        return 0;
    }

    @Override // android.widget.FrameLayout
    public Drawable getActiveIndicatorDrawable() {
        View view = this.B;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Override // android.widget.FrameLayout
    public a getBadge() {
        return this.T;
    }

    @Override // android.widget.FrameLayout
    protected int getItemBackgroundResId() {
        return e.g;
    }

    @Override // android.widget.FrameLayout
    public i getItemData() {
        return this.H;
    }

    @Override // android.widget.FrameLayout
    protected int getItemDefaultMarginResId() {
        return d.h0;
    }

    @Override // android.widget.FrameLayout
    protected abstract int getItemLayoutResId();

    @Override // android.widget.FrameLayout
    public int getItemPosition() {
        return this.G;
    }

    @Override // android.widget.FrameLayout
    protected int getSuggestedMinimumHeight() {
        android.view.ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        return i2 += bottomMargin;
    }

    @Override // android.widget.FrameLayout
    protected int getSuggestedMinimumWidth() {
        android.view.ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), i2 += rightMargin);
    }

    @Override // android.widget.FrameLayout
    public void h(i i, int i2) {
        int i3;
        int obj3;
        boolean obj4;
        this.H = i;
        setCheckable(i.isCheckable());
        setChecked(i.isChecked());
        setEnabled(i.isEnabled());
        setIcon(i.getIcon());
        setTitle(i.getTitle());
        setId(i.getItemId());
        if (!TextUtils.isEmpty(i.getContentDescription())) {
            setContentDescription(i.getContentDescription());
        }
        if (!TextUtils.isEmpty(i.getTooltipText())) {
            obj4 = i.getTooltipText();
        } else {
            obj4 = i.getTitle();
        }
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 21) {
            if (sDK_INT > 23) {
                v0.a(this, obj4);
            }
        } else {
        }
        obj3 = i.isVisible() ? 0 : 8;
        setVisibility(obj3);
        this.a = true;
    }

    @Override // android.widget.FrameLayout
    void n() {
        s(this.C);
    }

    @Override // android.widget.FrameLayout
    public int[] onCreateDrawableState(int i) {
        i checkable;
        int[] obj2 = super.onCreateDrawableState(i++);
        checkable = this.H;
        if (checkable != null && checkable.isCheckable() && this.H.isChecked()) {
            if (checkable.isCheckable()) {
                if (this.H.isChecked()) {
                    FrameLayout.mergeDrawableStates(obj2, a.U);
                }
            }
        }
        return obj2;
    }

    @Override // android.widget.FrameLayout
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        a visible;
        boolean selected;
        java.lang.CharSequence contentDescription;
        StringBuilder stringBuilder;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        visible = this.T;
        contentDescription = this.H.getTitle();
        if (visible != null && visible.isVisible() && !TextUtils.isEmpty(this.H.getContentDescription())) {
            if (visible.isVisible()) {
                contentDescription = this.H.getTitle();
                if (!TextUtils.isEmpty(this.H.getContentDescription())) {
                    contentDescription = this.H.getContentDescription();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append(contentDescription);
                stringBuilder.append(", ");
                stringBuilder.append(this.T.h());
                accessibilityNodeInfo.setContentDescription(stringBuilder.toString());
            }
        }
        final c obj7 = c.y0(accessibilityNodeInfo);
        obj7.a0(c.c.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            obj7.Y(false);
            obj7.P(c.a.e);
        }
        obj7.o0(getResources().getString(j.h));
    }

    @Override // android.widget.FrameLayout
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a.b obj2 = new a.b(this, i);
        post(obj2);
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorDrawable(Drawable drawable) {
        final View view = this.B;
        if (view == null) {
        }
        view.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorEnabled(boolean z) {
        int obj2;
        this.O = z;
        final View view = this.B;
        if (view != null) {
            obj2 = z ? 0 : 8;
            view.setVisibility(obj2);
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorHeight(int i) {
        this.Q = i;
        u(getWidth());
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorMarginHorizontal(int i) {
        this.S = i;
        u(getWidth());
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorResizeable(boolean z) {
        this.R = z;
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorWidth(int i) {
        this.P = i;
        u(getWidth());
    }

    @Override // android.widget.FrameLayout
    void setBadge(a a) {
        this.T = a;
        final ImageView obj1 = this.C;
        if (obj1 != null) {
            r(obj1);
        }
    }

    @Override // android.widget.FrameLayout
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // android.widget.FrameLayout
    public void setChecked(boolean z) {
        TextView view2;
        TextView i3;
        TextView view;
        int i4;
        int i;
        int i2;
        int i5;
        TextView view3 = this.F;
        i2 = 2;
        view3.setPivotX((float)i6);
        TextView view4 = this.F;
        view4.setPivotY((float)baseline);
        TextView view5 = this.E;
        view5.setPivotX((float)i7);
        TextView view6 = this.E;
        view6.setPivotY((float)baseline2);
        i3 = 1065353216;
        i4 = z ? i3 : 0;
        l(i4);
        i = this.y;
        final int i19 = 17;
        final int i20 = 49;
        final int i21 = 4;
        final int i22 = 0;
        if (i != -1) {
            if (i != 0) {
                if (i != 1) {
                    if (i != i2) {
                    } else {
                        a.q(getIconOrContainer(), this.b, i19);
                        i = 8;
                        this.F.setVisibility(i);
                        this.E.setVisibility(i);
                    }
                } else {
                    a.w(this.D, this.c);
                    if (z) {
                        a.q(getIconOrContainer(), (int)i14, i20);
                        a.p(this.F, i3, i3, i22);
                        i = this.w;
                        a.p(this.E, i, i, i21);
                    } else {
                        a.q(getIconOrContainer(), this.b, i20);
                        i2 = this.x;
                        a.p(this.F, i2, i2, i21);
                        a.p(this.E, i3, i3, i22);
                    }
                }
            } else {
                if (z) {
                    a.q(getIconOrContainer(), this.b, i20);
                    a.w(this.D, this.c);
                    this.F.setVisibility(i22);
                } else {
                    a.q(getIconOrContainer(), this.b, i19);
                    a.w(this.D, i22);
                    this.F.setVisibility(i21);
                }
                this.E.setVisibility(i21);
            }
        } else {
            if (this.z) {
                if (z) {
                    a.q(getIconOrContainer(), this.b, i20);
                    a.w(this.D, this.c);
                    this.F.setVisibility(i22);
                } else {
                    a.q(getIconOrContainer(), this.b, i19);
                    a.w(this.D, i22);
                    this.F.setVisibility(i21);
                }
                this.E.setVisibility(i21);
            } else {
                a.w(this.D, this.c);
                if (z) {
                    a.q(getIconOrContainer(), (int)i17, i20);
                    a.p(this.F, i3, i3, i22);
                    i = this.w;
                    a.p(this.E, i, i, i21);
                } else {
                    a.q(getIconOrContainer(), this.b, i20);
                    i2 = this.x;
                    a.p(this.F, i2, i2, i21);
                    a.p(this.E, i3, i3, i22);
                }
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.widget.FrameLayout
    public void setEnabled(boolean z) {
        int view;
        s obj2;
        super.setEnabled(z);
        this.E.setEnabled(z);
        this.F.setEnabled(z);
        this.C.setEnabled(z);
        if (z) {
            u.z0(this, s.b(getContext(), 1002));
        } else {
            u.z0(this, 0);
        }
    }

    @Override // android.widget.FrameLayout
    public void setIcon(Drawable drawable) {
        Object drawable2;
        Drawable obj2;
        if (drawable == this.J) {
        }
        this.J = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
            } else {
                obj2 = constantState.newDrawable();
            }
            obj2 = a.r(obj2).mutate();
            this.K = obj2;
            drawable2 = this.I;
            if (drawable2 != null) {
                a.o(obj2, drawable2);
            }
        }
        this.C.setImageDrawable(obj2);
    }

    @Override // android.widget.FrameLayout
    public void setIconSize(int i) {
        android.view.ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.C.setLayoutParams((FrameLayout.LayoutParams)layoutParams);
    }

    @Override // android.widget.FrameLayout
    public void setIconTintList(ColorStateList colorStateList) {
        Object iVar;
        Object obj2;
        this.I = colorStateList;
        iVar = this.K;
        if (this.H != null && iVar != null) {
            iVar = this.K;
            if (iVar != null) {
                a.o(iVar, colorStateList);
                this.K.invalidateSelf();
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void setItemBackground(int i) {
        Context context;
        int obj2;
        if (i == 0) {
            obj2 = 0;
        } else {
            obj2 = a.f(getContext(), i);
        }
        setItemBackground(obj2);
    }

    @Override // android.widget.FrameLayout
    public void setItemBackground(Drawable drawable) {
        Drawable.ConstantState constantState;
        Drawable obj2;
        if (drawable != null && drawable.getConstantState() != null) {
            if (drawable.getConstantState() != null) {
                obj2 = drawable.getConstantState().newDrawable().mutate();
            }
        }
        u.o0(this, obj2);
    }

    @Override // android.widget.FrameLayout
    public void setItemPaddingBottom(int i) {
        if (this.c != i) {
            this.c = i;
            m();
        }
    }

    @Override // android.widget.FrameLayout
    public void setItemPaddingTop(int i) {
        if (this.b != i) {
            this.b = i;
            m();
        }
    }

    @Override // android.widget.FrameLayout
    public void setItemPosition(int i) {
        this.G = i;
    }

    @Override // android.widget.FrameLayout
    public void setLabelVisibilityMode(int i) {
        int obj2;
        if (this.y != i) {
            this.y = i;
            v();
            u(getWidth());
            m();
        }
    }

    @Override // android.widget.FrameLayout
    public void setShifting(boolean z) {
        if (this.z != z) {
            this.z = z;
            m();
        }
    }

    @Override // android.widget.FrameLayout
    public void setTextAppearanceActive(int i) {
        k.q(this.F, i);
        e(this.E.getTextSize(), this.F.getTextSize());
    }

    @Override // android.widget.FrameLayout
    public void setTextAppearanceInactive(int i) {
        k.q(this.E, i);
        e(this.E.getTextSize(), this.F.getTextSize());
    }

    @Override // android.widget.FrameLayout
    public void setTextColor(ColorStateList colorStateList) {
        TextView view;
        if (colorStateList != null) {
            this.E.setTextColor(colorStateList);
            this.F.setTextColor(colorStateList);
        }
    }

    @Override // android.widget.FrameLayout
    public void setTitle(java.lang.CharSequence charSequence) {
        i empty;
        i empty2;
        int i;
        java.lang.CharSequence obj3;
        this.E.setText(charSequence);
        this.F.setText(charSequence);
        empty = this.H;
        if (empty != null) {
            if (TextUtils.isEmpty(empty.getContentDescription())) {
                setContentDescription(charSequence);
            }
        } else {
        }
        empty2 = this.H;
        if (empty2 != null) {
            if (TextUtils.isEmpty(empty2.getTooltipText())) {
            } else {
                obj3 = this.H.getTooltipText();
            }
        }
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 21) {
            if (sDK_INT > 23) {
                v0.a(this, obj3);
            }
        } else {
        }
    }
}
