package d.a.o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.t0;
import d.a.j;
import d.h.l.b;
import d.h.l.i;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class g extends MenuInflater {

    static final Class<?>[] e;
    static final Class<?>[] f;
    final Object[] a;
    final Object[] b;
    Context c;
    private Object d;

    private static class a implements MenuItem.OnMenuItemClickListener {

        private static final Class<?>[] c;
        private Object a;
        private Method b;
        static {
            Class[] arr = new Class[1];
            g.a.c = arr;
        }

        public a(Object object, String string2) {
            super();
            this.a = object;
            this.b = object.getClass().getMethod(string2, g.a.c);
        }

        @Override // android.view.MenuItem$OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                final int i = 0;
                int i2 = 1;
                if (this.b.getReturnType() == Boolean.TYPE) {
                }
                Object[] arr = new Object[i2];
                arr[i] = menuItem;
                return (Boolean)this.b.invoke(this.a, arr).booleanValue();
                final Object[] arr2 = new Object[i2];
                arr2[i] = menuItem;
                this.b.invoke(this.a, arr2);
                return i2;
                RuntimeException runtimeException = new RuntimeException(menuItem);
                throw runtimeException;
            }
        }
    }

    private class b {

        b A;
        private java.lang.CharSequence B;
        private java.lang.CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        final d.a.o.g F;
        private Menu a;
        private int b;
        private int c;
        private int d;
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private int i;
        private int j;
        private java.lang.CharSequence k;
        private java.lang.CharSequence l;
        private int m;
        private char n;
        private int o;
        private char p;
        private int q;
        private int r;
        private boolean s;
        private boolean t;
        private boolean u;
        private int v;
        private int w;
        private String x;
        private String y;
        private String z;
        public b(d.a.o.g g, Menu menu2) {
            this.F = g;
            super();
            final int obj1 = 0;
            this.a = menu2;
            h();
        }

        private char c(String string) {
            final int i = 0;
            if (string == null) {
                return i;
            }
            return string.charAt(i);
        }

        private <T> T e(String string, Class<?>[] class2Arr2, Object[] object3Arr3) {
            final Constructor obj4 = Class.forName(string, false, gVar.c.getClassLoader()).getConstructor(class2Arr2);
            obj4.setAccessible(true);
            return obj4.newInstance(object3Arr3);
        }

        private void i(MenuItem menuItem) {
            Object aVar;
            int i;
            Object str2;
            int str4;
            int i3;
            int i4;
            int str;
            int i2;
            String str3;
            final int i9 = 1;
            i3 = this.r >= i9 ? i9 : i2;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(i3).setTitleCondensed(this.l).setIcon(this.m);
            int i5 = this.v;
            if (i5 >= 0) {
                menuItem.setShowAsAction(i5);
            }
            if (this.z != null) {
                if (gVar.c.isRestricted()) {
                } else {
                    aVar = new g.a(this.F.b(), this.z);
                    menuItem.setOnMenuItemClickListener(aVar);
                }
                IllegalStateException obj6 = new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                throw obj6;
            }
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    (i)menuItem.t(i9);
                } else {
                    if (menuItem instanceof j) {
                        (j)menuItem.h(i9);
                    }
                }
            }
            str2 = this.x;
            if (str2 != null) {
                menuItem.setActionView((View)e(str2, g.e, gVar3.a));
                i2 = i9;
            }
            str4 = this.w;
            if (str4 > 0) {
                if (i2 == 0) {
                    menuItem.setActionView(str4);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            b bVar = this.A;
            if (bVar != null) {
                i.a(menuItem, bVar);
            }
            i.c(menuItem, this.B);
            i.g(menuItem, this.C);
            i.b(menuItem, this.n, this.o);
            i.f(menuItem, this.p, this.q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                i.e(menuItem, mode);
            }
            ColorStateList list = this.D;
            if (list != null) {
                i.d(menuItem, list);
            }
        }

        public void a() {
            this.h = true;
            i(this.a.add(this.b, this.i, this.j, this.k));
        }

        public SubMenu b() {
            this.h = true;
            SubMenu subMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            i(subMenu.getItem());
            return subMenu;
        }

        public boolean d() {
            return this.h;
        }

        public void f(AttributeSet attributeSet) {
            final TypedArray obj3 = gVar.c.obtainStyledAttributes(attributeSet, j.g1);
            int i7 = 0;
            this.b = obj3.getResourceId(j.i1, i7);
            this.c = obj3.getInt(j.k1, i7);
            this.d = obj3.getInt(j.l1, i7);
            this.e = obj3.getInt(j.m1, i7);
            int i8 = 1;
            this.f = obj3.getBoolean(j.j1, i8);
            this.g = obj3.getBoolean(j.h1, i8);
            obj3.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z;
            String str;
            PorterDuff.Mode mode;
            ColorStateList list;
            PorterDuff.Mode i;
            int str2;
            int i2;
            final t0 obj7 = t0.u(gVar.c, attributeSet, j.n1);
            int i24 = 0;
            this.i = obj7.n(j.q1, i24);
            this.j = i7 |= i28;
            this.k = obj7.p(j.v1);
            this.l = obj7.p(j.w1);
            this.m = obj7.n(j.o1, i24);
            this.n = c(obj7.o(j.x1));
            int i29 = 4096;
            this.o = obj7.k(j.E1, i29);
            this.p = c(obj7.o(j.y1));
            this.q = obj7.k(j.I1, i29);
            int i17 = j.z1;
            if (obj7.s(i17)) {
                this.r = obj7.a(i17, i24);
            } else {
                this.r = this.e;
            }
            this.s = obj7.a(j.r1, i24);
            this.t = obj7.a(j.s1, this.f);
            this.u = obj7.a(j.p1, this.g);
            i = -1;
            this.v = obj7.k(j.J1, i);
            this.z = obj7.o(j.A1);
            this.w = obj7.n(j.B1, i24);
            this.x = obj7.o(j.D1);
            str = obj7.o(j.C1);
            this.y = str;
            str2 = str != null ? 1 : i24;
            final int i33 = 0;
            if (str2 != null && this.w == 0 && this.x == null) {
                if (this.w == 0) {
                    if (this.x == null) {
                        this.A = (b)e(str, g.f, gVar2.b);
                    } else {
                        if (str2 != null) {
                            Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                        }
                        this.A = i33;
                    }
                } else {
                }
            } else {
            }
            this.B = obj7.p(j.F1);
            this.C = obj7.p(j.K1);
            mode = j.H1;
            if (obj7.s(mode)) {
                this.E = a0.e(obj7.k(mode, i), this.E);
            } else {
                this.E = i33;
            }
            list = j.G1;
            if (obj7.s(list)) {
                this.D = obj7.c(list);
            } else {
                this.D = i33;
            }
            obj7.w();
            this.h = i24;
        }

        public void h() {
            int i = 0;
            this.b = i;
            this.c = i;
            this.d = i;
            this.e = i;
            int i2 = 1;
            this.f = i2;
            this.g = i2;
        }
    }
    static {
        Class[] arr = new Class[1];
        g.e = arr;
        g.f = arr;
    }

    public g(Context context) {
        super(context);
        this.c = context;
        Object[] arr = new Object[1];
        this.a = arr;
        this.b = arr;
    }

    private Object a(Object object) {
        Object obj2;
        if (object instanceof Activity != null) {
            return object;
        }
        if (object instanceof ContextWrapper) {
            obj2 = a((ContextWrapper)object.getBaseContext());
        }
        return obj2;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet2, Menu menu3) {
        int i3;
        String str;
        int i;
        boolean equals2;
        int i5;
        int i4;
        int i2;
        String equals3;
        boolean equals4;
        int equals;
        int obj15;
        g.b bVar = new g.b(this, menu3);
        obj15 = xmlPullParser.getEventType();
        i3 = 2;
        str = "menu";
        i = 1;
        while (obj15 == i3) {
            i3 = 2;
            str = "menu";
            i = 1;
        }
        obj15 = xmlPullParser.getName();
        if (!obj15.equals(str)) {
        } else {
            obj15 = xmlPullParser.next();
            int i6 = 0;
            final int i7 = 0;
            i2 = i6;
            i4 = i5;
            while (i5 == 0) {
                equals3 = "item";
                equals4 = "group";
                if (obj15 != i3) {
                } else {
                }
                if (i4 != 0) {
                } else {
                }
                obj15 = xmlPullParser.getName();
                if (obj15.equals(equals4)) {
                } else {
                }
                if (obj15.equals(equals3)) {
                } else {
                }
                if (obj15.equals(str)) {
                } else {
                }
                i2 = obj15;
                i4 = i;
                obj15 = xmlPullParser.next();
                c(xmlPullParser, attributeSet2, bVar.b());
                bVar.g(attributeSet2);
                bVar.f(attributeSet2);
                if (obj15 != 3) {
                } else {
                }
                obj15 = xmlPullParser.getName();
                if (i4 != 0 && obj15.equals(i2)) {
                } else {
                }
                if (obj15.equals(equals4)) {
                } else {
                }
                if (obj15.equals(equals3)) {
                } else {
                }
                if (obj15.equals(str)) {
                }
                i5 = i;
                if (!bVar.d()) {
                }
                obj15 = bVar.A;
                if (obj15 != null && obj15.a()) {
                } else {
                }
                bVar.a();
                if (obj15.a()) {
                } else {
                }
                bVar.b();
                bVar.h();
                if (obj15.equals(i2)) {
                } else {
                }
                i2 = i6;
                i4 = i7;
            }
        }
        StringBuilder obj14 = new StringBuilder();
        obj14.append("Expecting menu, got ");
        obj14.append(obj15);
        RuntimeException obj13 = new RuntimeException(obj14.toString());
        throw obj13;
    }

    @Override // android.view.MenuInflater
    Object b() {
        Object obj;
        if (this.d == null) {
            this.d = a(this.c);
        }
        return this.d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu2) {
        final String str = "Error inflating menu XML";
        if (!menu2 instanceof a) {
            super.inflate(i, menu2);
        }
        int i2 = 0;
        XmlResourceParser layout = this.c.getResources().getLayout(i);
        c(layout, Xml.asAttributeSet(layout), menu2);
        if (layout != null) {
            layout.close();
        }
    }
}
