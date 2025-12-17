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

/* loaded from: classes2.dex */
public final class q0 {

    private static final Logger c;
    private static io.grpc.q0 d;
    private static final Iterable<Class<?>> e;
    private final LinkedHashSet<io.grpc.p0> a;
    private final LinkedHashMap<String, io.grpc.p0> b;

    private static final class a implements io.grpc.c1.b<io.grpc.p0> {
        @Override // io.grpc.c1$b
        public boolean a(Object object) {
            return d((p0)object);
        }

        @Override // io.grpc.c1$b
        public int b(Object object) {
            return c((p0)object);
        }

        @Override // io.grpc.c1$b
        public int c(io.grpc.p0 p0) {
            return p0.c();
        }

        @Override // io.grpc.c1$b
        public boolean d(io.grpc.p0 p0) {
            return p0.d();
        }
    }
    static {
        q0.c = Logger.getLogger(q0.class.getName());
        q0.e = q0.c();
    }

    public q0() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = linkedHashSet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.b = linkedHashMap;
    }

    private void a(io.grpc.p0 p0) {
        n.e(p0.d(), "isAvailable() returned false");
        this.a.add(p0);
        return;
        synchronized (this) {
            n.e(p0.d(), "isAvailable() returned false");
            this.a.add(p0);
        }
    }

    public static io.grpc.q0 b() {
        Class<io.grpc.p0> obj;
        io.grpc.q0 q0Var;
        io.grpc.q0 next;
        java.lang.ClassLoader classLoader;
        io.grpc.q0.a aVar;
        String str;
        obj = p0.class;
        final Class<io.grpc.q0> obj2 = q0.class;
        synchronized (obj2) {
            aVar = new q0.a();
            q0Var = new q0();
            q0.d = q0Var;
            Iterator iterator = c1.e(obj, q0.e, obj.getClassLoader(), aVar).iterator();
            while (iterator.hasNext()) {
                q0Var = iterator.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Service loader found ");
                stringBuilder.append((p0)q0Var);
                q0.c.fine(stringBuilder.toString());
                if (q0Var.d() != null) {
                }
                q0.d.a(q0Var);
            }
            try {
                q0.d.e();
                return q0.d;
                throw th;
            }
        }
    }

    static List<Class<?>> c() {
        Class forName2;
        Class forName;
        Logger logger;
        Level fINE;
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Class.forName("io.grpc.j1.s1"));
        arrayList.add(Class.forName("io.grpc.n1.b"));
        return Collections.unmodifiableList(arrayList);
    }

    private void e() {
        Object next;
        String str;
        int i;
        int i2;
        this.b.clear();
        Iterator iterator = this.a.iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    str = (p0)next.b();
                    i = this.b.get(str);
                    if ((p0)i != null) {
                    } else {
                    }
                    this.b.put(str, next);
                    if ((p0)i.c() < next.c()) {
                    }
                }
                next = iterator.next();
                str = (p0)next.b();
                i = this.b.get(str);
                if ((p0)i != null) {
                } else {
                }
                if ((p0)i.c() < next.c()) {
                }
                this.b.put(str, next);
                throw th;
            }
        }
    }

    public io.grpc.p0 d(String string) {
        n.p(string, "policy");
        return (p0)this.b.get(string);
        synchronized (this) {
            n.p(string, "policy");
            return (p0)this.b.get(string);
        }
    }
}
