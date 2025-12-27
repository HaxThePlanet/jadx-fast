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
import androidx.appcompat.view.menu.g.a;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.t0;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.b0.b;
import f.c.a.e.d;
import f.c.a.e.d0.h;
import f.c.a.e.d0.k;
import f.c.a.e.d0.k.b;

/* compiled from: NavigationBarView.java */
/* loaded from: classes2.dex */
public abstract class e extends FrameLayout {

    private final b a = new b();
    private final c b;
    private final d c = new d();
    private ColorStateList v;
    private MenuInflater w;
    private e.c x;
    private e.b y;

    public interface b {
        void a(MenuItem menuItem);
    }

    public interface c {
        boolean a(MenuItem menuItem);
    }

    class a implements g.a {

        final /* synthetic */ e a;
        a() {
            this.a = eVar;
            super();
        }

        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            boolean z = false;
            f.c.a.e.y.e.c cVar;
            z = true;
            if (this.a.y != null && menuItem.getItemId() == this.a.getSelectedItemId()) {
                this.a.y.a(menuItem);
                return true;
            }
            if (this.a.x != null) {
                if (this.a.x.a(menuItem)) {
                    int i = 0;
                }
            }
            return z;
        }

        public void b(androidx.appcompat.view.menu.g gVar) {
        }
    }

    static class d extends d.j.a.a {

        public static final Parcelable.Creator<e.d> CREATOR = new e$d$a<>();
        Bundle c;

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel, java.lang.ClassLoader classLoader) {
            this.c = parcel.readBundle(classLoader);
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.c);
        }

        public d(Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = e.d.class.getClassLoader();
            }
            b(parcel, classLoader);
        }
    }
    public e(Context context, AttributeSet set, int i, int i2) throws android.content.res.Resources.NotFoundException {
        super(a.c(context, set, i, i2), set, i);
        f.c.a.e.y.d dVar = new d();
        final Context context2 = getContext();
        final int[] iArr2 = new int[2];
        final int q32 = l.Q3;
        final int i12 = 0;
        iArr2[i12] = q32;
        final int p32 = l.P3;
        final int i13 = 1;
        iArr2[i13] = p32;
        final t0 t0Var = l.i(context2, set, l.F3, i, i2, iArr2);
        final f.c.a.e.y.b bVar2 = new b(context2, getClass(), getMaxItemCount());
        f.c.a.e.y.c cVar = d(context2);
        this.b = cVar;
        dVar.b(cVar);
        dVar.a(i13);
        cVar.setPresenter(dVar);
        bVar2.b(dVar);
        dVar.i(getContext(), bVar2);
        int l32 = l.L3;
        if (t0Var.s(l32)) {
            cVar.setIconTintList(t0Var.c(l.L3));
        } else {
            cVar.setIconTintList(cVar.e(16842808));
        }
        setItemIconSize(t0Var.f(l.K3, getResources().getDimensionPixelSize(d.g0)));
        if (t0Var.s(l.Q3)) {
            setItemTextAppearanceInactive(t0Var.n(l.Q3, i12));
        }
        if (t0Var.s(l.P3)) {
            setItemTextAppearanceActive(t0Var.n(l.P3, i12));
        }
        i2 = l.R3;
        if (t0Var.s(i2)) {
            setItemTextColor(t0Var.c(l.R3));
        }
        if (getBackground() != null) {
            if (getBackground() instanceof ColorDrawable) {
                u.o0(this, c(context2));
            }
        }
        i5 = l.N3;
        if (t0Var.s(i5)) {
            setItemPaddingTop(t0Var.f(l.N3, i12));
        }
        i6 = l.M3;
        if (t0Var.s(i6)) {
            setItemPaddingBottom(t0Var.f(l.M3, i12));
        }
        i7 = l.H3;
        if (t0Var.s(i7)) {
            setElevation((float)(t0Var.f(l.H3, i12)));
        }
        a.o(getBackground().mutate(), c.b(context2, t0Var, l.G3));
        i = -1;
        setLabelVisibilityMode(t0Var.l(l.S3, i));
        int i19 = t0Var.n(l.J3, i12);
        if (i19 != 0) {
            cVar.setItemBackgroundRes(i19);
        } else {
            setItemRippleColor(c.b(context2, t0Var, l.O3));
        }
        int i8 = t0Var.n(l.I3, i12);
        if (i8 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray styledAttributes = context2.obtainStyledAttributes(i8, l.z3);
            setItemActiveIndicatorWidth(styledAttributes.getDimensionPixelSize(l.B3, i12));
            setItemActiveIndicatorHeight(styledAttributes.getDimensionPixelSize(l.A3, i12));
            setItemActiveIndicatorMarginHorizontal(styledAttributes.getDimensionPixelOffset(l.D3, i12));
            setItemActiveIndicatorColor(c.a(context2, styledAttributes, l.C3));
            setItemActiveIndicatorShapeAppearance(k.b(context2, styledAttributes.getResourceId(l.E3, i12), i12).m());
            styledAttributes.recycle();
        }
        i9 = l.T3;
        if (t0Var.s(i9)) {
            e(t0Var.n(l.T3, i12));
        }
        t0Var.w();
        addView(cVar);
        bVar2.V(new e.a(this));
    }

    static /* synthetic */ e.b a(e eVar) {
        return eVar.y;
    }

    static /* synthetic */ e.c b(e eVar) {
        return eVar.x;
    }

    private f.c.a.e.d0.g c(Context context) {
        final f.c.a.e.d0.g gVar = new g();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            gVar.Z(ColorStateList.valueOf(background.getColor()));
        }
        gVar.O(context);
        return gVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.w == null) {
            this.w = new g(getContext());
        }
        return this.w;
    }

    @Override // android.widget.FrameLayout
    public void e(int i) {
        final boolean z = true;
        this.c.k(z);
        getMenuInflater().inflate(i, this.a);
        this.c.k(false);
        this.c.d(z);
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
    @Override // android.widget.FrameLayout
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
    public Menu getMenu() {
        return this.a;
    }

    @Override // android.widget.FrameLayout
    public n getMenuView() {
        return this.b;
    }

    @Override // android.widget.FrameLayout
    public d getPresenter() {
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
        if (!(parcelable instanceof e.d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(parcelable.a());
        this.a.S(parcelable.c);
    }

    @Override // android.widget.FrameLayout
    protected Parcelable onSaveInstanceState() {
        final f.c.a.e.y.e.d dVar = new e.d(super.onSaveInstanceState());
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
    public void setItemActiveIndicatorColor(ColorStateList list) {
        this.b.setItemActiveIndicatorColor(list);
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
    public void setItemActiveIndicatorShapeAppearance(k kVar) {
        this.b.setItemActiveIndicatorShapeAppearance(kVar);
    }

    @Override // android.widget.FrameLayout
    public void setItemActiveIndicatorWidth(int i) {
        this.b.setItemActiveIndicatorWidth(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemBackground(Drawable drawable) {
        this.b.setItemBackground(drawable);
        this.v = null;
    }

    @Override // android.widget.FrameLayout
    public void setItemBackgroundResource(int i) {
        this.b.setItemBackgroundRes(i);
        this.v = null;
    }

    @Override // android.widget.FrameLayout
    public void setItemIconSize(int i) {
        this.b.setItemIconSize(i);
    }

    @Override // android.widget.FrameLayout
    public void setItemIconSizeRes(int i) throws android.content.res.Resources.NotFoundException {
        setItemIconSize(getResources().getDimensionPixelSize(i));
    }

    @Override // android.widget.FrameLayout
    public void setItemIconTintList(ColorStateList list) {
        this.b.setIconTintList(list);
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
    public void setItemRippleColor(ColorStateList list) {
        Drawable drawable2 = null;
        if (this.v == list) {
            if (list == null) {
                if (this.b.getItemBackground() != null) {
                    this.b.setItemBackground(drawable2);
                }
            }
            return;
        }
        this.v = list;
        if (this.b == null) {
            this.b.setItemBackground(drawable2);
        } else {
            ColorStateList colorStateList2 = b.a(list);
            int i = 21;
            if (Build.VERSION.SDK_INT >= 21) {
                this.b.setItemBackground(new RippleDrawable(colorStateList2, drawable2, drawable2));
            } else {
                GradientDrawable gradientDrawable = new GradientDrawable();
                float f = 0.00001f;
                gradientDrawable.setCornerRadius(f);
                Drawable drawable = a.r(gradientDrawable);
                a.o(drawable, colorStateList2);
                this.b.setItemBackground(drawable);
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
    public void setItemTextColor(ColorStateList list) {
        this.b.setItemTextColor(list);
    }

    @Override // android.widget.FrameLayout
    public void setLabelVisibilityMode(int i) {
        if (this.b.getLabelVisibilityMode() != i) {
            this.b.setLabelVisibilityMode(i);
            this.c.d(false);
        }
    }

    @Override // android.widget.FrameLayout
    public void setOnItemReselectedListener(e.b bVar) {
        this.y = bVar;
    }

    @Override // android.widget.FrameLayout
    public void setOnItemSelectedListener(e.c cVar) {
        this.x = cVar;
    }

    @Override // android.widget.FrameLayout
    public void setSelectedItemId(int i) {
        final MenuItem item = this.a.findItem(i);
        if (item != null) {
            int i2 = 0;
            if (!this.a.O(item, this.c, i2)) {
                item.setChecked(true);
            }
        }
    }

    @Override // android.widget.FrameLayout
    protected abstract c d(Context context);

    @Override // android.widget.FrameLayout
    public abstract int getMaxItemCount();
}
