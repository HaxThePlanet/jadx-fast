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
import androidx.appcompat.widget.a0;
import androidx.appcompat.widget.t0;
import d.h.l.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: SupportMenuInflater.java */
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
            g.a.c = new Class[] { MenuItem.class };
        }

        public a(Object object, String str) throws java.lang.NoSuchMethodException, InflateException {
            super();
            this.a = object;
            try {
                this.b = object.getClass().getMethod(str, g.a.c);
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                str = "Couldn't resolve menu item onClick handler ";
                str = " in class ";
                object = object.getName();
                object = str + str + str + object;
                InflateException inflateException = new InflateException(object);
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            try {
                final int i = 0;
                int i2 = 1;
                if (this.b.getReturnType() == Boolean.TYPE) {
                    Object[] arr = new Object[i2];
                    return (Boolean)this.b.invoke(this.a, new Object[] { menuItem }).booleanValue();
                }
                final Object[] arr2 = new Object[i2];
                this.b.invoke(this.a, new Object[] { menuItem });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    }

    private class b {

        b A;
        private java.lang.CharSequence B;
        private java.lang.CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;
        final /* synthetic */ g F;
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
        public b(Menu menu) {
            this.F = gVar;
            super();
            this.a = menu;
            h();
        }

        private char c(String str) {
            final int i = 0;
            if (str == null) {
                return i;
            }
            return str.charAt(i);
        }

        private <T> T e(String str, Class<?>[] clsArr, Object[] objectArr) throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
            try {
                final Constructor constructor2 = Class.forName(str, false, this.F.c.getClassLoader()).getConstructor(clsArr);
                constructor2.setAccessible(true);
            } catch (Exception e) {
                objectArr = new StringBuilder();
                objectArr.append("Cannot instantiate class: ");
                objectArr.append(str);
                str = objectArr.toString();
                objectArr = "SupportMenuInflater";
                Log.w(objectArr, str, e);
                str = null;
                return str;
            }
            return constructor2.newInstance(objectArr);
        }

        private void i(MenuItem menuItem) {
            boolean z6;
            int i4 = 2;
            int i5 = 0;
            i5 = 0;
            i5 = 1;
            int r1 = this.r >= i5 ? i5 : 0;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable((this.r >= i5 ? i5 : 0)).setTitleCondensed((this.r >= i5 ? i5 : 0)).setIcon((this.r >= i5 ? i5 : 0));
            if (this.v >= 0) {
                menuItem.setShowAsAction(this.v);
            }
            if (this.z != null) {
                if (this.F.c.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                } else {
                    menuItem.setOnMenuItemClickListener(new g.a(this.F.b(), this.z));
                }
            }
            i4 = 2;
            if (this.r >= 2) {
                if (menuItem instanceof i) {
                    (i)menuItem.t(true);
                } else {
                    if (menuItem instanceof j) {
                        (j)menuItem.h(true);
                    }
                }
            }
            if (this.x != null) {
                menuItem.setActionView((View)e(this.x, g.e, this.F.a));
            }
            if (this.w > 0) {
                if (this.F.a == 0) {
                    menuItem.setActionView(this.w);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            if (this.A != null) {
                i.a(menuItem, this.A);
            }
            i.c(menuItem, this.B);
            i.g(menuItem, this.C);
            i.b(menuItem, this.n, this.o);
            i.f(menuItem, this.p, this.q);
            if (this.E != null) {
                i.e(menuItem, this.E);
            }
            if (this.D != null) {
                i.d(menuItem, this.D);
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

        public void f(AttributeSet set) throws android.content.res.Resources.NotFoundException {
            final TypedArray styledAttributes = this.F.c.obtainStyledAttributes(set, j.g1);
            int i7 = 0;
            this.b = styledAttributes.getResourceId(j.i1, i7);
            this.c = styledAttributes.getInt(j.k1, i7);
            this.d = styledAttributes.getInt(j.l1, i7);
            this.e = styledAttributes.getInt(j.m1, i7);
            boolean z = true;
            this.f = styledAttributes.getBoolean(j.j1, z);
            this.g = styledAttributes.getBoolean(j.h1, z);
            styledAttributes.recycle();
        }

        public void g(AttributeSet set) {
            String str;
            int i = 1;
            int i2;
            final t0 t0Var = t0.u(this.F.c, set, j.n1);
            i = 0;
            this.i = t0Var.n(j.q1, i);
            this.j = (t0Var.k(j.t1, this.c)) & (-65536) | (t0Var.k(j.u1, this.d)) & 65535;
            this.k = t0Var.p(j.v1);
            this.l = t0Var.p(j.w1);
            this.m = t0Var.n(j.o1, i);
            this.n = c(t0Var.o(j.x1));
            int i27 = 4096;
            this.o = t0Var.k(j.E1, i27);
            this.p = c(t0Var.o(j.y1));
            this.q = t0Var.k(j.I1, i27);
            int i15 = j.z1;
            if (t0Var.s(i15)) {
                this.r = t0Var.a(j.z1, false);
            } else {
                this.r = this.e;
            }
            this.s = t0Var.a(j.r1, false);
            this.t = t0Var.a(j.s1, this.f);
            this.u = t0Var.a(j.p1, this.g);
            int i28 = -1;
            this.v = t0Var.k(j.J1, i28);
            this.z = t0Var.o(j.A1);
            this.w = t0Var.n(j.B1, i);
            this.x = t0Var.o(j.D1);
            str = t0Var.o(j.C1);
            this.y = str;
            int r3 = str != null ? 1 : i;
            final b bVar = null;
            if (this.d == 0 || this.w != 0 || this.x != null) {
                if (this.d != 0) {
                    str = "SupportMenuInflater";
                    Log.w(str, "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = bVar;
            } else {
                this.A = (b)e(str, g.f, this.F.b);
            }
            this.B = t0Var.p(j.F1);
            this.C = t0Var.p(j.K1);
            int h12 = j.H1;
            if (t0Var.s(h12)) {
                this.E = a0.e(t0Var.k(j.H1, i28), this.E);
            } else {
                this.E = bVar;
            }
            int g12 = j.G1;
            if (t0Var.s(g12)) {
                this.D = t0Var.c(j.G1);
            } else {
                this.D = bVar;
            }
            t0Var.w();
            this.h = false;
        }

        public void h() {
            int i = 0;
            this.b = i;
            this.c = i;
            this.d = i;
            this.e = i;
            boolean z = true;
            this.f = z;
            this.g = z;
        }
    }
    static {
        Class[] arr = new Class[1];
        g.e = new Class[] { Context.class };
        g.f = arr;
    }

    public g(Context context) {
        super(context);
        this.c = context;
        Object[] arr = new Object[1];
        this.a = new Object[] { context };
        this.b = arr;
    }

    private Object a(Object object) {
        Object obj;
        if (object instanceof Activity) {
            return object;
        }
        if (object instanceof ContextWrapper) {
            obj = a(object.getBaseContext());
        }
        return obj;
    }

    private void c(XmlPullParser xmlPullParser, AttributeSet set, Menu menu) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int i2;
        Object obj;
        String str;
        boolean equals2;
        int i4;
        int eventType;
        b bVar;
        d.a.o.g.b bVar2 = new g.b(this, menu);
        eventType = xmlPullParser.getEventType();
        int i = 2;
        String str3 = "menu";
        i2 = 1;
        while (eventType == i) {
            if (xmlPullParser.next() == i2) {
                int i3 = 0;
                i2 = 0;
            }
            i = 2;
            str3 = "menu";
            i2 = 1;
        }
        String name = xmlPullParser.getName();
        if (!name.equals(str3)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Expecting menu, got ";
            set = str2 + name;
            throw new RuntimeException(set);
        } else {
            eventType = xmlPullParser.next();
            i3 = 0;
            i2 = 0;
            while (i2 == 0) {
                if (eventType == i2) {
                    throw new RuntimeException("Unexpected end of document");
                }
            }
            return;
        }
    }

    @Override // android.view.MenuInflater
    Object b() {
        if (this.d == null) {
            this.d = a(this.c);
        }
        return this.d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof a)) {
            super.inflate(i, menu);
            return;
        }
        try {
            XmlResourceParser layout = this.c.getResources().getLayout(i);
            c(layout, Xml.asAttributeSet(layout), menu);
        } catch (Throwable th) {
        }
        if (layout != null) {
            layout.close();
        }
    }
}
