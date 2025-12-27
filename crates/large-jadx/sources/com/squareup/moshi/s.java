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

/* compiled from: StandardJsonAdapters.java */
/* loaded from: classes2.dex */
final class s {

    public static final f.d a = new s$c();
    static final f<Boolean> b = new s$d<>();
    static final f<Byte> c = new s$e<>();
    static final f<Character> d = new s$f<>();
    static final f<Double> e = new s$g<>();
    static final f<Float> f = new s$h<>();
    static final f<Integer> g = new s$i<>();
    static final f<Long> h = new s$j<>();
    static final f<Short> i = new s$k<>();
    static final f<String> j = new s$a<>();

    static class b {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[i.b.values().length];
            s.b.a = iArr;
            try {
                iArr[i.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s.b.a[i.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s.b.a[i.b.STRING.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s.b.a[i.b.NUMBER.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s.b.a[i.b.BOOLEAN.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                s.b.a[i.b.NULL.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    class a extends f<String> {
        a() {
            super();
        }

        @Override // com.squareup.moshi.f
        public String k(i iVar) {
            return iVar.w();
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, String str) {
            oVar.L(str);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(String)";
        }
    }

    class c implements f.d {
        c() {
            super();
        }

        public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            final int i = 0;
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return s.b;
            }
            if (s.b == Byte.TYPE) {
                return s.c;
            }
            if (s.c == Character.TYPE) {
                return s.d;
            }
            if (s.c == Double.TYPE) {
                return s.e;
            }
            if (s.c == Float.TYPE) {
                return s.f;
            }
            if (s.c == Integer.TYPE) {
                return s.g;
            }
            if (s.c == Long.TYPE) {
                return s.h;
            }
            if (s.c == Short.TYPE) {
                return s.i;
            }
            if (s.c == Boolean.class) {
                return s.b.f();
            }
            if (s.c == Byte.class) {
                return s.c.f();
            }
            if (s.c == Character.class) {
                return s.d.f();
            }
            if (s.c == Double.class) {
                return s.e.f();
            }
            if (s.e == Float.class) {
                return s.f.f();
            }
            if (s.c == Integer.class) {
                return s.g.f();
            }
            if (s.c == Long.class) {
                return s.h.f();
            }
            if (s.c == Short.class) {
                return s.i.f();
            }
            if (s.c == String.class) {
                return s.j.f();
            }
            if (s.c == Object.class) {
                return new s.m(rVar).f();
            }
            Class cls = t.g(type);
            com.squareup.moshi.f fVar9 = b.d(rVar, type, cls);
            if (fVar9 != null) {
                return fVar9;
            }
            if (cls.isEnum()) {
                return new s.l(cls).f();
            }
            return i;
        }
    }

    class d extends f<Boolean> {
        d() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Boolean k(i iVar) {
            return Boolean.valueOf(iVar.m());
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Boolean boolean) {
            oVar.M(boolean.booleanValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    class e extends f<Byte> {
        e() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Byte k(i iVar) {
            return Byte.valueOf((byte)(s.a(iVar, "a byte", -128, 255)));
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Byte byte) {
            oVar.J((long)(byte.intValue() & 255));
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    class f extends f<Character> {
        f() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Character k(i iVar) throws JsonDataException {
            String str = iVar.w();
            int i2 = 0;
            final int i3 = 1;
            if (str.length() > i3) {
                Object[] arr = new Object[3];
                StringBuilder stringBuilder = new StringBuilder();
                char c = '"';
                str2 = c + str + c;
                throw new JsonDataException(String.format("Expected %s but was %s at path %s", new Object[] { "a char", str2, iVar.getPath() }));
            } else {
                return Character.valueOf(str.charAt(i2));
            }
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Character character) {
            oVar.L(character.toString());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Character)";
        }
    }

    class g extends f<Double> {
        g() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Double k(i iVar) {
            return Double.valueOf(iVar.n());
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Double double) {
            oVar.H(double.doubleValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Double)";
        }
    }

    class h extends f<Float> {
        h() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Float k(i iVar) throws JsonDataException {
            float f = (float)iVar.n();
            return Float.valueOf(f);
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Float float) {
            Objects.requireNonNull(float);
            oVar.K(float);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Float)";
        }
    }

    class i extends f<Integer> {
        i() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Integer k(i iVar) {
            return Integer.valueOf(iVar.o());
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Integer integer) {
            oVar.J((long)integer.intValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    class j extends f<Long> {
        j() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Long k(i iVar) {
            return Long.valueOf(iVar.q());
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Long long) {
            oVar.J(long.longValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Long)";
        }
    }

    class k extends f<Short> {
        k() {
            super();
        }

        @Override // com.squareup.moshi.f
        public Short k(i iVar) {
            return Short.valueOf((short)(s.a(iVar, "a short", -32768, 32767)));
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, Short short) {
            oVar.J((long)short.intValue());
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Short)";
        }
    }

    static final class l<T extends Enum<T>> extends f<T> {

        private final Class<T> a;
        private final String[] b;
        private final T[] c;
        private final i.a d;
        l(Class<T> cls) {
            int i = 0;
            String name;
            super();
            this.a = cls;
            try {
                Object[] enumConstants = cls.getEnumConstants();
                this.c = enumConstants;
                this.b = new String[enumConstants.length];
                i = 0;
                while (new String[enumConstants.length] < objArr.length) {
                    Enum obj = objArr[i];
                    cls2 = e.class;
                    Annotation annotation = cls.getField(obj.name()).getAnnotation(cls2);
                    if (annotation != null) {
                        name = annotation.name();
                    } else {
                        name = obj.name();
                    }
                    this.b[i] = name;
                    i = i + 1;
                }
                this.d = i.a.a(this.b);
            } catch (java.lang.NoSuchFieldException noSuchField) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Missing field in ";
                cls = cls.getName();
                cls = str + cls;
                throw new AssertionError(cls, noSuchField);
            }
        }

        @Override // com.squareup.moshi.f
        public T k(i iVar) throws JsonDataException {
            int i = iVar.K(this.d);
            if (i == -1) {
                String path = iVar.getPath();
                String str3 = iVar.w();
                final StringBuilder stringBuilder = new StringBuilder();
                String str = "Expected one of ";
                List list = Arrays.asList(this.b);
                String str2 = " but was ";
                String str4 = " at path ";
                iVar = str + list + str2 + str3 + str4 + path;
                throw new JsonDataException(iVar);
            } else {
                return this.c[i];
            }
        }

        @Override // com.squareup.moshi.f
        public void l(o oVar, T t) {
            oVar.L(this.b[t.ordinal()]);
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "JsonAdapter(";
            String name = this.a.getName();
            String str3 = ")";
            str = str2 + name + str3;
            return str;
        }
    }

    static final class m extends f<Object> {

        private final r a;
        private final f<List> b;
        private final f<Map> c;
        private final f<String> d;
        private final f<Double> e;
        private final f<Boolean> f;
        m(r rVar) {
            super();
            this.a = rVar;
            this.b = rVar.c(List.class);
            this.c = rVar.c(Map.class);
            this.d = rVar.c(String.class);
            this.e = rVar.c(Double.class);
            this.f = rVar.c(Boolean.class);
        }

        private Class<?> k(Class<?> cls) {
            Class<java.util.Collection> obj;
            if (Map.class.isAssignableFrom(cls)) {
                return Map.class;
            }
            if (Collection.class.isAssignableFrom(cls)) {
                obj = Collection.class;
            }
            return obj;
        }

        @Override // com.squareup.moshi.f
        public Object b(i iVar) {
            switch (s.b.a[iVar.E().ordinal()]) {
                case 1: /* ordinal */
                    return this.b.b(iVar);
                case 2: /* ordinal */
                    return this.c.b(iVar);
                case 3: /* ordinal */
                    return this.d.b(iVar);
                case 4: /* ordinal */
                    return this.e.b(iVar);
                case 5: /* ordinal */
                    return this.f.b(iVar);
                case 6: /* ordinal */
                    return iVar.r();
                default:
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Expected a value but was ";
                    com.squareup.moshi.i.b bVar2 = iVar.E();
                    String str2 = " at path ";
                    String path = iVar.getPath();
                    iVar = str + bVar2 + str2 + path;
                    throw new IllegalStateException(str + bVar2 + str2 + path);
            }
        }

        @Override // com.squareup.moshi.f
        public void i(o oVar, Object object) {
            Class cls = object.getClass();
            obj = Object.class;
            if (cls == obj) {
                oVar.c();
                oVar.i();
            } else {
                this.a.e(k(cls), b.a).i(oVar, object);
            }
        }

        @Override // com.squareup.moshi.f
        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    static int a(i iVar, String str, int i, int i2) throws JsonDataException {
        i = iVar.o();
        if (i < i) {
            Object[] arr = new Object[3];
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", new Object[] { str, Integer.valueOf(i), iVar.getPath() }));
        } else {
            if (i <= i2) {
                return i;
            }
        }
    }
}
