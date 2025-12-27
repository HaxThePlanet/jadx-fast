package io.grpc;

import com.google.common.base.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: LoadBalancerRegistry.java */
/* loaded from: classes2.dex */
public final class q0 {

    private static final Logger c;
    private static q0 d;
    private static final Iterable<Class<?>> e;
    private final LinkedHashSet<p0> a = new LinkedHashSet<>();
    private final LinkedHashMap<String, p0> b = new LinkedHashMap<>();

    private static final class a implements c1.b<p0> {
        a() {
            super();
        }

        public int c(p0 p0Var) {
            return p0Var.c();
        }

        public boolean d(p0 p0Var) {
            return p0Var.d();
        }
    }
    static {
        q0.c = Logger.getLogger(q0.class.getName());
        q0.e = q0.c();
    }

    public q0() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
    }

    private synchronized void a(p0 p0Var) {
        n.e(p0Var.d(), "isAvailable() returned false");
        this.a.add(p0Var);
    }

    public static synchronized q0 b() {
        java.lang.ClassLoader classLoader;
        io.grpc.q0.a aVar;
        String str;
        obj = p0.class;
        final Class<io.grpc.q0> obj3 = q0.class;
        if (q0.d == null) {
            q0.d = new q0();
            Iterator it = c1.e(obj, q0.e, obj.getClassLoader(), new q0.a()).iterator();
            while (it.hasNext()) {
                io.grpc.q0 q0Var2 = it.next();
                StringBuilder stringBuilder = new StringBuilder();
                str = "Service loader found ";
                obj5 = str + q0Var2;
                q0.c.fine(obj5);
            }
            q0.d.e();
        }
        return q0.d;
    }

    static List<Class<?>> c() {
        Logger obj2;
        Level obj4;
        String obj6;
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.j1.s1"));
        } catch (java.lang.ClassNotFoundException classNotFound) {
            Logger logger = q0.c;
            Level fINE2 = Level.FINE;
            String str3 = "Unable to find round-robin LoadBalancer";
            logger.log(fINE2, str3, classNotFound);
        }
        try {
            arrayList.add(Class.forName("io.grpc.n1.b"));
        } catch (java.lang.ClassNotFoundException classNotFound) {
            logger = q0.c;
            fINE2 = Level.FINE;
            str3 = "Unable to find round-robin LoadBalancer";
            logger.log(fINE2, str3, classNotFound);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private synchronized void e() {
        int i;
        this.b.clear();
        Iterator it = this.a.iterator();
        Object item = it.next();
        String str = item.b();
        Object value = this.b.get(str);
        this.b.put(str, item);
    }

    public synchronized p0 d(String str) {
        n.p(str, "policy");
        return (p0)this.b.get(str);
    }
}
