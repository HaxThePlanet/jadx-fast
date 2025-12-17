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
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import com.google.android.material.internal.j;
import d.a.a;
import d.a.k.a.a;
import d.h.k.f;
import d.h.k.h;
import d.h.l.e0.c;
import d.h.l.e0.c.b;
import d.h.l.u;
import d.u.b;
import d.u.q;
import d.u.s;
import f.c.a.e.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.g;
import f.c.a.e.m.a;
import f.c.a.e.n.a;
import f.c.a.e.x.a;
import java.util.ArrayList;
import java.util.HashSet;

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
    private SparseArray<a> I;
    private int J = -1;
    private int K = -1;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private k P;
    private boolean Q = false;
    private ColorStateList R;
    private f.c.a.e.y.d S;
    private g T;
    private final s a;
    private final View.OnClickListener b;
    private final f<f.c.a.e.y.a> c;
    private final SparseArray<View.OnTouchListener> v;
    private int w;
    private f.c.a.e.y.a[] x;
    private int y = 0;
    private int z = 0;

    class a implements View.OnClickListener {

        final f.c.a.e.y.c a;
        a(f.c.a.e.y.c c) {
            this.a = c;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            boolean z;
            final i obj4 = (a)view.getItemData();
            if (!c.c(this.a).O(obj4, c.a(this.a), 0)) {
                obj4.setChecked(true);
            }
        }
    }
    static {
        int i = 1;
        int[] iArr2 = new int[i];
        final int i4 = 0;
        iArr2[i4] = 16842912;
        c.U = iArr2;
        int[] iArr = new int[i];
        iArr[i4] = -16842910;
        c.V = iArr;
    }

    public c(Context context) {
        super(context);
        int i = 5;
        h obj5 = new h(i);
        this.c = obj5;
        obj5 = new SparseArray(i);
        this.v = obj5;
        SparseArray sparseArray = new SparseArray(i);
        this.I = sparseArray;
        int i2 = -1;
        this.D = e(16842808);
        b bVar = new b();
        this.a = bVar;
        bVar.u0(0);
        int integer = getResources().getInteger(g.b);
        bVar.r0((long)obj5);
        bVar.s0(a.e(getContext(), b.J, a.b));
        obj5 = new j();
        bVar.k0(obj5);
        obj5 = new c.a(this);
        this.b = obj5;
        u.v0(this, 1);
    }

    static f.c.a.e.y.d a(f.c.a.e.y.c c) {
        return c.S;
    }

    static g c(f.c.a.e.y.c c) {
        return c.T;
    }

    private Drawable f() {
        Object kVar;
        if (this.P != null && this.R != null) {
            if (this.R != null) {
                g gVar = new g(this.P);
                gVar.Z(this.R);
                return gVar;
            }
        }
        return null;
    }

    private f.c.a.e.y.a getNewItem() {
        Object obj;
        if ((a)this.c.b() == null) {
            obj = g(getContext());
        }
        return obj;
    }

    private boolean i(int i) {
        int obj2;
        obj2 = i != -1 ? 1 : 0;
        return obj2;
    }

    private void j() {
        int i;
        int keyAt;
        Integer valueOf;
        int contains;
        HashSet hashSet = new HashSet();
        keyAt = i;
        while (keyAt < this.T.size()) {
            hashSet.add(Integer.valueOf(this.T.getItem(keyAt).getItemId()));
            keyAt++;
        }
        while (i < this.I.size()) {
            keyAt = this.I.keyAt(i);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
            }
            i++;
            this.I.delete(keyAt);
        }
    }

    private void setBadgeIfNeeded(f.c.a.e.y.a a) {
        int id = a.getId();
        if (!i(id)) {
        }
        Object obj = this.I.get(id);
        if ((a)obj != null) {
            a.setBadge((a)obj);
        }
    }

    @Override // android.view.ViewGroup
    public void b(g g) {
        this.T = g;
    }

    @Override // android.view.ViewGroup
    public void d() {
        int length;
        int i;
        int newItem;
        f.c.a.e.y.a itemId;
        Drawable drawable;
        f fVar;
        removeAllViews();
        f.c.a.e.y.a[] objArr = this.x;
        int i6 = 0;
        if (objArr != null) {
            newItem = i6;
            while (newItem < objArr.length) {
                itemId = objArr[newItem];
                if (itemId != null) {
                }
                newItem++;
                this.c.a(itemId);
                itemId.f();
            }
        }
        if (this.T.size() == 0) {
            this.y = i6;
            this.z = i6;
            this.x = 0;
        }
        j();
        this.x = new a[this.T.size()];
        i = i6;
        int i8 = 1;
        while (i < this.T.size()) {
            this.S.k(i8);
            this.T.getItem(i).setCheckable(i8);
            this.S.k(i6);
            newItem = getNewItem();
            this.x[i] = newItem;
            newItem.setIconTintList(this.A);
            newItem.setIconSize(this.B);
            newItem.setTextColor(this.D);
            newItem.setTextAppearanceInactive(this.E);
            newItem.setTextAppearanceActive(this.F);
            newItem.setTextColor(this.C);
            int i12 = this.J;
            int i18 = -1;
            if (i12 != i18) {
            }
            int i13 = this.K;
            if (i13 != i18) {
            }
            newItem.setActiveIndicatorWidth(this.M);
            newItem.setActiveIndicatorHeight(this.N);
            newItem.setActiveIndicatorMarginHorizontal(this.O);
            newItem.setActiveIndicatorDrawable(f());
            newItem.setActiveIndicatorResizeable(this.Q);
            newItem.setActiveIndicatorEnabled(this.L);
            drawable = this.G;
            if (drawable != null) {
            } else {
            }
            newItem.setItemBackground(this.H);
            newItem.setShifting(h(this.w, this.T.G().size()));
            newItem.setLabelVisibilityMode(this.w);
            MenuItem item3 = this.T.getItem(i);
            newItem.h((i)item3, i6);
            newItem.setItemPosition(i);
            itemId = item3.getItemId();
            newItem.setOnTouchListener((View.OnTouchListener)this.v.get(itemId));
            newItem.setOnClickListener(this.b);
            fVar = this.y;
            if (fVar != 0 && itemId == fVar) {
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
            i++;
            i8 = 1;
            if (itemId == fVar) {
            }
            this.z = i;
            newItem.setItemBackground(drawable);
            newItem.setItemPaddingBottom(i13);
            newItem.setItemPaddingTop(i12);
        }
        int i5 = Math.min(size3 -= i8, this.z);
        this.z = i5;
        this.T.getItem(i5).setChecked(i8);
    }

    @Override // android.view.ViewGroup
    public ColorStateList e(int i) {
        TypedValue typedValue = new TypedValue();
        final int i3 = 1;
        int i2 = 0;
        if (!getContext().getTheme().resolveAttribute(i, typedValue, i3)) {
            return i2;
        }
        ColorStateList obj11 = a.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(a.x, typedValue, i3)) {
            return i2;
        }
        int defaultColor = obj11.getDefaultColor();
        int i5 = 3;
        final int[][] iArr2 = new int[i5];
        final int[] iArr3 = c.V;
        final int i6 = 0;
        iArr2[i6] = iArr3;
        iArr2[i3] = c.U;
        final int i7 = 2;
        iArr2[i7] = ViewGroup.EMPTY_STATE_SET;
        int[] iArr = new int[i5];
        iArr[i6] = obj11.getColorForState(iArr3, defaultColor);
        iArr[i3] = typedValue.data;
        iArr[i7] = defaultColor;
        ColorStateList colorStateList = new ColorStateList(iArr2, iArr);
        return colorStateList;
    }

    @Override // android.view.ViewGroup
    protected abstract f.c.a.e.y.a g(Context context);

    SparseArray<a> getBadgeDrawables() {
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
        int length;
        f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null && objArr.length > 0) {
            if (objArr.length > 0) {
                return objArr[0].getBackground();
            }
        }
        return this.G;
    }

    @Deprecated
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
    protected g getMenu() {
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
    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.ViewGroup
    protected boolean h(int i, int i2) {
        int i3;
        int obj4;
        i3 = 1;
        if (i == -1) {
            if (i2 > 3) {
            } else {
                i3 = i4;
            }
        } else {
            if (i == 0) {
            } else {
            }
        }
        return i3;
    }

    @Override // android.view.ViewGroup
    void k(int i) {
        int i2;
        MenuItem item;
        int itemId;
        int obj5;
        i2 = 0;
        while (i2 < this.T.size()) {
            item = this.T.getItem(i2);
            if (i == item.getItemId()) {
                break;
            } else {
            }
            i2++;
        }
    }

    @Override // android.view.ViewGroup
    public void l() {
        g size;
        int i3;
        boolean objArr;
        int i4;
        int i;
        int i2;
        MenuItem itemId;
        boolean checked;
        size = this.T;
        if (size != null) {
            if (this.x == null) {
            } else {
                size = size.size();
                if (size != objArr2.length) {
                    d();
                }
                i4 = 0;
                i = i4;
                while (i < size) {
                    itemId = this.T.getItem(i);
                    if (itemId.isChecked()) {
                    }
                    i++;
                    this.y = itemId.getItemId();
                    this.z = i;
                }
                if (this.y != this.y) {
                    q.a(this, this.a);
                }
                i2 = i4;
                while (i2 < size) {
                    this.S.k(true);
                    this.x[i2].setLabelVisibilityMode(this.w);
                    this.x[i2].setShifting(h(this.w, this.T.G().size()));
                    this.x[i2].h((i)this.T.getItem(i2), i4);
                    this.S.k(i4);
                    i2++;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        final int i = 1;
        c.y0(accessibilityNodeInfo).Z(c.b.a(i, this.T.G().size(), false, i));
    }

    void setBadgeDrawables(SparseArray<a> sparseArray) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        Object obj;
        this.I = sparseArray;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i = 0;
            while (i < objArr.length) {
                aVar = objArr[i];
                aVar.setBadge((a)sparseArray.get(aVar.getId()));
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setIconTintList(ColorStateList colorStateList) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        this.A = colorStateList;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i = 0;
            while (i < objArr.length) {
                objArr[i].setIconTintList(colorStateList);
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        Drawable drawable;
        this.R = colorStateList;
        final f.c.a.e.y.a[] obj5 = this.x;
        if (obj5 != null) {
            i = 0;
            while (i < obj5.length) {
                obj5[i].setActiveIndicatorDrawable(f());
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorEnabled(boolean z) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        this.L = z;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i = 0;
            while (i < objArr.length) {
                objArr[i].setActiveIndicatorEnabled(z);
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorHeight(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        this.N = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                objArr[i2].setActiveIndicatorHeight(i);
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorMarginHorizontal(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        this.O = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                objArr[i2].setActiveIndicatorMarginHorizontal(i);
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    protected void setItemActiveIndicatorResizeable(boolean z) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        this.Q = z;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i = 0;
            while (i < objArr.length) {
                objArr[i].setActiveIndicatorResizeable(z);
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorShapeAppearance(k k) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        Drawable drawable;
        this.P = k;
        final f.c.a.e.y.a[] obj5 = this.x;
        if (obj5 != null) {
            i = 0;
            while (i < obj5.length) {
                obj5[i].setActiveIndicatorDrawable(f());
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemActiveIndicatorWidth(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        this.M = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                objArr[i2].setActiveIndicatorWidth(i);
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemBackground(Drawable drawable) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        this.G = drawable;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i = 0;
            while (i < objArr.length) {
                objArr[i].setItemBackground(drawable);
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemBackgroundRes(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        this.H = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                objArr[i2].setItemBackground(i);
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemIconSize(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        this.B = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                objArr[i2].setIconSize(i);
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemPaddingBottom(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        this.K = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                objArr[i2].setItemPaddingBottom(i);
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemPaddingTop(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        this.J = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                objArr[i2].setItemPaddingTop(i);
                i2++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemTextAppearanceActive(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        ColorStateList list;
        this.F = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                aVar = objArr[i2];
                aVar.setTextAppearanceActive(i);
                list = this.C;
                if (list != null) {
                }
                i2++;
                aVar.setTextColor(list);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemTextAppearanceInactive(int i) {
        int length;
        int i2;
        f.c.a.e.y.a aVar;
        ColorStateList list;
        this.E = i;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i2 = 0;
            while (i2 < objArr.length) {
                aVar = objArr[i2];
                aVar.setTextAppearanceInactive(i);
                list = this.C;
                if (list != null) {
                }
                i2++;
                aVar.setTextColor(list);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setItemTextColor(ColorStateList colorStateList) {
        int length;
        int i;
        f.c.a.e.y.a aVar;
        this.C = colorStateList;
        final f.c.a.e.y.a[] objArr = this.x;
        if (objArr != null) {
            i = 0;
            while (i < objArr.length) {
                objArr[i].setTextColor(colorStateList);
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void setLabelVisibilityMode(int i) {
        this.w = i;
    }

    @Override // android.view.ViewGroup
    public void setPresenter(f.c.a.e.y.d d) {
        this.S = d;
    }
}
