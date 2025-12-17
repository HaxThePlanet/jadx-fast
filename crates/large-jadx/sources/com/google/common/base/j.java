package com.google.common.base;

import java.util.Arrays;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class j {

    static class a {
    }

    public static final class b {

        private static boolean e;
        private final String a;
        private final com.google.common.base.j.b.a b;
        private com.google.common.base.j.b.a c;
        private boolean d;
        private b(String string) {
            super();
            j.b.a aVar = new j.b.a(0);
            this.b = aVar;
            this.c = aVar;
            this.d = false;
            j.b.j();
            n.o(string);
            this.a = (String)string;
        }

        b(String string, com.google.common.base.j.a j$a2) {
            super(string);
        }

        private com.google.common.base.j.b.a f() {
            j.b.a aVar = new j.b.a(0);
            aVar2.c = aVar;
            this.c = aVar;
            return aVar;
        }

        private com.google.common.base.j.b g(Object object) {
            aVar.b = object;
            return this;
        }

        private com.google.common.base.j.b h(String string, Object object2) {
            final com.google.common.base.j.b.a aVar = f();
            aVar.b = object2;
            n.o(string);
            aVar.a = (String)string;
            return this;
        }

        private static void j() {
            Class<com.google.common.base.j.b> obj;
            int i;
            Exception exception;
            String str;
            obj = j.b.class;
            if (j.b.e) {
            }
            synchronized (obj) {
            }
        }

        public com.google.common.base.j.b a(String string, double d2) {
            h(string, String.valueOf(d2));
            return this;
        }

        public com.google.common.base.j.b b(String string, int i2) {
            h(string, String.valueOf(i2));
            return this;
        }

        public com.google.common.base.j.b c(String string, long l2) {
            h(string, String.valueOf(l2));
            return this;
        }

        public com.google.common.base.j.b d(String string, Object object2) {
            h(string, object2);
            return this;
        }

        public com.google.common.base.j.b e(String string, boolean z2) {
            h(string, String.valueOf(z2));
            return this;
        }

        public com.google.common.base.j.b i(Object object) {
            g(object);
            return this;
        }

        public com.google.common.base.j.b k() {
            this.d = true;
            return this;
        }

        public String toString() {
            com.google.common.base.j.b.a aVar;
            String str;
            String array;
            Object deepToString;
            int i2;
            int i;
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append(this.a);
            stringBuilder.append('{');
            aVar = aVar2.c;
            str = "";
            while (aVar != null) {
                deepToString = aVar.b;
                if (this.d) {
                } else {
                }
                stringBuilder.append(str);
                array = aVar.a;
                if (array != null) {
                }
                if (deepToString != null && deepToString.getClass().isArray()) {
                } else {
                }
                stringBuilder.append(deepToString);
                str = ", ";
                aVar = aVar.c;
                if (deepToString.getClass().isArray()) {
                } else {
                }
                array = 1;
                Object[] arr = new Object[array];
                arr[0] = deepToString;
                deepToString = Arrays.deepToString(arr);
                stringBuilder.append(deepToString, array, length -= array);
                stringBuilder.append(array);
                stringBuilder.append('=');
                stringBuilder.append(str);
                array = aVar.a;
                if (deepToString != null && array != null) {
                }
            }
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    public static <T> T a(T t, T t2) {
        if (t != 0) {
            return t;
        }
        Objects.requireNonNull(t2, "Both parameters are null");
        return t2;
    }

    public static com.google.common.base.j.b b(Class<?> class) {
        j.b bVar = new j.b(class.getSimpleName(), 0);
        return bVar;
    }

    public static com.google.common.base.j.b c(Object object) {
        j.b bVar = new j.b(object.getClass().getSimpleName(), 0);
        return bVar;
    }
}
