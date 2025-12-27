package d.h.e;

import android.util.Log;
import android.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* compiled from: PropertyValuesHolder.java */
/* loaded from: classes.dex */
public class s implements java.lang.Cloneable {

    private static final Class<?>[] C;
    private static final Class<?>[] D;
    private static final Class<?>[] E;
    static final HashMap<Class<?>, HashMap<String, Method>> F = new HashMap<>();
    private static final HashMap<Class<?>, HashMap<String, Method>> G = new HashMap<>();
    private Object A;
    private t B;
    String a;
    Property b;
    Method c = null;
    private Method v = null;
    Class<?> w;
    p x = null;
    final Object[] y;
    private u z;

    static class a extends s {

        private i H;
        p.a I;
        float J;
        a(String str, float... fArr) {
            super(str);
            o(fArr);
        }

        @Override // d.h.e.s
        void a(float f) {
            this.J = this.I.n1(f);
        }

        @Override // d.h.e.s
        Object d() {
            return Float.valueOf(this.J);
        }

        @Override // d.h.e.s
        void n(Object object) {
            if (this.H != null) {
                this.H.b(object, this.J);
                return;
            }
            if (this.b != null) {
                this.b.set(object, Float.valueOf(this.J));
                return;
            }
            if (this.c != null) {
                try {
                    this.y[0] = Float.valueOf(this.J);
                    this.c.invoke(object, this.y);
                } catch (java.lang.IllegalAccessException illegalAccess) {
                    illegalAccess = illegalAccess.toString();
                    Log.e(str, illegalAccess);
                } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
                    invocationTarget1 = invocationTarget1.toString();
                    Log.e(str, invocationTarget1);
                }
            }
        }

        @Override // d.h.e.s
        public void o(float... fArr) {
            s.super.o(fArr);
            this.I = (p.a)this.x;
        }

        @Override // d.h.e.s
        public s.a w() {
            final d.h.e.s sVar = s.super.b();
            sVar.I = (p.a)sVar.x;
            return sVar;
        }

