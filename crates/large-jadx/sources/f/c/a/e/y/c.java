package f.c.a.e.y;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import com.google.android.material.internal.j;
import d.h.k.f;
import d.h.k.h;
import d.h.l.e0.c;
import d.h.l.e0.c.b;
import d.h.l.u;
import d.u.q;
import d.u.s;
import f.c.a.e.d0.k;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: NavigationBarMenuView.java */
/* loaded from: classes2.dex */
public abstract class c extends ViewGroup implements n {

    private static final int[] U;
    private static final int[] V;
    private ColorStateList A;
    private int B;
    private ColorStateList C;
    private final ColorStateList D;
    private int E;
    private int F;
    private Drawable G;
    private int H;
    private SparseArray<f.c.a.e.n.a> I = new SparseArray<>(5);
    private int J = -1;
    private int K = -1;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private k P;
    private boolean Q = false;
    private ColorStateList R;
    private d S;
    private androidx.appcompat.view.menu.g T;
    private final s a = new b();
    private final View.OnClickListener b = new c$a();
    private final f<a> c = new h<>(5);
    private final SparseArray<View.OnTouchListener> v = new SparseArray<>(5);
    private int w;
    private a[] x;
    private int y = 0;
    private int z = 0;

    class a implements View.OnClickListener {

        final /* synthetic */ c a;
        a() {
            this.a = cVar;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            final i itemData = view.getItemData();
            if (!this.a.T.O(itemData, this.a.S, 0)) {
                boolean z = true;
                itemData.setChecked(z);
            }
        }
    }
    static {
        int i = 1;
        int[] iArr2 = new int[i];
        final int i4 = 0;
        iArr2[i4] = 0x010100a0 /* Unknown resource */;
        c.U = iArr2;
        int[] iArr = new int[i];
        iArr[i4] = -16842910;
        c.V = iArr;
    }

    public c(Context context) throws android.content.res.Resources.NotFoundException {
        super(context);
        int i = 5;
        h hVar = new h(i);
        SparseArray sparseArray2 = new SparseArray(i);
        SparseArray sparseArray = new SparseArray(i);
        this.D = e(16842808);
        d.u.b bVar = new b();
        bVar.u0(0);
        int integer = getResources().getInteger(g.b);
        bVar.r0((long)(a.d(getContext(), b.I, integer)));
        bVar.s0(a.e(getContext(), b.J, a.b));
        bVar.k0(new j());
        f.c.a.e.y.c.a aVar = new c.a(this);
        u.v0(this, 1);
    }

    static /* synthetic */ d a(c cVar) {
        return cVar.S;
    }

    static /* synthetic */ androidx.appcompat.view.menu.g c(c cVar) {
        return cVar.T;
    }

    private Drawable f() {
        if (this.P != null && this.R != null) {
            f.c.a.e.d0.g gVar = new g(this.P);
            gVar.Z(this.R);
            return gVar;
        }
        return null;
    }

    private a getNewItem() {
        Object obj;
        if ((a)this.c.b() == null) {
            f.c.a.e.y.a aVar = g(getContext());
        }
        return obj;
    }

    private void j() {
        int keyAt = 0;
        int size;
        final HashSet hashSet = new HashSet();
        keyAt = 0;
        while (keyAt < this.T.size()) {
            hashSet.add(Integer.valueOf(this.T.getItem(keyAt).getItemId()));
            keyAt = keyAt + 1;
        }
        while (keyAt < this.I.size()) {
            keyAt = this.I.keyAt(keyAt);
            keyAt = keyAt + 1;
        }
    }

    private void setBadgeIfNeeded(a aVar) {
        int id = aVar.getId();
        if (!i(id)) {
            return;
        }
        Object obj = this.I.get(id);
        if (obj != null) {
            aVar.setBadge(obj);
        }
    }

    @Override // android.view.ViewGroup
    public void b(androidx.appcompat.view.menu.g gVar) {
        this.T = gVar;
    }

