package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Metadata;
import kotlin.d0.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.p;
import kotlin.q;
import kotlin.w;
import kotlin.y.i;
import kotlin.z.a;
import kotlinx.coroutines.f0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u000cH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\u0008\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\u0082\u0008\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0008\u0008\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\u0008\u00030\u00042\u0008\u0008\u0002\u0010\u0014\u001a\u00020\tH\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\u0008\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000*(\u0008\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018", d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class i {

    private static final int a;
    private static final ReentrantReadWriteLock b;
    private static final WeakHashMap<Class<? extends Throwable>, l<Throwable, Throwable>> c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class e implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(obj2.length), Integer.valueOf(obj1.length));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¨\u0006\u0003", d2 = {"<anonymous>", "", "e", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements l<Throwable, Throwable> {

        final Constructor $constructor$inlined;
        public a(Constructor constructor) {
            this.$constructor$inlined = constructor;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Throwable a(Throwable throwable) {
            Constructor $constructor$inlined;
            Object obj5;
            try {
                kotlin.p.a aVar2 = p.a;
                Object[] arr = new Object[2];
                obj5 = this.$constructor$inlined.newInstance(throwable.getMessage(), throwable);
                if (obj5 == null) {
                } else {
                }
                p.a((Throwable)obj5);
                obj5 = new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                throw obj5;
                kotlin.p.a aVar = p.a;
                throwable = q.a(throwable);
                p.a(throwable);
                if (p.e(obj5)) {
                }
                obj5 = 0;
                return (Throwable)obj5;
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Throwable)object);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¨\u0006\u0003", d2 = {"<anonymous>", "", "e", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements l<Throwable, Throwable> {

        final Constructor $constructor$inlined;
        public b(Constructor constructor) {
            this.$constructor$inlined = constructor;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Throwable a(Throwable throwable) {
            Constructor $constructor$inlined;
            Object obj4;
            try {
                kotlin.p.a aVar2 = p.a;
                Object[] arr = new Object[1];
                obj4 = this.$constructor$inlined.newInstance(throwable);
                if (obj4 == null) {
                } else {
                }
                p.a((Throwable)obj4);
                obj4 = new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                throw obj4;
                kotlin.p.a aVar = p.a;
                throwable = q.a(throwable);
                p.a(throwable);
                if (p.e(obj4)) {
                }
                obj4 = 0;
                return (Throwable)obj4;
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Throwable)object);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¨\u0006\u0003", d2 = {"<anonymous>", "", "e", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class c extends p implements l<Throwable, Throwable> {

        final Constructor $constructor$inlined;
        public c(Constructor constructor) {
            this.$constructor$inlined = constructor;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Throwable a(Throwable throwable) {
            Object instance;
            Throwable obj5;
            try {
                kotlin.p.a aVar2 = p.a;
                Object[] arr = new Object[1];
                instance = this.$constructor$inlined.newInstance(throwable.getMessage());
                if (instance == null) {
                } else {
                }
                (Throwable)instance.initCause(throwable);
                p.a(instance);
                obj5 = new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                throw obj5;
                p.a(q.a(throwable));
                if (p.e(instance)) {
                }
                instance = 0;
                return (Throwable)instance;
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Throwable)object);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¨\u0006\u0003", d2 = {"<anonymous>", "", "e", "kotlinx/coroutines/internal/ExceptionsConstuctorKt$safeCtor$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements l<Throwable, Throwable> {

        final Constructor $constructor$inlined;
        public d(Constructor constructor) {
            this.$constructor$inlined = constructor;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Throwable a(Throwable throwable) {
            Object instance;
            Throwable obj3;
            try {
                kotlin.p.a aVar2 = p.a;
                instance = this.$constructor$inlined.newInstance(new Object[0]);
                if (instance == null) {
                } else {
                }
                (Throwable)instance.initCause(throwable);
                p.a(instance);
                obj3 = new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                throw obj3;
                p.a(q.a(throwable));
                if (p.e(instance)) {
                }
                instance = 0;
                return (Throwable)instance;
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Throwable)object);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "E", "", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements l {

        public static final kotlinx.coroutines.internal.i.f a;
        static {
            i.f fVar = new i.f();
            i.f.a = fVar;
        }

        f() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Void a(Throwable throwable) {
            return null;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Throwable)object);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "E", "", "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l {

        public static final kotlinx.coroutines.internal.i.g a;
        static {
            i.g gVar = new i.g();
            i.g.a = gVar;
        }

        g() {
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final Void a(Throwable throwable) {
            return null;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((Throwable)object);
        }
    }
    static {
        i.a = i.d(Throwable.class, -1);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        i.b = reentrantReadWriteLock;
        WeakHashMap weakHashMap = new WeakHashMap();
        i.c = weakHashMap;
    }

    private static final l<Throwable, Throwable> a(Constructor<?> constructor) {
        Class<String> obj;
        Class[] parameterTypes;
        int length;
        kotlinx.coroutines.internal.i.d dVar;
        int i3;
        int i;
        int i2;
        obj = String.class;
        parameterTypes = constructor.getParameterTypes();
        length = parameterTypes.length;
        dVar = 0;
        if (length != 0) {
            i3 = 0;
            i = 1;
            if (length != i) {
                if (length != 2) {
                } else {
                    if (n.b(parameterTypes[i3], obj) && n.b(parameterTypes[i], Throwable.class)) {
                        if (n.b(parameterTypes[i], Throwable.class)) {
                            dVar = new i.a(constructor);
                        }
                    }
                }
            } else {
                parameterTypes = parameterTypes[i3];
                if (n.b(parameterTypes, Throwable.class)) {
                    dVar = new i.b(constructor);
                } else {
                    if (n.b(parameterTypes, obj)) {
                        dVar = new i.c(constructor);
                    }
                }
            }
        } else {
            dVar = new i.d(constructor);
        }
        return dVar;
    }

    private static final int b(Class<?> class, int i2) {
        int i3;
        int i;
        int i4;
        do {
            final Field[] declaredFields = class.getDeclaredFields();
            i = i3;
            while (i3 < declaredFields.length) {
                if (static ^= 1 != 0) {
                }
                i3++;
                i++;
            }
            if (class.getSuperclass() != null) {
            }
            if (static ^= 1 != 0) {
            }
            i3++;
            i++;
        } while (/* condition */);
        return i2 += i;
    }

    static int c(Class class, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return i.b(class, obj1);
    }

    private static final int d(Class<?> class, int i2) {
        int i;
        Integer obj3;
        a.e(class);
        kotlin.p.a aVar2 = p.a;
        p.a(Integer.valueOf(i.c(class, 0, 1, 0)));
        if (p.e(obj3)) {
            try {
                obj3 = obj4;
                return (Number)obj3.intValue();
            }
        }
    }

    public static final <E extends Throwable> E e(E e) {
        kotlin.p.a aVar;
        Throwable i2;
        int i5;
        int readHoldCount2;
        int next;
        int i4;
        int i6;
        int i3;
        int readHoldCount;
        int i;
        int i7;
        Throwable obj9;
        i2 = 0;
        if (e instanceof f0) {
            aVar = p.a;
            p.a((f0)e.a());
            if (p.e(obj9)) {
            } else {
                try {
                    i2 = obj9;
                    return (Throwable)i2;
                    ReentrantReadWriteLock reentrantReadWriteLock = i.b;
                    ReentrantReadWriteLock.ReadLock lock3 = reentrantReadWriteLock.readLock();
                    lock3.lock();
                    Object obj = i.c.get(e.getClass());
                    lock3.unlock();
                    i6 = 0;
                    if (i.a != i.d(e.getClass(), i6)) {
                    }
                    ReentrantReadWriteLock.ReadLock lock4 = reentrantReadWriteLock.readLock();
                    if (reentrantReadWriteLock.getWriteHoldCount() == 0) {
                    } else {
                    }
                    readHoldCount2 = reentrantReadWriteLock.getReadHoldCount();
                    readHoldCount2 = i6;
                    i3 = i6;
                    while (i3 < readHoldCount2) {
                        lock4.unlock();
                        i3++;
                    }
                    lock4.unlock();
                    i3++;
                    ReentrantReadWriteLock.WriteLock lock = reentrantReadWriteLock.writeLock();
                    lock.lock();
                    i.c.put(e.getClass(), i.f.a);
                    obj9 = w.a;
                } catch (Throwable th) {
                }
                return (Throwable)(l)obj.invoke(e);
            }
        }
    }
}
