package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import d.a.l.a.a;
import d.a.m.a;
import d.e.d;
import d.e.e;
import d.e.g;
import d.e.h;
import d.v.a.a.c;
import d.v.a.a.i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class j0 {

    private static final PorterDuff.Mode h;
    private static androidx.appcompat.widget.j0 i;
    private static final androidx.appcompat.widget.j0.c j;
    private WeakHashMap<Context, h<ColorStateList>> a;
    private g<String, androidx.appcompat.widget.j0.d> b;
    private h<String> c;
    private final WeakHashMap<Context, d<WeakReference<Drawable.ConstantState>>> d;
    private TypedValue e;
    private boolean f;
    private androidx.appcompat.widget.j0.e g;

    private interface d {
        public abstract Drawable a(Context context, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4);
    }

    interface e {
        public abstract boolean a(Context context, int i2, Drawable drawable3);

        public abstract PorterDuff.Mode b(int i);

        public abstract Drawable c(androidx.appcompat.widget.j0 j0, Context context2, int i3);

        public abstract ColorStateList d(Context context, int i2);

        public abstract boolean e(Context context, int i2, Drawable drawable3);
    }

    static class a implements androidx.appcompat.widget.j0.d {
        @Override // androidx.appcompat.widget.j0$d
        public Drawable a(Context context, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
            try {
                return a.m(context, context.getResources(), xmlPullParser2, attributeSet3, theme4);
                xmlPullParser2 = "AsldcInflateDelegate";
                attributeSet3 = "Exception while inflating <animated-selector>";
                Log.e(xmlPullParser2, attributeSet3, context);
                context = null;
                return context;
            }
        }
    }

    private static class b implements androidx.appcompat.widget.j0.d {
        @Override // androidx.appcompat.widget.j0$d
        public Drawable a(Context context, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
            try {
                return c.a(context, context.getResources(), xmlPullParser2, attributeSet3, theme4);
                xmlPullParser2 = "AvdcInflateDelegate";
                attributeSet3 = "Exception while inflating <animated-vector>";
                Log.e(xmlPullParser2, attributeSet3, context);
                context = null;
                return context;
            }
        }
    }

    private static class c extends e<Integer, PorterDuffColorFilter> {
        public c(int i) {
            super(i);
        }

        private static int j(int i, PorterDuff.Mode porterDuff$Mode2) {
            final int i2 = 31;
            return obj1 += obj2;
        }

        @Override // d.e.e
        PorterDuffColorFilter k(int i, PorterDuff.Mode porterDuff$Mode2) {
            return (PorterDuffColorFilter)c(Integer.valueOf(j0.c.j(i, mode2)));
        }

        @Override // d.e.e
        PorterDuffColorFilter l(int i, PorterDuff.Mode porterDuff$Mode2, PorterDuffColorFilter porterDuffColorFilter3) {
            return (PorterDuffColorFilter)d(Integer.valueOf(j0.c.j(i, mode2)), porterDuffColorFilter3);
        }
    }

    private static class f implements androidx.appcompat.widget.j0.d {
        @Override // androidx.appcompat.widget.j0$d
        public Drawable a(Context context, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
            try {
                return i.c(context.getResources(), xmlPullParser2, attributeSet3, theme4);
                xmlPullParser2 = "VdcInflateDelegate";
                attributeSet3 = "Exception while inflating <vector>";
                Log.e(xmlPullParser2, attributeSet3, context);
                context = null;
                return context;
            }
        }
    }
    static {
        j0.h = PorterDuff.Mode.SRC_IN;
        j0.c cVar = new j0.c(6);
        j0.j = cVar;
    }

    public j0() {
        super();
        WeakHashMap weakHashMap = new WeakHashMap(0);
        this.d = weakHashMap;
    }

    private void a(String string, androidx.appcompat.widget.j0.d j0$d2) {
        g gVar;
        if (this.b == null) {
            gVar = new g();
            this.b = gVar;
        }
        this.b.put(string, d2);
    }

    private boolean b(Context context, long l2, Drawable drawable3) {
        Object dVar;
        WeakHashMap map;
        final Drawable.ConstantState obj6 = obj6.getConstantState();
        synchronized (this) {
            try {
                if ((d)this.d.get(context) == null) {
                }
                dVar = new d();
                this.d.put(context, dVar);
                WeakReference obj3 = new WeakReference(obj6);
                dVar.k(l2, drawable3);
                return 1;
                return 0;
                throw context;
            }
        }
    }

    private void c(Context context, int i2, ColorStateList colorStateList3) {
        WeakHashMap weakHashMap;
        Object hVar;
        WeakHashMap map;
        if (this.a == null) {
            weakHashMap = new WeakHashMap();
            this.a = weakHashMap;
        }
        if ((h)this.a.get(context) == null) {
            hVar = new h();
            this.a.put(context, hVar);
        }
        hVar.a(i2, colorStateList3);
    }

    private void d(Context context) {
        Drawable obj2;
        if (this.f) {
        }
        this.f = true;
        obj2 = j(context, a.a);
        if (obj2 == null) {
        } else {
            if (!j0.q(obj2)) {
            } else {
            }
        }
        this.f = false;
        obj2 = new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        throw obj2;
    }

    private static long e(TypedValue typedValue) {
        return i |= l2;
    }

    private Drawable f(Context context, int i2) {
        TypedValue typedValue;
        TypedValue changingConfigurations;
        Drawable obj6;
        if (this.e == null) {
            typedValue = new TypedValue();
            this.e = typedValue;
        }
        changingConfigurations = this.e;
        final int i = 1;
        context.getResources().getValue(i2, changingConfigurations, i);
        long l = j0.e(changingConfigurations);
        Drawable drawable = i(context, l);
        if (drawable != null) {
            return drawable;
        }
        androidx.appcompat.widget.j0.e eVar = this.g;
        if (eVar == null) {
            obj6 = 0;
        } else {
            obj6 = eVar.c(this, context, i2);
        }
        if (obj6 != null) {
            obj6.setChangingConfigurations(changingConfigurations.changingConfigurations);
            b(context, l, i);
        }
        return obj6;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode porterDuff$Mode2, int[] i3Arr3) {
        if (colorStateList != null && mode2 == null) {
            if (mode2 == null) {
            }
            return j0.l(colorStateList.getColorForState(i3Arr3, 0), mode2);
        }
        return null;
    }

    public static androidx.appcompat.widget.j0 h() {
        androidx.appcompat.widget.j0 j0Var;
        final Class<androidx.appcompat.widget.j0> obj = j0.class;
        synchronized (obj) {
            j0Var = new j0();
            j0.i = j0Var;
            j0.p(j0Var);
            return j0.i;
        }
    }

    private Drawable i(Context context, long l2) {
        Object obj;
        Object obj2 = this.d.get(context);
        final int i = 0;
        synchronized (this) {
            try {
                return i;
                obj = (d)obj2.f(l2);
                obj = (WeakReference)obj.get();
                if (obj != null && (Drawable.ConstantState)obj != null) {
                }
                obj = obj.get();
                if ((Drawable.ConstantState)(Drawable.ConstantState)obj != null) {
                }
                return (Drawable.ConstantState)(Drawable.ConstantState)obj.newDrawable(context.getResources());
                obj2.l(l2);
                return i;
                throw context;
            }
        }
    }

    public static PorterDuffColorFilter l(int i, PorterDuff.Mode porterDuff$Mode2) {
        PorterDuffColorFilter porterDuffColorFilter;
        final Class<androidx.appcompat.widget.j0> obj = j0.class;
        final androidx.appcompat.widget.j0.c cVar = j0.j;
        synchronized (obj) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, mode2);
            cVar.l(i, mode2, porterDuffColorFilter);
            return porterDuffColorFilter;
        }
    }

    private ColorStateList n(Context context, int i2) {
        int i;
        Object obj3;
        final WeakHashMap map = this.a;
        i = 0;
        obj3 = map.get(context);
        if (map != null && (h)obj3 != null) {
            obj3 = map.get(context);
            if ((h)(h)obj3 != null) {
                i = obj3;
            }
        }
        return i;
    }

    private static void p(androidx.appcompat.widget.j0 j0) {
        int sDK_INT;
        int str;
        if (Build.VERSION.SDK_INT < 24) {
            j0.f fVar = new j0.f();
            j0.a("vector", fVar);
            j0.b bVar = new j0.b();
            j0.a("animated-vector", bVar);
            sDK_INT = new j0.a();
            j0.a("animated-selector", sDK_INT);
        }
    }

    private static boolean q(Drawable drawable) {
        String str;
        int obj1;
        if (!drawable instanceof i) {
            if ("android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    private Drawable r(Context context, int i2) {
        g empty;
        Object hVar;
        TypedValue typedValue;
        TypedValue changingConfigurations;
        Object resources;
        boolean equals;
        int i3;
        Drawable drawable;
        java.lang.CharSequence attributeSet;
        Object theme;
        int i;
        Context obj11;
        empty = this.b;
        int i4 = 0;
        h hVar2 = this.c;
        final String str4 = "appcompat_skip_skip";
        hVar = hVar2.e(i2);
        if (empty != null && !empty.isEmpty() && hVar2 != null && !str4.equals((String)hVar) && hVar != null && this.b.get(hVar) == null) {
            if (!empty.isEmpty()) {
                hVar2 = this.c;
                str4 = "appcompat_skip_skip";
                if (hVar2 != null) {
                    hVar = hVar2.e(i2);
                    if (!str4.equals((String)hVar)) {
                        if (hVar != null) {
                            if (this.b.get(hVar) == null) {
                            }
                        }
                        if (this.e == null) {
                            typedValue = new TypedValue();
                            this.e = typedValue;
                        }
                        changingConfigurations = this.e;
                        resources = context.getResources();
                        i3 = 1;
                        resources.getValue(i2, changingConfigurations, i3);
                        final long l = j0.e(changingConfigurations);
                        drawable = i(context, l);
                        if (drawable != null) {
                            return drawable;
                        }
                        attributeSet = changingConfigurations.string;
                        if (attributeSet != null && attributeSet.toString().endsWith(".xml")) {
                            if (attributeSet.toString().endsWith(".xml")) {
                                resources = resources.getXml(i2);
                                theme = resources.next();
                                i = 2;
                                while (theme != i) {
                                    if (theme != i3) {
                                    }
                                    theme = resources.next();
                                    i = 2;
                                }
                                if (theme != i) {
                                } else {
                                    String name = resources.getName();
                                    this.c.a(i2, name);
                                    i3 = this.b.get(name);
                                    if ((j0.d)i3 != null) {
                                        drawable = resources;
                                    }
                                    if (drawable != null) {
                                        drawable.setChangingConfigurations(changingConfigurations.changingConfigurations);
                                        b(context, l, obj5);
                                    }
                                }
                                obj11 = new XmlPullParserException("No start tag found");
                                throw obj11;
                            }
                        }
                        if (drawable == null) {
                            this.c.a(i2, str4);
                        }
                        return drawable;
                    }
                    return i4;
                }
                hVar = new h();
                this.c = hVar;
            }
        }
        return i4;
    }

    private Drawable v(Context context, int i2, boolean z3, Drawable drawable4) {
        boolean list;
        Context obj2;
        Drawable obj5;
        list = m(context, i2);
        if (list != null) {
            if (a0.a(drawable4)) {
                obj5 = drawable4.mutate();
            }
            obj5 = a.r(obj5);
            a.o(obj5, list);
            obj2 = o(i2);
            if (obj2 != null) {
                a.p(obj5, obj2);
            }
        } else {
            list = this.g;
            if (list != null && list.e(context, i2, drawable4)) {
                if (list.e(context, i2, drawable4)) {
                } else {
                    if (!x(context, i2, drawable4) && z3) {
                        if (z3) {
                            obj5 = 0;
                        }
                    }
                }
            } else {
            }
        }
        return obj5;
    }

    static void w(Drawable drawable, androidx.appcompat.widget.r0 r02, int[] i3Arr3) {
        boolean mutate;
        boolean z;
        boolean z2;
        Object obj3;
        if (a0.a(drawable) && drawable.mutate() != drawable) {
            if (drawable.mutate() != drawable) {
                Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            }
        }
        z = r02.d;
        if (!z) {
            if (r02.c) {
                z = z ? r02.a : 0;
                obj3 = r02.c ? r02.b : j0.h;
                drawable.setColorFilter(j0.g(z, obj3, i3Arr3));
            } else {
                drawable.clearColorFilter();
            }
        } else {
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public Drawable j(Context context, int i2) {
        return k(context, i2, false);
        synchronized (this) {
            return k(context, i2, false);
        }
    }

    Drawable k(Context context, int i2, boolean z3) {
        Drawable drawable;
        d(context);
        synchronized (this) {
            try {
                drawable = f(context, i2);
                if (drawable == null) {
                }
                drawable = a.f(context, i2);
                if (drawable != null) {
                }
                drawable = v(context, i2, z3, drawable);
                if (drawable != null) {
                }
                a0.b(drawable);
                return drawable;
                throw context;
            }
        }
    }

    ColorStateList m(Context context, int i2) {
        ColorStateList list;
        synchronized (this) {
            try {
                androidx.appcompat.widget.j0.e eVar = this.g;
                if (eVar == null) {
                } else {
                }
                list = 0;
                list = eVar.d(context, i2);
                if (list != null) {
                }
                c(context, i2, list);
                return list;
                throw context;
            }
        }
    }

    PorterDuff.Mode o(int i) {
        int obj2;
        final androidx.appcompat.widget.j0.e eVar = this.g;
        if (eVar == null) {
            obj2 = 0;
        } else {
            obj2 = eVar.b(i);
        }
        return obj2;
    }

    public void s(Context context) {
        final Object obj2 = this.d.get(context);
        synchronized (this) {
            try {
                (d)obj2.b();
                throw context;
            }
        }
    }

    Drawable t(Context context, androidx.appcompat.widget.y0 y02, int i3) {
        Drawable drawable;
        synchronized (this) {
            try {
                drawable = y02.d(i3);
                if (drawable != null) {
                }
                return v(context, i3, false, drawable);
                return null;
                throw context;
            }
        }
    }

    public void u(androidx.appcompat.widget.j0.e j0$e) {
        this.g = e;
        return;
        synchronized (this) {
            this.g = e;
        }
    }

    boolean x(Context context, int i2, Drawable drawable3) {
        Context obj2;
        final androidx.appcompat.widget.j0.e eVar = this.g;
        if (eVar != null && eVar.a(context, i2, drawable3)) {
            obj2 = eVar.a(context, i2, drawable3) ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