    @Override // android.view.ViewGroup
    public void d() {
        int i;
        Object obj;
        f fVar;
        removeAllViews();
        i = 0;
        if (this.x != null) {
            length = objArr.length;
            for (f.c.a.e.y.a aVar : objArr) {
            }
        }
        if (this.T.size() == 0) {
            this.y = i;
            this.z = i;
            this.x = null;
            return;
        }
        j();
        this.x = new a[this.T.size()];
        boolean z2 = true;
        while (this.T < this.T.size()) {
            this.S.k(z2);
            this.T.getItem(i).setCheckable(z2);
            this.S.k(false);
            f.c.a.e.y.a newItem = getNewItem();
            this.x[i] = newItem;
            newItem.setIconTintList(this.A);
            newItem.setIconSize(this.B);
            newItem.setTextColor(this.D);
            newItem.setTextAppearanceInactive(this.E);
            newItem.setTextAppearanceActive(this.F);
            newItem.setTextColor(this.C);
            int i17 = -1;
            newItem.setActiveIndicatorWidth(this.M);
            newItem.setActiveIndicatorHeight(this.N);
            newItem.setActiveIndicatorMarginHorizontal(this.O);
            newItem.setActiveIndicatorDrawable(f());
            newItem.setActiveIndicatorResizeable(this.Q);
            newItem.setActiveIndicatorEnabled(this.L);
            newItem.setShifting(h(this.w, this.T.G().size()));
            newItem.setLabelVisibilityMode(this.w);
            MenuItem item3 = this.T.getItem(i);
            newItem.h(item3, i);
            newItem.setItemPosition(i);
            int itemId = item3.getItemId();
            newItem.setOnTouchListener((View.OnTouchListener)this.v.get(itemId));
            newItem.setOnClickListener(this.b);
            setBadgeIfNeeded(newItem);
            addView(newItem);
            i = i + 1;
        }
        int min = Math.min(this.T.size() - z2, this.z);
        this.z = min;
        this.T.getItem(min).setChecked(z2);
    }

