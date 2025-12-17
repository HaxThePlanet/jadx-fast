package io.grpc;

import com.google.common.base.n;
import com.google.common.collect.x;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class x0 {

    private static final Logger e;
    private static io.grpc.x0 f;
    private final io.grpc.v0.d a;
    private String b;
    private final LinkedHashSet<io.grpc.w0> c;
    private x<String, io.grpc.w0> d;

    static class a {
    }

    private final class b extends io.grpc.v0.d {

        final io.grpc.x0 a;
        private b(io.grpc.x0 x0) {
            this.a = x0;
            super();
        }

        b(io.grpc.x0 x0, io.grpc.x0.a x0$a2) {
            super(x0);
        }

        @Override // io.grpc.v0$d
        public String a() {
            final io.grpc.x0 x0Var = this.a;
            return x0.a(this.a);
            synchronized (x0Var) {
                x0Var = this.a;
                return x0.a(this.a);
            }
        }

        @Override // io.grpc.v0$d
        public io.grpc.v0 b(URI uRI, io.grpc.v0.b v0$b2) {
            int obj3;
            Object obj = this.a.f().get(uRI.getScheme());
            if ((w0)obj == null) {
                obj3 = 0;
            } else {
                obj3 = (w0)obj.b(uRI, b2);
            }
            return obj3;
        }
    }

    private static final class c implements io.grpc.c1.b<io.grpc.w0> {
        c(io.grpc.x0.a x0$a) {
            super();
        }

        @Override // io.grpc.c1$b
        public boolean a(Object object) {
            return d((w0)object);
        }

        @Override // io.grpc.c1$b
        public int b(Object object) {
            return c((w0)object);
        }

        @Override // io.grpc.c1$b
        public int c(io.grpc.w0 w0) {
            return w0.e();
        }

        @Override // io.grpc.c1$b
        public boolean d(io.grpc.w0 w0) {
            return w0.d();
        }
    }
    static {
        x0.e = Logger.getLogger(x0.class.getName());
    }

    public x0() {
        super();
        x0.b bVar = new x0.b(this, 0);
        this.a = bVar;
        this.b = "unknown";
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.c = linkedHashSet;
        this.d = x.k();
    }

    static String a(io.grpc.x0 x0) {
        return x0.b;
    }

    private void b(io.grpc.w0 w0) {
        n.e(w0.d(), "isAvailable() returned false");
        this.c.add(w0);
        return;
        synchronized (this) {
            n.e(w0.d(), "isAvailable() returned false");
            this.c.add(w0);
        }
    }

    public static io.grpc.x0 d() {
        Class<io.grpc.w0> obj;
        boolean empty;
        io.grpc.x0 x0Var;
        io.grpc.x0 next;
        Object classLoader;
        io.grpc.x0.c cVar;
        int str;
        obj = w0.class;
        final Class<io.grpc.x0> obj2 = x0.class;
        synchronized (obj2) {
            cVar = new x0.c(0);
            List list = c1.e(obj, x0.e(), obj.getClassLoader(), cVar);
            if (list.isEmpty()) {
                x0.e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            x0Var = new x0();
            x0.f = x0Var;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                x0Var = iterator.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Service loader found ");
                stringBuilder.append((w0)x0Var);
                x0.e.fine(stringBuilder.toString());
                if (x0Var.d() != null) {
                }
                x0.f.b(x0Var);
            }
            x0.f.g();
            return x0.f;
        }
    }

    static List<Class<?>> e() {
        Class forName;
        Logger logger;
        Level fINE;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Class.forName("io.grpc.j1.d0"));
        return Collections.unmodifiableList(arrayList);
    }

    private void g() {
        int i4;
        String str;
        Object next;
        int i2;
        int i;
        int i3;
        HashMap hashMap = new HashMap();
        i4 = Integer.MIN_VALUE;
        str = "unknown";
        Iterator iterator = this.c.iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    String str2 = (w0)next.c();
                    i = hashMap.get(str2);
                    if ((w0)i != null) {
                    } else {
                    }
                    hashMap.put(str2, next);
                    if (i4 < next.e()) {
                    }
                    i4 = next.e();
                    str = next.c();
                    if ((w0)i.e() < next.e()) {
                    }
                }
                next = iterator.next();
                str2 = (w0)next.c();
                i = hashMap.get(str2);
                if ((w0)i != null) {
                } else {
                }
                if ((w0)i.e() < next.e()) {
                }
                hashMap.put(str2, next);
                if (i4 < next.e()) {
                }
                i4 = next.e();
                str = next.c();
                this.d = x.d(hashMap);
                this.b = str;
                throw th;
            }
        }
    }

    public io.grpc.v0.d c() {
        return this.a;
    }

    Map<String, io.grpc.w0> f() {
        return this.d;
        synchronized (this) {
            return this.d;
        }
    }
}
