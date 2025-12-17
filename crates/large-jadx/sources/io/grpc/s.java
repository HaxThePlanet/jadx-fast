package io.grpc;

import java.io.Closeable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class s {

    static final Logger c;
    public static final io.grpc.s v;
    final io.grpc.s.a a;
    final int b = 0;

    public interface b {
        public abstract void a(io.grpc.s s);
    }

    private static final class c implements Runnable {

        private final Executor a;
        final io.grpc.s.b b;
        private final io.grpc.s c;
        c(Executor executor, io.grpc.s.b s$b2, io.grpc.s s3) {
            super();
            this.a = executor;
            this.b = b2;
            this.c = s3;
        }

        static io.grpc.s a(io.grpc.s.c s$c) {
            return c.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.c);
        }
    }

    private static final class d {

        static final io.grpc.s.e a;
        static {
            Object eVar;
            Level fINE;
            String str;
            AtomicReference atomicReference = new AtomicReference();
            s.d.a = s.d.a(atomicReference);
            Object obj = atomicReference.get();
            if ((Throwable)obj != null) {
                s.c.log(Level.FINE, "Storage override doesn't exist. Using default", (Throwable)obj);
            }
        }

        private static io.grpc.s.e a(AtomicReference<? super java.lang.ClassNotFoundException> atomicReference) {
            try {
                int i = 0;
                return (s.e)Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(s.e.class).getConstructor(new Class[i]).newInstance(new Object[i]);
                RuntimeException exc = new RuntimeException("Storage override failed to initialize", atomicReference);
                throw exc;
                atomicReference.set(exc);
                atomicReference = new g1();
                return atomicReference;
            }
        }
    }

    public static abstract class e {
        @Deprecated
        public void a(io.grpc.s s) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Deprecated. Do not call.");
            throw obj2;
        }

        public abstract io.grpc.s b();

        public abstract void c(io.grpc.s s, io.grpc.s s2);

        public io.grpc.s d(io.grpc.s s) {
            b();
            a(s);
            throw 0;
        }
    }

    public static final class a extends io.grpc.s implements Closeable {

        private ArrayList<io.grpc.s.c> w;
        private io.grpc.s.b x;
        private void E(io.grpc.s.b s$b, io.grpc.s s2) {
            ArrayList list;
            Object obj;
            io.grpc.s.b bVar;
            io.grpc.s.b obj4;
            io.grpc.s obj5;
            list = this.w;
            synchronized (this) {
                try {
                    size--;
                    while (list >= 0) {
                        obj = this.w.get(list);
                        if (obj.b == b) {
                            break;
                        } else {
                        }
                        list--;
                        if (s.c.a((s.c)obj) == s2) {
                            break;
                        } else {
                        }
                    }
                    obj = this.w.get(list);
                    if (obj.b == b) {
                    } else {
                    }
                    if (s.c.a((s.c)obj) == s2) {
                    } else {
                    }
                    this.w.remove(list);
                    list--;
                    if (this.w.isEmpty()) {
                    }
                    obj4 = this.a;
                    obj5 = 0;
                    if (obj4 != null) {
                    } else {
                    }
                    this.x = obj5;
                    this.w = obj5;
                    obj4.n(this.x);
                    throw obj5;
                    throw b;
                }
            }
        }

        static void r(io.grpc.s.a s$a, io.grpc.s.c s$c2) {
            a.x(c2);
            throw 0;
        }

        static void w(io.grpc.s.a s$a, io.grpc.s.b s$b2, io.grpc.s s3) {
            a.E(b2, s3);
        }

        private void x(io.grpc.s.c s$c) {
            m();
            throw 0;
        }

        @Override // io.grpc.s
        public Throwable e() {
            throw 0;
        }

        @Override // io.grpc.s
        public io.grpc.u k() {
            throw 0;
        }

        @Override // io.grpc.s
        public boolean m() {
            throw 0;
        }

        @Override // io.grpc.s
        public void n(io.grpc.s.b s$b) {
            throw 0;
        }
    }
    static {
        s.c = Logger.getLogger(s.class.getName());
        s sVar = new s();
        s.v = sVar;
    }

    private s() {
        super();
        s.q(0);
    }

    static <T> T f(T t, Object object2) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException obj0 = new NullPointerException(String.valueOf(object2));
        throw obj0;
    }

    public static io.grpc.s i() {
        io.grpc.s sVar;
        if (s.o().b() == null) {
            sVar = s.v;
        }
        return sVar;
    }

    static io.grpc.s.e o() {
        return s.d.a;
    }

    private static void q(int i) {
        int sEVERE;
        Exception exception;
        String str;
        int obj3;
        if (i == 1000) {
            exception = new Exception();
            s.c.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", exception);
        }
    }

    public void a(io.grpc.s.b s$b, Executor executor2) {
        s.f(b, "cancellationListener");
        s.f(executor2, "executor");
        io.grpc.s.a aVar = this.a;
        if (aVar != null) {
        } else {
        }
        s.c cVar = new s.c(executor2, b, this);
        s.a.r(aVar, cVar);
        throw 0;
    }

    public io.grpc.s c() {
        io.grpc.s sVar;
        if (s.o().d(this) == null) {
            sVar = s.v;
        }
        return sVar;
    }

    public Throwable e() {
        final io.grpc.s.a aVar = this.a;
        final int i = 0;
        if (aVar != null) {
        } else {
            return i;
        }
        aVar.e();
        throw i;
    }

    public void j(io.grpc.s s) {
        s.f(s, "toAttach");
        s.o().c(this, s);
    }

    public io.grpc.u k() {
        final io.grpc.s.a aVar = this.a;
        final int i = 0;
        if (aVar != null) {
        } else {
            return i;
        }
        aVar.k();
        throw i;
    }

    public boolean m() {
        io.grpc.s.a aVar = this.a;
        if (aVar != null) {
        } else {
            return 0;
        }
        aVar.m();
        throw 0;
    }

    public void n(io.grpc.s.b s$b) {
        final io.grpc.s.a aVar = this.a;
        if (aVar == null) {
        }
        s.a.w(aVar, b, this);
    }
}
