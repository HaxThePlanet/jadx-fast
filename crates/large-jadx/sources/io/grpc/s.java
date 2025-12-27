package io.grpc;

import java.io.Closeable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Context.java */
/* loaded from: classes2.dex */
public class s {

    static final Logger c;
    public static final s v = new s();
    final s.a a;
    final int b = 0;

    public interface b {
        void a(s sVar);
    }

    private static final class c implements Runnable {

        private final Executor a;
        final s.b b;
        private final s c;
        c(Executor executor, s.b bVar, s sVar) {
            super();
            this.a = executor;
            this.b = bVar;
            this.c = sVar;
        }

        static /* synthetic */ s a(s.c cVar) {
            return cVar.c;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.c);
        }
    }

    private static final class d {

        static final s.e a;
        static {
            AtomicReference atomicReference = new AtomicReference();
            s.d.a = s.d.a(atomicReference);
            Object obj = atomicReference.get();
            if (obj != null) {
                str = "Storage override doesn't exist. Using default";
                s.c.log(Level.FINE, str, obj);
            }
        }

        private static s.e a(AtomicReference<? super java.lang.ClassNotFoundException> atomicReference) throws java.lang.NoSuchMethodException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
            try {
                int i = 0;
            } catch (Exception e) {
                RuntimeException runtimeException = new RuntimeException("Storage override failed to initialize", e);
                throw runtimeException;
            } catch (java.lang.ClassNotFoundException classNotFound1) {
                e.set(classNotFound1);
                e = new g1();
                return e;
            }
            return (s.e)Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(s.e.class).getConstructor(new Class[i]).newInstance(new Object[i]);
        }
    }

    public static abstract class e {
        @Deprecated
        public void a(s sVar) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public s d(s sVar) {
            b();
            a(sVar);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        public abstract s b();

        public abstract void c(s sVar, s sVar2);
    }

    public static final class a extends s implements Closeable {

        private ArrayList<s.c> w;
        private s.b x;
        private void E(s.b bVar, s sVar) {
            int i;
            Object item;
            io.grpc.s.b bVar2;
            synchronized (this) {
                try {
                    i = this.w.size() - 1;
                    while (this.w >= 0) {
                        item = this.w.get(i);
                        if (item.b != bVar || s.c.a(item) != sVar) {
                            i = i - 1;
                            while (this.w >= 0) {
                                item = this.w.get(i);
                                if (item.b == bVar && s.c.a(item) == sVar) {
                                    break;
                                }
                            }
                            if (this.w.isEmpty()) {
                                io.grpc.s.b bVar3 = null;
                                if (this.a == null) {
                                    this.x = bVar3;
                                    this.w = bVar3;
                                } else {
                                    this.a.n(this.x);
                                }
                                /* Dexterity WARN: Type inference failed for thrown value */
                                throw (Throwable) bVar3;
                            }
                        } else {
                            break;
                        }
                    }
                    this.w.remove(i);
                    bVar3 = null;
                    this.x = bVar3;
                    this.w = bVar3;
                    this.a.n(this.x);
                } catch (Throwable unused) {
                }
                try {
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }

        static /* synthetic */ void r(s.a aVar, s.c cVar) {
            aVar.x(cVar);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        static /* synthetic */ void w(s.a aVar, s.b bVar, s sVar) {
            aVar.E(bVar, sVar);
        }

        private void x(s.c cVar) {
            try {
                m();
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        @Override // io.grpc.s
        public Throwable e() {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        @Override // io.grpc.s
        public u k() {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        @Override // io.grpc.s
        public boolean m() {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        @Override // io.grpc.s
        public void n(s.b bVar) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }
    static {
        s.c = Logger.getLogger(s.class.getName());
    }

    private s() {
        super();
        s.q(0);
    }

    static <T> T f(T t, Object object) {
        if (t == 0) {
            throw new NullPointerException(String.valueOf(object));
        } else {
            return t;
        }
    }

    public static s i() {
        io.grpc.s sVar;
        if (s.o().b() == null) {
            sVar = s.v;
        }
        return sVar;
    }

    static s.e o() {
        return s.d.a;
    }

    private static void q(int i) {
        int i2 = 1000;
        if (i == 1000) {
            str = "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000";
            s.c.log(Level.SEVERE, str, new Exception());
        }
    }

    public void a(s.b bVar, Executor executor) {
        s.f(bVar, "cancellationListener");
        s.f(executor, "executor");
        if (this.a != null) {
            s.a.r(this.a, new s.c(executor, bVar, this));
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    public s c() {
        io.grpc.s sVar;
        if (s.o().d(this) == null) {
            sVar = s.v;
        }
        return sVar;
    }

    public Throwable e() {
        final int i = 0;
        if (this.a != null) {
            this.a.e();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            return null;
        }
    }

    public void j(s sVar) {
        s.f(sVar, "toAttach");
        s.o().c(this, sVar);
    }

    public u k() {
        final int i = 0;
        if (this.a != null) {
            this.a.k();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            return null;
        }
    }

    public boolean m() {
        if (this.a != null) {
            this.a.m();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            return false;
        }
    }

    public void n(s.b bVar) {
        if (this.a == null) {
            return;
        }
        this.a.E(bVar, this);
    }
}
