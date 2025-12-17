package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.content.a;
import d.h.g.a.a;
import d.h.l.b;
import d.h.l.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class g implements a {

    private static final int[] A;
    private final Context a;
    private final Resources b;
    private boolean c;
    private boolean d;
    private androidx.appcompat.view.menu.g.a e;
    private ArrayList<androidx.appcompat.view.menu.i> f;
    private ArrayList<androidx.appcompat.view.menu.i> g;
    private boolean h = true;
    private ArrayList<androidx.appcompat.view.menu.i> i;
    private ArrayList<androidx.appcompat.view.menu.i> j;
    private boolean k = true;
    private int l = 0;
    private ContextMenu.ContextMenuInfo m;
    java.lang.CharSequence n;
    Drawable o;
    View p;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private ArrayList<androidx.appcompat.view.menu.i> v;
    private CopyOnWriteArrayList<WeakReference<androidx.appcompat.view.menu.m>> w;
    private androidx.appcompat.view.menu.i x;
    private boolean y = false;
    private boolean z;

    public interface a {
        public abstract boolean a(androidx.appcompat.view.menu.g g, MenuItem menuItem2);

        public abstract void b(androidx.appcompat.view.menu.g g);
    }

    public interface b {
        public abstract boolean a(androidx.appcompat.view.menu.i i);
    }
    static {
        int[] iArr = new int[6];
        iArr = new int[]{1, 4, 5, 3, 2, 0};
        g.A = iArr;
    }

    public g(Context context) {
        super();
        int i = 0;
        ArrayList arrayList3 = new ArrayList();
        this.v = arrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.w = copyOnWriteArrayList;
        this.a = context;
        this.b = context.getResources();
        ArrayList obj3 = new ArrayList();
        this.f = obj3;
        obj3 = new ArrayList();
        this.g = obj3;
        ArrayList arrayList = new ArrayList();
        this.i = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.j = arrayList2;
        f0(true);
    }

    private static int D(int i) {
        int[] iArr;
        int length;
        i3 >>= 16;
        if (i4 < 0) {
        } else {
            iArr = g.A;
            if (i4 >= iArr.length) {
            } else {
                return obj3 |= i6;
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("order does not contain a valid category.");
        throw obj3;
    }

    private void P(int i, boolean z2) {
        ArrayList size;
        int obj2;
        if (i >= 0) {
            if (i >= this.f.size()) {
            } else {
                this.f.remove(i);
                if (z2) {
                    M(true);
                }
            }
        }
    }

    private void a0(int i, java.lang.CharSequence charSequence2, int i3, Drawable drawable4, View view5) {
        Drawable obj3;
        final int i2 = 0;
        if (view5 != null) {
            this.p = view5;
            this.n = i2;
            this.o = i2;
        } else {
            if (i > 0) {
                this.n = E().getText(i);
            } else {
                if (charSequence2 != null) {
                    this.n = charSequence2;
                }
            }
            if (i3 > 0) {
                this.o = a.f(w(), i3);
            } else {
                if (drawable4 != null) {
                    this.o = drawable4;
                }
            }
            this.p = i2;
        }
        M(false);
    }

    private void f0(boolean z) {
        int i;
        Context context;
        boolean obj3;
        if (z != 0 && obj3.keyboard != 1 && v.e(ViewConfiguration.get(this.a), this.a)) {
            if (obj3.keyboard != 1) {
                if (v.e(ViewConfiguration.get(this.a), this.a)) {
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        this.d = i;
    }

    private androidx.appcompat.view.menu.i g(int i, int i2, int i3, int i4, java.lang.CharSequence charSequence5, int i6) {
        super(this, i, i2, i3, i4, charSequence5, i6);
        return iVar2;
    }

    private void i(boolean z) {
        Object next;
        Object obj;
        if (this.w.isEmpty()) {
        }
        h0();
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = (WeakReference)next.get();
            if ((m)obj == null) {
            } else {
            }
            (m)obj.d(z);
            this.w.remove(next);
        }
        g0();
    }

    private void j(Bundle bundle) {
        String iterator;
        boolean next;
        Object obj;
        final SparseArray obj4 = bundle.getSparseParcelableArray("android:menu:presenters");
        if (obj4 != null) {
            if (this.w.isEmpty()) {
            } else {
                iterator = this.w.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    obj = (WeakReference)next.get();
                    if ((m)obj == null) {
                    } else {
                    }
                    next = (m)obj.getId();
                    next = obj4.get(next);
                    if (next > 0 && (Parcelable)next != null) {
                    }
                    next = obj4.get(next);
                    if ((Parcelable)(Parcelable)next != null) {
                    }
                    obj.j((Parcelable)(Parcelable)next);
                    this.w.remove(next);
                }
            }
        }
    }

    private void k(Bundle bundle) {
        int next;
        Object obj;
        if (this.w.isEmpty()) {
        }
        SparseArray sparseArray = new SparseArray();
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = (WeakReference)next.get();
            if ((m)obj == null) {
            } else {
            }
            next = (m)obj.getId();
            obj = obj.m();
            if (next > 0 && obj != null) {
            }
            obj = obj.m();
            if (obj != null) {
            }
            sparseArray.put(next, obj);
            this.w.remove(next);
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    private boolean l(androidx.appcompat.view.menu.r r, androidx.appcompat.view.menu.m m2) {
        boolean empty;
        int i;
        Object obj;
        if (this.w.isEmpty()) {
            return 0;
        }
        if (m2 != null) {
            i = m2.l(r);
        }
        Iterator obj5 = this.w.iterator();
        while (obj5.hasNext()) {
            empty = obj5.next();
            obj = (WeakReference)empty.get();
            if ((m)obj == null) {
            } else {
            }
            if (i == 0) {
            }
            i = empty;
            this.w.remove(empty);
        }
        return i;
    }

    private static int p(ArrayList<androidx.appcompat.view.menu.i> arrayList, int i2) {
        int i;
        int i3;
        size--;
        while (i >= 0) {
            i--;
        }
        return 0;
    }

    @Override // d.h.g.a.a
    public View A() {
        return this.p;
    }

    public ArrayList<androidx.appcompat.view.menu.i> B() {
        t();
        return this.j;
    }

    @Override // d.h.g.a.a
    boolean C() {
        return this.t;
    }

    @Override // d.h.g.a.a
    Resources E() {
        return this.b;
    }

    @Override // d.h.g.a.a
    public androidx.appcompat.view.menu.g F() {
        return this;
    }

    public ArrayList<androidx.appcompat.view.menu.i> G() {
        int i;
        Object obj;
        boolean visible;
        if (!this.h) {
            return this.g;
        }
        this.g.clear();
        final int i3 = 0;
        i = i3;
        while (i < this.f.size()) {
            obj = this.f.get(i);
            if ((i)obj.isVisible()) {
            }
            i++;
            this.g.add(obj);
        }
        this.h = i3;
        this.k = true;
        return this.g;
    }

    @Override // d.h.g.a.a
    public boolean H() {
        return this.y;
    }

    @Override // d.h.g.a.a
    boolean I() {
        return this.c;
    }

    @Override // d.h.g.a.a
    public boolean J() {
        return this.d;
    }

    @Override // d.h.g.a.a
    void K(androidx.appcompat.view.menu.i i) {
        final int obj1 = 1;
        this.k = obj1;
        M(obj1);
    }

    @Override // d.h.g.a.a
    void L(androidx.appcompat.view.menu.i i) {
        final int obj1 = 1;
        this.h = obj1;
        M(obj1);
    }

    @Override // d.h.g.a.a
    public void M(boolean z) {
        final int i = 1;
        if (!this.q) {
            if (z) {
                this.h = i;
                this.k = i;
            }
            i(z);
        } else {
            this.r = i;
            if (z) {
                this.s = i;
            }
        }
    }

    @Override // d.h.g.a.a
    public boolean N(MenuItem menuItem, int i2) {
        return O(menuItem, 0, i2);
    }

    @Override // d.h.g.a.a
    public boolean O(MenuItem menuItem, androidx.appcompat.view.menu.m m2, int i3) {
        int i;
        boolean z2;
        boolean enabled;
        boolean z;
        int i2;
        boolean subMenu;
        int obj7;
        int obj9;
        i = 0;
        if ((i)menuItem != null) {
            if (!(i)menuItem.isEnabled()) {
            } else {
                z2 = menuItem.k();
                final b bVar = menuItem.b();
                final int i4 = 1;
                if (bVar != null && bVar.a()) {
                    i2 = bVar.a() ? i4 : i;
                } else {
                }
                if (menuItem.j()) {
                    if (z2 |= obj7 != 0) {
                        e(i4);
                    }
                } else {
                    if (!menuItem.hasSubMenu()) {
                        if (i2 != 0) {
                            if (i3 &= 4 == 0) {
                                e(i);
                            }
                            if (!menuItem.hasSubMenu()) {
                                obj9 = new r(w(), this, menuItem);
                                menuItem.x(obj9);
                            }
                            obj7 = menuItem.getSubMenu();
                            if (i2 != 0) {
                                bVar.f((r)obj7);
                            }
                            if (z2 |= obj7 == 0) {
                                e(i4);
                            }
                        } else {
                            if (i3 & 1 == 0) {
                                e(i4);
                            }
                        }
                    } else {
                    }
                }
            }
            return z2;
        }
        return i;
    }

    @Override // d.h.g.a.a
    public void Q(androidx.appcompat.view.menu.m m) {
        Object next;
        Object obj;
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = (WeakReference)next.get();
            if ((m)obj != null) {
            } else {
            }
            this.w.remove(next);
            if ((m)obj == m) {
            }
        }
    }

    @Override // d.h.g.a.a
    public void R(Bundle bundle) {
        int i;
        MenuItem subMenu;
        boolean subMenu2;
        int i3;
        int i2;
        int obj8;
        if (bundle == null) {
        }
        i = 0;
        while (i < size()) {
            subMenu = getItem(i);
            View actionView = subMenu.getActionView();
            if (actionView != null && actionView.getId() != -1) {
            }
            if (subMenu.hasSubMenu()) {
            }
            i++;
            (r)subMenu.getSubMenu().R(bundle);
            if (actionView.getId() != -1) {
            }
            actionView.restoreHierarchyState(bundle.getSparseParcelableArray(v()));
        }
        obj8 = bundle.getInt("android:menu:expandedactionview");
        obj8 = findItem(obj8);
        if (obj8 > 0 && obj8 != null) {
            obj8 = findItem(obj8);
            if (obj8 != null) {
                obj8.expandActionView();
            }
        }
    }

    @Override // d.h.g.a.a
    public void S(Bundle bundle) {
        j(bundle);
    }

    @Override // d.h.g.a.a
    public void T(Bundle bundle) {
        int size;
        int sparseArray;
        int i2;
        MenuItem subMenu2;
        boolean subMenu;
        View actionViewExpanded;
        int str;
        int i;
        sparseArray = 0;
        i2 = 0;
        while (i2 < size()) {
            subMenu2 = getItem(i2);
            actionViewExpanded = subMenu2.getActionView();
            if (actionViewExpanded != null && actionViewExpanded.getId() != -1 && sparseArray == null) {
            }
            if (subMenu2.hasSubMenu()) {
            }
            i2++;
            (r)subMenu2.getSubMenu().T(bundle);
            if (actionViewExpanded.getId() != -1) {
            }
            if (sparseArray == null) {
            }
            actionViewExpanded.saveHierarchyState(sparseArray);
            if (subMenu2.isActionViewExpanded()) {
            }
            bundle.putInt("android:menu:expandedactionview", subMenu2.getItemId());
            sparseArray = new SparseArray();
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(v(), sparseArray);
        }
    }

    @Override // d.h.g.a.a
    public void U(Bundle bundle) {
        k(bundle);
    }

    @Override // d.h.g.a.a
    public void V(androidx.appcompat.view.menu.g.a g$a) {
        this.e = a;
    }

    @Override // d.h.g.a.a
    public androidx.appcompat.view.menu.g W(int i) {
        this.l = i;
        return this;
    }

    @Override // d.h.g.a.a
    void X(MenuItem menuItem) {
        int i;
        Object obj;
        int groupId;
        h0();
        final int i2 = 0;
        i = i2;
        while (i < this.f.size()) {
            obj = this.f.get(i);
            if ((i)obj.getGroupId() == menuItem.getGroupId()) {
            }
            i++;
            if (!obj.m()) {
            } else {
            }
            if (!obj.isCheckable()) {
            } else {
            }
            if (obj == menuItem) {
            } else {
            }
            groupId = i2;
            obj.s(groupId);
            groupId = 1;
        }
        g0();
    }

    @Override // d.h.g.a.a
    protected androidx.appcompat.view.menu.g Y(int i) {
        this.a0(0, 0, i, 0, 0);
        return this;
    }

    @Override // d.h.g.a.a
    protected androidx.appcompat.view.menu.g Z(Drawable drawable) {
        this.a0(0, 0, 0, drawable, 0);
        return this;
    }

    @Override // d.h.g.a.a
    protected MenuItem a(int i, int i2, int i3, java.lang.CharSequence charSequence4) {
        final int i9 = g.D(i3);
        final androidx.appcompat.view.menu.i obj9 = this.g(i, i2, i3, i9, charSequence4, this.l);
        ContextMenu.ContextMenuInfo obj10 = this.m;
        if (obj10 != null) {
            obj9.v(obj10);
        }
        obj10 = this.f;
        obj10.add(g.p(obj10, i9), obj9);
        M(true);
        return obj9;
    }

    @Override // d.h.g.a.a
    public MenuItem add(int i) {
        int i2 = 0;
        return a(i2, i2, i2, this.b.getString(i));
    }

    @Override // d.h.g.a.a
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.b.getString(i4));
    }

    @Override // d.h.g.a.a
    public MenuItem add(int i, int i2, int i3, java.lang.CharSequence charSequence4) {
        return a(i, i2, i3, charSequence4);
    }

    @Override // d.h.g.a.a
    public MenuItem add(java.lang.CharSequence charSequence) {
        final int i = 0;
        return a(i, i, i, charSequence);
    }

    @Override // d.h.g.a.a
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName4, Intent[] intent5Arr5, Intent intent6, int i7, MenuItem[] menuItem8Arr8) {
        int i4;
        int size;
        MenuItem intent2;
        MenuItem icon2;
        Intent intent;
        Drawable icon;
        String packageName;
        int obj14;
        PackageManager packageManager = this.a.getPackageManager();
        i4 = 0;
        final List obj11 = packageManager.queryIntentActivityOptions(componentName4, intent5Arr5, intent6, i4);
        if (obj11 != null) {
            size = obj11.size();
        } else {
            size = i4;
        }
        if (i7 &= 1 == 0) {
            removeGroup(i);
        }
        while (i4 < size) {
            obj14 = obj11.get(i4);
            int specificIndex = obj14.specificIndex;
            if (specificIndex < 0) {
            } else {
            }
            intent = intent5Arr5[specificIndex];
            Intent intent3 = new Intent(intent);
            android.content.pm.ActivityInfo activityInfo = obj14.activityInfo;
            ComponentName componentName = new ComponentName(applicationInfo.packageName, activityInfo.name);
            intent3.setComponent(componentName);
            obj14 = obj14.specificIndex;
            if (menuItem8Arr8 != null && obj14 >= 0) {
            }
            i4++;
            obj14 = obj14.specificIndex;
            if (obj14 >= 0) {
            }
            menuItem8Arr8[obj14] = add(i, i2, i3, (ResolveInfo)obj14.loadLabel(packageManager)).setIcon(obj14.loadIcon(packageManager)).setIntent(intent3);
            intent = intent6;
        }
        return size;
    }

    @Override // d.h.g.a.a
    public SubMenu addSubMenu(int i) {
        int i2 = 0;
        return addSubMenu(i2, i2, i2, this.b.getString(i));
    }

    @Override // d.h.g.a.a
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.b.getString(i4));
    }

    @Override // d.h.g.a.a
    public SubMenu addSubMenu(int i, int i2, int i3, java.lang.CharSequence charSequence4) {
        final MenuItem obj1 = a(i, i2, i3, charSequence4);
        r obj2 = new r(this.a, this, (i)obj1);
        obj1.x(obj2);
        return obj2;
    }

    @Override // d.h.g.a.a
    public SubMenu addSubMenu(java.lang.CharSequence charSequence) {
        final int i = 0;
        return addSubMenu(i, i, i, charSequence);
    }

    @Override // d.h.g.a.a
    public void b(androidx.appcompat.view.menu.m m) {
        c(m, this.a);
    }

    @Override // d.h.g.a.a
    protected androidx.appcompat.view.menu.g b0(int i) {
        this.a0(i, 0, 0, 0, 0);
        return this;
    }

    @Override // d.h.g.a.a
    public void c(androidx.appcompat.view.menu.m m, Context context2) {
        WeakReference weakReference = new WeakReference(m);
        this.w.add(weakReference);
        m.i(context2, this);
        this.k = true;
    }

    @Override // d.h.g.a.a
    protected androidx.appcompat.view.menu.g c0(java.lang.CharSequence charSequence) {
        this.a0(0, charSequence, 0, 0, 0);
        return this;
    }

    @Override // d.h.g.a.a
    public void clear() {
        androidx.appcompat.view.menu.i iVar = this.x;
        if (iVar != null) {
            f(iVar);
        }
        this.f.clear();
        M(true);
    }

    @Override // d.h.g.a.a
    public void clearHeader() {
        int i = 0;
        this.o = i;
        this.n = i;
        this.p = i;
        M(false);
    }

    @Override // d.h.g.a.a
    public void close() {
        e(true);
    }

    @Override // d.h.g.a.a
    public void d() {
        final androidx.appcompat.view.menu.g.a aVar = this.e;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    @Override // d.h.g.a.a
    protected androidx.appcompat.view.menu.g d0(View view) {
        this.a0(0, 0, 0, 0, view);
        return this;
    }

    @Override // d.h.g.a.a
    public final void e(boolean z) {
        Object next;
        Object obj;
        if (this.u) {
        }
        this.u = true;
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = (WeakReference)next.get();
            if ((m)obj == null) {
            } else {
            }
            (m)obj.c(this, z);
            this.w.remove(next);
        }
        this.u = false;
    }

    @Override // d.h.g.a.a
    public void e0(boolean z) {
        this.z = z;
    }

    @Override // d.h.g.a.a
    public boolean f(androidx.appcompat.view.menu.i i) {
        boolean iterator;
        int i2;
        boolean next;
        Object obj;
        androidx.appcompat.view.menu.i obj5;
        i2 = 0;
        if (!this.w.isEmpty()) {
            if (this.x != i) {
            } else {
                h0();
                iterator = this.w.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    obj = (WeakReference)next.get();
                    if ((m)obj == null) {
                    } else {
                    }
                    if ((m)obj.f(this, i) == 0) {
                    }
                    this.w.remove(next);
                }
                g0();
                if (i2 != 0) {
                    this.x = 0;
                }
            }
        }
        return i2;
    }

    @Override // d.h.g.a.a
    public MenuItem findItem(int i) {
        int i2;
        Object item;
        boolean subMenu;
        i2 = 0;
        while (i2 < size()) {
            item = this.f.get(i2);
            i2++;
            item = item.getSubMenu().findItem(i);
        }
        return null;
    }

    @Override // d.h.g.a.a
    public void g0() {
        int i;
        i = 0;
        this.q = i;
        if (this.r) {
            this.r = i;
            M(this.s);
        }
    }

    @Override // d.h.g.a.a
    public MenuItem getItem(int i) {
        return (MenuItem)this.f.get(i);
    }

    @Override // d.h.g.a.a
    boolean h(androidx.appcompat.view.menu.g g, MenuItem menuItem2) {
        androidx.appcompat.view.menu.g obj2;
        final androidx.appcompat.view.menu.g.a aVar = this.e;
        if (aVar != null && aVar.a(g, menuItem2)) {
            obj2 = aVar.a(g, menuItem2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // d.h.g.a.a
    public void h0() {
        boolean z;
        if (!this.q) {
            this.q = true;
            z = 0;
            this.r = z;
            this.s = z;
        }
    }

    @Override // d.h.g.a.a
    public boolean hasVisibleItems() {
        int i;
        boolean visible;
        final int i2 = 1;
        if (this.z) {
            return i2;
        }
        final int i3 = 0;
        i = i3;
        while (i < size()) {
            i++;
        }
        return i3;
    }

    @Override // d.h.g.a.a
    public boolean isShortcutKey(int i, KeyEvent keyEvent2) {
        int obj1;
        obj1 = r(i, keyEvent2) != null ? 1 : 0;
        return obj1;
    }

    @Override // d.h.g.a.a
    public boolean m(androidx.appcompat.view.menu.i i) {
        int i2;
        Object next;
        Object obj;
        if (this.w.isEmpty()) {
            return 0;
        }
        h0();
        Iterator iterator = this.w.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = (WeakReference)next.get();
            if ((m)obj == null) {
            } else {
            }
            if ((m)obj.g(this, i) == 0) {
            }
            this.w.remove(next);
        }
        g0();
        if (i2 != 0) {
            this.x = i;
        }
        return i2;
    }

    @Override // d.h.g.a.a
    public int n(int i) {
        return o(i, 0);
    }

    @Override // d.h.g.a.a
    public int o(int i, int i2) {
        int groupId;
        int obj4;
        if (i2 < 0) {
            obj4 = 0;
        }
        while (obj4 < size()) {
            obj4++;
        }
        return -1;
    }

    @Override // d.h.g.a.a
    public boolean performIdentifierAction(int i, int i2) {
        return N(findItem(i), i2);
    }

    @Override // d.h.g.a.a
    public boolean performShortcut(int i, KeyEvent keyEvent2, int i3) {
        boolean obj1;
        int obj2;
        obj1 = r(i, keyEvent2);
        if (obj1 != null) {
            obj1 = N(obj1, i3);
        } else {
            obj1 = 0;
        }
        if (i3 & 2 != 0) {
            e(true);
        }
        return obj1;
    }

    @Override // d.h.g.a.a
    public int q(int i) {
        int i2;
        int itemId;
        i2 = 0;
        while (i2 < size()) {
            i2++;
        }
        return -1;
    }

    @Override // d.h.g.a.a
    androidx.appcompat.view.menu.i r(int i, KeyEvent keyEvent2) {
        int i3;
        Object obj;
        char alphabeticShortcut;
        char meta;
        int i2;
        final ArrayList list = this.v;
        list.clear();
        s(list, i, keyEvent2);
        final int i4 = 0;
        if (list.isEmpty()) {
            return i4;
        }
        int metaState = keyEvent2.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent2.getKeyData(keyData);
        final int obj13 = list.size();
        final int i6 = 0;
        if (obj13 == 1) {
            return (i)list.get(i6);
        }
        boolean z = I();
        i3 = i6;
        while (i3 < obj13) {
            obj = list.get(i3);
            if (z) {
            } else {
            }
            alphabeticShortcut = (i)obj.getNumericShortcut();
            meta = keyData.meta;
            i3++;
            alphabeticShortcut = obj.getAlphabeticShortcut();
        }
        return i4;
    }

    @Override // d.h.g.a.a
    public void removeGroup(int i) {
        int i2;
        int i4;
        int groupId;
        int i3;
        int obj6;
        final int i5 = n(i);
        if (i5 >= 0) {
            i4 = 0;
            groupId = i4;
            while (groupId < size -= i5) {
                if ((i)this.f.get(i5).getGroupId() == i) {
                }
                P(i5, i4);
                groupId = i3;
            }
            M(true);
        }
    }

    @Override // d.h.g.a.a
    public void removeItem(int i) {
        P(q(i), true);
    }

    void s(List<androidx.appcompat.view.menu.i> list, int i2, KeyEvent keyEvent3) {
        int i;
        Object obj;
        char alphabeticShortcut;
        boolean subMenu;
        int meta;
        int alphabeticModifiers;
        int i4;
        int i3;
        final boolean z = I();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        final int i5 = 67;
        if (!keyEvent3.getKeyData(keyData) && i2 != i5) {
            if (i2 != i5) {
            }
        }
        final int i6 = 0;
        i = i6;
        while (i < this.f.size()) {
            obj = this.f.get(i);
            if ((i)obj.hasSubMenu()) {
            }
            if (z) {
            } else {
            }
            alphabeticShortcut = obj.getNumericShortcut();
            if (z) {
            } else {
            }
            alphabeticModifiers = obj.getNumericModifiers();
            i4 = 69647;
            if (modifiers & i4 == alphabeticModifiers &= i4) {
            } else {
            }
            meta = i6;
            if (meta != 0 && alphabeticShortcut != 0) {
            }
            i++;
            if (alphabeticShortcut != 0) {
            }
            meta = keyData.meta;
            if (alphabeticShortcut != meta[i6] && alphabeticShortcut != meta[2]) {
            } else {
            }
            if (obj.isEnabled()) {
            }
            list.add(obj);
            if (alphabeticShortcut != meta[2]) {
            } else {
            }
            if (z && alphabeticShortcut == 8 && i2 == i5 && obj.isEnabled()) {
            }
            if (alphabeticShortcut == 8) {
            }
            if (i2 == i5) {
            }
            meta = 1;
            alphabeticModifiers = obj.getAlphabeticModifiers();
            alphabeticShortcut = obj.getAlphabeticShortcut();
            (g)obj.getSubMenu().s(list, i2, keyEvent3);
        }
    }

    @Override // d.h.g.a.a
    public void setGroupCheckable(int i, boolean z2, boolean z3) {
        int i2;
        Object obj;
        int groupId;
        i2 = 0;
        while (i2 < this.f.size()) {
            obj = this.f.get(i2);
            if ((i)obj.getGroupId() == i) {
            }
            i2++;
            obj.t(z3);
            obj.setCheckable(z2);
        }
    }

    @Override // d.h.g.a.a
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // d.h.g.a.a
    public void setGroupEnabled(int i, boolean z2) {
        int i2;
        Object obj;
        int groupId;
        i2 = 0;
        while (i2 < this.f.size()) {
            obj = this.f.get(i2);
            if ((i)obj.getGroupId() == i) {
            }
            i2++;
            obj.setEnabled(z2);
        }
    }

    @Override // d.h.g.a.a
    public void setGroupVisible(int i, boolean z2) {
        int i2;
        int i4;
        int i3;
        Object obj;
        int groupId;
        i4 = i2;
        i3 = 1;
        while (i2 < this.f.size()) {
            obj = this.f.get(i2);
            if ((i)obj.getGroupId() == i && obj.y(z2)) {
            }
            i2++;
            i3 = 1;
            if (obj.y(z2)) {
            }
            i4 = i3;
        }
        if (i4 != 0) {
            M(i3);
        }
    }

    @Override // d.h.g.a.a
    public void setQwertyMode(boolean z) {
        this.c = z;
        M(false);
    }

    @Override // d.h.g.a.a
    public int size() {
        return this.f.size();
    }

    @Override // d.h.g.a.a
    public void t() {
        ArrayList list;
        ArrayList size;
        int i;
        boolean next;
        boolean next2;
        Object obj;
        list = G();
        if (!this.k) {
        }
        Iterator iterator = this.w.iterator();
        final int i2 = 0;
        i = i2;
        while (iterator.hasNext()) {
            next = iterator.next();
            obj = (WeakReference)next.get();
            if ((m)obj == null) {
            } else {
            }
            i |= next;
            this.w.remove(next);
        }
        if (i != 0) {
            this.i.clear();
            this.j.clear();
            i = i2;
            while (i < list.size()) {
                next2 = list.get(i);
                if ((i)next2.l()) {
                } else {
                }
                this.j.add(next2);
                i++;
                this.i.add(next2);
            }
        } else {
            this.i.clear();
            this.j.clear();
            this.j.addAll(G());
        }
        this.k = i2;
    }

    public ArrayList<androidx.appcompat.view.menu.i> u() {
        t();
        return this.i;
    }

    @Override // d.h.g.a.a
    protected String v() {
        return "android:menu:actionviewstates";
    }

    @Override // d.h.g.a.a
    public Context w() {
        return this.a;
    }

    @Override // d.h.g.a.a
    public androidx.appcompat.view.menu.i x() {
        return this.x;
    }

    @Override // d.h.g.a.a
    public Drawable y() {
        return this.o;
    }

    @Override // d.h.g.a.a
    public java.lang.CharSequence z() {
        return this.n;
    }
}