    @Override // android.view.ViewGroup
    public ColorStateList e(int i) {
        TypedValue typedValue = new TypedValue();
        final boolean z = true;
        int i2 = 0;
        if (!getContext().getTheme().resolveAttribute(i, typedValue, z)) {
            return null;
        }
        ColorStateList colorStateList2 = a.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(a.x, typedValue, z)) {
            return i2;
        }
        int defaultColor = colorStateList2.getDefaultColor();
        int i4 = 3;
        final int[][] iArr2 = new int[i4];
        final int[] iArr3 = c.V;
        final int i5 = 0;
        iArr2[i5] = iArr3;
        iArr2[z] = c.U;
        final int i6 = 2;
        iArr2[i6] = ViewGroup.EMPTY_STATE_SET;
        int[] iArr = new int[i4];
        iArr[i5] = colorStateList2.getColorForState(iArr3, defaultColor);
        iArr[z] = typedValue.data;
        iArr[i6] = defaultColor;
        return new ColorStateList(iArr2, iArr);
    }

    @Override // android.view.ViewGroup
    SparseArray<f.c.a.e.n.a> getBadgeDrawables() {
        return this.I;
    }

    @Override // android.view.ViewGroup
    public ColorStateList getIconTintList() {
        return this.A;
    }

    @Override // android.view.ViewGroup
    public ColorStateList getItemActiveIndicatorColor() {
        return this.R;
    }

    @Override // android.view.ViewGroup
    public boolean getItemActiveIndicatorEnabled() {
        return this.L;
    }

    @Override // android.view.ViewGroup
    public int getItemActiveIndicatorHeight() {
        return this.N;
    }

    @Override // android.view.ViewGroup
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.O;
    }

    @Override // android.view.ViewGroup
    public k getItemActiveIndicatorShapeAppearance() {
        return this.P;
    }

    @Override // android.view.ViewGroup
    public int getItemActiveIndicatorWidth() {
        return this.M;
    }

    @Override // android.view.ViewGroup
    public Drawable getItemBackground() {
        if (this.x != null) {
            length = objArr.length;
            if (objArr.length > 0) {
                return objArr[0].getBackground();
            }
        }
        return this.G;
    }

    @Deprecated
    @Override // android.view.ViewGroup
    public int getItemBackgroundRes() {
        return this.H;
    }

    @Override // android.view.ViewGroup
    public int getItemIconSize() {
        return this.B;
    }

    @Override // android.view.ViewGroup
    public int getItemPaddingBottom() {
        return this.K;
    }

    @Override // android.view.ViewGroup
    public int getItemPaddingTop() {
        return this.J;
    }

    @Override // android.view.ViewGroup
    public int getItemTextAppearanceActive() {
        return this.F;
    }

    @Override // android.view.ViewGroup
    public int getItemTextAppearanceInactive() {
        return this.E;
    }

    @Override // android.view.ViewGroup
    public ColorStateList getItemTextColor() {
        return this.C;
    }

    @Override // android.view.ViewGroup
    public int getLabelVisibilityMode() {
        return this.w;
    }

    @Override // android.view.ViewGroup
    protected androidx.appcompat.view.menu.g getMenu() {
        return this.T;
    }

    @Override // android.view.ViewGroup
    public int getSelectedItemId() {
        return this.y;
    }

    @Override // android.view.ViewGroup
    protected int getSelectedItemPosition() {
        return this.z;
    }

    @Override // android.view.ViewGroup
    void k(int i) {
        int i2 = 0;
        MenuItem item;
        int itemId;
        i2 = 0;
        while (i2 < this.T.size()) {
            item = this.T.getItem(i2);
            if (i == item.getItemId()) {
                this.y = i;
                this.z = i2;
                boolean z = true;
                item.setChecked(z);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void l() {
        int i2;
        MenuItem item;
        f.c.a.e.y.d dVar;
        boolean checked;
    }

    @Override // android.view.ViewGroup
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        final int i = 1;
        c.y0(accessibilityNodeInfo).Z(c.b.a(i, this.T.G().size(), false, i));
    }

    @Override // android.view.ViewGroup
    void setBadgeDrawables(SparseArray<f.c.a.e.n.a> sparseArray) {
        int i = 0;
        f.c.a.e.y.a aVar;
        Object obj;
        this.I = sparseArray;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setBadge((a)sparseArray.get(aVar.getId()));
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setIconTintList(ColorStateList list) {
        int i = 0;
        f.c.a.e.y.a aVar;
        this.A = list;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setIconTintList(list);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorColor(ColorStateList list) {
        int i = 0;
        f.c.a.e.y.a aVar;
        Drawable drawable;
        this.R = list;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setActiveIndicatorDrawable(f());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorEnabled(boolean z) {
        int i = 0;
        f.c.a.e.y.a aVar;
        this.L = z;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setActiveIndicatorEnabled(z);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorHeight(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        this.N = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setActiveIndicatorHeight(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorMarginHorizontal(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        this.O = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setActiveIndicatorMarginHorizontal(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected void setItemActiveIndicatorResizeable(boolean z) {
        int i = 0;
        f.c.a.e.y.a aVar;
        this.Q = z;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setActiveIndicatorResizeable(z);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorShapeAppearance(k kVar) {
        int i = 0;
        f.c.a.e.y.a aVar;
        Drawable drawable;
        this.P = kVar;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setActiveIndicatorDrawable(f());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorWidth(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        this.M = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setActiveIndicatorWidth(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemBackground(Drawable drawable) {
        int i = 0;
        f.c.a.e.y.a aVar;
        this.G = drawable;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemBackgroundRes(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        this.H = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setItemBackground(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemIconSize(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        this.B = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setIconSize(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemPaddingBottom(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        this.K = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setItemPaddingBottom(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemPaddingTop(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        this.J = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setItemPaddingTop(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemTextAppearanceActive(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        ColorStateList colorStateList;
        this.F = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setTextAppearanceActive(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemTextAppearanceInactive(int i) {
        int i2 = 0;
        f.c.a.e.y.a aVar;
        ColorStateList colorStateList;
        this.E = i;
        if (this.x != null) {
            length = objArr.length;
            i2 = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setTextAppearanceInactive(i);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemTextColor(ColorStateList list) {
        int i = 0;
        f.c.a.e.y.a aVar;
        this.C = list;
        if (this.x != null) {
            length = objArr.length;
            i = 0;
            for (f.c.a.e.y.a aVar : objArr) {
                aVar.setTextColor(list);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setLabelVisibilityMode(int i) {
        this.w = i;
    }

    @Override // android.view.ViewGroup
    public void setPresenter(d dVar) {
        this.S = dVar;
    }

    private boolean i(int i) {
        boolean z = true;
        i = i != -1 ? 1 : 0;
        return (i != -1 ? 1 : 0);
    }

    @Override // android.view.ViewGroup
    protected abstract a g(Context context);

    @Override // android.view.ViewGroup
    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.ViewGroup
    protected boolean h(int i, int i2) {
        boolean z = true;
        int i3 = 3;
        int i4 = 1;
        if (i == -1) {
            i3 = 3;
            if (i2 <= 3) {
                int i5 = 0;
            }
        }
        return z;
    }
}
