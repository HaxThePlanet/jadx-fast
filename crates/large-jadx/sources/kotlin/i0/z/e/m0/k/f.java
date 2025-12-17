package kotlin.i0.z.e.m0.k;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.k0.l;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.reflect.jvm.internal.impl.utils.c;
import kotlin.w;

/* loaded from: classes3.dex */
public class f implements kotlin.i0.z.e.m0.k.n {

    private static final String d;
    public static final kotlin.i0.z.e.m0.k.n e;
    protected final kotlin.i0.z.e.m0.k.k a;
    private final kotlin.i0.z.e.m0.k.f.f b;
    private final String c;

    public interface f {

        public static final kotlin.i0.z.e.m0.k.f.f a;
        static {
            f.f.a aVar = new f.f.a();
            f.f.a = aVar;
        }

        public abstract RuntimeException a(Throwable throwable);
    }

    private static class g {

        private final K a;
        private final a<? extends V> b;
        public g(K k, a<? extends V> a2) {
            super();
            this.a = k;
            this.b = a2;
        }

        static a a(kotlin.i0.z.e.m0.k.f.g f$g) {
            return g.b;
        }

        public boolean equals(Object object) {
            Class<kotlin.i0.z.e.m0.k.f.g> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (f.g.class != object.getClass()) {
                } else {
                    if (!this.a.equals(object.a)) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    private static enum n {

        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED;
    }

    private static class o {

        private final T a;
        private final boolean b;
        static {
        }

        private o(T t, boolean z2) {
            super();
            this.a = t;
            this.b = z2;
        }

        public static <T> kotlin.i0.z.e.m0.k.f.o<T> a() {
            f.o oVar = new f.o(0, 1);
            return oVar;
        }

        public static <T> kotlin.i0.z.e.m0.k.f.o<T> d(T t) {
            f.o oVar = new f.o(t, 0);
            return oVar;
        }

        public T b() {
            return this.a;
        }

        public boolean c() {
            return this.b;
        }

        public String toString() {
            String valueOf;
            if (c()) {
                valueOf = "FALL_THROUGH";
            } else {
                valueOf = String.valueOf(this.a);
            }
            return valueOf;
        }
    }

    static class a extends kotlin.i0.z.e.m0.k.f {
        a(String string, kotlin.i0.z.e.m0.k.f.f f$f2, kotlin.i0.z.e.m0.k.k k3) {
            super(string, f2, k3, 0);
        }

        private static void j(int i) {
            String str2;
            int i2;
            String str;
            Object obj7;
            final int i3 = 1;
            str2 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            final int i4 = 2;
            i2 = i != i3 ? 3 : i4;
            Object[] arr = new Object[i2];
            final String str3 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            int i5 = 0;
            if (i != i3) {
                arr[i5] = "source";
            } else {
                arr[i5] = str3;
            }
            String str4 = "recursionDetectedDefault";
            if (i != i3) {
                arr[i3] = str3;
            } else {
                arr[i3] = str4;
            }
            if (i != i3) {
                arr[i4] = str4;
            }
            String format = String.format(str2, arr);
            if (i != i3) {
                obj7 = new IllegalArgumentException(format);
            } else {
                obj7 = new IllegalStateException(format);
            }
            throw obj7;
        }

        protected <K, V> kotlin.i0.z.e.m0.k.f.o<V> p(String string, K k2) {
            final int obj2 = 0;
            if (string == null) {
            } else {
                kotlin.i0.z.e.m0.k.f.o obj1 = f.o.a();
                if (obj1 == null) {
                } else {
                    return obj1;
                }
                f.a.j(1);
                throw obj2;
            }
            f.a.j(0);
            throw obj2;
        }
    }

    private static class h implements kotlin.i0.z.e.m0.k.j<T> {

        private final kotlin.i0.z.e.m0.k.f a;
        private final a<? extends T> b;
        private volatile Object c = null;
        public h(kotlin.i0.z.e.m0.k.f f, a<? extends T> a2) {
            int i = 0;
            if (f == null) {
            } else {
                if (a2 == null) {
                } else {
                    super();
                    kotlin.i0.z.e.m0.k.f.n nOT_COMPUTED = f.n.NOT_COMPUTED;
                    this.a = f;
                    this.b = a2;
                }
                f.h.a(1);
                throw i;
            }
            f.h.a(0);
            throw i;
        }

        private static void a(int i) {
            String str3;
            int i2;
            String str2;
            String str;
            Object obj8;
            final int i3 = 3;
            final int i4 = 2;
            if (i != i4 && i != i3) {
                str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
            if (i != i4 && i != i3) {
                i2 = i != i3 ? i3 : i4;
            } else {
            }
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            final int i5 = 0;
            final int i6 = 1;
            if (i != i6) {
                if (i != i4 && i != i3) {
                    if (i != i3) {
                        arr[i5] = "storageManager";
                    } else {
                        arr[i5] = str2;
                    }
                } else {
                }
            } else {
                arr[i5] = "computable";
            }
            if (i != i4) {
                if (i != i3) {
                    arr[i6] = str2;
                } else {
                    arr[i6] = "renderDebugInformation";
                }
            } else {
                arr[i6] = "recursionDetected";
            }
            if (i != i4 && i != i3) {
                if (i != i3) {
                    arr[i4] = "<init>";
                }
            }
            String format = String.format(str3, arr);
            if (i != i4 && i != i3) {
                if (i != i3) {
                    obj8 = new IllegalArgumentException(format);
                } else {
                    obj8 = new IllegalStateException(format);
                }
            } else {
            }
            throw obj8;
        }

        protected void b(T t) {
        }

        protected kotlin.i0.z.e.m0.k.f.o<T> c(boolean z) {
            final int i = 0;
            kotlin.i0.z.e.m0.k.f.o obj3 = this.a.p("in a lazy value", i);
            if (obj3 == null) {
            } else {
                return obj3;
            }
            f.h.a(2);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.k.j
        public boolean d() {
            Object obj;
            int i;
            kotlin.i0.z.e.m0.k.f.n nOT_COMPUTED;
            if (this.c != f.n.NOT_COMPUTED && this.c != f.n.COMPUTING) {
                i = this.c != f.n.COMPUTING ? 1 : 0;
            } else {
            }
            return i;
        }

        public T invoke() {
            Object invoke;
            boolean z;
            boolean cOMPUTING;
            kotlin.i0.z.e.m0.k.f.n rECURSION_WAS_DETECTED;
            boolean z2;
            Object obj = this.c;
            if (!obj instanceof f.n) {
                WrappedValues.f(obj);
                return obj;
            }
            fVar.a.lock();
            invoke = this.c;
            if (!invoke instanceof f.n) {
                WrappedValues.f(invoke);
            } else {
                cOMPUTING = f.n.COMPUTING;
                this.c = f.n.RECURSION_WAS_DETECTED;
                rECURSION_WAS_DETECTED = c(true);
                if (invoke == cOMPUTING && !rECURSION_WAS_DETECTED.c()) {
                    this.c = f.n.RECURSION_WAS_DETECTED;
                    rECURSION_WAS_DETECTED = c(true);
                    if (!rECURSION_WAS_DETECTED.c()) {
                        invoke = rECURSION_WAS_DETECTED.b();
                    } else {
                        invoke = c(false);
                        if (invoke == f.n.RECURSION_WAS_DETECTED && !invoke.c()) {
                            invoke = c(false);
                            if (!invoke.c()) {
                                invoke = invoke.b();
                            } else {
                                this.c = cOMPUTING;
                                invoke = this.b.invoke();
                                b(invoke);
                                this.c = invoke;
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
            fVar2.a.unlock();
            return invoke;
        }
    }

    private static class l implements kotlin.i0.z.e.m0.k.h<K, V> {

        private final kotlin.i0.z.e.m0.k.f a;
        private final ConcurrentMap<K, Object> b;
        private final l<? super K, ? extends V> c;
        public l(kotlin.i0.z.e.m0.k.f f, ConcurrentMap<K, Object> concurrentMap2, l<? super K, ? extends V> l3) {
            final int i = 0;
            if (f == null) {
            } else {
                if (concurrentMap2 == null) {
                } else {
                    if (l3 == null) {
                    } else {
                        super();
                        this.a = f;
                        this.b = concurrentMap2;
                        this.c = l3;
                    }
                    f.l.b(2);
                    throw i;
                }
                f.l.b(1);
                throw i;
            }
            f.l.b(0);
            throw i;
        }

        private static void b(int i) {
            String str;
            int i2;
            String str2;
            String str3;
            Object obj9;
            final int i3 = 4;
            final int i4 = 3;
            if (i != i4 && i != i3) {
                str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
            final int i5 = 2;
            if (i != i4 && i != i3) {
                i2 = i != i3 ? i4 : i5;
            } else {
            }
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            final int i6 = 0;
            final int i7 = 1;
            if (i != i7) {
                if (i != i5) {
                    if (i != i4 && i != i3) {
                        if (i != i3) {
                            arr[i6] = "storageManager";
                        } else {
                            arr[i6] = str2;
                        }
                    } else {
                    }
                } else {
                    arr[i6] = "compute";
                }
            } else {
                arr[i6] = "map";
            }
            if (i != i4) {
                if (i != i3) {
                    arr[i7] = str2;
                } else {
                    arr[i7] = "raceCondition";
                }
            } else {
                arr[i7] = "recursionDetected";
            }
            if (i != i4 && i != i3) {
                if (i != i3) {
                    arr[i5] = "<init>";
                }
            }
            String format = String.format(str, arr);
            if (i != i4 && i != i3) {
                if (i != i3) {
                    obj9 = new IllegalArgumentException(format);
                } else {
                    obj9 = new IllegalStateException(format);
                }
            } else {
            }
            throw obj9;
        }

        private java.lang.AssertionError c(K k, Object object2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Race condition detected on input ");
            stringBuilder.append(k);
            stringBuilder.append(". Old value is ");
            stringBuilder.append(object2);
            stringBuilder.append(" under ");
            stringBuilder.append(this.a);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            f.l(assertionError);
            return (AssertionError)assertionError;
        }

        protected kotlin.i0.z.e.m0.k.f.o<V> e(K k, boolean z2) {
            kotlin.i0.z.e.m0.k.f.o obj2 = this.a.p("", k);
            if (obj2 == null) {
            } else {
                return obj2;
            }
            f.l.b(3);
            throw 0;
        }

        public V invoke(K k) {
            kotlin.i0.z.e.m0.k.f.n rECURSION_WAS_DETECTED2;
            Throwable cOMPUTING;
            Throwable rECURSION_WAS_DETECTED;
            boolean cOMPUTING2;
            Object obj6;
            Object obj = this.b.get(k);
            if (obj != null && obj != f.n.COMPUTING) {
                if (obj != f.n.COMPUTING) {
                    return WrappedValues.d(obj);
                }
            }
            fVar.a.lock();
            kotlin.i0.z.e.m0.k.f.n cOMPUTING3 = f.n.COMPUTING;
            rECURSION_WAS_DETECTED2 = f.n.RECURSION_WAS_DETECTED;
            rECURSION_WAS_DETECTED = e(k, true);
            if (this.b.get(k) == cOMPUTING3 && !rECURSION_WAS_DETECTED.c()) {
                rECURSION_WAS_DETECTED2 = f.n.RECURSION_WAS_DETECTED;
                rECURSION_WAS_DETECTED = e(k, true);
                if (!rECURSION_WAS_DETECTED.c()) {
                    obj6 = rECURSION_WAS_DETECTED.b();
                    fVar2.a.unlock();
                    return obj6;
                } else {
                }
            } else {
            }
            int i = 0;
            this.b.put(k, cOMPUTING3);
            Object invoke = this.c.invoke(k);
            Object obj2 = this.b.put(k, WrappedValues.b(invoke));
            if (obj2 != cOMPUTING3) {
            } else {
                obj6.a.unlock();
                return invoke;
            }
            throw c(k, obj2);
        }
    }

    private static class e extends kotlin.i0.z.e.m0.k.f.l<kotlin.i0.z.e.m0.k.f.g<K, V>, V> implements kotlin.i0.z.e.m0.k.b<K, V> {
        private e(kotlin.i0.z.e.m0.k.f f, ConcurrentMap<kotlin.i0.z.e.m0.k.f.g<K, V>, Object> concurrentMap2) {
            int i = 0;
            if (f == null) {
            } else {
                if (concurrentMap2 == null) {
                } else {
                    f.e.a aVar = new f.e.a();
                    super(f, concurrentMap2, aVar);
                }
                f.e.b(1);
                throw i;
            }
            f.e.b(0);
            throw i;
        }

        e(kotlin.i0.z.e.m0.k.f f, ConcurrentMap concurrentMap2, kotlin.i0.z.e.m0.k.f.a f$a3) {
            super(f, concurrentMap2);
        }

        private static void b(int i) {
            String str;
            String obj5;
            Object[] arr = new Object[3];
            final int i3 = 1;
            int i4 = 0;
            final int i5 = 2;
            if (i != i3) {
                if (i != i5) {
                    arr[i4] = "storageManager";
                } else {
                    arr[i4] = "computation";
                }
            } else {
                arr[i4] = "map";
            }
            arr[i3] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != i5) {
                arr[i5] = "<init>";
            } else {
                arr[i5] = "computeIfAbsent";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        public V a(K k, a<? extends V> a2) {
            if (a2 == null) {
            } else {
                f.g gVar = new f.g(k, a2);
                return invoke(gVar);
            }
            f.e.b(2);
            throw 0;
        }
    }

    private static abstract class i extends kotlin.i0.z.e.m0.k.f.h<T> {

        private volatile kotlin.i0.z.e.m0.k.l<T> v = null;
        public i(kotlin.i0.z.e.m0.k.f f, a<? extends T> a2) {
            final int i = 0;
            if (f == null) {
            } else {
                if (a2 == null) {
                } else {
                    super(f, a2);
                }
                f.i.a(1);
                throw i;
            }
            f.i.a(0);
            throw i;
        }

        private static void a(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "storageManager";
            } else {
                arr[i3] = "computable";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            arr[2] = "<init>";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        protected final void b(T t) {
            l lVar = new l(t);
            this.v = lVar;
            e(t);
            this.v = 0;
        }

        protected abstract void e(T t);

        public T invoke() {
            boolean z;
            kotlin.i0.z.e.m0.k.l lVar = this.v;
            if (lVar != null && lVar.b()) {
                if (lVar.b()) {
                    return lVar.a();
                }
            }
            return super.invoke();
        }
    }

    private static class j extends kotlin.i0.z.e.m0.k.f.h<T> implements kotlin.i0.z.e.m0.k.i<T> {
        static {
        }

        public j(kotlin.i0.z.e.m0.k.f f, a<? extends T> a2) {
            final int i = 0;
            if (f == null) {
            } else {
                if (a2 == null) {
                } else {
                    super(f, a2);
                }
                f.j.a(1);
                throw i;
            }
            f.j.a(0);
            throw i;
        }

        private static void a(int i) {
            String str3;
            int i2;
            String str2;
            String str;
            Object obj7;
            final int i3 = 2;
            str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            i2 = i != i3 ? 3 : i3;
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            final int i4 = 0;
            final int i5 = 1;
            if (i != i5) {
                if (i != i3) {
                    arr[i4] = "storageManager";
                } else {
                    arr[i4] = str2;
                }
            } else {
                arr[i4] = "computable";
            }
            if (i != i3) {
                arr[i5] = str2;
            } else {
                arr[i5] = "invoke";
            }
            if (i != i3) {
                arr[i3] = "<init>";
            }
            String format = String.format(str3, arr);
            if (i != i3) {
                obj7 = new IllegalArgumentException(format);
            } else {
                obj7 = new IllegalStateException(format);
            }
            throw obj7;
        }

        public T invoke() {
            Object invoke = super.invoke();
            if (invoke == null) {
            } else {
                return invoke;
            }
            f.j.a(2);
            throw 0;
        }
    }

    private static class m extends kotlin.i0.z.e.m0.k.f.l<K, V> implements kotlin.i0.z.e.m0.k.g<K, V> {
        static {
        }

        public m(kotlin.i0.z.e.m0.k.f f, ConcurrentMap<K, Object> concurrentMap2, l<? super K, ? extends V> l3) {
            final int i = 0;
            if (f == null) {
            } else {
                if (concurrentMap2 == null) {
                } else {
                    if (l3 == null) {
                    } else {
                        super(f, concurrentMap2, l3);
                    }
                    f.m.b(2);
                    throw i;
                }
                f.m.b(1);
                throw i;
            }
            f.m.b(0);
            throw i;
        }

        private static void b(int i) {
            String str;
            int i2;
            String str3;
            String str2;
            Object obj8;
            final int i3 = 3;
            str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            final int i4 = 2;
            i2 = i != i3 ? i3 : i4;
            Object[] arr = new Object[i2];
            str3 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            final int i5 = 1;
            final int i6 = 0;
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        arr[i6] = "storageManager";
                    } else {
                        arr[i6] = str3;
                    }
                } else {
                    arr[i6] = "compute";
                }
            } else {
                arr[i6] = "map";
            }
            if (i != i3) {
                arr[i5] = str3;
            } else {
                arr[i5] = "invoke";
            }
            if (i != i3) {
                arr[i4] = "<init>";
            }
            String format = String.format(str, arr);
            if (i != i3) {
                obj8 = new IllegalArgumentException(format);
            } else {
                obj8 = new IllegalStateException(format);
            }
            throw obj8;
        }

        public V invoke(K k) {
            Object obj1 = super.invoke(k);
            if (obj1 == null) {
            } else {
                return obj1;
            }
            f.m.b(3);
            throw 0;
        }
    }

    class b extends kotlin.i0.z.e.m0.k.f.j<T> {

        final Object v;
        b(kotlin.i0.z.e.m0.k.f f, kotlin.i0.z.e.m0.k.f f2, a a3, Object object4) {
            this.v = object4;
            super(f2, a3);
        }

        private static void a(int i) {
            Object[] obj2 = new Object[2];
            IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
            throw illegalStateException;
        }

        protected kotlin.i0.z.e.m0.k.f.o<T> c(boolean z) {
            kotlin.i0.z.e.m0.k.f.o obj1 = f.o.d(this.v);
            if (obj1 == null) {
            } else {
                return obj1;
            }
            f.b.a(0);
            throw 0;
        }
    }

    private static class d extends kotlin.i0.z.e.m0.k.f.e<K, V> implements kotlin.i0.z.e.m0.k.a<K, V> {
        static {
        }

        private d(kotlin.i0.z.e.m0.k.f f, ConcurrentMap<kotlin.i0.z.e.m0.k.f.g<K, V>, Object> concurrentMap2) {
            final int i = 0;
            if (f == null) {
            } else {
                if (concurrentMap2 == null) {
                } else {
                    super(f, concurrentMap2, i);
                }
                f.d.b(1);
                throw i;
            }
            f.d.b(0);
            throw i;
        }

        d(kotlin.i0.z.e.m0.k.f f, ConcurrentMap concurrentMap2, kotlin.i0.z.e.m0.k.f.a f$a3) {
            super(f, concurrentMap2);
        }

        private static void b(int i) {
            String str3;
            int i2;
            String str2;
            String str;
            Object obj8;
            final int i3 = 3;
            str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            final int i4 = 2;
            i2 = i != i3 ? i3 : i4;
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            final int i5 = 1;
            int i6 = 0;
            if (i != i5) {
                if (i != i4) {
                    if (i != i3) {
                        arr[i6] = "storageManager";
                    } else {
                        arr[i6] = str2;
                    }
                } else {
                    arr[i6] = "computation";
                }
            } else {
                arr[i6] = "map";
            }
            String str4 = "computeIfAbsent";
            if (i != i3) {
                arr[i5] = str2;
            } else {
                arr[i5] = str4;
            }
            if (i != i4) {
                if (i != i3) {
                    arr[i4] = "<init>";
                }
            } else {
                arr[i4] = str4;
            }
            String format = String.format(str3, arr);
            if (i != i3) {
                obj8 = new IllegalArgumentException(format);
            } else {
                obj8 = new IllegalStateException(format);
            }
            throw obj8;
        }

        public V a(K k, a<? extends V> a2) {
            final int i = 0;
            if (a2 == null) {
            } else {
                Object obj2 = super.a(k, a2);
                if (obj2 == null) {
                } else {
                    return obj2;
                }
                f.d.b(3);
                throw i;
            }
            f.d.b(2);
            throw i;
        }
    }

    private static abstract class k extends kotlin.i0.z.e.m0.k.f.i<T> implements kotlin.i0.z.e.m0.k.i<T> {
        static {
        }

        public k(kotlin.i0.z.e.m0.k.f f, a<? extends T> a2) {
            final int i = 0;
            if (f == null) {
            } else {
                if (a2 == null) {
                } else {
                    super(f, a2);
                }
                f.k.a(1);
                throw i;
            }
            f.k.a(0);
            throw i;
        }

        private static void a(int i) {
            String str3;
            int i2;
            String str2;
            String str;
            Object obj7;
            final int i3 = 2;
            str3 = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            i2 = i != i3 ? 3 : i3;
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            final int i4 = 0;
            final int i5 = 1;
            if (i != i5) {
                if (i != i3) {
                    arr[i4] = "storageManager";
                } else {
                    arr[i4] = str2;
                }
            } else {
                arr[i4] = "computable";
            }
            if (i != i3) {
                arr[i5] = str2;
            } else {
                arr[i5] = "invoke";
            }
            if (i != i3) {
                arr[i3] = "<init>";
            }
            String format = String.format(str3, arr);
            if (i != i3) {
                obj7 = new IllegalArgumentException(format);
            } else {
                obj7 = new IllegalStateException(format);
            }
            throw obj7;
        }

        public T invoke() {
            Object invoke = super.invoke();
            if (invoke == null) {
            } else {
                return invoke;
            }
            f.k.a(2);
            throw 0;
        }
    }

    class c extends kotlin.i0.z.e.m0.k.f.k<T> {

        final l w;
        final l x;
        c(kotlin.i0.z.e.m0.k.f f, kotlin.i0.z.e.m0.k.f f2, a a3, l l4, l l5) {
            this.w = l4;
            this.x = l5;
            super(f2, a3);
        }

        private static void a(int i) {
            String str;
            int i2;
            String str2;
            String str3;
            Object obj6;
            final int i3 = 2;
            str = i != i3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            i2 = i != i3 ? i3 : 3;
            Object[] arr = new Object[i2];
            str2 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            int i4 = 0;
            if (i != i3) {
                arr[i4] = str2;
            } else {
                arr[i4] = "value";
            }
            int i5 = 1;
            if (i != i3) {
                arr[i5] = "recursionDetected";
            } else {
                arr[i5] = str2;
            }
            if (i != i3) {
            } else {
                arr[i3] = "doPostCompute";
            }
            String format = String.format(str, arr);
            if (i != i3) {
                obj6 = new IllegalStateException(format);
            } else {
                obj6 = new IllegalArgumentException(format);
            }
            throw obj6;
        }

        protected kotlin.i0.z.e.m0.k.f.o<T> c(boolean z) {
            final l lVar = this.w;
            final int i = 0;
            if (lVar == null) {
                kotlin.i0.z.e.m0.k.f.o obj3 = super.c(z);
                if (obj3 == null) {
                } else {
                    return obj3;
                }
                f.c.a(0);
                throw i;
            }
            obj3 = f.o.d(lVar.invoke(Boolean.valueOf(z)));
            if (obj3 == null) {
            } else {
                return obj3;
            }
            f.c.a(1);
            throw i;
        }

        protected void e(T t) {
            if (t == null) {
            } else {
                this.x.invoke(t);
            }
            f.c.a(2);
            throw 0;
        }
    }
    static {
        f.d = l.Z0(f.class.getCanonicalName(), ".", "");
        f.a aVar = new f.a("NO_LOCKS", f.f.a, e.b);
        f.e = aVar;
    }

    public f(String string) {
        final int i = 0;
        super(string, i, i);
    }

    public f(String string, Runnable runnable2, l<java.lang.InterruptedException, w> l3) {
        super(string, f.f.a, k.a.a(runnable2, l3));
    }

    private f(String string, kotlin.i0.z.e.m0.k.f.f f$f2, kotlin.i0.z.e.m0.k.k k3) {
        final int i = 0;
        if (string == null) {
        } else {
            if (f2 == null) {
            } else {
                if (k3 == null) {
                } else {
                    super();
                    this.a = k3;
                    this.b = f2;
                    this.c = string;
                }
                f.j(6);
                throw i;
            }
            f.j(5);
            throw i;
        }
        f.j(4);
        throw i;
    }

    f(String string, kotlin.i0.z.e.m0.k.f.f f$f2, kotlin.i0.z.e.m0.k.k k3, kotlin.i0.z.e.m0.k.f.a f$a4) {
        super(string, f2, k3);
    }

    private static void j(int i) {
        String str;
        String str3;
        String str2;
        int i2;
        Object obj13;
        final int i4 = 37;
        final int i5 = 20;
        final int i6 = 13;
        final int i7 = 10;
        if (i != i7 && i != i6 && i != i5 && i != i4) {
            if (i != i6) {
                if (i != i5) {
                    str = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
                } else {
                }
            } else {
            }
        } else {
        }
        str3 = 3;
        final int i8 = 2;
        if (i != i7 && i != i6 && i != i5 && i != i4) {
            if (i != i6) {
                if (i != i5) {
                    i2 = i != i4 ? str3 : i8;
                } else {
                }
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i2];
        final String str4 = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
        final String str5 = "compute";
        final int i9 = 1;
        int i10 = 0;
        if (i != i9 && i != str3 && i != 5) {
            if (i != str3) {
                if (i != 5) {
                    if (i != 6) {
                        switch (i) {
                            case 8:
                                arr[i10] = "exceptionHandlingStrategy";
                                break;
                            case 9:
                                arr[i10] = str5;
                                break;
                            case 10:
                                arr[i10] = str4;
                                break;
                            case 11:
                                arr[i10] = "onRecursiveCall";
                                break;
                            case 12:
                                arr[i10] = "map";
                                break;
                            case 13:
                                arr[i10] = "computable";
                                break;
                            case 14:
                                arr[i10] = "postCompute";
                                break;
                            case 15:
                                arr[i10] = "source";
                                break;
                            case 16:
                                arr[i10] = "throwable";
                                break;
                            default:
                                arr[i10] = "debugText";
                        }
                    } else {
                        arr[i10] = "lock";
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        str2 = "sanitizeStackTrace";
        String str6 = "createMemoizedFunctionWithNullableValues";
        final String str7 = "createMemoizedFunction";
        if (i != i7 && i != i6) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        arr[i9] = str4;
                    } else {
                        arr[i9] = str2;
                    }
                } else {
                    arr[i9] = str6;
                }
            } else {
                arr[i9] = str7;
            }
        } else {
        }
        switch (i) {
            case 4:
                arr[i8] = "<init>";
                break;
            case 5:
                arr[i8] = "replaceExceptionHandling";
                break;
            case 6:
                arr[i8] = str7;
                break;
            case 8:
                arr[i8] = str6;
                break;
            case 9:
                arr[i8] = "createLazyValue";
                break;
            case 10:
                arr[i8] = "createRecursionTolerantLazyValue";
                break;
            case 11:
                arr[i8] = "createLazyValueWithPostCompute";
                break;
            case 12:
                arr[i8] = "createNullableLazyValue";
                break;
            case 13:
                arr[i8] = "createRecursionTolerantNullableLazyValue";
                break;
            case 14:
                arr[i8] = "createNullableLazyValueWithPostCompute";
                break;
            case 15:
                arr[i8] = str5;
                break;
            case 16:
                arr[i8] = "recursionDetectedDefault";
                break;
            case 17:
                arr[i8] = str2;
                break;
            default:
                arr[i8] = "createWithExceptionHandling";
        }
        String format = String.format(str, arr);
        if (i != i7 && i != i6 && i != i5 && i != i4) {
            if (i != i6) {
                if (i != i5) {
                    if (i != i4) {
                        obj13 = new IllegalArgumentException(format);
                    } else {
                        obj13 = new IllegalStateException(format);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        throw obj13;
    }

    static kotlin.i0.z.e.m0.k.f.f k(kotlin.i0.z.e.m0.k.f f) {
        return f.b;
    }

    static Throwable l(Throwable throwable) {
        f.q(throwable);
        return throwable;
    }

    private static <K> ConcurrentMap<K, Object> m() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3, 1065353216, 2);
        return concurrentHashMap;
    }

    private static <T extends Throwable> T q(T t) {
        int i;
        int i2;
        boolean startsWith;
        String str;
        final int i3 = 0;
        if (t == 0) {
        } else {
            java.lang.StackTraceElement[] stackTrace = t.getStackTrace();
            int length = stackTrace.length;
            i = -1;
            i2 = 0;
            while (i2 < length) {
                if (!stackTrace[i2].getClassName().startsWith(f.d)) {
                    break;
                } else {
                }
                i2++;
            }
            List subList = Arrays.asList(stackTrace).subList(i, length);
            t.setStackTrace((StackTraceElement[])subList.toArray(new StackTraceElement[subList.size()]));
            if (t == 0) {
            } else {
                return t;
            }
            f.j(37);
            throw i3;
        }
        f.j(36);
        throw i3;
    }

    public <K, V> kotlin.i0.z.e.m0.k.b<K, V> a() {
        f.e eVar = new f.e(this, f.m(), 0);
        return eVar;
    }

    public <K, V> kotlin.i0.z.e.m0.k.a<K, V> b() {
        f.d dVar = new f.d(this, f.m(), 0);
        return dVar;
    }

    public <T> kotlin.i0.z.e.m0.k.i<T> c(a<? extends T> a, T t2) {
        int i = 0;
        if (a == null) {
        } else {
            if (t2 == null) {
            } else {
                f.b bVar = new f.b(this, this, a, t2);
                return bVar;
            }
            f.j(27);
            throw i;
        }
        f.j(26);
        throw i;
    }

    public <T> kotlin.i0.z.e.m0.k.i<T> d(a<? extends T> a) {
        if (a == null) {
        } else {
            f.j jVar = new f.j(this, a);
            return jVar;
        }
        f.j(23);
        throw 0;
    }

    public <T> T e(a<? extends T> a) {
        if (a == null) {
        } else {
            this.a.lock();
            this.a.unlock();
            return a.invoke();
        }
        f.j(34);
        throw 0;
    }

    public <T> kotlin.i0.z.e.m0.k.j<T> f(a<? extends T> a) {
        if (a == null) {
        } else {
            f.h hVar = new f.h(this, a);
            return hVar;
        }
        f.j(30);
        throw 0;
    }

    public <T> kotlin.i0.z.e.m0.k.i<T> g(a<? extends T> a, l<? super Boolean, ? extends T> l2, l<? super T, w> l3) {
        int i = 0;
        if (a == null) {
        } else {
            if (l3 == null) {
            } else {
                super(this, this, a, l2, l3);
                return cVar;
            }
            f.j(29);
            throw i;
        }
        f.j(28);
        throw i;
    }

    public <K, V> kotlin.i0.z.e.m0.k.g<K, V> h(l<? super K, ? extends V> l) {
        final int i = 0;
        if (l == null) {
        } else {
            kotlin.i0.z.e.m0.k.g obj3 = n(l, f.m());
            if (obj3 == null) {
            } else {
                return obj3;
            }
            f.j(10);
            throw i;
        }
        f.j(9);
        throw i;
    }

    public <K, V> kotlin.i0.z.e.m0.k.h<K, V> i(l<? super K, ? extends V> l) {
        final int i = 0;
        if (l == null) {
        } else {
            kotlin.i0.z.e.m0.k.h obj3 = o(l, f.m());
            if (obj3 == null) {
            } else {
                return obj3;
            }
            f.j(20);
            throw i;
        }
        f.j(19);
        throw i;
    }

    public <K, V> kotlin.i0.z.e.m0.k.g<K, V> n(l<? super K, ? extends V> l, ConcurrentMap<K, Object> concurrentMap2) {
        int i = 0;
        if (l == null) {
        } else {
            if (concurrentMap2 == null) {
            } else {
                f.m mVar = new f.m(this, concurrentMap2, l);
                return mVar;
            }
            f.j(15);
            throw i;
        }
        f.j(14);
        throw i;
    }

    public <K, V> kotlin.i0.z.e.m0.k.h<K, V> o(l<? super K, ? extends V> l, ConcurrentMap<K, Object> concurrentMap2) {
        int i = 0;
        if (l == null) {
        } else {
            if (concurrentMap2 == null) {
            } else {
                f.l lVar = new f.l(this, concurrentMap2, l);
                return lVar;
            }
            f.j(22);
            throw i;
        }
        f.j(21);
        throw i;
    }

    protected <K, V> kotlin.i0.z.e.m0.k.f.o<V> p(String string, K k2) {
        String str;
        String obj4;
        if (string == null) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Recursion detected ");
            stringBuilder.append(string);
            if (k2 == null) {
                obj4 = "";
            } else {
                obj4 = new StringBuilder();
                obj4.append("on input: ");
                obj4.append(k2);
                obj4 = obj4.toString();
            }
            stringBuilder.append(obj4);
            stringBuilder.append(" under ");
            stringBuilder.append(this);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            f.q(assertionError);
            throw (AssertionError)assertionError;
        }
        f.j(35);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.k.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        stringBuilder.append(" (");
        stringBuilder.append(this.c);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