        a(Property property, float... fArr) {
            super(property);
            o(fArr);
            z = property instanceof i;
            if (property instanceof i) {
                this.H = (i)this.b;
            }
        }
    }

    static class b extends s {

        private l H;
        p.b I;
        int J;
        b(String str, int... iArr) {
            super(str);
            p(iArr);
        }

        @Override // d.h.e.s
        void a(float f) {
            this.J = this.I.N0(f);
        }

        @Override // d.h.e.s
        Object d() {
            return Integer.valueOf(this.J);
        }

        @Override // d.h.e.s
        void n(Object object) {
            if (this.H != null) {
                this.H.b(object, this.J);
                return;
            }
            if (this.b != null) {
                this.b.set(object, Integer.valueOf(this.J));
                return;
            }
            try {
                this.y[0] = Integer.valueOf(this.J);
                this.c.invoke(object, this.y);
            } catch (java.lang.IllegalAccessException illegalAccess) {
                illegalAccess = illegalAccess.toString();
                Log.e(str, illegalAccess);
            } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
                invocationTarget1 = invocationTarget1.toString();
                Log.e(str, invocationTarget1);
            }
        }

        @Override // d.h.e.s
        public void p(int... iArr) {
            s.super.p(iArr);
            this.I = (p.b)this.x;
        }

        @Override // d.h.e.s
        public s.b w() {
            final d.h.e.s sVar = s.super.b();
            sVar.I = (p.b)sVar.x;
            return sVar;
        }

        b(Property property, int... iArr) {
            super(property);
            p(iArr);
            z = property instanceof l;
            if (property instanceof l) {
                this.H = (l)this.b;
            }
        }
    }
    static {
        final Class<Integer> obj = Integer.class;
        final Class<Double> obj2 = Double.class;
        final Class<Float> obj3 = Float.class;
        int i = 6;
        Class[] arr2 = new Class[i];
        final Class tYPE2 = Float.TYPE;
        final int i2 = 0;
        arr2[i2] = tYPE2;
        final int i3 = 1;
        arr2[i3] = obj3;
        final int i4 = 2;
        arr2[i4] = Double.TYPE;
        Class tYPE23 = Integer.TYPE;
        final int i5 = 3;
        arr2[i5] = tYPE23;
        final int i6 = 4;
        arr2[i6] = obj2;
        final int i7 = 5;
        arr2[i7] = obj;
        s.C = arr2;
        Class[] arr3 = new Class[i];
        arr3[i2] = tYPE23;
        arr3[i3] = obj;
        arr3[i4] = tYPE2;
        final Class tYPE24 = Double.TYPE;
        arr3[i5] = tYPE24;
        arr3[i6] = obj3;
        arr3[i7] = obj2;
        s.D = arr3;
        Class[] arr = new Class[i];
        arr[i2] = tYPE24;
        arr[i3] = obj2;
        arr[i4] = tYPE2;
        arr[i5] = tYPE23;
        arr[i6] = obj3;
        arr[i7] = obj;
        s.E = arr;
    }

    s(String str) {
        super();
        this.y = new Object[1];
        this.a = str;
    }

    private Object c(Object object) {
        Object obj;
        if (this.B != null) {
            z = tVar instanceof f;
            if (!(tVar instanceof f)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Converter ";
                String name = this.B.getClass().getName();
                String str2 = " must be a BidirectionalTypeConverter";
                r0 = str + name + str2;
                throw new IllegalArgumentException(r0);
            } else {
                obj = tVar.c(object);
            }
        }
        return obj;
    }

    static String e(String str, String str2) {
        String str3;
        return str3;
    }

    private Method f(Class<?> cls, String str, Class<?> cls2) {
        Method declaredMethod;
        Class[] objArr = null;
        int i = 1;
        Class[] arr2;
        int i2;
        d.h.e.t tVar;
        str = s.e(str, this.a);
        objArr = null;
        if (cls2 != null) {
            i = 1;
            Class[] arr = new Class[i];
            i2 = 0;
            if (cls2.equals(Float.class)) {
                arr2 = s.C;
            } else {
                if (cls2.equals(Integer.class)) {
                    arr2 = s.D;
                } else {
                    if (cls2.equals(Double.class)) {
                        arr2 = s.E;
                    } else {
                    }
                }
            }
            length = arr2.length;
            if (i2 < length) {
                final Class cls4 = arr2[i2];
                arr[i2] = cls4;
                try {
                    if (this.B == null) {
                        this.w = cls4;
                    }
                } catch (java.lang.NoSuchMethodException unused) {
                }
                return cls.getMethod(str, arr);
            }
        } else {
            try {
                Method method2 = cls.getMethod(str, null);
            } catch (java.lang.NoSuchMethodException unused) {
            }
        }
        if (objArr == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str7 = "Method ";
            String str9 = s.e(str, this.a);
            String str10 = "() with type ";
            String str11 = " not found on target class ";
            str3 = str7 + str9 + str10 + cls2 + str11 + cls;
            str4 = "PropertyValuesHolder";
            Log.w(str4, str3);
        }
        return objArr;
    }

    public static s j(Property<?, Float> property, float... fArr) {
        return new s.a(property, fArr);
    }

    public static s k(String str, float... fArr) {
        return new s.a(str, fArr);
    }

    public static s l(Property<?, Integer> property, int... iArr) {
        return new s.b(property, iArr);
    }

    public static s m(String str, int... iArr) {
        return new s.b(str, iArr);
    }

    private void s(Class<?> cls) {
        this.v = v(cls, s.G, "get", null);
    }

    private Method v(Class<?> cls, HashMap<Class<?>, HashMap<String, Method>> hashMap, String str, Class<?> cls2) {
        Object value;
        int i = 0;
        int i2 = 0;
        synchronized (hashMap) {
            try {
                value = hashMap.get(cls);
                i = 0;
                i2 = 0;
                if (value != null && value.containsKey(this.a)) {
                    Object value2 = value.get(this.a);
                }
                if (this.a == 0 && value == null) {
                    hashMap.put(cls, new HashMap());
                    value.put(this.a, this.f(cls, str, cls2));
                }
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    void a(float f) {
        Object obj;
        if (this.B != null) {
            obj = this.B.a(this.x.I1(f));
        }
        this.A = obj;
    }

    public s b() {
        try {
            final Object clone = super.clone();
            clone.a = this.a;
            clone.b = this.b;
            clone.x = this.x.clone();
            clone.z = this.z;
        } catch (java.lang.CloneNotSupportedException unused) {
            return null;
        }
        return clone;
    }

    Object d() {
        return this.A;
    }

    public String g() {
        return this.a;
    }

    void h() {
        int i = 0;
        Class<Float> obj;
        if (this.z == null) {
            obj = Integer.class;
            if (this.w == obj) {
                d.h.e.j jVar = j.b();
            } else {
                obj = Float.class;
                if (this.w == obj) {
                    d.h.e.g gVar = g.b();
                } else {
                    i = 0;
                }
            }
            this.z = i;
        }
        if (this.z != null) {
            this.x.l0(this.z);
        }
    }

    void n(Object object) {
        Object obj;
        if (this.b != null) {
            this.b.set(object, d());
        }
        if (this.c != null) {
            try {
                this.y[0] = d();
                this.c.invoke(object, this.y);
            } catch (java.lang.IllegalAccessException illegalAccess) {
                illegalAccess = illegalAccess.toString();
                Log.e(str, illegalAccess);
            } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
                invocationTarget1 = invocationTarget1.toString();
                Log.e(str, invocationTarget1);
            }
        }
    }

    public void o(float... fArr) {
        this.w = Float.TYPE;
        this.x = o.a(fArr);
    }

    public void p(int... iArr) {
        this.w = Integer.TYPE;
        this.x = o.b(iArr);
    }

    public void r(String str) {
        this.a = str;
    }

    void t(Class<?> cls) {
        Class cls2;
        if (this.B == null) {
        } else {
            cls2 = this.B.b();
        }
        this.c = v(cls, s.F, "set", cls2);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = ": ";
        String object = this.x.toString();
        str = this.a + str3 + object;
        return str;
    }

    void u(Object object) {
        List list;
        int size;
        Object item;
        int i;
        Object obj;
        Object obj2;
        Object[] arr;
        boolean z2;
        final boolean z3 = true;
        size = 0;
        if (this.b != null) {
            try {
                List list2 = this.x.q();
                if (list2 == null) {
                } else {
                    size = list2.size();
                }
                i = 0;
                Object item2 = list2.get(size);
                if (!item2.e() || item2.n()) {
                    if (i == 0) {
                        obj = c(this.b.get(object));
                    }
                    item2.l(obj);
                    item2.m(z3);
                }
            } catch (java.lang.IllegalAccessException illegalAccess) {
                Throwable illegalAccess2 = illegalAccess.toString();
                Log.e(str, illegalAccess2);
            } catch (java.lang.reflect.InvocationTargetException invocationTarget1) {
                invocationTarget1 = invocationTarget1.toString();
                Log.e(str, invocationTarget1);
            }
            return;
        }
        if (this.b == null) {
            Class cls = object.getClass();
            if (this.c == null) {
                t(cls);
            }
            list = this.x.q();
            if (list == null) {
            } else {
                size = list.size();
            }
            while (size < size) {
                item = list.get(size);
                if (!item.e() || item.n()) {
                }
                invocationTarget1 = invocationTarget1.toString();
                Log.e(str, invocationTarget1);
                invocationTarget1 = invocationTarget1.toString();
                Log.e(str, invocationTarget1);
            }
        }
    }

    s(Property property) {
        super();
        this.y = new Object[1];
        this.b = property;
        if (property != null) {
            this.a = property.getName();
        }
    }
}
