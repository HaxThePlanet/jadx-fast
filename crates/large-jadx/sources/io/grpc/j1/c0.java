package io.grpc.j1;

import com.google.common.base.VerifyException;
import com.google.common.base.n;
import com.google.common.base.q;
import com.google.common.base.t;
import com.google.common.base.v;
import io.grpc.a;
import io.grpc.a1;
import io.grpc.d1;
import io.grpc.f1;
import io.grpc.v0;
import io.grpc.v0.b;
import io.grpc.v0.c;
import io.grpc.v0.e;
import io.grpc.v0.g;
import io.grpc.v0.g.a;
import io.grpc.v0.h;
import io.grpc.y;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: DnsNameResolver.java */
/* loaded from: classes3.dex */
public class c0 extends v0 {

    private static final c0.g A;
    private static String B;
    private static final Logger s;
    private static final Set<String> t;
    private static final String u;
    private static final String v;
    private static final String w;
    static boolean x;
    static boolean y;
    protected static boolean z;
    final a1 a;
    private final Random b = new Random();
    protected volatile c0.b c;
    private final AtomicReference<c0.f> d = new AtomicReference<>();
    private final String e;
    private final String f;
    private final int g;
    private final f2.d<Executor> h;
    private final long i;
    private final f1 j;
    private final q k;
    protected boolean l;
    private boolean m;
    private Executor n;
    private final boolean o = false;
    private final v0.h p;
    private boolean q;
    private v0.e r;

    static class a {
    }

    public interface b {
        List<InetAddress> resolveAddress(String str);
    }

    protected static final class c {

        private d1 a;
        private List<y> b;
        private v0.c c;
        public a d;
        /* synthetic */ c(c0.a aVar) {
            this();
        }

        static /* synthetic */ List a(c0.c cVar) {
            return cVar.b;
        }

        static /* synthetic */ List b(c0.c cVar, List list) {
            cVar.b = list;
            return list;
        }

        static /* synthetic */ d1 c(c0.c cVar) {
            return cVar.a;
        }

        static /* synthetic */ d1 d(c0.c cVar, d1 d1Var) {
            cVar.a = d1Var;
            return d1Var;
        }

        static /* synthetic */ v0.c e(c0.c cVar) {
            return cVar.c;
        }

        static /* synthetic */ v0.c f(c0.c cVar, v0.c cVar2) {
            cVar.c = cVar2;
            return cVar2;
        }

        private c() {
            super();
        }
    }

    private final class e implements Runnable {

