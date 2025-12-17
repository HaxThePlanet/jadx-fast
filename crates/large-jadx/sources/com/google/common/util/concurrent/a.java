package com.google.common.util.concurrent;

import com.google.common.base.n;
import com.google.common.base.r;
import com.google.common.base.t;
import com.google.common.util.concurrent.h.a;
import com.google.common.util.concurrent.h.b;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public abstract class a<V>  extends a implements com.google.common.util.concurrent.c<V> {

    private static final boolean v = false;
    private static final Logger w;
    private static final com.google.common.util.concurrent.a.b x;
    private static final Object y;
    private volatile Object a;
    private volatile com.google.common.util.concurrent.a.e b;
    private volatile com.google.common.util.concurrent.a.k c;

    static class a {
    }

    private static abstract class b {
        b(com.google.common.util.concurrent.a.a a$a) {
            super();
        }

        abstract boolean a(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.e a$e2, com.google.common.util.concurrent.a.e a$e3);

        abstract boolean b(com.google.common.util.concurrent.a<?> a, Object object2, Object object3);

        abstract boolean c(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.k a$k2, com.google.common.util.concurrent.a.k a$k3);

        abstract void d(com.google.common.util.concurrent.a.k a$k, com.google.common.util.concurrent.a.k a$k2);

        abstract void e(com.google.common.util.concurrent.a.k a$k, Thread thread2);
    }

    private static final class c {

        static final com.google.common.util.concurrent.a.c c = null;
        static final com.google.common.util.concurrent.a.c d = null;
        final boolean a;
        final Throwable b;
        static {
            boolean cVar;
            int i;
            final int i2 = 0;
            if (a.c()) {
            } else {
                a.c cVar2 = new a.c(0, i2);
                a.c.d = cVar2;
                cVar = new a.c(1, i2);
                a.c.c = cVar;
            }
        }

        c(boolean z, Throwable throwable2) {
            super();
            this.a = z;
            this.b = throwable2;
        }
    }

    private static final class d {

        final Throwable a;
        static {
            a.d.a aVar = new a.d.a("Failure occurred while trying to finish a future.");
            a.d dVar = new a.d(aVar);
        }

        d(Throwable throwable) {
            super();
            n.o(throwable);
            this.a = (Throwable)throwable;
        }
    }

    private static final class e {

        static final com.google.common.util.concurrent.a.e d;
        final Runnable a;
        final Executor b;
        com.google.common.util.concurrent.a.e c;
        static {
            final int i = 0;
            a.e eVar = new a.e(i, i);
            a.e.d = eVar;
        }

        e(Runnable runnable, Executor executor2) {
            super();
            this.a = runnable;
            this.b = executor2;
        }
    }

    private static final class g implements Runnable {

        final com.google.common.util.concurrent.a<V> a;
        final com.google.common.util.concurrent.c<? extends V> b;
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            if (a.d(this.a) != this) {
            }
            if (a.b().b(this.a, this, a.f(this.b))) {
                a.g(this.a);
            }
        }
    }

    private static final class k {

        static final com.google.common.util.concurrent.a.k c;
        volatile Thread a;
        volatile com.google.common.util.concurrent.a.k b;
        static {
            a.k kVar = new a.k(0);
            a.k.c = kVar;
        }

        k() {
            super();
            a.b().e(this, Thread.currentThread());
        }

        k(boolean z) {
            super();
        }

        void a(com.google.common.util.concurrent.a.k a$k) {
            a.b().d(this, k);
        }

        void b() {
            int i;
            final Thread thread = this.a;
            if (thread != null) {
                this.a = 0;
                LockSupport.unpark(thread);
            }
        }
    }

    private static final class f extends com.google.common.util.concurrent.a.b {

        final AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a.k, Thread> a;
        final AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a.k, com.google.common.util.concurrent.a.k> b;
        final AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a, com.google.common.util.concurrent.a.k> c;
        final AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a, com.google.common.util.concurrent.a.e> d;
        final AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a, Object> e;
        f(AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a.k, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a.k, com.google.common.util.concurrent.a.k> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a, com.google.common.util.concurrent.a.k> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a, com.google.common.util.concurrent.a.e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<com.google.common.util.concurrent.a, Object> atomicReferenceFieldUpdater5) {
            super(0);
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        boolean a(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.e a$e2, com.google.common.util.concurrent.a.e a$e3) {
            return this.d.compareAndSet(a, e2, e3);
        }

        boolean b(com.google.common.util.concurrent.a<?> a, Object object2, Object object3) {
            return this.e.compareAndSet(a, object2, object3);
        }

        boolean c(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.k a$k2, com.google.common.util.concurrent.a.k a$k3) {
            return this.c.compareAndSet(a, k2, k3);
        }

        @Override // com.google.common.util.concurrent.a$b
        void d(com.google.common.util.concurrent.a.k a$k, com.google.common.util.concurrent.a.k a$k2) {
            this.b.lazySet(k, k2);
        }

        @Override // com.google.common.util.concurrent.a$b
        void e(com.google.common.util.concurrent.a.k a$k, Thread thread2) {
            this.a.lazySet(k, thread2);
        }
    }

    private static final class h extends com.google.common.util.concurrent.a.b {
        private h() {
            super(0);
        }

        h(com.google.common.util.concurrent.a.a a$a) {
            super();
        }

        boolean a(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.e a$e2, com.google.common.util.concurrent.a.e a$e3) {
            synchronized (a) {
                try {
                    a.k(a, e3);
                    return 1;
                    return 0;
                    throw e2;
                }
            }
        }

        boolean b(com.google.common.util.concurrent.a<?> a, Object object2, Object object3) {
            synchronized (a) {
                try {
                    a.e(a, object3);
                    return 1;
                    return 0;
                    throw object2;
                }
            }
        }

        boolean c(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.k a$k2, com.google.common.util.concurrent.a.k a$k3) {
            synchronized (a) {
                try {
                    a.i(a, k3);
                    return 1;
                    return 0;
                    throw k2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.a$b
        void d(com.google.common.util.concurrent.a.k a$k, com.google.common.util.concurrent.a.k a$k2) {
            k.b = k2;
        }

        @Override // com.google.common.util.concurrent.a$b
        void e(com.google.common.util.concurrent.a.k a$k, Thread thread2) {
            k.a = thread2;
        }
    }

    private static final class j extends com.google.common.util.concurrent.a.b {

        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;
        static {
            Unsafe unsafe;
            Class<com.google.common.util.concurrent.a.k> obj = a.k.class;
            unsafe = Unsafe.getUnsafe();
            try {
                Class<com.google.common.util.concurrent.a> obj2 = a.class;
                a.j.c = unsafe.objectFieldOffset(obj2.getDeclaredField("c"));
                a.j.b = unsafe.objectFieldOffset(obj2.getDeclaredField("b"));
                a.j.d = unsafe.objectFieldOffset(obj2.getDeclaredField("a"));
                a.j.e = unsafe.objectFieldOffset(obj.getDeclaredField("a"));
                a.j.f = unsafe.objectFieldOffset(obj.getDeclaredField("b"));
                a.j.a = unsafe;
                t.f(cause);
                RuntimeException runtimeException = new RuntimeException(cause);
                throw runtimeException;
                Throwable cause = cause.getCause();
                runtimeException = new RuntimeException("Could not initialize intrinsics", cause);
                throw runtimeException;
            } catch (java.security.PrivilegedActionException privilegedAction) {
            }
        }

        private j() {
            super(0);
        }

        j(com.google.common.util.concurrent.a.a a$a) {
            super();
        }

        boolean a(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.e a$e2, com.google.common.util.concurrent.a.e a$e3) {
            return a.j.a.compareAndSwapObject(a, a.j.b, obj3, e2);
        }

        boolean b(com.google.common.util.concurrent.a<?> a, Object object2, Object object3) {
            return a.j.a.compareAndSwapObject(a, a.j.d, obj3, object2);
        }

        boolean c(com.google.common.util.concurrent.a<?> a, com.google.common.util.concurrent.a.k a$k2, com.google.common.util.concurrent.a.k a$k3) {
            return a.j.a.compareAndSwapObject(a, a.j.c, obj3, k2);
        }

        @Override // com.google.common.util.concurrent.a$b
        void d(com.google.common.util.concurrent.a.k a$k, com.google.common.util.concurrent.a.k a$k2) {
            a.j.a.putObject(k, a.j.f, obj2);
        }

        @Override // com.google.common.util.concurrent.a$b
        void e(com.google.common.util.concurrent.a.k a$k, Thread thread2) {
            a.j.a.putObject(k, a.j.e, obj2);
        }
    }

    static abstract class i extends com.google.common.util.concurrent.a<V> implements com.google.common.util.concurrent.c {
    }
    static {
        int i;
        com.google.common.util.concurrent.a.j str;
        com.google.common.util.concurrent.a.j sEVERE;
        String str2;
        AtomicReferenceFieldUpdater updater4;
        String updater3;
        String updater2;
        String updater;
        com.google.common.util.concurrent.a.f fVar;
        final Class<com.google.common.util.concurrent.a.k> obj = a.k.class;
        boolean boolean = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    }

    private void A(com.google.common.util.concurrent.a.k a$k) {
        int i;
        com.google.common.util.concurrent.a.k kVar;
        Object obj;
        Object obj5;
        final int i2 = 0;
        k.a = i2;
        while (this.c == a.k.c) {
            i = i2;
            while (obj5 != null) {
                kVar = obj5.b;
                obj5 = kVar;
                i.b = kVar;
                i = obj5;
            }
            kVar = obj5.b;
            obj5 = kVar;
            i.b = kVar;
            i = obj5;
        }
    }

    static com.google.common.util.concurrent.a.b b() {
        return a.x;
    }

    static boolean c() {
        return a.v;
    }

    static Object d(com.google.common.util.concurrent.a a) {
        return a.a;
    }

    static Object e(com.google.common.util.concurrent.a a, Object object2) {
        a.a = object2;
        return object2;
    }

    static Object f(com.google.common.util.concurrent.c c) {
        return a.v(c);
    }

    static void g(com.google.common.util.concurrent.a a) {
        a.s(a);
    }

    static com.google.common.util.concurrent.a.k h(com.google.common.util.concurrent.a a) {
        return a.c;
    }

    static com.google.common.util.concurrent.a.k i(com.google.common.util.concurrent.a a, com.google.common.util.concurrent.a.k a$k2) {
        a.c = k2;
        return k2;
    }

    static com.google.common.util.concurrent.a.e j(com.google.common.util.concurrent.a a) {
        return a.b;
    }

    static com.google.common.util.concurrent.a.e k(com.google.common.util.concurrent.a a, com.google.common.util.concurrent.a.e a$e2) {
        a.b = e2;
        return e2;
    }

    private void l(StringBuilder stringBuilder) {
        String str;
        Object obj;
        String str2;
        stringBuilder.append("SUCCESS, result=[");
        o(stringBuilder, a.w(this));
        stringBuilder.append("]");
    }

    private void m(StringBuilder stringBuilder) {
        Throwable string;
        String str;
        boolean length;
        boolean str2;
        StringBuilder stringBuilder2;
        stringBuilder.append("PENDING");
        Object obj = this.a;
        final String str6 = "]";
        if (obj instanceof a.g) {
            stringBuilder.append(", setFuture=[");
            p(stringBuilder, obj.b);
            stringBuilder.append(str6);
        } else {
            str = r.a(y());
            if (str != null) {
                stringBuilder.append(", info=[");
                stringBuilder.append(str);
                stringBuilder.append(str6);
            }
        }
        if (isDone()) {
            stringBuilder.delete(stringBuilder.length(), stringBuilder.length());
            l(stringBuilder);
        }
    }

    private void o(StringBuilder stringBuilder, Object object2) {
        String str;
        String obj3;
        if (object2 == null) {
            stringBuilder.append("null");
        } else {
            if (object2 == this) {
                stringBuilder.append("this future");
            } else {
                stringBuilder.append(object2.getClass().getName());
                stringBuilder.append("@");
                stringBuilder.append(Integer.toHexString(System.identityHashCode(object2)));
            }
        }
    }

    private void p(StringBuilder stringBuilder, Object object2) {
        String str;
        Object obj3;
        if (object2 == this) {
            stringBuilder.append("this future");
        } else {
            try {
                stringBuilder.append(object2);
                stringBuilder.append("Exception thrown from implementation: ");
                object2 = object2.getClass();
                stringBuilder.append(object2);
            }
        }
    }

    private static CancellationException q(String string, Throwable throwable2) {
        CancellationException cancellationException = new CancellationException(string);
        cancellationException.initCause(throwable2);
        return cancellationException;
    }

    private com.google.common.util.concurrent.a.e r(com.google.common.util.concurrent.a.e a$e) {
        com.google.common.util.concurrent.a.e eVar;
        boolean z;
        com.google.common.util.concurrent.a.e obj5;
        com.google.common.util.concurrent.a.e eVar2 = this.b;
        while (a.x.a(this, eVar2, a.e.d)) {
            eVar2 = this.b;
        }
        eVar = e;
        obj5 = eVar4;
        while (obj5 != null) {
            obj5.c = eVar;
            eVar = obj5;
            obj5 = z;
        }
        return eVar;
    }

    private static void s(com.google.common.util.concurrent.a<?> a) {
        int i;
        boolean z;
        Object obj;
        com.google.common.util.concurrent.a.b bVar;
        com.google.common.util.concurrent.a obj4;
        i = 0;
        while (/* condition */) {
            while (obj4 != null) {
                z = obj4.a;
                if (z instanceof a.g) {
                    break loop_2;
                } else {
                }
                a.t(z, obj4.b);
                obj4 = i;
                obj4 = z.a;
                if (obj4.a == (a.g)z) {
                    break loop_2;
                } else {
                }
                if (a.x.b(obj4, (a.g)z, a.v(z.b))) {
                    break loop_2;
                } else {
                }
            }
            z = obj4.a;
            if (z instanceof a.g) {
            } else {
            }
            a.t(z, obj4.b);
            obj4 = i;
            obj4 = z.a;
            if (obj4.a == (a.g)z) {
            } else {
            }
            if (a.x.b(obj4, (a.g)z, a.v(z.b))) {
            } else {
            }
            obj4.z();
            obj4.n();
            obj4 = obj4.r(i);
        }
    }

    private static void t(Runnable runnable, Executor executor2) {
        Throwable th;
        Logger logger;
        Level sEVERE;
        String str;
        String stringBuilder;
        Runnable obj5;
        Object obj6;
        try {
            executor2.execute(runnable);
            runnable = String.valueOf(runnable);
            executor2 = String.valueOf(executor2);
            str = String.valueOf(runnable);
            str = str.length();
            str += 57;
            stringBuilder = String.valueOf(executor2);
            stringBuilder = stringBuilder.length();
            str += stringBuilder;
            stringBuilder = new StringBuilder(str);
            str = "RuntimeException while executing runnable ";
            stringBuilder.append(str);
            stringBuilder.append(runnable);
            runnable = " with executor ";
            stringBuilder.append(runnable);
            stringBuilder.append(executor2);
            runnable = stringBuilder.toString();
            a.w.log(Level.SEVERE, runnable, th);
        }
    }

    private V u(Object object) {
        Object obj2;
        if (object instanceof a.c) {
        } else {
            if (object instanceof a.d) {
            } else {
                if (object == a.y) {
                    obj2 = 0;
                }
                return obj2;
            }
            ExecutionException executionException = new ExecutionException(object.a);
            throw executionException;
        }
        throw a.q("Task was cancelled.", object.b);
    }

    private static Object v(com.google.common.util.concurrent.c<?> c) {
        boolean z;
        Object obj;
        z = b.a((a)c);
        if (c instanceof a && z != null) {
            z = b.a((a)c);
            if (z != null) {
                a.d obj8 = new a.d(z);
                return obj8;
            }
        }
        boolean cancelled = c.isCancelled();
        if (i &= cancelled != 0) {
            return a.c.d;
        }
        if (cancelled) {
            String valueOf = String.valueOf(c);
            StringBuilder stringBuilder2 = new StringBuilder(length += 84);
            stringBuilder2.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
            stringBuilder2.append(valueOf);
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder2.toString());
            a.c cVar2 = new a.c(0, illegalArgumentException3);
            return cVar2;
        }
        if (a.w(c) == null) {
            obj = a.y;
        }
        return obj;
    }

    private static <V> V w(Future<V> future) {
        int currentThread;
        currentThread = 0;
        try {
            if (currentThread != 0) {
            }
            Thread.currentThread().interrupt();
            return future.get();
        }
        Thread thread = Thread.currentThread();
        thread.interrupt();
        throw future;
    }

    private void z() {
        com.google.common.util.concurrent.a.k kVar;
        while (a.x.c(this, this.c, a.k.c)) {
        }
        while (kVar != null) {
            kVar.b();
            kVar = kVar.b;
        }
    }

    protected boolean B(V v) {
        Object obj3;
        if (v == null) {
            obj3 = a.y;
        }
        if (a.x.b(this, 0, obj3)) {
            a.s(this);
            return 1;
        }
        return 0;
    }

    @Override // com.google.common.util.concurrent.h.a
    protected boolean C(Throwable throwable) {
        n.o(throwable);
        a.d dVar = new a.d((Throwable)throwable);
        if (a.x.b(this, 0, dVar)) {
            a.s(this);
            return 1;
        }
        return 0;
    }

    @Override // com.google.common.util.concurrent.h.a
    protected final Throwable a() {
        return null;
    }

    @Override // com.google.common.util.concurrent.h.a
    public boolean cancel(boolean z) {
        Object obj;
        int i3;
        boolean i2;
        int i;
        com.google.common.util.concurrent.a.c cVar;
        boolean cancellationException;
        String str;
        obj = this.a;
        i2 = 0;
        i = obj == null ? i3 : i2;
        if (i |= cancellationException != null) {
            if (a.v) {
                cancellationException = new CancellationException("Future.cancel() was called.");
                cVar = new a.c(z, cancellationException);
            } else {
                cVar = z ? a.c.c : a.c.d;
            }
            while (a.x.b(this, obj, cVar)) {
            }
            if (z) {
                x();
            }
            a.s(this);
            if (obj instanceof a.g) {
                obj.b.cancel(z);
            }
        } else {
            i3 = i2;
        }
        return i3;
    }

    public V get() {
        com.google.common.util.concurrent.a.k kVar2;
        boolean z;
        int i;
        com.google.common.util.concurrent.a.k kVar;
        int i4;
        com.google.common.util.concurrent.a.b bVar;
        int i3;
        int i2;
        if (Thread.interrupted()) {
        } else {
            Object obj = this.a;
            final int i5 = 0;
            final int i6 = 1;
            i = obj != null ? i6 : i5;
            if (i &= i4 != 0) {
                return u(obj);
            }
            if (this.c != a.k.c) {
                kVar = new a.k();
                kVar.a(kVar2);
                while (a.x.c(this, kVar2, kVar)) {
                    kVar.a(kVar2);
                }
                LockSupport.park(this);
                while (!Thread.interrupted()) {
                    z = this.a;
                    if (z) {
                    } else {
                    }
                    i3 = i5;
                    LockSupport.park(this);
                    i3 = i6;
                }
                A(kVar);
                InterruptedException interruptedException = new InterruptedException();
                throw interruptedException;
            }
            return u(this.a);
        }
        InterruptedException interruptedException2 = new InterruptedException();
        throw interruptedException2;
    }

    public V get(long l, TimeUnit timeUnit2) {
        String valueOf;
        String string;
        String concat;
        String string2;
        int stringBuilder;
        long nanos;
        int i5;
        int i4;
        int i6;
        int cmp2;
        com.google.common.util.concurrent.a.k kVar2;
        Object obj;
        int stringBuilder2;
        int i;
        int cmp;
        int i3;
        int convert;
        com.google.common.util.concurrent.a.k kVar;
        int i2;
        long nanos2;
        final Object obj2 = this;
        long l2 = l;
        stringBuilder = obj22;
        nanos = stringBuilder.toNanos(l2);
        if (Thread.interrupted()) {
        } else {
            Object obj10 = obj2.a;
            stringBuilder2 = 1;
            i = obj10 != null ? stringBuilder2 : 0;
            if (i &= i14 != 0) {
                return obj2.u(obj10);
            }
            cmp = 0;
            if (Long.compare(nanos, cmp) > 0) {
                nanoTime3 += nanos;
            } else {
                i3 = cmp;
            }
            final int i17 = 1000;
            if (Long.compare(nanos, i17) >= 0 && obj2.c != a.k.c) {
                if (obj2.c != a.k.c) {
                    kVar = new a.k();
                    kVar.a(kVar2);
                    while (a.x.c(obj2, kVar2, kVar)) {
                        kVar.a(kVar2);
                    }
                    e.a(obj2, nanos);
                    while (!Thread.interrupted()) {
                        Object obj9 = obj2.a;
                        if (obj9 != null) {
                        } else {
                        }
                        i6 = 0;
                        e.a(obj2, nanos);
                        i6 = stringBuilder2;
                    }
                    obj2.A(kVar);
                    InterruptedException interruptedException3 = new InterruptedException();
                    throw interruptedException3;
                }
                return obj2.u(obj2.a);
            }
            while (Long.compare(nanos, cmp) > 0) {
                Object obj8 = obj2.a;
                if (obj8 != null) {
                } else {
                }
                i4 = 0;
                nanos = i3 - nanoTime;
                i4 = stringBuilder2;
            }
            String string4 = toString();
            Locale rOOT = Locale.ROOT;
            String lowerCase = obj22.toString().toLowerCase(rOOT);
            String lowerCase2 = obj22.toString().toLowerCase(rOOT);
            StringBuilder stringBuilder4 = new StringBuilder(length6 += 28);
            String str5 = "Waited ";
            stringBuilder4.append(str5);
            stringBuilder4.append(l2);
            valueOf = " ";
            stringBuilder4.append(valueOf);
            stringBuilder4.append(lowerCase2);
            if (Long.compare(i15, cmp) < 0) {
                int i11 = -nanos;
                convert = stringBuilder.convert(i11, i5);
                i11 -= nanos2;
                stringBuilder = Long.compare(convert, cmp);
                if (stringBuilder != null) {
                    if (Long.compare(nanos, i17) > 0) {
                        i2 = stringBuilder2;
                    } else {
                        i2 = 0;
                    }
                } else {
                }
                String valueOf4 = String.valueOf(String.valueOf(stringBuilder4.toString()).concat(" (plus "));
                stringBuilder2 = new StringBuilder(i8 += length5);
                stringBuilder2.append(valueOf4);
                stringBuilder2.append(convert);
                stringBuilder2.append(valueOf);
                stringBuilder2.append(lowerCase);
                if (stringBuilder > 0 && i2 != 0) {
                    valueOf4 = String.valueOf(concat);
                    stringBuilder2 = new StringBuilder(i8 += length5);
                    stringBuilder2.append(valueOf4);
                    stringBuilder2.append(convert);
                    stringBuilder2.append(valueOf);
                    stringBuilder2.append(lowerCase);
                    if (i2 != 0) {
                        string = String.valueOf(stringBuilder2.toString()).concat(",");
                    }
                    concat = String.valueOf(string).concat(valueOf);
                }
                if (i2 != 0) {
                    String valueOf2 = String.valueOf(concat);
                    stringBuilder = new StringBuilder(length += 33);
                    stringBuilder.append(valueOf2);
                    stringBuilder.append(nanos);
                    stringBuilder.append(" nanoseconds ");
                    concat = stringBuilder.toString();
                }
                string2 = String.valueOf(concat).concat("delay)");
            }
            if (isDone()) {
                TimeoutException timeoutException = new TimeoutException(String.valueOf(string2).concat(" but future completed as timeout expired"));
                throw timeoutException;
            }
            StringBuilder stringBuilder3 = new StringBuilder(i9 += length4);
            stringBuilder3.append(string2);
            stringBuilder3.append(" for ");
            stringBuilder3.append(string4);
            TimeoutException timeoutException2 = new TimeoutException(stringBuilder3.toString());
            throw timeoutException2;
        }
        InterruptedException interruptedException = new InterruptedException();
        throw interruptedException;
    }

    @Override // com.google.common.util.concurrent.h.a
    public boolean isCancelled() {
        return obj instanceof a.c;
    }

    @Override // com.google.common.util.concurrent.h.a
    public boolean isDone() {
        int i;
        Object obj = this.a;
        final int i4 = 1;
        i = obj != null ? i4 : 0;
        return i2 &= i;
    }

    @Override // com.google.common.util.concurrent.h.a
    protected void n() {
    }

    @Override // com.google.common.util.concurrent.h.a
    public String toString() {
        String simpleName;
        boolean done;
        StringBuilder stringBuilder = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            stringBuilder.append(getClass().getSimpleName());
        } else {
            stringBuilder.append(getClass().getName());
        }
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append("[status=");
        if (isCancelled()) {
            stringBuilder.append("CANCELLED");
        } else {
            if (isDone()) {
                l(stringBuilder);
            } else {
                m(stringBuilder);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override // com.google.common.util.concurrent.h.a
    protected void x() {
    }

    @Override // com.google.common.util.concurrent.h.a
    protected String y() {
        if (this instanceof ScheduledFuture) {
            final TimeUnit mILLISECONDS = TimeUnit.MILLISECONDS;
            StringBuilder stringBuilder = new StringBuilder(41);
            stringBuilder.append("remaining delay=[");
            stringBuilder.append((ScheduledFuture)this.getDelay(mILLISECONDS));
            stringBuilder.append(" ms]");
            return stringBuilder.toString();
        }
        return null;
    }
}
