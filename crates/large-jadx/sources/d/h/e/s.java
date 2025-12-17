package d.h.e;

import android.util.Log;
import android.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class s implements java.lang.Cloneable {

    private static final Class<?>[] C;
    private static final Class<?>[] D;
    private static final Class<?>[] E;
    static final HashMap<Class<?>, HashMap<String, Method>> F;
    private static final HashMap<Class<?>, HashMap<String, Method>> G;
    private Object A;
    private d.h.e.t B;
    String a;
    Property b;
    Method c = null;
    private Method v = null;
    Class<?> w;
    d.h.e.p x = null;
    final Object[] y;
    private d.h.e.u z;

    static class a extends d.h.e.s {

        private d.h.e.i H;
        d.h.e.p.a I;
        float J;
        a(Property property, float... f2Arr2) {
            boolean obj1;
            super(property);
            o(f2Arr2);
            if (property instanceof i) {
                this.H = (i)this.b;
            }
        }

        a(String string, float... f2Arr2) {
            super(string);
            o(f2Arr2);
        }

        @Override // d.h.e.s
        void a(float f) {
            this.J = this.I.n1(f);
        }

        @Override // d.h.e.s
        public d.h.e.s b() {
            return w();
        }

        @Override // d.h.e.s
        public Object clone() {
            return w();
        }

        @Override // d.h.e.s
        Object d() {
            return Float.valueOf(this.J);
        }

        @Override // d.h.e.s
        void n(Object object) {
            Method method;
            Object[] objArr;
            Float valueOf;
            Object obj5;
            String str = "PropertyValuesHolder";
            d.h.e.i iVar = this.H;
            if (iVar != null) {
                iVar.b(object, this.J);
            }
            Property property = this.b;
            if (property != null) {
                property.set(object, Float.valueOf(this.J));
            }
            if (this.c != null) {
                this.y[0] = Float.valueOf(this.J);
                this.c.invoke(object, this.y);
            }
        }

        @Override // d.h.e.s
        public void o(float... fArr) {
            super.o(fArr);
            this.I = (p.a)this.x;
        }

        @Override // d.h.e.s
        public d.h.e.s.a w() {
            final d.h.e.s sVar = super.b();
            sVar.I = (p.a)sVar.x;
            return (s.a)sVar;
        }
    }

    static class b extends d.h.e.s {

        private d.h.e.l H;
        d.h.e.p.b I;
        int J;
        b(Property property, int... i2Arr2) {
            boolean obj1;
            super(property);
            p(i2Arr2);
            if (property instanceof l) {
                this.H = (l)this.b;
            }
        }

        b(String string, int... i2Arr2) {
            super(string);
            p(i2Arr2);
        }

        @Override // d.h.e.s
        void a(float f) {
            this.J = this.I.N0(f);
        }

        @Override // d.h.e.s
        public d.h.e.s b() {
            return w();
        }

        @Override // d.h.e.s
        public Object clone() {
            return w();
        }

        @Override // d.h.e.s
        Object d() {
            return Integer.valueOf(this.J);
        }

        @Override // d.h.e.s
        void n(Object object) {
            Object obj5;
            String str = "PropertyValuesHolder";
            d.h.e.l lVar = this.H;
            if (lVar != null) {
                lVar.b(object, this.J);
            }
            Property property = this.b;
            if (property != null) {
                property.set(object, Integer.valueOf(this.J));
            }
            this.y[0] = Integer.valueOf(this.J);
            this.c.invoke(object, this.y);
        }

        @Override // d.h.e.s
        public void p(int... iArr) {
            super.p(iArr);
            this.I = (p.b)this.x;
        }

        @Override // d.h.e.s
        public d.h.e.s.b w() {
            final d.h.e.s sVar = super.b();
            sVar.I = (p.b)sVar.x;
            return (s.b)sVar;
        }
    }
    static {
        Class<Integer> obj = Integer.class;
        final Class<Double> obj2 = Double.class;
        final Class<Float> obj3 = Float.class;
        int i = 6;
        Class[] arr2 = new Class[i];
        final Class tYPE = Float.TYPE;
        final int i2 = 0;
        arr2[i2] = tYPE;
        final int i3 = 1;
        arr2[i3] = obj3;
        final int i4 = 2;
        arr2[i4] = Double.TYPE;
        Class tYPE3 = Integer.TYPE;
        final int i5 = 3;
        arr2[i5] = tYPE3;
        final int i6 = 4;
        arr2[i6] = obj2;
        final int i7 = 5;
        arr2[i7] = obj;
        s.C = arr2;
        Class[] arr3 = new Class[i];
        arr3[i2] = tYPE3;
        arr3[i3] = obj;
        arr3[i4] = tYPE;
        final Class tYPE4 = Double.TYPE;
        arr3[i5] = tYPE4;
        arr3[i6] = obj3;
        arr3[i7] = obj2;
        s.D = arr3;
        Class[] arr = new Class[i];
        arr[i2] = tYPE4;
        arr[i3] = obj2;
        arr[i4] = tYPE;
        arr[i5] = tYPE3;
        arr[i6] = obj3;
        arr[i7] = obj;
        s.E = arr;
        HashMap hashMap = new HashMap();
        s.F = hashMap;
        HashMap hashMap2 = new HashMap();
        s.G = hashMap2;
    }

    s(Property property) {
        Object obj2;
        super();
        int i = 0;
        this.y = new Object[1];
        this.b = property;
        if (property != null) {
            this.a = property.getName();
        }
    }

    s(String string) {
        super();
        int i = 0;
        this.y = new Object[1];
        this.a = string;
    }

    private Object c(Object object) {
        boolean z;
        Object obj3;
        d.h.e.t tVar = this.B;
        if (tVar != null) {
            if (!tVar instanceof f) {
            } else {
                obj3 = (f)tVar.c(object);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Converter ");
            stringBuilder.append(this.B.getClass().getName());
            stringBuilder.append(" must be a BidirectionalTypeConverter");
            obj3 = new IllegalArgumentException(stringBuilder.toString());
            throw obj3;
        }
        return obj3;
    }

    static String e(String string, String string2) {
        char upperCase;
        StringBuilder stringBuilder;
        String obj2;
        String obj3;
        if (string2 != null) {
            if (string2.length() == 0) {
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(Character.toUpperCase(string2.charAt(0)));
                stringBuilder.append(string2.substring(1));
                obj2 = stringBuilder.toString();
            }
        }
        return obj2;
    }

    private Method f(Class<?> class, String string2, Class<?> class3) {
        Object stringBuilder;
        Method declaredMethod;
        Method method;
        boolean z;
        Class[] arr;
        Class[] arr2;
        int i;
        int length;
        int i2;
        d.h.e.t tVar;
        Object obj11;
        String obj12;
        stringBuilder = s.e(string2, this.a);
        if (class3 == null) {
            method = class.getMethod(stringBuilder, 0);
        } else {
            z = 1;
            arr = new Class[z];
            i = 0;
            if (class3.equals(Float.class)) {
                arr2 = s.C;
            } else {
                if (class3.equals(Integer.class)) {
                    arr2 = s.D;
                } else {
                    if (class3.equals(Double.class)) {
                        arr2 = s.E;
                    } else {
                        new Class[z][i] = class3;
                    }
                }
            }
            try {
                i2 = i;
                final Class cls = arr2[i2];
                arr[i] = cls;
                if (this.B == null) {
                }
                this.w = cls;
            } catch (java.lang.NoSuchMethodException noSuchMethod) {
            }
        }
        if (method == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Method ");
            stringBuilder.append(s.e(string2, this.a));
            stringBuilder.append("() with type ");
            stringBuilder.append(class3);
            stringBuilder.append(" not found on target class ");
            stringBuilder.append(class);
            Log.w("PropertyValuesHolder", stringBuilder.toString());
        }
        return method;
    }

    public static d.h.e.s j(Property<?, Float> property, float... f2Arr2) {
        s.a aVar = new s.a(property, f2Arr2);
        return aVar;
    }

    public static d.h.e.s k(String string, float... f2Arr2) {
        s.a aVar = new s.a(string, f2Arr2);
        return aVar;
    }

    public static d.h.e.s l(Property<?, Integer> property, int... i2Arr2) {
        s.b bVar = new s.b(property, i2Arr2);
        return bVar;
    }

    public static d.h.e.s m(String string, int... i2Arr2) {
        s.b bVar = new s.b(string, i2Arr2);
        return bVar;
    }

    private void s(Class<?> class) {
        this.v = v(class, s.G, "get", 0);
    }

    private Method v(Class<?> class, HashMap<Class<?>, HashMap<String, Method>> hashMap2, String string3, Class<?> class4) {
        Object hashMap;
        int key;
        int i;
        Object obj4;
        hashMap = hashMap2.get(class);
        key = 0;
        i = 0;
        synchronized (hashMap2) {
            try {
                if ((HashMap)hashMap.containsKey(this.a)) {
                }
                i = hashMap.get(this.a);
                if (key == null && hashMap == null) {
                }
                if (hashMap == null) {
                }
                hashMap = new HashMap();
                hashMap2.put(class, hashMap);
                hashMap.put(this.a, f(class, string3, class4));
                return i;
                throw class;
            }
        }
    }

    @Override // java.lang.Cloneable
    void a(float f) {
        Object obj2;
        d.h.e.t tVar = this.B;
        if (tVar == null) {
        } else {
            obj2 = tVar.a(this.x.I1(f));
        }
        this.A = obj2;
    }

    @Override // java.lang.Cloneable
    public d.h.e.s b() {
        try {
            final Object clone = super.clone();
            clone.a = this.a;
            clone.b = this.b;
            clone.x = this.x.clone();
            clone.z = this.z;
            return (s)clone;
            return null;
        }
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return b();
    }

    @Override // java.lang.Cloneable
    Object d() {
        return this.A;
    }

    @Override // java.lang.Cloneable
    public String g() {
        return this.a;
    }

    @Override // java.lang.Cloneable
    void h() {
        d.h.e.u uVar;
        Class<Float> obj;
        if (this.z == null) {
            Class cls = this.w;
            if (cls == Integer.class) {
                uVar = j.b();
            } else {
                if (cls == Float.class) {
                    uVar = g.b();
                } else {
                    uVar = 0;
                }
            }
            this.z = uVar;
        }
        d.h.e.u uVar2 = this.z;
        if (uVar2 != null) {
            this.x.l0(uVar2);
        }
    }

    @Override // java.lang.Cloneable
    void n(Object object) {
        Method method;
        Object obj;
        Object obj2;
        Object obj5;
        final String str = "PropertyValuesHolder";
        Property property = this.b;
        if (property != null) {
            property.set(object, d());
        }
        if (this.c != null) {
            this.y[0] = d();
            this.c.invoke(object, this.y);
        }
    }

    @Override // java.lang.Cloneable
    public void o(float... fArr) {
        this.w = Float.TYPE;
        this.x = o.a(fArr);
    }

    @Override // java.lang.Cloneable
    public void p(int... iArr) {
        this.w = Integer.TYPE;
        this.x = o.b(iArr);
    }

    @Override // java.lang.Cloneable
    public void r(String string) {
        this.a = string;
    }

    void t(Class<?> class) {
        Class cls;
        d.h.e.t tVar = this.B;
        if (tVar == null) {
            cls = this.w;
        } else {
            cls = tVar.b();
        }
        this.c = v(class, s.F, "set", cls);
    }

    @Override // java.lang.Cloneable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(": ");
        stringBuilder.append(this.x.toString());
        return stringBuilder.toString();
    }

    @Override // java.lang.Cloneable
    void u(Object object) {
        Object class;
        StringBuilder string;
        String size2;
        int size;
        int i;
        int i3;
        Object string2;
        int i2;
        Object obj;
        Method method;
        Object[] arr;
        final String str = "PropertyValuesHolder";
        final int i5 = 1;
        final int i6 = 0;
        if (this.b != null) {
            List list = this.x.q();
            if (list == null) {
                size = i6;
            } else {
                size = list.size();
            }
            i2 = i4;
            i3 = i6;
            while (i3 < size) {
                obj = list.get(i3);
                if ((n)obj.e()) {
                } else {
                }
                if (i2 == 0) {
                }
                obj.l(i2);
                obj.m(i5);
                i3++;
                i2 = c(this.b.get(object));
                if (obj.n() && i2 == 0) {
                }
            }
        }
        class = object.getClass();
        if (this.b == null && this.c == null) {
            class = object.getClass();
            if (this.c == null) {
                t(class);
            }
            string = this.x.q();
            if (string == null) {
                size2 = i6;
            } else {
                size2 = string.size();
            }
            i = i6;
            while (i < size2) {
                string2 = string.get(i);
                string2.l(c(this.v.invoke(object, new Object[i6])));
                string2.m(i5);
                i++;
                s(class);
                string2 = string2.toString();
                Log.e(obj1, string2);
                string2 = string2.toString();
                Log.e(obj1, string2);
            }
        }
    }
}
