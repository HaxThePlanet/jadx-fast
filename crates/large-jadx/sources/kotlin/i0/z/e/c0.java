package kotlin.i0.z.e;

import java.lang.ref.SoftReference;
import kotlin.d0.c.a;

/* loaded from: classes3.dex */
public class c0 {

    public static abstract class c {

        private static final Object a;
        static {
            c0.c.a aVar = new c0.c.a();
            c0.c.a = aVar;
        }

        protected Object a(T t) {
            Object obj1;
            if (t == null) {
                obj1 = c0.c.a;
            }
            return obj1;
        }

        public final T b(Object object, Object object2) {
            return invoke();
        }

        protected T c(Object object) {
            Object obj2;
            if (object == c0.c.a) {
                obj2 = 0;
            }
            return obj2;
        }

        public abstract T invoke();
    }

    public static class b extends kotlin.i0.z.e.c0.c<T> {

        private final a<T> b;
        private volatile Object c = null;
        public b(a<T> a) {
            if (a == null) {
            } else {
                super();
                this.b = a;
            }
            c0.b.e(0);
            throw 0;
        }

        private static void e(int i) {
            Object[] obj2 = new Object[3];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazyVal", "<init>"));
            throw illegalArgumentException;
        }

        public T invoke() {
            Object obj = this.c;
            if (obj != null) {
                return c(obj);
            }
            Object invoke = this.b.invoke();
            this.c = a(invoke);
            return invoke;
        }
    }

    public static class a extends kotlin.i0.z.e.c0.c<T> implements a<T> {

        private final a<T> b;
        private volatile SoftReference<Object> c = null;
        public a(T t, a<T> a2) {
            Object obj2;
            Object obj3;
            if (a2 == null) {
            } else {
                super();
                this.b = a2;
                if (t != null) {
                    obj3 = new SoftReference(a(t));
                    this.c = obj3;
                }
            }
            c0.a.e(0);
            throw 0;
        }

        private static void e(int i) {
            Object[] obj2 = new Object[3];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "initializer", "kotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal", "<init>"));
            throw illegalArgumentException;
        }

        public T invoke() {
            Object softReference;
            softReference = this.c;
            softReference = softReference.get();
            if (softReference != null && softReference != null) {
                softReference = softReference.get();
                if (softReference != null) {
                    return c(softReference);
                }
            }
            Object invoke = this.b.invoke();
            SoftReference softReference2 = new SoftReference(a(invoke));
            this.c = softReference2;
            return invoke;
        }
    }
    private static void a(int i) {
        String obj3;
        Object[] arr = new Object[3];
        int i5 = 1;
        arr[i5] = "kotlin/reflect/jvm/internal/ReflectProperties";
        int i4 = 2;
        if (i != i5 && i != i4) {
            if (i != i4) {
                arr[i4] = "lazy";
            } else {
                arr[i4] = "lazySoft";
            }
        } else {
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    public static <T> kotlin.i0.z.e.c0.b<T> b(a<T> a) {
        if (a == null) {
        } else {
            c0.b bVar = new c0.b(a);
            return bVar;
        }
        c0.a(0);
        throw 0;
    }

    public static <T> kotlin.i0.z.e.c0.a<T> c(T t, a<T> a2) {
        if (a2 == null) {
        } else {
            c0.a aVar = new c0.a(t, a2);
            return aVar;
        }
        c0.a(1);
        throw 0;
    }

    public static <T> kotlin.i0.z.e.c0.a<T> d(a<T> a) {
        final int i = 0;
        if (a == null) {
        } else {
            return c0.c(i, a);
        }
        c0.a(2);
        throw i;
    }
}