        private final v0.e a;
        final /* synthetic */ c0 b;
        e(v0.e eVar) {
            this.b = c0Var;
            super();
            n.p(eVar, "savedListener");
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            io.grpc.j1.c0.c cVar = null;
            f1 f1Var;
            io.grpc.j1.c0.e.a aVar;
            boolean z2;
            boolean z = true;
            Logger logger;
            String str3;
            Level fINER2 = Level.FINER;
            if (c0.s.isLoggable(fINER2)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Attempting DNS resolution of ";
                String str2 = this.b.f;
                str = str4 + str2;
                c0.s.finer(str);
            }
            int i = 0;
            int i2 = 1;
            z = false;
            try {
                y yVar = this.b.n();
                final v0.g.a aVar6 = v0.g.d();
                if (c0.s.isLoggable(Level.FINER)) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    str3 = "Using proxy address ";
                    str5 = str3 + yVar;
                    c0.s.finer(str5);
                }
                aVar6.b(Collections.singletonList(yVar));
                cVar = this.b.o(z);
                this.a.a(cVar.a);
            } catch (Throwable th) {
            }
            this.a.c(aVar6.a());
            if (c0.s == null || c0.c.c(c0.s) != null) {
            }
            f1Var = this.b.j;
            aVar = new c0.e.a(this, z);
            f1Var.execute(aVar);
        }
    }

    public interface f {
        List<String> a(String str);
    }

    interface g {
        c0.f a();

        Throwable b();
    }

    private enum d implements c0.b {

        INSTANCE;
        @Override // java.lang.Enum
        public List<InetAddress> resolveAddress(String str) throws UnknownHostException {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(str)));
        }
    }
    static {
        Class<io.grpc.j1.c0> obj = c0.class;
        c0.s = Logger.getLogger(obj.getName());
        c0.t = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[] { "clientLanguage", "percentage", "clientHostname", "serviceConfig" })));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        c0.u = property;
        String str6 = "false";
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", str6);
        c0.v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", str6);
        c0.w = property3;
        c0.x = Boolean.parseBoolean(property);
        c0.y = Boolean.parseBoolean(property2);
        c0.z = Boolean.parseBoolean(property3);
        c0.A = c0.v(obj.getClassLoader());
    }

    protected c0(String str, String str2, v0.b bVar, f2.d<Executor> dVar, q qVar, boolean z) {
        super();
        Random random = new Random();
        this.c = c0.d.INSTANCE;
        AtomicReference atomicReference = new AtomicReference();
        n.p(bVar, "args");
        this.h = dVar;
        StringBuilder stringBuilder = new StringBuilder();
        String str10 = "//";
        n.p(str2, "name");
        String bVar32 = str2;
        str5 = str10 + bVar32;
        URI uri = URI.create(str5);
        dVar = uri.getHost() != null ? 1 : 0;
        n.k((uri.getHost() != null ? 1 : 0), "Invalid DNS name: %s", str2);
        String authority = uri.getAuthority();
        n.q(authority, (uri.getHost() != null ? 1 : 0), uri);
        this.e = authority;
        this.f = uri.getHost();
        if (uri.getPort() == -1) {
            this.g = bVar.a();
        } else {
            this.g = uri.getPort();
        }
        a1 a1Var = bVar.c();
        n.p(a1Var, "proxyDetector");
        this.a = a1Var;
        this.i = c0.s(z);
        n.p(qVar, "stopwatch");
        this.k = qVar;
        f1 f1Var = bVar.e();
        n.p(f1Var, "syncContext");
        this.j = f1Var;
        Executor executor = bVar.b();
        this.n = executor;
        v0.h hVar = bVar.d();
        n.p(hVar, "serviceConfigParser");
        this.p = hVar;
    }

    private List<y> A() {
        Logger logger;
        Level fINE2;
        String str2;
        try {
            List resolveAddress = this.c.resolveAddress(this.f);
        } catch (Throwable th) {
        }
        ArrayList arrayList = new ArrayList(resolveAddress.size());
        Iterator it = resolveAddress.iterator();
        while (it.hasNext()) {
            arrayList.add(new y(new InetSocketAddress((InetAddress)it.next(), this.g)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private v0.c B() {
        List emptyList;
        String str2;
        String str3;
        emptyList = Collections.emptyList();
        io.grpc.j1.c0.f fVar = u();
        if (fVar != null) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String str5 = "_grpc_config.";
                str = str5 + this.f;
                emptyList = fVar.a(str);
            } catch (Exception e) {
                c0.s.log(Level.FINE, "ServiceConfig resolution failure", e);
            }
        }
        if (!emptyList.isEmpty()) {
            v0.c cVar = c0.x(emptyList, this.b, c0.r());
            if (cVar != null && cVar.d() != null) {
                return v0.c.b(cVar.d());
            }
        } else {
            Object[] arr = new Object[1];
            str2 = "No TXT records found for {0}";
            c0.s.log(Level.FINE, str2, new Object[] { this.f });
        }
        return null;
    }

    protected static boolean C(boolean z, boolean z2, String str) {
        int z3;
        char charAt;
        char c = 46;
        z3 = 0;
        if (!z) {
            return false;
        }
        if ("localhost".equalsIgnoreCase(str)) {
            return z2;
        }
        if (str.contains(":")) {
            return false;
        }
        z3 = 1;
        while (z3 < str.length()) {
            charAt = str.charAt(z3);
            c = '.';
            z3 = z3 + 1;
        }
        return z3 ^ z3;
    }

    static /* synthetic */ f1 f(c0 c0Var) {
        return c0Var.j;
    }

    static /* synthetic */ Logger g() {
        return c0.s;
    }

    static /* synthetic */ String h(c0 c0Var) {
        return c0Var.f;
    }

    static /* synthetic */ y i(c0 c0Var) {
        return c0Var.n();
    }

    static /* synthetic */ long j(c0 c0Var) {
        return c0Var.i;
    }

    static /* synthetic */ q k(c0 c0Var) {
        return c0Var.k;
    }

    static /* synthetic */ boolean l(c0 c0Var, boolean z) {
        c0Var.q = z;
        return z;
    }

    private boolean m() {
        boolean z2 = true;
        TimeUnit nANOSECONDS2;
        long l = 0;
        int cmp2;
        if (this.l) {
            l = 0L;
            if (this.i != l) {
                if (this.i > l) {
                    long l3 = this.k.d(TimeUnit.NANOSECONDS);
                    if (l3 > this.i) {
                        int i = 1;
                    } else {
                        int i2 = 0;
                    }
                }
            }
        }
        return z2;
    }

    private y n() {
        io.grpc.z0 z0Var = this.a.a(InetSocketAddress.createUnresolved(this.f, this.g));
        if (z0Var != null) {
            return new y(z0Var);
        }
        return null;
    }

    private static final List<String> p(Map<String, ?> map) {
        return b1.g(map, "clientLanguage");
    }

    private static final List<String> q(Map<String, ?> map) {
        return b1.g(map, "clientHostname");
    }

    private static String r() {
        if (c0.B == null) {
            try {
                c0.B = InetAddress.getLocalHost().getHostName();
            } catch (java.net.UnknownHostException unknownHost) {
                throw new RuntimeException(unknownHost);
            }
        }
        return c0.B;
    }

    private static long s(boolean z) {
        int i = 30;
        final long l = 0L;
        if (z != null) {
            return l;
        }
        str = "networkaddress.cache.ttl";
        String property = System.getProperty(str);
        i = 30;
        if (property != null) {
            try {
                long parsed = Long.parseLong(property);
            } catch (java.lang.NumberFormatException unused) {
                int arr = 3;
                arr = new Object[arr];
                arr[0] = z;
                z = 1;
                arr[z] = num;
                z = 2;
                Object num = Long.valueOf(obj);
                arr[z] = num;
                z = "Property({0}) valid is not valid number format({1}), fall back to default({2})";
                c0.s.log(Level.WARNING, z, arr);
            }
        }
        if (i > l) {
            long nanos = TimeUnit.SECONDS.toNanos(i);
        }
        return i;
    }

    private static final Double t(Map<String, ?> map) {
        return b1.h(map, "percentage");
    }

    static c0.g v(java.lang.ClassLoader classLoader) throws java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.reflect.InvocationTargetException, java.lang.InstantiationException {
        try {
        } catch (Exception e) {
            Logger logger = c0.s;
            Level fINE2 = Level.FINE;
            String str2 = "Can't find JndiResourceResolverFactory ctor, skipping.";
            logger.log(fINE2, str2, e);
            return obj;
        }
        int i2 = 0;
        try {
        } catch (Exception e) {
            logger = c0.s;
            fINE2 = Level.FINE;
            str2 = "Can't find JndiResourceResolverFactory ctor, skipping.";
            logger.log(fINE2, str2, e);
            return obj;
        }
        try {
            Object constructor2 = Class.forName("io.grpc.j1.z0", true, classLoader).asSubclass(c0.g.class).getConstructor(new Class[i2]).newInstance(new Object[i2]);
        } catch (Exception e) {
            logger = c0.s;
            fINE2 = Level.FINE;
            str2 = "Can't construct JndiResourceResolverFactory, skipping.";
            logger.log(fINE2, str2, e);
            return obj;
        }
        if (constructor2.b() != null) {
            c0.s.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", constructor2.b());
            return null;
        }
        return constructor2;
    }

    static Map<String, ?> w(Map<String, ?> map, Random random, String str) throws VerifyException {
        boolean hasNext;
        int i;
        boolean equalsIgnoreCase;
        String str2;
        boolean z;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            str = "Bad key: %s";
            v.a(c0.t.contains(item.getKey()), str, item);
        }
        List list = c0.p(map);
        int i3 = 0;
        i = 1;
        i = 0;
        if (list != null && !list.isEmpty()) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                str2 = "java";
                if (str2.equalsIgnoreCase((String)it2.next())) {
                    break;
                }
            }
            if (i == 0) {
                return null;
            }
        }
        Double d = c0.t(map);
        if (d != null) {
            int value = d.intValue();
            int i4 = 100;
            int r6 = i;
            str4 = "Bad percentage: %s";
            v.a(i, "Bad percentage: %s", d);
            if (random.nextInt(i4) >= value) {
                return i3;
            }
        }
        List list2 = c0.q(map);
        if (list2 != null && !list2.isEmpty()) {
            Iterator it3 = list2.iterator();
            while (it3.hasNext()) {
                if ((String)it3.next().equals(str)) {
                    break;
                }
            }
            if (i == 0) {
                return i3;
            }
        }
        String str6 = "serviceConfig";
        Map map2 = b1.j(map, str6);
        if (map2 == null) {
            Object[] arr = new Object[2];
            throw new VerifyException(String.format("key '%s' missing in '%s'", new Object[] { map, str6 }));
        } else {
            return map2;
        }
    }

    static v0.c x(List<String> list, Random random, String str) {
        int i;
        Map map;
        try {
        } catch (RuntimeException e) {
            random = d1.h;
            str = "failed to pick service config choice";
            random = random.r(str);
            e = random.q(e);
            e = v0.c.b(e);
            return e;
        }
        Iterator it = c0.y(list).iterator();
        i = 0;
        while (it.hasNext()) {
            try {
            } catch (RuntimeException e) {
                random = d1.h;
                str = "failed to pick service config choice";
                random = random.r(str);
                e = random.q(e);
                e = v0.c.b(e);
                return e;
            }
            if (c0.w((Map)it.next(), random, str) != null) {
                break;
            }
        }
        if (map == null) {
            return i;
        }
        return v0.c.a(map);
    }

    static List<Map<String, ?>> y(List<String> list) {
        Level fINE2;
        Object[] arr;
        int i = 0;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    private void z() {
    }

    @Override // io.grpc.v0
    public String a() {
        return this.e;
    }

    @Override // io.grpc.v0
    public void b() {
        boolean z = true;
        int r0 = this.r != null ? 1 : 0;
        n.v((this.r != null ? 1 : 0), "not started");
        z();
    }

    @Override // io.grpc.v0
    public void c() {
        if (this.m) {
            return;
        }
        this.m = true;
        if (this.n != null && this.o) {
            this.n = (Executor)f2.f(this.h, this.n);
        }
    }

    @Override // io.grpc.v0
    public void d(v0.e eVar) {
        boolean z2 = true;
        int r0 = this.r == null ? 1 : 0;
        n.v((this.r == null ? 1 : 0), "already started");
        if (this.o) {
            this.n = (Executor)f2.d(this.h);
        }
        n.p(eVar, "listener");
        this.r = eVar;
        z();
    }

    @Override // io.grpc.v0
    protected c0.c o(boolean z) {
        final io.grpc.j1.c0.c cVar2 = new c0.c(null);
        try {
            cVar2.b = A();
        } catch (Exception e) {
        }
        if (c0.z) {
            cVar2.c = B();
        }
        return cVar2;
    }

    @Override // io.grpc.v0
    protected c0.f u() {
        Object obj;
        if (!c0.C(c0.x, c0.y, this.f)) {
            return null;
        }
        if ((c0.f)this.d.get() == null && c0.A != null) {
            io.grpc.j1.c0.f fVar = c0.A.a();
        }
        return obj;
    }
}
