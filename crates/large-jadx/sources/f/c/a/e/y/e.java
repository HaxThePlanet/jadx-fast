package f.c.a.e.y;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.t0;
import androidx.core.graphics.drawable.a;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import d.a.o.g;
import d.h.l.u;
import d.j.a.a;
import f.c.a.e.a0.c;
import f.c.a.e.b0.b;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.d0.h;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public abstract class e extends FrameLayout {

    private final f.c.a.e.y.b a;
    private final f.c.a.e.y.c b;
    private final f.c.a.e.y.d c;
    private ColorStateList v;
    private MenuInflater w;
    private f.c.a.e.y.e.c x;
    private f.c.a.e.y.e.b y;

    public interface b {
        public abstract void a(MenuItem menuItem);
    }

    public interface c {
        public abstract boolean a(MenuItem menuItem);
    }

    class a implements g.a {

        final f.c.a.e.y.e a;
        a(f.c.a.e.y.e e) {
            this.a = e;
            super();
        }

        @Override // androidx.appcompat.view.menu.g$a
        public boolean a(g g, MenuItem menuItem2) {
            int i;
            int selectedItemId;
            f.c.a.e.y.e.b obj3;
            if (e.a(this.a) != null && menuItem2.getItemId() == this.a.getSelectedItemId()) {
                if (menuItem2.getItemId() == this.a.getSelectedItemId()) {
                    e.a(this.a).a(menuItem2);
                    return 1;
                }
            }
            if (e.b(this.a) != null && !e.b(this.a).a(menuItem2)) {
                if (!e.b(this.a).a(menuItem2)) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        @Override // androidx.appcompat.view.menu.g$a
        public void b(g g) {
        }
    }

    static class d extends a {

        public static final Parcelable.Creator<f.c.a.e.y.e.d> CREATOR;
        Bundle c;
        static {
            e.d.a aVar = new e.d.a();
            e.d.CREATOR = aVar;
        }

        public d(Parcel parcel, java.lang.ClassLoader classLoader2) {
            java.lang.ClassLoader obj2;
            super(parcel, classLoader2);
            if (classLoader2 == null) {
                obj2 = e.d.class.getClassLoader();
            }
            b(parcel, obj2);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel, java.lang.ClassLoader classLoader2) {
            this.c = parcel.readBundle(classLoader2);
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.c);
        }
    }
    public e(Context context, AttributeSet attributeSet2, int i3, int i4) {
        int i;
        ColorStateList obj12;
        super(a.c(context, attributeSet2, i3, i4), attributeSet2, i3);
        obj12 = new d();
        this.c = obj12;
        final Context context4 = getContext();
        final int[] iArr2 = new int[2];
        final int q3 = l.Q3;
        final int i8 = 0;
        iArr2[i8] = q3;
        final int p3 = l.P3;
        final int i9 = 1;
        iArr2[i9] = p3;
        final t0 obj13 = l.i(context4, attributeSet2, l.F3, i3, i4, iArr2);
        b obj14 = new b(context4, getClass(), getMaxItemCount());
        this.a = obj14;
        f.c.a.e.y.c obj15 = d(context4);
        this.b = obj15;
        obj12.b(obj15);
        obj12.a(i9);
        obj15.setPresenter(obj12);
        obj14.b(obj12);
        obj12.i(getContext(), obj14);
        obj12 = l.L3;
        if (obj13.s(obj12)) {
            obj15.setIconTintList(obj13.c(obj12));
        } else {
            obj15.setIconTintList(obj15.e(16842808));
        }
        setItemIconSize(obj13.f(l.K3, getResources().getDimensionPixelSize(d.g0)));
        if (obj13.s(q3)) {
            setItemTextAppearanceInactive(obj13.n(q3, i8));
        }
        if (obj13.s(p3)) {
            setItemTextAppearanceActive(obj13.n(p3, i8));
        }
        obj12 = l.R3;
        if (obj13.s(obj12)) {
            setItemTextColor(obj13.c(obj12));
        }
        if (getBackground() != null) {
            if (obj12 instanceof ColorDrawable) {
                u.o0(this, c(context4));
            }
        } else {
        }
        obj12 = l.N3;
        if (obj13.s(obj12)) {
            setItemPaddingTop(obj13.f(obj12, i8));
        }
        obj12 = l.M3;
        if (obj13.s(obj12)) {
            setItemPaddingBottom(obj13.f(obj12, i8));
        }
        obj12 = l.H3;
        if (obj13.s(obj12)) {
            setElevation((float)obj12);
        }
        a.o(getBackground().mutate(), c.b(context4, obj13, l.G3));
        setLabelVisibilityMode(obj13.l(l.S3, -1));
        obj12 = obj13.n(l.J3, i8);
        if (obj12 != null) {
            obj15.setItemBackgroundRes(obj12);
        } else {
            setItemRippleColor(c.b(context4, obj13, l.O3));
        }
        obj12 = obj13.n(l.I3, i8);
        if (obj12 != null) {
            setItemActiveIndicatorEnabled(i9);
            obj12 = context4.obtainStyledAttributes(obj12, l.z3);
            setItemActiveIndicatorWidth(obj12.getDimensionPixelSize(l.B3, i8));
            setItemActiveIndicatorHeight(obj12.getDimensionPixelSize(l.A3, i8));
            setItemActiveIndicatorMarginHorizontal(obj12.getDimensionPixelOffset(l.D3, i8));
            setItemActiveIndicatorColor(c.a(context4, obj12, l.C3));
            setItemActiveIndicatorShapeAppearance(k.b(context4, obj12.getResourceId(l.E3, i8), i8).m());
            obj12.recycle();
        }
        obj12 = l.T3;
        if (obj13.s(obj12)) {
            e(obj13.n(obj12, i8));
        }
        obj13.w();
        addView(obj15);
        obj12 = new e.a(this);
        obj14.V(obj12);
    }

    static f.c.a.e.y.e.b a(f.c.a.e.y.e e) {
        return e.y;
    }

    static f.c.a.e.y.e.c b(f.c.a.e.y.e e) {
        return e.x;
    }

    private g c(Context context) {
        Object valueOf;
        g gVar = new g();
        valueOf = getBackground();
        if (valueOf instanceof ColorDrawable) {
            gVar.Z(ColorStateList.valueOf((ColorDrawable)valueOf.getColor()));
        }
        gVar.O(context);
        return gVar;
    }

    private MenuInflater getMenuInflater() {
        Object gVar;
        Context context;
        if (this.w == null) {
            gVar = new g(getContext());
            this.w = gVar;
        }
        return this.w;
    }

    @Override // android.widget.FrameLayout
    protected abstract f.c.a.e.y.c d(Context context);

    @Override // android.widget.FrameLayout
    public void e(int i) {
        final int i3 = 1;
        this.c.k(i3);
        getMenuInflater().inflate(i, this.a);
        this.c.k(false);
        this.c.d(i3);
    }

    @Override // android.widget.FrameLayout
    public ColorStateList getItemActiveIndicatorColor() {
        return this.b.getItemActiveIndicatorColor();
    }

    @Override // android.widget.FrameLayout
    public int getItemActiveIndicatorHeight() {
        return this.b.getItemActiveIndicatorHeight();
    }

    @Override // android.widget.FrameLayout
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.b.getItemActiveIndicatorMarginHorizontal();
    }

    @Override // android.widget.FrameLayout
    public k getItemActiveIndicatorShapeAppearance() {
        return this.b.getItemActiveIndicatorShapeAppearance();
    }

    @Override // android.widget.FrameLayout
    public int getItemActiveIndicatorWidth() {
        return this.b.getItemActiveIndicatorWidth();
    }

    @Override // android.widget.FrameLayout
    public Drawable getItemBackground() {
        return this.b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.b.getItemBackgroundRes();
    }

    @Override // android.widget.FrameLayout
    public int getItemIconSize() {
        return this.b.getItemIconSize();
    }

    @Override // android.widget.FrameLayout
    public ColorStateList getItemIconTintList() {
        return this.b.getIconTintList();
    }

    @Override // android.widget.FrameLayout
    public int getItemPaddingBottom() {
        return this.b.getItemPaddingBottom();
    }

    @Override // android.widget.FrameLayout
    public int getItemPaddingTop() {
        return this.b.getItemPaddingTop();
    }

    @Override // android.widget.FrameLayout
    public ColorStateList getItemRippleColor() {
        return this.v;
    }

    @Override // android.widget.FrameLayout
    public int getItemTextAppearanceActive() {
        return this.b.getItemTextAppearanceActive();
    }

    @Override // android.widget.FrameLayout
    public int getItemTextAppearanceInactive() {
        return this.b.getItemTextAppearanceInactive();
    }

    @Override // android.widget.FrameLayout
    public ColorStateList getItemTextColor() {
        return this.b.getItemTextColor();
    }

    @Override // android.widget.FrameLayout
    public int getLabelVisibilityMode() {
        return this.b.getLabelVisibilityMode();
    }

    @Override // android.widget.FrameLayout
    public abstract int getMaxItemCount();

    @Override // android.widget.FrameLayout
    public Menu getMenu() {
        return this.a;
    }

    @Override // android.widget.FrameLayout
    public n getMenuView() {
        return this.b;
    }

    @Override // android.widget.FrameLayout
    public f.c.a.e.y.d getPresenter() {
        return this.c;
    }

    @Override // android.widget.FrameLayout
    public int getSelectedItemId() {
        return this.b.getSelectedItemId();
    }

    @Override // android.widget.FrameLayout
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.widget.FrameLayout
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof e.d) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((e.d)parcelable.a());
        this.a.S(parcelable.c);
    }

    @Override // android.widget.FrameLayout
    protected Parcelable onSaveInstanceState() {
        e.d dVar = new e.d(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        dVar.c = bundle;
        this.a.U(bundle);
        return dVar;
    }

    @Override // android.widget.FrameLayout
    public void setElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f);
        }
        h.d(this, f);
    }

    @Override // android.widget.FrameLayout
    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.b.setItemActiveIndicatorColor(colorStateList);
    }

    @Override // android.widget.FrameLayout
    public void setItemActiveIndicatorEnabled(boolean z) {
        this.b.setItemActiveIndicatorEnabled(z);
    }

    @Override // android.widget.FrameLayout
    public void setItemActiveIndicatorHeight(int i) {
        this.b.setItemActiveIndicatorHeight(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.b.setItemActiveIndicatorMarginHorizontal(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemActiveIndicatorShapeAppearance(k k) {
        this.b.setItemActiveIndicatorShapeAppearance(k);
    }

    @Override // android.widget.FrameLayout
    public void setItemActiveIndicatorWidth(int i) {
        this.b.setItemActiveIndicatorWidth(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemBackground(Drawable drawable) {
        this.b.setItemBackground(drawable);
        this.v = 0;
    }

    @Override // android.widget.FrameLayout
    public void setItemBackgroundResource(int i) {
        this.b.setItemBackgroundRes(i);
        this.v = 0;
    }

    @Override // android.widget.FrameLayout
    public void setItemIconSize(int i) {
        this.b.setItemIconSize(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemIconSizeRes(int i) {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    @Override // android.widget.FrameLayout
    public void setItemIconTintList(ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    @Override // android.widget.FrameLayout
    public void setItemPaddingBottom(int i) {
        this.b.setItemPaddingBottom(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemPaddingTop(int i) {
        this.b.setItemPaddingTop(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemRippleColor(ColorStateList colorStateList) {
        Object list;
        int i;
        int rippleDrawable;
        Object obj4;
        i = 0;
        if (this.v == colorStateList && colorStateList == null && this.b.getItemBackground() != null) {
            if (colorStateList == null) {
                if (this.b.getItemBackground() != null) {
                    this.b.setItemBackground(i);
                }
            }
        }
        this.v = colorStateList;
        if (colorStateList == null) {
            this.b.setItemBackground(i);
        } else {
            obj4 = b.a(colorStateList);
            if (Build.VERSION.SDK_INT >= 21) {
                rippleDrawable = new RippleDrawable(obj4, i, i);
                this.b.setItemBackground(rippleDrawable);
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(925353388);
                list = a.r(gradientDrawable);
                a.o(list, obj4);
                this.b.setItemBackground(list);
            }
        }
    }

    @Override // android.widget.FrameLayout
    public void setItemTextAppearanceActive(int i) {
        this.b.setItemTextAppearanceActive(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemTextAppearanceInactive(int i) {
        this.b.setItemTextAppearanceInactive(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemTextColor(ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    @Override // android.widget.FrameLayout
    public void setLabelVisibilityMode(int i) {
        int labelVisibilityMode;
        int obj2;
        if (this.b.getLabelVisibilityMode() != i) {
            this.b.setLabelVisibilityMode(i);
            this.c.d(false);
        }
    }

    @Override // android.widget.FrameLayout
    public void setOnItemReselectedListener(f.c.a.e.y.e.b e$b) {
        this.y = b;
    }

    @Override // android.widget.FrameLayout
    public void setOnItemSelectedListener(f.c.a.e.y.e.c e$c) {
        this.x = c;
    }

    @Override // android.widget.FrameLayout
    public void setSelectedItemId(int i) {
        f.c.a.e.y.b bVar;
        f.c.a.e.y.d dVar;
        int i2;
        final MenuItem obj4 = this.a.findItem(i);
        if (obj4 != null && !this.a.O(obj4, this.c, 0)) {
            if (!this.a.O(obj4, this.c, 0)) {
                obj4.setChecked(true);
            }
        }
    }
}
