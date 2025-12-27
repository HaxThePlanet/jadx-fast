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

/* compiled from: NameResolverRegistry.java */
/* loaded from: classes2.dex */
public final class x0 {

    private static final Logger e;
    private static x0 f;
    private final v0.d a = new x0$b();
    private String b = "unknown";
    private final LinkedHashSet<w0> c = new LinkedHashSet<>();
    private x<String, w0> d;

    static class a {
    }

    private final class b extends v0.d {

        final /* synthetic */ x0 a;
        private b() {
            this.a = x0Var;
            super();
        }

        @Override // io.grpc.v0$d
        public String a() {
            synchronized (x0Var) {
                try {
                    return this.a.b;
                } catch (Throwable th) {
                }
                throw th;
            }
        }

        @Override // io.grpc.v0$d
        public v0 b(URI uri, v0.b bVar) {
            int i = 0;
            Object value = this.a.f().get(uri.getScheme());
            if (value == null) {
                i = 0;
            } else {
                io.grpc.v0 v0Var = value.b(uri, bVar);
            }
            return i;
        }

        /* synthetic */ b(x0.a aVar) {
            this(x0Var);
        }
    }

    private static final class c implements c1.b<w0> {
        private c() {
            super();
        }

        public int c(w0 w0Var) {
            return w0Var.e();
        }

        public boolean d(w0 w0Var) {
            return w0Var.d();
        }

        /* synthetic */ c(x0.a aVar) {
            this();
        }
    }
    static {
        x0.e = Logger.getLogger(x0.class.getName());
    }

    public x0() {
        super();
        io.grpc.x0.b bVar = new x0.b(this, null);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.d = x.k();
    }

    static /* synthetic */ String a(x0 x0Var) {
        return x0Var.b;
    }

    private synchronized void b(w0 w0Var) {
        n.e(w0Var.d(), "isAvailable() returned false");
        this.c.add(w0Var);
    }

    public static synchronized x0 d() {
        java.lang.ClassLoader classLoader;
        io.grpc.x0.c cVar;
        io.grpc.x0.a aVar = null;
        obj = w0.class;
        final Class<io.grpc.x0> obj3 = x0.class;
        if (x0.f == null) {
            aVar = null;
            List list = c1.e(obj, x0.e(), obj.getClassLoader(), new x0.c(aVar));
            if (list.isEmpty()) {
                x0.e.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            x0.f = new x0();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                io.grpc.x0 x0Var2 = it.next();
                StringBuilder stringBuilder = new StringBuilder();
                Object str2 = "Service loader found ";
                obj5 = str2 + x0Var2;
                x0.e.fine(obj5);
            }
            x0.f.g();
        }
        return x0.f;
    }

    static List<Class<?>> e() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.j1.d0"));
        } catch (java.lang.ClassNotFoundException classNotFound) {
            x0.e.log(Level.FINE, "Unable to find DNS NameResolver", classNotFound);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void g() {
        int i = -2147483648;
        String str;
        Object value;
        int i3;
        HashMap hashMap = new HashMap();
        i = Integer.MIN_VALUE;
        str = "unknown";
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String str2 = item.c();
            value = hashMap.get(str2);
            if (value != null) {
                if (value.e() < item.e()) {
                    hashMap.put(str2, item);
                }
            }
            if (i < item.e()) {
                i = item.e();
                str = item.c();
            }
        }
        this.d = x.d(hashMap);
        this.b = str;
    }

    public v0.d c() {
        return this.a;
    }

    synchronized Map<String, w0> f() {
        return this.d;
    }
}
