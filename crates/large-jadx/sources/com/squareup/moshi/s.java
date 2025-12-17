package com.squareup.moshi;

import com.squareup.moshi.v.b;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
final class s {

    public static final com.squareup.moshi.f.d a;
    static final com.squareup.moshi.f<Boolean> b;
    static final com.squareup.moshi.f<Byte> c;
    static final com.squareup.moshi.f<Character> d;
    static final com.squareup.moshi.f<Double> e;
    static final com.squareup.moshi.f<Float> f;
    static final com.squareup.moshi.f<Integer> g;
    static final com.squareup.moshi.f<Long> h;
    static final com.squareup.moshi.f<Short> i;
    static final com.squareup.moshi.f<String> j;

    static class b {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            s.b.a = iArr;
            iArr[i.b.BEGIN_ARRAY.ordinal()] = 1;
            s.b.a[i.b.BEGIN_OBJECT.ordinal()] = 2;
            s.b.a[i.b.STRING.ordinal()] = 3;
            s.b.a[i.b.NUMBER.ordinal()] = 4;
            s.b.a[i.b.BOOLEAN.ordinal()] = 5;
            s.b.a[i.b.NULL.ordinal()] = 6;
        }
    }

    class a extends com.squareup.moshi.f<String> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (String)object2);
        }

        @Override // com.squareup.moshi.f
        public String k(com.squareup.moshi.i i) {
            return i.w();
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, String string2) {
            o.L(string2);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(String)";
        }
    }

    class c implements com.squareup.moshi.f.d {
        public com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set2, com.squareup.moshi.r r3) {
            final int i = 0;
            if (!set2.isEmpty()) {
                return i;
            }
            if (type == Boolean.TYPE) {
                return s.b;
            }
            if (type == Byte.TYPE) {
                return s.c;
            }
            if (type == Character.TYPE) {
                return s.d;
            }
            if (type == Double.TYPE) {
                return s.e;
            }
            if (type == Float.TYPE) {
                return s.f;
            }
            if (type == Integer.TYPE) {
                return s.g;
            }
            if (type == Long.TYPE) {
                return s.h;
            }
            if (type == Short.TYPE) {
                return s.i;
            }
            if (type == Boolean.class) {
                return s.b.f();
            }
            if (type == Byte.class) {
                return s.c.f();
            }
            if (type == Character.class) {
                return s.d.f();
            }
            if (type == Double.class) {
                return s.e.f();
            }
            if (type == Float.class) {
                return s.f.f();
            }
            if (type == Integer.class) {
                return s.g.f();
            }
            if (type == Long.class) {
                return s.h.f();
            }
            if (type == Short.class) {
                return s.i.f();
            }
            if (type == String.class) {
                return s.j.f();
            }
            if (type == Object.class) {
                s.m obj2 = new s.m(r3);
                return obj2.f();
            }
            Class obj3 = t.g(type);
            obj2 = b.d(r3, type, obj3);
            if (obj2 != null) {
                return obj2;
            }
            if (obj3.isEnum()) {
                obj2 = new s.l(obj3);
                return obj2.f();
            }
            return i;
        }
    }

    class d extends com.squareup.moshi.f<Boolean> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Boolean)object2);
        }

        @Override // com.squareup.moshi.f
        public Boolean k(com.squareup.moshi.i i) {
            return Boolean.valueOf(i.m());
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Boolean boolean2) {
            o.M(boolean2.booleanValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    class e extends com.squareup.moshi.f<Byte> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Byte)object2);
        }

        @Override // com.squareup.moshi.f
        public Byte k(com.squareup.moshi.i i) {
            return Byte.valueOf((byte)obj4);
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Byte byte2) {
            o.J((long)obj4);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    class f extends com.squareup.moshi.f<Character> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Character)object2);
        }

        @Override // com.squareup.moshi.f
        public Character k(com.squareup.moshi.i i) {
            String str = i.w();
            int i3 = 0;
            final int i4 = 1;
            if (str.length() > i4) {
            } else {
                return Character.valueOf(str.charAt(i3));
            }
            Object[] arr = new Object[3];
            arr[i3] = "a char";
            StringBuilder stringBuilder = new StringBuilder();
            int i6 = 34;
            stringBuilder.append(i6);
            stringBuilder.append(str);
            stringBuilder.append(i6);
            arr[i4] = stringBuilder.toString();
            arr[2] = i.getPath();
            JsonDataException jsonDataException = new JsonDataException(String.format("Expected %s but was %s at path %s", arr));
            throw jsonDataException;
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Character character2) {
            o.L(character2.toString());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Character)";
        }
    }

    class g extends com.squareup.moshi.f<Double> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Double)object2);
        }

        @Override // com.squareup.moshi.f
        public Double k(com.squareup.moshi.i i) {
            return Double.valueOf(i.n());
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Double double2) {
            o.H(double2.doubleValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Double)";
        }
    }

    class h extends com.squareup.moshi.f<Float> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Float)object2);
        }

        @Override // com.squareup.moshi.f
        public Float k(com.squareup.moshi.i i) {
            boolean infinite;
            float f = (float)d;
            if (!i.k()) {
                if (Float.isInfinite(f)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("JSON forbids NaN and infinities: ");
                stringBuilder.append(f);
                stringBuilder.append(" at path ");
                stringBuilder.append(i.getPath());
                JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
                throw jsonDataException;
            }
            return Float.valueOf(f);
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Float float2) {
            Objects.requireNonNull(float2);
            o.K(float2);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Float)";
        }
    }

    class i extends com.squareup.moshi.f<Integer> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Integer)object2);
        }

        @Override // com.squareup.moshi.f
        public Integer k(com.squareup.moshi.i i) {
            return Integer.valueOf(i.o());
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Integer integer2) {
            o.J((long)obj4);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    class j extends com.squareup.moshi.f<Long> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Long)object2);
        }

        @Override // com.squareup.moshi.f
        public Long k(com.squareup.moshi.i i) {
            return Long.valueOf(i.q());
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Long long2) {
            o.J(long2.longValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Long)";
        }
    }

    class k extends com.squareup.moshi.f<Short> {
        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Short)object2);
        }

        @Override // com.squareup.moshi.f
        public Short k(com.squareup.moshi.i i) {
            return Short.valueOf((short)obj4);
        }

        @Override // com.squareup.moshi.f
        public void l(com.squareup.moshi.o o, Short short2) {
            o.J((long)obj4);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Short)";
        }
    }

    static final class l extends com.squareup.moshi.f<T> {

        private final Class<T> a;
        private final String[] b;
        private final T[] c;
        private final com.squareup.moshi.i.a d;
        l(Class<T> class) {
            int i;
            Object assertionError;
            StringBuilder stringBuilder;
            String str;
            super();
            this.a = class;
            Object[] enumConstants = class.getEnumConstants();
            this.c = (Enum[])enumConstants;
            this.b = new String[enumConstants.length];
            i = 0;
            Enum[] objArr = this.c;
            while (i < objArr.length) {
                Enum obj = objArr[i];
                Annotation annotation = class.getField(obj.name()).getAnnotation(e.class);
                if ((e)annotation != null) {
                } else {
                }
                assertionError = obj.name();
                this.b[i] = assertionError;
                i++;
                objArr = this.c;
                assertionError = (e)annotation.name();
            }
            this.d = i.a.a(this.b);
        }

        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            return k(i);
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            l(o, (Enum)object2);
        }

        public T k(com.squareup.moshi.i i) {
            int i2 = i.K(this.d);
            if (i2 == -1) {
            } else {
                return this.c[i2];
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected one of ");
            stringBuilder.append(Arrays.asList(this.b));
            stringBuilder.append(" but was ");
            stringBuilder.append(i.w());
            stringBuilder.append(" at path ");
            stringBuilder.append(i.getPath());
            JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
            throw jsonDataException;
        }

        public void l(com.squareup.moshi.o o, T t2) {
            o.L(this.b[t2.ordinal()]);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("JsonAdapter(");
            stringBuilder.append(this.a.getName());
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class m extends com.squareup.moshi.f<Object> {

        private final com.squareup.moshi.r a;
        private final com.squareup.moshi.f<List> b;
        private final com.squareup.moshi.f<Map> c;
        private final com.squareup.moshi.f<String> d;
        private final com.squareup.moshi.f<Double> e;
        private final com.squareup.moshi.f<Boolean> f;
        m(com.squareup.moshi.r r) {
            super();
            this.a = r;
            this.b = r.c(List.class);
            this.c = r.c(Map.class);
            this.d = r.c(String.class);
            this.e = r.c(Double.class);
            this.f = r.c(Boolean.class);
        }

        private Class<?> k(Class<?> class) {
            Class obj2;
            if (Map.class.isAssignableFrom(class)) {
                return Map.class;
            }
            if (Collection.class.isAssignableFrom(class)) {
                obj2 = Collection.class;
            }
            return obj2;
        }

        @Override // com.squareup.moshi.f
        public Object b(com.squareup.moshi.i i) {
            int i2;
            switch (i3) {
                case 1:
                    return this.b.b(i);
                case 2:
                    return this.c.b(i);
                case 3:
                    return this.d.b(i);
                case 4:
                    return this.e.b(i);
                case 5:
                    return this.f.b(i);
                case 6:
                    return i.r();
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Expected a value but was ");
                    stringBuilder.append(i.E());
                    stringBuilder.append(" at path ");
                    stringBuilder.append(i.getPath());
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                    throw illegalStateException;
            }
        }

        @Override // com.squareup.moshi.f
        public void i(com.squareup.moshi.o o, Object object2) {
            Object class;
            Class<Object> obj;
            Set set;
            class = object2.getClass();
            if (class == Object.class) {
                o.c();
                o.i();
            } else {
                this.a.e(k(class), b.a).i(o, object2);
            }
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Object)";
        }
    }
    static {
        s.c cVar = new s.c();
        s.a = cVar;
        s.d dVar = new s.d();
        s.b = dVar;
        s.e eVar = new s.e();
        s.c = eVar;
        s.f fVar = new s.f();
        s.d = fVar;
        s.g gVar = new s.g();
        s.e = gVar;
        s.h hVar = new s.h();
        s.f = hVar;
        s.i iVar = new s.i();
        s.g = iVar;
        s.j jVar = new s.j();
        s.h = jVar;
        s.k kVar = new s.k();
        s.i = kVar;
        s.a aVar = new s.a();
        s.j = aVar;
    }

    static int a(com.squareup.moshi.i i, String string2, int i3, int i4) {
        int i2 = i.o();
        if (i2 < i3) {
        } else {
            if (i2 > i4) {
            } else {
                return i2;
            }
        }
        Object[] obj5 = new Object[3];
        JsonDataException obj4 = new JsonDataException(String.format("Expected %s but was %s at path %s", string2, Integer.valueOf(i2), i.getPath()));
        throw obj4;
    }
}
