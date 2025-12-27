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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n.a;
import androidx.appcompat.widget.v0;
import androidx.core.widget.k;
import d.h.l.e0.c;
import d.h.l.e0.c.a;
import d.h.l.e0.c.c;
import d.h.l.s;
import d.h.l.u;
import f.c.a.e.d;
import f.c.a.e.e;
import f.c.a.e.f;
import f.c.a.e.g;
import f.c.a.e.j;

/* compiled from: NavigationBarItemView.java */
/* loaded from: classes2.dex */
public abstract class a extends FrameLayout implements n.a {

    private static final int[] U;
    private static final a.d V = new a$d(0);
    private static final a.d W = new a$e(0);
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
    private a.d M;
    private float N = 0f;
    private boolean O = false;
    private int P = 0;
    private int Q = 0;
    private boolean R = false;
    private int S = 0;
    private f.c.a.e.n.a T;
    private boolean a = false;
    private int b;
    private int c;
    private float v;
    private float w;
    private float x;
    private int y;
    private boolean z;

    class a implements View.OnLayoutChangeListener {

        final /* synthetic */ a a;
        a() {
            this.a = aVar;
            super();
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.a.C.getVisibility() == 0) {
                this.a.t(this.a.C);
            }
        }
    }

    class b implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ a b;
        b(int i) {
            this.b = aVar;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.u(this.a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {

        final /* synthetic */ float a;
        final /* synthetic */ a b;
        c(float f) {
            this.b = aVar;
            this.a = f;
            super();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.b.o((Float)valueAnimator.getAnimatedValue().floatValue(), this.a);
        }
    }

    private static class d {
        private d() {
            super();
        }

        protected float a(float f, float f2) {
            int i = 1061997773;
            int i2 = 1045220557;
            final float f3 = 0.0f;
            int r1 = f2 == 0.0f ? 1061997773 : f3;
            final float f4 = 1f;
            f2 = f2 == 0.0f ? f4 : 1045220557;
            return a.b(0.0f, f4, i, (f2 == 0.0f ? f4 : 1045220557), f);
        }

        protected float b(float f, float f2) {
            return a.a(0.4f, 1f, f);
        }

        public void d(float f, float f2, View view) {
            view.setScaleX(b(f, f2));
            view.setScaleY(c(f, f2));
            view.setAlpha(a(f, f2));
        }

        /* synthetic */ d(a.a aVar) {
            this();
        }

        protected float c(float f, float f2) {
            return 1065353216;
        }
    }

    private static class e extends a.d {
        private e() {
            super(null);
        }

        @Override // f.c.a.e.y.a$d
        protected float c(float f, float f2) {
            return b(f, f2);
        }

        /* synthetic */ e(a.a aVar) {
            this();
        }
    }
    static {
        int[] iArr = new int[1];
        a.U = new int[] { 0x010100a0 /* Unknown resource */ };
    }

    public a(Context context) throws android.content.res.Resources.NotFoundException {
        super(context);
        this.M = a.V;
        boolean z = true;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, z);
        this.A = (FrameLayout)findViewById(f.T);
        this.B = findViewById(f.S);
        View viewById6 = findViewById(f.U);
        this.C = viewById6;
        View viewById = findViewById(f.V);
        this.D = viewById;
        View viewById2 = findViewById(f.X);
        this.E = viewById2;
        View viewById3 = findViewById(f.W);
        this.F = viewById3;
        setBackgroundResource(getItemBackgroundResId());
        this.b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.c = viewById.getPaddingBottom();
        int i3 = 2;
        u.v0(viewById2, i3);
        u.v0(viewById3, i3);
        setFocusable(z);
        e(viewById2.getTextSize(), viewById3.getTextSize());
        if (viewById6 != null) {
            viewById6.addOnLayoutChangeListener(new a.a(this));
        }
    }

    static /* synthetic */ ImageView a(a aVar) {
        return aVar.C;
    }

    static /* synthetic */ void b(a aVar, View view) {
        aVar.t(view);
    }

    static /* synthetic */ void c(a aVar, int i) {
        aVar.u(i);
    }

    static /* synthetic */ void d(a aVar, float f, float f2) {
        aVar.o(f, f2);
    }

    private void e(float f, float f2) {
        this.v = f - f2;
        float f4 = 1f;
        this.w = (f2 * f4) / f;
        this.x = (f * f4) / f2;
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout;
        if (this.A == null) {
        }
        return frameLayout;
    }

    private int getItemVisiblePosition() {
        int i = 0;
        View childAt;
        final android.view.ViewParent parent = getParent();
        i = 0;
        while (i < parent.indexOfChild(this)) {
            childAt = parent.getChildAt(i);
            z = childAt instanceof a;
            i = i + 1;
        }
        return i;
    }

    private int getSuggestedIconHeight() {
        int i = 0;
        i = this.T != null ? minimumHeight / 2 : 0;
        return (Math.max(i, (FrameLayout.LayoutParams)getIconOrContainer().getLayoutParams().topMargin)) + this.C.getMeasuredWidth() + i;
    }

    private int getSuggestedIconWidth() {
        int i = 0;
        if (this.T == null) {
            i = 0;
        } else {
            i = this.T.getMinimumWidth() - this.T.j();
        }
        android.view.ViewGroup.LayoutParams layoutParams = getIconOrContainer().getLayoutParams();
        return (Math.max(i, layoutParams.leftMargin)) + this.C.getMeasuredWidth() + (Math.max(i, layoutParams.rightMargin));
    }

    private FrameLayout i(View view) {
        int i = 0;
        i = 0;
        if (b.a == this.C && b.a) {
        }
        return i;
    }

    private boolean j() {
        boolean z = true;
        int r0 = this.T != null ? 1 : 0;
        return (this.T != null ? 1 : 0);
    }

    private boolean k() {
        boolean z2 = false;
        int i = 2;
        if (this.R) {
            i = 2;
            int r0 = this.y == 2 ? 1 : 0;
        }
        return (this.y == 2 ? 1 : 0);
    }

    private void l(float f) throws android.content.res.Resources.NotFoundException {
        o(f, f);
    }

    private void m() {
        if (this.H != null) {
            setChecked(this.H.isChecked());
        }
    }

    private void o(float f, float f2) {
        if (this.B != null) {
            this.M.d(f, f2, this.B);
        }
        this.N = f;
    }

    private static void p(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private static void q(View view, int i, int i2) {
        final android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private void r(View view) {
        if (!j()) {
            return;
        }
        if (view != null) {
            boolean z2 = false;
            setClipChildren(z2);
            setClipToPadding(z2);
            b.a(this.T, view, i(view));
        }
    }

    private void s(View view) {
        if (!j()) {
            return;
        }
        if (view != null) {
            boolean z2 = true;
            setClipChildren(z2);
            setClipToPadding(z2);
            b.d(this.T, view);
        }
        this.T = null;
    }

    private void t(View view) {
        if (!j()) {
            return;
        }
        b.e(this.T, view, i(view));
    }

    private void u(int i) {
        int i2;
        if (this.B == null) {
            return;
        }
        i2 = Math.min(this.P, i - (this.S * 2));
        android.view.ViewGroup.LayoutParams layoutParams = this.B.getLayoutParams();
        int r1 = k() ? i2 : this.Q;
        layoutParams.height = (k() ? i2 : this.Q);
        layoutParams.width = i2;
        this.B.setLayoutParams(layoutParams);
    }

    private void v() {
        if (k()) {
            this.M = a.W;
        } else {
            this.M = a.V;
        }
    }

    private static void w(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    @Override // android.widget.FrameLayout
    void f() {
        n();
        this.H = null;
        this.N = 0.0f;
        this.a = false;
    }

    @Override // android.widget.FrameLayout
    public Drawable getActiveIndicatorDrawable() {
        if (this.B == null) {
            return null;
        }
        return this.B.getBackground();
    }

    @Override // android.widget.FrameLayout
    public f.c.a.e.n.a getBadge() {
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
    public int getItemPosition() {
        return this.G;
    }

    @Override // android.widget.FrameLayout
    protected int getSuggestedMinimumHeight() {
        android.view.ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        return (getSuggestedIconHeight() + layoutParams.topMargin) + this.D.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.widget.FrameLayout
    protected int getSuggestedMinimumWidth() {
        android.view.ViewGroup.LayoutParams layoutParams = this.D.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), (layoutParams.leftMargin + this.D.getMeasuredWidth()) + layoutParams.rightMargin);
    }

    @Override // android.widget.FrameLayout
    public void h(i iVar, int i) {
        int i3 = 8;
        java.lang.CharSequence tooltipText;
        this.H = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        if (!TextUtils.isEmpty(iVar.getTooltipText())) {
            tooltipText = iVar.getTooltipText();
        } else {
            tooltipText = iVar.getTitle();
        }
        final int sDK_INT2 = Build.VERSION.SDK_INT;
        i = 21;
        if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 23) {
            v0.a(this, tooltipText);
        }
        iVar = iVar.isVisible() ? 0 : 8;
        setVisibility((iVar.isVisible() ? 0 : 8));
        this.a = true;
    }

    @Override // android.widget.FrameLayout
    void n() {
        s(this.C);
    }

    @Override // android.widget.FrameLayout
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.H != null && this.H.isCheckable()) {
            if (this.H.isChecked()) {
                FrameLayout.mergeDrawableStates(onCreateDrawableState, a.U);
            }
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.FrameLayout
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) throws android.content.res.Resources.NotFoundException {
        Object obj;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.T != null && this.T.isVisible()) {
            java.lang.CharSequence title = this.H.getTitle();
            if (!TextUtils.isEmpty(this.H.getContentDescription())) {
                java.lang.CharSequence contentDescription = this.H.getContentDescription();
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str = ", ";
            java.lang.CharSequence charSequence = this.T.h();
            str2 = obj + str + charSequence;
            accessibilityNodeInfo.setContentDescription(str2);
        }
        final c cVar2 = c.y0(accessibilityNodeInfo);
        cVar2.a0(c.c.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            cVar2.Y(false);
            cVar2.P(c.a.e);
        }
        cVar2.o0(getResources().getString(j.h));
    }

    @Override // android.widget.FrameLayout
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new a.b(this, i));
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorDrawable(Drawable drawable) {
        if (this.B == null) {
            return;
        }
        this.B.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.FrameLayout
    public void setActiveIndicatorEnabled(boolean z) {
        int i = 8;
        this.O = z;
        if (this.B != null && z) {
            i = 0;
            this.B.setVisibility(i);
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
    void setBadge(f.c.a.e.n.a aVar) {
        this.T = aVar;
        if (this.C != null) {
            r(this.C);
        }
    }

    @Override // android.widget.FrameLayout
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // android.widget.FrameLayout
    public void setChecked(boolean z) {
        int i = 0;
        int i2;
        int i3 = 2;
        this.F.setPivotX((float)(this.F.getWidth() / i3));
        this.F.setPivotY((float)this.F.getBaseline());
        this.E.setPivotX((float)(this.E.getWidth() / i3));
        this.E.setPivotY((float)this.E.getBaseline());
        float f = 1f;
        float r1 = z ? f : 0;
        l((z ? f : 0));
        int i4 = -1;
        final int i16 = 17;
        final int i17 = 49;
        final int i18 = 4;
        final int i19 = 0;
        if (this.y != -1) {
            if (this.y == 0) {
                if (z) {
                    a.q(getIconOrContainer(), this.b, i17);
                    a.w(this.D, this.c);
                    this.F.setVisibility(i19);
                } else {
                    a.q(getIconOrContainer(), this.b, i16);
                    a.w(this.D, i19);
                    this.F.setVisibility(i18);
                }
                this.E.setVisibility(i18);
            } else {
                i4 = 1;
                if (this.y != 1) {
                    if (this.y == i3) {
                        a.q(getIconOrContainer(), this.b, i16);
                        i2 = 8;
                        this.F.setVisibility(i2);
                        this.E.setVisibility(i2);
                    }
                } else {
                    a.w(this.D, this.c);
                    if (z) {
                        i3 = (int)(float)this.b + this.v;
                        a.q(getIconOrContainer(), i3, i17);
                        a.p(this.F, f, f, i19);
                        a.p(this.E, this.w, this.w, i18);
                    } else {
                        a.q(getIconOrContainer(), this.b, i17);
                        a.p(this.F, this.x, this.x, i18);
                        a.p(this.E, f, f, i19);
                    }
                }
            }
        } else {
            if (this.z) {
                if (z) {
                    a.q(getIconOrContainer(), this.b, i17);
                    a.w(this.D, this.c);
                    this.F.setVisibility(i19);
                } else {
                    a.q(getIconOrContainer(), this.b, i16);
                    a.w(this.D, i19);
                    this.F.setVisibility(i18);
                }
                this.E.setVisibility(i18);
            } else {
                a.w(this.D, this.c);
                if (z) {
                    i3 = (int)(float)this.b + this.v;
                    a.q(getIconOrContainer(), i3, i17);
                    a.p(this.F, f, f, i19);
                    a.p(this.E, this.w, this.w, i18);
                } else {
                    a.q(getIconOrContainer(), this.b, i17);
                    a.p(this.F, this.x, this.x, i18);
                    a.p(this.E, f, f, i19);
                }
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.widget.FrameLayout
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.E.setEnabled(z);
        this.F.setEnabled(z);
        this.C.setEnabled(z);
        if (z) {
            int i = 1002;
            u.z0(this, s.b(getContext(), i));
        } else {
            s sVar = null;
            u.z0(this, sVar);
        }
    }

    @Override // android.widget.FrameLayout
    public void setIcon(Drawable drawable) {
        Drawable drawable3;
        Drawable mutate;
        if (drawable == this.J) {
            return;
        }
        this.J = drawable;
        if (drawable != null && constantState == null) {
            mutate = a.r(drawable3).mutate();
            this.K = mutate;
            if (this.I != null) {
                a.o(mutate, this.I);
            }
        }
        this.C.setImageDrawable(mutate);
    }

    @Override // android.widget.FrameLayout
    public void setIconSize(int i) {
        android.view.ViewGroup.LayoutParams layoutParams = this.C.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.C.setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout
    public void setIconTintList(ColorStateList list) {
        this.I = list;
        if (this.H != null && this.K != null) {
            a.o(this.K, list);
            this.K.invalidateSelf();
        }
    }

    @Override // android.widget.FrameLayout
    public void setItemBackground(int i) {
        Drawable drawable = null;
        if (i == 0) {
            int i2 = 0;
        } else {
            drawable = a.f(getContext(), i);
        }
        setItemBackground(drawable);
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
    public void setTextColor(ColorStateList list) {
        if (list != null) {
            this.E.setTextColor(list);
            this.F.setTextColor(list);
        }
    }

    @Override // android.widget.FrameLayout
    public void setTitle(java.lang.CharSequence charSequence) {
        i iVar;
        int i = 21;
        java.lang.CharSequence tooltipText;
        this.E.setText(charSequence);
        this.F.setText(charSequence);
        if (this.H != null) {
            if (TextUtils.isEmpty(this.H.getContentDescription())) {
                setContentDescription(charSequence);
            }
        }
        if (this.H != null) {
            if (!(TextUtils.isEmpty(this.H.getTooltipText()))) {
                tooltipText = this.H.getTooltipText();
            }
        }
        int sDK_INT2 = Build.VERSION.SDK_INT;
        i = 21;
        if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 23) {
            v0.a(this, tooltipText);
        }
    }

    @Override // android.widget.FrameLayout
    public void setItemBackground(Drawable drawable) {
        Drawable mutate;
        if (drawable != null && drawable.getConstantState() != null) {
            mutate = drawable.getConstantState().newDrawable().mutate();
        }
        u.o0(this, mutate);
    }

    @Override // android.widget.FrameLayout
    public boolean g() {
        return false;
    }

    @Override // android.widget.FrameLayout
    protected abstract int getItemLayoutResId();
}
